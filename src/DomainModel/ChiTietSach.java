/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class ChiTietSach {
    private int id,idSach,idNgonNgu,idTacGIa,idNXB;
    private String Mota;
    private int soluong;
    private float giaNhap,giaBan;
    private Date ngaysua,NgayTao;

    public ChiTietSach() {
    }

    public ChiTietSach(int id, int idSach, int idNgonNgu, int idTacGIa, int idNXB, String Mota, int soluong, float giaNhap, float giaBan, Date ngaysua, Date NgayTao) {
        this.id = id;
        this.idSach = idSach;
        this.idNgonNgu = idNgonNgu;
        this.idTacGIa = idTacGIa;
        this.idNXB = idNXB;
        this.Mota = Mota;
        this.soluong = soluong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.ngaysua = ngaysua;
        this.NgayTao = NgayTao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public int getIdNgonNgu() {
        return idNgonNgu;
    }

    public void setIdNgonNgu(int idNgonNgu) {
        this.idNgonNgu = idNgonNgu;
    }

    public int getIdTacGIa() {
        return idTacGIa;
    }

    public void setIdTacGIa(int idTacGIa) {
        this.idTacGIa = idTacGIa;
    }

    public int getIdNXB() {
        return idNXB;
    }

    public void setIdNXB(int idNXB) {
        this.idNXB = idNXB;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public Date getNgaysua() {
        return ngaysua;
    }

    public void setNgaysua(Date ngaysua) {
        this.ngaysua = ngaysua;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }
    
    
            
}
