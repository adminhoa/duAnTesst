/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.form.giaodich;

import DomainModel.ChiTietSach;
import DomainModel.NgonNgu;
import DomainModel.NhaXuatBan;
import DomainModel.Sach;
import DomainModel.TacGia;
import Service.Impl.ChiTietSachImpl;
import Service.Impl.NgonNguImpl;
import Service.Impl.NhaXuatBanImpl;
import Service.Impl.SachImpl;
import Service.Impl.TacGiaImpl;
import Services.NgonNguService;
import Services.NhaXuatBanService;
import Services.SachService;
import Services.TacGiaService;
import View.TrangChu.mainform;
import ViewModel.MatHangViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Services.ChiTietSachService;
import java.awt.event.ActionListener;

/**
 *
 * @author ADMIN
 */
public class ViewThemMatHang extends javax.swing.JFrame {

    DefaultTableModel tbl_model = new DefaultTableModel();
    NhaXuatBanService NhaXuatBanService = new NhaXuatBanImpl();
    NgonNguService NgonNguService = new NgonNguImpl();
    TacGiaService TacGiaService = new TacGiaImpl();
    SachService SachService = new SachImpl();
    List<NhaXuatBan> LisNhaXuatBan = new ArrayList<>();
    List<NgonNgu> ListNgonNgu = new ArrayList<>();
    List<TacGia> ListTacGia = new ArrayList<>();
    List<Sach> ListSach = new ArrayList<>();
    List<MatHangViewModel> listMatHangViewModel = new ArrayList<>();
    List<ChiTietSach> listchitietsach = new ArrayList<>();
    ChiTietSachService chitietsachService = new ChiTietSachImpl();
    
    
    
    
    public ViewThemMatHang() {
        initComponents();
       // setOpaque(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        statusForm();
        fillComboboxNgonNgu();
        fillComboboxNhaXuatBan();
        fillComboboxTacGia();
        fillComboboxTenSanPham();
        LisNhaXuatBan = NhaXuatBanService.getlist();
        lbl_ngonNgu.setVisible(false);
        lbl_nxb.setVisible(false);
        lbl_tacGia.setVisible(false);
        lbl_giaBan.setVisible(false);
        
        
        
    }
    public void fillComboboxNhaXuatBan() {
        DefaultComboBoxModel cbModel = (DefaultComboBoxModel) cbo_nhaXuatBan.getModel();
        cbo_nhaXuatBan.removeAllItems();
        List<NhaXuatBan> listnhaxuatBan = NhaXuatBanService.getlist();
        for (NhaXuatBan c : listnhaxuatBan) {
            cbModel.addElement(c);
        }
    }
    public void fillComboboxNgonNgu() {
        DefaultComboBoxModel cbModel = (DefaultComboBoxModel) cbo_ngonNgu.getModel();
        cbo_ngonNgu.removeAllItems();
        List<NgonNgu> listNgonNgu = NgonNguService.getList();
        for (NgonNgu c : listNgonNgu) {
            cbModel.addElement(c);
        }
    }
    public void fillComboboxTacGia() {
        DefaultComboBoxModel cbModel = (DefaultComboBoxModel) cbo_tacGia.getModel();
        cbo_tacGia.removeAllItems();
        ListTacGia = TacGiaService.getist();
        for (TacGia c : ListTacGia) {
            cbModel.addElement(c);
        }
    }
    public void fillComboboxTenSanPham() {
        DefaultComboBoxModel cbModel = (DefaultComboBoxModel) cbo_tenSanPham.getModel();
        cbo_tenSanPham.removeAllItems();
        ListSach = SachService.getAllSach();
        for (Sach s : ListSach) {
            cbModel.addElement(s);
        }
    }
    public void statusForm(){
            txt_TenNhaXuatBan.setVisible(false);
            btn_ThemNXB.setVisible(false);
            btn_suaNhaXuatBan.setVisible(false);
            btn_themNgonNgu.setVisible(false);
            Btn_Sua.setVisible(false);
            txt_TenNgonNgu.setVisible(false);
            txt_TenTacGia.setVisible(false);
            btn_themTacGia.setVisible(false);
            btn_SuaTacGia.setVisible(false);
    }
    public void shownhaxuatban(){
         
        NhaXuatBan nxb =  (NhaXuatBan) cbo_nhaXuatBan.getSelectedItem();
        if (nxb == null) {
            return;
        } else {
            txt_TenNhaXuatBan.setText(nxb.getNhaXuatBan());
        }
    }
     public void showNgonNgu(){
        NgonNgu nn =   (NgonNgu) cbo_ngonNgu.getSelectedItem();
        if (nn == null) {
            return;
        } else {
            txt_TenNgonNgu.setText(nn.getTenNgonNgu());
        }
    }
     public void showTacGia(){
        TacGia tg =    (TacGia) cbo_tacGia.getSelectedItem();
        if (tg == null) {
            return;
        } else {
            txt_TenTacGia.setText(tg.getTenGiaGia());
        }
    }
    
   
    public NhaXuatBan guidataNhaXuatBan(){
        NhaXuatBan nxb = new NhaXuatBan();
        nxb.setNhaXuatBan(txt_TenNhaXuatBan.getText());
        return nxb;
    }
    public NgonNgu guidataNgonNgu(){
        NgonNgu nn = new NgonNgu();
        nn.setTenNgonNgu(txt_TenNgonNgu.getText());
        return nn;
    }
    public TacGia guidataTacGia(){
        TacGia tg = new TacGia();
        tg.setTenGiaGia(txt_TenTacGia.getText());
        return tg;
    }
    public MatHangViewModel getfromMatHang(){
        NhaXuatBan nxb = (NhaXuatBan) cbo_nhaXuatBan.getSelectedItem();
        NgonNgu nn = (NgonNgu) cbo_ngonNgu.getSelectedItem();
        TacGia tg = (TacGia) cbo_tacGia.getSelectedItem();
        Sach s = (Sach) cbo_tenSanPham.getSelectedItem();
        MatHangViewModel mh = new MatHangViewModel();
        mh.setGiaban(Float.parseFloat(txt_giaBan.getText()));
        mh.setIdNgonNgu(nn.getIdNgonNgu());
        mh.setTenNgonNgu(nn.getTenNgonNgu());
        mh.setIdsach(s.getIdSach());
        mh.setTenSach(s.getTenSach());
        mh.setTrangThai(true);
        mh.setSoluongton(0);
        mh.setMasach(s.getMaSach());
        mh.setIdTacGia(tg.getIdTacGia());
        mh.setTenTacGia(tg.getTenGiaGia());
        mh.setIsNXB(nxb.getId());
        mh.setTenNxb(nxb.getNhaXuatBan());
         
        
        return mh;
    }
    public void inerts (){
         int index = tbl_chiTietSanPham.getRowCount();
        if (index >0) {
            for (int i = 0; i < listMatHangViewModel.size(); i++) {
                JOptionPane.showMessageDialog(this,chitietsachService.insert(listMatHangViewModel.get(i)));
                txt_giaBan.setText("");
            }
               
        listMatHangViewModel.clear();
        tbl_model.setRowCount(0);
        new mainform().showForm(new ViewMatHang());
        this.dispose();
        }
    }
    public void deleteRowInTableTemp() {
        int row = tbl_chiTietSanPham.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tbl_chiTietSanPham.getModel();

        for (int i = 0; i < tbl_chiTietSanPham.getRowCount(); i++) {
            if (row == i) {
                model.removeRow(row);
                listMatHangViewModel.remove(listMatHangViewModel.get(i));
                JOptionPane.showMessageDialog(this,"Xóa Mặt Hàng Thành Công");
                //btn_xoa.setEnabled(false);
                return;
            }
        }
    }
    public void reset(){
        cbo_ngonNgu.setSelectedIndex(0);
        cbo_nhaXuatBan.setSelectedIndex(0);
        cbo_tacGia.setSelectedIndex(0);
        cbo_tenSanPham.setSelectedIndex(0);
        txt_giaBan.setText("");
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cbo_tenSanPham = new View.form.Combobox();
        txt_giaBan = new View.form.TextField();
        cbo_nhaXuatBan = new View.form.Combobox();
        cbo_ngonNgu = new View.form.Combobox();
        btn_themNhaXuatBan = new View.form.MyButton();
        btn_ThemNXB = new View.form.MyButton();
        btn_suaNhaXuatBan = new View.form.MyButton();
        myButton4 = new View.form.MyButton();
        btn_themNgonNgu = new View.form.MyButton();
        Btn_Sua = new View.form.MyButton();
        btn_SuaTacGia = new View.form.MyButton();
        btn_themTacGia = new View.form.MyButton();
        cbo_tacGia = new View.form.Combobox();
        myButton9 = new View.form.MyButton();
        txt_TenTacGia = new View.form.TextField();
        txt_TenNhaXuatBan = new View.form.TextField();
        txt_TenNgonNgu = new View.form.TextField();
        lbl_nxb = new javax.swing.JLabel();
        lbl_tacGia = new javax.swing.JLabel();
        lbl_ngonNgu = new javax.swing.JLabel();
        lbl_giaBan = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btn_reset = new View.form.MyButton();
        myButton15 = new View.form.MyButton();
        jPanel8 = new javax.swing.JPanel();
        btn_HoanThanh = new View.form.MyButton();
        myButton2 = new View.form.MyButton();
        btn_xoa = new View.form.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_chiTietSanPham = new View.form.TableColumn();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Them mat hang");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiet San Pham", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13))); // NOI18N

        cbo_tenSanPham.setLabeText("Ten Sách");

        txt_giaBan.setLabelText("Gia ban");
        txt_giaBan.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_giaBanCaretUpdate(evt);
            }
        });

        cbo_nhaXuatBan.setLabeText("Nha xuat ban");

        cbo_ngonNgu.setLabeText("Ngon Ngu");

        btn_themNhaXuatBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon/icons8_Plus_32.png"))); // NOI18N
        btn_themNhaXuatBan.setBorderColor(new java.awt.Color(255, 255, 255));
        btn_themNhaXuatBan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_themNhaXuatBan.setRadius(20);
        btn_themNhaXuatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themNhaXuatBanActionPerformed(evt);
            }
        });

        btn_ThemNXB.setText("them");
        btn_ThemNXB.setRadius(20);
        btn_ThemNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemNXBActionPerformed(evt);
            }
        });

        btn_suaNhaXuatBan.setText("Sua");
        btn_suaNhaXuatBan.setRadius(20);
        btn_suaNhaXuatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaNhaXuatBanActionPerformed(evt);
            }
        });

        myButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon/icons8_Plus_32.png"))); // NOI18N
        myButton4.setBorderColor(new java.awt.Color(255, 255, 255));
        myButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        myButton4.setRadius(20);
        myButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton4ActionPerformed(evt);
            }
        });

        btn_themNgonNgu.setText("them");
        btn_themNgonNgu.setRadius(20);
        btn_themNgonNgu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themNgonNguActionPerformed(evt);
            }
        });

        Btn_Sua.setText("Sua");
        Btn_Sua.setRadius(20);
        Btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SuaActionPerformed(evt);
            }
        });

        btn_SuaTacGia.setText("Sua");
        btn_SuaTacGia.setRadius(20);
        btn_SuaTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaTacGiaActionPerformed(evt);
            }
        });

        btn_themTacGia.setText("them");
        btn_themTacGia.setRadius(20);
        btn_themTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themTacGiaActionPerformed(evt);
            }
        });

        cbo_tacGia.setLabeText("Tac gia");

        myButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon/icons8_Plus_32.png"))); // NOI18N
        myButton9.setBorderColor(new java.awt.Color(255, 255, 255));
        myButton9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        myButton9.setRadius(20);
        myButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton9ActionPerformed(evt);
            }
        });

        txt_TenTacGia.setLabelText("Tên Tác Giả");

        txt_TenNhaXuatBan.setLabelText("Tên Nhà Xuất Bản");

        txt_TenNgonNgu.setLabelText("Tên Ngôn Ngữ");

        lbl_nxb.setForeground(new java.awt.Color(255, 0, 51));
        lbl_nxb.setText("jLabel2");

        lbl_tacGia.setForeground(new java.awt.Color(255, 0, 51));
        lbl_tacGia.setText("jLabel2");

        lbl_ngonNgu.setForeground(new java.awt.Color(255, 0, 51));
        lbl_ngonNgu.setText("jLabel2");

        lbl_giaBan.setForeground(new java.awt.Color(255, 0, 51));
        lbl_giaBan.setText("jLabel2");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbo_tenSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                        .addComponent(txt_giaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbl_giaBan))
                .addGap(52, 52, 52)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_ngonNgu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btn_themTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btn_SuaTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(btn_ThemNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btn_suaNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                    .addComponent(btn_themNgonNgu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)
                                    .addComponent(Btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbo_ngonNgu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(cbo_tacGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(txt_TenNgonNgu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(txt_TenTacGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(lbl_tacGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(myButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(myButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbl_nxb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_TenNhaXuatBan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbo_nhaXuatBan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(btn_themNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 37, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_tenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_nhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_TenNhaXuatBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_giaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btn_themNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(lbl_nxb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btn_suaNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbo_ngonNgu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_TenNgonNgu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(myButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_ThemNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_giaBan)))
                .addGap(1, 1, 1)
                .addComponent(lbl_ngonNgu)
                .addGap(4, 4, 4)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_themNgonNgu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_tacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_TenTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_tacGia)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_themTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_SuaTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_reset.setText("Reset");
        btn_reset.setRadius(20);
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        myButton15.setText("Luu Tam");
        myButton15.setRadius(20);
        myButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(myButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(myButton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_HoanThanh.setText("Hoan Thanh");
        btn_HoanThanh.setRadius(20);
        btn_HoanThanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HoanThanhActionPerformed(evt);
            }
        });

        myButton2.setText("Hủy");
        myButton2.setRadius(20);
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xoa");
        btn_xoa.setRadius(20);
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_HoanThanh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btn_HoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbl_chiTietSanPham.setBackground(new java.awt.Color(255, 255, 255));
        tbl_chiTietSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ten San Pham", "Gia Ban", "Nha Xuat Ban", "Ngon Ngu", "Tac Gia"
            }
        ));
        jScrollPane1.setViewportView(tbl_chiTietSanPham);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1101, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void myButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton15ActionPerformed
        // TODO add your handling code here:
        tbl_model = (DefaultTableModel) tbl_chiTietSanPham.getModel();
        MatHangViewModel mh = getfromMatHang();
        tbl_model.addRow(new Object[]{
            mh.getTenSach(),mh.getGiaban(),mh.getTenNxb(),mh.getTenNgonNgu(),mh.getTenTacGia()
        });
        listMatHangViewModel.add(mh);
        reset();
    }//GEN-LAST:event_myButton15ActionPerformed
public void addFilltable(ActionListener evt){
    btn_HoanThanh.addActionListener(evt);
}
    private void btn_HoanThanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HoanThanhActionPerformed
        // TODO add your handling code here:
        inerts();
        
       
        

        
                
        
    }//GEN-LAST:event_btn_HoanThanhActionPerformed
    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_myButton2ActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        deleteRowInTableTemp();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_themNhaXuatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themNhaXuatBanActionPerformed
        // TODO add your handling code here:
        if (txt_TenNhaXuatBan.isVisible()) {
            txt_TenNhaXuatBan.setVisible(false);
            btn_ThemNXB.setVisible(false);
            btn_suaNhaXuatBan.setVisible(false);
        } else {
        txt_TenNhaXuatBan.setVisible(true);
            btn_ThemNXB.setVisible(true);
            btn_suaNhaXuatBan.setVisible(true);
           shownhaxuatban();
        }
        
    }//GEN-LAST:event_btn_themNhaXuatBanActionPerformed

    private void myButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton4ActionPerformed
        // TODO add your handling code here:
        if (txt_TenNgonNgu.isVisible()) {
            txt_TenNgonNgu.setVisible(false);
            btn_themNgonNgu.setVisible(false);
            Btn_Sua.setVisible(false);
        } else {
            txt_TenNgonNgu.setVisible(true);
            btn_themNgonNgu.setVisible(true);
            Btn_Sua.setVisible(true);
            showNgonNgu();
        }
    }//GEN-LAST:event_myButton4ActionPerformed

    private void myButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton9ActionPerformed
        // TODO add your handling code here:
        if (txt_TenTacGia.isVisible()) {
            txt_TenTacGia.setVisible(false);
            btn_themTacGia.setVisible(false);
            btn_SuaTacGia.setVisible(false);
        } else {
            txt_TenTacGia.setVisible(true);
            btn_themTacGia.setVisible(true);
            btn_SuaTacGia.setVisible(true);
            showTacGia();
        }
    }//GEN-LAST:event_myButton9ActionPerformed

    private void btn_ThemNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemNXBActionPerformed
        // TODO add your handling code here:
        if (txt_TenNhaXuatBan.getText().equals("")) {
            lbl_nxb.setVisible(true);
                lbl_nxb.setText("Nhà Xuất Bản không được để trống khi thêm !!!");
                return;
        }
        for (NhaXuatBan nxb : LisNhaXuatBan) {
            if (txt_TenNhaXuatBan.getText().equalsIgnoreCase(nxb.getNhaXuatBan())) {
                lbl_nxb.setVisible(true);
                lbl_nxb.setText("Nhà Xuất Bản đã có !!!");
                txt_TenNhaXuatBan.setText("");
                return;
            }
        }
        JOptionPane.showMessageDialog(this,NhaXuatBanService.insert(guidataNhaXuatBan()));
        fillComboboxNhaXuatBan();
       
    }//GEN-LAST:event_btn_ThemNXBActionPerformed

    private void btn_themNgonNguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themNgonNguActionPerformed
        // TODO add your handling code here:
        if (txt_TenNgonNgu.getText().equals("")) {
            lbl_ngonNgu.setVisible(true);
                lbl_ngonNgu.setText("Nhà Xuất Bản không được để trống khi thêm !!!");
                return;
        }
        for (NgonNgu nn : ListNgonNgu) {
            if (txt_TenNgonNgu.getText().equalsIgnoreCase(nn.getTenNgonNgu())) {
                lbl_ngonNgu.setVisible(true);
                lbl_ngonNgu.setText("Ngôn Ngữ đã có !!!");
                txt_TenNgonNgu.setText("");
                return;
            }
        }
        JOptionPane.showMessageDialog(this,NgonNguService.insert(guidataNgonNgu()));
        fillComboboxNgonNgu();
    }//GEN-LAST:event_btn_themNgonNguActionPerformed

    private void btn_themTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themTacGiaActionPerformed
        // TODO add your handling code here:
        if (txt_TenTacGia.getText().equals("")) {
            lbl_tacGia.setVisible(true);
                lbl_tacGia.setText("Tên Tác Giả không được để trống khi thêm !!!");
                return;
        }
        for (TacGia tg : ListTacGia) {
            if (txt_TenNhaXuatBan.getText().equalsIgnoreCase(tg.getTenGiaGia())) {
                lbl_tacGia.setVisible(true);
                lbl_tacGia.setText("Nhà Xuất Bản đã có !!!");
                txt_TenTacGia.setText("");
                return;
            }
        }
        JOptionPane.showMessageDialog(this,TacGiaService.insert(guidataTacGia()));
        fillComboboxTacGia();
    }//GEN-LAST:event_btn_themTacGiaActionPerformed

    private void btn_suaNhaXuatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaNhaXuatBanActionPerformed
        // TODO add your handling code here:
        NhaXuatBan nxb = (NhaXuatBan) cbo_nhaXuatBan.getSelectedItem();
        nxb.setNhaXuatBan(txt_TenNhaXuatBan.getText());
        JOptionPane.showMessageDialog(this,NhaXuatBanService.update(nxb));
    }//GEN-LAST:event_btn_suaNhaXuatBanActionPerformed

    private void Btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SuaActionPerformed
        // TODO add your handling code here:
        NgonNgu nn = (NgonNgu) cbo_ngonNgu.getSelectedItem();
        nn.setTenNgonNgu(txt_TenNgonNgu.getText());
        JOptionPane.showMessageDialog(this,NgonNguService.update(nn));
    }//GEN-LAST:event_Btn_SuaActionPerformed

    private void btn_SuaTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaTacGiaActionPerformed
        // TODO add your handling code here:
         TacGia tg = (TacGia) cbo_tacGia.getSelectedItem();
        tg.setTenGiaGia(txt_TenTacGia.getText());
        JOptionPane.showMessageDialog(this,TacGiaService.update(tg));
    }//GEN-LAST:event_btn_SuaTacGiaActionPerformed

    private void txt_giaBanCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_giaBanCaretUpdate
        // TODO add your handling code here:
//        try {
//            Float.parseFloat(txt_giaBan.getText());
//        } catch (Exception e) {
//            lbl_giaBan.setText("giá bán là số nha bạn");
//            txt_giaBan.setText("");
//            return;
//        }
    }//GEN-LAST:event_txt_giaBanCaretUpdate

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewThemMatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewThemMatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewThemMatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewThemMatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewThemMatHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.form.MyButton Btn_Sua;
    private View.form.MyButton btn_HoanThanh;
    private View.form.MyButton btn_SuaTacGia;
    private View.form.MyButton btn_ThemNXB;
    private View.form.MyButton btn_reset;
    private View.form.MyButton btn_suaNhaXuatBan;
    private View.form.MyButton btn_themNgonNgu;
    private View.form.MyButton btn_themNhaXuatBan;
    private View.form.MyButton btn_themTacGia;
    private View.form.MyButton btn_xoa;
    private View.form.Combobox cbo_ngonNgu;
    private View.form.Combobox cbo_nhaXuatBan;
    private View.form.Combobox cbo_tacGia;
    private View.form.Combobox cbo_tenSanPham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_giaBan;
    private javax.swing.JLabel lbl_ngonNgu;
    private javax.swing.JLabel lbl_nxb;
    private javax.swing.JLabel lbl_tacGia;
    private View.form.MyButton myButton15;
    private View.form.MyButton myButton2;
    private View.form.MyButton myButton4;
    private View.form.MyButton myButton9;
    private View.form.TableColumn tbl_chiTietSanPham;
    private View.form.TextField txt_TenNgonNgu;
    private View.form.TextField txt_TenNhaXuatBan;
    private View.form.TextField txt_TenTacGia;
    private View.form.TextField txt_giaBan;
    // End of variables declaration//GEN-END:variables

   
}
