/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;



/**
 *
 * @author ADMIN
 */

public class TaiKhoan {
    
    private int idTaiKhoan;
    private int idUser;   
    private String name;
    private String matKhau;
    
   

    public TaiKhoan() {
    }

    public TaiKhoan(String name, String matKhau) {
        this.name = name;
        this.matKhau = matKhau;
    }

    public TaiKhoan(int idTaiKhoan, int idUser, String name, String matKhau) {
        this.idTaiKhoan = idTaiKhoan;
        this.idUser = idUser;
        this.name = name;
        this.matKhau = matKhau;
    }

    public int getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(int idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

   

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    
    
}
