/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.Users;
import Repository.UserRepositoty;
import Services.UsersService;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class UsersImpl implements UsersService{
    UserRepositoty rep = new UserRepositoty();

    public UsersImpl() {
    }

    @Override
    public Users getUsers(int k) {
        return rep.getLisUsers(k);
    }

//    @Override
//    public String them(Users us) {
//        boolean t = rep.them(us);
//        if (t) {
//            return "them thanh cong";
//        }
//        return "them that bai";
//
//    }

//    @Override
//    public List<Users> getListnhanvien() {
//     return rep.getListnhanvien();
//    }

    @Override
    public List<Users> getListnhanvien() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

   

    

    
}
