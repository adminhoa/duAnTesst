/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author ADMIN
 */
public class HoaDonBanHang {
    private int IDHoaDonBan,IdKhachHang,IdUsers;
    private String NgayTao,NgayThanhToan,TenKhachHang,Ghichu;
    private boolean TrangThaiTraTien,TrangThaiHoaDon;
    private float TongTien,TienKhachDua,TienTraLai;
    private boolean TrangThai;
    private Integer IDVoucher;

    public HoaDonBanHang() {
    }

    public HoaDonBanHang(int IDHoaDonBan, int IdKhachHang, int IdUsers, String NgayTao, String NgayThanhToan, String TenKhachHang, String Ghichu, boolean TrangThaiTraTien, boolean TrangThaiHoaDon, float TongTien, float TienKhachDua, float TienTraLai, boolean TrangThai, Integer IDVoucher) {
        this.IDHoaDonBan = IDHoaDonBan;
        this.IdKhachHang = IdKhachHang;
        this.IdUsers = IdUsers;
        this.NgayTao = NgayTao;
        this.NgayThanhToan = NgayThanhToan;
        this.TenKhachHang = TenKhachHang;
        this.Ghichu = Ghichu;
        this.TrangThaiTraTien = TrangThaiTraTien;
        this.TrangThaiHoaDon = TrangThaiHoaDon;
        this.TongTien = TongTien;
        this.TienKhachDua = TienKhachDua;
        this.TienTraLai = TienTraLai;
        this.TrangThai = TrangThai;
        this.IDVoucher = IDVoucher;
    }

    public String getGhichu() {
        return Ghichu;
    }

    public void setGhichu(String Ghichu) {
        this.Ghichu = Ghichu;
    }

    
    

    public int getIDHoaDonBan() {
        return IDHoaDonBan;
    }

    public void setIDHoaDonBan(int IDHoaDonBan) {
        this.IDHoaDonBan = IDHoaDonBan;
    }

    public int getIdKhachHang() {
        return IdKhachHang;
    }

    public void setIdKhachHang(int IdKhachHang) {
        this.IdKhachHang = IdKhachHang;
    }

    public int getIdUsers() {
        return IdUsers;
    }

    public void setIdUsers(int IdUsers) {
        this.IdUsers = IdUsers;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(String NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public boolean isTrangThaiTraTien() {
        return TrangThaiTraTien;
    }

    public void setTrangThaiTraTien(boolean TrangThaiTraTien) {
        this.TrangThaiTraTien = TrangThaiTraTien;
    }

    public boolean isTrangThaiHoaDon() {
        return TrangThaiHoaDon;
    }

    public void setTrangThaiHoaDon(boolean TrangThaiHoaDon) {
        this.TrangThaiHoaDon = TrangThaiHoaDon;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public float getTienKhachDua() {
        return TienKhachDua;
    }

    public void setTienKhachDua(float TienKhachDua) {
        this.TienKhachDua = TienKhachDua;
    }

    public float getTienTraLai() {
        return TienTraLai;
    }

    public void setTienTraLai(float TienTraLai) {
        this.TienTraLai = TienTraLai;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public Integer getIDVoucher() {
        return IDVoucher;
    }

    public void setIDVoucher(Integer IDVoucher) {
        this.IDVoucher = IDVoucher;
    }
    
    
    
    
            
}
