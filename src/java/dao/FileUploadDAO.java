package dao;

import entity.FileUpload;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@RequestScoped
public class FileUploadDAO extends AbstractDAO<FileUpload> {

    @PersistenceContext
    private EntityManager em;

    public FileUploadDAO() {
        super(FileUpload.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Transactional
    @Override
    public void create(FileUpload fileUpload) {
        super.create(fileUpload);
    }

    @Transactional
    @Override
    public void update(FileUpload fileUpload) {
        super.update(fileUpload);
    }

    @Transactional
    @Override
    public void delete(FileUpload fileUpload) {
        super.delete(fileUpload);
    }

    @Override
    public FileUpload find(Object id) {
        return super.find(id);
    }

    @Override
    public List<FileUpload> findAll() {
        return super.findAll();
    }

    @Override
    public List<FileUpload> findRange(int firstResult, int maxResults) {
        return super.findRange(firstResult, maxResults);
    }

    @Override
    public int count() {
        return super.count();
    }
}
