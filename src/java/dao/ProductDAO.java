package dao;

import entity.Product;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Yavuz Selim
 */
public class ProductDAO extends DBConnection{
    
    public List<Product> readList(){
        List<Product> list = new ArrayList <>();
        try{
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from product");
            while(rs.next()){
                list.add(new Product(rs.getLong("id"), rs.getString("isim"),rs.getString("marka"),rs.getString("kategori")));
            }
        } catch (Exception e ){
            System.out.println(e.getMessage());
        }
        return list;
    }
    public void create(Product p){
        try{
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into Product(isim) values ('" + p.getIsim()+ " ' )");
            st.executeUpdate("insert into Product(marka) values ('" + p.getMarka() + " ' )");
            st.executeUpdate("insert into Product(kategori) values ('" + p.getKategori()+ " ' )");
           
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
    } 
    public void update(Product p){
        try{
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update Product set isim='"+p.getIsim()+"' where id="+p.getId());
            st.executeUpdate("update Product set marka='"+p.getMarka()+"' where id="+p.getId());
            st.executeUpdate("update Product set kategori='"+p.getKategori()+"' where id="+p.getId());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
    }
     public void delete(Product p){
        try{
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("delete from Product where id=" +p.getId());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
    }
         
         
    
}