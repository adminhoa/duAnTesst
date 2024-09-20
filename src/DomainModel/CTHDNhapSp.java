/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author ADMIN
 */
public class CTHDNhapSp {

    private int IDHoaDonNhapSanPham;
    private int IDChiTietSach;
    private int DetailsInvoice;
    private int SoLuong;
    private float priceImport;

    public CTHDNhapSp() {
    }

    public CTHDNhapSp(int IDHoaDonNhapSanPham, int IDChiTietSach, int DetailsInvoice, int SoLuong, float priceImport) {
        this.IDHoaDonNhapSanPham = IDHoaDonNhapSanPham;
        this.IDChiTietSach = IDChiTietSach;
        this.DetailsInvoice = DetailsInvoice;
        this.SoLuong = SoLuong;
        this.priceImport = priceImport;
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

    public int getDetailsInvoice() {
        return DetailsInvoice;
    }

    public void setDetailsInvoice(int DetailsInvoice) {
        this.DetailsInvoice = DetailsInvoice;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getPriceImport() {
        return priceImport;
    }

    public void setPriceImport(float priceImport) {
        this.priceImport = priceImport;
    }

}
