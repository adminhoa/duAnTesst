/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;


import java.util.List;


/**
 *
 * @author ADMIN
 */

public class NCC {
    
    
    private int idNCC;
    private String tenNCC;//nvarchar(255)
    private String DiaChi;//nvarchar(255)
    private String Sdt;//varchar(10)

    public NCC() {
    }

    public NCC(int idNCC, String tenNCC, String DiaChi, String Sdt) {
        this.idNCC = idNCC;
        this.tenNCC = tenNCC;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
    }
    public NCC(String tenNCC, String DiaChi, String Sdt) {
        this.tenNCC = tenNCC;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
    }
    public int getIdNCC() {
        return idNCC;
    }

    public void setIdNCC(int idNCC) {
        this.idNCC = idNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    @Override
    public String toString() {
        return tenNCC ;
    }
    
    
    
    
}
