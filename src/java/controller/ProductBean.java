package controller;

import dao.ProductDAO;
import entity.Category;
import entity.Product;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named(value = "productBean")
@SessionScoped
public class ProductBean implements Serializable {

    private Product entity;

    @EJB
    private ProductDAO dao;

    private List<Product> list;
    
    private List<Category> categories;
    private int pageNumber = 1; // Başlangıç sayfa numarası
    private int pageSize = 10; // Sayfa başına maksimum kayıt sayısı

    public ProductBean() {
        entity = new Product();
    }

    public void create() {
        System.out.println(entity.toString());
        dao.create(entity);

        entity = new Product(); // Yeni bir Product nesnesi oluştur
    }

    public void update() {
        dao.update(entity);
        entity = new Product();
    }

    public void delete() {
        dao.delete(entity);
        entity = new Product(); // Silinen kategori için yeni bir Product nesnesi oluştur
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

    public Product getEntity() {
        return entity;
    }

    public void setEntity(Product entity) {
        this.entity = entity;
    }

    public List<Product> getList() {
        if (list == null) {
            updateList();
        }
        return list;
    }

    public void setList(List<Product> list) {
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    
    
}
