/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.TaiKhoan;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface TaiKhoanService {
    public TaiKhoan gettaikhoan(String userName);
    TaiKhoan getdoimatkhau(Integer id);
    String update(TaiKhoan tk);
}
