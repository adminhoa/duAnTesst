/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.TaiKhoan;
import Repository.TaiKhoanRepository;
import Services.TaiKhoanService;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class TaiKhoanImpl implements TaiKhoanService{
    TaiKhoanRepository rep = new TaiKhoanRepository();
    public TaiKhoanImpl() {
    }

    @Override
    public TaiKhoan gettaikhoan(String userName) {
       return rep.getLisTaiKhoan(userName);
    }

  

    @Override
    public String update(TaiKhoan tk) {
       return rep.update(tk);
    }

    @Override
    public TaiKhoan getdoimatkhau(Integer id) {
        return rep.getLisdoimaykhau(id);
    }



    

 

    
    
    
}
