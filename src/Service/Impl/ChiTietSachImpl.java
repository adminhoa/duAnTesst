/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.ChiTietSach;
import Repository.ChiTietSachRepository;
import Services.ChiTietSachService;
import ViewModel.BanHangViewModel;
import ViewModel.MatHang01;
import ViewModel.MatHangViewModel;
import ViewModel.NhapHangViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ChiTietSachImpl implements ChiTietSachService{
    ChiTietSachRepository rep = new ChiTietSachRepository();
    
    public ChiTietSachImpl() {
    }

    

    @Override
    public List<MatHangViewModel> getlist() {
        return rep.getListchitietsp();
    }

    @Override
    public String insert(MatHangViewModel cts) {
       return rep.insert(cts);
    }

    @Override
    public List<MatHang01> getlistConHang() {
        return rep.getListConHang();
    }

    @Override
    public List<MatHang01> getlistHetHang() {
        return rep.getListHetHang();
    }

    @Override
    public List<MatHang01> getlistThapToiCao() {
        return rep.getListThapToiCao();
    }

    @Override
    public List<MatHang01> getlistCaoToiThap() {
        return rep.getListTuCaoToiThap();
    }

    @Override
    public List<MatHang01> getlistDangKinhDoanh() {
       return rep.getListDangKinhDoanh();
    }

    @Override
    public List<MatHang01> getlistNgungKinhDoanh() {
       return rep.getListNgungKinhDoanh();
    }

    @Override
    public String update(MatHangViewModel cts) {
      return rep.update(cts);
    }


    @Override
    public List<BanHangViewModel> getlistBanHang() {
      return rep.getListBanHang();
    }

    @Override
    public String updateSoLuongTon(Integer SoLuong, Integer ID) {
       return rep.updateSoLuongTon(SoLuong, ID);
    }

    @Override
    public BanHangViewModel TimKiemmSach(String tim) {
       return rep.TimKiemSach(tim);
    }

    @Override
    public List<MatHangViewModel> timkiemtheoma(String tim) {
       return rep.search(tim);
    }

    @Override
    public List<BanHangViewModel> timkiemtheomaBanHang(String tim) {
       return rep.search01(tim);
    }

    

    

    
    

    
    

   
}
