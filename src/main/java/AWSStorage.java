import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.Paths;
import javax.servlet.http.Part;

public class AWSStorage {

    private AmazonS3 s3;

    public AWSStorage() {

        /*
         * The ProfileCredentialsProvider will return your [default]
         * credential profile by reading from the credentials file located at
         * (~/.aws/credentials).
         */

        AWSCredentials credentials = null;
        try {
            credentials = new ProfileCredentialsProvider().getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                            "Please make sure that your credentials file is at the correct " +
                            "location (~/.aws/credentials), and is in valid format.",
                    e);
        }
        s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2)
                .build();

        System.out.println("===========================================");
        System.out.println("Getting Started with Amazon S3");
        System.out.println("===========================================\n");
    }

    public boolean createFolder(String folderName) {
        /*
        * Create a new S3 bucket - Amazon S3 bucket names are globally unique,
        * so once a bucket name has been taken by any user, you can't create
        * another bucket with that same name.
        *
        * You can optionally specify a location for your bucket if you want to
        * keep your data closer to your applications or users.
        */
        String bucketName = folderName; //+ "_"+ UUID.randomUUID();

        if(s3.doesBucketExistV2(bucketName)) {
            System.out.println("Bucket name is not available."
                    + " Try again with a different Bucket name.");
            return false;
        }
        try
        {

            System.out.println("Creating bucket " + bucketName + "\n");
            s3.createBucket(bucketName);
        } catch (AmazonServiceException ase) {
            logServiceException(ase);
        } catch (AmazonClientException ace) {
            logClientException(ace);
        }
        return true;
    }
    public void uploadImage(String folderName, Part filePart) {

        /*
         * Upload an object to your bucket - You can easily upload a file to
         * S3, or upload directly an InputStream if you know the length of
         * the data in the stream. You can also specify your own metadata
         * when uploading to S3, which allows you set a variety of options
         * like content-type and content-encoding, plus additional metadata
         * specific to your applications.
         */

        try
        {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            InputStream fileContent = filePart.getInputStream();
            File image = File.createTempFile(fileName, ".jpg");
            image.deleteOnExit();
            FileOutputStream out = new FileOutputStream(image);
            IOUtils.copy(fileContent, out);

            System.out.println("Uploading a new object to S3 from a file\n");
            s3.putObject(new PutObjectRequest( folderName, fileName, image));
            //make file public to be able to display it after upload
            s3.setObjectAcl(folderName, fileName, CannedAccessControlList.PublicRead);

        } catch (AmazonServiceException ase) {
            logServiceException(ase);
        } catch (AmazonClientException ace) {
            logClientException(ace);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void downloadImage(String folderName, String imageName){
        /*
         * Download an object - When you download an object, you get all of
         * the object's metadata and a stream from which to read the contents.
         * It's important to read the contents of the stream as quickly as
         * possibly since the data is streamed directly from Amazon S3 and your
         * network connection will remain open until you read all the data or
         * close the input stream.
         *
         * GetObjectRequest also supports several other options, including
         * conditional downloading of objects based on modification times,
         * ETags, and selectively downloading a range of an object.
         */
        try{
            System.out.println("Downloading an object");
            S3Object object = s3.getObject(new GetObjectRequest(folderName, imageName));
            System.out.println("Content-Type: "  + object.getObjectMetadata().getContentType());
            //displayTextInputStream(object.getObjectContent());
        } catch (AmazonServiceException ase) {
            logServiceException(ase);
        } catch (AmazonClientException ace) {
            logClientException(ace);
        }
    }
    public void listImagesInFolder(String folderName){
        /*
         * List objects in your bucket by prefix - There are many options for
         * listing the objects in your bucket.  Keep in mind that buckets with
         * many objects might truncate their results when listing their objects,
         * so be sure to check if the returned object listing is truncated, and
         * use the AmazonS3.listNextBatchOfObjects(...) operation to retrieve
         * additional results.
         */
        try{
            System.out.println("Listing objects");
            ObjectListing objectListing = s3.listObjects(new ListObjectsRequest()
                    .withBucketName(folderName)
                    .withPrefix("My"));
            for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
                System.out.println(" - " + objectSummary.getKey() + "  " +
                        "(size = " + objectSummary.getSize() + ")");
            }
        } catch (AmazonServiceException ase) {
            logServiceException(ase);
        } catch (AmazonClientException ace) {
            logClientException(ace);
        }
    }
    public void deleteImage(String folderName, String imageName){
        /*
         * Delete an object - Unless versioning has been turned on for your bucket,
         * there is no way to undelete an object, so use caution when deleting objects.
         */
        try
        {
            System.out.println("Deleting an object\n");
            s3.deleteObject(folderName, imageName);
        } catch (AmazonServiceException ase) {
            logServiceException(ase);
        } catch (AmazonClientException ace) {
            logClientException(ace);
        }
    }
    public void deleteFolder(String folderName){
        /*
         * Delete a bucket - A bucket must be completely empty before it can be
         * deleted, so remember to delete any objects from your buckets before
         * you try to delete them.
         */
        try
        {
            System.out.println("Deleting bucket " + folderName + "\n");
            s3.deleteBucket(folderName);
        } catch (AmazonServiceException ase) {
            logServiceException(ase);
        } catch (AmazonClientException ace) {
            logClientException(ace);
        }
    }
    private void logClientException(AmazonClientException ace) {
        System.out.println("Caught an AmazonClientException, which means the client encountered "
                + "a serious internal problem while trying to communicate with S3, "
                + "such as not being able to access the network.");
        System.out.println("Error Message: " + ace.getMessage());
    }
    private void logServiceException(AmazonServiceException ase) {
        System.out.println("Caught an AmazonServiceException, which means your request made it "
                + "to Amazon S3, but was rejected with an error response for some reason.");
        System.out.println("Error Message:    " + ase.getMessage());
        System.out.println("HTTP Status Code: " + ase.getStatusCode());
        System.out.println("AWS Error Code:   " + ase.getErrorCode());
        System.out.println("Error Type:       " + ase.getErrorType());
        System.out.println("Request ID:       " + ase.getRequestId());
    }
}
