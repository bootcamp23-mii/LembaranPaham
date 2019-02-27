/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.EmployeeController;
import models.Employee;
import tools.DBConnection;
import controllers.JobController;
import controllers.UserController;
import daos.JobDAO;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.Job;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author FES
 */
public class HRView extends javax.swing.JFrame {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//    UserController uc = new UserController(sessionFactory);
    

    /**
     * Creates new form NewJFrame
     */
    public HRView() {
        initComponents();
        getMiddle(); 
        jpRegister.setVisible(false);
    }

    private void getMiddle() {
        int frameWidth = ((dim.width - this.getSize().width) / 2);
        int frameHeigth = ((dim.height - this.getSize().height) / 2);
        this.setLocation(frameWidth, frameHeigth);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jpRegister = new javax.swing.JPanel();
        tfUnameReg = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        pfPassReg = new javax.swing.JPasswordField();
        pfPassConfirm = new javax.swing.JPasswordField();
        btRegister = new javax.swing.JButton();
        lblPass = new javax.swing.JLabel();
        lblPassConfirm = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanelLogin = new javax.swing.JPanel();
        jLabelUsername = new javax.swing.JLabel();
        jTextUsername = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();
        tbToRegister = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jobsframe = new javax.swing.JMenuItem();
        regionMenuItem = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        deptMenuItem = new javax.swing.JMenuItem();
        locationMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelMain.setLayout(new javax.swing.OverlayLayout(jPanelMain));

        lblUsername.setText("Username");

        btRegister.setText("Register");
        btRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegisterActionPerformed(evt);
            }
        });

        lblPass.setText("Password");

        lblPassConfirm.setText("Password Confirmation");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Register");

        javax.swing.GroupLayout jpRegisterLayout = new javax.swing.GroupLayout(jpRegister);
        jpRegister.setLayout(jpRegisterLayout);
        jpRegisterLayout.setHorizontalGroup(
            jpRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegisterLayout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addGroup(jpRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRegisterLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1))
                    .addGroup(jpRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btRegister)
                        .addGroup(jpRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPass)
                            .addGroup(jpRegisterLayout.createSequentialGroup()
                                .addGroup(jpRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPassConfirm)
                                    .addComponent(lblUsername))
                                .addGap(39, 39, 39)
                                .addGroup(jpRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pfPassReg)
                                    .addComponent(pfPassConfirm)
                                    .addComponent(tfUnameReg, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(276, Short.MAX_VALUE))
        );
        jpRegisterLayout.setVerticalGroup(
            jpRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRegisterLayout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jpRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUnameReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername))
                .addGap(18, 18, 18)
                .addGroup(jpRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pfPassReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPass))
                .addGap(18, 18, 18)
                .addGroup(jpRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pfPassConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassConfirm))
                .addGap(18, 18, 18)
                .addComponent(btRegister)
                .addGap(141, 141, 141))
        );

        jPanelMain.add(jpRegister);

        jLabelUsername.setText("Username");

        jLabelPassword.setText("Password");

        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jPasswordField.setToolTipText("");

        tbToRegister.setText("Register");
        tbToRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbToRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addContainerGap(201, Short.MAX_VALUE)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUsername)
                    .addComponent(jLabelPassword))
                .addGap(28, 28, 28)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addComponent(jButtonLogin)
                        .addGap(18, 18, 18)
                        .addComponent(tbToRegister))
                    .addComponent(jTextUsername)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addGap(231, 231, 231))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUsername))
                .addGap(18, 18, 18)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLogin)
                    .addComponent(tbToRegister))
                .addContainerGap(178, Short.MAX_VALUE))
        );

        jPanelMain.add(jPanelLogin);

        jMenu1.setText("CRUD");
        jMenu1.setEnabled(false);

        jMenuItem1.setText("Employees");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jobsframe.setText("Jobs");
        jobsframe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobsframeActionPerformed(evt);
            }
        });
        jMenu1.add(jobsframe);

        regionMenuItem.setText("Regions");
        regionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regionMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(regionMenuItem);

        jMenuItem2.setText("Countries");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        deptMenuItem.setText("Department");
        deptMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(deptMenuItem);

        locationMenu.setText("Location");
        locationMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationMenuActionPerformed(evt);
            }
        });
        jMenu1.add(locationMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        EmployeeView ev = new EmployeeView();
        jPanelMain.add(ev);
        ev.setVisible(true);
//        jIFEmployee.setBounds(5, 5, 200, 300);
        ev.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ev.revalidate();
//        jPanel1.add(jInternalFrame1, javax.swing.JLayeredPane.DEFAULT_LAYER);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jobsframeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobsframeActionPerformed
        JobView n = new JobView();
        jPanelMain.add(n);
        n.setVisible(true);

    }//GEN-LAST:event_jobsframeActionPerformed


    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_searchActionPerformed

    private void tf_minsalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_minsalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_minsalActionPerformed

    private void tf_maxsalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_maxsalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_maxsalActionPerformed

    private void bt_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_insertActionPerformed

    }//GEN-LAST:event_bt_insertActionPerformed

    private void bt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateActionPerformed

    }//GEN-LAST:event_bt_updateActionPerformed

    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed

    }//GEN-LAST:event_bt_deleteActionPerformed

    private void tf_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_idActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void tf_minsalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_minsalKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_tf_minsalKeyTyped

    private void tf_maxsalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_maxsalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_maxsalKeyTyped

    private void regionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regionMenuItemActionPerformed
        // TODO add your handling code here:
        RegionView rv = new RegionView();
        jPanelMain.add(rv);
        rv.setVisible(true);
    }//GEN-LAST:event_regionMenuItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        CountryView cv = new CountryView();
        jPanelMain.add(cv);
        cv.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void locationMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationMenuActionPerformed
        // TODO add your handling code here:
        LocationView lv = new LocationView();
        jPanelMain.add(lv);
        lv.setVisible(true);
    }//GEN-LAST:event_locationMenuActionPerformed

    private void deptMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptMenuItemActionPerformed
        DepartmentView dv = new DepartmentView();
        jPanelMain.add(dv);
        dv.setVisible(true);
    }//GEN-LAST:event_deptMenuItemActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        String pass = "";
        for (char c : jPasswordField.getPassword()) {
            pass += c;
        }
        if (uc.login(jTextUsername.getText(), pass)) {
            JOptionPane.showMessageDialog(null, "Login Sukses.");
//            jPanelLogin.setEnabled(false);
            jPanelLogin.setVisible(false);
            jMenu1.setEnabled(true);
        } else {
            jTextUsername.setText("");
            jPasswordField.setText("");
            JOptionPane.showMessageDialog(null, "Username atau Password salah.");
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void tbToRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbToRegisterActionPerformed
        // TODO add your handling code here:
//        Register reg = new Register();
        jPanelLogin.setVisible(false);
        jpRegister.setVisible(true);
    }//GEN-LAST:event_tbToRegisterActionPerformed

    private void btRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegisterActionPerformed
        String pass = "";
        String passconf = "";
        for (char c : pfPassReg.getPassword()) {
            pass += c;
        }
        for (char c : pfPassConfirm.getPassword()) {
            passconf += c;
        }
        if (tfUnameReg.getText().isEmpty() || pass.isEmpty() || passconf.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lengkapi Data");
        } else if (uc.getById(tfUnameReg.getText()).size() != 0) {
            JOptionPane.showMessageDialog(null, "Username sudah digunakan");
        } else if (!Arrays.equals(pfPassReg.getPassword(), pfPassConfirm.getPassword())) {
            JOptionPane.showMessageDialog(null, "Password tidak sama");
        } else if (pfPassReg.getPassword().length < 6) {
            JOptionPane.showMessageDialog(null, "Password minimal 6 karakter");
        } else {
            JOptionPane.showMessageDialog(null, uc.register(tfUnameReg.getText(), pass));
            jpRegister.setVisible(false);
            jPanelLogin.setVisible(true);
            

        }
    }//GEN-LAST:event_btRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(HRView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HRView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HRView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HRView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HRView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegister;
    private javax.swing.JMenuItem deptMenuItem;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    public javax.swing.JPanel jPanelLogin;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextUsername;
    private javax.swing.JMenuItem jobsframe;
    private javax.swing.JPanel jpRegister;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPassConfirm;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JMenuItem locationMenu;
    private javax.swing.JPasswordField pfPassConfirm;
    private javax.swing.JPasswordField pfPassReg;
    private javax.swing.JMenuItem regionMenuItem;
    private javax.swing.JButton tbToRegister;
    private javax.swing.JTextField tfUnameReg;
    // End of variables declaration//GEN-END:variables
}
