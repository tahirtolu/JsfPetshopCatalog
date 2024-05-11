/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Category;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Yavuz Selim
 */
public class CategoryDAO extends DBConnection{
    
    public List<Category> readList(){
        List<Category> list = new ArrayList <>();
        try{
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from category");
            while(rs.next()){
                list.add(new Category(rs.getLong("id"), rs.getString("kategoriIsmi")));
            }
        } catch (Exception e ){
            System.out.println(e.getMessage());
        }
        return list;
    }
    public void create(Category b){
        try{
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into category(kategoriIsmi) values ('" + b.getKategoriIsmi() + " ' )");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
    } 
    public void update(Category b){
        try{
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update category set kategoriIsmi='"+b.getKategoriIsmi()+"' where id="+b.getId());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
    }
     public void delete(Category b){
        try{
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("delete from category where id=" +b.getId());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
    }
         
         
    
}
