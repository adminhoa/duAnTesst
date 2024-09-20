/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;


/**
 *
 * @author ADMIN
 */
public class HDBanViewModel {
        private int IdHoaDonBan, IdKhachHang, IdUsers,IdVoucher;
    private String GhiChu, tenUser, tenKhachHang;
    private String NGAYTHANHTOAN;
    private boolean statusPay, statusInvoice;
    private double TongTien, TienKhachDua, TienTraLai;

    public HDBanViewModel() {
    }
    
    public int getIdHoaDonBan() {
        return IdHoaDonBan;
    }

    public void setIdHoaDonBan(int IdHoaDonBan) {
        this.IdHoaDonBan = IdHoaDonBan;
    }

    public int getIdKhachHang() {
        return IdKhachHang;
    }

    public void setIdKhachHang(int IdKhachHang) {
        this.IdKhachHang = IdKhachHang;
    }

    public int getIdUsers() {
        return IdUsers;
    }

    public void setIdUsers(int IdUsers) {
        this.IdUsers = IdUsers;
    }

    public int getIdVoucher() {
        return IdVoucher;
    }

    public void setIdVoucher(int IdVoucher) {
        this.IdVoucher = IdVoucher;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getTenUser() {
        return tenUser;
    }

    public void setTenUser(String tenUser) {
        this.tenUser = tenUser;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getNGAYTHANHTOAN() {
        return NGAYTHANHTOAN;
    }

    public void setNGAYTHANHTOAN(String NGAYTHANHTOAN) {
        this.NGAYTHANHTOAN = NGAYTHANHTOAN;
    }


    public boolean isStatusPay() {
        return statusPay;
    }

    public void setStatusPay(boolean statusPay) {
        this.statusPay = statusPay;
    }

    public boolean isStatusInvoice() {
        return statusInvoice;
    }

    public void setStatusInvoice(boolean statusInvoice) {
        this.statusInvoice = statusInvoice;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public double getTienKhachDua() {
        return TienKhachDua;
    }

    public void setTienKhachDua(double TienKhachDua) {
        this.TienKhachDua = TienKhachDua;
    }

    public double getTienTraLai() {
        return TienTraLai;
    }

    public void setTienTraLai(double TienTraLai) {
        this.TienTraLai = TienTraLai;
    }
    
    
}
