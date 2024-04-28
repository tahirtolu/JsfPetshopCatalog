/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class Customer {
    private long id ;
    private String isim ;
    private String soyisim;
    private int telefon ;
    private String email ; 
    private String adress;

    public void setId(long id) {
        this.id = id;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public int getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public String getAdress() {
        return adress;
    }
   
    public Customer() {
    }


    
    public Customer(long id, String isim, String soyisim, int telefon, String email, String adress) {
        this.id = id;
        this.isim = isim;
        this.soyisim = soyisim;
        this.telefon = telefon;
        this.email = email;
        this.adress = adress;
    }

}


