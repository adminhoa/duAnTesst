/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.ChiTietHoaDonBan;
import ViewModel.CTHDBanViewModel;
import ViewModel.HDBanViewModel;
import java.util.List;





/**
 *
 * @author ADMIN
 */
public interface ChiTietHoaDonService {
    String insert (ChiTietHoaDonBan cthd);
    
    List<HDBanViewModel> getAll(String Stringdate);
    
    List<CTHDBanViewModel> selectByIdBan(int id);
    
    HDBanViewModel FindHDB(int k) ;
    
   int ThoiGian(String Stringdate) ;
}
