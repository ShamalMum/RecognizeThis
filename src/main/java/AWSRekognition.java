import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class AWSRekognition {
    private AmazonRekognition rekognitionClient;
    public AWSRekognition() {
        AWSCredentials credentials;
        try {
            credentials = new ProfileCredentialsProvider("default").getCredentials();
        } catch(Exception e) {
            throw new AmazonClientException("Cannot load the credentials from the credential profiles file. "
                    + "Please make sure that your credentials file is at the correct "
                    + "location (/Users/userid/.aws/credentials), and is in a valid format.", e);
        }
        rekognitionClient = AmazonRekognitionClientBuilder
                .standard()
                .withRegion(Regions.US_EAST_2)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }
    public List<Label> detectObjectsInImage(String folderName, String imageName){
        DetectLabelsRequest request = new DetectLabelsRequest()
                .withImage(new Image()
                        .withS3Object(new S3Object()
                                .withName(imageName).withBucket(folderName)))
                .withMaxLabels(10)
                .withMinConfidence(75F);

        List <Label> labels = new ArrayList<>();
        try {
            DetectLabelsResult result = rekognitionClient.detectLabels(request);
            labels = result.getLabels();
            System.out.println("Detected labels for " + imageName);
            for (Label label: labels) {
                System.out.println(label.getName() + ": " + label.getConfidence().toString());
            }

        } catch(AmazonRekognitionException e) {
            e.printStackTrace();
        }
        return labels;
    }
    public List<Celebrity> detectCelebrityInfo(String folderName, String imageName){

        RecognizeCelebritiesRequest request = new RecognizeCelebritiesRequest()
                .withImage(new Image()
                        .withS3Object(new S3Object()
                                .withName(imageName).withBucket(folderName)));

        System.out.println("Looking for celebrities in image " + imageName + "\n");

        RecognizeCelebritiesResult result=rekognitionClient.recognizeCelebrities(request);

        //Display recognized celebrity information
        List<Celebrity> celebs=result.getCelebrityFaces();
        System.out.println(celebs.size() + " celebrity(s) were recognized.\n");
        for (Celebrity celebrity: celebs) {
            System.out.println("Celebrity recognized: " + celebrity.getName());
            System.out.println("Celebrity ID: " + celebrity.getId());
            BoundingBox boundingBox=celebrity.getFace().getBoundingBox();
            System.out.println("position: " +
                    boundingBox.getLeft().toString() + " " +
                    boundingBox.getTop().toString());
            System.out.println("Further information (if available):");
            for (String url: celebrity.getUrls()){
                System.out.println(url);
            }
            System.out.println();
        }
        System.out.println(result.getUnrecognizedFaces().size() + " face(s) were unrecognized.");
        return celebs;
    }
    public List<TextDetection>  detectTextInImage (String folderName, String imageName){
        DetectTextRequest request = new DetectTextRequest()
                .withImage(new Image()
                        .withS3Object(new S3Object()
                                .withName(imageName)
                                .withBucket(folderName)));
        List<TextDetection> textDetections = new ArrayList<>();
        try {
            DetectTextResult result = rekognitionClient.detectText(request);
            textDetections = result.getTextDetections();

            System.out.println("Detected lines and words for " + imageName);
            for (TextDetection text: textDetections) {

                System.out.println("Detected: " + text.getDetectedText());
                System.out.println("Confidence: " + text.getConfidence().toString());
                System.out.println("Id : " + text.getId());
                System.out.println("Parent Id: " + text.getParentId());
                System.out.println("Type: " + text.getType());
                System.out.println();
            }
        } catch(AmazonRekognitionException e) {
            e.printStackTrace();
        }
        return textDetections;
    }
    public List<FaceDetail> detectFacesInImage(String folderName, String imageName){
        DetectFacesRequest request = new DetectFacesRequest()
                .withImage(new Image()
                        .withS3Object(new S3Object()
                                .withName(imageName)
                                .withBucket(folderName)))
                .withAttributes(Attribute.ALL);
        List <FaceDetail> faceDetails = new ArrayList<>();
        try {
            DetectFacesResult result = rekognitionClient.detectFaces(request);
            faceDetails = result.getFaceDetails();

            for (FaceDetail face: faceDetails) {
                if (request.getAttributes().contains("ALL")) {
                    AgeRange ageRange = face.getAgeRange();
                    System.out.println("The detected face is estimated to be between "
                            + ageRange.getLow().toString() + " and " + ageRange.getHigh().toString()
                            + " years old.");
                    System.out.println("Here's the complete set of attributes:");
                } else { // non-default attributes have null values.
                    System.out.println("Here's the default set of attributes:");
                }

                ObjectMapper objectMapper = new ObjectMapper();
                System.out.println(objectMapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(face));
            }

        } catch (AmazonRekognitionException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return faceDetails;
    }
}
