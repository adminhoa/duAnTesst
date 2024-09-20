/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.ChiTietSach;
import ViewModel.BanHangViewModel;
import ViewModel.MatHang01;
import ViewModel.MatHangViewModel;
import ViewModel.NhapHangViewModel;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ChiTietSachService {
    List<MatHangViewModel> getlist ();
    String insert(MatHangViewModel cts);
    List<MatHang01> getlistConHang();
    List<MatHang01> getlistHetHang();
    List<MatHang01> getlistThapToiCao();
    List<MatHang01> getlistCaoToiThap();
    List<MatHang01> getlistDangKinhDoanh();
    List<MatHang01> getlistNgungKinhDoanh();
    String update(MatHangViewModel cts);
    List<BanHangViewModel> getlistBanHang ();
    String updateSoLuongTon(Integer SoLuong, Integer ID);
    BanHangViewModel TimKiemmSach(String tim);
    List<MatHangViewModel> timkiemtheoma (String tim);
     List<BanHangViewModel> timkiemtheomaBanHang (String tim);
}
