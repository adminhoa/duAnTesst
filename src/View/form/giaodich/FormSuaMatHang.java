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
import Services.ChiTietSachService;
import Services.NgonNguService;
import Services.NhaXuatBanService;
import Services.SachService;
import Services.TacGiaService;
import View.TrangChu.mainform;
import ViewModel.MatHangViewModel;
import ViewModel.sachMatHangViewModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class FormSuaMatHang extends javax.swing.JFrame {

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
    List<sachMatHangViewModel> listsachMatHangViewModel = new ArrayList<>();
    ChiTietSachService chitietsachService = new ChiTietSachImpl();
    public FormSuaMatHang() {
        initComponents();
//        fillComboboxNgonNgu();
//        fillComboboxNhaXuatBan();
//        fillComboboxTacGia();
//        fillComboboxTenSanPham();
        
    }
    public FormSuaMatHang(String Tensach, Float GiaBan,String tenngonngu ,String tenTacGIa,String tennhaxuatban,int idchitietsach){
        initComponents();
        setLocationRelativeTo(null);
         setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        fillComboboxNgonNgu();
        fillComboboxNhaXuatBan();
        fillComboboxTacGia();
        fillComboboxTenSanPham();
        txt_ID.setText(Integer.toString(idchitietsach));
        txt_ID.setEditable(false);
        txt_GiaBan.setText(Float.toString(GiaBan));
        
       NhaXuatBan nxb = (NhaXuatBan) NhaXuatBanService.Select(tennhaxuatban);
       TacGia tg = TacGiaService.selectName(tenTacGIa);
      sachMatHangViewModel s = SachService.selectByName(Tensach);
       NgonNgu nn = NgonNguService.selectName(tenngonngu);
       
       cbo_NgonNgu.getModel().setSelectedItem(nn);
       cbo_NhaXuatBan.getModel().setSelectedItem(nxb);
       cbo_TacGia.getModel().setSelectedItem(tg);
       cbo_TenSach.getModel().setSelectedItem(s);
       cbo_TenSach.setEditable(false);
       cbo_TenSach.setEnabled(false);
       
       
       
       
        
        
    }
     public void themSuKienUpdate(ActionListener evt) {
        btn_hoanThanh.addActionListener(evt);
    }
    public void fillComboboxNhaXuatBan() {
        DefaultComboBoxModel cbModel = (DefaultComboBoxModel) cbo_NhaXuatBan.getModel();
        cbo_NhaXuatBan.removeAllItems();
        List<NhaXuatBan> listnhaxuatBan = NhaXuatBanService.getlist();
        for (NhaXuatBan c : listnhaxuatBan) {
            cbModel.addElement(c);
        }
    }
    
    public void fillComboboxNgonNgu() {
        DefaultComboBoxModel cbModel = (DefaultComboBoxModel) cbo_NgonNgu.getModel();
        cbo_NgonNgu.removeAllItems();
        List<NgonNgu> listNgonNgu = NgonNguService.getList();
        for (NgonNgu c : listNgonNgu) {
            cbModel.addElement(c);
        }
    }
    public void fillComboboxTacGia() {
        DefaultComboBoxModel cbModel = (DefaultComboBoxModel) cbo_TacGia.getModel();
        cbo_TacGia.removeAllItems();
        ListTacGia = TacGiaService.getist();
        for (TacGia c : ListTacGia) {
            cbModel.addElement(c);
        }
    }
    public void fillComboboxTenSanPham() {
        DefaultComboBoxModel cbModel = (DefaultComboBoxModel) cbo_TenSach.getModel();
        cbo_TenSach.removeAllItems();
        ListSach = SachService.getAllSach();
        for (Sach s : ListSach) {
            cbModel.addElement(s);
        }
    }
     public MatHangViewModel getfromMatHang(){
        NhaXuatBan nxb = (NhaXuatBan) cbo_NhaXuatBan.getSelectedItem();
        NgonNgu nn = (NgonNgu) cbo_NgonNgu.getSelectedItem();
        TacGia tg = (TacGia) cbo_TacGia.getSelectedItem();
        sachMatHangViewModel s =  (sachMatHangViewModel) cbo_TenSach.getSelectedItem();
        MatHangViewModel mh = new MatHangViewModel();
        mh.setGiaban(Float.parseFloat(txt_GiaBan.getText()));
        mh.setIdchitietsach(Integer.parseInt(txt_ID.getText()));
        mh.setIdNgonNgu(nn.getIdNgonNgu());
        mh.setTenNgonNgu(nn.getTenNgonNgu());
        mh.setIdsach(s.getIdsach());
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
     public boolean validate1(){
//         try {
//             Integer.parseInt(txt_GiaBan.getText());
//         } catch (Exception e) {
//             JOptionPane.showMessageDialog(this,"Bạn Ơi, Giá Bán Phải Là Số Nha");
//             return false;
//         }
         if (txt_GiaBan.getText().trim().isEmpty()) {
             JOptionPane.showMessageDialog(this, "Bạn Ơi, Giá Bán Không Được Để Trống Nha");
             return false;
         }
         return true;
     }
     public void update(){
         if (validate1()) {
             
         
         MatHangViewModel mh = getfromMatHang();
         JOptionPane.showMessageDialog(this,chitietsachService.update(mh));
         new mainform().showForm(new ViewMatHang());
         this.dispose();}
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
        jPanel2 = new javax.swing.JPanel();
        txt_ID = new View.form.TextField();
        txt_GiaBan = new View.form.TextField();
        cbo_TenSach = new View.form.Combobox();
        cbo_NhaXuatBan = new View.form.Combobox();
        cbo_NgonNgu = new View.form.Combobox();
        cbo_TacGia = new View.form.Combobox();
        btn_hoanThanh = new View.form.MyButton();
        btn_huy = new View.form.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sửa Mặt Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        txt_ID.setLabelText("ID");

        txt_GiaBan.setLabelText("Giá Bán");

        cbo_TenSach.setLabeText("");

        cbo_NhaXuatBan.setLabeText("");

        cbo_NgonNgu.setLabeText("");

        cbo_TacGia.setLabeText("");

        btn_hoanThanh.setText("Sửa");
        btn_hoanThanh.setRadius(20);
        btn_hoanThanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hoanThanhActionPerformed(evt);
            }
        });

        btn_huy.setText("Hủy");
        btn_huy.setRadius(20);
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_ID, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(txt_GiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_NgonNgu, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_TacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_TenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_NhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(56, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_hoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_TenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_GiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_NhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cbo_NgonNgu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbo_TacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_hoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_hoanThanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hoanThanhActionPerformed
        // TODO add your handling code here:
//        MatHangViewModel mh = getfromMatHang();
//        chitietsachService.update(mh);
//        new mainform().showForm(new ViewMatHang());
//        this.dispose();
        
    }//GEN-LAST:event_btn_hoanThanhActionPerformed

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_huyActionPerformed

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
            java.util.logging.Logger.getLogger(FormSuaMatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSuaMatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSuaMatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSuaMatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSuaMatHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.form.MyButton btn_hoanThanh;
    private View.form.MyButton btn_huy;
    private View.form.Combobox cbo_NgonNgu;
    private View.form.Combobox cbo_NhaXuatBan;
    private View.form.Combobox cbo_TacGia;
    private View.form.Combobox cbo_TenSach;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private View.form.TextField txt_GiaBan;
    private View.form.TextField txt_ID;
    // End of variables declaration//GEN-END:variables
}
