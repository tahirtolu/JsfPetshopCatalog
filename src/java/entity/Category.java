/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Entity;

/**
 *
 * @author User
 */
@Entity
public class Category extends AbstractEntity{
 
    private String kategoriIsmi;


    public String getKategoriIsmi() {
        return kategoriIsmi;
    }

    public void setKategoriIsmi(String kategoriIsmi) {
        this.kategoriIsmi = kategoriIsmi;
    }

    public Category() {
    }

    public Category( String kategoriIsmi) {
        
        this.kategoriIsmi = kategoriIsmi;
    }

    @Override
    public String toString() {
        return "Category{" + "kategoriIsmi=" + kategoriIsmi + '}';
    }
    
    
}
