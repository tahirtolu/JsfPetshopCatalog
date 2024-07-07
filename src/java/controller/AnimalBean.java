package controller;

import dao.AnimalDAO;
import entity.Animal;
import entity.FileUpload;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Named(value = "animalBean")
@SessionScoped
public class AnimalBean implements Serializable {

    private Animal entity;
    @EJB
    private AnimalDAO dao;
    private List<Animal> list;
    private int pageNumber = 1; // Başlangıç sayfa numarası
    private int pageSize = 10; // Sayfa başına maksimum kayıt sayısı

    
    private Part file;
    private List<Animal> uploadedFiles;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public List<Animal> getUploadedFiles() {
        if (uploadedFiles == null) {
            uploadedFiles = dao.findAll();
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
            
            getEntity().setHayvanTuru(getEntity().getHayvanTuru());
            getEntity().setYas(getEntity().getYas());
            getEntity().setCinsiyet(getEntity().getCinsiyet());
            getEntity().setFileName(fileName);
            getEntity().setFilePath(filePath);
            getEntity().setFileType(fileType);
           
            
            dao.create(getEntity());

            FacesMessage message = new FacesMessage("Dosya başarıyla yüklendi!");
            FacesContext.getCurrentInstance().addMessage(null, message);

            // Yüklenmiş dosyalar listesini yenile
            uploadedFiles = dao.findAll();
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
    public AnimalBean() {
        entity = new Animal();
    }

    public void create() {
    dao.create(entity);
    entity = new Animal(); // Yeni bir Animal nesnesi oluştur
    pageNumber = 1; // Sayfa numarasını sıfırla
    updateList(); // Listeyi güncelle
}


    public void update() {
        dao.update(entity);
        entity = new Animal();
    }

    public void delete() {
    dao.delete(entity);
    entity = new Animal(); // Silinen kategori için yeni bir Animal nesnesi oluştur
    pageNumber = 1; // Sayfa numarasını sıfırla
    updateList(); // Listeyi güncelle
}


    public void nextPage() {
        pageNumber++;
        updateList();
    }

    public void previousPage() {
        if (pageNumber > 1) {
            pageNumber--;
            updateList();
        }
    }

    private void updateList() {
        list = dao.findCategoriesWithPagination(pageNumber, pageSize);
    }

    public Animal getEntity() {
        if(entity == null){
        entity = new Animal();
        }
        return entity;
    }

    public void setEntity(Animal entity) {
        this.entity = entity;
    }

    public List<Animal> getList() {
        if (list == null) {
            list=dao.findAll();
        }
        return list;
    }

    public void setList(List<Animal> list) {
        this.list = list;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
