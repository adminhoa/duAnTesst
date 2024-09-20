/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Repository.HoaDonTraHangRepository;
import Services.HoaDonTraHangService;
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
public class HoaDonTraHangImpl implements HoaDonTraHangService{
private HoaDonTraHangRepository rp = new HoaDonTraHangRepository();

    @Override
    public List<HDTraHangViewModel> getAllTra() {
        return rp.getAllTra();
    }

//    @Override
//    public Float TongTien(Float idHDT) {
//        return rp.TongTien(idHDT);
//    }

    @Override
    public List<CTHDTraHangViewModel> selectByIdNhap(int id) {
        return rp.selectByIdNhap(id);
    }

    @Override
    public List<NhapHangViewModel> selectByIdInvoiceReturn(int id) {
        return rp.selectByIdInvoiceReturn(id);
    }

    @Override
    public List<HDBanViewModel> selectAllCheckVoucher() {
        return rp.selectAllCheckVoucher();
    }

    @Override
    public List<HDTraHangViewModel> selectAllHDTra() {
        return rp.selectAllHDTra();
    }

    @Override
    public List<HDDoiSPViewModel> selectAllHDDoi() {
        return rp.selectAllHDDoi();
    }

    @Override
    public String insertHDTra(HDTraHangViewModel e) {
        return rp.insertHDTra(e);
    }

    @Override
    public String insertCTHDTra(CTHDTraHangViewModel e) {
        return rp.insertCTHDTra(e);
    }

    @Override
    public String updateSlgCTSach(Integer soluong, Integer id) {
        return rp.updateSlgCTSach(soluong, id);
    }

    @Override
    public HDTraHangViewModel FindIDHdTra(Integer k) {
        return rp.FindIDHdTra(k);
    }
}
