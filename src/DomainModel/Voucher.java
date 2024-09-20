/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Voucher {
    private int IDVoucher;
    private String MaGiamGia;
    private float giamgia;
    private String Ngaytao;
    private Date NgayBatDau,NgayKetThuc;
    private int SoLuong;
    private boolean TrangThai;

    public Voucher() {
    }

    public Voucher(int IDVoucher, String MaGiamGia, float giamgia, String Ngaytao, Date NgayBatDau, Date NgayKetThuc, int SoLuong, boolean TrangThai) {
        this.IDVoucher = IDVoucher;
        this.MaGiamGia = MaGiamGia;
        this.giamgia = giamgia;
        this.Ngaytao = Ngaytao;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.SoLuong = SoLuong;
        this.TrangThai = TrangThai;
    }

    
    

    public int getIDVoucher() {
        return IDVoucher;
    }

    public void setIDVoucher(int IDVoucher) {
        this.IDVoucher = IDVoucher;
    }

    public String getMaGiamGia() {
        return MaGiamGia;
    }

    public void setMaGiamGia(String MaGiamGia) {
        this.MaGiamGia = MaGiamGia;
    }

    public float getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(float giamgia) {
        this.giamgia = giamgia;
    }

   

    public String getNgaytao() {
        return Ngaytao;
    }

    public void setNgaytao(String Ngaytao) {
        this.Ngaytao = Ngaytao;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

   
    

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return  MaGiamGia ;
    }

    
    
    
}
