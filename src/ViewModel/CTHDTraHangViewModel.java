/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author quanh
 */
public class CTHDTraHangViewModel {
    private int idHDChiTiet;//idDetailInvoiceReturn
    private String tenSach;//
    private String tenKhach;//
    private  String tenNN;//
    private String tenNXB;//
    private String tenTG;//
    private int soLuong;//
    private float tongTien;//price
    private int idHoaDonTra,idCtSach;
    
    public CTHDTraHangViewModel() {
    }

    public CTHDTraHangViewModel(int idHDChiTiet, String tenSach, String tenKhach, String tenNN, String tenNXB, String tenTG, int soLuong, float tongTien) {
        this.idHDChiTiet = idHDChiTiet;
        this.tenSach = tenSach;
        this.tenKhach = tenKhach;
        this.tenNN = tenNN;
        this.tenNXB = tenNXB;
        this.tenTG = tenTG;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public int getIdHDChiTiet() {
        return idHDChiTiet;
    }

    public void setIdHDChiTiet(int idHDChiTiet) {
        this.idHDChiTiet = idHDChiTiet;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }

    public String getTenNN() {
        return tenNN;
    }

    public void setTenNN(String tenNN) {
        this.tenNN = tenNN;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public int getIdHoaDonTra() {
        return idHoaDonTra;
    }

    public void setIdHoaDonTra(int idHoaDonTra) {
        this.idHoaDonTra = idHoaDonTra;
    }

    public int getIdCtSach() {
        return idCtSach;
    }

    public void setIdCtSach(int idCtSach) {
        this.idCtSach = idCtSach;
    }
    
    
}
