/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author ADMIN
 */
public class ChiTietHoaDonBan {
    private int idChiTietHoaDonBan,IDHoaDonBan,IdChiTietSach;
    private int SoLuong;
    private float DonGia;

    public ChiTietHoaDonBan() {
    }

    public ChiTietHoaDonBan(int idChiTietHoaDonBan, int IDHoaDonBan, int IdChiTietSach, int SoLuong, float DonGia) {
        this.idChiTietHoaDonBan = idChiTietHoaDonBan;
        this.IDHoaDonBan = IDHoaDonBan;
        this.IdChiTietSach = IdChiTietSach;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public int getIdChiTietHoaDonBan() {
        return idChiTietHoaDonBan;
    }

    public void setIdChiTietHoaDonBan(int idChiTietHoaDonBan) {
        this.idChiTietHoaDonBan = idChiTietHoaDonBan;
    }

    public int getIDHoaDonBan() {
        return IDHoaDonBan;
    }

    public void setIDHoaDonBan(int IDHoaDonBan) {
        this.IDHoaDonBan = IDHoaDonBan;
    }

    public int getIdChiTietSach() {
        return IdChiTietSach;
    }

    public void setIdChiTietSach(int IdChiTietSach) {
        this.IdChiTietSach = IdChiTietSach;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }
    
}
