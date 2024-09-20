/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author ADMIN
 */
public class TacGia {
    private int IdTacGia;
    private String TenGiaGia;

    public TacGia() {
    }

    public TacGia(int IdTacGia, String TenGiaGia) {
        this.IdTacGia = IdTacGia;
        this.TenGiaGia = TenGiaGia;
    }

    public int getIdTacGia() {
        return IdTacGia;
    }

    public void setIdTacGia(int IdTacGia) {
        this.IdTacGia = IdTacGia;
    }

    public String getTenGiaGia() {
        return TenGiaGia;
    }

    public void setTenGiaGia(String TenGiaGia) {
        this.TenGiaGia = TenGiaGia;
    }

    @Override
    public String toString() {
        return  TenGiaGia ;
    }
    
}
