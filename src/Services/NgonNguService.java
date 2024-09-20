/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.NgonNgu;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface NgonNguService {
    List<NgonNgu> getList();
    String insert(NgonNgu nn);
    String update(NgonNgu nn);
    NgonNgu selectName(String name);
}
