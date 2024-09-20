
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.NgonNgu;
import Repository.NgonNguRepository;
import Services.NgonNguService;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NgonNguImpl implements NgonNguService{
    NgonNguRepository rep = new NgonNguRepository();
    @Override
    public String insert(NgonNgu nn) {
        return rep.insert(nn);
    }

    @Override
    public List<NgonNgu> getList() {
     return rep.getlistNgon();
    }

    @Override
    public String update(NgonNgu nn) {
        return rep.update(nn);
    }

    @Override
    public NgonNgu selectName(String name) {
       return rep.selectName(name);
       
    }
    
}
