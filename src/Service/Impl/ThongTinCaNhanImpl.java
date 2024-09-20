/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.Users;
import Repository.ThongTinCaNhanRepository;
import Services.ThongTinCaNhanService;
import java.util.List;

/**
 *
 * @author ADMIN
 */

public class ThongTinCaNhanImpl implements ThongTinCaNhanService{
    ThongTinCaNhanRepository rep = new ThongTinCaNhanRepository();
    @Override
    public Users getlistUsers(Integer id) {
        return rep.getListusers(id);
    }

    @Override
    public String update(int id,Users us) {
        boolean update = rep.updateThongTin(id, us);
        if(update){
            return "Sửa Thông Tin Thành Công";
        }
        return "Sửa Thông Tin Thất Bai";
   
    }

    @Override
    public List<Users> getListThongTin() {
       return  rep.getListThongTin();
    }
    
}
