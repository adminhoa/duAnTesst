/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;


/**
 *
 * @author ADMIN
 */
public class CTHDNhapSpViewModel {
    private int DetailsInvoice;//id
    private int IDHoaDonNhapSanPham;//
    private int IDChiTietSach;//
    private int SoLuong;//
    private float price;//goi gia cua ctsp
    private String tenSp;
    private String TacGia;
    private String NgonNgu;
    private String NXB;
    private int idHDCTNhap;
    public CTHDNhapSpViewModel() {
    }

    public CTHDNhapSpViewModel(int DetailsInvoice, int IDHoaDonNhapSanPham, int IDChiTietSach, int SoLuong, float price, String tenSp, String TacGia, String NgonNgu, String NXB) {
        this.DetailsInvoice = DetailsInvoice;
        this.IDHoaDonNhapSanPham = IDHoaDonNhapSanPham;
        this.IDChiTietSach = IDChiTietSach;
        this.SoLuong = SoLuong;
        this.price = price;
        this.tenSp = tenSp;
        this.TacGia = TacGia;
        this.NgonNgu = NgonNgu;
        this.NXB = NXB;
    }

    public CTHDNhapSpViewModel(int DetailsInvoice, int IDHoaDonNhapSanPham, int IDChiTietSach, int SoLuong, float price, String tenSp, String TacGia, String NgonNgu, String NXB, int idHDCTNhap) {
        this.DetailsInvoice = DetailsInvoice;
        this.IDHoaDonNhapSanPham = IDHoaDonNhapSanPham;
        this.IDChiTietSach = IDChiTietSach;
        this.SoLuong = SoLuong;
        this.price = price;
        this.tenSp = tenSp;
        this.TacGia = TacGia;
        this.NgonNgu = NgonNgu;
        this.NXB = NXB;
        this.idHDCTNhap = idHDCTNhap;
    }

    public int getDetailsInvoice() {
        return DetailsInvoice;
    }

    public void setDetailsInvoice(int DetailsInvoice) {
        this.DetailsInvoice = DetailsInvoice;
    }

    public int getIDHoaDonNhapSanPham() {
        return IDHoaDonNhapSanPham;
    }

    public void setIDHoaDonNhapSanPham(int IDHoaDonNhapSanPham) {
        this.IDHoaDonNhapSanPham = IDHoaDonNhapSanPham;
    }

    public int getIDChiTietSach() {
        return IDChiTietSach;
    }

    public void setIDChiTietSach(int IDChiTietSach) {
        this.IDChiTietSach = IDChiTietSach;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }

    public String getNgonNgu() {
        return NgonNgu;
    }

    public void setNgonNgu(String NgonNgu) {
        this.NgonNgu = NgonNgu;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public int getIdHDCTNhap() {
        return idHDCTNhap;
    }

    public void setIdHDCTNhap(int idHDCTNhap) {
        this.idHDCTNhap = idHDCTNhap;
    }

   
    
}
