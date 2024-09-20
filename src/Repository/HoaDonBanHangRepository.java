
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.HoaDonBanHang;
import Utilities.DBConnection;
import ViewModel.HDBanViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class HoaDonBanHangRepository {
     DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<HoaDonBanHang> ListHoaDon = null;

    public HoaDonBanHangRepository() {
    }
    
     public String insert (HoaDonBanHang hdbh){
        String insert = "INSERT INTO dbo.HoaDonBan\n" +
"		 (\n" +
"		     IdKhachHang,\n" +
"		     IdUsers,\n" +
"		     IdVoucher,\n" +
"		     TENKhachHang,\n" +
"		     statusPay,\n" +
"		     statusInvoice,\n" +
"		     TongTien,\n" +
"		     TienKhachDua,\n" +
"		     TienTraLai,\n" +
"		     TrangThai,\n" +
"		     GhiChu,\n" +
"		     ngayTao,\n" +
"		     NGAYTHANHTOAN\n" +
"		 )\n" +
"		 VALUES(?,?,?,?,?,?,?,?,?,?,?,GETDATE(),GETDATE())";
      
        try {
            pst = db.getConnection().prepareStatement(insert);
            pst.setInt(1, hdbh.getIdKhachHang());
            pst.setInt(2, hdbh.getIdUsers());
            pst.setObject(3, hdbh.getIDVoucher());
            pst.setString(4, hdbh.getTenKhachHang());
            pst.setBoolean(5, hdbh.isTrangThaiTraTien());
            pst.setBoolean(6, hdbh.isTrangThaiHoaDon());
            pst.setFloat(7, hdbh.getTongTien());
            pst.setFloat(8, hdbh.getTienKhachDua());
            pst.setFloat(9, hdbh.getTienTraLai());
            pst.setBoolean(10, hdbh.isTrangThai());
            pst.setString(11, hdbh.getGhichu());
            pst.executeUpdate();
            return "them thanh cong";
        } catch (Exception e) {
            
        }
        return "Them khong thanh cong";
    }
     
     
     public HDBanViewModel FindHDB(int k) {
        String sql = "SELECT IdHoaDonBan,HoaDonBan.IdKhachHang,IdVoucher,NGAYTHANHTOAN,GhiChu,\n" +
"statusPay,statusInvoice,TongTien,TienKhachDua,TienTraLai,TENKhachHang,\n" +
"Users.IdUsers, Users.HoTen FROM dbo.HoaDonBan\n" +
"JOIN dbo.Users ON Users.IdUsers = HoaDonBan.IdUsers \n" +
"JOIN dbo.KhachHang ON KhachHang.IdKhachHang = HoaDonBan.IdKhachHang\n" +
"WHERE IdHoaDonBan = ?";
        List<HDBanViewModel > list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, k);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HDBanViewModel i = new HDBanViewModel();
                i.setIdHoaDonBan(rs.getInt("IdHoaDonBan"));
                i.setIdKhachHang(rs.getInt("IdKhachHang"));
                i.setIdUsers(rs.getInt("IdUsers"));
                i.setIdVoucher(rs.getInt("idVoucher"));
                i.setNGAYTHANHTOAN(rs.getString("NGAYTHANHTOAN"));
                i.setGhiChu(rs.getString("GhiChu"));
                i.setStatusPay(rs.getBoolean("statusPay"));
                i.setStatusInvoice(rs.getBoolean("statusInvoice"));
                i.setTenKhachHang(rs.getString("TENKhachHang"));
                i.setTenUser(rs.getString("HoTen"));
                i.setTongTien(rs.getDouble("TongTien"));
                i.setTienKhachDua(rs.getDouble("TienKhachDua"));
                i.setTienTraLai(rs.getDouble("TienTraLai"));
                return i;
                // listHDNhap.add(i);
            }

        } catch (SQLException ex) {
            Logger.getLogger(NhapHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
