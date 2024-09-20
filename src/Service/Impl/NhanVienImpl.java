/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.TaiKhoan;
import DomainModel.Users;
import Repository.NhanVienRepository;
import Services.NhanVienService;
import ViewModel.NhanVienViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */

public class NhanVienImpl implements NhanVienService{
    NhanVienRepository rep = new NhanVienRepository();
    
    @Override
    public List<Users> ListgetNhanVien() {
        return rep.getListnhanvien();
    }

    @Override
    public String themNhanVien(Users us) {
     boolean t = rep.them(us);
        if (t) {
            return "them thanh cong";
        }
        return "them that bai";
    }

    @Override
    public String ThemTaiKhoan(TaiKhoan tk) {
        return rep.insertTaiKhoan(tk);
    }

    @Override
    public String XoaNhanVien(int k) {
       return rep.Delete( k);
    }

    @Override
    public String SuaNhanVien(Users us) {
        return rep.updataNhanVien(us);
    }

    @Override
    public List<Users> ListgetNhanVienKhongLam() {
         return rep.getListnhanvienKhonglam();
    }

    @Override
    public List<Users> TimKiemTenNhanVien(String tim) {
       return (List<Users>) rep.searchTen(tim);
    }

    @Override
    public List<NhanVienViewModel> getAll() {
      return rep.getAll();
    }

    

   

    
    
}
