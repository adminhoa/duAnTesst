/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.form.giaodich;

import Service.Impl.DoiHangImpl;
import Services.DoiHangService;
import View.login.Auth;
import View.login.XDate;
import ViewModel.CTDoiHDViewModel;
import ViewModel.CTDoiSPViewModel;
import ViewModel.HDBanViewModel;
import ViewModel.HDDoiSPViewModel;
import ViewModel.HDTraHangViewModel;
import ViewModel.NhapHangViewModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class ViewDoiHang extends javax.swing.JPanel {

    /**
     * Creates new form DoiHang
     */
    DefaultTableModel model = null;
    DefaultTableModel modelList = null;
    ViewDoiSanPham viewDoiSanPham = new ViewDoiSanPham();
    List<NhapHangViewModel> list2 = new ArrayList<>();

    public ViewDoiHang() {
        initComponents();
        model = new DefaultTableModel();
        modelList = new DefaultTableModel();
    }

    List<NhapHangViewModel> listPr;

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

    public void fillTableListProduct(List<NhapHangViewModel> list) {
        modelList = (DefaultTableModel) tbl2.getModel();

        int totalRow = tbl2.getRowCount();

        for (int i = 0; i < list.size(); i++) {
            NhapHangViewModel p = list.get(i);
            if (tbl2.getRowCount() <= 0) {
                for (NhapHangViewModel p2 : list) {
                    modelList.addRow(new Object[]{
                        p2.getIdchitietsach(),
                        p2.getTenSach(),
                        p2.getTenNxb(),
                        p2.getTenTacGia(),
                        p2.getTenNgonNgu(),
                        p2.getGia() + " đ",
                        p2.getSoluong()
                    });
                }
            } else {
                for (int j = 0; j < totalRow; j++) {
                    if (p.getIdchitietsach() == (int) tbl2.getValueAt(j, 0)) {
                        p.setSoluong(p.getSoluong() + (int) tbl2.getValueAt(j, 6));
                        tbl2.setValueAt(p.getSoluong(), j, 6);
                    } else {
                        modelList.addRow(new Object[]{
                            p.getIdchitietsach(),
                            p.getTenSach(),
                            p.getTenNxb(),
                            p.getTenTacGia(),
                            p.getTenNgonNgu(),
                            p.getGia() + " đ",
                            p.getSoluong()
                        });

                    }
                }
            }
        }
        for (int i = 0; i < tbl2.getRowCount(); i++) {
            for (int j = i + 1; j < tbl2.getRowCount(); j++) {
                if ((int) tbl2.getValueAt(i, 0) == (int) tbl2.getValueAt(j, 0)) {
                    modelList.removeRow(j);
                    j--;
                }
            }
        }
    }

    List<CTDoiHDViewModel> listCTDoiHD = new ArrayList<>();
    List<CTDoiSPViewModel> listCTDoiSP = new ArrayList<>();
    DoiHangService doiHangService = new DoiHangImpl();

    public void getDetailInvoiceChange() {
        for (int i = 0; i < tbl1.getRowCount(); i++) {
            if (!(listPr.get(i).getSoluong() == (int) tbl1.getValueAt(i, 3))) {
                CTDoiHDViewModel de = new CTDoiHDViewModel();
                int idPr = (int) tbl1.getValueAt(i, 1);
                int slg = (int) tbl1.getValueAt(i, 4);
                de.setIdCTSach(idPr);
                de.setSoLuong(slg);
                listCTDoiHD.add(de);
                NhapHangViewModel p = doiHangService.selectById(idPr);
                System.out.println(doiHangService.updateSoLg(p.getSoluong() + slg, idPr));
            }
        }
    }

    public void getDetailChangeProduct() {
        for (int i = 0; i < tbl2.getRowCount(); i++) {
            CTDoiSPViewModel de = new CTDoiSPViewModel();
            int idPr = (int) tbl2.getValueAt(i, 0);
            int slg = (int) tbl2.getValueAt(i, 6);
            de.setIdCTSach(idPr);
            de.setSoLuong(slg);
            listCTDoiSP.add(de);
            NhapHangViewModel p = doiHangService.selectById(idPr);
            System.out.println(doiHangService.updateSoLg(p.getSoluong() - slg, idPr));
        }
    }

    public boolean ShearchKeyFillTable(int id) {
        model = (DefaultTableModel) tbl1.getModel();
        modelList = (DefaultTableModel) tbl2.getModel();
        modelList.setRowCount(0);
        list2.clear();
        model.setRowCount(0);

        System.out.println(listPr = doiHangService.selectByIdHDTra(id));
        for (NhapHangViewModel d : listPr) {
            model.addRow(new Object[]{
                d.getIdHoaDonBan(),
                d.getIdchitietsach(),
                d.getTenSach(),
                d.getSoluong(),
                0,
                d.getTenNxb(),
                d.getTenTacGia(),
                d.getTenNgonNgu(),
                d.getGia() + " đ"
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

    public List<NhapHangViewModel> fillTableByPrice() {
        int row = tbl1.getSelectedRow();
        float price = Float.parseFloat(fomartFloat((String) tbl1.getValueAt(tbl1.getSelectedRow(), 8)));
        int id = (int) tbl1.getValueAt(row, 1);

        return doiHangService.selectByGia(price, id);
    }

    public HDDoiSPViewModel getInvoiceChange() {
        HDDoiSPViewModel ir = new HDDoiSPViewModel();
//        Calendar calendar = Calendar.getInstance();
//        ir.setNgaytaoHDTra(XDate.toString(calendar.getTime(), "hh:mm:ss aa yyyy-MM-dd"));
        ir.setMoTa(txt_GhiChu.getText());
        ir.setIDHoaDonBanHang(Integer.valueOf(txt_timkiemhoadon.getText()));
        ir.setIdUsers(Auth.user.getIdusers());
        List<NhapHangViewModel> items = doiHangService.selectByIdHDTra(Integer.parseInt(txt_timkiemhoadon.getText()));
        for (NhapHangViewModel p : items) {
            ir.setIDKhachHang(p.getIdKhachHang());
            ir.setTenKhachHang(p.getTenKhachHang());
            break;
        }
        return ir;
    }

    public void insertInvoiceChange() {
        HDDoiSPViewModel ir = getInvoiceChange();
        System.out.println(doiHangService.insertHDDoi(ir));
        getDetailInvoiceChange();
        getDetailChangeProduct();
        for (int i = 0; i < listCTDoiHD.size(); i++) {
            System.out.println(doiHangService.insertCTDoiHD(listCTDoiHD.get(i)));
        }
        List<CTDoiHDViewModel> listDe = doiHangService.selectAllCTDoiHD();

        for (int i = 0; i < listCTDoiSP.size(); i++) {
            System.out.println(doiHangService.insertCTDoiSp(listCTDoiSP.get(i)));
        }
        JOptionPane.showMessageDialog(this, "Đổi hàng thành công !!!");
    }

    public boolean checkChange() {
        List<HDDoiSPViewModel> list = doiHangService.selectAllHDDoiSP();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIDHoaDonBanHang() == Integer.parseInt(txt_timkiemhoadon.getText())) {
                return false;
            }
        }
        list2.clear();
        return true;
    }
 public boolean checkDayChange() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date sDate = sdf.parse(listPr.get(0).getNgaytao());
            Date eDate = sdf.parse(XDate.toString(new Date(), "yyyy-MM-dd"));
            long sValue = sDate.getTime();
            long eValue = eDate.getTime();
            long tmp = Math.abs(sValue - eValue);
            long result = tmp / (24 * 60 * 60 * 1000);
            if (result > 2) {
                JOptionPane.showMessageDialog(txt_timkiemhoadon, "Ngày đổi sản phẩm đã quá hạn");
                lbl_Search.setText("Ngày đổi sản phẩm đã quá hạn");

                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_timkiemhoadon = new View.form.TextField();
        lbl_Search = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new View.form.TableColumn();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl2 = new View.form.TableColumn();
        jPanel4 = new javax.swing.JPanel();
        txt_khachhang = new View.form.TextField();
        txt_mahoadon = new View.form.TextField();
        txt_sanphamtra = new View.form.TextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_GhiChu = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        btn_doitra = new View.form.MyButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Đổi Hàng");

        jLabel1.setText("Tìm Kiếm");

        txt_timkiemhoadon.setLabelText("Tìm Kiếm Hóa Đơn");
        txt_timkiemhoadon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timkiemhoadonKeyReleased(evt);
            }
        });

        lbl_Search.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(118, 118, 118)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(txt_timkiemhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txt_timkiemhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Search, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDHDBan", "ID Sach", "Ten Sach", "So luong", "So luong doi", "NXB", "Tac Gia", "Ngon Ngu", "Don gia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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
            tbl1.getColumnModel().getColumn(8).setResizable(false);
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản Phẩm Đổi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        tbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Sach", "Ten Sach", "NXB", "Tac Gia", "Ngon Ngu", "Don Gia", "So Luong"
            }
        ));
        tbl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        txt_khachhang.setEditable(false);
        txt_khachhang.setLabelText("Khách Hàng");

        txt_mahoadon.setEditable(false);
        txt_mahoadon.setLabelText("Mã Hóa Đơn");

        txt_sanphamtra.setEditable(false);
        txt_sanphamtra.setLabelText("Sản Phẩm Đổi");

        txt_GhiChu.setColumns(20);
        txt_GhiChu.setRows(5);
        jScrollPane3.setViewportView(txt_GhiChu);

        jLabel3.setText("Ghi Chú");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_khachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_mahoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txt_sanphamtra, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_mahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(txt_sanphamtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        btn_doitra.setText("Đổi Trả");
        btn_doitra.setRadius(20);
        btn_doitra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_doitraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_doitra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(124, 124, 124))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_doitra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl2MouseClicked
        // TODO add your handling code here:
         int row = tbl2.getSelectedRow();
        int id = (int) tbl2.getValueAt(row, 0);
    }//GEN-LAST:event_tbl2MouseClicked

    private void btn_doitraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doitraActionPerformed
        // TODO add your handling code here:
        try {
            insertInvoiceChange();
        model.setRowCount(0);
        modelList.setRowCount(0);
        lbl_Search.setText("");
        txt_khachhang.setText("");
        txt_mahoadon.setText("");
        txt_GhiChu.setText("");
        txt_timkiemhoadon.setText("");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_doitraActionPerformed

       public boolean checkVoucher() {
        List<HDBanViewModel> list = doiHangService.selectAllHDBan();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdHoaDonBan() == Integer.parseInt(txt_timkiemhoadon.getText())) {
                if (list.get(i).getIdVoucher() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkReturn() {
        
        List<HDTraHangViewModel> hDTraHangViewModels= doiHangService.selectAllHDTra();
        for (int i = 0; i < hDTraHangViewModels.size(); i++) {
            if (hDTraHangViewModels.get(i).getMaHoaDonBan() == Integer.parseInt(txt_timkiemhoadon.getText())) {
                return false;
            }
        }
        return true;
    }
    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        // TODO add your handling code here:
        
        txt_sanphamtra.setText((String) tbl1.getValueAt(tbl1.getSelectedRow(), 2));
//        if (evt.getClickCount() > 1) {
//            return;
//        }
        if (checkDayChange() == false) {
            JOptionPane.showMessageDialog(this, "Hoá đơn đã quá hạn đổi");
            return;
        } else if (checkChange() == false) {
            JOptionPane.showMessageDialog(this, "Hoá đơn đã đổi hàng");
            return;
        } else if (checkReturn() == false) {
            JOptionPane.showMessageDialog(this, "Hoá đơn đã trả hàng");
            return;
        } else if (checkVoucher() == false) {
            JOptionPane.showMessageDialog(this, "Hoá đơn có voucher không thể đổi");
            return;
        } else {
            try {
                int quantity = Integer.valueOf(JOptionPane.showInputDialog(this, "Bạn cần nhập số lượng cần hoàn trả"));
                int row = tbl1.getSelectedRow();
                int quantityOnTable = (int) tbl1.getValueAt(row, 3);
                float price = Float.parseFloat(fomartFloat((String) tbl1.getValueAt(tbl1.getSelectedRow(), 8)));
                if (quantity > quantityOnTable || quantity < 0) {
                    JOptionPane.showMessageDialog(this, "Bạn đã nhập sai số lượng");
                    return;
                }
                List<NhapHangViewModel> list = fillTableByPrice();
                for (int i = 0; i < tbl2.getRowCount(); i++) {
                    int idPr = (int) tbl2.getValueAt(i, 0);
                    NhapHangViewModel pr = doiHangService.selectById(idPr);
                    int quantityList2 = (int) tbl2.getValueAt(i, 6);
                    pr.setSoluong(quantityList2);
                    list2.add(pr);
                }

                viewDoiSanPham = new ViewDoiSanPham(list, (float) quantity * price, list2);
                viewDoiSanPham.setVisible(true);
                viewDoiSanPham.addEvenFillTable(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        List<NhapHangViewModel> list = viewDoiSanPham.addToFormChangeProduct();
                        int iquantity = ((int) tbl1.getValueAt(row, 3)) - quantity;
                        tbl1.setValueAt(iquantity, row, 3);
                        tbl1.setValueAt((int) tbl1.getValueAt(row, 4) + quantity, row, 4);
                        fillTableListProduct(list);

                    }
                });
            } catch (Exception e) {
            }
        }
        
    }//GEN-LAST:event_tbl1MouseClicked

    private void txt_timkiemhoadonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timkiemhoadonKeyReleased
        // TODO add your handling code here:
           if (txt_timkiemhoadon.getText().isEmpty()) {
            lbl_Search.setText("");
            txt_mahoadon.setText("");
            lbl_Search.setText("");
            model.setRowCount(0);
            modelList.setRowCount(0);
            return;
        }
        try {
            if (ShearchKeyFillTable(Integer.valueOf(txt_timkiemhoadon.getText())) == false) {
                lbl_Search.setText("Hoá đơn không tồn tại");
                return;
            } else {
                lbl_Search.setText("");
            }
            if (checkChange() == false) {
                lbl_Search.setText("Hoá đơn đã đổi hàng");
                return;
            }
            if (checkReturn() == false) {
                lbl_Search.setText("Hoá đơn đã trả hàng");
                return;
            }
            if (checkVoucher() == false) {
                lbl_Search.setText("Hoá đơn có voucher không thể đổi");
                return;
            }
            if (checkDayChange() == false) {
                return;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(txt_timkiemhoadon, "Vui lòng nhập lại ");
            lbl_Search.setText("Vui lòng nhập lại ");
        }
    }//GEN-LAST:event_txt_timkiemhoadonKeyReleased

public void delete() {
        DefaultTableModel model = (DefaultTableModel) tbl2.getModel();
        if (tbl2.getSelectedRowCount() == 1) {
            for (int i = 0; i < tbl1.getRowCount(); i++) {
                if (tbl1.getValueAt(tbl1.getSelectedRow(), 1).equals(tbl2.getValueAt(i, 0))) {
                    int ii = (int) tbl2.getValueAt(i, 6) + (int) tbl1.getValueAt(tbl1.getSelectedRow(), 3);
                    tbl1.setValueAt(ii, i, 3);
                    tbl1.setValueAt((int) tbl1.getValueAt(tbl1.getSelectedRow(), 4) - 1, i, 4);
                }
            }
            for (int i = 0; i < listPr.size(); i++) {
                if (listPr.get(i).getIdchitietsach() == (int) tbl2.getValueAt(tbl2.getSelectedRow(), 1)) {
                    model.removeRow(tbl2.getSelectedRow());
                    listPr.remove(listPr.get(i));
                    return;
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.form.MyButton btn_doitra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_Search;
    private View.form.TableColumn tbl1;
    private View.form.TableColumn tbl2;
    private javax.swing.JTextArea txt_GhiChu;
    private View.form.TextField txt_khachhang;
    private View.form.TextField txt_mahoadon;
    private View.form.TextField txt_sanphamtra;
    private View.form.TextField txt_timkiemhoadon;
    // End of variables declaration//GEN-END:variables
}
