/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author User
 */
@Entity
public class Category extends AbstractEntity {

    private String kategoriIsmi;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    public String getKategoriIsmi() {
        return kategoriIsmi;
    }

    public void setKategoriIsmi(String kategoriIsmi) {
        this.kategoriIsmi = kategoriIsmi;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
        product.getCategories().add(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.getCategories().remove(this);
    }

  
    @Override
    public String toString() {
        return "Category{" +
                "kategoriIsmi='" + kategoriIsmi + '\'' +
                '}';
    }
}
