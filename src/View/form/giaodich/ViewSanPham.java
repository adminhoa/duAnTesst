/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.form.giaodich;

import DomainModel.NCC;
import DomainModel.Sach;
import DomainModel.TheLoai;
import Service.Impl.NCCImpl;
import Service.Impl.SachImpl;
import Service.Impl.TheLoaiImpl;
import Services.NCCService;
import Services.SachService;
import Services.TheLoaiServie;
import ViewModel.SachViewModel;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.layout.AC;

/**
 *
 * @author ADMIN
 */
public class ViewSanPham extends javax.swing.JPanel implements Runnable, ThreadFactory {

    private DefaultComboBoxModel cbModel;
    private DefaultComboBoxModel cbModel2;
    private DefaultTableModel tblModel;
    private List<SachViewModel> listSachView;
    private List<NCC> listNCC;
    private List<TheLoai> listtheloai;
    private TheLoaiServie svTheLoai;
    private SachService svSach;
    private NCCService svNCC;
    private WebcamPanel panel = null;
    private static Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public ViewSanPham() {
        initComponents();
        cbModel = (DefaultComboBoxModel) cbo_loaiSach.getModel();
        tblModel = (DefaultTableModel) tbl_sanPham.getModel();
        cbModel2 = (DefaultComboBoxModel) cboNhaCungCaP.getModel();
        svTheLoai = new TheLoaiImpl();
        svSach = new SachImpl();
        svNCC = new NCCImpl();
        listtheloai = svTheLoai.getlistTheLoai();
        listSachView = svSach.getAll();
        listNCC = svNCC.getAll();
        statusform();
        fillcomboxTheLoai();
        fillComBoxCNN();
        showData(listSachView);
        txtID.disable();
        txtIDTheLoai.disable();
        initwebcam();
        btn_suaSach.setEnabled(false);
        btn_xoasach.setEnabled(false);

    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;

    }

    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            Result result = null;
            BufferedImage image = null;
            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }
            if (image == null) {
                continue;
            }
            LuminanceSource soure = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(soure));
            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (Exception e) {
            }
            if (result != null) {
                txtMaSach.setText(result.getText());
            }

        } while (true);
    }

    public static void closeCam() {
        if (webcam == null) {
            return;
        }
        webcam.close();
    }

    private void initwebcam() {
        Dimension size = WebcamResolution.QQVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        jPanel6.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 150));

        executor.execute(this);

    }

    public void statusform() {
        txt_tenLoaiSach.setVisible(false);
        rdo_DangKinhDoanh.setSelected(true);
        btn_them.setVisible(false);
        btn_sua.setVisible(false);
        rdoDKDCTS.setVisible(false);
        rdoNKDcts.setVisible(false);
        txtIDTheLoai.setVisible(false);
//        myButton1.setVisible(false);
    }

    public boolean checkMaSach(String acc) {
        for (int i = 0; i < svSach.getAll().size(); i++) {
            if (svSach.getAll().get(i).getMaSach().trim().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTenTheLoai(String acc) {
        for (int i = 0; i < svTheLoai.getlistTheLoai().size(); i++) {
            if (svTheLoai.getlistTheLoai().get(i).getTenTheLoai().trim().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }

    public void initTable() {
        String[] cols = new String[]{"ID Sach", "Ten Sach", "Loai Sach", "Trang thai"};
        tblModel.setColumnIdentifiers(cols);
        tbl_sanPham.setModel(tblModel);
        listSachView = svSach.getAll();
        showData(listSachView);
    }

    public void showData(List<SachViewModel> listSachView) {
        tblModel.setRowCount(0);
        for (SachViewModel s : listSachView) {
            Object[] row = new Object[]{s.getId(), s.getMaSach(), s.getTenSach(), s.getLoaiSach(), s.getNXB(), s.isTrangThai() == true ? "Đang kinh doanh" : "Ngừng kinh doanh"};
            tblModel.addRow(row);
        }
    }

    public void showDataListNKD() {
        tblModel.setRowCount(0);
        List<SachViewModel> list = svSach.getNKD();
        for (SachViewModel s : list) {
            Object[] row = new Object[]{s.getId(), s.getMaSach(), s.getTenSach(), s.getLoaiSach(), s.getNXB(), s.isTrangThai() == true ? "Đang kinh doanh" : "Ngừng kinh doanh"};
            tblModel.addRow(row);
        }
    }

    public void showDataListDKD() {
        tblModel.setRowCount(0);
        List<SachViewModel> list = svSach.getDKD();
        for (SachViewModel s : list) {
            Object[] row = new Object[]{s.getId(), s.getMaSach(), s.getTenSach(), s.getLoaiSach(), s.getNXB(), s.isTrangThai() == true ? "Đang kinh doanh" : "Ngừng kinh doanh"};
            tblModel.addRow(row);
        }
    }

    public void showtheloai() {

        TheLoai tl = (TheLoai) cbo_loaiSach.getSelectedItem();
        if (tl == null) {
            return;
        }

        txt_tenLoaiSach.setText(tl.getTenTheLoai());
        txtIDTheLoai.setText(String.valueOf(tl.getIdTheLoai()));
//           for (TheLoai cc : listtheloai) {
//            if(cc.isTrangThai()==true){
//                rdoDKDCTS.setSelected(true);
//            }else{
//                rdoNKDcts.setSelected(true);
//            }
//        }
        if (tl.isTrangThai() == true) {
            rdoDKDCTS.setSelected(true);
        } else {
            rdoNKDcts.setSelected(true);
        }

    }

    public void fillComBoxCNN() {
        DefaultComboBoxModel comode2 = (DefaultComboBoxModel) cboNhaCungCaP.getModel();
        cboNhaCungCaP.removeAllItems();
        listNCC = svNCC.getAll();
        for (NCC ncc : listNCC) {
            comode2.addElement(ncc);
        }
    }

    public void fillcomboxTheLoai() {
        DefaultComboBoxModel comode = (DefaultComboBoxModel) cbo_loaiSach.getModel();
        cbo_loaiSach.removeAllItems();
        listtheloai = svTheLoai.getlistTheLoai();
        for (TheLoai tl : listtheloai) {
            comode.addElement(tl);
        }

    }

    public void lammoi() {
        txtID.setText("");
        txtTenSach1.setText("");
        txtMaSach.setText("");
        rdo_DangKinhDoanh.setSelected(true);
        btn_suaSach.setEnabled(false);
        btn_xoasach.setEnabled(false);
    }

    public void fillData(int index) {
        SachViewModel s = svSach.getAll().get(index);

    }

    public TheLoai guidata() {
        TheLoai tl = new TheLoai();
        tl.setTenTheLoai(txt_tenLoaiSach.getText());
        boolean tt = rdoDKDCTS.isSelected();
        if (tt) {
            tl.setTrangThai(true);
        } else {
            tl.setTrangThai(false);
        }

        return tl;
    }

    public Sach guiDataSach() {
        return new Sach(txtMaSach.getText(), txtTenSach1.getText(), listtheloai.get(cbo_loaiSach.getSelectedIndex()).getIdTheLoai(), listNCC.get(cboNhaCungCaP.getSelectedIndex()).getIdNCC(), rdo_DangKinhDoanh.isSelected());
//        return new Sach(txtTenSach1.getText(), listtheloai.get(cbo_loaiSach.getSelectedIndex()).getIdTheLoai(), rdo_DangKinhDoanh.isSelected());
    }

    public void TimTheoTen() {
        String temp = txtTimKiem.getText();
        List<SachViewModel> listSearch = new ArrayList<>();
        listSearch = svSach.searchTen(temp);
        tblModel = (DefaultTableModel) tbl_sanPham.getModel();
        tblModel.setRowCount(0);
        if (listSearch.isEmpty()) {
            lblTb2.setText("Không tìm thay san pham : " + temp);
            return;
        }
        for (SachViewModel p : listSearch) {
            tblModel.addRow(new Object[]{
                p.getId(),
                p.getMaSach(),
                p.getTenSach(),
                p.getLoaiSach(),
                p.getNXB(),
                p.isTrangThai() == true ? "Đang Kinh Doanh" : "Ngừng Kinh Doanh",});
        }
    }
    public void xoaForm(){
        txtID.setText("");
        cbo_loaiSach.setSelectedIndex(0);
        txtTenSach1.setText("");
        txtMaSach.setText("");
        rdo_DangKinhDoanh.setSelected(false);
        rdo_NgungKinhDoanh.setSelected(false);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new View.form.TextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblTb2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sanPham = new View.form.TableColumn();
        jPanel4 = new javax.swing.JPanel();
        cbo_loaiSach = new View.form.Combobox();
        jLabel3 = new javax.swing.JLabel();
        rdo_DangKinhDoanh = new View.form.RadioButtonCustom();
        rdo_NgungKinhDoanh = new View.form.RadioButtonCustom();
        btn_Moi = new View.form.MyButton();
        btn_themsach = new View.form.MyButton();
        btn_suaSach = new View.form.MyButton();
        btn_xoasach = new View.form.MyButton();
        myButton7 = new View.form.MyButton();
        txt_tenLoaiSach = new View.form.TextField();
        btn_them = new View.form.MyButton();
        txtTenSach1 = new View.form.TextField();
        txtID = new View.form.TextField();
        txtMaSach = new View.form.TextField();
        cboNhaCungCaP = new View.form.Combobox();
        btn_TatQuetMa = new View.form.MyButton();
        rdoDKDCTS = new View.form.RadioButtonCustom();
        rdoNKDcts = new View.form.RadioButtonCustom();
        txtIDTheLoai = new View.form.TextField();
        btn_sua = new View.form.MyButton();
        cbTK = new View.form.Combobox();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Sách");

        txtTimKiem.setLabelText("Tìm theo tên");
        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quét Mã", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 360, 150));

        lblTb2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTb2.setForeground(new java.awt.Color(255, 51, 51));

        tbl_sanPham.setBackground(new java.awt.Color(255, 255, 255));
        tbl_sanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Sách", "Mã Sách", "Tên Sách", "Loại Sách", "NXB", "Trạng Thái"
            }
        ));
        tbl_sanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sanPham);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết Sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        cbo_loaiSach.setLabeText("Loại Sách");
        cbo_loaiSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_loaiSachMouseClicked(evt);
            }
        });

        jLabel3.setText("Trạng Thái");

        buttonGroup1.add(rdo_DangKinhDoanh);
        rdo_DangKinhDoanh.setText("Đang Kinh Doanh ");
        rdo_DangKinhDoanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_DangKinhDoanhActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdo_NgungKinhDoanh);
        rdo_NgungKinhDoanh.setText("Ngừng Kinh Doanh");

        btn_Moi.setText("Tạo Mới");
        btn_Moi.setRadius(20);
        btn_Moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MoiActionPerformed(evt);
            }
        });

        btn_themsach.setText("Thêm");
        btn_themsach.setRadius(20);
        btn_themsach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themsachActionPerformed(evt);
            }
        });

        btn_suaSach.setText("Cập Nhập");
        btn_suaSach.setRadius(20);
        btn_suaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaSachActionPerformed(evt);
            }
        });

        btn_xoasach.setText("Xóa");
        btn_xoasach.setRadius(20);
        btn_xoasach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoasachActionPerformed(evt);
            }
        });

        myButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon/icons8_Plus_32.png"))); // NOI18N
        myButton7.setBorderColor(new java.awt.Color(255, 255, 255));
        myButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton7ActionPerformed(evt);
            }
        });

        txt_tenLoaiSach.setLabelText("Tên Loại Sách");
        txt_tenLoaiSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenLoaiSachActionPerformed(evt);
            }
        });

        btn_them.setText("Thêm");
        btn_them.setRadius(20);
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        txtTenSach1.setLabelText("Tên Sách");
        txtTenSach1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSach1ActionPerformed(evt);
            }
        });

        txtID.setLabelText("ID");

        txtMaSach.setLabelText("Mã Sách");

        cboNhaCungCaP.setLabeText("Nhà cung cấp");

        btn_TatQuetMa.setText("Tắt Quét Mã");
        btn_TatQuetMa.setRadius(20);
        btn_TatQuetMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TatQuetMaActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoDKDCTS);
        rdoDKDCTS.setText("Dang kinh doanh");

        buttonGroup2.add(rdoNKDcts);
        rdoNKDcts.setText("Ngung kinh doanh");

        txtIDTheLoai.setLabelText("ID The loai");

        btn_sua.setText("Sua");
        btn_sua.setRadius(20);
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboNhaCungCaP, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbo_loaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tenLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btn_TatQuetMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSach1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rdo_DangKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(rdo_NgungKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_Moi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_themsach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(btn_suaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_xoasach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtIDTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoDKDCTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoNKDcts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_TatQuetMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(myButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cbo_loaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tenLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoDKDCTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNKDcts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboNhaCungCaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSach1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdo_DangKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdo_NgungKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Moi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_themsach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_suaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoasach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        cbTK.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Đang Kinh Doanh", "Ngừng Kinh Doanh", "Tất cả" }));
        cbTK.setLabeText("tìm kiem theo trang thai");
        cbTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblTb2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(cbTK, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(229, 229, 229))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbTK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTb2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableShowProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableShowProductsMouseClicked
        // editProducts();
        // TODO add your handling code here:
    }//GEN-LAST:event_tableShowProductsMouseClicked

    private void myButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton7ActionPerformed
        // TODO add your handling code here:
        if (txt_tenLoaiSach.isVisible()) {
            txt_tenLoaiSach.setVisible(false);
            btn_sua.setVisible(false);
            btn_them.setVisible(false);
            rdoDKDCTS.setVisible(false);
            rdoNKDcts.setVisible(false);
            txtIDTheLoai.setVisible(false);

        } else {
            txt_tenLoaiSach.setVisible(true);
            btn_sua.setVisible(true);
            btn_them.setVisible(true);
            rdoDKDCTS.setVisible(true);
            rdoNKDcts.setVisible(true);
            txtIDTheLoai.setVisible(true);

            showtheloai();
        }

    }//GEN-LAST:event_myButton7ActionPerformed

    private void txt_tenLoaiSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenLoaiSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenLoaiSachActionPerformed

    private void cbo_loaiSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_loaiSachMouseClicked

    }//GEN-LAST:event_cbo_loaiSachMouseClicked

    private void btn_themsachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themsachActionPerformed
//        listtheloai = svTheLoai.getlistTheLoai();
//        int indexTl = cbo_loaiSach.getSelectedIndex();
//        TheLoai tl = listtheloai.get(indexTl);
//        String tenSach = txtTenSach.getText();
//        boolean trangThai = rdo_DangKinhDoanh.isSelected();
//        Sach s = new Sach( tenSach, tl.getIdTheLoai(), trangThai);
        if (checkMaSach(txtMaSach.getText()) == true) {
            JOptionPane.showMessageDialog(this, "Bạn ơi,Mã sách có trong hệ thống rồi nha");
            return;
        } else {

            JOptionPane.showMessageDialog(this, svSach.inert(guiDataSach()));
            listSachView = svSach.getAll();
            showData(listSachView);
            lammoi();

        }
    }//GEN-LAST:event_btn_themsachActionPerformed

    private void btn_MoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MoiActionPerformed
        lammoi();
    }//GEN-LAST:event_btn_MoiActionPerformed

    private void rdo_DangKinhDoanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_DangKinhDoanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_DangKinhDoanhActionPerformed

    private void btn_suaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaSachActionPerformed
        String id = txtID.getText();
        JOptionPane.showMessageDialog(this, svSach.update(guiDataSach(), id));
        listSachView = svSach.getAll();
        showData(listSachView);
        lammoi();

    }//GEN-LAST:event_btn_suaSachActionPerformed

    private void tbl_sanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanPhamMouseClicked
        int row = tbl_sanPham.getSelectedRow();
        SachViewModel s = listSachView.get(row);
        txtID.setText(s.getId() + "");
        txtMaSach.setText(s.getMaSach());
        txtTenSach1.setText(s.getTenSach());
        cboNhaCungCaP.setSelectedItem(s.getNXB());
        cbo_loaiSach.setSelectedItem(s.getLoaiSach());
        boolean trangThai = s.isTrangThai();
        if (trangThai) {
            rdo_DangKinhDoanh.setSelected(true);
        } else {
            rdo_NgungKinhDoanh.setSelected(true);
        }
        btn_suaSach.setEnabled(true);
        btn_xoasach.setEnabled(true);
    }//GEN-LAST:event_tbl_sanPhamMouseClicked

    private void txtTenSach1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSach1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSach1ActionPerformed

    private void btn_xoasachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoasachActionPerformed
        String id = txtID.getText();
        JOptionPane.showMessageDialog(this, svSach.delete(id));
        listSachView = svSach.getAll();
        showData(listSachView);
        xoaForm();
    }//GEN-LAST:event_btn_xoasachActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        TimTheoTen();
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void btn_TatQuetMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TatQuetMaActionPerformed
        // TODO add your handling code here:
        if (webcam == null) {
            return;
        }
        webcam.close();

    }//GEN-LAST:event_btn_TatQuetMaActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed

        if (checkTenTheLoai(txt_tenLoaiSach.getText()) == true) {
            JOptionPane.showMessageDialog(this, "Bạn ơi, Tên sách đac có trong hệ thống");
            return;
        } else {

            JOptionPane.showMessageDialog(this, svTheLoai.inerts(guidata()));
            fillcomboxTheLoai();
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
//        if (checkTenTheLoai(txt_tenLoaiSach.getText())==true) {
//            JOptionPane.showMessageDialog(this,"Bạn ơi, Tên sách đã có trong hệ thống");
//            return;
//        } else {
//        int id = Integer.valueOf(txtIDTheLoai.getText());
//        JOptionPane.showMessageDialog(this,svTheLoai.update(guidata(),id));
//        svSach.update01(guiDataSach(), id);
//        fillcomboxTheLoai();
//        listSachView = svSach.getAll();
//        showData(listSachView);
        int id = Integer.valueOf(txtIDTheLoai.getText());
        JOptionPane.showMessageDialog(this, svTheLoai.update(guidata(), id));
        svSach.update01(guiDataSach(), id);
        fillcomboxTheLoai();
        listSachView = svSach.getAll();
        showData(listSachView);
        //}
    }//GEN-LAST:event_btn_suaActionPerformed

    private void cbTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTKActionPerformed
        if (cbTK.getSelectedIndex() == 0) {
            showDataListDKD();
        } else if(cbTK.getSelectedIndex() == 1) {
            showDataListNKD();
        }
        else{
            showData(listSachView);
        }
    }//GEN-LAST:event_cbTKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.form.MyButton btn_Moi;
    private View.form.MyButton btn_TatQuetMa;
    private View.form.MyButton btn_sua;
    private View.form.MyButton btn_suaSach;
    private View.form.MyButton btn_them;
    private View.form.MyButton btn_themsach;
    private View.form.MyButton btn_xoasach;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private View.form.Combobox cbTK;
    private View.form.Combobox cboNhaCungCaP;
    private View.form.Combobox cbo_loaiSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTb2;
    private View.form.MyButton myButton7;
    private View.form.RadioButtonCustom rdoDKDCTS;
    private View.form.RadioButtonCustom rdoNKDcts;
    private View.form.RadioButtonCustom rdo_DangKinhDoanh;
    private View.form.RadioButtonCustom rdo_NgungKinhDoanh;
    private View.form.TableColumn tbl_sanPham;
    private View.form.TextField txtID;
    private View.form.TextField txtIDTheLoai;
    private View.form.TextField txtMaSach;
    private View.form.TextField txtTenSach1;
    private View.form.TextField txtTimKiem;
    private View.form.TextField txt_tenLoaiSach;
    // End of variables declaration//GEN-END:variables
}
