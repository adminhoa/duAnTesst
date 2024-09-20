/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.Sach;
import Repository.SachRepository;
import Services.SachService;
import Services.SachService;
import ViewModel.SachViewModel;
import ViewModel.sachMatHangViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class SachImpl implements SachService {

    private SachRepository rp = new SachRepository();

    @Override
    public List<SachViewModel> getAll() {
        return rp.getAll();
    }

    @Override
    public String inert(Sach s) {
        if (s.getMaSach().isEmpty() == true) {
            return "Ma sach trong";
        } else if (s.getTenSach().isEmpty() == true) {
            return "Ten sach trong";
        }
        boolean them = rp.them(s);
        if (them) {
            return "them sach thanh cong";
        } else {
            return "them sach that bai";
        }
    }

    @Override
    public List<Sach> getAllSach() {
        return rp.getAllSach();
    }

    @Override
    public String update(Sach s, String id) {
        boolean up = rp.update(s, id);
        if (up) {
            return "update thanh cong";
        }
        return "update that bai";
    }

    @Override
    public String delete(String id) {
        boolean de = rp.xoa(id);
        if (de) {
            return "xoa thanh cong";
        }
        return "xoa that bai";
    }

    @Override
    public List<SachViewModel> searchTen(String temp) {
        return rp.searchTen(temp);
    }

    @Override
    public sachMatHangViewModel selectByName(String name) {
        return rp.selectByName(name);
    }

    @Override
    public String update01(Sach s, int id) {
        boolean up = rp.sua(s, id);
        if (up) {
            return "update thanh cong";
        }
        return "update that bai";
    }

    @Override
    public List<SachViewModel> getNKD() {
        return rp.getListSachNgungKinhDoanh();
    }

    @Override
    public List<SachViewModel> getDKD() {
        return rp.getListSachDangKinhDoanh();

    }

}
