/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModel.NCC;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface NCCService {
List<NCC> getAll() ;
    String insert(NCC ncc);
    String update(String id, NCC ncc);
    String delete(String id,NCC ncc);
    List<NCC> search(String temp);
}
