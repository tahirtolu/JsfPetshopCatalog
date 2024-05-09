/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Brand;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Yavuz Selim
 */
public class BrandDAO extends DBConnection{
    
    public List<Brand> readList(){
        List<Brand> list = new ArrayList <>();
        try{
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from brand");
            while(rs.next()){
                list.add(new Brand(rs.getLong("id"), rs.getString("logoResmi")));
            }
        } catch (Exception e ){
            System.out.println(e.getMessage());
        }
        return list;
    }
    public void create(Brand b){
        try{
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into brand(markaIsmi) values ('" + b.getMarkaIsmi() + " ' )");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
    }
         
    
}
