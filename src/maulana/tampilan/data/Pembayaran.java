package maulana.tampilan.data;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import maulana.koneksi.KoneksiDB;
import maulana.tampilan.popup.PopUpDataMobilPemabayaran;
import maulana.tampilan.popup.PopUpDataPemesanan;
import maulana.tampilan.popup.PopUpDataSupir;
import raven.toast.Notifications;

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
    private DefaultTableModel tabModelPembayaran;

    public Pembayaran() {
        initComponents();
        aktif();
        autoNumber();
        dataTabelPembayaran();
        init();
        datePicker.setCloseAfterSelected(true);
        datePicker.setEditor(txtTanggalPembayaran);
    }

    private void aktif() {
        btnUbahPembayaran1.setVisible(false);
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

    private void dataTabelPembayaran() {
        Object[] baris = {
            "ID Pembayaran",
            "ID Pemesanan",
            "Nama Pelanggan",
            "Telepon Pelanggan",
            "ID Karyawan",
            "Tgl Pembayaran",
            "ID Mobil",
            "Harga Mobil",
            "Lama Sewa",
            "DP",
            "Total",
            "Supir",
            "ID Supir",
            "Nama Supir",
            "Telepon Supir",
            "Tarif Supir",
            "Total Harga",
            "Uang",
            "Kembali"
        };

        tabModelPembayaran = new DefaultTableModel(null, baris);
        tblPembayaran.setModel(tabModelPembayaran);
        String cariItem = txtCari.getText();

        try {
            String query = "SELECT * FROM pembayaran WHERE id_pembayaran LIKE '%" + cariItem + "%' OR nama_pelanggan LIKE'%" + cariItem + "%' ORDER BY id_pembayaran ASC";
            Statement statment = koneksi.createStatement();
            ResultSet hasil = statment.executeQuery(query);
            while (hasil.next()) {
                tabModelPembayaran.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6),
                    hasil.getString(7),
                    hasil.getString(8),
                    hasil.getString(9),
                    hasil.getString(10),
                    hasil.getString(11),
                    hasil.getString(12),
                    hasil.getString(13),
                    hasil.getString(14),
                    hasil.getString(15),
                    hasil.getString(16),
                    hasil.getString(17),
                    hasil.getString(18),
                    hasil.getString(19)
                });
            }
            tblPembayaran.revalidate();
            tblPembayaran.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal dipanggil");
        }
    }

    private void init() {
        txtCari.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Cari...");
        txtCari.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("maulana/icon/search.svg"));
        txtCari.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "background:$TextField.background");
        txtTanggalPembayaran.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "background:$TextField.background");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        datePicker = new raven.datetime.component.date.DatePicker();
        tabPanePembayaran = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        panelRounded1 = new maulana.swing.PanelRounded();
        txtIDPembayaran = new maulana.swing.TextFieldFlatLaf();
        panelRounded4 = new maulana.swing.PanelRounded();
        jLabel14 = new javax.swing.JLabel();
        txtIDKaryawan = new maulana.swing.TextFieldFlatLaf();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTanggalPembayaran = new javax.swing.JFormattedTextField();
        panelRounded6 = new maulana.swing.PanelRounded();
        panelRounded2 = new maulana.swing.PanelRounded();
        txtIDPesanan = new maulana.swing.TextFieldFlatLaf();
        jLabel1 = new javax.swing.JLabel();
        btnCekDataPesanan = new maulana.swing.ButtonActionFlatLaf();
        jLabel2 = new javax.swing.JLabel();
        txtNamaPelanggan = new maulana.swing.TextFieldFlatLaf();
        txtNoTlpPelanggan = new maulana.swing.TextFieldFlatLaf();
        jLabel3 = new javax.swing.JLabel();
        panelRounded3 = new maulana.swing.PanelRounded();
        txtIDMobil = new maulana.swing.TextFieldFlatLaf();
        jLabel5 = new javax.swing.JLabel();
        btnCekDataMobil = new maulana.swing.ButtonActionFlatLaf();
        jLabel6 = new javax.swing.JLabel();
        txtHargaMobil = new maulana.swing.TextFieldFlatLaf();
        txtLamaSewa = new maulana.swing.TextFieldFlatLaf();
        jLabel7 = new javax.swing.JLabel();
        txtDp = new maulana.swing.TextFieldFlatLaf();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTotal = new maulana.swing.TextFieldFlatLaf();
        panelRounded7 = new maulana.swing.PanelRounded();
        btnSimpan = new maulana.swing.ButtonActionFlatLaf();
        btnBatalPembayaran = new maulana.swing.ButtonActionFlatLaf();
        btnPembayaranBaru = new maulana.swing.ButtonActionFlatLaf();
        btnUbahPembayaran1 = new maulana.swing.ButtonActionFlatLaf();
        panelRounded5 = new maulana.swing.PanelRounded();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtTotalHarga = new maulana.swing.TextFieldFlatLaf();
        txtUang = new maulana.swing.TextFieldFlatLaf();
        txtKembali = new maulana.swing.TextFieldFlatLaf();
        jLabel33 = new javax.swing.JLabel();
        buttonAction1 = new maulana.swing.ButtonActionFlatLaf();
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
        btnCekDataSupir = new maulana.swing.ButtonActionFlatLaf();
        rdBtnYa = new javax.swing.JRadioButton();
        txtTarifSupir = new maulana.swing.TextFieldFlatLaf();
        jLabel35 = new javax.swing.JLabel();
        rdBtnTidak = new javax.swing.JRadioButton();
        btnTambahTarifSupir = new maulana.swing.ButtonActionFlatLaf();
        jPanel2 = new javax.swing.JPanel();
        btnEditPembayaran = new maulana.swing.ButtonActionFlatLaf();
        buttonHapusPembayaran = new maulana.swing.ButtonActionFlatLaf();
        txtCari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPembayaran = new maulana.swing.TabelFlatLaf();

        tabPanePembayaran.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        panelRounded1.setBorder(javax.swing.BorderFactory.createTitledBorder("ID Pembayaran"));

        txtIDPembayaran.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIDPembayaran.setEnabled(false);

        javax.swing.GroupLayout panelRounded1Layout = new javax.swing.GroupLayout(panelRounded1);
        panelRounded1.setLayout(panelRounded1Layout);
        panelRounded1Layout.setHorizontalGroup(
            panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(txtIDPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        panelRounded1Layout.setVerticalGroup(
            panelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtIDPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Tanggal");

        txtIDKaryawan.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIDKaryawan.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("ID Karyawan");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Pembayaran");

        javax.swing.GroupLayout panelRounded4Layout = new javax.swing.GroupLayout(panelRounded4);
        panelRounded4.setLayout(panelRounded4Layout);
        panelRounded4Layout.setHorizontalGroup(
            panelRounded4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 485, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTanggalPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        panelRounded4Layout.setVerticalGroup(
            panelRounded4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelRounded4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtIDKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(txtTanggalPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(panelRounded3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRounded3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtDp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap())
        );

        btnSimpan.setText("SIMPAN PEMBAYARAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatalPembayaran.setText("BATAL PEMBAYARAN");
        btnBatalPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalPembayaranActionPerformed(evt);
            }
        });

        btnPembayaranBaru.setText("PEMBAYARAN BARU");
        btnPembayaranBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPembayaranBaruActionPerformed(evt);
            }
        });

        btnUbahPembayaran1.setText("UBAH PEMBAYARAN");
        btnUbahPembayaran1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahPembayaran1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRounded7Layout = new javax.swing.GroupLayout(panelRounded7);
        panelRounded7.setLayout(panelRounded7Layout);
        panelRounded7Layout.setHorizontalGroup(
            panelRounded7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUbahPembayaran1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBatalPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPembayaranBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        panelRounded7Layout.setVerticalGroup(
            panelRounded7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRounded7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatalPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPembayaranBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUbahPembayaran1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
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

        buttonAction1.setText("HITUNG");
        buttonAction1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRounded5Layout = new javax.swing.GroupLayout(panelRounded5);
        panelRounded5.setLayout(panelRounded5Layout);
        panelRounded5Layout.setHorizontalGroup(
            panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRounded5Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonAction1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRounded5Layout.setVerticalGroup(
            panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRounded5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        btnTambahTarifSupir.setText("TAMBAH");
        btnTambahTarifSupir.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnTambahTarifSupir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahTarifSupirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRounded9Layout = new javax.swing.GroupLayout(panelRounded9);
        panelRounded9.setLayout(panelRounded9Layout);
        panelRounded9Layout.setHorizontalGroup(
            panelRounded9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRounded9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRounded9Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdBtnYa, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdBtnTidak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addComponent(btnTambahTarifSupir, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
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
                    .addComponent(btnTambahTarifSupir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout panelRounded8Layout = new javax.swing.GroupLayout(panelRounded8);
        panelRounded8.setLayout(panelRounded8Layout);
        panelRounded8Layout.setHorizontalGroup(
            panelRounded8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRounded8Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addComponent(panelRounded9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panelRounded8Layout.setVerticalGroup(
            panelRounded8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRounded8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
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
                    .addComponent(panelRounded9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGambarMobil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRounded5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRounded7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRounded8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRounded4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelRounded8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRounded5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRounded7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelRounded1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRounded6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );

        tabPanePembayaran.addTab("Pembayaran", jPanel1);

        btnEditPembayaran.setText("EDIT");
        btnEditPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPembayaranActionPerformed(evt);
            }
        });

        buttonHapusPembayaran.setText("HAPUS");
        buttonHapusPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusPembayaranActionPerformed(evt);
            }
        });

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        tblPembayaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblPembayaran);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonHapusPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1111, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonHapusPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
        );

        tabPanePembayaran.addTab("Data Pembayaran", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanePembayaran)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanePembayaran)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCekDataPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekDataPesananActionPerformed
        // Membuat dialog baru yang berisi panel PopUpDataPelanggan
        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Data Pemesanan", true);

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
        btnTambahTarifSupir.setEnabled(false);

        txtIDSopir.setText("");
        txtNamaSupir.setText("");
        txtNoTlpSupir.setText("");
        txtTarifSupir.setText("");
    }//GEN-LAST:event_rdBtnTidakActionPerformed

    private void rdBtnYaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBtnYaActionPerformed
        txtIDSopir.setEnabled(true);
        txtNamaSupir.setEnabled(true);
        txtNoTlpSupir.setEnabled(true);
        txtTarifSupir.setEnabled(true);
        btnCekDataSupir.setEnabled(true);
        btnTambahTarifSupir.setEnabled(true);
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

    private void btnTambahTarifSupirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahTarifSupirActionPerformed
        int totalHarga = Integer.parseInt(txtTotal.getText());
        int tarifSupir = Integer.parseInt(txtTarifSupir.getText());

        int totalHargaUpdate = tarifSupir + totalHarga;
        txtTotalHarga.setText(String.valueOf(totalHargaUpdate));
    }//GEN-LAST:event_btnTambahTarifSupirActionPerformed

    private void buttonAction1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction1ActionPerformed
        try {
            // Mendapatkan nilai Total Harga dan Uang dari inputan
            int totalHarga = Integer.parseInt(txtTotalHarga.getText());
            int uang = Integer.parseInt(txtUang.getText());

            // Menghitung kembalian
            int kembali = uang - totalHarga;

            // Menampilkan hasil kembalian ke txtKembali
            txtKembali.setText(String.valueOf(kembali));

            // Memastikan kembalian tidak negatif
            if (kembali < 0) {
                JOptionPane.showMessageDialog(this, "Uang tidak mencukupi untuk membayar total harga.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Harap masukkan angka yang valid pada Total Harga dan Uang.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonAction1ActionPerformed

    private void btnBatalPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalPembayaranActionPerformed
        txtIDPesanan.setText("");
        txtNamaPelanggan.setText("");
        txtNoTlpPelanggan.setText("");
        txtIDMobil.setText("");
        txtHargaMobil.setText("");
        txtLamaSewa.setText("");
        txtDp.setText("");
        txtTotal.setText("");
        lblGambarMobil.setIcon(null);
        lblMerekMobil.setText("");
        lblJenisMobil.setText("");
        lblPlatNomor.setText("");
        lblKapasitas.setText("");
        lblStatusMobil.setText("");
        buttonGroup1.clearSelection();
        txtIDSopir.setText("");
        txtNamaSupir.setText("");
        txtNoTlpSupir.setText("");
        txtTarifSupir.setText("");
        txtTotalHarga.setText("");
        txtUang.setText("");
        txtKembali.setText("");

    }//GEN-LAST:event_btnBatalPembayaranActionPerformed

    private void btnPembayaranBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPembayaranBaruActionPerformed
        autoNumber();
        txtIDPesanan.setText("");
        txtNamaPelanggan.setText("");
        txtNoTlpPelanggan.setText("");
        txtIDMobil.setText("");
        txtHargaMobil.setText("");
        txtLamaSewa.setText("");
        txtDp.setText("");
        txtTotal.setText("");
        lblGambarMobil.setIcon(null);
        lblMerekMobil.setText("----------------");
        lblJenisMobil.setText("----------------");
        lblPlatNomor.setText("----------------");
        lblKapasitas.setText("----------------");
        lblStatusMobil.setText("----------------");
        buttonGroup1.clearSelection();
        txtIDSopir.setText("");
        txtNamaSupir.setText("");
        txtNoTlpSupir.setText("");
        txtTarifSupir.setText("");
        txtTotalHarga.setText("");
        txtUang.setText("");
        txtKembali.setText("");
    }//GEN-LAST:event_btnPembayaranBaruActionPerformed

    public void itemTerpilihSupir() {
        txtIDSopir.setText(idSupir);
        txtNamaSupir.setText(namaSupir);
        txtNoTlpSupir.setText(noTlpnSupir);
        txtTarifSupir.setText(String.valueOf(tarifSupir));
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        rdBtnYa.setActionCommand("Dengan supir");
        rdBtnTidak.setActionCommand("Tanpa supir");
        String query = "INSERT INTO pembayaran ("
                + "id_pembayaran, "
                + "id_pemesanan, "
                + "nama_pelanggan, "
                + "no_telepon_pelanggan, "
                + "id_karyawan, "
                + "tanggal_pembayaran, "
                + "id_mobil, "
                + "harga_mobil, "
                + "lama_sewa, "
                + "dp, "
                + "total, "
                + "supir, "
                + "id_supir, "
                + "nama_supir, "
                + "no_telepon_supir, "
                + "tarif_supir, "
                + "total_harga, "
                + "uang, "
                + "kembali"
                + ") "
                + "VALUES (?, ?, ?, ?, ?, STR_TO_DATE(?, '%d/%m/%Y'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Ambil data dari JTextField
            String idPembayaran = txtIDPembayaran.getText();
            String idPemesanan = txtIDPesanan.getText();
            String namaPelanggan = txtNamaPelanggan.getText();
            String noTelpPelanggan = txtNoTlpPelanggan.getText();
            String idKaryawan = txtIDKaryawan.getText();
            String tglPembayaran = txtTanggalPembayaran.getText();
            String idMobil = txtIDMobil.getText();
            String hargaMobil = txtHargaMobil.getText();
            String lamaSewa = txtLamaSewa.getText();
            String dp = txtDp.getText();
            String total = txtTotal.getText();
            String supir = buttonGroup1.getSelection().getActionCommand();
            String idSupir = txtIDSopir.getText();
            if (idSupir.isEmpty()) {
                idSupir = null;  // Kirimkan null jika tidak ada supir yang dipilih
            }
            String namaSupir = txtNamaSupir.getText();
            String noTeleponSupir = txtNoTlpSupir.getText();
            int tarifSupir = 0;
            if (!txtTarifSupir.getText().isEmpty()) {
                tarifSupir = Integer.parseInt(txtTarifSupir.getText());
            }
            String totalHarga = txtTotalHarga.getText();
            String uang = txtUang.getText();
            String kembali = txtKembali.getText();

            // Siapkan PreparedStatement untuk memasukkan data ke dalam tabel pemesanan
            PreparedStatement statement = koneksi.prepareStatement(query);

            // Set nilai parameter untuk query
            statement.setInt(1, Integer.parseInt(idPembayaran));
            statement.setInt(2, Integer.parseInt(idPemesanan));
            statement.setString(3, namaPelanggan);
            statement.setString(4, noTelpPelanggan);
            statement.setInt(5, Integer.parseInt(idKaryawan));
            statement.setString(6, tglPembayaran);
            statement.setString(7, idMobil);
            statement.setInt(8, Integer.parseInt(hargaMobil));
            statement.setInt(9, Integer.parseInt(lamaSewa));
            statement.setInt(10, Integer.parseInt(dp));
            statement.setInt(11, Integer.parseInt(total));
            statement.setString(12, supir);
            statement.setString(13, (idSupir == null || idSupir.isEmpty()) ? null : idSupir);
            statement.setString(14, namaSupir);
            statement.setString(15, noTeleponSupir);
            statement.setInt(16, tarifSupir);
            statement.setInt(17, Integer.parseInt(totalHarga));
            statement.setInt(18, Integer.parseInt(uang));
            statement.setInt(19, Integer.parseInt(kembali));

            statement.executeUpdate();
            statement.close();
            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data pembayaran berhasil disimpan");
            dataTabelPembayaran();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Format angka salah: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void buttonHapusPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusPembayaranActionPerformed
        int selectedRow = tblPembayaran.getSelectedRow();

        // Periksa apakah ada baris yang dipilih
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Silakan pilih data pembayaran yang ingin dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Ambil ID Pembayaran yang dipilih
        String idPembayaran = tblPembayaran.getValueAt(selectedRow, 0).toString();

        // Konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data pembayaran dengan ID: " + idPembayaran + "?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Hapus data dari database
                String query = "DELETE FROM pembayaran WHERE id_pembayaran = '" + idPembayaran + "'";
                Statement statement = koneksi.createStatement();
                statement.executeUpdate(query);

                // Hapus baris dari tabel
                ((DefaultTableModel) tblPembayaran.getModel()).removeRow(selectedRow);

                // Tampilkan notifikasi sukses
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data pembayarn berhasil dihapus");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Data gagal dihapus: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_buttonHapusPembayaranActionPerformed

    private void btnEditPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPembayaranActionPerformed
        rdBtnYa.setActionCommand("Dengan supir");
        rdBtnTidak.setActionCommand("Tanpa supir");
        // Pastikan pengguna memilih baris yang akan di-edit
        int selectedRow = tblPembayaran.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin di-edit terlebih dahulu!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Ambil data dari baris yang dipilih
        String idPembayaran = tblPembayaran.getValueAt(selectedRow, 0).toString();
        String idPemesanan = tblPembayaran.getValueAt(selectedRow, 1).toString();
        String namaPelanggan = tblPembayaran.getValueAt(selectedRow, 2).toString();
        String noTelpPelanggan = tblPembayaran.getValueAt(selectedRow, 3).toString();
        String idKaryawan = tblPembayaran.getValueAt(selectedRow, 4).toString();
        String tanggalPembayaran = tblPembayaran.getValueAt(selectedRow, 5).toString();
        String idMobil = tblPembayaran.getValueAt(selectedRow, 6).toString();
        String hargaMobil = tblPembayaran.getValueAt(selectedRow, 7).toString();
        String lamaSewa = tblPembayaran.getValueAt(selectedRow, 8).toString();
        String dp = tblPembayaran.getValueAt(selectedRow, 9).toString();
        String total = tblPembayaran.getValueAt(selectedRow, 10).toString();
        String supir = tblPembayaran.getValueAt(selectedRow, 11).toString();
        Object value = tblPembayaran.getValueAt(selectedRow, 12);
        String idSupir = (value != null) ? value.toString() : "";
        String namaSupir = tblPembayaran.getValueAt(selectedRow, 13).toString();
        String noTlpSupir = tblPembayaran.getValueAt(selectedRow, 14).toString();
        String tarifSupi = tblPembayaran.getValueAt(selectedRow, 15).toString();
        String totalHarga = tblPembayaran.getValueAt(selectedRow, 16).toString();
        String uang = tblPembayaran.getValueAt(selectedRow, 17).toString();
        String kembali = tblPembayaran.getValueAt(selectedRow, 18).toString();

        // Tampilkan panel pesanan
        tabPanePembayaran.setSelectedIndex(0); // Asumsi tab pesanan ada di index 1        
        btnUbahPembayaran1.setVisible(true);

        // Perbarui komponen input di tampilan pembayaran
        txtIDPembayaran.setText(idPembayaran);
        txtIDPesanan.setText(idPemesanan);
        txtNamaPelanggan.setText(namaPelanggan);
        txtNoTlpPelanggan.setText(noTelpPelanggan);
        txtIDKaryawan.setText(idKaryawan);
        // Konversi format tanggal dari yyyy-MM-dd menjadi dd/MM/yyyy
        try {
            // Buat SimpleDateFormat dengan format input yang sesuai (yyyy-MM-dd)
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Parsing tanggal yang diambil dari tabel menjadi objek Date
            Date tanggal = inputFormat.parse(tanggalPembayaran);

            // Buat SimpleDateFormat dengan format output yang diinginkan (dd/MM/yyyy)
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

            // Format tanggal ke dalam format yang diinginkan
            String formattedDate = outputFormat.format(tanggal);

            // Tampilkan tanggal yang sudah diformat ke dalam txtTanggalPemesanan
            txtTanggalPembayaran.setText(formattedDate);
        } catch (ParseException e) {
            // Tangani kesalahan jika format tanggal tidak valid
            e.printStackTrace();
        }
        txtIDMobil.setText(idMobil);
        txtHargaMobil.setText(hargaMobil);
        txtLamaSewa.setText(lamaSewa);
        txtDp.setText(dp);
        txtTotal.setText(String.valueOf(total));
        if (supir.equals("Dengan supir")) {
            rdBtnYa.setSelected(true);
        } else if (supir.equals("Tanpa supir")) {
            rdBtnTidak.setSelected(true);
        }
        txtIDSopir.setText(idSupir);
        txtNamaSupir.setText(namaSupir);
        txtNoTlpSupir.setText(noTlpSupir);
        txtTarifSupir.setText(String.valueOf(tarifSupi));
        txtTotalHarga.setText(String.valueOf(totalHarga));
        txtUang.setText(String.valueOf(uang));
        txtKembali.setText(String.valueOf(kembali));

        // Tombol simpan perubahan
        btnUbahPembayaran1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ambil data yang telah diedit dari komponen input
                // Ambil data dari JTextField
                String newIdPembayaran = txtIDPembayaran.getText();
                String newIdPemesanan = txtIDPesanan.getText();
                String newNamaPelanggan = txtNamaPelanggan.getText();
                String newNoTelpPelanggan = txtNoTlpPelanggan.getText();
                String newIdKaryawan = txtIDKaryawan.getText();
                String newTglPembayaran = txtTanggalPembayaran.getText();
                String newIdMobil = txtIDMobil.getText();
                String newHargaMobil = txtHargaMobil.getText();
                String newLamaSewa = txtLamaSewa.getText();
                String newDp = txtDp.getText();
                String newTotal = txtTotal.getText();
                String newSupir = buttonGroup1.getSelection().getActionCommand();
                String newIdSupir = txtIDSopir.getText();
                if (newIdSupir.isEmpty()) {
                    newIdSupir = null;  // Kirimkan null jika tidak ada supir yang dipilih
                }
                String newNamaSupir = txtNamaSupir.getText();
                String newNoTeleponSupir = txtNoTlpSupir.getText();
                int newTarifSupir = 0;
                if (!txtTarifSupir.getText().isEmpty()) {
                    newTarifSupir = Integer.parseInt(txtTarifSupir.getText());
                }
                String newTotalHarga = txtTotalHarga.getText();
                String newUang = txtUang.getText();
                String newKembali = txtKembali.getText();

                try {
                    // Simpan data yang telah diedit ke database
                    String query = "UPDATE pembayaran SET "
                            + "id_pemesanan = ?, "
                            + "nama_pelanggan = ?, "
                            + "no_telepon_pelanggan = ?, "
                            + "id_karyawan = ?, "
                            + "tanggal_pembayaran = STR_TO_DATE(?, '%d/%m/%Y'), "
                            + "id_mobil = ?, "
                            + "harga_mobil = ?, "
                            + "lama_sewa = ?, "
                            + "dp = ?, "
                            + "total = ?, "
                            + "supir = ?, "
                            + "id_supir = ?, "
                            + "nama_supir = ?, "
                            + "no_telepon_supir = ?, "
                            + "tarif_supir = ?, "
                            + "total_harga = ?, "
                            + "uang = ?, "
                            + "kembali = ? "
                            + "WHERE id_pembayaran = ?";
                    PreparedStatement preparedStatement = koneksi.prepareStatement(query);
                    preparedStatement.setInt(1, Integer.parseInt(newIdPemesanan));
                    preparedStatement.setString(2, newNamaPelanggan);
                    preparedStatement.setString(3, newNoTelpPelanggan);
                    preparedStatement.setInt(4, Integer.parseInt(newIdKaryawan));
                    preparedStatement.setString(5, newTglPembayaran);
                    preparedStatement.setString(6, newIdMobil);
                    preparedStatement.setInt(7, Integer.parseInt(newHargaMobil));
                    preparedStatement.setInt(8, Integer.parseInt(newLamaSewa));
                    preparedStatement.setInt(9, Integer.parseInt(newDp));
                    preparedStatement.setInt(10, Integer.parseInt(newTotal));
                    preparedStatement.setString(11, newSupir);
                    preparedStatement.setString(12, (newIdSupir == null || newIdSupir.isEmpty()) ? null : newIdSupir);
                    preparedStatement.setString(13, newNamaSupir);
                    preparedStatement.setString(14, newNoTeleponSupir);
                    preparedStatement.setInt(15, newTarifSupir);
                    preparedStatement.setInt(16, Integer.parseInt(newTotalHarga));
                    preparedStatement.setInt(17, Integer.parseInt(newUang));
                    preparedStatement.setInt(18, Integer.parseInt(newKembali));
                    preparedStatement.setInt(19, Integer.parseInt(newIdPembayaran));
                    preparedStatement.executeUpdate();

                    // Perbarui data yang telah diedit di tabel
                    DefaultTableModel model = (DefaultTableModel) tblPembayaran.getModel();
                    model.setValueAt(newIdPemesanan, selectedRow, 1);
                    model.setValueAt(newNamaPelanggan, selectedRow, 2);
                    model.setValueAt(newNoTelpPelanggan, selectedRow, 3);
                    model.setValueAt(newIdKaryawan, selectedRow, 4);
                    model.setValueAt(newTglPembayaran, selectedRow, 5);
                    model.setValueAt(newIdMobil, selectedRow, 6);
                    model.setValueAt(newHargaMobil, selectedRow, 7);
                    model.setValueAt(newLamaSewa, selectedRow, 8);
                    model.setValueAt(newDp, selectedRow, 9);
                    model.setValueAt(newTotal, selectedRow, 10);
                    model.setValueAt(newSupir, selectedRow, 11);
                    model.setValueAt(newIdSupir, selectedRow, 12);
                    model.setValueAt(newNamaSupir, selectedRow, 13);
                    model.setValueAt(newNoTeleponSupir, selectedRow, 14);
                    model.setValueAt(newTarifSupir, selectedRow, 15);
                    model.setValueAt(newTotalHarga, selectedRow, 16);
                    model.setValueAt(newUang, selectedRow, 17);
                    model.setValueAt(newKembali, selectedRow, 18);

                    Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data pembayaran berhasil diperbarui");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
    }//GEN-LAST:event_btnEditPembayaranActionPerformed

    private void btnUbahPembayaran1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahPembayaran1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUbahPembayaran1ActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        dataTabelPembayaran();
    }//GEN-LAST:event_txtCariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private maulana.swing.ButtonActionFlatLaf btnBatalPembayaran;
    private maulana.swing.ButtonActionFlatLaf btnCekDataMobil;
    private maulana.swing.ButtonActionFlatLaf btnCekDataPesanan;
    private maulana.swing.ButtonActionFlatLaf btnCekDataSupir;
    private maulana.swing.ButtonActionFlatLaf btnEditPembayaran;
    private maulana.swing.ButtonActionFlatLaf btnPembayaranBaru;
    private maulana.swing.ButtonActionFlatLaf btnSimpan;
    private maulana.swing.ButtonActionFlatLaf btnTambahTarifSupir;
    private maulana.swing.ButtonActionFlatLaf btnUbahPembayaran1;
    private maulana.swing.ButtonActionFlatLaf buttonAction1;
    private javax.swing.ButtonGroup buttonGroup1;
    private maulana.swing.ButtonActionFlatLaf buttonHapusPembayaran;
    private raven.datetime.component.date.DatePicker datePicker;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JTabbedPane tabPanePembayaran;
    private maulana.swing.TabelFlatLaf tblPembayaran;
    private javax.swing.JTextField txtCari;
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
    private javax.swing.JFormattedTextField txtTanggalPembayaran;
    private maulana.swing.TextFieldFlatLaf txtTarifSupir;
    private maulana.swing.TextFieldFlatLaf txtTotal;
    private maulana.swing.TextFieldFlatLaf txtTotalHarga;
    private maulana.swing.TextFieldFlatLaf txtUang;
    // End of variables declaration//GEN-END:variables
}
