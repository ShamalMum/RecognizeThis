import com.amazonaws.services.rekognition.model.Label;
import com.amazonaws.services.simpleworkflow.flow.JsonDataConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@WebServlet("/detectobjects")
@MultipartConfig
public class ObjectDetectionServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/detectobjects.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String bucket = this.getServletContext().getInitParameter("bucket-name");
        AWSStorage awsStorage = new AWSStorage();
        awsStorage.uploadImage(bucket, req.getPart("file"));
        String photo = Paths.get(req.getPart("file").getSubmittedFileName()).getFileName().toString();
        AWSRekognition awsRek = new AWSRekognition();
        // Detect Objects
        List<Label> labels =awsRek.detectObjectsInImage(bucket, photo);
        JsonDataConverter jsonDC = new JsonDataConverter();
        resp.getWriter().write(jsonDC.toData(labels));
    }
}
