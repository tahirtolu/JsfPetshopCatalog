/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AnimalDAO;
import entity.Animal;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Yavuz Selim
 */
@Named(value= "AnimalBean")
@SessionScoped
public class AnimalBean implements Serializable {

    private Animal entity;
    private AnimalDAO dao;
    private List<Animal> List;

    public AnimalBean() {

    }

    public void create() {
        this.getDao().create(entity);
        this.entity = new Animal();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Animal();
    }

    public void delete() {
        this.getDao().delete(entity);
        this.entity = new Animal();
    }

    public Animal getEntity() {

        if (this.entity == null) {
            this.entity = new Animal();
        }
        return entity;
    }

    public AnimalDAO getDao() {

        if (this.dao == null) {
            this.dao = new AnimalDAO();

        }

        return dao;
    }

    public List<Animal> getList() {

        this.List = this.getDao().readList();

        return List;
    }

    public void setEntity(Animal entity) {
        this.entity = entity;
    }

    public void setDao(AnimalDAO dao) {
        this.dao = dao;
    }

    public void setList(List<Animal> List) {
        this.List = List;
    }
}
