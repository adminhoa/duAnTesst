/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Utilities.DBConnection;
import ViewModel.CTDoiHDViewModel;
import ViewModel.CTDoiSPViewModel;
import ViewModel.HDBanViewModel;
import ViewModel.HDDoiSPViewModel;
import ViewModel.HDTraHangViewModel;
import ViewModel.NhapHangViewModel;
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
public class DoiHangRepository {

    List<NhapHangViewModel> listNhapVMD = null;
    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;

    public NhapHangViewModel selectById(Integer k) {
        String sql = "SELECT D.IdCTSach,D.IdSach,D.IdNXB,D.IdTacGia,D.IdNgonNgu,D.GiaBan,D.SoLuongTon,D.TrangThai, P.TenSach,S.TenNXB,C.TenNgonNGu,M.TenTacGia,L.TenTheLoai \n"
                + "FROM dbo.ChiTietSach D\n"
                + "INNER JOIN dbo.NXB S ON S.IdNXB = D.IdNXB\n"
                + "INNER JOIN dbo.TacGia M ON M.IdTacGia = D.IdTacGia\n"
                + "INNER JOIN dbo.NgonNgu C ON C.IdNgonNgu = D.IdNgonNgu\n"
                + "INNER JOIN dbo.Sach P ON P.IdSach = D.IdSach\n"
                + "INNER JOIN dbo.TheLoai L ON L.IdTheLoai = P.Idtheloai\n"
                + "WHERE D.IdCTSach = ?";
        listNhapVMD = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, k);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                NhapHangViewModel p = new NhapHangViewModel();
                p.setIdchitietsach(rs.getInt("IdCTSach"));
                p.setIdsach(rs.getInt("IdSach"));
                p.setIsNXB(rs.getInt("IdNXB"));
                p.setIdTacGia(rs.getInt("IdTacGia"));
                p.setIdNgonNgu(rs.getInt("IdNgonNgu"));
                p.setGia(rs.getFloat("GiaBan"));
                p.setSoluong(rs.getInt("SoLuongTon"));
                p.setTrangThai(rs.getBoolean("TrangThai"));
                p.setTenNxb(rs.getString("TenNXB"));
                p.setTenTacGia(rs.getString("TenTacGia"));
                p.setTenNgonNgu(rs.getString("TenNgonNGu"));
                p.setTenSach(rs.getString("TenSach"));
                p.setTenTheLoai(rs.getString("TenTheLoai"));
                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public String updateSoLg(Integer soluong, Integer id) {
        String sql = "UPDATE [dbo].[ChiTietSach] SET [SoLuongTon] = ? WHERE IdCTSach = ?";
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

    public List<NhapHangViewModel> selectByIdHDTra(int id) {
        String sql = "SELECT I.IdHoaDonBan,E.IdCTSach,P.TenSach,E.SoLuong,S.TenNXB,M.TenNgonNGu,A.TenTacGia, E.DonGia,C.Hoten,C.IdKhachHang,I.ngayTao\n"
                + "FROM dbo.CTHoaDonBan E\n"
                + "JOIN dbo.HoaDonBan I ON I.IdHoaDonBan = E.IdHoaDonBan\n"
                + "JOIN dbo.KhachHang C ON C.IdKhachHang = I.IdKhachHang\n"
                + "JOIN dbo.ChiTietSach D ON D.IdCTSach = E.IdCTSach\n"
                + "JOIN dbo.Sach P ON P.IdSach = D.IdSach\n"
                + "JOIN dbo.NXB S ON S.IdNXB = D.IdNXB\n"
                + "JOIN dbo.NgonNgu M ON M.IdNgonNgu = D.IdNgonNgu\n"
                + "JOIN dbo.TacGia A ON A.IdTacGia = D.IdTacGia\n"
                + "WHERE E.IdHoaDonBan = ? AND E.SoLuong > 0";

        try {
            //st = db.getConnection().createStatement();
            pst = db.getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            listNhapVMD = new ArrayList<>();
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
                listNhapVMD.add(p);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DoiHangRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNhapVMD;
    }

    ////////*************************
    public List<NhapHangViewModel> selectByGia(float gia, int idSach) {
        String sql = "SELECT D.IdCTSach,D.IdSach,D.IdNXB,D.IdTacGia,D.IdNgonNgu,D.GiaBan,D.SoLuongTon,D.TrangThai, P.TenSach,S.TenNXB,C.TenNgonNGu,M.TenTacGia,L.TenTheLoai \n"
                + "FROM dbo.ChiTietSach D\n"
                + "INNER JOIN dbo.NXB S ON S.IdNXB = D.IdNXB\n"
                + "INNER JOIN dbo.TacGia M ON M.IdTacGia = D.IdTacGia\n"
                + "INNER JOIN dbo.NgonNgu C ON C.IdNgonNgu = D.IdNgonNgu\n"
                + "INNER JOIN dbo.Sach P ON P.IdSach = D.IdSach\n"
                + "INNER JOIN dbo.TheLoai L ON L.IdTheLoai = P.Idtheloai\n"
                + "where d.GiaBan <= ? and D.IdCTSach not in (?) and P.TrangThai = 1 and D.SoLuongTon > 0 ";
        try {
            //st = db.getConnection().createStatement();
            pst = db.getConnection().prepareStatement(sql);
            pst.setFloat(1, gia);
            pst.setInt(2, idSach);

            rs = pst.executeQuery();
            listNhapVMD = new ArrayList<>();
            while (rs.next()) {
                NhapHangViewModel p = new NhapHangViewModel();
                p.setIdchitietsach(rs.getInt("IdCTSach"));
                p.setIdsach(rs.getInt("IdSach"));
                p.setIsNXB(rs.getInt("IdNXB"));
                p.setIdTacGia(rs.getInt("IdTacGia"));
                p.setIdNgonNgu(rs.getInt("IdNgonNgu"));
                p.setGia(rs.getFloat("GiaBan"));
                p.setSoluong(rs.getInt("SoLuongTon"));
                p.setTrangThai(rs.getBoolean("TrangThai"));
                p.setTenNxb(rs.getString("TenNXB"));
                p.setTenTacGia(rs.getString("TenTacGia"));
                p.setTenNgonNgu(rs.getString("TenNgonNGu"));
                p.setTenSach(rs.getString("TenSach"));
                p.setTenTheLoai(rs.getString("TenTheLoai"));
                listNhapVMD.add(p);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNhapVMD;
    }
//            public static void main(String[] args) {
//        DoiHangRepository i = new DoiHangRepository();
//           List<NhapHangViewModel> list  = i.selectByGia(40000, 1);
//           for (NhapHangViewModel nhanVienViewModel : list) {
//               System.out.println(nhanVienViewModel.toString());
//        }
//    }

    public String insertHDDoi(HDDoiSPViewModel cts) {
        String insert = "INSERT INTO dbo.HoaDonThayDoiSanPham(IdUsers,IDKhachHang,IDHoaDonBanHang,MoTa,ngaytaohoadon)VALUES(?,?,?,?,GETDATE())";
        try {
            pst = db.getConnection().prepareStatement(insert);
            pst.setInt(1, cts.getIdUsers());
            pst.setInt(2, cts.getIDKhachHang());
            pst.setInt(3, cts.getIDHoaDonBanHang());
           // pst.setString(4, cts.getNgaytaoHDTra());
            pst.setString(4, cts.getMoTa());
            pst.executeUpdate();
            return "them hddoi thanh cong";
        } catch (Exception e) {

        }
        return "Them hddoi khong thanh cong";
    }

    public String insertCTDoiHD(CTDoiHDViewModel e) {

        try {
            String sql = "INSERT INTO dbo.ChiTietThayDoiHoaDon(IDHoaDonThayDoiSanPham,IDChiTietSach,SoLuong) VALUES\n"
                    + "((SELECT TOP 1 IDHoaDonThayDoiSanPham FROM dbo.HoaDonThayDoiSanPham ORDER BY IDHoaDonThayDoiSanPham DESC ), ?,?)";
            pst = db.getConnection().prepareStatement(sql);
            // pst.setInt(1, cthdnsvm.getIDHoaDonNhapSanPham());
            pst.setInt(1, e.getIdCTSach());
            pst.setInt(2, e.getSoLuong());
            pst.executeUpdate();
            return "Them vao CTDoiHD thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Them CTDoiHD khong thanh cong";
    }

    public List<CTDoiHDViewModel> selectAllCTDoiHD() {
        String sql = "SELECT * FROM dbo.ChiTietThayDoiHoaDon De\n"
                + "JOIN dbo.HoaDonThayDoiSanPham I ON I.IDHoaDonThayDoiSanPham = De.IDHoaDonThayDoiSanPham\n"
                + "INNER JOIN dbo.ChiTietSach D ON D.IdCTSach = De.IDChiTietSach\n"
                + "INNER JOIN dbo.NXB S ON S.IdNXB = D.IdNXB\n"
                + "INNER JOIN dbo.TacGia M ON M.IdTacGia = D.IdTacGia\n"
                + "INNER JOIN dbo.NgonNgu C ON C.IdNgonNgu = D.IdNgonNgu\n"
                + "INNER JOIN dbo.Sach P ON P.IdSach = D.IdSach";
        List<CTDoiHDViewModel> cTDoi = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CTDoiHDViewModel de = new CTDoiHDViewModel();
                de.setIdHDDoi(rs.getInt("IDHoaDonThayDoiSanPham"));
                de.setSoLuong(rs.getInt("SoLuong"));
                de.setGia(rs.getInt("GiaBan"));
                de.setTenNXB(rs.getString("TenNXB"));
                de.setTenTacGia(rs.getString("TenTacGia"));
                de.setTenNgonNgu(rs.getString("TenNgonNGu"));
                de.setIdCTDoiHD(rs.getInt("IDChiTietThayDoiHoaDon"));
                de.setIdCTSach(rs.getInt("IdCTSach"));
                de.setTenSach(rs.getString("TenSach"));
                cTDoi.add(de);
            }
            return cTDoi;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public String insertCTDoiSp(CTDoiSPViewModel cts) {
        String insert = "INSERT INTO dbo.ChiTietThayDoiSanPham(IDChiTietThayDoiHoaDon,IDChiTietSach,SoLuong)\n" +
"VALUES((SELECT TOP 1 IDChiTietThayDoiHoaDon FROM dbo.ChiTietThayDoiHoaDon ORDER BY IDChiTietThayDoiHoaDon DESC),?,?)";
        try {
            pst = db.getConnection().prepareStatement(insert);
            pst.setInt(1, cts.getIdCTSach());
            pst.setInt(2, cts.getSoLuong());
            pst.executeUpdate();
            return "them CTDoiSp thanh cong";
        } catch (Exception e) {

        }
        return "Them CTDoiSp khong thanh cong";
    }

      public List<HDDoiSPViewModel> selectAllHDDoiSP() {
          String sql = "SELECT * FROM dbo.HoaDonThayDoiSanPham JOIN dbo.KhachHang ON KhachHang.IdKhachHang = HoaDonThayDoiSanPham.IDKhachHang \n" +
"ORDER BY IDHoaDonThayDoiSanPham DESC ";
            List<HDDoiSPViewModel> listHDDoisp = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HDDoiSPViewModel p = new HDDoiSPViewModel();
                p.setIDHoaDonDoiSanPham(rs.getInt("IDHoaDonThayDoiSanPham"));
                p.setIDHoaDonBanHang(rs.getInt("IDHoaDonBanHang"));
                p.setNgaytaoHDTra(rs.getString("ngaytaohoadon"));
                p.setIDKhachHang(rs.getInt("IDKhachHang"));
                p.setMoTa(rs.getString("MoTa"));
                p.setTenKhachHang(rs.getString("Hoten"));
                p.setIdUsers(rs.getInt("IdUsers"));
                listHDDoisp.add(p);
            }
            return listHDDoisp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
      }
      
       public List<HDBanViewModel> selectAllHDBan() {
          String sql = "SELECT IdHoaDonBan,HoaDonBan.IdKhachHang,HoaDonBan.IdUsers,IdVoucher,NGAYTHANHTOAN,\n" +
"GhiChu,statusPay,statusInvoice,TENKhachHang,Users.HoTen,TongTien,TienKhachDua,TienTraLai \n" +
"FROM dbo.HoaDonBan JOIN dbo.Users ON Users.IdUsers = HoaDonBan.IdUsers\n" +
"JOIN dbo.KhachHang ON KhachHang.IdKhachHang = HoaDonBan.IdKhachHang ORDER BY IdHoaDonBan DESC ";
            List<HDBanViewModel> listHDBsp = new ArrayList<>();
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
                i.setTenKhachHang(rs.getString("TENKhachHang"));
                i.setTenUser(rs.getString("HoTen"));
                i.setTongTien(rs.getDouble("TongTien"));
                i.setTienKhachDua(rs.getDouble("TienKhachDua"));
                i.setTienTraLai(rs.getDouble("TienTraLai"));
                listHDBsp.add(i);
            }
            return listHDBsp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
      }
      
       
       
       public List<HDTraHangViewModel> selectAllHDTra() {
           String sql = "SELECT IDHoaDonTraHang,IDHoaDonBanHang,NgayDoiHang,HoaDonTraHang.IDKhachHang,totalReturn,MoTa,Hoten \n" +
"FROM dbo.HoaDonTraHang JOIN dbo.KhachHang ON KhachHang.IdKhachHang = HoaDonTraHang.IDKhachHang ORDER BY IDHoaDonTraHang DESC";
            List<HDTraHangViewModel> listHDTvmd = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                  HDTraHangViewModel p = new HDTraHangViewModel();
                p.setMaHoaDonTra(rs.getInt("IDHoaDonTraHang"));
                p.setMaHoaDonBan(rs.getInt("IDHoaDonBanHang"));
                p.setThoiGian(rs.getDate("NgayDoiHang"));
                p.setIdKhachHang(rs.getInt("IDKhachHang"));
                p.setTongTienHoanTra(rs.getFloat("totalReturn"));
                p.setGhiChu(rs.getString("MoTa"));
                p.setKhachHang(rs.getString("Hoten"));

                listHDTvmd.add(p);
            }
            return listHDTvmd;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
       }
}
