/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModel.CTDoiHDViewModel;
import ViewModel.CTDoiSPViewModel;
import ViewModel.HDDoiSPViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface HDDoiHangService {
     List<HDDoiSPViewModel> selectAllHDDoi(String Stringdate) ;
     
     List<CTDoiHDViewModel> selectByIdhdDoi(Integer k) ;
     
      List<CTDoiSPViewModel> selectByIdCTHDoi(Integer k) ;
      
      HDDoiSPViewModel FindHDD(int k) ;
}
