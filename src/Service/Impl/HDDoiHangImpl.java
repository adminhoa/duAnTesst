/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Repository.HoaDonDoiHangRepository;
import Services.HDDoiHangService;
import ViewModel.CTDoiHDViewModel;
import ViewModel.CTDoiSPViewModel;
import ViewModel.HDDoiSPViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HDDoiHangImpl implements HDDoiHangService{
    HoaDonDoiHangRepository repository = new HoaDonDoiHangRepository();
    
    @Override
    public List<HDDoiSPViewModel> selectAllHDDoi(String Stringdate) {
        return repository.selectAllHDDoi(Stringdate);
    }

    @Override
    public List<CTDoiHDViewModel> selectByIdhdDoi(Integer k) {
        return repository.selectByIdhdDoi(k);
    }

    @Override
    public List<CTDoiSPViewModel> selectByIdCTHDoi(Integer k) {
        return repository.selectByIdCTHDoi(k);
    }

    @Override
    public HDDoiSPViewModel FindHDD(int k) {
        return repository.FindHDD(k);
    }
    
}
