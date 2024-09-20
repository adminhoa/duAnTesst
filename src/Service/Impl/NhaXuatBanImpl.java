/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.NhaXuatBan;
import Repository.NhaXuatBanRepository;
import Services.NhaXuatBanService;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhaXuatBanImpl implements NhaXuatBanService{
    NhaXuatBanRepository rep = new NhaXuatBanRepository();
    
    @Override
    public List<NhaXuatBan> getlist() {
     return rep.getlist();
    }

    @Override
    public String insert(NhaXuatBan nxb) {
       return rep.insert(nxb);
    }

    @Override
    public String update(NhaXuatBan nxb) {
        return rep.update(nxb);
    }

    @Override
    public NhaXuatBan Select(String name) {
       return rep.selectName(name);
    }

    

   

    
    
}
