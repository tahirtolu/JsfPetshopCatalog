/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CategoryDAO;
import entity.Category;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Yavuz Selim
 */
@Named(value= "CategoryBean")
@SessionScoped
public class CategoryBean implements Serializable {

    private Category entity;
    private CategoryDAO dao;
    private List<Category> List;

    public CategoryBean() {

    }

    public void create() {
        this.getDao().create(entity);
        this.entity = new Category();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Category();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new Category();
    }

    public Category getEntity() {

        if (this.entity == null) {
            this.entity = new Category();
        }
        return entity;
    }

    public CategoryDAO getDao() {

        if (this.dao == null) {
            this.dao = new CategoryDAO();

        }

        return dao;
    }

    public List<Category> getList() {

        this.List = this.getDao().readList();

        return List;
    }

    public void setEntity(Category entity) {
        this.entity = entity;
    }

    public void setDao(CategoryDAO dao) {
        this.dao = dao;
    }

    public void setList(List<Category> List) {
        this.List = List;
    }
}
