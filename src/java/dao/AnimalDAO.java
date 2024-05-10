/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Animal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class AnimalDAO extends DBConnection {

    public List<Animal> readList() {
        List<Animal> list = new ArrayList<>();
        String query = "SELECT * FROM animal";
        try (PreparedStatement pst = this.getConnect().prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                list.add(new Animal(rs.getLong("id"), rs.getString("hayvanTuru"), rs.getString("hayvanCinsi"), rs.getString("hayvanIrki"), rs.getString("cinsiyet"), rs.getInt("kilo"), rs.getInt("yas")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void create(Animal a) {
        String query = "INSERT INTO animal (hayvanTuru, hayvanIrki, hayvanCinsi, cinsiyet, kilo, yas) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = this.getConnect().prepareStatement(query)) {
            pst.setString(1, a.getHayvanTuru());
            pst.setString(2, a.getHayvanIrki());
            pst.setString(3, a.getHayvanCinsi());
            pst.setString(4, a.getCinsiyet());
            pst.setFloat(5, a.getKilo());
            pst.setInt(6, a.getYas());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Animal a) {
        String query = "UPDATE animal SET hayvanTuru=?, hayvanIrki=?, hayvanCinsi=?, cinsiyet=?, kilo=?, yas=? WHERE id=?";
        try (PreparedStatement pst = this.getConnect().prepareStatement(query)) {
            pst.setString(1, a.getHayvanTuru());
            pst.setString(2, a.getHayvanIrki());
            pst.setString(3, a.getHayvanCinsi());
            pst.setString(4, a.getCinsiyet());
            pst.setFloat(5, a.getKilo());
            pst.setInt(6, a.getYas());
            pst.setLong(7, a.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Animal a) {
        String query = "DELETE FROM animal WHERE id=?";
        try (PreparedStatement pst = this.getConnect().prepareStatement(query)) {
            pst.setLong(1, a.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}