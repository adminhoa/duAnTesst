/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.Date;

/**
 *
 * @author quanh
 */
public class ChiTietHoaDonTra {
    private int idCTHDTra;
    private int idHoaDonTra;
    private int idChiTietSach;
    private int soLuong;
    private int idHoaDonBan;
    private Date NgayDoiHang;
    private String moTa;
    private float GIA;

    public ChiTietHoaDonTra() {
    }

    public ChiTietHoaDonTra(int idCTHDTra, int idHoaDonTra, int idChiTietSach, int soLuong, int idHoaDonBan, Date NgayDoiHang, String moTa, float GIA) {
        this.idCTHDTra = idCTHDTra;
        this.idHoaDonTra = idHoaDonTra;
        this.idChiTietSach = idChiTietSach;
        this.soLuong = soLuong;
        this.idHoaDonBan = idHoaDonBan;
        this.NgayDoiHang = NgayDoiHang;
        this.moTa = moTa;
        this.GIA = GIA;
    }

    public int getIdCTHDTra() {
        return idCTHDTra;
    }

    public void setIdCTHDTra(int idCTHDTra) {
        this.idCTHDTra = idCTHDTra;
    }

    public int getIdHoaDonTra() {
        return idHoaDonTra;
    }

    public void setIdHoaDonTra(int idHoaDonTra) {
        this.idHoaDonTra = idHoaDonTra;
    }

    public int getIdChiTietSach() {
        return idChiTietSach;
    }

    public void setIdChiTietSach(int idChiTietSach) {
        this.idChiTietSach = idChiTietSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getIdHoaDonBan() {
        return idHoaDonBan;
    }

    public void setIdHoaDonBan(int idHoaDonBan) {
        this.idHoaDonBan = idHoaDonBan;
    }

    public Date getNgayDoiHang() {
        return NgayDoiHang;
    }

    public void setNgayDoiHang(Date NgayDoiHang) {
        this.NgayDoiHang = NgayDoiHang;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public float getGIA() {
        return GIA;
    }

    public void setGIA(float GIA) {
        this.GIA = GIA;
    }
    
    
}
