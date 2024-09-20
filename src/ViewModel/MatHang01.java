/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author ADMIN
 */
public class MatHang01 {
    private int idCTSach;
    private String Masach;
    private String tensach;
    private float GiaBan;
    private String TenNgonNgu,tenTacGia,TenNxb;
    private int soLuong;
    
    public MatHang01() {
    }

    public MatHang01(int idCTSach, String Masach, String tensach, float GiaBan, String TenNgonNgu, String tenTacGia, String TenNxb, int soLuong) {
        this.idCTSach = idCTSach;
        this.Masach = Masach;
        this.tensach = tensach;
        this.GiaBan = GiaBan;
        this.TenNgonNgu = TenNgonNgu;
        this.tenTacGia = tenTacGia;
        this.TenNxb = TenNxb;
        this.soLuong = soLuong;
    }

    public MatHang01(String Masach, String tensach, float GiaBan, String TenNgonNgu, String tenTacGia, String TenNxb, int soLuong) {
        this.Masach = Masach;
        this.tensach = tensach;
        this.GiaBan = GiaBan;
        this.TenNgonNgu = TenNgonNgu;
        this.tenTacGia = tenTacGia;
        this.TenNxb = TenNxb;
        this.soLuong = soLuong;
    }

   
    
    public int getIdCTSach() {
        return idCTSach;
    }

    public void setIdCTSach(int idCTSach) {
        this.idCTSach = idCTSach;
    }

  

    public String getMasach() {
        return Masach;
    }

    public void setMasach(String Masach) {
        this.Masach = Masach;
    }

 

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(float GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getTenNgonNgu() {
        return TenNgonNgu;
    }

    public void setTenNgonNgu(String TenNgonNgu) {
        this.TenNgonNgu = TenNgonNgu;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getTenNxb() {
        return TenNxb;
    }

    public void setTenNxb(String TenNxb) {
        this.TenNxb = TenNxb;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
}
