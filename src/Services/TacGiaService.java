/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.TacGia;
import java.util.List;
import javax.print.DocFlavor;

/**
 *
 * @author ADMIN
 */
public interface TacGiaService {
    List<TacGia> getist();
    String insert (TacGia tg);
    String update (TacGia tg);
    TacGia selectName(String name);
}
