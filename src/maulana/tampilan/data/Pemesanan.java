package maulana.tampilan.data;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Image;
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
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import maulana.koneksi.KoneksiDB;
import maulana.tampilan.popup.PopUpDataMobilPemesanan;
import maulana.tampilan.popup.PopUpDataPelanggan;
import raven.toast.Notifications;

public class Pemesanan extends javax.swing.JPanel {

    public void setLblGambar(ImageIcon imageIcon) {
        lblGambar.setIcon(imageIcon);
    }

    public String nik, noSim, namaPelanggan, noTelepon, alamatPelanggan;
    public String idMobil, merek, jenis, platNomor, kapasitas, tarif, status;
    public ImageIcon gambar;  // Ubah tipe data gambar menjadi ImageIcon
    private Connection koneksi = new KoneksiDB().connect();
    private DefaultTableModel tabmodelPemesanan;
    private DefaultTableModel tabModelPesanan;

    public Pemesanan() {
        initComponents();
        init();
        aktif();
        dataTabel();
        autoNumber();
    }

    public void setIdKaryawan(String idKaryawan) {
        if (idKaryawan != null) {
            txtIDKaryawan.setText(idKaryawan);
        } else {
            System.out.println("ID Karyawan kosong di Pemesanan!");
        }
    }

    public String getIdKaryawan() {
        return txtIDKaryawan.getText();
    }

    public void itemTerpilihPelanggan() {
        txtNik.setText(nik);
        txtNamaPelanggan.setText(namaPelanggan);
        txtNoTlpnPelanggan.setText(noTelepon);
    }

    public void itemTerpilihMobil() {
        txtIDMobil.setText(idMobil);
        txtHargaMobil.setText(tarif);
        lblMerekMobil.setText(merek);
        lblJensiMobil.setText(jenis);
        lblPlatNomor.setText(platNomor);
        lblKapasitas.setText(kapasitas + " Orang");
        lblStatus.setText(status);
    }

    protected void aktif() {
        txtTanggal.setEditor(new JSpinner.DateEditor(txtTanggal, "yyyy/mm/dd"));
    }

    private void autoNumber() {
        try {
            String sql = "SELECT id_pemesanan FROM pemesanan ORDER BY id_pemesanan DESC LIMIT 1"; // Mengambil ID terakhir
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Asumsikan default ID jika tidak ada entri di tabel
            String nextID = "2400001";

            if (rs.next()) {
                String id_pesanan = rs.getString("id_pemesanan").substring(2); // Mengambil ID tanpa awalan "MB"
                int Angka = Integer.parseInt(id_pesanan) + 1; // Menaikkan angka

                // Menentukan jumlah nol di depan berdasarkan nilai Angka
                String Nol = String.format("%05d", Angka); // Membuat format string "000", "00", "0", atau "" sesuai dengan nilai Angka
                nextID = "24" + Nol; // Membuat ID baru
            }

            // Mengatur ID baru ke form
            txtIDPesanan.setText(nextID);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Auto nomor gagal: " + e.getMessage());
        }
    }

    private void dataTabel() {
        Object[] baris = {"ID Pesanan", "Nama Pelanggan", "NIK", "No. Telepon", "ID Karyawan", "Tgl. Pesanan", "ID Mobil", "Harga Mobil", "Lama Sewa", "DP", "Total"};
        tabmodelPemesanan = new DefaultTableModel(null, baris);
        String cariItem = txtCari.getText();

        try {
            String query = "SELECT * FROM pemesanan WHERE id_pemesanan LIKE '%" + cariItem + "%' OR nama_pelanggan LIKE'%" + cariItem + "%' ORDER BY id_pemesanan ASC";
            Statement statment = koneksi.createStatement();
            ResultSet hasil = statment.executeQuery(query);
            while (hasil.next()) {
                tabmodelPemesanan.addRow(new Object[]{
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
                    hasil.getString(11)
                });
            }
            tblPemesanan.setModel(tabmodelPemesanan);
            TableColumn kolom;
            kolom = tblPemesanan.getColumnModel().getColumn(0);
            kolom.setMaxWidth(100);
            kolom = tblPemesanan.getColumnModel().getColumn(1);
            kolom.setPreferredWidth(200);
            kolom = tblPemesanan.getColumnModel().getColumn(2);
            kolom.setPreferredWidth(200);
            kolom = tblPemesanan.getColumnModel().getColumn(3);
            kolom.setPreferredWidth(150);
            kolom = tblPemesanan.getColumnModel().getColumn(4);
            kolom.setPreferredWidth(100);
            kolom = tblPemesanan.getColumnModel().getColumn(5);
            kolom.setPreferredWidth(100);
            kolom = tblPemesanan.getColumnModel().getColumn(6);
            kolom.setPreferredWidth(100);
            kolom = tblPemesanan.getColumnModel().getColumn(7);
            kolom.setPreferredWidth(100);
            kolom = tblPemesanan.getColumnModel().getColumn(8);
            kolom.setPreferredWidth(50);
            kolom = tblPemesanan.getColumnModel().getColumn(9);
            kolom.setPreferredWidth(100);
            kolom = tblPemesanan.getColumnModel().getColumn(10);
            kolom.setPreferredWidth(100);
            tblPemesanan.revalidate();
            tblPemesanan.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal dipanggil");
        }
    }

    private void init() {
        panel1.putClientProperty(FlatClientProperties.STYLE, "arc:25;");
        panel2.putClientProperty(FlatClientProperties.STYLE, "arc:25;");
        panel3.putClientProperty(FlatClientProperties.STYLE, "arc:25;");
        panel4.putClientProperty(FlatClientProperties.STYLE, "arc:25;");
        panel5.putClientProperty(FlatClientProperties.STYLE, "arc:25;");
        panelIDPesanan.putClientProperty(FlatClientProperties.STYLE, "arc:25;");
        txtCari.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Cari...");
        txtCari.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("maulana/icon/search.svg"));
        txtCari.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
                + "background:$TextField.background");
        txtIDPesanan.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,10,5,20;"
                + "background:$Panel.background");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPane = new javax.swing.JTabbedPane();
        panelPemesanan = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JSpinner();
        txtIDKaryawan = new maulana.swing.TextFieldFlatLaf();
        panel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCekDataPelanggan = new javax.swing.JButton();
        txtNamaPelanggan = new maulana.swing.TextFieldFlatLaf();
        txtNik = new maulana.swing.TextFieldFlatLaf();
        txtNoTlpnPelanggan = new maulana.swing.TextFieldFlatLaf();
        panel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblMerekMobil = new javax.swing.JLabel();
        lblJensiMobil = new javax.swing.JLabel();
        lblPlatNomor = new javax.swing.JLabel();
        lblKapasitas = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblGambar = new javax.swing.JLabel();
        panel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panelIDPesanan = new javax.swing.JPanel();
        txtIDPesanan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnCekDataMobil = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtIDMobil = new maulana.swing.TextFieldFlatLaf();
        txtHargaMobil = new maulana.swing.TextFieldFlatLaf();
        txtLama = new maulana.swing.TextFieldFlatLaf();
        txtDp = new maulana.swing.TextFieldFlatLaf();
        panel5 = new javax.swing.JPanel();
        btnSimpanPesanan = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtTotal = new maulana.swing.TextFieldFlatLaf();
        jPanel2 = new javax.swing.JPanel();
        txtCari = new javax.swing.JTextField();
        btnUbah = new maulana.swing.ButtonAction();
        btnHapus = new maulana.swing.ButtonAction();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPemesanan = new maulana.swing.TabelFlatLaf();

        tabPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabPane.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        panel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("ID Karyawan :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tanggal :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Pemesanan");

        txtTanggal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTanggal.setModel(new javax.swing.SpinnerDateModel());
        txtTanggal.setBorder(null);
        txtTanggal.setEnabled(false);
        txtTanggal.setOpaque(true);

        txtIDKaryawan.setEnabled(false);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        panel2.setBackground(new java.awt.Color(51, 51, 51));
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Form Pelanggan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("NIK Pelanggan");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("No.Telepon");

        btnCekDataPelanggan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCekDataPelanggan.setText("CEK");
        btnCekDataPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekDataPelangganActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addComponent(txtNik, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCekDataPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNamaPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNoTlpnPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCekDataPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNik, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoTlpnPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        panel3.setBackground(new java.awt.Color(51, 51, 51));
        panel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Info Mobil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Merek Mobil");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Jenis Mobil");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Plat Nomor");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Kapsitas");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Status");

        lblMerekMobil.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMerekMobil.setText("------------------");

        lblJensiMobil.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblJensiMobil.setText("------------------");

        lblPlatNomor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPlatNomor.setText("------------------");

        lblKapasitas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblKapasitas.setText("------------------");

        lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblStatus.setText("------------------");

        lblGambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGambar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMerekMobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblJensiMobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPlatNomor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblKapasitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblGambar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMerekMobil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblJensiMobil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPlatNomor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblKapasitas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStatus)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel4.setBackground(new java.awt.Color(51, 51, 51));
        panel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Form Pesanan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("ID Mobil");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Harga / hari");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Lama");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("DP");

        panelIDPesanan.setBackground(new java.awt.Color(51, 51, 51));
        panelIDPesanan.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtIDPesanan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIDPesanan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIDPesanan.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("ID Pemesanan");

        javax.swing.GroupLayout panelIDPesananLayout = new javax.swing.GroupLayout(panelIDPesanan);
        panelIDPesanan.setLayout(panelIDPesananLayout);
        panelIDPesananLayout.setHorizontalGroup(
            panelIDPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIDPesananLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtIDPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelIDPesananLayout.setVerticalGroup(
            panelIDPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIDPesananLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelIDPesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        btnCekDataMobil.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCekDataMobil.setText("CEK");
        btnCekDataMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekDataMobilActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Hari");

        txtDp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDpKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelIDPesanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addComponent(txtLama, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                .addComponent(txtIDMobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCekDataMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtHargaMobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelIDPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCekDataMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        panel5.setBackground(new java.awt.Color(51, 51, 51));

        btnSimpanPesanan.setText("SIMPAN PESANAN");
        btnSimpanPesanan.setToolTipText("");
        btnSimpanPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanPesananActionPerformed(evt);
            }
        });

        jButton5.setText("BATALKAN PESANAN");
        jButton5.setToolTipText("");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Total");

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 558, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSimpanPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSimpanPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPemesananLayout = new javax.swing.GroupLayout(panelPemesanan);
        panelPemesanan.setLayout(panelPemesananLayout);
        panelPemesananLayout.setHorizontalGroup(
            panelPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPemesananLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelPemesananLayout.createSequentialGroup()
                        .addGroup(panelPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        panelPemesananLayout.setVerticalGroup(
            panelPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPemesananLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPemesananLayout.createSequentialGroup()
                        .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        tabPane.addTab("Pemesanan", panelPemesanan);

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        btnUbah.setText("EDIT");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        tblPemesanan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPemesanan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        tabPane.addTab("Lihat Pesanan", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        dataTabel();
    }//GEN-LAST:event_txtCariKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Opsional: Mengosongkan JTextField (form input)
        txtNik.setText("");
        txtNamaPelanggan.setText("");
        txtNoTlpnPelanggan.setText("");
        txtIDMobil.setText("");
        txtHargaMobil.setText("");
        txtLama.setText("");
        txtDp.setText("");
        txtTotal.setText("");
        lblGambar.setIcon(null);
        lblMerekMobil.setText("------------------");
        lblJensiMobil.setText("------------------");
        lblPlatNomor.setText("------------------");
        lblKapasitas.setText("------------------");
        lblStatus.setText("------------------");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnSimpanPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanPesananActionPerformed
        String query = "INSERT INTO pemesanan (id_pemesanan, nama_pelanggan, nik, notlpn_pelanggan, id_karyawan, tanggal_pemesanan, id_mobil, harga, lama_sewa, dp, total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Ambil data dari JTextField
            String idPemesanan = txtIDPesanan.getText();  // ID Pemesanan
            String namaPelanggan = txtNamaPelanggan.getText();     // Nama Pelanggan
            String nik = txtNik.getText();                // NIK
            String noTelpPelanggan = txtNoTlpnPelanggan.getText();          // No. Telepon
            String idKaryawan = txtIDKaryawan.getText();  // ID Karyawan           
            // Ambil tanggal dari JSpinner
            java.util.Date tanggal = (java.util.Date) txtTanggal.getValue(); // Ambil nilai dari JSpinner
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd"); // Format tanggal yang diinginkan
            String tanggalPemesanan = sdf.format(tanggal);  // Ubah tanggal menjadi string dalam format "yyyy-MM-dd"
            String idMobil = txtIDMobil.getText();
            String hargaMobil = txtHargaMobil.getText();
            String lamaSewa = txtLama.getText();
            String dp = txtDp.getText();
            String totalHarga = txtTotal.getText();

            // Siapkan PreparedStatement untuk memasukkan data ke dalam tabel pemesanan
            PreparedStatement statement = koneksi.prepareStatement(query);

            // Set nilai parameter untuk query
            statement.setInt(1, Integer.parseInt(idPemesanan));       // ID Pemesanan
            statement.setString(2, namaPelanggan);     // Nama Pelanggan
            statement.setString(3, nik);               // NIK
            statement.setString(4, noTelpPelanggan);   // No. Telepon
            statement.setInt(5, Integer.parseInt(idKaryawan));        // ID Karyawan
            statement.setString(6, tanggalPemesanan);  // Tanggal Pemesanan
            statement.setString(7, idMobil);
            statement.setInt(8, Integer.parseInt(hargaMobil));
            statement.setInt(9, Integer.parseInt(lamaSewa));
            statement.setInt(10, Integer.parseInt(dp));
            statement.setInt(11, Integer.parseInt(totalHarga));

            statement.executeUpdate();
            statement.close();
            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data pemesanan berhasil disimpan");
            dataTabel();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Format angka salah: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanPesananActionPerformed

    private void btnCekDataMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekDataMobilActionPerformed
        // Membuat dialog baru yang berisi panel PopUpDataPelanggan
        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Data Mobil", true);

        // Menambahkan panel PopUpDataPelanggan ke dalam dialog
        PopUpDataMobilPemesanan dataMobil = new PopUpDataMobilPemesanan(dialog);
        dataMobil.mobilPemesanan = this;
        dataMobil.setVisible(true);
        dialog.add(dataMobil);

        // Mengatur ukuran dan lokasi dialog
        dialog.setSize(776, 400);
        dialog.setLocationRelativeTo(null); // Agar dialog muncul di tengah
        dialog.setResizable(false); // Menonaktifkan resize
        dialog.setVisible(true); // Menampilkan dialog
    }//GEN-LAST:event_btnCekDataMobilActionPerformed

    private void btnCekDataPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekDataPelangganActionPerformed
        // Membuat dialog baru yang berisi panel PopUpDataPelanggan
        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Data Pelanggan", true);

        // Menambahkan panel PopUpDataPelanggan ke dalam dialog
        PopUpDataPelanggan dataPelanggan = new PopUpDataPelanggan(dialog);
        dataPelanggan.pelanggan = this;        
        dialog.add(dataPelanggan);

        // Mengatur ukuran dan lokasi dialog
        dialog.setSize(776, 400);
        dialog.setLocationRelativeTo(null); // Agar dialog muncul di tengah
        dialog.setResizable(false); // Menonaktifkan resize
        dialog.setVisible(true); // Menampilkan dialog
    }//GEN-LAST:event_btnCekDataPelangganActionPerformed

    private void txtDpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDpKeyReleased
        int harga = Integer.parseInt(txtHargaMobil.getText());
        int lamaSewa = Integer.parseInt(txtLama.getText());
        int dp = Integer.parseInt(txtDp.getText());
        int total = (harga * lamaSewa) - dp;
        txtTotal.setText(String.valueOf(total));
    }//GEN-LAST:event_txtDpKeyReleased

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int selectedRow = tblPemesanan.getSelectedRow();

        // Periksa apakah ada baris yang dipilih
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Silakan pilih data pesanan yang ingin dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Ambil ID Pesanan yang dipilih
        String idMobil = tblPemesanan.getValueAt(selectedRow, 0).toString();

        // Konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus Pesanan dengan ID: " + idMobil + "?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Hapus data dari database
                String query = "DELETE FROM pemesanan WHERE id_pemesanan = '" + idMobil + "'";
                Statement statement = koneksi.createStatement();
                statement.executeUpdate(query);

                // Hapus baris dari tabel
                ((DefaultTableModel) tblPemesanan.getModel()).removeRow(selectedRow);

                // Tampilkan notifikasi sukses
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data pesanan berhasil dihapus");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Data gagal dihapus: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // Pastikan pengguna memilih baris yang akan di-edit
        int selectedRow = tblPemesanan.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin di-edit terlebih dahulu!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Ambil data dari baris yang dipilih
        String idPemesanan = tblPemesanan.getValueAt(selectedRow, 0).toString();
        String namaPelanggan = tblPemesanan.getValueAt(selectedRow, 1).toString();
        String nik = tblPemesanan.getValueAt(selectedRow, 2).toString();
        String noTelpPelanggan = tblPemesanan.getValueAt(selectedRow, 3).toString();
        String idKaryawan = tblPemesanan.getValueAt(selectedRow, 4).toString();
        String tanggalPemesanan = tblPemesanan.getValueAt(selectedRow, 5).toString();
        String idMobil = tblPemesanan.getValueAt(selectedRow, 6).toString();
        String harga = tblPemesanan.getValueAt(selectedRow, 7).toString();
        String lamaSewa = tblPemesanan.getValueAt(selectedRow, 8).toString();
        String dp = tblPemesanan.getValueAt(selectedRow, 9).toString();
        String total = tblPemesanan.getValueAt(selectedRow, 10).toString();

        // Tampilkan panel pesanan
        tabPane.setSelectedIndex(0); // Asumsi tab pesanan ada di index 1        

        // Perbarui komponen input di tampilan pesanan
        txtIDPesanan.setText(idPemesanan);
        txtNamaPelanggan.setText(namaPelanggan);
        txtNik.setText(nik);
        txtNoTlpnPelanggan.setText(noTelpPelanggan);
        txtIDKaryawan.setText(idKaryawan);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parsedDate = sdf.parse(tanggalPemesanan); // Mengonversi string tanggal ke objek Date
            txtTanggal.setValue(parsedDate); // Mengatur tanggal di JSpinner
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtIDMobil.setText(idMobil);
        txtHargaMobil.setText(harga);
        txtLama.setText(lamaSewa);
        txtDp.setText(dp);
        txtTotal.setText(total);

// Tombol simpan perubahan
        btnSimpanPesanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ambil data yang telah diedit dari komponen input
                String newID = txtIDPesanan.getText();
                String newNamaPelanggan = txtNamaPelanggan.getText();
                String newNik = txtNik.getText();
                String newNoTelp = txtNoTlpnPelanggan.getText();
                String newIDKaryawan = txtIDKaryawan.getText();
                Date newTanggalPemesanan = (Date) txtTanggal.getValue(); // txtTanggal adalah JSpinner
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String newTanggalPemesananStr = sdf.format(newTanggalPemesanan); // Mengonversi tanggal ke string dengan format yang diinginkan
                String newIDMobil = txtIDMobil.getText();
                String newHarga = txtHargaMobil.getText();
                String newLamaSewa = txtLama.getText();
                String newDp = txtDp.getText();
                String newTotal = txtTotal.getText();

                try {
                    // Simpan data yang telah diedit ke database
                    String query = "UPDATE pemesanan SET nama_pelanggan = ?, nik = ?, notlpn_pelanggan = ?, id_karyawan = ?, tanggal_pemesanan = ?, id_mobil = ?, harga = ?, lama_sewa = ?, dp = ?, total = ? WHERE id_pemesanan = ?";
                    PreparedStatement preparedStatement = koneksi.prepareStatement(query);
                    preparedStatement.setString(1, newNamaPelanggan);
                    preparedStatement.setString(2, newNik);
                    preparedStatement.setString(3, newNoTelp);
                    preparedStatement.setString(4, newIDKaryawan);
                    preparedStatement.setString(5, newTanggalPemesananStr);
                    preparedStatement.setString(6, newIDMobil);
                    preparedStatement.setString(7, newHarga);
                    preparedStatement.setString(8, newLamaSewa);
                    preparedStatement.setString(9, newDp);
                    preparedStatement.setString(10, newTotal);
                    preparedStatement.setString(11, newID);
                    preparedStatement.executeUpdate();

                    // Perbarui data yang telah diedit di tabel
                    DefaultTableModel model = (DefaultTableModel) tblPemesanan.getModel();
                    model.setValueAt(newNamaPelanggan, selectedRow, 1);
                    model.setValueAt(newNik, selectedRow, 2);
                    model.setValueAt(newNoTelp, selectedRow, 3);
                    model.setValueAt(newIDKaryawan, selectedRow, 4);
                    model.setValueAt(newTanggalPemesanan, selectedRow, 5);
                    model.setValueAt(newIDMobil, selectedRow, 6);
                    model.setValueAt(newHarga, selectedRow, 7);
                    model.setValueAt(newLamaSewa, selectedRow, 8);
                    model.setValueAt(newDp, selectedRow, 9);
                    model.setValueAt(newTotal, selectedRow, 10);

                    Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data pesanan berhasil diperbarui");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    }//GEN-LAST:event_btnUbahActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCekDataMobil;
    private javax.swing.JButton btnCekDataPelanggan;
    private maulana.swing.ButtonAction btnHapus;
    private javax.swing.JButton btnSimpanPesanan;
    private maulana.swing.ButtonAction btnUbah;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGambar;
    private javax.swing.JLabel lblJensiMobil;
    private javax.swing.JLabel lblKapasitas;
    private javax.swing.JLabel lblMerekMobil;
    private javax.swing.JLabel lblPlatNomor;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panelIDPesanan;
    private javax.swing.JPanel panelPemesanan;
    private javax.swing.JTabbedPane tabPane;
    private maulana.swing.TabelFlatLaf tblPemesanan;
    private javax.swing.JTextField txtCari;
    private maulana.swing.TextFieldFlatLaf txtDp;
    private maulana.swing.TextFieldFlatLaf txtHargaMobil;
    private maulana.swing.TextFieldFlatLaf txtIDKaryawan;
    private maulana.swing.TextFieldFlatLaf txtIDMobil;
    private javax.swing.JTextField txtIDPesanan;
    private maulana.swing.TextFieldFlatLaf txtLama;
    private maulana.swing.TextFieldFlatLaf txtNamaPelanggan;
    private maulana.swing.TextFieldFlatLaf txtNik;
    private maulana.swing.TextFieldFlatLaf txtNoTlpnPelanggan;
    private javax.swing.JSpinner txtTanggal;
    private maulana.swing.TextFieldFlatLaf txtTotal;
    // End of variables declaration//GEN-END:variables
}
