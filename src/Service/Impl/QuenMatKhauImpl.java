/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Repository.QuenMatKhauRepository;
import Services.QuenMatKhauService;
import ViewModel.NhanVienViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class QuenMatKhauImpl implements QuenMatKhauService{
    QuenMatKhauRepository rep = new QuenMatKhauRepository();
    public QuenMatKhauImpl() {
    }

    @Override
    public List<NhanVienViewModel> Getlist() {
       return rep.getAll();
    }

    @Override
    public String Update(NhanVienViewModel nv) {
        return rep.update(nv);
    }
    
}
