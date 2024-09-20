/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.NhaXuatBan;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface NhaXuatBanService {
    List<NhaXuatBan> getlist();
    String insert(NhaXuatBan nxb);
    String update(NhaXuatBan nxb);
    NhaXuatBan Select(String name);
}
