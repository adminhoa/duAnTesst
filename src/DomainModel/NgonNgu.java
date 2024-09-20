/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author ADMIN
 */
public class NgonNgu {
    private int idNgonNgu;
    private String TenNgonNgu;

    public NgonNgu() {
    }

    public NgonNgu(int idNgonNgu, String TenNgonNgu) {
        this.idNgonNgu = idNgonNgu;
        this.TenNgonNgu = TenNgonNgu;
    }

    public int getIdNgonNgu() {
        return idNgonNgu;
    }

    public void setIdNgonNgu(int idNgonNgu) {
        this.idNgonNgu = idNgonNgu;
    }

    public String getTenNgonNgu() {
        return TenNgonNgu;
    }

    public void setTenNgonNgu(String TenNgonNgu) {
        this.TenNgonNgu = TenNgonNgu;
    }

    @Override
    public String toString() {
        return  TenNgonNgu ;
    }
    
    
    
}
