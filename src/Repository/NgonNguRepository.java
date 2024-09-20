/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.NgonNgu;
import DomainModel.NhaXuatBan;
import Utilities.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

/**
 *
 * @author ADMIN
 */
public class NgonNguRepository {
    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<NgonNgu> ListNgonNgu = null;

    public NgonNguRepository() {
    }
    
    public List<NgonNgu> getlistNgon(){
        ListNgonNgu = new ArrayList<>();
        String select = "SELECT * FROM dbo.NgonNgu";
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {                
                ListNgonNgu.add(new NgonNgu(rs.getInt(1), rs.getNString(2)));
            }
        } catch (Exception e) {
        }
        return ListNgonNgu;
    }
    public String insert (NgonNgu nn){
        String insert = "INSERT INTO dbo.NgonNgu\n" +
"(\n" +
"    TenNgonNGu\n" +
")\n" +
"VALUES(?)";
        try {
            pst = db.getConnection().prepareStatement(insert);
            pst.setNString(1, nn.getTenNgonNgu());
            pst.executeUpdate();
            return "them thanh cong";
        } catch (Exception e) {
            
        }
        return "Them khong thanh cong";
    }
    public String update(NgonNgu nn){
        String update ="UPDATE dbo.NgonNgu SET TenNgonNGu = ? WHERE IdNgonNgu = ?";
        try {
            pst = db.getConnection().prepareStatement(update);
            pst.setNString(1, nn.getTenNgonNgu());
            pst.setInt(2, nn.getIdNgonNgu());
           // System.out.println(ListNhaXuatBan.size());
           pst.executeUpdate();
            return "sua thanh cong";
        } catch (Exception e) {
            
        }
        return "sua khong thanh cong";
    }
//    public NgonNgu selectName(String name){
//        ListNgonNgu = new ArrayList<>();
//        String select = "SELECT * FROM dbo.NgonNgu WHERE TenNgonNGu = ? ";
//        try {
////            st = db.getConnection().createStatement();
////            rs = st.executeQuery(select);
//            
//            pst = db.getConnection().prepareStatement(select);
//           pst.setString(1, name);
//        pst.executeQuery();
//            while (rs.next()) {                
//                ListNgonNgu.add(new NgonNgu(rs.getInt(1), rs.getNString(2)));
//            }
//            rs.close();
//        } catch (Exception e) {
//        }
//        return null;
//    }
     public NgonNgu selectName(String name) {
        String sql = "SELECT * FROM dbo.NgonNgu WHERE TenNgonNGu = ? ";
               
        ListNgonNgu = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
           if (rs.next()) {
                NgonNgu p = new NgonNgu();
                p.setIdNgonNgu(rs.getInt("IdNgonNgu"));
                p.setTenNgonNgu(rs.getString("TenNgonNGu"));                
                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
