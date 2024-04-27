/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Yavuz Selim
 */
public class Picture {
    private long id;
    private String resimAdi;
    private String resimTipi;
    private String resimURL;

    public Picture() {
    }

    public Picture(long id, String resimAdi, String resimTipi, String resimURL) {
        this.id = id;
        this.resimAdi = resimAdi;
        this.resimTipi = resimTipi;
        this.resimURL = resimURL;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getResimAdi() {
        return resimAdi;
    }

    public void setResimAdi(String resimAdi) {
        this.resimAdi = resimAdi;
    }

    public String getResimTipi() {
        return resimTipi;
    }

    public void setResimTipi(String resimTipi) {
        this.resimTipi = resimTipi;
    }

    public String getResimURL() {
        return resimURL;
    }

    public void setResimURL(String resimURL) {
        this.resimURL = resimURL;
    }
    
}
