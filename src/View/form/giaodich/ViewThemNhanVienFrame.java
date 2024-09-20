/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.form.giaodich;

import DomainModel.TaiKhoan;
import DomainModel.Users;
import Service.Impl.NhanVienImpl;

import Service.Impl.UsersImpl;
import Services.NhanVienService;

import Services.UsersService;
import View.TrangChu.mainform;
import View.login.XDate;
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
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class ViewThemNhanVienFrame extends javax.swing.JFrame implements Runnable,ThreadFactory {

    private DefaultTableModel tblModel;
    private List<Users> ListUsers = new ArrayList<>();
   // private UsersService usersService = new UsersImpl();
    NhanVienService nhanVienService =new NhanVienImpl();
    List<TaiKhoan> ListTaiKhoan = new ArrayList<>();
    private WebcamPanel panel = null;
    private static Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    private  static final String Email = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6}$)";
    
    

    /**
     * Creates new form ViewThemNhanVienFrame
     */
    public ViewThemNhanVienFrame() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        Users us ;
       // setResizable(false);
        btn_sua.setEnabled(false);
       //  webcam.close();
//       initwebcam();
       

    }
    public static void closeCam(){
        if (webcam == null) {
            return;
        }
        webcam.close();
    }

    ViewThemNhanVienFrame(String CCCD, String Hoten, String ChucVu, String GioiTinh, String NgaySinh, String DiaChi, String SoDienThoai, String email, String Luong, int idUser, int status) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btn_them.setEnabled(false);
        btn_them.setVisible(false);
        btn_lammoi.setEnabled(false);
        btn_lammoi.setVisible(false);
        
        txt_cccd.setText(CCCD);
        txt_cccd.setEditable(false);
        txt_ten.setText(Hoten);
        txt_ngaysinh.setText(NgaySinh);
        txt_diachi.setText(DiaChi);
        txt_dienthoai.setText(SoDienThoai);
        txt_email.setText(email);
        txt_luong.setText(Luong);
        txt_password.setVisible(false);
        txt_username.setVisible(false);
        txt_diachi.setEditable(false);
        txt_ngaysinh.setEditable(false);
        this.NgaySinh.setVisible(false);
        rbt_nam.setEnabled(false);
        rbt_nu.setEnabled(false);
        txt_email.setEditable(false);
        txt_ten.setEditable(false);
        txt_dienthoai.setEditable(false);

        if (GioiTinh.equalsIgnoreCase("Nam")) {
            rbt_nam.setSelected(true);
        } else if (GioiTinh.equalsIgnoreCase("Nữ")) {
            rbt_nu.setSelected(true);
        }
        if (ChucVu.equalsIgnoreCase("Quản lý")) {
            rbt_quanly.setSelected(true);
        } else if (ChucVu.equalsIgnoreCase("Nhân viên")) {
            rbt_nhanvien.setSelected(true);
        }

        if (status == 0) {
            rbt_danglamviec.setSelected(true);
        } else {
            rbt_nghilam.setSelected(true);
        }
        lbl_IDusers.setText(idUser + "");
    }
    private void initwebcam(){
    Dimension size = WebcamResolution.QQVGA.getSize();
    webcam = Webcam.getWebcams().get(0);
    webcam.setViewSize(size);
    panel = new WebcamPanel(webcam);
    panel.setPreferredSize(size);
    panel.setFPSDisplayed(true);
  
   jPanel3.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 150));
  jPanel4.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 150));
    executor.execute(this);
    
}
    public void run(){
    do {        
        try {
             Thread.sleep(100);
        } catch (Exception e) {
        }
        Result result =null;
        BufferedImage image = null;
        if (webcam.isOpen()) {
            if ((image = webcam.getImage() )== null) {
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
            txt_ThongTinNhanVien.setText(result.getText());
            
        }
       
        
        
       
    } while (true);
}

@Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t ;
        
    }

    public void addEvenUpdate(ActionListener evt) {
        btn_sua.addActionListener(evt);
    }
    public Users update() {
        Users us = new Users();
        
        us.setHoten(txt_ten.getText());
        us.setDiaChi(txt_diachi.getText());
        us.setEmail(txt_email.getText());
        us.setGioitinh(rbt_nam.isSelected());
        us.setLuong(Float.parseFloat(txt_luong.getText()));
        us.setNgaysinh(XDate.toDate(txt_ngaysinh.getText(), "yyyy-MM-dd"));
        us.setRole(rbt_quanly.isSelected());
        us.setSoDienThoai(txt_dienthoai.getText());
        us.setTrangThai(rbt_danglamviec.isSelected());
        us.setIdusers(Integer.parseInt(lbl_IDusers.getText()));
        us.setCCCD(txt_cccd.getText());
        JOptionPane.showMessageDialog(this,nhanVienService.SuaNhanVien(us));
        this.dispose();
        
        return us;
    }
    
    

    public void clearForm() {
        txt_ten.setText("");
        txt_cccd.setText("");
        txt_email.setText("");
        txt_luong.setText("");
        txt_ngaysinh.setText("");
        txt_diachi.setText("");
        txt_username.setText("");
        txt_password.setText("");
        txt_cccd.setText("");
        txt_dienthoai.setText("");
        rbt_danglamviec.setSelected(false);
        rbt_nghilam.setSelected(false);
        rbt_quanly.setSelected(false);
        rbt_nhanvien.setSelected(false);
        rbt_nam.setSelected(false);
        rbt_nu.setSelected(false);
        btn_them.setEnabled(true);
    }

    public Users getGui() {
        Users us = new Users();
        us.setCCCD(txt_cccd.getText());
        us.setHoten(txt_ten.getText());
        us.setSoDienThoai(txt_dienthoai.getText());
        us.setEmail(txt_email.getText());
        us.setLuong(Float.parseFloat(txt_luong.getText()));
        if (rbt_danglamviec.isSelected() == true) {
            us.setTrangThai(true);
        } else {
            us.setTrangThai(false);
        }
        us.setNgaysinh(XDate.toDate(txt_ngaysinh.getText(), "dd-MM-yyyy"));
        if (rbt_nam.isSelected() == true) {
            us.setGioitinh(true);
        } else {
            us.setGioitinh(false);
        }
        if (rbt_quanly.isSelected() == true) {
            us.setRole(true);
        } else {
            us.setRole(false);
        }
        us.setDiaChi(txt_diachi.getText());
        return us;

    }
    public TaiKhoan GetGuidataTaiKhoan(){
        TaiKhoan tk = new TaiKhoan();
        tk.setName(txt_username.getText());
        tk.setMatKhau(txt_password.getText());
        return tk;
    }
    public boolean checkDate() {
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.parse(txt_ngaysinh.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        int years = Period.between(date, today).getYears();
        if (years < 18) {
            JOptionPane.showMessageDialog(this,"Bạn ơi trên 18 mới đc nha");
            System.out.println(years);
            return false;
        }
        System.out.println(years);
        return true;
    }
    public boolean checkUser(String acc) {
        for (int i = 0; i < nhanVienService.getAll().size(); i++) {
            if (nhanVienService.getAll().get(i).getUsername().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }
    public boolean checkEmail(String acc) {
        for (int i = 0; i < nhanVienService.getAll().size(); i++) {
            if (nhanVienService.getAll().get(i).getEmail().trim().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }
    public boolean checkSoDienThoai(String acc) {
        for (int i = 0; i < nhanVienService.getAll().size(); i++) {
            if (nhanVienService.getAll().get(i).getSoDienThoai().trim().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }
    public boolean checkCCCD(String acc) {
        for (int i = 0; i < nhanVienService.getAll().size(); i++) {
            if (nhanVienService.getAll().get(i).getCCCD().trim().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }
    public void insert(){
        System.out.println("huhi");
        try {
        if (validate01()) {
            if (checkCCCD(txt_cccd.getText())==true) {
                    JOptionPane.showMessageDialog(this,"Bạn Ơi,Nhân Viên Này có trong hệ thống rồi nha");
                    return;
                }else
            if (checkDate()) {
                if (checkSoDienThoai(txt_dienthoai.getText())== true) {
                    JOptionPane.showMessageDialog(this,"Bạn Ơi, Số điện thoại có trong hệ thống rồi nha");
                    return;
                }else if (checkEmail(txt_email.getText())==true) {
                    JOptionPane.showMessageDialog(this,"Bạn Ơi, Email có trong hệ thống rồi nha");
                    return;
                }else if (checkUser(txt_username.getText()) == true) {
                    JOptionPane.showMessageDialog(this,"Bạn Ơi,Tên Users có trong hệ thống rồi nha");
                    return;
                } else if (checksodienthoai(txt_dienthoai.getText())==false) {
                    JOptionPane.showMessageDialog(this,"Bạn ơi, số điện thoại không hợp lệ ");
                }else
                      {
                         
                JOptionPane.showMessageDialog(this, nhanVienService.themNhanVien(getGui()));
        nhanVienService.ThemTaiKhoan(GetGuidataTaiKhoan());
       // new mainform().showForm(new ViewNhanVien());
        clearForm();
        this.dispose();
         if (webcam == null) {
            return;
        }
        webcam.close(); 
        
            }
            }
        }
         } catch (Exception e) {
        }
    }
    public boolean checksodienthoai(  String sb){
         boolean flag = true;
        if (txt_dienthoai.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn Ơi, số điện thoại đang trống nha");
            return false;
        }
        Pattern pattern = Pattern.compile("(84|0[3|5|7|8|9])+([0-9]{8})");
        Matcher matcher = pattern.matcher(txt_dienthoai.getText());
        if (!matcher.find()) {
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }
    
    public boolean validate01(){
        if (txt_ten.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi Họ và Tên đang trống");
            return false;
        }
        if (txt_diachi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi Dịa Chỉ đang trống");
            return false;
        }
        if (txt_dienthoai.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi Số Điện Thoại đang trống");
            return false;
        }
        
        
        
        try {
            Integer.parseInt(txt_dienthoai.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Số điện thoại phải là số nha");
            return false;
        }
        if (txt_email.getText().trim().isEmpty()) {
             JOptionPane.showMessageDialog(this,"Bạn ơi Email đang trống nha");
            return false;
        }
        if (txt_ngaysinh.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi Ngày Sinh đang trống");
            return false;
        }
        if (txt_password.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi pass đang trống");
            return false;
        }
        if (txt_username.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi users đang trống");
            return false;
        }
        if (txt_luong.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi Lương đang trống");
            return false;
        }
        if (!rbt_nam.isSelected()&& !rbt_nu.isSelected()) {
           JOptionPane.showMessageDialog(this,"Bạn ơi chưa chọn Giới Tính ");
            return false;
        }
        if (!rbt_quanly.isSelected()&& !rbt_nhanvien.isSelected()) {
           JOptionPane.showMessageDialog(this,"Bạn ơi chưa chọn chức Vụ ");
            return false;
        }
        if (!rbt_danglamviec.isSelected()&& !rbt_nghilam.isSelected()) {
           JOptionPane.showMessageDialog(this,"Bạn ơi chưa Chọn Tình Trạng ");
            return false;
        }
        try {
            Float.parseFloat(txt_luong.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Bạn ơi Lương phải là số nha");
            return false;
        }
        Matcher matcher = Pattern.compile(Email).matcher(txt_email.getText());
         if (!matcher.matches()) {
             JOptionPane.showMessageDialog(this,"Email sai định dạnh rồi nha, phải có @gmail.com");
             return false;
        }
         
         
         
        return true;
    }
    
    public void addEvenFillTable(ActionListener evt) {
        btn_them.addActionListener(evt);
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
        buttonGroup3 = new javax.swing.ButtonGroup();
        NgaySinh = new com.raven.datechooser.DateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_ten = new View.form.TextField();
        txt_ngaysinh = new View.form.TextField();
        txt_email = new View.form.TextField();
        txt_cccd = new View.form.TextField();
        txt_luong = new View.form.TextField();
        txt_password = new View.form.TextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_diachi = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        rbt_nam = new View.form.RadioButtonCustom();
        rbt_nu = new View.form.RadioButtonCustom();
        txt_username = new View.form.TextField();
        jLabel4 = new javax.swing.JLabel();
        rbt_danglamviec = new View.form.RadioButtonCustom();
        rbt_nghilam = new View.form.RadioButtonCustom();
        jLabel5 = new javax.swing.JLabel();
        rbt_quanly = new View.form.RadioButtonCustom();
        rbt_nhanvien = new View.form.RadioButtonCustom();
        btn_them = new View.form.MyButton();
        btn_sua = new View.form.MyButton();
        btn_lammoi = new View.form.MyButton();
        btn_huy = new View.form.MyButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txt_ThongTinNhanVien = new View.form.TextField();
        myButton1 = new View.form.MyButton();
        myButton2 = new View.form.MyButton();
        lbl_IDusers = new javax.swing.JLabel();
        txt_dienthoai = new View.form.TextField();

        NgaySinh.setTextRefernce(txt_ngaysinh);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Thêm Nhân Viên");

        txt_ten.setLabelText("Tên");

        txt_ngaysinh.setLabelText("Ngày Sinh");

        txt_email.setLabelText("Email");

        txt_cccd.setLabelText("CCCD");

        txt_luong.setLabelText("Lương");

        txt_password.setLabelText("PassWord");

        jLabel2.setText("Địa chỉ");

        txt_diachi.setColumns(20);
        txt_diachi.setRows(5);
        jScrollPane1.setViewportView(txt_diachi);

        jLabel3.setText("Giới Tính ");

        rbt_nam.setBackground(new java.awt.Color(102, 255, 102));
        buttonGroup1.add(rbt_nam);
        rbt_nam.setText("Nam");

        rbt_nu.setBackground(new java.awt.Color(51, 255, 51));
        buttonGroup1.add(rbt_nu);
        rbt_nu.setText("Nữ");

        txt_username.setLabelText("UserName");

        jLabel4.setText("Tình Trạng");

        rbt_danglamviec.setBackground(new java.awt.Color(51, 255, 51));
        buttonGroup2.add(rbt_danglamviec);
        rbt_danglamviec.setText("Đang Làm Việc");

        rbt_nghilam.setBackground(new java.awt.Color(51, 255, 51));
        buttonGroup2.add(rbt_nghilam);
        rbt_nghilam.setText("Nghỉ Làm");

        jLabel5.setText("Chức Vụ");

        rbt_quanly.setBackground(new java.awt.Color(102, 255, 102));
        buttonGroup3.add(rbt_quanly);
        rbt_quanly.setText("Quản Lý ");

        rbt_nhanvien.setBackground(new java.awt.Color(51, 255, 51));
        buttonGroup3.add(rbt_nhanvien);
        rbt_nhanvien.setText("Nhân Viên");

        btn_them.setText("Thêm ");
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

        btn_lammoi.setText("Làm Mới");
        btn_lammoi.setRadius(20);
        btn_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoiActionPerformed(evt);
            }
        });

        btn_huy.setText("Hủy");
        btn_huy.setRadius(20);
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Máy Quét Thông Tin Nhân Viên"));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 150));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        txt_ThongTinNhanVien.setLabelText("Thông Tin Nhân Viên");
        txt_ThongTinNhanVien.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_ThongTinNhanVienCaretUpdate(evt);
            }
        });

        myButton1.setText("Mở Cam");
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        myButton2.setText("Tắt Cam");
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });

        txt_dienthoai.setLabelText("Điện Thoại");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_ten, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txt_cccd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_email, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_username, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(rbt_danglamviec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbt_nghilam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_dienthoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_lammoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rbt_quanly, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(rbt_nhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_ngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(rbt_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbt_nu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txt_luong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_IDusers, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_ThongTinNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(7, 7, 7)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_luong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_cccd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_dienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(9, 9, 9)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbt_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbt_nu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(txt_ThongTinNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_IDusers)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbt_danglamviec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbt_nghilam, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbt_quanly, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbt_nhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_lammoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
        // TODO add your handling code here:
        this.dispose();
        if (webcam == null) {
            return;
        }
        webcam.close();
        //this.dispose();
        clearForm();
      
        
    }//GEN-LAST:event_btn_huyActionPerformed

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btn_lammoiActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
      //this.insert();
        
        

       
    }//GEN-LAST:event_btn_themActionPerformed

    private void txt_ThongTinNhanVienCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_ThongTinNhanVienCaretUpdate
        // TODO add your handling code here:
        String t = txt_ThongTinNhanVien.getText();
        String[] txt2 = t.split("\\|");
        if (txt2.length == 7) {
             txt_cccd.setText(txt2[0]);
             txt_ten.setText(txt2[2]);
             String ngaysinh = txt2[3];
             String ngay = ngaysinh.substring(0,2);
             String Thang = ngaysinh.substring(2,4);
             String Nam = ngaysinh.substring(4,8);
          //   txt_ngaysinh.setText(txt2[3]);
             txt_diachi.setText(txt2[5]);
             txt_ngaysinh.setText(ngay+"-"+Thang+"-"+Nam);
            // Txt_02.setText(txt2[6]);

            if (txt2[4].equalsIgnoreCase("nam")) {
                rbt_nam.setSelected(true);
            } else {
                rbt_nu.setSelected(true);
            }
        }
    }//GEN-LAST:event_txt_ThongTinNhanVienCaretUpdate

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
        initwebcam();
        
       // webcam.open();
        //run();
    }//GEN-LAST:event_myButton1ActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        // TODO add your handling code here:
        if (webcam == null) {
            return;
        }
        webcam.close();
      
    }//GEN-LAST:event_myButton2ActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
       //this.update();
    }//GEN-LAST:event_btn_suaActionPerformed

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
            java.util.logging.Logger.getLogger(ViewThemNhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewThemNhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewThemNhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewThemNhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewThemNhanVienFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser NgaySinh;
    private View.form.MyButton btn_huy;
    private View.form.MyButton btn_lammoi;
    private View.form.MyButton btn_sua;
    private View.form.MyButton btn_them;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_IDusers;
    private View.form.MyButton myButton1;
    private View.form.MyButton myButton2;
    private View.form.RadioButtonCustom rbt_danglamviec;
    private View.form.RadioButtonCustom rbt_nam;
    private View.form.RadioButtonCustom rbt_nghilam;
    private View.form.RadioButtonCustom rbt_nhanvien;
    private View.form.RadioButtonCustom rbt_nu;
    private View.form.RadioButtonCustom rbt_quanly;
    private View.form.TextField txt_ThongTinNhanVien;
    private View.form.TextField txt_cccd;
    private javax.swing.JTextArea txt_diachi;
    private View.form.TextField txt_dienthoai;
    private View.form.TextField txt_email;
    private View.form.TextField txt_luong;
    private View.form.TextField txt_ngaysinh;
    private View.form.TextField txt_password;
    private View.form.TextField txt_ten;
    private View.form.TextField txt_username;
    // End of variables declaration//GEN-END:variables
}
