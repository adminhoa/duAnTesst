/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author ADMIN
 */
public class BanHangViewModel {
    private int id;
    private String MaSach,TenSach,TheLoai,NgonNgu,TacGia,NXB;
    private  float DonGia;
    private int SoLuongTon;

    public BanHangViewModel() {
    }

    public BanHangViewModel(int id, String MaSach, String TenSach, String TheLoai, String NgonNgu, String TacGia, String NXB, float DonGia, int SoLuongTon) {
        this.id = id;
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TheLoai = TheLoai;
        this.NgonNgu = NgonNgu;
        this.TacGia = TacGia;
        this.NXB = NXB;
        this.DonGia = DonGia;
        this.SoLuongTon = SoLuongTon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String TheLoai) {
        this.TheLoai = TheLoai;
    }

    public String getNgonNgu() {
        return NgonNgu;
    }

    public void setNgonNgu(String NgonNgu) {
        this.NgonNgu = NgonNgu;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }

    public int getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(int SoLuongTon) {
        this.SoLuongTon = SoLuongTon;
    }
     
    
}
