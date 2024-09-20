/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.form.giaodich;

import Service.Impl.DoiHangImpl;
import Services.DoiHangService;
import ViewModel.NhapHangViewModel;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class ViewDoiSanPham extends javax.swing.JFrame {

    DefaultTableModel modelList = null;
    DefaultTableModel model = null;
    DoiHangService doiHangService = new DoiHangImpl();
    /**
     * Creates new form ViewDoiSanPham
     */
    float total = 0;
    List<NhapHangViewModel> list = new ArrayList<>();

    public ViewDoiSanPham() {
        initComponents();
    }

    public String deleteLastKey(String str) {
        if (str.charAt(str.length() - 1) == 'đ') {
            str = str.replace(str.substring(str.length() - 1), "");
            return str;
        } else {
            return str;
        }
    }

    public String fomartFloat(String txt) {
        String pattern = deleteLastKey(txt);
        return pattern = pattern.replaceAll(",", "");
    }
    Locale lc = new Locale("nv", "VN");
    NumberFormat nf = NumberFormat.getInstance(lc);

    public ViewDoiSanPham(List<NhapHangViewModel> list, float totatMoney, List<NhapHangViewModel> list2) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        total = totatMoney;
        txt_TienTra.setText(nf.format(total) + " đ");
        modelList = (DefaultTableModel) tbl1.getModel();
        for (int i = 0; i < list.size(); i++) {
            NhapHangViewModel p = list.get(i);
            if (p.getSoluong() < 0) {
                modelList.addRow(new Object[]{
                    p.getIdchitietsach(),
                    p.getTenSach(),
                    p.getTenNxb(),
                    p.getTenTacGia(),
                    p.getTenNgonNgu(),
                    nf.format(p.getGia()) + " đ",
                    p.getSoluong()
                });
            } else if ((list2.size() > 0)) {
                for (int j = 0; j < list2.size(); j++) {
                    if (p.getIdchitietsach() == list2.get(j).getIdchitietsach()) {
                        p.setSoluong(p.getSoluong() - list2.get(j).getSoluong());
                    }
                }
                modelList.addRow(new Object[]{
                    p.getIdchitietsach(),
                    p.getTenSach(),
                    p.getTenNxb(),
                    p.getTenTacGia(),
                    p.getTenNgonNgu(),
                    nf.format(p.getGia()) + " đ",
                    p.getSoluong()
                });

            } else {
                modelList.addRow(new Object[]{
                    p.getIdchitietsach(),
                    p.getTenSach(),
                    p.getTenNxb(),
                    p.getTenTacGia(),
                    p.getTenNgonNgu(),
                    nf.format(p.getGia()) + " đ",
                    p.getSoluong()
                });
            }
        }
    }

    public void fillTableIn4Invoice() {
        try {
            int quatity = Integer.valueOf(JOptionPane.showInputDialog(this, "Nhập số lượng"));
            int row = tbl1.getSelectedRow();
            int id = (int) tbl1.getValueAt(row, 0);
            String name = (String) tbl1.getValueAt(row, 1);
            String size = (String) tbl1.getValueAt(row, 2);
            String color = (String) tbl1.getValueAt(row, 3);
            String material = (String) tbl1.getValueAt(row, 4);
            float price = Float.parseFloat(fomartFloat((String) tbl1.getValueAt(tbl1.getSelectedRow(), 5)));
            if (quatity > (int) tbl1.getValueAt(row, 6) || quatity < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng hàng trả không hợp lệ ");
            } else {
                if (total - (price * quatity) < 0) {
                    JOptionPane.showMessageDialog(this, "Bạn đã chọn quá số tiền được đổi");
                    return;
                }
                total = total - (price * quatity);
                txt_TienTra.setText(nf.format(total) + " đ");
                model = (DefaultTableModel) tbl2.getModel();
                model.addRow(new Object[]{
                    id, name, size, color, material, price, quatity
                });
                int i = ((int) tbl1.getValueAt(row, 6)) - quatity;
                tbl1.setValueAt(i, row, 6);
                tbl1.clearSelection();

                NhapHangViewModel pr = doiHangService.selectById(id);
                pr.setSoluong(quatity);
                list.add(pr);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn số lượng hoàn trả ");
        }
    }

    public List<NhapHangViewModel> addToFormChangeProduct() {
        if (!list.isEmpty()) {
            model = (DefaultTableModel) tbl2.getModel();
            model.setRowCount(0);
            this.dispose();
            JOptionPane.showMessageDialog(this, "Thêm SP đổi thành công");
            return list;
        }
        JOptionPane.showMessageDialog(this, "Bạn chưa thêm SP nào");
        return null;
    }

    public void addEvenFillTable(ActionListener evt) {
        btn_DoiHang.addActionListener(evt);
    }

    public void delete() {
        if (tbl2.getSelectedRowCount() == 1) {

            for (int i = 0; i < tbl1.getRowCount(); i++) {
                if (tbl1.getValueAt(i, 0).equals(tbl2.getValueAt(tbl2.getSelectedRow(), 0))) {
                    tbl1.setValueAt((int) tbl1.getValueAt(i, 6) + (int) tbl2.getValueAt(tbl2.getSelectedRow(), 6), i, 6);
                }
            }

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getIdchitietsach() == (int) tbl2.getValueAt(tbl2.getSelectedRow(), 0)) {
                    list.remove(list.get(i));
                    total = total + (float) tbl2.getValueAt(tbl2.getSelectedRow(), 5) * (int) tbl2.getValueAt(tbl2.getSelectedRow(), 6);
                    txt_TienTra.setText(nf.format(total) + " đ");
                    model.removeRow(tbl2.getSelectedRow());
                }
            }

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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new View.form.TableColumn();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl2 = new View.form.TableColumn();
        jLabel1 = new javax.swing.JLabel();
        txt_TienTra = new View.form.TextField();
        btn_Xoa = new View.form.MyButton();
        btn_DoiHang = new View.form.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbl1.setBackground(new java.awt.Color(255, 255, 255));
        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma Sach", "Ten Sach", "NXB", "Tac Gia", "Ngon Ngu", "Don Gia", "So Luong"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl1);
        if (tbl1.getColumnModel().getColumnCount() > 0) {
            tbl1.getColumnModel().getColumn(0).setResizable(false);
            tbl1.getColumnModel().getColumn(1).setResizable(false);
            tbl1.getColumnModel().getColumn(2).setResizable(false);
            tbl1.getColumnModel().getColumn(3).setResizable(false);
            tbl1.getColumnModel().getColumn(4).setResizable(false);
            tbl1.getColumnModel().getColumn(5).setResizable(false);
            tbl1.getColumnModel().getColumn(6).setResizable(false);
        }

        tbl2.setBackground(new java.awt.Color(255, 255, 255));
        tbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma Sach", "Ten Sach", "NXB", "Tac Gia", "Ngon Ngu", "Don Gia", "So Luong"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl2.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tbl2);
        if (tbl2.getColumnModel().getColumnCount() > 0) {
            tbl2.getColumnModel().getColumn(0).setResizable(false);
            tbl2.getColumnModel().getColumn(1).setResizable(false);
            tbl2.getColumnModel().getColumn(2).setResizable(false);
            tbl2.getColumnModel().getColumn(3).setResizable(false);
            tbl2.getColumnModel().getColumn(4).setResizable(false);
            tbl2.getColumnModel().getColumn(5).setResizable(false);
            tbl2.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel1.setText("Tiền cần trả khách");

        txt_TienTra.setLabelText("");

        btn_Xoa.setText("Xoa");
        btn_Xoa.setRadius(20);
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        btn_DoiHang.setText("Doi Hang");
        btn_DoiHang.setRadius(20);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_DoiHang, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txt_TienTra, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_TienTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btn_DoiHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(122, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        // TODO add your handling code here:
        fillTableIn4Invoice();
    }//GEN-LAST:event_tbl1MouseClicked

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btn_XoaActionPerformed

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
            java.util.logging.Logger.getLogger(ViewDoiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDoiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDoiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDoiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewDoiSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.form.MyButton btn_DoiHang;
    private View.form.MyButton btn_Xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private View.form.TableColumn tbl1;
    private View.form.TableColumn tbl2;
    private View.form.TextField txt_TienTra;
    // End of variables declaration//GEN-END:variables
}
