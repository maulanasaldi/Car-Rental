/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maulana.tampilan.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;
import maulana.koneksi.KoneksiDB;
import maulana.tampilan.popup.PopUpDataMobilPemabayaran;
import maulana.tampilan.popup.PopUpDataPemesanan;
import maulana.tampilan.popup.PopUpDataSupir;

/**
 *
 * @author mmaul
 */
public class Pembayaran extends javax.swing.JPanel {

    public void setIDKaryawan(String idKaryawan) {
        txtIDKaryawan.setText(idKaryawan);
    }

    public void setLblGambar(ImageIcon imageIcon) {
        lblGambarMobil.setIcon(imageIcon);
    }

    public String getIDKaryawan() {
        return txtIDKaryawan.getText();
    }

    private Connection koneksi = new KoneksiDB().connect();
    public String idPesanan, namaPelanggan, noTlpnPelanggan, idMobil, hargaMobil, lamaSewa, dp;
    public int totalHarga;
    public String merek, jenis, platNomor, kapasitas, tarif, status;
    public String idSupir, namaSupir, noTlpnSupir, alamatSupir;
    public int tarifSupir;
    public ImageIcon gambar;  // Ubah tipe data gambar menjadi ImageIcon    

    public Pembayaran() {
        initComponents();
        aktif();
        autoNumber();        
    }

    private void aktif() {
        txtTanggalPembayaran.setEditor(new JSpinner.DateEditor(txtTanggalPembayaran, "yyyy-mm-dd"));
    }

    private void autoNumber() {
        try {
            String query = "SELECT id_pembayaran FROM pembayaran ORDER BY id_pembayaran DESC LIMIT 1";
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(query);
            String nextID = "2100001";
            if (rs.next()) {
                String id_pesanan = rs.getString("id_pembayaran").substring(2); // Mengambil ID awalan "MB"
                int Angka = Integer.parseInt(id_pesanan) + 1; // Menaikkan angka

                // Menentukan jumlah nol di depan berdasarkan nilai Angka
                String Nol = String.format("%05d", Angka); // Membuat format string "000", "00", "0", atau "" sesuai dengan nilai Angka
                nextID = "21" + Nol; // Membuat ID baru
            }

            // Mengatur ID baru ke form
            txtIDPembayaran.setText(nextID);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Auto nomor gagal: " + e.getMessage());
        }
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        panelRounded1 = new maulana.swing.PanelRounded();
        txtIDPembayaran = new maulana.swing.TextFieldFlatLaf();
        panelRounded4 = new maulana.swing.PanelRounded();
        txtTanggalPembayaran = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        txtIDKaryawan = new maulana.swing.TextFieldFlatLaf();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        panelRounded6 = new maulana.swing.PanelRounded();
        panelRounded2 = new maulana.swing.PanelRounded();
        txtIDPesanan = new maulana.swing.TextFieldFlatLaf();
        jLabel1 = new javax.swing.JLabel();
        btnCekDataPesanan = new maulana.swing.ButtonAction();
        jLabel2 = new javax.swing.JLabel();
        txtNamaPelanggan = new maulana.swing.TextFieldFlatLaf();
        txtNoTlpPelanggan = new maulana.swing.TextFieldFlatLaf();
        jLabel3 = new javax.swing.JLabel();
        panelRounded3 = new maulana.swing.PanelRounded();
        txtIDMobil = new maulana.swing.TextFieldFlatLaf();
        jLabel5 = new javax.swing.JLabel();
        btnCekDataMobil = new maulana.swing.ButtonAction();
        jLabel6 = new javax.swing.JLabel();
        txtHargaMobil = new maulana.swing.TextFieldFlatLaf();
        txtLamaSewa = new maulana.swing.TextFieldFlatLaf();
        jLabel7 = new javax.swing.JLabel();
        txtDp = new maulana.swing.TextFieldFlatLaf();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTotal = new maulana.swing.TextFieldFlatLaf();
        jPanel3 = new javax.swing.JPanel();
        panelRounded8 = new maulana.swing.PanelRounded();
        lblGambarMobil = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblMerekMobil = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblJenisMobil = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblPlatNomor = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblKapasitas = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblStatusMobil = new javax.swing.JLabel();
        panelRounded9 = new maulana.swing.PanelRounded();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtNamaSupir = new maulana.swing.TextFieldFlatLaf();
        txtNoTlpSupir = new maulana.swing.TextFieldFlatLaf();
        jLabel22 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtIDSopir = new maulana.swing.TextFieldFlatLaf();
        btnCekDataSupir = new maulana.swing.ButtonAction();
        rdBtnYa = new javax.swing.JRadioButton();
        txtTarifSupir = new maulana.swing.TextFieldFlatLaf();
        jLabel35 = new javax.swing.JLabel();
        rdBtnTidak = new javax.swing.JRadioButton();
        btnCekDataSupir1 = new maulana.swing.ButtonAction();
        panelRounded7 = new maulana.swing.PanelRounded();
        btnSimpan = new maulana.swing.ButtonAction();
        btnBatalPembayaran = new maulana.swing.ButtonAction();
        panelRounded5 = new maulana.swing.PanelRounded();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtTotalHarga = new maulana.swing.TextFieldFlatLaf();
        txtUang = new maulana.swing.TextFieldFlatLaf();
        txtKembali = new maulana.swing.TextFieldFlatLaf();
        jLabel33 = new javax.swing.JLabel();

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        panelRounded1.setBorder(javax.swing.BorderFactory.createTitledBorder("ID Pembayaran"));

        txtIDPembayaran.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout panelRounded1Layout = new javax.swing.GroupLayout(panelRounded1);
        panelRounded1.setLayout(panelRounded1Layout);
        panelRounded1Layout.setHorizontalGroup(
            panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(txtIDPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        panelRounded1Layout.setVerticalGroup(
            panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtIDPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        txtTanggalPembayaran.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTanggalPembayaran.setModel(new javax.swing.SpinnerDateModel());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Tanggal");

        txtIDKaryawan.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("ID Karyawan");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Pembayaran");

        javax.swing.GroupLayout panelRounded4Layout = new javax.swing.GroupLayout(panelRounded4);
        panelRounded4.setLayout(panelRounded4Layout);
        panelRounded4Layout.setHorizontalGroup(
            panelRounded4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded4Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTanggalPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        panelRounded4Layout.setVerticalGroup(
            panelRounded4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelRounded4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTanggalPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtIDKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(15, 15, 15))
        );

        panelRounded6.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Pesanan"));

        panelRounded2.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Pelanggan"));

        txtIDPesanan.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("ID Pesanan");

        btnCekDataPesanan.setText("CEK");
        btnCekDataPesanan.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnCekDataPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekDataPesananActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nama");

        txtNamaPelanggan.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txtNoTlpPelanggan.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("No. Telepon");

        javax.swing.GroupLayout panelRounded2Layout = new javax.swing.GroupLayout(panelRounded2);
        panelRounded2.setLayout(panelRounded2Layout);
        panelRounded2Layout.setHorizontalGroup(
            panelRounded2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRounded2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRounded2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCekDataPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRounded2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRounded2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNoTlpPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        panelRounded2Layout.setVerticalGroup(
            panelRounded2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelRounded2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRounded2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIDPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCekDataPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(panelRounded2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRounded2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoTlpPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelRounded3.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Pesanan"));

        txtIDMobil.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("ID Mobil");

        btnCekDataMobil.setText("CEK");
        btnCekDataMobil.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnCekDataMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekDataMobilActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Harga /Hari");

        txtHargaMobil.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txtLamaSewa.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Lama Sewa");

        txtDp.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("DP");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Total");

        txtTotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        javax.swing.GroupLayout panelRounded3Layout = new javax.swing.GroupLayout(panelRounded3);
        panelRounded3.setLayout(panelRounded3Layout);
        panelRounded3Layout.setHorizontalGroup(
            panelRounded3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRounded3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRounded3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCekDataMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRounded3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHargaMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRounded3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLamaSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRounded3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDp, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRounded3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        panelRounded3Layout.setVerticalGroup(
            panelRounded3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelRounded3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRounded3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIDMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCekDataMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(panelRounded3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRounded3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLamaSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRounded3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRounded3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtDp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(panelRounded3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout panelRounded6Layout = new javax.swing.GroupLayout(panelRounded6);
        panelRounded6.setLayout(panelRounded6Layout);
        panelRounded6Layout.setHorizontalGroup(
            panelRounded6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRounded6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRounded2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRounded3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelRounded6Layout.setVerticalGroup(
            panelRounded6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRounded2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRounded3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblGambarMobil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGambarMobil.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Merek Mobil");

        lblMerekMobil.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMerekMobil.setText("----------------");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setText("Jenis Mobil");

        lblJenisMobil.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblJenisMobil.setText("----------------");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel24.setText("Plat Nomor");

        lblPlatNomor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPlatNomor.setText("----------------");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel26.setText("Kapasitas");

        lblKapasitas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblKapasitas.setText("----------------");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel28.setText("Status");

        lblStatusMobil.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblStatusMobil.setText("----------------");

        panelRounded9.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Supir"));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Pakai Supir");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Nama");

        txtNamaSupir.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txtNoTlpSupir.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("No. Telepon");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("ID Supir");

        txtIDSopir.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        btnCekDataSupir.setText("CEK");
        btnCekDataSupir.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnCekDataSupir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekDataSupirActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdBtnYa);
        rdBtnYa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdBtnYa.setText("Ya");
        rdBtnYa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBtnYaActionPerformed(evt);
            }
        });

        txtTarifSupir.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("Tarif /Hari");

        buttonGroup1.add(rdBtnTidak);
        rdBtnTidak.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdBtnTidak.setText("Tidak");
        rdBtnTidak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBtnTidakActionPerformed(evt);
            }
        });

        btnCekDataSupir1.setText("TAMBAH");
        btnCekDataSupir1.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnCekDataSupir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekDataSupir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRounded9Layout = new javax.swing.GroupLayout(panelRounded9);
        panelRounded9.setLayout(panelRounded9Layout);
        panelRounded9Layout.setHorizontalGroup(
            panelRounded9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded9Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panelRounded9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRounded9Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdBtnYa, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdBtnTidak, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                        .addGap(108, 108, 108))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRounded9Layout.createSequentialGroup()
                        .addGroup(panelRounded9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRounded9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded9Layout.createSequentialGroup()
                                .addComponent(txtIDSopir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCekDataSupir, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNamaSupir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNoTlpSupir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelRounded9Layout.createSequentialGroup()
                                .addComponent(txtTarifSupir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCekDataSupir1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        panelRounded9Layout.setVerticalGroup(
            panelRounded9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded9Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelRounded9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdBtnYa)
                    .addComponent(rdBtnTidak))
                .addGap(10, 10, 10)
                .addGroup(panelRounded9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRounded9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIDSopir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCekDataSupir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(panelRounded9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaSupir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRounded9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoTlpSupir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRounded9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTarifSupir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCekDataSupir1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout panelRounded8Layout = new javax.swing.GroupLayout(panelRounded8);
        panelRounded8.setLayout(panelRounded8Layout);
        panelRounded8Layout.setHorizontalGroup(
            panelRounded8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGambarMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRounded8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMerekMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJenisMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlatNomor, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKapasitas, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatusMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRounded9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        panelRounded8Layout.setVerticalGroup(
            panelRounded8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRounded8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRounded8Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMerekMobil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblJenisMobil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPlatNomor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblKapasitas, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStatusMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRounded9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGambarMobil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        btnSimpan.setText("SIMPAN PEMBAYARAN");

        btnBatalPembayaran.setText("BATAL PEMBAYARAN");

        javax.swing.GroupLayout panelRounded7Layout = new javax.swing.GroupLayout(panelRounded7);
        panelRounded7.setLayout(panelRounded7Layout);
        panelRounded7Layout.setHorizontalGroup(
            panelRounded7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBatalPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panelRounded7Layout.setVerticalGroup(
            panelRounded7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRounded7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatalPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        panelRounded5.setBorder(javax.swing.BorderFactory.createTitledBorder("Pembayaran"));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Total Harga");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Uang");

        txtTotalHarga.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txtUang.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txtKembali.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("Kembali");

        javax.swing.GroupLayout panelRounded5Layout = new javax.swing.GroupLayout(panelRounded5);
        panelRounded5.setLayout(panelRounded5Layout);
        panelRounded5Layout.setHorizontalGroup(
            panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUang, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(txtTotalHarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        panelRounded5Layout.setVerticalGroup(
            panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRounded7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelRounded5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelRounded8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(panelRounded8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRounded5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRounded7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRounded4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRounded6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRounded1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRounded4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelRounded1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRounded6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))))
        );

        jTabbedPane1.addTab("Pembayaran", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCekDataPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekDataPesananActionPerformed
        // Membuat dialog baru yang berisi panel PopUpDataPelanggan
        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Data Pelanggan", true);

        // Menambahkan panel PopUpDataPelanggan ke dalam dialog
        PopUpDataPemesanan dataPemesanan = new PopUpDataPemesanan(dialog);
        dataPemesanan.pemesanan = this;
        dialog.add(dataPemesanan);

        // Mengatur ukuran dan lokasi dialog
        dialog.setSize(776, 400);
        dialog.setLocationRelativeTo(null); // Agar dialog muncul di tengah
        dialog.setResizable(false); // Menonaktifkan resize
        dialog.setVisible(true); // Menampilkan dialog
    }//GEN-LAST:event_btnCekDataPesananActionPerformed

    public void itemTerpilihPemesanan() {
        txtIDPesanan.setText(idPesanan);
        txtNamaPelanggan.setText(namaPelanggan);
        txtNoTlpPelanggan.setText(noTlpnPelanggan);
        txtIDMobil.setText(idMobil);
        txtHargaMobil.setText(hargaMobil);
        txtLamaSewa.setText(lamaSewa);
        txtDp.setText(dp);
        txtTotal.setText(String.valueOf(totalHarga));
        txtTotalHarga.setText(String.valueOf(totalHarga));
    }

    private void btnCekDataMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekDataMobilActionPerformed
        // Membuat dialog baru yang berisi panel PopUpDataPelanggan
        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Data Mobil", true);

        // Menambahkan panel PopUpDataPelanggan ke dalam dialog
        PopUpDataMobilPemabayaran dataMobil = new PopUpDataMobilPemabayaran(dialog);
        dataMobil.mobilPembayaran = this;
        dataMobil.setVisible(true);
        dialog.add(dataMobil);

        // Mengatur ukuran dan lokasi dialog
        dialog.setSize(776, 400);
        dialog.setLocationRelativeTo(null); // Agar dialog muncul di tengah
        dialog.setResizable(false); // Menonaktifkan resize
        dialog.setVisible(true); // Menampilkan dialog
    }//GEN-LAST:event_btnCekDataMobilActionPerformed

    public void itemTerpilihMobil() {
        txtIDMobil.setText(idMobil);
        txtHargaMobil.setText(tarif);
        lblMerekMobil.setText(merek);
        lblJenisMobil.setText(jenis);
        lblPlatNomor.setText(platNomor);
        lblKapasitas.setText(kapasitas + " Orang");
        lblStatusMobil.setText(status);
    }

    private void rdBtnTidakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBtnTidakActionPerformed
        txtIDSopir.setEnabled(false);
        txtNamaSupir.setEnabled(false);
        txtNoTlpSupir.setEnabled(false);
        txtTarifSupir.setEnabled(false);
        btnCekDataSupir.setEnabled(false);
    }//GEN-LAST:event_rdBtnTidakActionPerformed

    private void rdBtnYaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBtnYaActionPerformed
        txtIDSopir.setEnabled(true);
        txtNamaSupir.setEnabled(true);
        txtNoTlpSupir.setEnabled(true);
        txtTarifSupir.setEnabled(true);
        btnCekDataSupir.setEnabled(true);
    }//GEN-LAST:event_rdBtnYaActionPerformed

    private void btnCekDataSupirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekDataSupirActionPerformed
        // Membuat dialog baru yang berisi panel PopUpDataSupir
        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Data Mobil", true);

        // Menambahkan panel PopUpDataSupir ke dalam dialog
        PopUpDataSupir dataSupir = new PopUpDataSupir(dialog);
        dataSupir.supir = this;
        dataSupir.setVisible(true);
        dialog.add(dataSupir);

        // Mengatur ukuran dan lokasi dialog
        dialog.setSize(776, 400);
        dialog.setLocationRelativeTo(null); // Agar dialog muncul di tengah
        dialog.setResizable(false); // Menonaktifkan resize
        dialog.setVisible(true); // Menampilkan dialog
    }//GEN-LAST:event_btnCekDataSupirActionPerformed

    private void btnCekDataSupir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekDataSupir1ActionPerformed
        int totalHarga = Integer.parseInt(txtTotal.getText());
        int tarifSupir = Integer.parseInt(txtTarifSupir.getText());
        
        int totalHargaUpdate = tarifSupir + totalHarga;
        txtTotalHarga.setText(String.valueOf(totalHargaUpdate));
    }//GEN-LAST:event_btnCekDataSupir1ActionPerformed

    public void itemTerpilihSupir() {
        txtIDSopir.setText(idSupir);
        txtNamaSupir.setText(namaSupir);
        txtNoTlpSupir.setText(noTlpnSupir);
        txtTarifSupir.setText(String.valueOf(tarifSupir));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private maulana.swing.ButtonAction btnBatalPembayaran;
    private maulana.swing.ButtonAction btnCekDataMobil;
    private maulana.swing.ButtonAction btnCekDataPesanan;
    private maulana.swing.ButtonAction btnCekDataSupir;
    private maulana.swing.ButtonAction btnCekDataSupir1;
    private maulana.swing.ButtonAction btnSimpan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblGambarMobil;
    private javax.swing.JLabel lblJenisMobil;
    private javax.swing.JLabel lblKapasitas;
    private javax.swing.JLabel lblMerekMobil;
    private javax.swing.JLabel lblPlatNomor;
    private javax.swing.JLabel lblStatusMobil;
    private maulana.swing.PanelRounded panelRounded1;
    private maulana.swing.PanelRounded panelRounded2;
    private maulana.swing.PanelRounded panelRounded3;
    private maulana.swing.PanelRounded panelRounded4;
    private maulana.swing.PanelRounded panelRounded5;
    private maulana.swing.PanelRounded panelRounded6;
    private maulana.swing.PanelRounded panelRounded7;
    private maulana.swing.PanelRounded panelRounded8;
    private maulana.swing.PanelRounded panelRounded9;
    private javax.swing.JRadioButton rdBtnTidak;
    private javax.swing.JRadioButton rdBtnYa;
    private maulana.swing.TextFieldFlatLaf txtDp;
    private maulana.swing.TextFieldFlatLaf txtHargaMobil;
    private maulana.swing.TextFieldFlatLaf txtIDKaryawan;
    private maulana.swing.TextFieldFlatLaf txtIDMobil;
    private maulana.swing.TextFieldFlatLaf txtIDPembayaran;
    private maulana.swing.TextFieldFlatLaf txtIDPesanan;
    private maulana.swing.TextFieldFlatLaf txtIDSopir;
    private maulana.swing.TextFieldFlatLaf txtKembali;
    private maulana.swing.TextFieldFlatLaf txtLamaSewa;
    private maulana.swing.TextFieldFlatLaf txtNamaPelanggan;
    private maulana.swing.TextFieldFlatLaf txtNamaSupir;
    private maulana.swing.TextFieldFlatLaf txtNoTlpPelanggan;
    private maulana.swing.TextFieldFlatLaf txtNoTlpSupir;
    private javax.swing.JSpinner txtTanggalPembayaran;
    private maulana.swing.TextFieldFlatLaf txtTarifSupir;
    private maulana.swing.TextFieldFlatLaf txtTotal;
    private maulana.swing.TextFieldFlatLaf txtTotalHarga;
    private maulana.swing.TextFieldFlatLaf txtUang;
    // End of variables declaration//GEN-END:variables
}
