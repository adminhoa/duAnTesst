/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import DomainModel.NCC;
import Repository.NCCRepository;
import Services.NCCService;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NCCServiceImpl implements NCCService {

    NCCRepository repository = new NCCRepository();

    @Override
    public List<NCC> getAll() {
        return repository.getAll();
    }

    @Override
    public String insert(NCC ncc) {
        boolean add = repository.insert(ncc);
        if (add) {
            return "Thêm thành công";
        } else if (repository.getIndex(ncc.getTenNCC()) != -1) {
            return "trung ma r";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(String id, NCC ncc) {
        boolean update = repository.update(id, ncc);
        if (update) {
            return "Sửa thành công id : " + id;
        } else if (repository.getIndex(ncc.getTenNCC()) == -1) {
            return "ko tim thay ten trong csdl";
        }
        return "Sửa thất bại";
    }

    @Override
    public String delete(String id, NCC ncc) {
        boolean delete = repository.delete(id, ncc);
        if (delete) {
            return "Xóa thành công id : " + id;
        } else if (repository.getIndex(ncc.getTenNCC()) == -1) {
            return "ko tim thay ten trong csdl";
        }
        return "Xóa thất bại";
    }

    @Override
    public List<NCC> search(String temp) {
        return repository.search(temp);
    }

}
