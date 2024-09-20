/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBConnection;
import View.login.XDate;
import ViewModel.CTDoiHDViewModel;
import ViewModel.CTDoiSPViewModel;
import ViewModel.HDDoiSPViewModel;
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
public class HoaDonDoiHangRepository {

    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<HDDoiSPViewModel> list = null;

    public List<HDDoiSPViewModel> selectAllHDDoi(String Stringdate) {
//        if (!Stringdate.isEmpty()) {
//            java.util.Date date = XDate.toDate(Stringdate, "yyyy-MM-dd");
//            String sql = "SELECT H.IDHoaDonThayDoiSanPham, H.IDHoaDonBanHang,\n"
//                    + "dbo.Users.HoTen, H.ngaytaohoadon, dbo.KhachHang.Hoten , dbo.KhachHang.Sdt, \n"
//                    + "H.MoTa FROM dbo.HoaDonThayDoiSanPham H\n"
//                    + "INNER JOIN dbo.KhachHang ON H.IDKhachHang = dbo.KhachHang.IdKhachHang \n"
//                    + "INNER JOIN dbo.Users ON H.IdUsers = dbo.Users.IdUsers\n"
//                    + "WHERE H.ngaytaohoadon BETWEEN '" + new java.sql.Date(date.getTime()) + "'" + "AND '" + new java.sql.Date(date.getTime()) + " ' \n"
//                    + "ORDER BY H.IDHoaDonThayDoiSanPham DESC";
//            try {
//                st = db.getConnection().createStatement();
//                rs = st.executeQuery(sql);
//                list = new ArrayList<>();
//                while (rs.next()) {
//                    HDDoiSPViewModel p = new HDDoiSPViewModel();
//                    p.setIDHoaDonDoiSanPham(rs.getInt("IDHoaDonThayDoiSanPham"));
//                    p.setIDHoaDonBanHang(rs.getInt("IDHoaDonBanHang"));
//                    p.setNgaytaoHDTra(rs.getString("ngaytaohoadon"));
//                    //    p.setIDKhachHang(rs.getInt("idCustomer"));
//                    p.setMoTa(rs.getString("MoTa"));
//                    p.setTenKhachHang(rs.getString("KhachHang.Hoten"));
//                    //  p.setIdUsers(rs.getInt("idUser"));
//                    p.setTenUsers(rs.getString("Users.HoTen"));
//                    p.setSDTkH(rs.getString("Sdt"));
//                    list.add(p);
//                }
//                rs.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return list;
//        }

        String sql = "SELECT H.IDHoaDonThayDoiSanPham, H.IDHoaDonBanHang,\n"
                + "dbo.Users.HoTen, H.ngaytaohoadon, dbo.KhachHang.Hoten , dbo.KhachHang.Sdt, \n"
                + "H.MoTa FROM dbo.HoaDonThayDoiSanPham H\n"
                + "INNER JOIN dbo.KhachHang ON H.IDKhachHang = dbo.KhachHang.IdKhachHang \n"
                + "INNER JOIN dbo.Users ON H.IdUsers = dbo.Users.IdUsers ORDER BY H.IDHoaDonThayDoiSanPham DESC";
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(sql);
            list = new ArrayList<>();
            while (rs.next()) {
                HDDoiSPViewModel p = new HDDoiSPViewModel();
                p.setIDHoaDonDoiSanPham(rs.getInt("IDHoaDonThayDoiSanPham"));
                p.setIDHoaDonBanHang(rs.getInt("IDHoaDonBanHang"));
                p.setNgaytaoHDTra(rs.getString("ngaytaohoadon"));
                //    p.setIDKhachHang(rs.getInt("idCustomer"));
                p.setMoTa(rs.getString("MoTa"));
                p.setTenKhachHang(rs.getString("Hoten"));
                //  p.setIdUsers(rs.getInt("idUser"));
                p.setTenUsers(rs.getString("HoTen"));
                p.setSDTkH(rs.getString("Sdt"));
                list.add(p);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
   public List<CTDoiHDViewModel> selectByIdhdDoi(Integer k) {
       String sql  = "SELECT de.IDHoaDonThayDoiSanPham,de.SoLuong,D.GiaBan,S.TenNXB,M.TenTacGia,C.TenNgonNGu,de.IDChiTietThayDoiHoaDon,de.IDChiTietSach,P.TenSach\n" +
"FROM dbo.ChiTietThayDoiHoaDon de\n" +
"JOIN dbo.HoaDonThayDoiSanPham I ON I.IDHoaDonThayDoiSanPham = de.IDHoaDonThayDoiSanPham\n" +
"INNER JOIN dbo.ChiTietSach D ON D.IdCTSach = de.IDChiTietSach\n" +
"INNER JOIN dbo.NXB S  ON S.IdNXB = D.IdNXB\n" +
"INNER JOIN dbo.TacGia M ON M.IdTacGia = D.IdTacGia\n" +
"INNER JOIN dbo.NgonNgu C ON C.IdNgonNgu = D.IdNgonNgu\n" +
"INNER JOIN dbo.Sach P ON P.IdSach = D.IdSach\n" +
"WHERE de.IDHoaDonThayDoiSanPham = ?";
       List<CTDoiHDViewModel> list = new ArrayList<>();
       try {
            //st = db.getConnection().createStatement();
            pst = db.getConnection().prepareStatement(sql);
            pst.setInt(1, k);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                CTDoiHDViewModel de = new CTDoiHDViewModel();
               de.setIdHDDoi(rs.getInt("IDHoaDonThayDoiSanPham"));
                de.setSoLuong(rs.getInt("SoLuong"));
                de.setGia(rs.getInt("GiaBan"));
                de.setTenNXB(rs.getString("TenNXB"));
                de.setTenTacGia(rs.getString("TenTacGia"));
                de.setTenNgonNgu(rs.getString("TenNgonNGu"));
                de.setIdCTDoiHD(rs.getInt("IDChiTietThayDoiHoaDon"));
                de.setIdCTSach(rs.getInt("IDChiTietSach"));
                de.setTenSach(rs.getString("TenSach"));
                list.add(de);
            }
            rs.close();
       } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
   } 
     public List<CTDoiSPViewModel> selectByIdCTHDoi(Integer k) {
          String sql  = "SELECT de.IDChiTietThayDoiHoaDon , de.SoLuong,D.GiaBan,S.TenNXB,M.TenTacGia,C.TenNgonNGu,de.IDChiTietThayDoiSanPham,de.IDChiTietSach,P.TenSach \n" +
"FROM dbo.ChiTietThayDoiSanPham de \n" +
"INNER JOIN dbo.ChiTietSach D ON D.IdCTSach = de.IDChiTietSach\n" +
"INNER JOIN dbo.NXB S  ON S.IdNXB = D.IdNXB\n" +
"INNER JOIN dbo.TacGia M ON M.IdTacGia = D.IdTacGia\n" +
"INNER JOIN dbo.NgonNgu C ON C.IdNgonNgu = D.IdNgonNgu\n" +
"INNER JOIN dbo.Sach P ON P.IdSach = D.IdSach\n" +
"WHERE de.IDChiTietThayDoiHoaDon = ? ";
       List<CTDoiSPViewModel> list = new ArrayList<>();
       try {
            //st = db.getConnection().createStatement();
            pst = db.getConnection().prepareStatement(sql);
            pst.setInt(1, k);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                CTDoiSPViewModel de = new CTDoiSPViewModel();
               de.setIdCTHDDoi(rs.getInt("IDChiTietThayDoiHoaDon"));
                de.setSoLuong(rs.getInt("SoLuong"));
                de.setGia(rs.getInt("GiaBan"));
                de.setTenNXB(rs.getString("TenNXB"));
                de.setTenTacGia(rs.getString("TenTacGia"));
                de.setTenNgonNgu(rs.getString("TenNgonNGu"));
                de.setidCTDoiSP(rs.getInt("IDChiTietThayDoiSanPham"));
                de.setIdCTSach(rs.getInt("IDChiTietSach"));
                de.setTenSach(rs.getString("TenSach"));
                list.add(de);
            }
            rs.close();
       } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
     }
     
        public HDDoiSPViewModel FindHDD(int k) {
        String sql = "SELECT H.IDHoaDonThayDoiSanPham, H.IDHoaDonBanHang,\n" +
"dbo.Users.HoTen, H.ngaytaohoadon, dbo.KhachHang.Hoten , dbo.KhachHang.Sdt,H.MoTa FROM dbo.HoaDonThayDoiSanPham H\n" +
"INNER JOIN dbo.KhachHang ON H.IDKhachHang = dbo.KhachHang.IdKhachHang\n" +
"INNER JOIN dbo.Users ON H.IdUsers = dbo.Users.IdUsers WHERE H.IDHoaDonThayDoiSanPham = ?";
        List<HDDoiSPViewModel> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, k);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
              HDDoiSPViewModel p = new HDDoiSPViewModel();
                    p.setIDHoaDonDoiSanPham(rs.getInt("IDHoaDonThayDoiSanPham"));
                    p.setIDHoaDonBanHang(rs.getInt("IDHoaDonBanHang"));
                    p.setNgaytaoHDTra(rs.getString("ngaytaohoadon"));
                    //    p.setIDKhachHang(rs.getInt("idCustomer"));
                    p.setMoTa(rs.getString("MoTa"));
                    p.setTenKhachHang(rs.getString("Hoten"));
                    //  p.setIdUsers(rs.getInt("idUser"));
                    p.setTenUsers(rs.getString("HoTen"));
                    p.setSDTkH(rs.getString("Sdt"));
                return p;
                // listHDNhap.add(i);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDoiHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

     
     
}
