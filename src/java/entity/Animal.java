/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Muhsin21
 */
public class Animal {
    private long id;
    private String hayvanTuru;
    private String hayvanCinsi;
    private String hayvanIrki;
    private String cinsiyet;
    private int kilo;

    public Animal() {
    }

    public Animal(long id, String hayvanTuru, String hayvanCinsi, String hayvanIrki, String cinsiyet, int kilo) {
        this.id = id;
        this.hayvanTuru = hayvanTuru;
        this.hayvanCinsi = hayvanCinsi;
        this.hayvanIrki = hayvanIrki;
        this.cinsiyet = cinsiyet;
        this.kilo = kilo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHayvanTuru() {
        return hayvanTuru;
    }

    public void setHayvanTuru(String hayvanTuru) {
        this.hayvanTuru = hayvanTuru;
    }

    public String getHayvanCinsi() {
        return hayvanCinsi;
    }

    public void setHayvanCinsi(String hayvanCinsi) {
        this.hayvanCinsi = hayvanCinsi;
    }

    public String getHayvanIrki() {
        return hayvanIrki;
    }

    public void setHayvanIrki(String hayvanIrki) {
        this.hayvanIrki = hayvanIrki;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public int getKilo() {
        return kilo;
    }

    public void setKilo(int kilo) {
        this.kilo = kilo;
    }
    
    
    
}
