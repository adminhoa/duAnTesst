/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModel.CTDoiHDViewModel;
import ViewModel.CTDoiSPViewModel;
import ViewModel.HDBanViewModel;
import ViewModel.HDDoiSPViewModel;
import ViewModel.HDTraHangViewModel;
import ViewModel.NhapHangViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface DoiHangService {
    NhapHangViewModel selectById(Integer k);
    
    String updateSoLg(Integer soluong, Integer id);
    
    List<NhapHangViewModel> selectByIdHDTra(int id);
    
    List<NhapHangViewModel> selectByGia(float gia,int idSach);
    
    String insertHDDoi(HDDoiSPViewModel cts);
    
    String insertCTDoiHD(CTDoiHDViewModel e);
    
    List<CTDoiHDViewModel> selectAllCTDoiHD();
    
    String insertCTDoiSp(CTDoiSPViewModel cts);
    
    List<HDDoiSPViewModel> selectAllHDDoiSP();
    
    List<HDBanViewModel> selectAllHDBan();
    
    List<HDTraHangViewModel> selectAllHDTra();
}

