/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.form.giaodich;

import DomainModel.KhachHang;
import Service.Impl.ChiTietHoaDonImpl;
import Service.Impl.HoaDonTraHangImpl;
import Service.Impl.KhachHangIMpl;
import Services.ChiTietHoaDonService;
import Services.HoaDonTraHangService;
import Services.KhachHangService;
import ViewModel.HDBanViewModel;
import ViewModel.HDDoiSPViewModel;
import ViewModel.HDTraHangViewModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class ViewHoaDonBanHang extends javax.swing.JPanel {

    DefaultTableModel tableModel = new DefaultTableModel();
    List<HDBanViewModel> listCTB;
    ChiTietHoaDonService chitiethoadonservice = new ChiTietHoaDonImpl();
    List<KhachHang> listKHg;
    
    boolean flag = false;
    HoaDonTraHangService donTraHangService = new HoaDonTraHangImpl();

    /**
     * Creates new form HoaDonBanHang
     */
    public ViewHoaDonBanHang() {
        initComponents();
        setOpaque(false);
        chitiethoadonservice = new ChiTietHoaDonImpl();
        fillData();
        btnFirst.setEnabled(false);
        btnFirst.setVisible(false);
        btnBack.setEnabled(false);
        btnBack.setVisible(false);
        cbbPagination.setEnabled(false);
        cbbPagination.setVisible(false);
        btnNext.setEnabled(false);
        btnNext.setVisible(false);
        btnLast.setEnabled(false);
        btnLast.setVisible(false);
    }
    int totalPage = 1;
    int page = 1;
    Integer totalData = 0;
    int rowCountPerPage = 5;
    public void edit() {
        if (page == 1) {
            btnFirst.setEnabled(false);
            btnBack.setEnabled(false);
        } else {
            btnFirst.setEnabled(true);
            btnBack.setEnabled(true);
        }

        if (page == totalPage) {
            btnLast.setEnabled(false);
            btnNext.setEnabled(false);
        } else {
            btnLast.setEnabled(true);
            btnNext.setEnabled(true);
        }

        if (page > totalPage) {
            page = 1;
        }
    }

    public void fillData() {
        tableModel = (DefaultTableModel) tbl_hoadonbanhang.getModel();
        listCTB = chitiethoadonservice.getAll("");
        KhachHangService khachHangService = new KhachHangIMpl();
        listKHg = khachHangService.getlistKhachHang();
        String phone = "";
        String status = "";
        List<HDDoiSPViewModel> listChange = donTraHangService.selectAllHDDoi();
        List<HDTraHangViewModel> listReturn = donTraHangService.selectAllHDTra();
        for (HDBanViewModel i : listCTB) {
            for (int j = 0; j < listKHg.size(); j++) {
                if (i.getIdKhachHang() == listKHg.get(j).getIdKhachHang()) {
                    phone = listKHg.get(j).getSoDienThoai();
                }
            }
            tableModel.addRow(new Object[]{
                i.getIdHoaDonBan(),
                i.getTenKhachHang(),
                phone,
                i.getTenUser(),
                i.getTongTien() + " đ",
                i.getNGAYTHANHTOAN(),
                i.getGhiChu()
            });
        }
        for (int i = 0; i < listCTB.size(); i++) {
            for (int j = 0; j < listReturn.size(); j++) {
                if (listReturn.get(j).getMaHoaDonBan() == listCTB.get(i).getIdHoaDonBan() ) {
//                    status = "Đã trả hàng";
                    tbl_hoadonbanhang.setValueAt("Đã trả hàng", i, 7);
                }
            }
        }
        for (int i = 0; i < listCTB.size(); i++) {
            for (int z = 0; z < listChange.size(); z++) {
                if (listChange.get(z).getIDHoaDonBanHang() == listCTB.get(i).getIdHoaDonBan()) {
//                    status = "Đã đổi hàng";
                    tbl_hoadonbanhang.setValueAt("Đã đổi hàng", i, 7);
                }
            }
        }

    }

    public void searchDateFillTable() {
        totalData = chitiethoadonservice.ThoiGian("");
        rowCountPerPage = Integer.valueOf(cbbPagination.getSelectedItem().toString());
        Double totalPageD = Math.ceil(totalData.doubleValue() / rowCountPerPage);
        totalPage = totalPageD.intValue();
        //edit();
        if (totalData == 0) {
            JOptionPane.showMessageDialog(this, "Ngày bạn chọn không có hóa đơn nào");
            return;
        }
        edit();
        tableModel = (DefaultTableModel) tbl_hoadonbanhang.getModel();
        tableModel.setRowCount(0);
        listCTB = chitiethoadonservice.getAll(txt_ThoiGian.getText());
        KhachHangService khachHangService = new KhachHangIMpl();
        listKHg = khachHangService.getlistKhachHang();
        String phone = "";
        String status = "";
        for (HDBanViewModel i : listCTB) {
            for (int j = 0; j < listKHg.size(); j++) {
                if (i.getIdKhachHang() == listKHg.get(j).getIdKhachHang()) {
                    phone = listKHg.get(j).getSoDienThoai();
                }
            }
            tableModel.addRow(new Object[]{
                i.getIdHoaDonBan(),
                i.getTenKhachHang(),
                phone,
                i.getTenUser(),
                i.getTongTien() + " đ",
                i.getNGAYTHANHTOAN(),
                i.getGhiChu()
            });
        }
        List<HDDoiSPViewModel> listChange = donTraHangService.selectAllHDDoi();
        List<HDTraHangViewModel> listReturn = donTraHangService.selectAllHDTra();
         for (int i = 0; i < listCTB.size(); i++) {
            for (int j = 0; j < listReturn.size(); j++) {
                if (listReturn.get(j).getMaHoaDonBan() == listCTB.get(i).getIdHoaDonBan() ) {
//                    status = "Đã trả hàng";
                    tbl_hoadonbanhang.setValueAt("Đã trả hàng", i, 7);
                }
            }
        }
        for (int i = 0; i < listCTB.size(); i++) {
            for (int z = 0; z < listChange.size(); z++) {
                if (listChange.get(z).getIDHoaDonBanHang() == listCTB.get(i).getIdHoaDonBan()) {
//                    status = "Đã đổi hàng";
                    tbl_hoadonbanhang.setValueAt("Đã đổi hàng", i, 7);
                }
            }
        }
        lbl_Count.setText("Page " + page + " for " + totalPage);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_timtheoma = new View.form.TextField();
        lbl_Search = new javax.swing.JLabel();
        btn_Tim = new View.form.MyButton();
        jPanel2 = new javax.swing.JPanel();
        txt_ThoiGian = new View.form.TextField();
        btn_loc = new View.form.MyButton();
        btn_reset = new View.form.MyButton();
        btnFirst = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        cbbPagination = new javax.swing.JComboBox<>();
        lbl_Count = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hoadonbanhang = new View.form.TableColumn();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(txt_ThoiGian);

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Hóa Đơn Bán Hàng");

        txt_timtheoma.setLabelText("Tìm Theo Mã HD");
        txt_timtheoma.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timtheomaCaretUpdate(evt);
            }
        });
        txt_timtheoma.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_timtheomaFocusGained(evt);
            }
        });
        txt_timtheoma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timtheomaKeyReleased(evt);
            }
        });

        lbl_Search.setForeground(new java.awt.Color(255, 51, 51));

        btn_Tim.setText("Tim");
        btn_Tim.setRadius(20);
        btn_Tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_timtheoma, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timtheoma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txt_ThoiGian.setLabelText("Thời Gian");

        btn_loc.setText("Lọc");
        btn_loc.setRadius(20);
        btn_loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_locActionPerformed(evt);
            }
        });

        btn_reset.setText("Reset");
        btn_reset.setRadius(20);
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btnFirst.setText("<<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnBack.setText("<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">>");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        cbbPagination.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "10", "15", "20", "25", "30" }));
        cbbPagination.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbPaginationItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_loc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl_Count, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(btnFirst)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBack)))
                        .addGap(9, 9, 9)
                        .addComponent(cbbPagination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLast)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_ThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_loc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnBack)
                    .addComponent(btnNext)
                    .addComponent(btnLast)
                    .addComponent(cbbPagination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbl_Count)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_hoadonbanhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma HD Ban", "Ten KH", "SDT", "Ten NV", "Tong Tien", "Ngay Tao", "Ghi Chu", "Trang Thai"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_hoadonbanhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hoadonbanhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_hoadonbanhang);
        if (tbl_hoadonbanhang.getColumnModel().getColumnCount() > 0) {
            tbl_hoadonbanhang.getColumnModel().getColumn(0).setResizable(false);
            tbl_hoadonbanhang.getColumnModel().getColumn(1).setResizable(false);
            tbl_hoadonbanhang.getColumnModel().getColumn(2).setResizable(false);
            tbl_hoadonbanhang.getColumnModel().getColumn(3).setResizable(false);
            tbl_hoadonbanhang.getColumnModel().getColumn(4).setResizable(false);
            tbl_hoadonbanhang.getColumnModel().getColumn(5).setResizable(false);
            tbl_hoadonbanhang.getColumnModel().getColumn(6).setResizable(false);
            tbl_hoadonbanhang.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_hoadonbanhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hoadonbanhangMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int row = tbl_hoadonbanhang.getSelectedRow();
            int id = (int) tbl_hoadonbanhang.getValueAt(row, 0);
            new ViewHoaDonChiTietBanHang(id, (DefaultTableModel) tbl_hoadonbanhang.getModel(), tbl_hoadonbanhang.getSelectedRow()).setVisible(true);
            System.out.println(tbl_hoadonbanhang.getValueAt(row, 5).toString());
        }

    }//GEN-LAST:event_tbl_hoadonbanhangMouseClicked
    public void search() {
        if (txt_timtheoma.getText().trim().equals("")) {
            return;
        }
        lbl_Search.setVisible(true);
        tableModel = (DefaultTableModel) tbl_hoadonbanhang.getModel();
        tableModel.setRowCount(0);
        int id = Integer.valueOf(txt_timtheoma.getText());
        HDBanViewModel i = chitiethoadonservice.FindHDB(id);
        
       
        KhachHangService khachHangService = new KhachHangIMpl();
        listKHg = khachHangService.getlistKhachHang();   
        
        if (i == null) {
            lbl_Search.setVisible(true);
            lbl_Search.setText("Không có mặt hàng : " + id);
            return;
        }
        String phone = "";
        List<HDDoiSPViewModel> listChange = donTraHangService.selectAllHDDoi();
        List<HDTraHangViewModel> listReturn = donTraHangService.selectAllHDTra();
        for (int j = 0; j < listKHg.size(); j++) {
            if (i.getIdKhachHang() == listKHg.get(j).getIdKhachHang()) {
                phone = listKHg.get(j).getSoDienThoai();
            }
        }
        tableModel.addRow(new Object[]{
            i.getIdHoaDonBan(),
            i.getTenKhachHang(),
            phone,
            i.getTenUser(),
            i.getTongTien() + " đ",
            i.getNGAYTHANHTOAN(),
            i.getGhiChu()
        });

        lbl_Search.setText("");
          for (int j = 0; j < listReturn.size(); j++) {
            if (id == listReturn.get(j).getMaHoaDonBan()) {
                tbl_hoadonbanhang.setValueAt("Đã trả hàng", j, 7);
            }
        }

        for (int z = 0; z < listChange.size(); z++) {
            if (id == listChange.get(z).getIDHoaDonBanHang()) {
                tbl_hoadonbanhang.setValueAt("Đã đổi hàng", z, 7);
            }
        }

      
            for (int z = 0; z < listChange.size(); z++) {
                if (id == listCTB.get(z).getIdHoaDonBan()) {
                  //  status = "Đã đổi hàng";
                    tbl_hoadonbanhang.setValueAt("Đã đổi hàng", z, 7);
                }
            }
        

    }
    private void txt_timtheomaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timtheomaCaretUpdate
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_timtheomaCaretUpdate

    private void txt_timtheomaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_timtheomaFocusGained
//        // TODO add your handling code here:
//                search();
//        if(txt_timtheoma.getText().isEmpty()){
//            lbl_Search.setVisible(false);
//            fillData();
//        }
    }//GEN-LAST:event_txt_timtheomaFocusGained

    private void txt_timtheomaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timtheomaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timtheomaKeyReleased

    private void btn_TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimActionPerformed
        // TODO add your handling code here:
        try {
            search();
            if (txt_timtheoma.getText().isEmpty()) {
                lbl_Search.setVisible(false);
                fillData();
            }
        } catch (NumberFormatException e) {
            lbl_Search.setText("Mã phải là số ");
        }
    }//GEN-LAST:event_btn_TimActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        lbl_Search.setVisible(false);
        txt_timtheoma.setText("");
        fillData();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_locActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_locActionPerformed
        // TODO add your handling code here:
        searchDateFillTable();
        flag = true;
    }//GEN-LAST:event_btn_locActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
         page--;
         if (flag) {
            searchDateFillTable();
            return;
        }
        fillData();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        page++;
         if (flag) {
            searchDateFillTable();
            return;
        }
        fillData();
    }//GEN-LAST:event_btnNextActionPerformed

    private void cbbPaginationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbPaginationItemStateChanged
        // TODO add your handling code here:
        if (flag) {
            searchDateFillTable();
            return;
        }
        fillData();
    }//GEN-LAST:event_cbbPaginationItemStateChanged

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        page = 1;
        if (flag) {
            searchDateFillTable();
            return;
        }
        fillData();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        page = totalPage;
        if (flag) {
            searchDateFillTable();
            return;
        }
        fillData();
    }//GEN-LAST:event_btnLastActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private View.form.MyButton btn_Tim;
    private View.form.MyButton btn_loc;
    private View.form.MyButton btn_reset;
    private javax.swing.JComboBox<String> cbbPagination;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Count;
    private javax.swing.JLabel lbl_Search;
    private View.form.TableColumn tbl_hoadonbanhang;
    private View.form.TextField txt_ThoiGian;
    private View.form.TextField txt_timtheoma;
    // End of variables declaration//GEN-END:variables
}
