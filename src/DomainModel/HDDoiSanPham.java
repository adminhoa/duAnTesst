/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author ADMIN
 */
public class HDDoiSanPham {

    private int IDHoaDonDoiSanPham,IDHoaDonBanHang, IDKhachHang,IdUsers;
    private int idsach, idchitietbanhang, IdCTHoaDonBan;
    private String ngaytaohoadon, MoTa;

    public HDDoiSanPham() {
    }

    public HDDoiSanPham(int IDHoaDonDoiSanPham, int IDHoaDonBanHang, int IDKhachHang, int IdUsers, int idsach, int idchitietbanhang, int IdCTHoaDonBan, String ngaytaohoadon, String MoTa) {
        this.IDHoaDonDoiSanPham = IDHoaDonDoiSanPham;
        this.IDHoaDonBanHang = IDHoaDonBanHang;
        this.IDKhachHang = IDKhachHang;
        this.IdUsers = IdUsers;
        this.idsach = idsach;
        this.idchitietbanhang = idchitietbanhang;
        this.IdCTHoaDonBan = IdCTHoaDonBan;
        this.ngaytaohoadon = ngaytaohoadon;
        this.MoTa = MoTa;
    }


    public int getIDHoaDonDoiSanPham() {
        return IDHoaDonDoiSanPham;
    }

    public void setIDHoaDonDoiSanPham(int IDHoaDonDoiSanPham) {
        this.IDHoaDonDoiSanPham = IDHoaDonDoiSanPham;
    }

    public int getIdUsers() {
        return IdUsers;
    }

    public void setIdUsers(int IdUsers) {
        this.IdUsers = IdUsers;
    }

    public int getIDKhachHang() {
        return IDKhachHang;
    }

    public void setIDKhachHang(int IDKhachHang) {
        this.IDKhachHang = IDKhachHang;
    }

    public int getIDHoaDonBanHang() {
        return IDHoaDonBanHang;
    }

    public void setIDHoaDonBanHang(int IDHoaDonBanHang) {
        this.IDHoaDonBanHang = IDHoaDonBanHang;
    }

    public int getIdsach() {
        return idsach;
    }

    public void setIdsach(int idsach) {
        this.idsach = idsach;
    }

    public int getIdchitietbanhang() {
        return idchitietbanhang;
    }

    public void setIdchitietbanhang(int idchitietbanhang) {
        this.idchitietbanhang = idchitietbanhang;
    }

    public int getIdCTHoaDonBan() {
        return IdCTHoaDonBan;
    }

    public void setIdCTHoaDonBan(int IdCTHoaDonBan) {
        this.IdCTHoaDonBan = IdCTHoaDonBan;
    }

    public String getNgaytaohoadon() {
        return ngaytaohoadon;
    }

    public void setNgaytaohoadon(String ngaytaohoadon) {
        this.ngaytaohoadon = ngaytaohoadon;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

}
