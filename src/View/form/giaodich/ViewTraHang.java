/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.form.giaodich;

import Service.Impl.HoaDonTraHangImpl;
import Services.HoaDonTraHangService;
import View.login.Auth;
import View.login.XDate;
import ViewModel.CTHDTraHangViewModel;
import ViewModel.HDBanViewModel;
import ViewModel.HDDoiSPViewModel;
import ViewModel.HDTraHangViewModel;
import ViewModel.NhapHangViewModel;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class ViewTraHang extends javax.swing.JPanel {

    DefaultTableModel model = null;
    DefaultTableModel modelList = null;
    List<NhapHangViewModel> listPr;
    HoaDonTraHangService hoaDonTraHangService = new HoaDonTraHangImpl();

    /**
     * Creates new form TraHang
     */
    public ViewTraHang() {
        initComponents();
        model = new DefaultTableModel();
        modelList = new DefaultTableModel();
    }

    public boolean ShearchKeyFillTable(int id) {
        model = (DefaultTableModel) tbl1.getModel();
        model.setRowCount(0);

        listPr = hoaDonTraHangService.selectByIdInvoiceReturn(id);
        for (NhapHangViewModel d : listPr) {
            model.addRow(new Object[]{
                d.getIdHoaDonBan(),
                d.getIdchitietsach(),
                d.getTenSach(),
                d.getSoluong(),
                d.getTenNxb(),
                d.getTenTacGia(),
                d.getTenNgonNgu(),
                d.getGia()
            });
            txt_khachhang.setText(d.getTenKhachHang());
            txt_mahoadon.setText(d.getIdHoaDonBan() + "");
        }
        if (listPr.size() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkDayReturn() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date sDate = sdf.parse(listPr.get(0).getNgaytao());
            Date eDate = sdf.parse(XDate.toString(new Date(), "yyyy-MM-dd"));
            long sValue = sDate.getTime();
            long eValue = eDate.getTime();
            long tmp = Math.abs(sValue - eValue);
            long result = tmp / (24 * 60 * 60 * 1000);
            System.out.println(result);
            if (result > 2) {
                lblSearch.setText("Ngày trả hoá đơn đã quá hạn");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }

    public boolean checkVoucher() {
        List<HDBanViewModel> list = hoaDonTraHangService.selectAllCheckVoucher();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdHoaDonBan() == Integer.parseInt(txt_timkiem.getText())) {
                if (list.get(i).getIdVoucher() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkReturn() {
        List<HDTraHangViewModel> list = hoaDonTraHangService.selectAllHDTra();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaHoaDonBan() == Integer.parseInt(txt_timkiem.getText())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkChange() {
        List<HDDoiSPViewModel> list = hoaDonTraHangService.selectAllHDDoi();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIDHoaDonBanHang() == Integer.parseInt(txt_timkiem.getText())) {
                return false;
            }
        }
        return true;
    }
    List<CTHDTraHangViewModel> list = new ArrayList<>();
    Locale lc = new Locale("nv", "VN");
    NumberFormat nf = NumberFormat.getInstance(lc);

    float priceTotal;

    public void fillTableIn4Invoice() {
        try {
            boolean flag = false;
            int quatity = Integer.valueOf(JOptionPane.showInputDialog(this, "Nhập số lượng cần hoàn trả"));
            int row = tbl1.getSelectedRow();
            int idHDBan = (int) tbl1.getValueAt(row, 0);
            int idSach = (int) tbl1.getValueAt(row, 1);
            String name = (String) tbl1.getValueAt(row, 2);
            int slg = (int) tbl1.getValueAt(row, 3);
            String NXB = (String) tbl1.getValueAt(row, 4);
            String TacGia = (String) tbl1.getValueAt(row, 5);
            String NgonNgu = (String) tbl1.getValueAt(row, 6);
            float price = (float) tbl1.getValueAt(row, 7);

            if (quatity > (int) tbl1.getValueAt(row, 3) || quatity < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng trả hàng không hợp lệ");
            } else {
                modelList = (DefaultTableModel) tbl2.getModel();
                modelList.addRow(new Object[]{
                    idSach, name, quatity, NXB, TacGia, NgonNgu, price
                });
                int i = ((int) tbl1.getValueAt(row, 3)) - quatity;
                tbl1.setValueAt(i, row, 3);
                txt_tienhoantra.setText(nf.format(TotalBuy()) + " đ");
                priceTotal = TotalBuy();
                CTHDTraHangViewModel dir = new CTHDTraHangViewModel();
                dir.setTongTien(price);
                dir.setIdCtSach(idSach);
                dir.setSoLuong(quatity);
                list.add(dir);
                tbl1.clearSelection();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn số lượng hoàn trả ");
        }

    }

    public HDTraHangViewModel getInvoiceReturn() {
        HDTraHangViewModel ir = new HDTraHangViewModel();
        ir.setGhiChu(txt_ghichu.getText());
        ir.setMaHoaDonBan(Integer.valueOf(txt_timkiem.getText()));
        ir.setTongTienHoanTra(TotalBuy());
        ir.setIDUsers(Auth.user.getIdusers());
        List<NhapHangViewModel> items = hoaDonTraHangService.selectByIdInvoiceReturn(Integer.valueOf(txt_timkiem.getText()));
        for (NhapHangViewModel p : items) {
            ir.setIdKhachHang(p.getIdKhachHang());
            ir.setKhachHang(p.getTenKhachHang());
            break;
        }

        return ir;
    }

    public void insertInvoiceReturn() {
        HDTraHangViewModel ir = getInvoiceReturn();
        System.out.println(hoaDonTraHangService.insertHDTra(ir));
        JOptionPane.showMessageDialog(this, "Bạn đã trả hàng thành công!!!");
        int row = tbl2.getRowCount();
        for (int i = 0; i < list.size(); i++) {
            CTHDTraHangViewModel de = list.get(i);
            System.out.println(de.getSoLuong());
            System.out.println(hoaDonTraHangService.insertCTHDTra(de));
            hoaDonTraHangService.updateSlgCTSach(de.getSoLuong(), de.getIdCtSach());
        }
    }

    public float TotalBuy() {
        float price = 0;
        int index = tbl2.getRowCount();
        for (int i = 0; i < index; i++) {
            price += (int) tbl2.getValueAt(i, 2) * (float) tbl2.getValueAt(i, 6);
        }
        return price;
    }

    public void deleteTemp() {
        DefaultTableModel model = (DefaultTableModel) tbl2.getModel();
        int row = tbl1.getSelectedRow();
        int rowTemp = tbl2.getSelectedRow();

        if (tbl2.getSelectedRowCount() == 1) {
            for (int i = 0; i < tbl1.getRowCount(); i++) {
                if (tbl1.getValueAt(i, 1).equals(tbl2.getValueAt(rowTemp, 0))) {
                    int ii = (int) tbl1.getValueAt(i, 3) + (int) tbl2.getValueAt(rowTemp, 2);
                    tbl1.setValueAt(ii, i, 3);
                }
            }
            priceTotal = priceTotal - (float) tbl2.getValueAt(tbl2.getSelectedRow(), 6) * (int) tbl2.getValueAt(tbl2.getSelectedRow(), 2);
            txt_tienhoantra.setText(nf.format(priceTotal) + " đ");
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getIdCtSach() == (int) tbl2.getValueAt(rowTemp, 0)) {
                    model.removeRow(tbl2.getSelectedRow());
                    list.remove(list.get(j));
                    return;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_timkiem = new View.form.TextField();
        lblSearch = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new View.form.TableColumn();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl2 = new View.form.TableColumn();
        btn_xoa = new View.form.MyButton();
        jPanel4 = new javax.swing.JPanel();
        txt_khachhang = new View.form.TextField();
        txt_mahoadon = new View.form.TextField();
        txt_ghichu = new View.form.TextField();
        txt_tienhoantra = new View.form.TextField();
        btn_trahang = new View.form.MyButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Trả Hàng");

        jLabel2.setText("Tìm Kiếm :");

        txt_timkiem.setLabelText("Tìm kiếm hóa đơn");
        txt_timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timkiemCaretUpdate(evt);
            }
        });
        txt_timkiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_timkiemFocusGained(evt);
            }
        });
        txt_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timkiemActionPerformed(evt);
            }
        });
        txt_timkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timkiemKeyReleased(evt);
            }
        });

        lblSearch.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Ban Hang", "ID Sach", "Tên sách", "Số lượng", "TenNXB", "TenTG", "TenNN", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
            tbl1.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        tbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Sach", "Ten Sach", "So Luong Tra", "tenNXB", "tenTG", "tenNN", "Don gia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

        btn_xoa.setText("Xóa");
        btn_xoa.setRadius(20);
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        txt_khachhang.setEditable(false);
        txt_khachhang.setForeground(new java.awt.Color(255, 0, 0));
        txt_khachhang.setCaretColor(new java.awt.Color(255, 0, 0));
        txt_khachhang.setLabelText("Khách Hàng");

        txt_mahoadon.setEditable(false);
        txt_mahoadon.setForeground(new java.awt.Color(255, 0, 0));
        txt_mahoadon.setCaretColor(new java.awt.Color(255, 0, 0));
        txt_mahoadon.setLabelText("Mã Hóa Đơn");

        txt_ghichu.setLabelText("Ghi Chú");

        txt_tienhoantra.setEditable(false);
        txt_tienhoantra.setForeground(new java.awt.Color(255, 51, 51));
        txt_tienhoantra.setCaretColor(new java.awt.Color(255, 0, 0));
        txt_tienhoantra.setLabelText("Tiền Hoàn Trả");

        btn_trahang.setText("Trả Hàng");
        btn_trahang.setRadius(20);
        btn_trahang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trahangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_trahang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_khachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_mahoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_ghichu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_tienhoantra, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_mahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txt_tienhoantra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_trahang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timkiemActionPerformed

    private void txt_timkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timkiemCaretUpdate

    }//GEN-LAST:event_txt_timkiemCaretUpdate

    private void txt_timkiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_timkiemFocusGained
        lblSearch.setText("");
    }//GEN-LAST:event_txt_timkiemFocusGained

    private void txt_timkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timkiemKeyReleased
        if (txt_timkiem.getText().isEmpty()) {
            txt_khachhang.setText("");
            txt_mahoadon.setText("");
            lblSearch.setText("");
            model.setRowCount(0);
            modelList.setRowCount(0);
            return;
        }
        try {
            if (ShearchKeyFillTable(Integer.valueOf(txt_timkiem.getText())) == false) {
                lblSearch.setText("Hoá đơn không tồn tại");
                return;
            } else {
                lblSearch.setText("");

            }
            if (checkReturn() == false) {
                lblSearch.setText("Hoá đơn đã trả hàng");
                return;
            }
            if (checkVoucher() == false) {
                lblSearch.setText("Hoá đơn áp dụng voucher không thể trả");
                return;
            }
            if (checkChange() == false) {
                lblSearch.setText("Hoá đơn đã đổi không thể trả hàng");
                return;
            }
            if (checkDayReturn() == false) {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            lblSearch.setText("Vui lòng nhập lại -.-");
        }
    }//GEN-LAST:event_txt_timkiemKeyReleased

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        if (evt.getClickCount() == 2) {
            if (checkDayReturn() == false) {
                JOptionPane.showMessageDialog(this, "Hoá đơn đã quá hạn trả");
                return;
            } else if (checkReturn() == false) {
                JOptionPane.showMessageDialog(this, "Hoá đơn đã trả hàng");
                return;
            } else if (checkVoucher() == false) {
                JOptionPane.showMessageDialog(this, "Hoá đơn áp dụng voucher không thể trả");
                return;
            } else if (checkChange() == false) {
                JOptionPane.showMessageDialog(this, "Hoá đơn đã đổi không thể trả hàng");
                return;
            } else {
                fillTableIn4Invoice();
            }
        }

    }//GEN-LAST:event_tbl1MouseClicked

    private void btn_trahangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trahangActionPerformed
        try {
            insertInvoiceReturn();
            model.setRowCount(0);
            modelList.setRowCount(0);
            lblSearch.setText("");
            txt_khachhang.setText("");
            txt_mahoadon.setText("");
            txt_tienhoantra.setText("");
            txt_ghichu.setText("");
            txt_timkiem.setText("");
        } catch (Exception e) {
            System.out.println("Mời nhập lại");
        }
    }//GEN-LAST:event_btn_trahangActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        try {
            deleteTemp();
        } catch (Exception e) {
            System.out.println("Mời nhập lại");
        }
    }//GEN-LAST:event_btn_xoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.form.MyButton btn_trahang;
    private View.form.MyButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSearch;
    private View.form.TableColumn tbl1;
    private View.form.TableColumn tbl2;
    private View.form.TextField txt_ghichu;
    private View.form.TextField txt_khachhang;
    private View.form.TextField txt_mahoadon;
    private View.form.TextField txt_tienhoantra;
    private View.form.TextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
