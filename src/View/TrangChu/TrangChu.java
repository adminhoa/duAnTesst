  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.TrangChu;



import View.form.giaodich.ViewKhachHang;
import View.form.giaodich.ViewBanHang;
import View.form.giaodich.ViewDoiHang;
import View.form.giaodich.ViewDoiMatKhau;
import View.form.giaodich.ViewHoaDonBanHang;
import View.form.giaodich.ViewHoaDonDoiHang;
import View.form.giaodich.ViewHoaDonNhapHang;
import View.form.giaodich.ViewHoaDonTraHang;
import View.form.giaodich.ViewKhuyenMai;
import View.form.giaodich.ViewMatHang;
import View.form.giaodich.ViewNhaCungCap;
import View.form.giaodich.ViewNhanVien;
import View.form.giaodich.ViewNhapHang;
import View.form.giaodich.ViewSanPham;
import View.form.giaodich.ViewThongKeDoanhSo;
import View.form.giaodich.ViewThongKeDoanhThu;
import View.form.giaodich.ViewTraHang;
import View.form.giaodich.ViewThongtincanhan;
import View.login.Login;
import View.icon.GoogleMaterialDesignIcons;
import View.icon.IconFontSwing;
import View.login.Auth;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class TrangChu extends javax.swing.JFrame {

    private MigLayout layout;
    private menu menu1;
    private Header header;
    private mainform main ;
    private Animator animator;
    private Login login = new Login();
  
            
    public TrangChu() {
        initComponents();
        init();
       setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }
private void init(){
    layout = new MigLayout("fill","0[]0[100%, fill]0", "0[fill, top]0");
    bg.setLayout(layout);
    menu1 = new menu();
    header = new Header();
   main = new mainform();
  
menu1.addEvent(new EvenMenuSelected() {
        @Override
        public void menuSelected(int menuIndex, int subMenuIndex) {
         System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
            if (Auth.isManager()) {
                 if (menuIndex == 3) {
                 if (subMenuIndex ==0) {
                        main.showForm(new ViewKhachHang() );
                       System.out.println("");
                    } 
                }else
                    if (menuIndex == 1) {
                        if (subMenuIndex ==0) {
                             main.showForm(new ViewSanPham() );
                        }else if (subMenuIndex == 1) {
                            main.showForm(new ViewMatHang());
                        
                    }else if (subMenuIndex == 2) {
                        main.showForm(new ViewNhaCungCap() );
                    }
                       
                    }else if (menuIndex == 0) {
                        if (subMenuIndex ==-1) {
                             main.showForm(new home());
                        }
                       
                    }
                    else
                        if (menuIndex == 2) {
                        if (subMenuIndex ==2) {
                             main.showForm(new ViewTraHang());
                        }else if (subMenuIndex == 3) {
                            main.showForm(new ViewDoiHang());
                        }else if (subMenuIndex == 4) {
                            main.showForm(new ViewHoaDonBanHang());
                        }else if (subMenuIndex == 5) {
                            main.showForm(new ViewHoaDonNhapHang());
                        }else if (subMenuIndex == 6) {
                            main.showForm(new ViewHoaDonTraHang());
                        }else if (subMenuIndex == 7) {
                            main.showForm(new ViewHoaDonDoiHang());
                        }else if (subMenuIndex == 1) {
                            main.showForm(new ViewBanHang());
                        }else if (subMenuIndex == 0) {
                             main.showForm(new ViewNhapHang());
                           
                        }
                    }else
                            if (menuIndex == 4) {
                        if (subMenuIndex ==0) {
                             main.showForm(new ViewNhanVien());
                        }}else if (menuIndex == 5) {
                        if (subMenuIndex ==0) {
                             main.showForm(new ViewThongKeDoanhThu());
                        }else if (subMenuIndex == 1) {
                            main.showForm(new ViewThongKeDoanhSo());
                        }
                        }else if (menuIndex == 6) {
                        if (subMenuIndex ==0) {
                             main.showForm(new ViewThongtincanhan());
                        }else if (subMenuIndex == 1) {
                            main.showForm(new ViewDoiMatKhau());
                        }
                        }else if (menuIndex == 7) {
                        if (subMenuIndex ==-1) {
                            main.showForm(new ViewKhuyenMai());
                        }}else {

                        int i = JOptionPane.showConfirmDialog(rootPane, "bạn có muốn đăng xuất không ");
                        if (i == JOptionPane.YES_OPTION) {
                            
                            dispose();
                            login.setVisible(true);
                           
                        } else {
                            return;
                        }
                    }
            
            } else {
                if (menuIndex == 3) {
                 if (subMenuIndex ==0) {
                        main.showForm(new ViewKhachHang() );
                       System.out.println("");
                    } 
                }else
                    if (menuIndex == 1) {
                        if (subMenuIndex ==0) {
                            main.showForm(new ViewSanPham() );
                             
                        }else if (subMenuIndex == 1) {
                        main.showForm(new ViewMatHang());
                    }
                       
                    }else if (menuIndex == 0) {
                        if (subMenuIndex ==-1) {
                             main.showForm(new home());
                        }
                       
                    }
                    else
                        if (menuIndex == 2) {
                        if (subMenuIndex ==2) {
                             main.showForm(new ViewDoiHang());
                        }else if (subMenuIndex == 3) {
                            main.showForm(new ViewHoaDonBanHang());
                        }else if (subMenuIndex == 4) {
                            main.showForm(new ViewHoaDonNhapHang());
                        }else if (subMenuIndex == 5) {
                            main.showForm(new ViewHoaDonTraHang());
                        }else if (subMenuIndex == 6) {
                            main.showForm(new ViewHoaDonDoiHang());
                        }else if (subMenuIndex == 1) {
                            main.showForm(new ViewTraHang());
                        }else if (subMenuIndex == 0) {
                            main.showForm(new ViewBanHang());
                        }
                    }else if (menuIndex == 4) {
                        if (subMenuIndex ==0) {
                             main.showForm(new ViewThongKeDoanhThu());
                        }else if (subMenuIndex == 1) {
                            main.showForm(new ViewThongKeDoanhSo());
                        }
                        }else if (menuIndex == 5) {
                        if (subMenuIndex ==0) {
                             main.showForm(new ViewThongtincanhan());
                        }else if (subMenuIndex == 1) {
                            main.showForm(new ViewDoiMatKhau());
                        }
                        }else {

                        int i = JOptionPane.showConfirmDialog(rootPane, "bạn có muốn đăng xuất không ");
                        if (i == JOptionPane.YES_OPTION) {
                            
                            dispose();
                            login.setVisible(true);
                           
                        } else {
                            return;
                        }
                    }
                   
            }
               
        }
    });
//    menu1.addEventShowPopup(new EventShowPopupMenu() {
//            @Override
//            public void showPopup(Component com) {
//                MenuItem item = (MenuItem) com;
//                PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
//                int x = Main.this.getX() + 52;
//                int y = Main.this.getY() + com.getY() + 86;
//                popup.setLocation(x, y);
//                popup.setVisible(true);
//            }
//        });
    menu1.initMenuItem();
    bg.add(menu1,"w 230!, spany 2");
    bg.add(header,"h 50!, wrap");
    bg.add(main,"w 100%,h 100%");
    TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu1.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu1, "w " + width + "!, spany2");
                menu1.revalidate();
            }

            @Override
            public void end() {
                menu1.setShowMenu(!menu1.isShowMenu());
                menu1.setEnableMenu(true);
            }

        };
    animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu1.setEnableMenu(false);
                if (menu1.isShowMenu()) {
                    menu1.hideallMenu();
                }
            }
        });
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //  Start with this form
        main.showForm(new home());
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
