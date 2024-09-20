/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModel.CTHDNhapSpViewModel;
import ViewModel.HDNhapSPViewModel;
import ViewModel.NhapHangViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface NhapHangService {

    List<NhapHangViewModel> getAll();

    List<NhapHangViewModel> searchTenSach(String temp);
    
    String insertHDN(HDNhapSPViewModel hdnspvm) ;
    
    String insertHDCT(CTHDNhapSpViewModel cthdnsvm) ;
    
    String updateCTSP(Integer slg,Float giaNhap ,Integer id);
    
    NhapHangViewModel searchID(int id);
    
    List<HDNhapSPViewModel> getAllHDNhap();
    
    Float TongTien(Integer idHDN);
    
    List<CTHDNhapSpViewModel> selectByIdNhap(int id);
    
   HDNhapSPViewModel FindHDN(int k);
}
