/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author tolut
 */
public class Brand {
    private long id;
    private String markaIsmi;

    public Brand(long id, String markaIsmi) {
        this.id = id;
        this.markaIsmi = markaIsmi;
    }

    public Brand() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarkaIsmi() {
        return markaIsmi;
    }

    public void setMarkaIsmi(String markaIsmi) {
        this.markaIsmi = markaIsmi;
    }
    
}
