/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.BrandDAO;
import entity.Brand;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Yavuz Selim
 */
@Named(value= "BrandBean")
@SessionScoped
public class BrandBean implements Serializable {

    private Brand entity;
    private BrandDAO dao;
    private List<Brand> List;

    public BrandBean() {

    }

    public void create() {
        this.getDao().create(entity);
        this.entity = new Brand();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Brand();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new Brand();
    }

    public Brand getEntity() {

        if (this.entity == null) {
            this.entity = new Brand();
        }
        return entity;
    }

    public BrandDAO getDao() {

        if (this.dao == null) {
            this.dao = new BrandDAO();

        }

        return dao;
    }

    public List<Brand> getList() {

        this.List = this.getDao().readList();

        return List;
    }

    public void setEntity(Brand entity) {
        this.entity = entity;
    }

    public void setDao(BrandDAO dao) {
        this.dao = dao;
    }

    public void setList(List<Brand> List) {
        this.List = List;
    }
}
