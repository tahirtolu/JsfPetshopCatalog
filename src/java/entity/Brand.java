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
    private String markaİsmi;

    public Brand(long id, String markaİsmi) {
        this.id = id;
        this.markaİsmi = markaİsmi;
    }

    public Brand() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarkaİsmi() {
        return markaİsmi;
    }

    public void setMarkaİsmi(String markaİsmi) {
        this.markaİsmi = markaİsmi;
    }
    
}
