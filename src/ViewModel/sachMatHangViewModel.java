/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author ADMIN
 */
public class sachMatHangViewModel {
    private int idsach,idtheloai;
    private String TenSach,TenTheLoai,MaSach;
    private boolean trangThai;

    public sachMatHangViewModel() {
    }

    public sachMatHangViewModel(int idsach, int idtheloai, String TenSach, String TenTheLoai, String MaSach, boolean trangThai) {
        this.idsach = idsach;
        this.idtheloai = idtheloai;
        this.TenSach = TenSach;
        this.TenTheLoai = TenTheLoai;
        this.MaSach = MaSach;
        this.trangThai = trangThai;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

  

    public int getIdsach() {
        return idsach;
    }

    public void setIdsach(int idsach) {
        this.idsach = idsach;
    }

    public int getIdtheloai() {
        return idtheloai;
    }

    public void setIdtheloai(int idtheloai) {
        this.idtheloai = idtheloai;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String TenTheLoai) {
        this.TenTheLoai = TenTheLoai;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return TenSach ;
    }
    
    
}
