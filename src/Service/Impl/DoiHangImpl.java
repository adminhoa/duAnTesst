/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Repository.DoiHangRepository;
import Services.DoiHangService;
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
public class DoiHangImpl implements DoiHangService{
    DoiHangRepository repository = new DoiHangRepository();
    @Override
    public NhapHangViewModel selectById(Integer k) {
        return repository.selectById(k);
    }

    @Override
    public String updateSoLg(Integer soluong, Integer id) {
        return repository.updateSoLg(soluong, id);
    }

    @Override
    public List<NhapHangViewModel> selectByIdHDTra(int id) {
        return repository.selectByIdHDTra(id);
    }

    @Override
    public List<NhapHangViewModel> selectByGia(float gia, int idSach) {
        return repository.selectByGia(gia, idSach);
    }

    @Override
    public String insertHDDoi(HDDoiSPViewModel cts) {
        return repository.insertHDDoi(cts);
    }

    @Override
    public String insertCTDoiHD(CTDoiHDViewModel e) {
        return repository.insertCTDoiHD(e);
    }

    @Override
    public List<CTDoiHDViewModel> selectAllCTDoiHD() {
        return repository.selectAllCTDoiHD();
    }

    @Override
    public String insertCTDoiSp(CTDoiSPViewModel cts) {
        return repository.insertCTDoiSp(cts);
    }

    @Override
    public List<HDDoiSPViewModel> selectAllHDDoiSP() {
        return repository.selectAllHDDoiSP();
    }

    @Override
    public List<HDBanViewModel> selectAllHDBan() {
        return repository.selectAllHDBan();
    }

    @Override
    public List<HDTraHangViewModel> selectAllHDTra() {
        return repository.selectAllHDTra();
    }
    
}
