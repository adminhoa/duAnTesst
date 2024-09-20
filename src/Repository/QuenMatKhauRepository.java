/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.NCC;
import Utilities.DBConnection;
import ViewModel.NhanVienViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class QuenMatKhauRepository {
    DBConnection db;
   Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
        PreparedStatement pst = null;
    List<NhanVienViewModel> list = null;

    public QuenMatKhauRepository() {
    }
    

    public List<NhanVienViewModel> getAll() {
        String sql = "SELECT TaiKhoan.IdUsers,IdTaiKhoan,CCCD\n" +
",HoTen,Sdt,DiaChi,Email,UserName,MatKhau,\n" +
"GioiTinh,Role,TrangThai,NgaySinh,Luong \n" +
"FROM dbo.TaiKhoan INNER JOIN dbo.Users \n" +
"ON Users.IdUsers = TaiKhoan.IdUsers ORDER BY \n" +
"TaiKhoan.IdUsers DESC";
        try {
           // pst = db.getConnection().prepareStatement(sql);
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();

            while (rs.next()) {
                list.add(new NhanVienViewModel(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getBoolean(10), rs.getBoolean(11), rs.getBoolean(12), rs.getDate(13),rs.getFloat(14)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public String update(NhanVienViewModel nv){
        String update ="UPDATE dbo.TaiKhoan SET MatKhau = ? FROM dbo.TaiKhoan INNER JOIN dbo.Users \n" +
"ON Users.IdUsers = TaiKhoan.IdUsers WHERE UserName = ?";
        try {
            pst = db.getConnection().prepareStatement(update);
            pst.setNString(1, nv.getPassword());
            pst.setString(2, nv.getUsername());
           // System.out.println(ListNhaXuatBan.size());
           pst.executeUpdate();
            return "Đổi Mật Khẩu Thành Công";
        } catch (Exception e) {
            
        }
        return "Đổi Mật Khẩu Không Thành Công";
    }
}
