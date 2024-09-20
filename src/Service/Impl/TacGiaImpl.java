/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.TacGia;
import Repository.TacGiaRepositiry;
import Services.TacGiaService;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class TacGiaImpl implements TacGiaService{
    TacGiaRepositiry rep = new TacGiaRepositiry();
    @Override
    public String insert(TacGia tg) {
       return  rep.insert(tg);
    }

    @Override
    public List<TacGia> getist() {
       return rep.getlistNTacGia();
    }

    @Override
    public String update(TacGia tg) {
       return rep.update(tg);
    }

    @Override
    public TacGia selectName(String name) {
       return rep.selectName(name);
    }
    
}
