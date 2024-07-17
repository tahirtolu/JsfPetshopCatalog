package util;

import controller.AnimalBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@WebServlet(name = "FileServlet", urlPatterns = {"/image/*"})
public class FileServlet extends HttpServlet {

    @Inject
    private AnimalBean animalBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestedImage = req.getPathInfo().substring(1); // Dosya adını alır

        // Dosyanın yüklenmiş olduğu dizini kullanın
        String filePath = "C:/uploadedFiles/" + requestedImage;
        File imageFile = new File(filePath);

        // Dosyanın var olup olmadığını kontrol edin
        if (imageFile.exists()) {
            // Resim dosyasını yanıt olarak gönderin
            resp.setContentType(getServletContext().getMimeType(imageFile.getName()));
            Files.copy(imageFile.toPath(), resp.getOutputStream());
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND); // Dosya bulunamazsa hata döndürün
        }
    }
}
