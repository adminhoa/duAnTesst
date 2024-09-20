/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModel.CTHDTraHangViewModel;
import ViewModel.HDBanViewModel;
import ViewModel.HDDoiSPViewModel;
import ViewModel.HDTraHangViewModel;
import ViewModel.NhapHangViewModel;
import java.util.List;

/**
 *
 * @author quanh
 */
public interface HoaDonTraHangService {
    List<HDTraHangViewModel> getAllTra();
   // Float TongTien(Float idHDT);
    List<CTHDTraHangViewModel> selectByIdNhap(int id);
    
    List<NhapHangViewModel> selectByIdInvoiceReturn(int id);
    
    List<HDBanViewModel> selectAllCheckVoucher();
    
    List<HDTraHangViewModel> selectAllHDTra();
    
    List<HDDoiSPViewModel> selectAllHDDoi();
    
    String insertHDTra(HDTraHangViewModel e);
    
    String insertCTHDTra(CTHDTraHangViewModel e);
    
    String updateSlgCTSach(Integer soluong, Integer id) ;
    
    HDTraHangViewModel FindIDHdTra(Integer k);
}
