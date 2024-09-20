/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.login;

import Repository.QuenMatKhauRepository;
import Service.Impl.QuenMatKhauImpl;
import Services.QuenMatKhauService;
import static View.login.Auth.user;
import ViewModel.NhanVienViewModel;
import java.awt.event.ActionListener;
import static java.lang.ProcessBuilder.Redirect.to;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class formQuenMatKhau extends javax.swing.JPanel {
    QuenMatKhauService quenmatkhauservice = new QuenMatKhauImpl();
    private  static final String Email = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6}$)";
    
   
    int randomCode;
    public formQuenMatKhau() {
        initComponents();
        txt_Verify.setEnabled(false);
        txt_MatKhau.setEnabled(false);
        txt_VerifyMatKhau.setEnabled(false);
        btnVerify.setEnabled(false);
        btnReset.setEnabled(false);
        lblTime.setText("");
        lbl_chuong.hide();
    
    }
    public void register() {
        txt_USERS.grabFocus();
    }
 public void addEventBackLogin(ActionListener event) {
        btn_BackLogin.addActionListener(event);
    }
 public void reset(){
     txt_MatKhau.setText("");
     txt_USERS.setText("");
     txt_Verify.setText("");
     txt_VerifyMatKhau.setText("");
     txt_email.setText("");
     txt_Verify.setEnabled(false);
        txt_MatKhau.setEnabled(false);
        txt_VerifyMatKhau.setEnabled(false);
        btnVerify.setEnabled(false);
        btnReset.setEnabled(false);
        btnSend.setEnabled(true);
//        lblTime.setText("");
//        lbl_chuong.hide();
 }
 public boolean checkUser(String acc) {
        for (int i = 0; i < quenmatkhauservice.Getlist().size(); i++) {
            if (quenmatkhauservice.Getlist().get(i).getUsername().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }
 public boolean checkEmail(String acc) {
        for (int i = 0; i < quenmatkhauservice.Getlist().size(); i++) {
            if (quenmatkhauservice.Getlist().get(i).getEmail().trim().equals(acc.trim())) {
                return true;
            }
        }
        return false;
    }
 public void sendCode() {
        try {
            Random rand = new Random();
            randomCode = rand.nextInt(999999);
            String host = "smtp.gmail.com";
            String user = "nhasachpolynhom2it17317@gmail.com";
            String pass = "xniejwfpqisipyuz";
           String to = txt_email.getText();
            String subject = "Reseting Code";
            String message = "Your reset code is " + randomCode;
            boolean sessionDebug = false;
            Properties pros = System.getProperties();
            pros.put("mail.smtp.starttls.enable", "true");
            pros.put("mail.smtp.starttls.required", "true");
            pros.put("mail.smtp.host", host);
            pros.put("mail.smtp.port", "587");
            pros.put("mail.smtp.auth", "true");
       java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(pros, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(user));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setText(message);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            JOptionPane.showMessageDialog(null, "Code đã gửi đến Email");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  Thread time;
  public void countDown() {
        time = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 60; i >= 0; i--) {
                    lblTime.setText("" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                txt_Verify.setEnabled(false);
                btnSend.setEnabled(true);
                btnVerify.setEnabled(false);
            }
        });
        time.start();
    }
    NhanVienViewModel getForm() {
        NhanVienViewModel em = new NhanVienViewModel();
        em.setPassword(new String(txt_VerifyMatKhau.getPassword()));
        em.setUsername(txt_USERS.getText());
        return em;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_BackLogin = new View.login.button();
        btnSend = new View.login.button();
        txt_USERS = new View.login.txtField();
        jLabel1 = new javax.swing.JLabel();
        txt_email = new View.login.txtField();
        txt_MatKhau = new View.login.password();
        txt_Verify = new View.login.txtField();
        txt_VerifyMatKhau = new View.login.password();
        lblTime = new javax.swing.JLabel();
        btnReset = new View.login.button();
        btnVerify = new View.login.button();
        lbl_chuong = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btn_BackLogin.setBackground(new java.awt.Color(255, 255, 255));
        btn_BackLogin.setText("Back");
        btn_BackLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_BackLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BackLoginActionPerformed(evt);
            }
        });

        btnSend.setBackground(new java.awt.Color(104, 159, 158));
        btnSend.setText("Gửi Mã Code");
        btnSend.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        txt_USERS.setHint("USERSNAME");
        txt_USERS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_USERSActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("QUÊN MẬT KHẨU");

        txt_email.setHint("EMAIL");

        txt_MatKhau.setHint("PassWord");
        txt_MatKhau.setOpaque(false);

        txt_Verify.setHint("Verify");
        txt_Verify.setOpaque(false);

        txt_VerifyMatKhau.setHint("Venrify Password");
        txt_VerifyMatKhau.setOpaque(false);

        lblTime.setText("Thoi Gian");

        btnReset.setBackground(new java.awt.Color(104, 159, 158));
        btnReset.setText("Đổi Mật Khẩu Mới");
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnVerify.setBackground(new java.awt.Color(104, 159, 158));
        btnVerify.setText("Verify");
        btnVerify.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifyActionPerformed(evt);
            }
        });

        lbl_chuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon/chuong_32.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_USERS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_MatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_VerifyMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_BackLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                    .addComponent(txt_Verify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(lbl_chuong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTime)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(txt_USERS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lbl_chuong))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txt_Verify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblTime)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_VerifyMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnVerify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_BackLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_USERSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_USERSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_USERSActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        if (txt_USERS.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi, Bạn chưa nhập Users để quên mật khẩu");
            return;
        }
        if (txt_email.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn ơi, Bạn chưa nhập Email để quên mật khẩu");
            return;
        }
        
        if (checkUser(txt_USERS.getText())==false) {
            JOptionPane.showMessageDialog(this,"Không tồn tại users");
            return;
        }
         if (checkEmail(txt_email.getText())==false) {
            JOptionPane.showMessageDialog(this,"Không tồn tại Email");
            return;
        }
         Matcher matcher = Pattern.compile(Email).matcher(txt_email.getText());
         if (!matcher.matches()) {
             JOptionPane.showMessageDialog(this,"Email sai định dạnh");
             return;
        }
       

        sendCode();
        btnSend.setEnabled(false);
            btnVerify.setEnabled(true);
            txt_Verify.setEnabled(true);
            lbl_chuong.setVisible(true);
        countDown();
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        if (txt_MatKhau.getText().isEmpty() ){
            JOptionPane.showMessageDialog(this, "Bạn ơi, Mật khẩu đang trống nha");
        } else 
       
        if (new String(txt_MatKhau.getPassword()).equals(new String(txt_VerifyMatKhau.getPassword()))) {
            NhanVienViewModel nv = getForm();
            JOptionPane.showMessageDialog(this,quenmatkhauservice.Update(nv));
//                this.dispose();
//                new Login().setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this,"Mật khẩu không khớp");
        }
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifyActionPerformed
        // TODO add your handling code here:
        if (txt_Verify.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Bạn chưa nhập Mã Code nha");
            return;
        }
        if (Integer.valueOf(txt_Verify.getText()) == randomCode) {
            lblTime.setText("");
            lbl_chuong.hide();
            time.stop();
            txt_MatKhau.setEnabled(true);
            txt_VerifyMatKhau.setEnabled(true);
            btnVerify.setEnabled(false);
            lbl_chuong.setIcon(null);
            btnReset.setEnabled(true);
//            time.stop();
//            btnReset.setEnabled(false);
            
        } else {
            JOptionPane.showMessageDialog(this,"Code Không Đúng Với Gmail,Vui lòng nhập lại");
        }
    }//GEN-LAST:event_btnVerifyActionPerformed

    private void btn_BackLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BackLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_BackLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.login.button btnReset;
    private View.login.button btnSend;
    private View.login.button btnVerify;
    private View.login.button btn_BackLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lbl_chuong;
    private View.login.password txt_MatKhau;
    private View.login.txtField txt_USERS;
    private View.login.txtField txt_Verify;
    private View.login.password txt_VerifyMatKhau;
    private View.login.txtField txt_email;
    // End of variables declaration//GEN-END:variables
}
