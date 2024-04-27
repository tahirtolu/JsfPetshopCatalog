/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author tolut
 */
public class Order {
    private long id;
    private Date tarih;
    private String müşteri_ismi;
    private int miktar;
    private double fiyat;
    private double toplam_tutar;

    public Order(long id, Date tarih, String müşteri_ismi, int miktar, double fiyat, double toplam_tutar) {
        this.id = id;
        this.tarih = tarih;
        this.müşteri_ismi = müşteri_ismi;
        this.miktar = miktar;
        this.fiyat = fiyat;
        this.toplam_tutar = toplam_tutar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public String getMüşteri_ismi() {
        return müşteri_ismi;
    }

    public void setMüşteri_ismi(String müşteri_ismi) {
        this.müşteri_ismi = müşteri_ismi;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public double getToplam_tutar() {
        return toplam_tutar;
    }

    public void setToplam_tutar(double toplam_tutar) {
        this.toplam_tutar = toplam_tutar;
    }

    public Order() {
    }
            
    
}
