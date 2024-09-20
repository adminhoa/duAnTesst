/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.TacGia;
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
public class TacGiaRepositiry {
     DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<TacGia> ListTacGia = null;

    public TacGiaRepositiry() {
    }
     public List<TacGia> getlistNTacGia(){
        ListTacGia = new ArrayList<>();
        String select = "SELECT * FROM dbo.TacGia";
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {                
                ListTacGia.add(new TacGia(rs.getInt(1), rs.getNString(2)));
            }
        } catch (Exception e) {
        }
        return ListTacGia;
    }
    public String insert (TacGia tg){
        String insert = "INSERT INTO dbo.TacGia\n" +
"(\n" +
"    TenTacGia\n" +
")\n" +
"VALUES(?)";
        try {
            pst = db.getConnection().prepareStatement(insert);
            pst.setNString(1, tg.getTenGiaGia());
            pst.executeUpdate();
            return "Them thanh Cong";
        } catch (Exception e) {
        }
        return "Them khong thanh cong";
    }
    public String update(TacGia tg){
        String update ="UPDATE dbo.TacGia SET TenTacGia = ? WHERE IdTacGia = ?";
        try {
            pst = db.getConnection().prepareStatement(update);
            pst.setNString(1, tg.getTenGiaGia());
            pst.setInt(2, tg.getIdTacGia());
           // System.out.println(ListNhaXuatBan.size());
           pst.executeUpdate();
            return "sua thanh cong";
        } catch (Exception e) {
            
        }
        return "sua khong thanh cong";
    }
//    public TacGia selectName(String name){
//        ListTacGia = new ArrayList<>();
//        String select = "SELECT * FROM dbo.TacGia WHERE TenTacGia = ?";
//        try {
//            pst = db.getConnection().prepareStatement(select);
//           pst.setString(1, name);
//           rs = pst.executeQuery();
//            while (rs.next()) {                
//                ListTacGia.add(new TacGia(rs.getInt(1), rs.getNString(2)));
//            }
//        } catch (Exception e) {
//        }
//        return null;
//    }
     public TacGia selectName(String name) {
        String sql = "SELECT * FROM dbo.TacGia WHERE TenTacGia = ? ";
               
        ListTacGia = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
           if (rs.next()) {
                TacGia p = new TacGia();
                p.setIdTacGia(rs.getInt("IdTacGia"));
                p.setTenGiaGia(rs.getString("TenTacGia"));                
                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
