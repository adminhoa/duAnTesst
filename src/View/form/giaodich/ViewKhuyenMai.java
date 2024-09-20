/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.form.giaodich;

import DomainModel.Voucher;
import Service.Impl.VoucherImpl;
import Services.VoucherService;
import View.login.XDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class ViewKhuyenMai extends javax.swing.JPanel {

    private static final String chu = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String ChuHoa= chu.toUpperCase(); // A-Z
    private static final String sO = "0123456789"; // 0-9
    private static final String ALPHA_NUMERIC = chu + ChuHoa + sO;
    DefaultTableModel tbl_model = new DefaultTableModel();
    VoucherService voucherService = new VoucherImpl();
    List<Voucher> ListVoucher = new ArrayList<>();
    int index =0;
    
    public ViewKhuyenMai() {
        initComponents();
        setOpaque(false);
       // btn_xoa.setEnabled(false);
       // btn_sua.setEnabled(false);
        tbl_model = (DefaultTableModel) tbl_khuyenMai.getModel();
        ListVoucher = voucherService.getListVouchers();
        filldata();
        txt_ID.setEnabled(false);
        btn_sua.setEnabled(false);
        btn_xoa.setEnabled(false);
        
    }
     public void filldata(){
        tbl_model.setRowCount(0);
        for (Voucher v : ListVoucher) {
            tbl_model.addRow(new Object[]{
                v.getIDVoucher(),v.getMaGiamGia(),v.getGiamgia(),v.getNgaytao(),v.getNgayBatDau(),v.getNgayKetThuc(),v.isTrangThai() == true ?"Đang Hoạt Động":"Ngừng Hoạt Động"
            });
        }
        
    }
    private static Random generator = new Random();
    
      public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }
     public String randomAlphaNumeric(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }
    public  Voucher guidata (){
        Voucher v= new Voucher();
        v.setMaGiamGia(randomAlphaNumeric(8));
        v.setNgayBatDau(XDate.toDate(txt_NgayBatDau.getText(), "yyyy-MM-dd"));
        v.setNgayKetThuc(XDate.toDate(txt_NgayKetThuc.getText(), "yyyy-MM-dd"));
        v.setGiamgia(Float.parseFloat(txt_giamgia.getText()));
        v.setSoLuong(Integer.parseInt(txt_soluong.getText()));
        if (rdo_DangHoatDong.isSelected()) {
            v.setTrangThai(true);
        } else {
             v.setTrangThai(false);
        }
        return v;
    }
     public  Voucher guidata01 (){
        Voucher v= new Voucher();
        v.setMaGiamGia(randomAlphaNumeric(8));
        v.setNgayBatDau(XDate.toDate(txt_NgayBatDau.getText(), "yyyy-MM-dd"));
        v.setNgayKetThuc(XDate.toDate(txt_NgayKetThuc.getText(), "yyyy-MM-dd"));
        v.setGiamgia(Float.parseFloat(txt_giamgia.getText()));
        v.setSoLuong(Integer.parseInt(txt_soluong.getText()));
        if (rdo_DangHoatDong.isSelected()) {
            v.setTrangThai(true);
        } else {
             v.setTrangThai(false);
        }
        return v;
    }
    public void reset(){
        txt_NgayBatDau.setText("");
        txt_NgayKetThuc.setText("");
        txt_giamgia.setText("");
        txt_soluong.setText("");
        txt_ID.setText("");
        rdo_DangHoatDong.setSelected(true);
        btn_sua.setEnabled(false);
        btn_xoa.setEnabled(false);
    }
    public void showdeil(){
        Voucher v = ListVoucher.get(index);
        txt_ID.setText(String.valueOf(v.getIDVoucher()));
        txt_giamgia.setText(String.valueOf(v.getGiamgia()));
        txt_soluong.setText(String.valueOf(v.getSoLuong()));
        txt_NgayBatDau.setText(String.valueOf(v.getNgayBatDau()));
        txt_NgayKetThuc.setText(String.valueOf(v.getNgayKetThuc()));
        if (v.isTrangThai()) {
            rdo_DangHoatDong.setSelected(true);
        } else {
            rdo_NgungHoatDong.setSelected(true);
        }
    }
    public int getVoucher(){
        int rowindex = tbl_khuyenMai.getSelectedRow();
        if (rowindex >= 0 ) {
            int ID = Integer.valueOf(tbl_khuyenMai.getModel().getValueAt(rowindex, 0).toString());
            return ID;
            
        } else {
            return 1;
        }
        
    }
    public void fillTableMa() {
        DefaultTableModel model = (DefaultTableModel) tbl_khuyenMai.getModel();
        model.setRowCount(0);
        String keyString = txt_timkiem.getText();
        List<Voucher> list =  voucherService.searchTen(keyString);
        if (list.isEmpty()) {
            lbl_tim.setText("Không có Voucher nào" + keyString);
            return;
        }
        for (Voucher v : list) {
            tbl_model.addRow(new Object[]{
                v.getIDVoucher(),v.getMaGiamGia(),v.getGiamgia(),v.getNgaytao(),v.getNgayBatDau(),v.getNgayKetThuc(),v.isTrangThai() == true ?"Đang Hoạt Động":"Ngừng Hoạt Động"
            });
        }
        
        lbl_tim.setText("");
    }
    public boolean valedate(){
        if (txt_giamgia.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi Giảm Giá Đang Trống Nha");
            return false;
        }
        if (txt_soluong.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi Số Lượng Đang Trống Nha");
            return false;
        }
        try {
            Float.parseFloat(txt_giamgia.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Bạn ơi, Giảm Giá Phải Là Số Nha");
            return false;
        }
        try {
            Float.parseFloat(txt_soluong.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Bạn ơi, Số Lượng Phải Là Số Nha");
            return false;
        }
        if (!rdo_DangHoatDong.isSelected() && !rdo_NgungHoatDong.isSelected()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi, Trạng Thái bạn chưa chọn nha");
            return false;
        }
       return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NgayBatDau = new com.raven.datechooser.DateChooser();
        NgayKetThuc = new com.raven.datechooser.DateChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_timkiem = new View.form.TextField();
        lbl_tim = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_khuyenMai = new View.form.TableColumn();
        jPanel4 = new javax.swing.JPanel();
        txt_giamgia = new View.form.TextField();
        txt_soluong = new View.form.TextField();
        txt_NgayBatDau = new View.form.TextField();
        txt_NgayKetThuc = new View.form.TextField();
        btn_them = new View.form.MyButton();
        btn_sua = new View.form.MyButton();
        btn_xoa = new View.form.MyButton();
        btn_taomoi = new View.form.MyButton();
        txt_ID = new View.form.TextField();
        rdo_DangHoatDong = new View.form.RadioButtonCustom();
        rdo_NgungHoatDong = new View.form.RadioButtonCustom();

        NgayBatDau.setDateFormat("yyyy-MM-dd");
        NgayBatDau.setTextRefernce(txt_NgayBatDau);

        NgayKetThuc.setDateFormat("yyyy-MM-dd");
        NgayKetThuc.setTextRefernce(txt_NgayKetThuc);
        NgayKetThuc.setVerifyInputWhenFocusTarget(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Khuyến Mãi");

        txt_timkiem.setLabelText("Tìm theo mã");
        txt_timkiem.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                txt_timkiemComponentAdded(evt);
            }
        });
        txt_timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timkiemCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_tim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lbl_tim)
                .addContainerGap())
        );

        tbl_khuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã Voucher", "Phần % Giảm Giá", "Ngày Tạo", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Trạng Thái"
            }
        ));
        tbl_khuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_khuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_khuyenMai);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txt_giamgia.setLabelText("Giảm GIá %");

        txt_soluong.setLabelText("Số Lượng ");

        txt_NgayBatDau.setToolTipText("");
        txt_NgayBatDau.setLabelText("Ngày Bắt Đầu");
        txt_NgayBatDau.setSelectionEnd(10);
        txt_NgayBatDau.setSelectionStart(10);

        txt_NgayKetThuc.setLabelText("Ngày Kết Thúc");
        txt_NgayKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NgayKetThucActionPerformed(evt);
            }
        });

        btn_them.setText("Thêm");
        btn_them.setRadius(20);
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.setRadius(20);
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xóa");
        btn_xoa.setRadius(20);
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_taomoi.setText("Tạo Mới");
        btn_taomoi.setRadius(20);

        txt_ID.setLabelText("ID");

        buttonGroup1.add(rdo_DangHoatDong);
        rdo_DangHoatDong.setText("Đang Hoạt Động");

        buttonGroup1.add(rdo_NgungHoatDong);
        rdo_NgungHoatDong.setText("Ngừng Hoạt Động");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_NgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addComponent(txt_NgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(48, 48, 48)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_taomoi, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(txt_giamgia, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addComponent(txt_soluong, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                        .addComponent(txt_ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(rdo_DangHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdo_NgungHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_giamgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_NgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_NgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdo_NgungHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdo_DangHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_taomoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(845, 845, 845))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1927, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 1, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_NgayKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NgayKetThucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NgayKetThucActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        if (valedate()) {
            Voucher v= guidata();
        JOptionPane.showMessageDialog(this,voucherService.insert(v));
        ListVoucher = voucherService.getListVouchers();
        filldata();
        reset();
        }
        
    }//GEN-LAST:event_btn_themActionPerformed

    private void tbl_khuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_khuyenMaiMouseClicked
        // TODO add your handling code here:
        try {
            index = tbl_khuyenMai.getSelectedRow();
            showdeil();
            btn_sua.setEnabled(true);
            btn_xoa.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this ," loi click");
        }
    }//GEN-LAST:event_tbl_khuyenMaiMouseClicked

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        Voucher newv= guidata();
        newv.setIDVoucher(getVoucher());
        JOptionPane.showMessageDialog(this, voucherService.DeleteVoucher(newv));
        ListVoucher = voucherService.getListVouchers();
        filldata();
        reset();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        Voucher newv= guidata01();
        newv.setIDVoucher(getVoucher());
        JOptionPane.showMessageDialog(this, voucherService.updateVoucher(newv));
        ListVoucher = voucherService.getListVouchers();
        filldata();
        reset();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void txt_timkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timkiemCaretUpdate
        // TODO add your handling code here:
        fillTableMa();
    }//GEN-LAST:event_txt_timkiemCaretUpdate

    private void txt_timkiemComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txt_timkiemComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timkiemComponentAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser NgayBatDau;
    private com.raven.datechooser.DateChooser NgayKetThuc;
    private View.form.MyButton btn_sua;
    private View.form.MyButton btn_taomoi;
    private View.form.MyButton btn_them;
    private View.form.MyButton btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_tim;
    private View.form.RadioButtonCustom rdo_DangHoatDong;
    private View.form.RadioButtonCustom rdo_NgungHoatDong;
    private View.form.TableColumn tbl_khuyenMai;
    private View.form.TextField txt_ID;
    private View.form.TextField txt_NgayBatDau;
    private View.form.TextField txt_NgayKetThuc;
    private View.form.TextField txt_giamgia;
    private View.form.TextField txt_soluong;
    private View.form.TextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
