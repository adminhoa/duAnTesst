/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;


/**
 *
 * @author ADMIN
 */

public class HDNhapSanPham  {

  
private int IDHoaDonNhapSanPham;
private int IDNhaCungCap ;
private int IDUsers ;
private String  NGAYTAODON ;
private int  TINHTRANGTRATIEN ;
private String  MoTa ;
   
    public HDNhapSanPham() {
    }

    public HDNhapSanPham(int IDHoaDonNhapSanPham, int IDNhaCungCap, int IDUsers, String NGAYTAODON, int TINHTRANGTRATIEN, String MoTa) {
        this.IDHoaDonNhapSanPham = IDHoaDonNhapSanPham;
        this.IDNhaCungCap = IDNhaCungCap;
        this.IDUsers = IDUsers;
        this.NGAYTAODON = NGAYTAODON;
        this.TINHTRANGTRATIEN = TINHTRANGTRATIEN;
        this.MoTa = MoTa;
    }

    public int getIDHoaDonNhapSanPham() {
        return IDHoaDonNhapSanPham;
    }

    public void setIDHoaDonNhapSanPham(int IDHoaDonNhapSanPham) {
        this.IDHoaDonNhapSanPham = IDHoaDonNhapSanPham;
    }

    public int getIDNhaCungCap() {
        return IDNhaCungCap;
    }

    public void setIDNhaCungCap(int IDNhaCungCap) {
        this.IDNhaCungCap = IDNhaCungCap;
    }

    public int getIDUsers() {
        return IDUsers;
    }

    public void setIDUsers(int IDUsers) {
        this.IDUsers = IDUsers;
    }

    public String getNGAYTAODON() {
        return NGAYTAODON;
    }

    public void setNGAYTAODON(String NGAYTAODON) {
        this.NGAYTAODON = NGAYTAODON;
    }

    public int getTINHTRANGTRATIEN() {
        return TINHTRANGTRATIEN;
    }

    public void setTINHTRANGTRATIEN(int TINHTRANGTRATIEN) {
        this.TINHTRANGTRATIEN = TINHTRANGTRATIEN;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

  

}
