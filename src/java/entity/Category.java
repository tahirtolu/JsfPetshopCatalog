/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author User
 */
public class Category {
    private long id;
    private String kategoriIsmi;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKategoriIsmi() {
        return kategoriIsmi;
    }

    public void setKategoriIsmi(String kategoriIsmi) {
        this.kategoriIsmi = kategoriIsmi;
    }

    public Category() {
    }

    public Category(long id, String kategoriIsmi) {
        this.id = id;
        this.kategoriIsmi = kategoriIsmi;
    }
    
}
