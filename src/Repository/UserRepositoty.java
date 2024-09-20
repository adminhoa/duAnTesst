/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModel.Users;
import Utilities.DBConnection;
import Utilities.jdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class UserRepositoty {

    DBConnection db;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<Users> ListUsers = null;
    Users users = null;

    public UserRepositoty() {

    }

    

    public Users getLisUsers(int iduser) {
        String select = "SELECT * FROM dbo.Users WHERE IdUsers = '" + iduser + "'";

        try {

            st = db.getConnection().createStatement();
            rs = st.executeQuery(select);
            // ListUsers= new ArrayList<>();
            while (rs.next()) {
                users = new Users(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getFloat(8), rs.getBoolean(9), rs.getBoolean(10),rs.getString(11));
            }
            rs.close();
        } catch (Exception e) {
        }

        return users;
    }

    

}
