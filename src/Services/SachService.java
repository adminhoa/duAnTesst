/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.Sach;
import ViewModel.SachViewModel;
import ViewModel.sachMatHangViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface SachService {
    List<SachViewModel> getAll();
    List<Sach> getAllSach();
    String inert(Sach s);
    String update(Sach s , String id);
    String delete(String id);
    List<SachViewModel> searchTen(String temp);
    sachMatHangViewModel selectByName(String name);
    String update01(Sach s , int id);
    List<SachViewModel> getNKD();
    List<SachViewModel> getDKD();
    
}
