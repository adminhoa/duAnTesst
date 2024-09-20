/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;

/**
 *
 * @author quanh
 */
public class HDTraHangViewModel {
    private int maHoaDonTra;
    private int maHoaDonBan;
    private int idKhachHang;
    private int IDUsers;
    private Date thoiGian;
    private String khachHang;
    private int Sdt;
    private float tongTienHoanTra;
    private String ghiChu;

    public HDTraHangViewModel() {
    }

    public HDTraHangViewModel(int maHoaDonTra, int maHoaDonBan, int idKhachHang, int IDUsers, Date thoiGian, String khachHang, int Sdt, float tongTienHoanTra, String ghiChu) {
        this.maHoaDonTra = maHoaDonTra;
        this.maHoaDonBan = maHoaDonBan;
        this.idKhachHang = idKhachHang;
        this.IDUsers = IDUsers;
        this.thoiGian = thoiGian;
        this.khachHang = khachHang;
        this.Sdt = Sdt;
        this.tongTienHoanTra = tongTienHoanTra;
        this.ghiChu = ghiChu;
    }

    public HDTraHangViewModel(int maHoaDonTra, int maHoaDonBan, Date thoiGian, String khachHang, int Sdt, float tongTienHoanTra, String ghiChu) {
        this.maHoaDonTra = maHoaDonTra;
        this.maHoaDonBan = maHoaDonBan;
        this.thoiGian = thoiGian;
        this.khachHang = khachHang;
        this.Sdt = Sdt;
        this.tongTienHoanTra = tongTienHoanTra;
        this.ghiChu = ghiChu;
    }
    

    public int getIDUsers() {
        return IDUsers;
    }

    public void setIDUsers(int IDUsers) {
        this.IDUsers = IDUsers;
    }

    

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    
    public int getMaHoaDonTra() {
        return maHoaDonTra;
    }

    public void setMaHoaDonTra(int maHoaDonTra) {
        this.maHoaDonTra = maHoaDonTra;
    }

    public int getMaHoaDonBan() {
        return maHoaDonBan;
    }

    public void setMaHoaDonBan(int maHoaDonBan) {
        this.maHoaDonBan = maHoaDonBan;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }

    public int getSdt() {
        return Sdt;
    }

    public void setSdt(int Sdt) {
        this.Sdt = Sdt;
    }

    public float getTongTienHoanTra() {
        return tongTienHoanTra;
    }

    public void setTongTienHoanTra(float tongTienHoanTra) {
        this.tongTienHoanTra = tongTienHoanTra;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
