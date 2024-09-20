/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.TaiKhoan;
import DomainModel.Users;
import ViewModel.NhanVienViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface NhanVienService {
    List<Users> ListgetNhanVien(); 
    List<Users> ListgetNhanVienKhongLam();
    String themNhanVien(Users us);
    String ThemTaiKhoan(TaiKhoan tk);
    String XoaNhanVien(int k);
    String SuaNhanVien(Users us);
    List<Users> TimKiemTenNhanVien(String tim);
    List<NhanVienViewModel> getAll();
}
