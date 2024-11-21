package maulana.tampilan.main;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import java.sql.Connection;
import javax.swing.JOptionPane;
import maulana.tampilan.data.Dashboard;
import maulana.tampilan.data.DataMobil;
import maulana.tampilan.data.DataKaryawan;
import maulana.tampilan.data.DataPelanggan;
import maulana.tampilan.data.DataSupir;
import maulana.koneksi.KoneksiDB;
import maulana.panel.report.ReportMobil;
import maulana.panel.report.ReportPelanggan;
import maulana.panel.report.ReportPembayaran;
import maulana.panel.report.ReportPemesanan;
import maulana.tampilan.data.Pembayaran;
import maulana.tampilan.data.Pemesanan;
import maulana.tampilan.login.Login;
import raven.popup.GlassPanePopup;
import raven.toast.Notifications;

public class Main extends javax.swing.JFrame {

    private String idKaryawan;
    private Connection koneksi = new KoneksiDB().connect();

    public Main() {
        initComponents();
        init();
        super.setExtendedState(MAXIMIZED_BOTH);
    }

    public void setIdKaryawan(String id) {
        if (id != null) {
            this.idKaryawan = id;  // Simpan nilai ke variabel instance
        } else {
            System.out.println("ID Karyawan null saat setIdKaryawan dipanggil!");
        }
    }

    public void setNamaKaryawan(String nama) {
        lblNamaKaryawan.setText(nama);
    }

    private void init() {
        GlassPanePopup.install(this);
        Notifications.getInstance().setJFrame(this);
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Panel.background;");
        scrollPenampil.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Panel.background;");
        cmdDashboard.putClientProperty(FlatClientProperties.STYLE, "arc:15;");
        cmdLogOut.putClientProperty(FlatClientProperties.STYLE, "arc:15;");
        cmdPenyewaan.putClientProperty(FlatClientProperties.STYLE, "arc:15;");
        cmdPembayaran.putClientProperty(FlatClientProperties.STYLE, "arc:15;");
        cmdPelanggan.putClientProperty(FlatClientProperties.STYLE, "arc:15;");
        cmdKaryawan.putClientProperty(FlatClientProperties.STYLE, "arc:15;");
        cmdModil.putClientProperty(FlatClientProperties.STYLE, "arc:15;");
        cmdSopir.putClientProperty(FlatClientProperties.STYLE, "arc:15;");
        cmdRepotPembayaran.putClientProperty(FlatClientProperties.STYLE, "arc:15;");
        cmdRepotMobil.putClientProperty(FlatClientProperties.STYLE, "arc:15;");
        cmdRepotPelanggan.putClientProperty(FlatClientProperties.STYLE, "arc:15;");
        cmdReportPemesanan.putClientProperty(FlatClientProperties.STYLE, "arc:15;");
        penampil.removeAll();
        penampil.add(new Dashboard());
        penampil.repaint();
        penampil.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblNamaKaryawan = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        cmdDashboard = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmdPenyewaan = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmdPembayaran = new javax.swing.JButton();
        cmdKaryawan = new javax.swing.JButton();
        cmdPelanggan = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmdModil = new javax.swing.JButton();
        cmdSopir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmdReportPemesanan = new javax.swing.JButton();
        cmdRepotPembayaran = new javax.swing.JButton();
        cmdRepotMobil = new javax.swing.JButton();
        cmdRepotPelanggan = new javax.swing.JButton();
        cmdLogOut = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        scrollPenampil = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        penampil = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CV. ADN");

        lblNamaKaryawan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNamaKaryawan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNamaKaryawan.setText("Muhammad Maulana Saldi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 811, Short.MAX_VALUE)
                .addComponent(lblNamaKaryawan)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addComponent(lblNamaKaryawan))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new java.awt.Dimension(220, 600));

        jPanel5.setPreferredSize(new java.awt.Dimension(220, 612));

        cmdDashboard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmdDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maulana/icon/Dashboard.png"))); // NOI18N
        cmdDashboard.setText("Dashboard");
        cmdDashboard.setAlignmentY(0.0F);
        cmdDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cmdDashboard.setMargin(new java.awt.Insets(10, 5, 10, 14));
        cmdDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDashboardActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Dashboard");

        cmdPenyewaan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmdPenyewaan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maulana/icon/Car Rental.png"))); // NOI18N
        cmdPenyewaan.setText("Pemesanan");
        cmdPenyewaan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdPenyewaan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cmdPenyewaan.setMargin(new java.awt.Insets(10, 5, 10, 14));
        cmdPenyewaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPenyewaanActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Transaksi");

        cmdPembayaran.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmdPembayaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maulana/icon/Card Payment.png"))); // NOI18N
        cmdPembayaran.setText("Pembayaran");
        cmdPembayaran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdPembayaran.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cmdPembayaran.setMargin(new java.awt.Insets(10, 5, 10, 14));
        cmdPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPembayaranActionPerformed(evt);
            }
        });

        cmdKaryawan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmdKaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maulana/icon/Manager.png"))); // NOI18N
        cmdKaryawan.setText("Karyawan");
        cmdKaryawan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdKaryawan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cmdKaryawan.setMargin(new java.awt.Insets(10, 5, 10, 14));
        cmdKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKaryawanActionPerformed(evt);
            }
        });

        cmdPelanggan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmdPelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maulana/icon/Customer.png"))); // NOI18N
        cmdPelanggan.setText("Pelanggan");
        cmdPelanggan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdPelanggan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cmdPelanggan.setMargin(new java.awt.Insets(10, 5, 10, 14));
        cmdPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPelangganActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Form");

        cmdModil.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmdModil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maulana/icon/Car.png"))); // NOI18N
        cmdModil.setText("Mobil");
        cmdModil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdModil.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cmdModil.setMargin(new java.awt.Insets(10, 5, 10, 14));
        cmdModil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdModilActionPerformed(evt);
            }
        });

        cmdSopir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmdSopir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maulana/icon/Driver.png"))); // NOI18N
        cmdSopir.setText("Sopir");
        cmdSopir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdSopir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cmdSopir.setMargin(new java.awt.Insets(10, 5, 10, 14));
        cmdSopir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSopirActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Laporan");

        cmdReportPemesanan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmdReportPemesanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maulana/icon/Purchase Order.png"))); // NOI18N
        cmdReportPemesanan.setText("Laporan Pemesanan");
        cmdReportPemesanan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdReportPemesanan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cmdReportPemesanan.setMargin(new java.awt.Insets(10, 5, 10, 14));
        cmdReportPemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdReportPemesananActionPerformed(evt);
            }
        });

        cmdRepotPembayaran.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmdRepotPembayaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maulana/icon/Statistics Report.png"))); // NOI18N
        cmdRepotPembayaran.setText("Laporan Pembayaran");
        cmdRepotPembayaran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdRepotPembayaran.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cmdRepotPembayaran.setMargin(new java.awt.Insets(10, 5, 10, 14));
        cmdRepotPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRepotPembayaranActionPerformed(evt);
            }
        });

        cmdRepotMobil.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmdRepotMobil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maulana/icon/Graph Report.png"))); // NOI18N
        cmdRepotMobil.setText("Laporan Mobil");
        cmdRepotMobil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdRepotMobil.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cmdRepotMobil.setMargin(new java.awt.Insets(10, 5, 10, 14));
        cmdRepotMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRepotMobilActionPerformed(evt);
            }
        });

        cmdRepotPelanggan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmdRepotPelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maulana/icon/Statistics Report.png"))); // NOI18N
        cmdRepotPelanggan.setText("Laporan Pelanggan");
        cmdRepotPelanggan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdRepotPelanggan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cmdRepotPelanggan.setMargin(new java.awt.Insets(10, 5, 10, 14));
        cmdRepotPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRepotPelangganActionPerformed(evt);
            }
        });

        cmdLogOut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmdLogOut.setForeground(new java.awt.Color(255, 255, 255));
        cmdLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maulana/icon/Logout.png"))); // NOI18N
        cmdLogOut.setText("Log Out");
        cmdLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdLogOut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cmdLogOut.setIconTextGap(10);
        cmdLogOut.setMargin(new java.awt.Insets(10, 5, 10, 14));
        cmdLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdPenyewaan, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmdPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cmdModil, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdSopir, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cmdReportPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdRepotPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdRepotMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdRepotPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmdDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdPenyewaan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdModil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdSopir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdReportPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdRepotPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdRepotMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdRepotPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        scroll.setViewportView(jPanel5);

        getContentPane().add(scroll, java.awt.BorderLayout.LINE_START);

        scrollPenampil.setBorder(null);

        penampil.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(penampil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(penampil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        scrollPenampil.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPenampil, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPenampil, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDashboardActionPerformed
        penampil.removeAll();
        penampil.add(new Dashboard());
        penampil.repaint();
        penampil.revalidate();
    }//GEN-LAST:event_cmdDashboardActionPerformed

    private void cmdPenyewaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPenyewaanActionPerformed
        penampil.removeAll();
        Pemesanan pesanan = new Pemesanan();

        // Set idKaryawan ke Pemesanan
        pesanan.setIdKaryawan(idKaryawan);

        penampil.add(pesanan);
        penampil.repaint();
        penampil.revalidate();

        // Debugging untuk memastikan idKaryawan dikirim ke Pemesanan
        System.out.println("ID Karyawan after setting in Pemesanan: " + idKaryawan);
    }//GEN-LAST:event_cmdPenyewaanActionPerformed

    private void cmdPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPembayaranActionPerformed
        penampil.removeAll();
        Pembayaran pembayaran = new Pembayaran();
        pembayaran.setIDKaryawan(idKaryawan);
        penampil.add(pembayaran);
        penampil.repaint();
        penampil.revalidate();

    }//GEN-LAST:event_cmdPembayaranActionPerformed

    private void cmdKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKaryawanActionPerformed
        penampil.removeAll();
        penampil.add(new DataKaryawan());
        penampil.repaint();
        penampil.revalidate();
    }//GEN-LAST:event_cmdKaryawanActionPerformed

    private void cmdPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPelangganActionPerformed
        penampil.removeAll();
        penampil.add(new DataPelanggan());
        penampil.repaint();
        penampil.revalidate();
    }//GEN-LAST:event_cmdPelangganActionPerformed

    private void cmdModilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdModilActionPerformed
        penampil.removeAll();
        penampil.add(new DataMobil());
        penampil.repaint();
        penampil.revalidate();
    }//GEN-LAST:event_cmdModilActionPerformed

    private void cmdSopirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSopirActionPerformed
        penampil.removeAll();
        penampil.add(new DataSupir());
        penampil.repaint();
        penampil.revalidate();
    }//GEN-LAST:event_cmdSopirActionPerformed

    private void cmdReportPemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdReportPemesananActionPerformed
        penampil.removeAll();
        penampil.add(new ReportPemesanan());
        penampil.repaint();
        penampil.revalidate();
    }//GEN-LAST:event_cmdReportPemesananActionPerformed

    private void cmdRepotPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRepotPembayaranActionPerformed
        penampil.removeAll();
        penampil.add(new ReportPembayaran());
        penampil.repaint();
        penampil.revalidate();
    }//GEN-LAST:event_cmdRepotPembayaranActionPerformed

    private void cmdRepotMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRepotMobilActionPerformed
        penampil.removeAll();
        penampil.add(new ReportMobil());
        penampil.repaint();
        penampil.revalidate();
    }//GEN-LAST:event_cmdRepotMobilActionPerformed

    private void cmdRepotPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRepotPelangganActionPerformed
        penampil.removeAll();
        penampil.add(new ReportPelanggan());
        penampil.repaint();
        penampil.revalidate();
    }//GEN-LAST:event_cmdRepotPelangganActionPerformed

    private void cmdLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLogOutActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin Log Out?", "Konfirmasi Log Out", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_cmdLogOutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMacDarkLaf.setup();
        FlatLaf.registerCustomDefaultsSource("sample.themes");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdDashboard;
    private javax.swing.JButton cmdKaryawan;
    private javax.swing.JButton cmdLogOut;
    private javax.swing.JButton cmdModil;
    private javax.swing.JButton cmdPelanggan;
    private javax.swing.JButton cmdPembayaran;
    private javax.swing.JButton cmdPenyewaan;
    private javax.swing.JButton cmdReportPemesanan;
    private javax.swing.JButton cmdRepotMobil;
    private javax.swing.JButton cmdRepotPelanggan;
    private javax.swing.JButton cmdRepotPembayaran;
    private javax.swing.JButton cmdSopir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblNamaKaryawan;
    private javax.swing.JPanel penampil;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JScrollPane scrollPenampil;
    // End of variables declaration//GEN-END:variables
}
