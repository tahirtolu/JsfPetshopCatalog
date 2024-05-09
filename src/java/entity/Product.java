/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Locale.Category;

/**
 *
 * @author Yavuz Selim
 */
public class Product implements Serializable {

    private long id;
    private String isim;
    private int fiyat;
    private Category kategori;
    private String marka;
    private int stok;
    private String aciklama;
    private String image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public Category getKategori() {
        return kategori;
    }

    public void setKategori(Category kategori) {
        this.kategori = kategori;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product() {
    }

    public Product(long id, String isim, int fiyat, Category kategori, String marka, int stok, String aciklama, String image) {
        this.id = id;
        this.isim = isim;
        this.fiyat = fiyat;
        this.kategori = kategori;
        this.marka = marka;
        this.stok = stok;
        this.aciklama = aciklama;
        this.image = image;
    }

    

}
