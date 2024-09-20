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
public class HDTra {
    private int idHoaDonTra;
    private int idKhachHang;
    private int idUser;
    private int IdHoaDonBan;
    private Date ngayDoiHang;
    private String moTa;
    private float totalReturn;

    public HDTra() {
    }

    public HDTra(int idHoaDonTra, int idKhachHang, int idUser, int IdHoaDonBan, Date ngayDoiHang, String moTa, float totalReturn) {
        this.idHoaDonTra = idHoaDonTra;
        this.idKhachHang = idKhachHang;
        this.idUser = idUser;
        this.IdHoaDonBan = IdHoaDonBan;
        this.ngayDoiHang = ngayDoiHang;
        this.moTa = moTa;
        this.totalReturn = totalReturn;
    }

    public int getIdHoaDonTra() {
        return idHoaDonTra;
    }

    public void setIdHoaDonTra(int idHoaDonTra) {
        this.idHoaDonTra = idHoaDonTra;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdHoaDonBan() {
        return IdHoaDonBan;
    }

    public void setIdHoaDonBan(int IdHoaDonBan) {
        this.IdHoaDonBan = IdHoaDonBan;
    }

    public Date getNgayDoiHang() {
        return ngayDoiHang;
    }

    public void setNgayDoiHang(Date ngayDoiHang) {
        this.ngayDoiHang = ngayDoiHang;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public float getTotalReturn() {
        return totalReturn;
    }

    public void setTotalReturn(float totalReturn) {
        this.totalReturn = totalReturn;
    }

    public void getIdHoaDonBan(Integer valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
