
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */

public class NguoiDung implements Serializable{
    
    private int id;
    
  //  @Column(name = "HoTen")
    private String hoTen;
    
  //  @Column(name = "NgaySinh")
    private Date ngaySinh;
    
   // @Column(name = "GioiTinh")
    private Date gioiTinh;
    
   // @Column(name = "DiaChi")
    private Date diaChi;
    
   // @Column(name = "Sdt")
    private String sdt;
    
  //  @Column(name = "Email")
    private String email;
    
   // @Column(name = "Luong")
    private BigDecimal luong;
    
   // @Column(name = "Role")
    private boolean role;
    
   // @Column(name = "TrangThai")
    private boolean trangThai;
    
   

    public NguoiDung() {
    }

    public NguoiDung(int id, String hoTen, Date ngaySinh, Date gioiTinh, Date diaChi, String sdt, String email, BigDecimal luong, boolean role, boolean trangThai) {
        this.id = id;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.luong = luong;
        this.role = role;
        this.trangThai = trangThai;
        
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Date gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(Date diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getLuong() {
        return luong;
    }

    public void setLuong(BigDecimal luong) {
        this.luong = luong;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }


    
    
}
