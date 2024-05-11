/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ProductDAO;
import entity.Product;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "ProductBean")
@SessionScoped
public class ProductBean implements Serializable {
    private Product entity;
    private ProductDAO dao;
    private List<Product> List;
    
    public void create(){
       this.getDao().create(entity);
       this.entity =new Product();
    }
    
    public void update() {
        this.getDao().update(entity);
        this.entity = new Product();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new Product();
    }

    public Product getEntity() {
        
        if (this.entity == null){
            this.entity = new Product();
        }
        
        return entity;
    }

    public ProductDAO getDao() {
        
        if( this.dao == null){
            this.dao = new ProductDAO();          
        }
        
        return dao;
    }

    public List<Product> getList() {
        
        this.List =this.getDao().readList();
        
        return List;
    }

    public void setEntity(Product entity) {
        this.entity = entity;
    }

    public void setDao(ProductDAO dao) {
        this.dao = dao;
    }

    public void setList(List<Product> List) {
        this.List = List;
    }
    
    
}