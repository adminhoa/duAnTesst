/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;



/**
 *
 * @author ADMIN
 */

public class HDNhapSPViewModel  {

  
private int IDHoaDonNhapSanPham;//
private int IDNhaCungCap ;
private int IDUsers ;//
private String  NGAYTAODON ;//
private boolean TINHTRANGTRATIEN ;//
private String  MoTa ;//
   
private String tenUser;
private String tenNCC;
private String sdtNCC;

    public HDNhapSPViewModel() {
    }

    public HDNhapSPViewModel(int IDHoaDonNhapSanPham, int IDNhaCungCap, int IDUsers, String NGAYTAODON, boolean TINHTRANGTRATIEN, String MoTa, String tenUser, String tenNCC) {
        this.IDHoaDonNhapSanPham = IDHoaDonNhapSanPham;
        this.IDNhaCungCap = IDNhaCungCap;
        this.IDUsers = IDUsers;
        this.NGAYTAODON = NGAYTAODON;
        this.TINHTRANGTRATIEN = TINHTRANGTRATIEN;
        this.MoTa = MoTa;
        this.tenUser = tenUser;
        this.tenNCC = tenNCC;
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

    public boolean getTINHTRANGTRATIEN() {
        return TINHTRANGTRATIEN;
    }

    public void setTINHTRANGTRATIEN(boolean TINHTRANGTRATIEN) {
        this.TINHTRANGTRATIEN = TINHTRANGTRATIEN;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getTenUser() {
        return tenUser;
    }

    public void setTenUser(String tenUser) {
        this.tenUser = tenUser;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getSdtNCC() {
        return sdtNCC;
    }

    public void setSdtNCC(String sdtNCC) {
        this.sdtNCC = sdtNCC;
    }
  

}
