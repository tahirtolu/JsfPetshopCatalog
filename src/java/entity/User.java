/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author User
 */
public class User {
    private long id ;
    private String isim ;
    private String soyisim ;
    private String sifre ;
    private String eposta;
    private String kullaniciAdi;

    public void setId(long id) {
        this.id = id;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public long getId() {
        return id;
    }

    public String getIsim() {
        return isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public String getSifre() {
        return sifre;
    }

    public User(long id, String isim, String soyisim, String sifre, String eposta, String kullaniciAdi) {
        this.id = id;
        this.isim = isim;
        this.soyisim = soyisim;
        this.sifre = sifre;
        this.kullaniciAdi = kullaniciAdi;
        this.eposta = eposta;
    }

    public User() {
    }
    
}
