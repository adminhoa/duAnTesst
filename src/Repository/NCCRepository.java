/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.NCC;
import Utilities.DBConnection;
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
public class NCCRepository {

    DBConnection dbConnection;
   Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    List<NCC> list = null;

    public List<NCC> getAll() {
        String sql = "	SELECT * FROM dbo.NhaCungCap ORDER BY IdNhaCungCap DESC";
        try {
           // pst = db.getConnection().prepareStatement(sql);
            con = dbConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();

            while (rs.next()) {
                list.add(new NCC(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getString(4)));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean insert(NCC ncc) {
        int check = 0;
        try {
            String sql = "INSERT INTO dbo.NhaCungCap\n"
                    + "(TenNhaCungCap,\n"
                    + "    DIACHI,\n"
                    + "    SODIENTHOAI\n"
                    + "    )VALUES(  ?,?,?)";
            con = dbConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ncc.getTenNCC());
            ps.setObject(2, ncc.getDiaChi());
            ps.setObject(3, ncc.getSdt());
            check = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean update(String id, NCC ncc) {
        int check = 0;
        try {
            String sql = "UPDATE [dbo].[NhaCungCap]\n"
                    + "   SET [TenNhaCungCap] = ?\n"
                    + "      ,[DIACHI] = ?\n"
                    + "      ,[SODIENTHOAI] =?\n"
                    + " WHERE idnhacungcap =?";

            con = dbConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ncc.getTenNCC());
            ps.setObject(2, ncc.getDiaChi());
            ps.setObject(3, ncc.getSdt());
            ps.setObject(4, id);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public boolean delete(String id, NCC ncc) {
        int check = 0;
        try {
            String sql = "DELETE FROM [dbo].[NhaCungCap]\n"
                    + "      WHERE idnhacungcap = ?";
            con = dbConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NCCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check > 0;
    }

    public int getIndex(String ma) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTenNCC().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    public List<NCC> search(String temp) {
        List<NCC> listTemp = new ArrayList<>();
        for (NCC x : list) {
            if (x.getTenNCC().contains(temp)) {
                listTemp.add(x);
            }
        }
        return listTemp;
    }
//        public List<NCC> search(String temp) {
//        List<NCC> listTemp = new ArrayList<>();
//        for (NCC dongSP : list) {
//            if (dongSP.getTenNCC().equalsIgnoreCase(temp.toLowerCase())) {
//                listTemp.add(dongSP);
//            }
//        }
//        return listTemp;
//    }
    
    //private static List<Employee> sortList = new LinkedList<Employee>();
//      public <T> void searchInList(T search) {
//        sortList.clear();
//        for (Employee e : empList) {
//            if (e.toString().toLowerCase().contains(((String) search).toLowerCase())) {
//                sortList.add(e);
//            }
//        }
//    }
}
