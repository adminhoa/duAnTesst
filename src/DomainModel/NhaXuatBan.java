/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author ADMIN
 */
public class NhaXuatBan {
    private int id;
    private String NhaXuatBan;

    public NhaXuatBan() {
    }

    public NhaXuatBan(int id, String NhaXuatBan) {
        this.id = id;
        this.NhaXuatBan = NhaXuatBan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNhaXuatBan() {
        return NhaXuatBan;
    }

    public void setNhaXuatBan(String NhaXuatBan) {
        this.NhaXuatBan = NhaXuatBan;
    }

    @Override
    public String toString() {
        return NhaXuatBan;
    }
    
    
    
            
}
