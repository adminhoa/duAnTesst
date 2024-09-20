/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.ChiTietHoaDonBan;
import Repository.ChiTietHoaDonRepository;
import Repository.HoaDonBanHangRepository;
import Services.ChiTietHoaDonService;
import ViewModel.CTHDBanViewModel;
import ViewModel.HDBanViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ChiTietHoaDonImpl implements ChiTietHoaDonService{
    ChiTietHoaDonRepository rep = new ChiTietHoaDonRepository();
    HoaDonBanHangRepository rep1 =new HoaDonBanHangRepository();
    @Override
    public String insert(ChiTietHoaDonBan cthd) {
        return rep.insert(cthd);
    }

    @Override
    public List<HDBanViewModel> getAll(String Stringdate) {
        return rep.getAll(Stringdate);
    }

    @Override
    public List<CTHDBanViewModel> selectByIdBan(int id) {
        return rep.selectByIdBan(id);
    }
    
        @Override
    public  HDBanViewModel FindHDB(int k) {
        return rep1.FindHDB(k);
    }

    @Override
    public int ThoiGian(String Stringdate) {
        return rep.ThoiGian(Stringdate);
    }
}
