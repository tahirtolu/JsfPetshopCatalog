package controller;

import dao.FileUploadDAO;
import entity.FileUpload;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Named (value ="FileUploadBean")
@RequestScoped
public class FileUploadBean implements Serializable {

    @Inject
    private FileUploadDAO fileUploadDAO;

    private Part file;
    private List<FileUpload> uploadedFiles;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public List<FileUpload> getUploadedFiles() {
        if (uploadedFiles == null) {
            uploadedFiles = fileUploadDAO.findAll();
        }
        return uploadedFiles;
    }

    public void upload() {
        try {
            String fileName = getFileName(file);
            String filePath = "C:/uploadedFiles/" + fileName; // Dosya yolu
            String fileType = file.getContentType();

            // Dosyayı belirtilen dosya yoluna kaydet
            saveFileToDisk(file, filePath);

            // Veritabanına dosya bilgilerini kaydet
            FileUpload fileUpload = new FileUpload(fileName, filePath, fileType);
            fileUploadDAO.create(fileUpload);

            FacesMessage message = new FacesMessage("Dosya başarıyla yüklendi!");
            FacesContext.getCurrentInstance().addMessage(null, message);

            // Yüklenmiş dosyalar listesini yenile
            uploadedFiles = fileUploadDAO.findAll();
        } catch (IOException e) {
            FacesMessage message = new FacesMessage("Dosya yüklenirken hata oluştu!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    private void saveFileToDisk(Part part, String filePath) throws IOException {
        Path file = Paths.get(filePath);
        Files.createDirectories(file.getParent());

        try (var input = part.getInputStream()) {
            Files.copy(input, file);
        }
    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] elements = contentDisposition.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
