/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.Sach;
import Utilities.DBConnection;
import Utilities.jdbcHelper;
import ViewModel.SachViewModel;
import ViewModel.sachMatHangViewModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author quanh
 */
public class SachRepository {
 DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<Sach> listSach = null;
    List<sachMatHangViewModel> listsachMatHang = null;
    
    public List<Sach> getAllSach() {
        String query = "select * from sach";
        List<Sach> listSach = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sach s = new Sach(rs.getInt(1), rs.getString(4), rs.getString(5), rs.getInt(2), rs.getInt(3), rs.getBoolean(6));
                listSach.add(s);
            }
            return listSach;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
     public List<SachViewModel> getListSachNgungKinhDoanh() {
        String select = "SELECT dbo.Sach.IdSach, dbo.Sach.MaSach, dbo.Sach.TenSach, dbo.TheLoai.TenTheLoai, dbo.NhaCungCap.TenNhaCungCap, dbo.Sach.TrangThai\n"
                + "FROM     dbo.NhaCungCap INNER JOIN\n"
                + "                  dbo.Sach ON dbo.NhaCungCap.IdNhaCungCap = dbo.Sach.IdNhaCungCap INNER JOIN\n"
                + "                  dbo.TheLoai ON dbo.Sach.Idtheloai = dbo.TheLoai.IdTheLoai WHERE dbo.Sach.TrangThai =0 ORDER BY dbo.Sach.TrangThai DESC";
        List<SachViewModel> listNKD = new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                listNKD.add(new SachViewModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6)));
            }
            rs.close();
        } catch (Exception e) {
        }
        return listNKD;
    }
      public List<SachViewModel> getListSachDangKinhDoanh() {
        String select = "SELECT dbo.Sach.IdSach, dbo.Sach.MaSach, dbo.Sach.TenSach, dbo.TheLoai.TenTheLoai, dbo.NhaCungCap.TenNhaCungCap, dbo.Sach.TrangThai\n"
                + "FROM     dbo.NhaCungCap INNER JOIN\n"
                + "                  dbo.Sach ON dbo.NhaCungCap.IdNhaCungCap = dbo.Sach.IdNhaCungCap INNER JOIN\n"
                + "                  dbo.TheLoai ON dbo.Sach.Idtheloai = dbo.TheLoai.IdTheLoai WHERE dbo.Sach.TrangThai =1 ORDER BY dbo.Sach.TrangThai DESC";
        List<SachViewModel> listNKD = new ArrayList<>();
        try {
            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                listNKD.add(new SachViewModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6)));
            }
            rs.close();
        } catch (Exception e) {
        }
        return listNKD;
    }
    public List<SachViewModel> getAll() {
        String query = "SELECT dbo.Sach.IdSach, dbo.Sach.MaSach, dbo.Sach.TenSach, dbo.TheLoai.TenTheLoai, dbo.NhaCungCap.TenNhaCungCap, dbo.Sach.TrangThai\n"
                + "FROM     dbo.NhaCungCap INNER JOIN\n"
                + "                  dbo.Sach ON dbo.NhaCungCap.IdNhaCungCap = dbo.Sach.IdNhaCungCap INNER JOIN\n"
                + "                  dbo.TheLoai ON dbo.Sach.Idtheloai = dbo.TheLoai.IdTheLoai ORDER BY IdSach DESC";
        List<SachViewModel> listSp = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SachViewModel spViewModel = new SachViewModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
                listSp.add(spViewModel);
            }
            return listSp;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
            public boolean sua(Sach s,int id) {
        String query = "UPDATE dbo.Sach SET TrangThai = (SELECT TRANGTHAI FROM dbo.TheLoai WHERE IdTheLoai = ?) WHERE Sach.Idtheloai = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, id);
            ps.setObject(2, id);
           
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
   
    
        public List<SachViewModel> searchTen(String temp) {
        String query = "SELECT dbo.Sach.IdSach, dbo.Sach.MaSach, dbo.Sach.TenSach, dbo.TheLoai.TenTheLoai, dbo.NhaCungCap.TenNhaCungCap, dbo.Sach.TrangThai\n"
                + "FROM     dbo.NhaCungCap INNER JOIN\n"
                + "                  dbo.Sach ON dbo.NhaCungCap.IdNhaCungCap = dbo.Sach.IdNhaCungCap INNER JOIN\n"
                + "                  dbo.TheLoai ON dbo.Sach.Idtheloai = dbo.TheLoai.IdTheLoai where Sach.TenSach like '%" + temp +"%' order by Sach.TenSach asc";
        List<SachViewModel> listSearch = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SachViewModel spViewModel = new SachViewModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
                listSearch.add(spViewModel);
            }
            return listSearch;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean update(Sach s, String id) {
        String query = "UPDATE [dbo].[Sach]\n"
                + "   SET \n"
                + "       [MaSach] = ?\n"
                + "      ,[TenSach] = ?\n"
                + "	 ,[Idtheloai] = ?\n"
                + "      ,[IdNhaCungCap] =?\n"
                + "      ,[TrangThai] = ?\n"
                + " WHERE IdSach = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, s.getMaSach());
            ps.setObject(2, s.getTenSach());
            ps.setObject(3, s.getIdTheLoai());
            ps.setObject(4, s.getIdNhaCungCap());
            ps.setObject(5, s.isTrangThai());
            ps.setObject(6, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean them(Sach s) {
        String query = "INSERT INTO [dbo].[Sach]\n"
                + "           (\n"
                + "		   [MaSach]\n"
                + "		   ,[TenSach]\n"
                + "           ,[Idtheloai]\n"
                + "		   ,[IdNhaCungCap]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {

            ps.setObject(1, s.getMaSach());
            ps.setObject(2, s.getTenSach());
            ps.setObject(3, s.getIdTheLoai());
            ps.setObject(4, s.getIdNhaCungCap());
            ps.setObject(5, s.isTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean xoa(String id) {
        int check = 0;
        String sql = "DELETE FROM [dbo].[Sach]\n"
                + "      WHERE IdSach = ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    public Sach selectName(String name) {
        String query = "SELECT IdSach,TenSach FROM dbo.Sach WHERE TenSach = ?";
        List<Sach> listSach = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sach s = new Sach(rs.getInt(1), rs.getString(2));
                listSach.add(s);
            }
            return (Sach) listSach;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
//    public Sach selectName01 (String name){
//         String sql = "SELECT * FROM dbo.Sach INNER JOIN dbo.TheLoai ON TheLoai.IdTheLoai = Sach.Idtheloai WHERE TenSach = ?";
//         listSach =new  ArrayList<>();
//         try {
////              st=db.getConnection().createStatement();
////            rs = st.executeQuery(sql);
//            pst = db.getConnection().prepareStatement(sql);
//           pst.setString(1, name);
//       pst.executeQuery();
//            while (rs.next()) {                
//                listSach.add(new Sach(rs.getInt(1), rs.getString(4), rs.getString(5), rs.getInt(2), rs.getInt(3), rs.getBoolean(6)));
//                
//            }
//            rs.close();
//         } catch (Exception e) {
//         }
//         return null;
//                 
//     }

   public sachMatHangViewModel selectByName(String name) {
        String sql = "SELECT * FROM dbo.Sach INNER JOIN dbo.TheLoai ON TheLoai.IdTheLoai = Sach.Idtheloai WHERE TenSach = ?";
               
        listsachMatHang = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
           if (rs.next()) {
                sachMatHangViewModel p = new sachMatHangViewModel();
                p.setIdsach(rs.getInt("IdSach"));
                p.setTenSach(rs.getString("TenSach"));
                p.setMaSach(rs.getString("MaSach"));
                p.setIdtheloai(rs.getInt("Idtheloai"));
                p.setTenTheLoai(rs.getString("TenTheLoai"));
                p.setTrangThai(rs.getBoolean("TrangThai"));
                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
