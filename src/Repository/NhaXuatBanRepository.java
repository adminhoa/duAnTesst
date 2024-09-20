/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.NhaXuatBan;
import Utilities.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sun.misc.Unsafe;
import java.sql.Connection;

/**
 *
 * @author ADMIN
 */
public class NhaXuatBanRepository {
    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<NhaXuatBan> ListNhaXuatBan = null;
NhaXuatBan nxb;
    public NhaXuatBanRepository() {
    }
    public List<NhaXuatBan> getlist (){
        String select = "SELECT * FROM dbo.NXB";
        ListNhaXuatBan = new ArrayList<>();
        try {
            st=db.getConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {                
                ListNhaXuatBan.add(new NhaXuatBan(rs.getInt(1), rs.getNString(2)));
            }
            rs.close();
        } catch (Exception e) {
        }
        return ListNhaXuatBan;
    }
    public String insert(NhaXuatBan nxb){
        String insert ="INSERT INTO dbo.NXB\n" +
"(\n" +
"    TenNXB\n" +
")\n" +
"VALUES(?)";
        try {
            pst = db.getConnection().prepareStatement(insert);
            pst.setNString(1, nxb.getNhaXuatBan());
           // System.out.println(ListNhaXuatBan.size());
           pst.executeUpdate();
            return "them thanh cong";
        } catch (Exception e) {
            
        }
        return "them khong thanh cong";
    }
    public String update(NhaXuatBan nxb){
        String update ="UPDATE dbo.NhaCungCap SET TenNhaCungCap = ? WHERE IdNhaCungCap = ?";
        try {
            pst = db.getConnection().prepareStatement(update);
            pst.setNString(1, nxb.getNhaXuatBan());
            pst.setInt(2, nxb.getId());
           // System.out.println(ListNhaXuatBan.size());
           pst.executeUpdate();
            return "sua thanh cong";
        } catch (Exception e) {
            
        }
        return "sua khong thanh cong";
    }
     public static void main(String[] args) {
        NhaXuatBanRepository a = new NhaXuatBanRepository();
        List<NhaXuatBan> lisnhaxuatban = a.getlist();
        for (NhaXuatBan nxb : lisnhaxuatban) {
            System.out.println(nxb);
        }
        
     }
//     public NhaXuatBan selectName (String name){
//         String sql = "SELECT * FROM dbo.NXB WHERE TenNXB = ?";
//         ListNhaXuatBan =new  ArrayList<>();
//         try {
////              st=db.getConnection().createStatement();
////            rs = st.executeQuery(sql);
//            pst = db.getConnection().prepareStatement(sql);
//           pst.setString(1, name);
//          pst.executeQuery();
//            while (rs.next()) {                
//                ListNhaXuatBan.add(new NhaXuatBan(rs.getInt(1), rs.getNString(2)));
//                
//            }
//            rs.close();
//         } catch (Exception e) {
//         }
//         return nxb;
//                 
//     }
     public NhaXuatBan selectName(String name) {
        String sql = "SELECT * FROM dbo.NXB WHERE TenNXB = ? ";
               
        ListNhaXuatBan = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
           if (rs.next()) {
                NhaXuatBan p = new NhaXuatBan();
                p.setId(rs.getInt("IdNXB"));
                p.setNhaXuatBan(rs.getString("TenNXB"));                
                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
