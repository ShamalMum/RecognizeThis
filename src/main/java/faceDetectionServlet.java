import com.amazonaws.services.rekognition.model.FaceDetail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@WebServlet("/detectfaces")
public class faceDetectionServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bucket = this.getServletContext().getInitParameter("bucket-name");
        AWSStorage awsStorage = new AWSStorage();
        awsStorage.uploadImage(bucket, req.getPart("file"));
        String photo = Paths.get(req.getPart("file").getSubmittedFileName()).getFileName().toString();
        AWSRekognition awsRek = new AWSRekognition();
        // Detect faces
        List<FaceDetail> faceDetails = awsRek.detectFacesInImage(bucket,photo);
    }
}
