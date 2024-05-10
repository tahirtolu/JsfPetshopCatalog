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
    
    private int page=1;
    private int pageCount=0;

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

        this.List = this.getDao().readList(page);

        return List;
    }
    public void prev(){
        page--;
        if(page <1){
        page=this.getPageCount();
        }
    }
    public void next(){
        page++;
        if(page > this.getPageCount()){
        page=1;
        }
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        List<Animal> alist=this.getDao().readList(page);
        int size = alist.size();
        pageCount =(int) Math.ceil(size/10);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    
    
}
