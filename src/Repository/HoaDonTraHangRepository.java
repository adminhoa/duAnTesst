/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBConnection;
import ViewModel.CTHDTraHangViewModel;
import ViewModel.HDBanViewModel;
import ViewModel.HDDoiSPViewModel;
import ViewModel.HDTraHangViewModel;
import ViewModel.NhapHangViewModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quanh
 */
public class HoaDonTraHangRepository {

    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
//$$$$$$$$$$$$$$$$$$$$$$$$$$$

    public List<HDTraHangViewModel> getAllTra() {
        String sql = "SELECT IDHoaDonTraHang,IDHoaDonBanHang,NgayDoiHang,HoaDonTraHang.IDKhachHang,totalReturn,MoTa,Hoten,Sdt\n" +
"FROM dbo.HoaDonTraHang JOIN dbo.KhachHang ON KhachHang.IdKhachHang = HoaDonTraHang.IDKhachHang ORDER BY IDHoaDonTraHang DESC";
        List<HDTraHangViewModel> listTra = new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(sql);
            listTra = new ArrayList<>();
            while (rs.next()) {
                HDTraHangViewModel p = new HDTraHangViewModel();
                 p.setMaHoaDonTra(rs.getInt("IDHoaDonTraHang"));
                p.setMaHoaDonBan(rs.getInt("IDHoaDonBanHang"));
                p.setThoiGian(rs.getDate("NgayDoiHang"));
                p.setIdKhachHang(rs.getInt("IDKhachHang"));
                p.setTongTienHoanTra(rs.getFloat("totalReturn"));
                p.setGhiChu(rs.getString("MoTa"));
                p.setKhachHang(rs.getString("Hoten"));
                p.setSdt(rs.getInt("Sdt"));
                listTra.add(p);
            }
            return listTra;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    //////$$$$$$
//    public Float TongTien(Float idHDT) {
//        String sql = "SELECT  IDchitietHoaDonTraHang, SUM(SoLuong * GIA ) as totalCash FROM dbo.chitietHoaDonTraHang \n"
//                + "                GROUP BY IDchitietHoaDonTraHang \n"
//                + "                HAVING IDchitietHoaDonTraHang = ?";
//        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setObject(1, idHDT);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                return rs.getFloat("totalCash");
//            }
//            rs.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    //////$$$$$$
    public List<CTHDTraHangViewModel> selectByIdNhap(int id) {
        String sql = " SELECT IDchitietHoaDonTraHang,SoLuong,GIA,TenNXB,TenTacGia,TenNgonNGu,TenSach,Hoten FROM dbo.HoaDonTraHang\n" +
"JOIN dbo.chitietHoaDonTraHang ON chitietHoaDonTraHang.IDHoaDonTraHang = HoaDonTraHang.IDHoaDonTraHang\n" +
"JOIN dbo.KhachHang ON KhachHang.IdKhachHang = HoaDonTraHang.IDKhachHang\n" +
"JOIN dbo.ChiTietSach ON ChiTietSach.IdCTSach = chitietHoaDonTraHang.IDChiTietSach\n" +
"JOIN dbo.Sach ON Sach.IdSach = ChiTietSach.IdSach\n" +
"JOIN dbo.NXB ON NXB.IdNXB = ChiTietSach.IdNXB\n" +
"JOIN dbo.TacGia ON TacGia.IdTacGia = ChiTietSach.IdTacGia\n" +
"JOIN dbo.NgonNgu ON NgonNgu.IdNgonNgu = ChiTietSach.IdNgonNgu\n" +
"WHERE chitietHoaDonTraHang.IDHoaDonTraHang = ?";
        List<CTHDTraHangViewModel> list = new ArrayList<>();
        try {
              pst = db.getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                CTHDTraHangViewModel de = new CTHDTraHangViewModel();
                 de.setIdHDChiTiet(rs.getInt("IDchitietHoaDonTraHang"));
                de.setSoLuong(rs.getInt("SoLuong"));
                de.setTongTien(rs.getInt("GIA"));
                de.setTenNXB(rs.getString("TenNXB"));
                de.setTenTG(rs.getString("TenTacGia"));
                de.setTenNN(rs.getString("TenNgonNGu"));
                de.setTenSach(rs.getString("TenSach"));
                de.setTenKhach(rs.getString("Hoten"));
                list.add(de);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;

    }

      public HDTraHangViewModel FindIDHdTra(Integer k) {
          String sql = "SELECT IDHoaDonTraHang,IDHoaDonBanHang,NgayDoiHang,HoaDonTraHang.IDKhachHang,totalReturn,MoTa,Hoten,Sdt\n" +
"FROM dbo.HoaDonTraHang JOIN dbo.KhachHang ON KhachHang.IdKhachHang = HoaDonTraHang.IDKhachHang WHERE IDHoaDonTraHang = ?";
          List<HDTraHangViewModel> list = new ArrayList<>();
           try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, k);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HDTraHangViewModel p = new HDTraHangViewModel();
                   p.setMaHoaDonTra(rs.getInt("IDHoaDonTraHang"));
                p.setMaHoaDonBan(rs.getInt("IDHoaDonBanHang"));
                p.setThoiGian(rs.getDate("NgayDoiHang"));
                p.setIdKhachHang(rs.getInt("IDKhachHang"));
                p.setTongTienHoanTra(rs.getFloat("totalReturn"));
                p.setGhiChu(rs.getString("MoTa"));
                p.setKhachHang(rs.getString("Hoten"));
                p.setSdt(rs.getInt("Sdt"));
                return p;
                // listHDNhap.add(i);
            }

        } catch (SQLException ex) {
            Logger.getLogger(NhapHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

      }
    
    public List<NhapHangViewModel> selectByIdInvoiceReturn(int id) {
        String sql = "SELECT HoaDonBan.IdHoaDonBan,CTHoaDonBan.IdCTSach,TenSach,SoLuong,TenNXB,TenTacGia,TenNgonNGu,DonGia,Hoten,KhachHang.IdKhachHang,ngayTao \n"
                + "FROM dbo.CTHoaDonBan \n"
                + "JOIN dbo.HoaDonBan ON HoaDonBan.IdHoaDonBan = CTHoaDonBan.IdHoaDonBan\n"
                + "JOIN dbo.KhachHang ON KhachHang.IdKhachHang = HoaDonBan.IdKhachHang\n"
                + "JOIN dbo.ChiTietSach ON ChiTietSach.IdCTSach = CTHoaDonBan.IdCTSach\n"
                + "JOIN dbo.Sach ON Sach.IdSach = ChiTietSach.IdSach\n"
                + "JOIN dbo.NXB ON NXB.IdNXB = ChiTietSach.IdNXB\n"
                + "JOIN dbo.TacGia ON TacGia.IdTacGia = ChiTietSach.IdTacGia\n"
                + "JOIN dbo.NgonNgu ON NgonNgu.IdNgonNgu = ChiTietSach.IdNgonNgu\n"
                + "WHERE CTHoaDonBan.IdHoaDonBan = ? AND SoLuong >0";
        List<NhapHangViewModel> list = new ArrayList<>();
        try {
            //st = db.getConnection().createStatement();
            pst = db.getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                NhapHangViewModel p = new NhapHangViewModel();
                p.setIdHoaDonBan(rs.getInt("IdHoaDonBan"));
                p.setIdchitietsach(rs.getInt("IdCTSach"));
                p.setGia(rs.getFloat("DonGia"));
                p.setSoluong(rs.getInt("SoLuong"));
                p.setTenNxb(rs.getString("TenNXB"));
                p.setTenNgonNgu(rs.getString("TenNgonNGu"));
                p.setTenTacGia(rs.getString("TenTacGia"));
                p.setTenSach(rs.getString("TenSach"));
                p.setTenKhachHang(rs.getString("Hoten"));
                p.setIdKhachHang(rs.getInt("IdKhachHang"));
                p.setNgaytao(rs.getString("ngayTao"));
                list.add(p);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DoiHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<HDBanViewModel> selectAllCheckVoucher() {
        String sql = "SELECT IdHoaDonBan ,HoaDonBan.IdKhachHang,HoaDonBan.IdUsers,IdVoucher,NGAYTHANHTOAN,GhiChu,statusPay,statusInvoice,\n"
                + "KhachHang.Hoten,Users.HoTen,TongTien,TienKhachDua,TienTraLai FROM dbo.HoaDonBan\n"
                + "JOIN dbo.Users ON Users.IdUsers = HoaDonBan.IdUsers\n"
                + "JOIN dbo.KhachHang ON KhachHang.IdKhachHang = HoaDonBan.IdKhachHang ORDER BY IdHoaDonBan DESC";
        List<HDBanViewModel> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HDBanViewModel i = new HDBanViewModel();
                i.setIdHoaDonBan(rs.getInt("IdHoaDonBan"));
                i.setIdKhachHang(rs.getInt("IdKhachHang"));
                i.setIdUsers(rs.getInt("IdUsers"));
                i.setIdVoucher(rs.getInt("IdVoucher"));
                i.setNGAYTHANHTOAN(rs.getString("NGAYTHANHTOAN"));
                i.setGhiChu(rs.getString("GhiChu"));
                i.setStatusPay(rs.getBoolean("statusPay"));
                i.setStatusInvoice(rs.getBoolean("statusInvoice"));
                i.setTenKhachHang(rs.getString("Hoten"));
                i.setTenUser(rs.getString("HoTen"));
                i.setTongTien(rs.getDouble("TongTien"));
                i.setTienKhachDua(rs.getDouble("TienKhachDua"));
                i.setTienTraLai(rs.getDouble("TienTraLai"));
                list.add(i);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HDTraHangViewModel> selectAllHDTra() {
        String sql = "SELECT * FROM dbo.HoaDonTraHang JOIN dbo.KhachHang ON KhachHang.IdKhachHang = HoaDonTraHang.IDKhachHang ORDER BY IDHoaDonTraHang DESC";
        List<HDTraHangViewModel> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HDTraHangViewModel p = new HDTraHangViewModel();
                p.setMaHoaDonTra(rs.getInt("IDHoaDonTraHang"));
                p.setMaHoaDonBan(rs.getInt("IDHoaDonBanHang"));
                p.setThoiGian(rs.getDate("NgayDoiHang"));
                p.setIdKhachHang(rs.getInt("IdKhachHang"));
                p.setTongTienHoanTra(rs.getFloat("totalReturn"));
                p.setGhiChu(rs.getString("MoTa"));
                p.setKhachHang(rs.getString("Hoten"));

                list.add(p);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HDDoiSPViewModel> selectAllHDDoi() {
        String sql = "SELECT IDHoaDonThayDoiSanPham,IDHoaDonBanHang,ngaytaohoadon,KhachHang.IdKhachHang,MoTa,Hoten,IdUsers FROM dbo.HoaDonThayDoiSanPham \n"
                + "JOIN dbo.KhachHang ON KhachHang.IdKhachHang = HoaDonThayDoiSanPham.IDKhachHang ORDER BY IDHoaDonThayDoiSanPham DESC";
        List<HDDoiSPViewModel> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HDDoiSPViewModel p = new HDDoiSPViewModel();
                p.setIDHoaDonDoiSanPham(rs.getInt("IDHoaDonThayDoiSanPham"));
                p.setIDHoaDonBanHang(rs.getInt("IDHoaDonBanHang"));
                p.setNgaytaoHDTra(rs.getString("ngaytaohoadon"));
                p.setIDKhachHang(rs.getInt("IdKhachHang"));
                p.setMoTa(rs.getString("MoTa"));
                p.setTenKhachHang(rs.getString("Hoten"));
                p.setIdUsers(rs.getInt("IdUsers"));

                list.add(p);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String insertHDTra(HDTraHangViewModel e) {
        try {
            String sql = "INSERT INTO dbo.HoaDonTraHang(IDKhachHang,IDUsers,IDHoaDonBanHang, MoTa,totalReturn,NgayDoiHang) VALUES (?,?,?,?,?,GETDATE())";
            pst = db.getConnection().prepareStatement(sql);
            pst.setInt(1, e.getIdKhachHang());
            pst.setInt(2, e.getIDUsers());
            pst.setInt(3, e.getMaHoaDonBan());
            pst.setString(4, e.getGhiChu());
            pst.setFloat(5, e.getTongTienHoanTra());
            pst.executeUpdate();
            return "Them HDTra thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Them HDTra khong thanh cong";
    }

    public String insertCTHDTra(CTHDTraHangViewModel e) {
        try {
        String sql = "INSERT INTO dbo.chitietHoaDonTraHang (IDHoaDonTraHang,IDChiTietSach,SoLuong, GIA) VALUES\n" +
"( (SELECT TOP 1 IDHoaDonTraHang FROM dbo.HoaDonTraHang ORDER BY IDHoaDonTraHang DESC),?,?,? )";
     pst = db.getConnection().prepareStatement(sql);
            // pst.setInt(1, cthdnsvm.getIDHoaDonNhapSanPham());
            pst.setInt(1, e.getIdCtSach());
            pst.setInt(2, e.getSoLuong());
            pst.setFloat(3, e.getTongTien());
            pst.executeUpdate();
            return "Them vao CTHDTra thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Them CTHDTra khong thanh cong";
    }
    public String updateSlgCTSach(Integer soluong, Integer id) {
        String sql = "UPDATE dbo.ChiTietSach SET SoLuongTon =SoLuongTon + ? WHERE IdCTSach = ?";
        
      try {
            pst = db.getConnection().prepareStatement(sql);

            pst.setInt(1, soluong);
            pst.setInt(2, id);
            pst.executeUpdate();
            return "sua slg thanh cong";
        } catch (Exception e) {

        }
        return "sua slg khong thanh cong";
    
    }
}
