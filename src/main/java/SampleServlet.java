import com.amazonaws.services.rekognition.model.Celebrity;
import com.amazonaws.services.rekognition.model.FaceDetail;
import com.amazonaws.services.rekognition.model.Label;
import com.amazonaws.services.rekognition.model.TextDetection;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;


@WebServlet("/upload")
@MultipartConfig
public class SampleServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // Code to create a folder "S3 Bucket"
        String folderName = "xtremeind-wap-project";
        AWSStorage f = new AWSStorage();
        f.createFolder(folderName);


        // Code to create a file uploaded by user and upload it AWS S3

        Part filePart = req.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();
        File image = File.createTempFile(fileName, ".jpg");
        image.deleteOnExit();
        FileOutputStream out = new FileOutputStream(image);
        IOUtils.copy(fileContent, out);
        f.uploadImage(folderName, "TEST", image);
        f.listImagesInFolder(folderName);


        // Detection Sample Code
        String photo = "party.jpg";
        String bucket = "wapproject";
        AWSRekognition awsRek = new AWSRekognition();
        // Detect Objects
        List<Label> labels =awsRek.detectObjectsInImage(bucket, photo);
        // Detect Celebrities
        List<Celebrity> celebs = awsRek.detectCelebrityInfo(bucket, photo);
        // Detect Text
        List<TextDetection> textDetections = awsRek.detectTextInImage(bucket, photo);
        // Detect faces
        List<FaceDetail> faceDetails = awsRek.detectFacesInImage(bucket,photo);
    }
}
