/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.HoaDonBanHang;
import Repository.HoaDonBanHangRepository;
import Services.HoaDonBanHangService;

/**
 *
 * @author ADMIN
 */
public class HoaDonBanHangImpl implements HoaDonBanHangService{
   HoaDonBanHangRepository rep = new HoaDonBanHangRepository();

    public HoaDonBanHangImpl() {
    }
   
   
    @Override
    public String insert(HoaDonBanHang hdbh) {
     return rep.insert(hdbh);
    }


    
}
