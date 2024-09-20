/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Repository.NhapHangRepository;
import Services.NhapHangService;
import ViewModel.CTHDNhapSpViewModel;
import ViewModel.HDNhapSPViewModel;
import ViewModel.NhapHangViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhapHangImpl implements NhapHangService {

    NhapHangRepository rep = new NhapHangRepository();

    @Override
    public List<NhapHangViewModel> getAll() {
        return rep.getAll();
    }

    @Override
    public List<NhapHangViewModel> searchTenSach(String temp) {
        return rep.searchTenSach(temp);
    }

    @Override
    public String insertHDN(HDNhapSPViewModel hdnspvm) {
        return rep.insertHDN(hdnspvm);
    }

    @Override
    public String insertHDCT(CTHDNhapSpViewModel cthdnsvm) {
        return rep.insertHDCT(cthdnsvm);
    }

    @Override
    public String updateCTSP(Integer slg, Float giaNhap, Integer id) {
        return rep.updateCTSP(slg, giaNhap, id);
    }

    @Override
    public NhapHangViewModel searchID(int id) {
        return rep.searchID(id);
    }

    @Override
    public List<HDNhapSPViewModel> getAllHDNhap() {
        return rep.getAllHDNhap();
    }

    @Override
    public Float TongTien(Integer idHDN) {
        return rep.TongTien(idHDN);
    }

    @Override
    public List<CTHDNhapSpViewModel> selectByIdNhap(int id) {
        return rep.selectByIdNhap(id);
    }

    @Override
    public HDNhapSPViewModel FindHDN(int k){
        return rep.FindHDN(k);
    }

}
