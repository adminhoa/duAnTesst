
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Users {
    private int idusers;
    private String Hoten;
    private Date Ngaysinh;
    private boolean gioitinh;
    private String DiaChi,SoDienThoai,Email;
    private float Luong;
    private boolean role,TrangThai;
    private String CCCD;
    
    

    public Users() {
        
    }

    public Users(int idusers, String Hoten, Date Ngaysinh, boolean gioitinh, String DiaChi, String SoDienThoai, String Email, float Luong, boolean role, boolean TrangThai, String CCCD) {
        this.idusers = idusers;
        this.Hoten = Hoten;
        this.Ngaysinh = Ngaysinh;
        this.gioitinh = gioitinh;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
        this.Luong = Luong;
        this.role = role;
        this.TrangThai = TrangThai;
        this.CCCD = CCCD;
    }

    

    

    public int getIdusers() {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public Date getNgaysinh() {
        return Ngaysinh;
    }
// public String getNgaysinh() {
//        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        return df.format(Ngaysinh);
//    }
    public void setNgaysinh(Date Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public float getLuong() {
        return Luong;
    }

    public void setLuong(float Luong) {
        this.Luong = Luong;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

 
    
}
