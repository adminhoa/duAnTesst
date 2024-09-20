/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;


/**
 *
 * @author ADMIN
 */
public class HDDoiSPViewModel {

    private int IDHoaDonDoiSanPham,IDHoaDonBanHang, IDKhachHang,IdUsers;
    private String ngaytaoHDTra, MoTa,tenKhachHang;
    private String tenUsers,SDTkH;//tu them
    
    public HDDoiSPViewModel() {
    }

    public HDDoiSPViewModel(int IDHoaDonDoiSanPham, int IDHoaDonBanHang, int IDKhachHang, int IdUsers, String ngaytaoHDTra, String MoTa, String tenKhachHang) {
        this.IDHoaDonDoiSanPham = IDHoaDonDoiSanPham;
        this.IDHoaDonBanHang = IDHoaDonBanHang;
        this.IDKhachHang = IDKhachHang;
        this.IdUsers = IdUsers;
        this.ngaytaoHDTra = ngaytaoHDTra;
        this.MoTa = MoTa;
        this.tenKhachHang = tenKhachHang;
    }

    public int getIDHoaDonDoiSanPham() {
        return IDHoaDonDoiSanPham;
    }

    public void setIDHoaDonDoiSanPham(int IDHoaDonDoiSanPham) {
        this.IDHoaDonDoiSanPham = IDHoaDonDoiSanPham;
    }

    public int getIDHoaDonBanHang() {
        return IDHoaDonBanHang;
    }

    public void setIDHoaDonBanHang(int IDHoaDonBanHang) {
        this.IDHoaDonBanHang = IDHoaDonBanHang;
    }

    public int getIDKhachHang() {
        return IDKhachHang;
    }

    public void setIDKhachHang(int IDKhachHang) {
        this.IDKhachHang = IDKhachHang;
    }

    public int getIdUsers() {
        return IdUsers;
    }

    public void setIdUsers(int IdUsers) {
        this.IdUsers = IdUsers;
    }

    public String getNgaytaoHDTra() {
        return ngaytaoHDTra;
    }

    public void setNgaytaoHDTra(String ngaytaoHDTra) {
        this.ngaytaoHDTra = ngaytaoHDTra;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getTenUsers() {
        return tenUsers;
    }

    public void setTenUsers(String tenUsers) {
        this.tenUsers = tenUsers;
    }

    public String getSDTkH() {
        return SDTkH;
    }

    public void setSDTkH(String SDTkH) {
        this.SDTkH = SDTkH;
    }

   
}
