/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.form.giaodich;

import Repository.ThongKeDoanhSoRepository;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class ViewThongKeDoanhSo extends javax.swing.JPanel {

    ThongKeDoanhSoRepository rep = new ThongKeDoanhSoRepository();
    public ViewThongKeDoanhSo() {
        initComponents();
        fillComboboxNam();
        rdo_bieudocot.setSelected(true);
    }
     public void fillComboboxNam() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_nam.getModel();
        model.removeAllElements();
        List<Integer> list = rep.selectNam();
        for (Integer nam : list) {
            model.addElement(nam);
        }

    }
     public void fillComboboxThang() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_thang.getModel();
        model.removeAllElements();
        int years = (int) cbo_nam.getSelectedItem();

        List<Integer> list = rep.selectMonths(years);
        for (Integer nam : list) {
            model.addElement(nam);
        }
        fillTable();
    }
     public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_thongkedoanhso.getModel();
        model.setRowCount(0);
        int year = (int) cbo_nam.getSelectedItem();
        int month = (int) cbo_thang.getSelectedItem();
        List<Object[]> list = rep.getSalesStatisticalDAO(year, month);
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rdo_bieudoduong = new javax.swing.JRadioButton();
        rdo_bieudocot = new javax.swing.JRadioButton();
        btn_bieudo = new View.form.MyButton();
        cbo_thang = new View.form.Combobox();
        cbo_nam = new View.form.Combobox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_thongkedoanhso = new View.form.TableColumn();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Thống Kê Doanh Số");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(860, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(rdo_bieudoduong);
        rdo_bieudoduong.setText("Biểu Đồ Đường");
        rdo_bieudoduong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_bieudoduongActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdo_bieudocot);
        rdo_bieudocot.setText("Biểu Đồ Cột");

        btn_bieudo.setText("Biểu Đồ");
        btn_bieudo.setToolTipText("");
        btn_bieudo.setRadius(20);
        btn_bieudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bieudoActionPerformed(evt);
            }
        });

        cbo_thang.setLabeText("Tháng");
        cbo_thang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_thangActionPerformed(evt);
            }
        });

        cbo_nam.setLabeText("Năm");
        cbo_nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_namActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rdo_bieudoduong)
                    .addComponent(rdo_bieudocot, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_bieudo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
            .addComponent(cbo_thang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cbo_nam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(cbo_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(rdo_bieudoduong)
                .addGap(18, 18, 18)
                .addComponent(rdo_bieudocot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_bieudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        tbl_thongkedoanhso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng Bán"
            }
        ));
        jScrollPane1.setViewportView(tbl_thongkedoanhso);
        if (tbl_thongkedoanhso.getColumnModel().getColumnCount() > 0) {
            tbl_thongkedoanhso.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdo_bieudoduongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_bieudoduongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_bieudoduongActionPerformed

    private void btn_bieudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bieudoActionPerformed
        // TODO add your handling code here:
        if (rdo_bieudocot.isSelected()) {
            new BieuDoCot((DefaultTableModel) tbl_thongkedoanhso.getModel(), null).setVisible(true);
        
        } else {
            new BieuDoDuong((DefaultTableModel) tbl_thongkedoanhso.getModel()).setVisible(true);
        }
    }//GEN-LAST:event_btn_bieudoActionPerformed

    private void cbo_namActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_namActionPerformed
        // TODO add your handling code here:
        fillComboboxThang();
    }//GEN-LAST:event_cbo_namActionPerformed

    private void cbo_thangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_thangActionPerformed
        // TODO add your handling code here:
        if (cbo_thang.getSelectedItem() == null) {
            return;
        } else {
            fillTable();
        }
    }//GEN-LAST:event_cbo_thangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.form.MyButton btn_bieudo;
    private javax.swing.ButtonGroup buttonGroup1;
    private View.form.Combobox cbo_nam;
    private View.form.Combobox cbo_thang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdo_bieudocot;
    private javax.swing.JRadioButton rdo_bieudoduong;
    private View.form.TableColumn tbl_thongkedoanhso;
    // End of variables declaration//GEN-END:variables
}
