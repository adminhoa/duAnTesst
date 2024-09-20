/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;


import DomainModel.TaiKhoan;
import Utilities.DBConnection;
import Utilities.jdbcHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class TaiKhoanRepository {
    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<TaiKhoan> LisTaiKhoan= null;
    TaiKhoan taikhoan = null;

    public TaiKhoanRepository() {
    }
    public TaiKhoan getLisTaiKhoan(String UsersName) {
        String select = "SELECT * FROM dbo.TaiKhoan INNER JOIN dbo.Users ON Users.IdUsers = TaiKhoan.IdUsers WHERE UserName = ? AND TrangThai = 1";
        
        try {
//            st = db.getConnection().createStatement();
//           pst.setString(1, UsersName);
//            pst = st.executeQuery(select);
            
             pst = db.getConnection().prepareStatement(select);
           pst.setString(1, UsersName);
           rs = pst.executeQuery();
          LisTaiKhoan = new ArrayList<>();
           while (rs.next()) {                
                taikhoan=new TaiKhoan(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getString(4));
            }
           rs.close();
        } catch (Exception e) {
        }
        
        return taikhoan;
    }

public TaiKhoan getLisdoimaykhau(Integer id) {
        String select01 = "SELECT * FROM dbo.TaiKhoan WHERE IdUsers = ?";
        
        try {
           pst = db.getConnection().prepareStatement(select01);
           pst.setInt(1, id);
           rs = pst.executeQuery();
          //LisTaiKhoan = new ArrayList<>();
           while (rs.next()) {                
                taikhoan=new TaiKhoan(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getString(4));
            }
           rs.close();
        } catch (Exception e) {
        }
        
        return taikhoan;
    }
public String update(TaiKhoan tk){
        String update ="UPDATE dbo.TaiKhoan SET MatKhau = ? WHERE IdUsers = ?";
        try {
            pst = db.getConnection().prepareStatement(update);
            pst.setNString(1, tk.getMatKhau());
            pst.setInt(2, tk.getIdUser());
           // System.out.println(ListNhaXuatBan.size());
           pst.executeUpdate();
            return "Đổi Mật Khẩu Thành Công";
        } catch (Exception e) {
            
        }
        return "Đổi Mật Khẩu Không Thành Công";
    }
   
}
