/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author ADMIN
 */
public class KhachHangTrangHangViewModel {
    private String Ten;
    private boolean gioiTinh;
    private String SoDienThoai;
    private int Soluong;

    public KhachHangTrangHangViewModel() {
    }

    public KhachHangTrangHangViewModel(String Ten, boolean gioiTinh, String SoDienThoai, int Soluong) {
        this.Ten = Ten;
        this.gioiTinh = gioiTinh;
        this.SoDienThoai = SoDienThoai;
        this.Soluong = Soluong;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }
    

    
}
