/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class NhanVienViewModel {
    private int IdUser, IDTaiKhoan;
    private String CCCD,Hoten, SoDienThoai, DiaChi, email, username, password;
    private boolean GioiTinh, role, TrangThai;
    private Date NgaySinh;
    private Float Luong;

    public NhanVienViewModel() {
    }

    public NhanVienViewModel(int IdUser, int IDTaiKhoan, String CCCD, String Hoten, String SoDienThoai, String DiaChi, String email, String username, String password, boolean GioiTinh, boolean role, boolean TrangThai, Date NgaySinh, Float Luong) {
        this.IdUser = IdUser;
        this.IDTaiKhoan = IDTaiKhoan;
        this.CCCD = CCCD;
        this.Hoten = Hoten;
        this.SoDienThoai = SoDienThoai;
        this.DiaChi = DiaChi;
        this.email = email;
        this.username = username;
        this.password = password;
        this.GioiTinh = GioiTinh;
        this.role = role;
        this.TrangThai = TrangThai;
        this.NgaySinh = NgaySinh;
        this.Luong = Luong;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public int getIDTaiKhoan() {
        return IDTaiKhoan;
    }

    public void setIDTaiKhoan(int IDTaiKhoan) {
        this.IDTaiKhoan = IDTaiKhoan;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
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

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public Float getLuong() {
        return Luong;
    }

    public void setLuong(Float Luong) {
        this.Luong = Luong;
    }
    
    
    
    
}
