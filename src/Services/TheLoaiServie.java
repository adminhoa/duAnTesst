/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.TheLoai;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface TheLoaiServie {
    List<TheLoai> getlistTheLoai();
    String inerts(TheLoai tl);
    String update(TheLoai tl,int id);
    TheLoai Select (String name);
}
