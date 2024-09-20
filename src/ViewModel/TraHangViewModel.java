/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author quanh
 */
public class TraHangViewModel {
    private int IDMaHoaDon;
    private int IDSach;
    private String tenSach;
    private int soLuong;
    private String tenNXB;
    private String tenNN;
    private String tenTG;   
    private float donGia;
    private String tenKh;
    private int idKhachHang;


    public TraHangViewModel() {
    }

    public TraHangViewModel(int IDMaHoaDon, int IDSach, String tenSach, int soLuong, String tenNXB, String tenNN, String tenTG, float donGia, String tenKh) {
        this.IDMaHoaDon = IDMaHoaDon;
        this.IDSach = IDSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.tenNXB = tenNXB;
        this.tenNN = tenNN;
        this.tenTG = tenTG;
        this.donGia = donGia;
        this.tenKh = tenKh;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }


    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    

    public int getIDMaHoaDon() {
        return IDMaHoaDon;
    }

    public void setIDMaHoaDon(int IDMaHoaDon) {
        this.IDMaHoaDon = IDMaHoaDon;
    }

    public int getIDSach() {
        return IDSach;
    }

    public void setIDSach(int IDSach) {
        this.IDSach = IDSach;
    }

    

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public String getTenNN() {
        return tenNN;
    }

    public void setTenNN(String tenNN) {
        this.tenNN = tenNN;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    
    
    
}
