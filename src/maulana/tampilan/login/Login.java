package maulana.tampilan.login;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatDarculaLaf;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import maulana.koneksi.KoneksiDB;
import maulana.tampilan.data.Pemesanan;

import maulana.tampilan.main.Main;
import raven.toast.Notifications;

public class Login extends javax.swing.JFrame {

    private Connection koneksi = new KoneksiDB().connect();

    public Login() {
        initComponents();
        super.setExtendedState(MAXIMIZED_BOTH);
        init();
    }

    private void init() {
        txtUserID.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "masukan id user anda");
        txtUserID.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,10,5,20;"
                + "background:$Panel.background;");

        txtPass.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "masukan password anda");
        txtPass.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,10,5,20;"
                + "background:$Panel.background;");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRounded1 = new maulana.swing.PanelRounded();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUserID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmd = new maulana.swing.Button();
        txtPass = new javax.swing.JPasswordField();
        cbShowPass = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setText("Selamat Datang");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("ID Pengguna");

        txtUserID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserIDActionPerformed(evt);
            }
        });
        txtUserID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserIDKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Kata Sandi");

        cmd.setBackground(new java.awt.Color(0, 0, 204));
        cmd.setForeground(new java.awt.Color(255, 255, 255));
        cmd.setText("MASUK");
        cmd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdActionPerformed(evt);
            }
        });

        txtPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });

        cbShowPass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbShowPass.setText("Lihat kata sandi");
        cbShowPass.setContentAreaFilled(false);
        cbShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbShowPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRounded1Layout = new javax.swing.GroupLayout(panelRounded1);
        panelRounded1.setLayout(panelRounded1Layout);
        panelRounded1Layout.setHorizontalGroup(
            panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(cbShowPass)
                    .addGroup(panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        panelRounded1Layout.setVerticalGroup(
            panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cbShowPass)
                .addGap(40, 40, 40)
                .addComponent(cmd, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(400, Short.MAX_VALUE)
                .addComponent(panelRounded1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(400, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(panelRounded1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserIDActionPerformed
        txtPass.requestFocus();
    }//GEN-LAST:event_txtUserIDActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        cmd.doClick();
    }//GEN-LAST:event_txtPassActionPerformed

    private void txtUserIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserIDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtPass.requestFocus();
        }
    }//GEN-LAST:event_txtUserIDKeyPressed

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtUserID.requestFocus();
        }
    }//GEN-LAST:event_txtPassKeyPressed

    private void cbShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbShowPassActionPerformed
        if (cbShowPass.isSelected()) {
            txtPass.setEchoChar((char) 0);
        } else {
            txtPass.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_cbShowPassActionPerformed

    private void cmdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActionPerformed
        String id = txtUserID.getText();
        String password = new String(txtPass.getPassword());
        try {
            String query = "SELECT * FROM karyawan WHERE id_karyawan =? AND password=?";
            PreparedStatement statement = koneksi.prepareStatement(query);
            statement.setString(1, id);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String idKaryawan = resultSet.getString("id_karyawan");
                String namaKaryawan = resultSet.getString("nama_karyawan");

                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Proses masuk berhasil");

                new Thread(() -> {
                    try {
                        Thread.sleep(1500);  // Jeda
                        SwingUtilities.invokeLater(() -> {
                            this.setVisible(false);
                            Main main = new Main();

                            if (idKaryawan != null && namaKaryawan != null) {
                                main.setIdKaryawan(idKaryawan); // Set idKaryawan ke instance Main
                                main.setNamaKaryawan(namaKaryawan); // Set namaKaryawan ke instance Main
                            } else {
                                System.out.println("ID atau Nama Karyawan kosong!");
                            }

                            main.setVisible(true);
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, "Login gagal! Username atau Password salah");
            }
        } catch (SQLException e) {            
            e.printStackTrace();
        }
    }//GEN-LAST:event_cmdActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int pilih = JOptionPane.showConfirmDialog(
                this,
                "Apakah anda yakin ingin keluar",
                "Konfirmasi Dialog",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (pilih == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        FlatDarculaLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbShowPass;
    private maulana.swing.Button cmd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private maulana.swing.PanelRounded panelRounded1;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUserID;
    // End of variables declaration//GEN-END:variables
}
