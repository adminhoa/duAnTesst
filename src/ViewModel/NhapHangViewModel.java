/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author ADMIN
 */
public class NhapHangViewModel {
//CTSPViewModel

    private int idchitietsach, idsach, idNgonNgu, IdTacGia, IsNXB;
   // private String mota;
    private int soluong;
    private float gia;//giaban
    private float gianhap;
    private String ngaytao;
    private String TenSach, TenNgonNgu, TenTacGia, TenNxb;
    private boolean trangThai;
    private int IdHoaDonBan;
    private int IdKhachHang;
    private String tenKhachHang;
    private String tenTheLoai;
    private String maSach;
    
    public NhapHangViewModel() {
    }

//    public NhapHangViewModel(int idchitietsach, int idsach, int idNgonNgu, int IdTacGia, int IsNXB, String mota, int soluong, float gia, float gianhap, String ngaytao, String TenSach, String TenNgonNgu, String TenTacGia, String TenNxb, boolean trangThai, int IdHoaDonBan, int IdKhachHang, String tenKhachHang, String tenTheLoai) {
//        this.idchitietsach = idchitietsach;
//        this.idsach = idsach;
//        this.idNgonNgu = idNgonNgu;
//        this.IdTacGia = IdTacGia;
//        this.IsNXB = IsNXB;
//        this.mota = mota;
//        this.soluong = soluong;
//        this.gia = gia;
//        this.gianhap = gianhap;
//        this.ngaytao = ngaytao;
//        this.TenSach = TenSach;
//        this.TenNgonNgu = TenNgonNgu;
//        this.TenTacGia = TenTacGia;
//        this.TenNxb = TenNxb;
//        this.trangThai = trangThai;
//        this.IdHoaDonBan = IdHoaDonBan;
//        this.IdKhachHang = IdKhachHang;
//        this.tenKhachHang = tenKhachHang;
//        this.tenTheLoai = tenTheLoai;
//    }

  

    public NhapHangViewModel(int idchitietsach,String TenSach,String tenTheLoai,String TenNxb,String TenNgonNgu,String TenTacGia,int soluong,float gia) {
        this.idchitietsach = idchitietsach;
        this.TenSach = TenSach;
        this.tenTheLoai = tenTheLoai;
        this.TenNxb = TenNxb;
        this.TenNgonNgu = TenNgonNgu;
        this.TenTacGia = TenTacGia;
        this.soluong = soluong;
        this.gia = gia;

    }

    public NhapHangViewModel(int idchitietsach,String TenSach,String tenTheLoai,String TenNxb,String TenNgonNgu,String TenTacGia,int soluong,float gia,String maSach ) {
        this.idchitietsach = idchitietsach;
        this.TenSach = TenSach;
        this.tenTheLoai = tenTheLoai;
        this.TenNxb = TenNxb;
        this.TenNgonNgu = TenNgonNgu;
        this.TenTacGia = TenTacGia;
        this.soluong = soluong;
        this.gia = gia;
        this.maSach = maSach;
    }

    public int getIdchitietsach() {
        return idchitietsach;
    }

    public void setIdchitietsach(int idchitietsach) {
        this.idchitietsach = idchitietsach;
    }

    public int getIdsach() {
        return idsach;
    }

    public void setIdsach(int idsach) {
        this.idsach = idsach;
    }

    public int getIdNgonNgu() {
        return idNgonNgu;
    }

    public void setIdNgonNgu(int idNgonNgu) {
        this.idNgonNgu = idNgonNgu;
    }

    public int getIdTacGia() {
        return IdTacGia;
    }

    public void setIdTacGia(int IdTacGia) {
        this.IdTacGia = IdTacGia;
    }

    public int getIsNXB() {
        return IsNXB;
    }

    public void setIsNXB(int IsNXB) {
        this.IsNXB = IsNXB;
    }

//    public String getMota() {
//        return mota;
//    }
//
//    public void setMota(String mota) {
//        this.mota = mota;
//    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public String getTenNgonNgu() {
        return TenNgonNgu;
    }

    public void setTenNgonNgu(String TenNgonNgu) {
        this.TenNgonNgu = TenNgonNgu;
    }

    public String getTenTacGia() {
        return TenTacGia;
    }

    public void setTenTacGia(String TenTacGia) {
        this.TenTacGia = TenTacGia;
    }

    public String getTenNxb() {
        return TenNxb;
    }

    public void setTenNxb(String TenNxb) {
        this.TenNxb = TenNxb;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
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

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public float getGianhap() {
        return gianhap;
    }

    public void setGianhap(float gianhap) {
        this.gianhap = gianhap;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    
}
