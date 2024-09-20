/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.Users;
import Utilities.DBConnection;

import Utilities.DBConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ThongTinCaNhanRepository {
 DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<Users> ListUsers = null;
    Users users = null;
    
    public ThongTinCaNhanRepository() {
    }
    public Users getListusers(Integer id) {
        String select01 = "SELECT * FROM dbo.Users WHERE IdUsers = ?";
        
        try {
           pst = db.getConnection().prepareStatement(select01);
           pst.setInt(1, id);
           rs = pst.executeQuery();
          //LisTaiKhoan = new ArrayList<>();
            while (rs.next()) {                
                users =new Users(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getFloat(8), rs.getBoolean(9), rs.getBoolean(10),rs.getString(11));
            }
           rs.close();
        } catch (Exception e) {
        }
        
        return users;
    }
        public boolean updateThongTin(int id,Users us) {
            int check = 0;
        String update = "UPDATE users SET Sdt = ?,Email = ?,DiaChi =?,HoTen =?,GioiTinh=?,NgaySinh =? WHERE IdUsers = ?";
        try {
            pst = db.getConnection().prepareStatement(update);

           
            pst.setString(1, us.getSoDienThoai());
            pst.setString(2, us.getEmail());
            pst.setString(3, us.getDiaChi());
            pst.setString(4, us.getHoten());
            pst.setBoolean(5, us.isGioitinh());
            pst.setObject(6, us.getNgaysinh());
            pst.setInt(7, us.getIdusers());
            check =pst.executeUpdate();
            
        } catch (Exception e) {

        }
        return check > 0;
    
    }
        public List<Users> getListThongTin() {
        String select = "SELECT* FROM dbo.Users";
        ListUsers= new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                users = new Users(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getFloat(8), rs.getBoolean(9), rs.getBoolean(10),rs.getString(11));
            }
            rs.close();
        } catch (Exception e) {
        }
        
        return ListUsers;
    }
  
}
