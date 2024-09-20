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
public class MatHangViewModel {
    private int idchitietsach,idsach,idNgonNgu,IdTacGia,IsNXB;
    private String mota;
    private int soluongton;
    private float gianhap,giaban;
    private Date ngaysua,ngaythem;
    private String masach,TenSach,TenNgonNgu,TenTacGia,TenNxb;
    private boolean trangThai;

    public MatHangViewModel() {
    }

    public MatHangViewModel(int idchitietsach, int idsach, int idNgonNgu, int IdTacGia, int IsNXB, String mota, int soluongton, float gianhap, float giaban, Date ngaysua, Date ngaythem, String masach, String TenSach, String TenNgonNgu, String TenTacGia, String TenNxb, boolean trangThai) {
        this.idchitietsach = idchitietsach;
        this.idsach = idsach;
        this.idNgonNgu = idNgonNgu;
        this.IdTacGia = IdTacGia;
        this.IsNXB = IsNXB;
        this.mota = mota;
        this.soluongton = soluongton;
        this.gianhap = gianhap;
        this.giaban = giaban;
        this.ngaysua = ngaysua;
        this.ngaythem = ngaythem;
        this.masach = masach;
        this.TenSach = TenSach;
        this.TenNgonNgu = TenNgonNgu;
        this.TenTacGia = TenTacGia;
        this.TenNxb = TenNxb;
        this.trangThai = trangThai;
    }

    public MatHangViewModel(int soluongton, float giaban, String masach, String TenSach, String TenNgonNgu, String TenTacGia, String TenNxb) {
        this.soluongton = soluongton;
        this.giaban = giaban;
        this.masach = masach;
        this.TenSach = TenSach;
        this.TenNgonNgu = TenNgonNgu;
        this.TenTacGia = TenTacGia;
        this.TenNxb = TenNxb;
    }

    public MatHangViewModel(int idchitietsach, int soluongton, float giaban, String masach, String TenSach, String TenNgonNgu, String TenTacGia, String TenNxb) {
        this.idchitietsach = idchitietsach;
        this.soluongton = soluongton;
        this.giaban = giaban;
        this.masach = masach;
        this.TenSach = TenSach;
        this.TenNgonNgu = TenNgonNgu;
        this.TenTacGia = TenTacGia;
        this.TenNxb = TenNxb;
    }
    
    

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
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

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getSoluongton() {
        return soluongton;
    }

    public void setSoluongton(int soluongton) {
        this.soluongton = soluongton;
    }

    public float getGianhap() {
        return gianhap;
    }

    public void setGianhap(float gianhap) {
        this.gianhap = gianhap;
    }

    public float getGiaban() {
        return giaban;
    }

    public void setGiaban(float giaban) {
        this.giaban = giaban;
    }

    public Date getNgaysua() {
        return ngaysua;
    }

    public void setNgaysua(Date ngaysua) {
        this.ngaysua = ngaysua;
    }

    public Date getNgaythem() {
        return ngaythem;
    }

    public void setNgaythem(Date ngaythem) {
        this.ngaythem = ngaythem;
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
     

}