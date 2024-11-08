package maulana.tampilan.data;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import maulana.koneksi.KoneksiDB;
import maulana.tampilan.popup.PopUpDataMobil;
import maulana.tampilan.popup.PopUpDataPelanggan;
import raven.toast.Notifications;

public class Pemesanan extends javax.swing.JPanel {
    
    private String idKaryawan;
    public String nik, noSim, namaPelanggan, noTelepon, alamatPelanggan;
    public String idMobil, merek, jenis, platNomor, kapasitas, tarif, status;
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
        panel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;");
        panel2.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;");
        panel3.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;");
        panel4.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;");
        panel5.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;");
        txtCari.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Cari...");
        txtCari.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("maulana/icon/search.svg"));
        txtCari.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:15;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0;"
                + "margin:5,20,5,20;"
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
        txtIDKaryawan = new javax.swing.JTextField();
        panel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNik = new javax.swing.JTextField();
        txtNamaPelanggan = new javax.swing.JTextField();
        btnCekDataPelanggan = new javax.swing.JButton();
        txtNoTlpnPelanggan = new javax.swing.JTextField();
        panel3 = new javax.swing.JPanel();
        panel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtIDMobil = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtHargaMobil = new javax.swing.JTextField();
        txtLama = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtDp = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtIDPesanan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnCekDataMobil = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        panel5 = new javax.swing.JPanel();
        btnSimpanPesanan = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPemesanan = new javax.swing.JTable();
        btnUbah = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();

        setBackground(new java.awt.Color(51, 51, 51));
        setLayout(new java.awt.BorderLayout());

        tabPane.setBackground(new java.awt.Color(51, 51, 51));
        tabPane.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        panelPemesanan.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("ID Karyawan :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tanggal :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Pemesanan");

        txtTanggal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTanggal.setModel(new javax.swing.SpinnerDateModel());
        txtTanggal.setEnabled(false);

        txtIDKaryawan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIDKaryawan.setEnabled(false);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 418, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIDKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
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

        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Form Pelanggan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("NIK Pelanggan");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("No.Telepon");

        txtNik.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtNamaPelanggan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNamaPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaPelangganActionPerformed(evt);
            }
        });

        btnCekDataPelanggan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCekDataPelanggan.setText("CEK");
        btnCekDataPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekDataPelangganActionPerformed(evt);
            }
        });

        txtNoTlpnPelanggan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNoTlpnPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoTlpnPelangganActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNamaPelanggan)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addComponent(txtNik)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCekDataPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNoTlpnPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNik, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCekDataPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoTlpnPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        panel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Daftar Pesanan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 647, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        panel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Form Pesanan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("ID Mobil");

        txtIDMobil.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Harga / hari");

        txtHargaMobil.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtLama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtLama.setName(""); // NOI18N
        txtLama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLamaKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Lama");

        txtDp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDpKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("DP");

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(69, 73, 74)));

        txtIDPesanan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIDPesanan.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("ID Pemesanan");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtIDPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIDMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCekDataMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHargaMobil))
                            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, panel4Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDp))
                            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, panel4Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLama, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(18, 18, 18))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtIDMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCekDataMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHargaMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtLama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

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

        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Total");

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSimpanPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpanPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout panelPemesananLayout = new javax.swing.GroupLayout(panelPemesanan);
        panelPemesanan.setLayout(panelPemesananLayout);
        panelPemesananLayout.setHorizontalGroup(
            panelPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPemesananLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPemesananLayout.createSequentialGroup()
                        .addGroup(panelPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        panelPemesananLayout.setVerticalGroup(
            panelPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPemesananLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(panelPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPemesananLayout.createSequentialGroup()
                        .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        tabPane.addTab("Pemesanan", panelPemesanan);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        tblPemesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Pesanan", "Nama Pelanggan", "NIK", "No. Telepon", "ID Karyawan", "Tgl. Pesanan", "ID Mobil", "Harga", "Lama", "DP", "Sub Total"
            }
        ));
        jScrollPane2.setViewportView(tblPemesanan);
        if (tblPemesanan.getColumnModel().getColumnCount() > 0) {
            tblPemesanan.getColumnModel().getColumn(0).setMaxWidth(100);
            tblPemesanan.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblPemesanan.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblPemesanan.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblPemesanan.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblPemesanan.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblPemesanan.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblPemesanan.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblPemesanan.getColumnModel().getColumn(8).setPreferredWidth(50);
            tblPemesanan.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblPemesanan.getColumnModel().getColumn(10).setPreferredWidth(100);
        }

        btnUbah.setText("UBAH");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        jButton2.setText("HAPUS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 649, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
        );

        tabPane.addTab("Lihat Pesanan", jPanel2);

        add(tabPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaPelangganActionPerformed

    private void btnCekDataPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekDataPelangganActionPerformed
        // Membuat dialog baru yang berisi panel PopUpDataPelanggan
        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Data Pelanggan", true);

        // Menambahkan panel PopUpDataPelanggan ke dalam dialog
        PopUpDataPelanggan dataPelanggan = new PopUpDataPelanggan();
        dataPelanggan.pelanggan = this;
        dataPelanggan.setVisible(true);
        dialog.add(dataPelanggan);

        // Mengatur ukuran dan lokasi dialog
        dialog.setSize(776, 400);
        dialog.setLocationRelativeTo(null); // Agar dialog muncul di tengah
        dialog.setResizable(false); // Menonaktifkan resize
        dialog.setVisible(true); // Menampilkan dialog
    }//GEN-LAST:event_btnCekDataPelangganActionPerformed

    private void txtNoTlpnPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoTlpnPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoTlpnPelangganActionPerformed

    private void btnCekDataMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekDataMobilActionPerformed
        // Membuat dialog baru yang berisi panel PopUpDataPelanggan
        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Data Mobil", true);

        // Menambahkan panel PopUpDataPelanggan ke dalam dialog
        PopUpDataMobil dataMobil = new PopUpDataMobil();
        dataMobil.mobil = this;
        dataMobil.setVisible(true);
        dialog.add(dataMobil);

        // Mengatur ukuran dan lokasi dialog
        dialog.setSize(776, 400);
        dialog.setLocationRelativeTo(null); // Agar dialog muncul di tengah
        dialog.setResizable(false); // Menonaktifkan resize
        dialog.setVisible(true); // Menampilkan dialog
    }//GEN-LAST:event_btnCekDataMobilActionPerformed

    private void txtLamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLamaKeyReleased
        try {
            // Ambil nilai dari field harga/hari dan lama
            int hargaPerHari = Integer.parseInt(txtHargaMobil.getText());
            int lama = Integer.parseInt(txtLama.getText());

            // Hitung subtotal
            int subTotal = hargaPerHari * lama;

            // Set subtotal sebagai teks pada field txtTotal
            txtTotal.setText(String.valueOf(subTotal));
        } catch (Exception e) {
            txtTotal.setText("");
        }
    }//GEN-LAST:event_txtLamaKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Menghapus semua baris dari tabel
        tabModelPesanan.setRowCount(0);  // Ini akan menghapus semua data dalam tabel

        // Opsional: Mengosongkan JTextField (form input)
        txtNik.setText("");
        txtNamaPelanggan.setText("");
        txtNoTlpnPelanggan.setText("");
        txtIDMobil.setText("");
        txtHargaMobil.setText("");
        txtLama.setText("");
        txtDp.setText("");        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtDpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDpKeyReleased
        try {
            // Ambil nilai dari field harga/hari dan lama
            int hargaPerHari = Integer.parseInt(txtHargaMobil.getText());
            int lama = Integer.parseInt(txtLama.getText());
            int dp = Integer.parseInt(txtDp.getText());

            // Hitung subtotal
            int subTotal = hargaPerHari * lama - dp;

            // Set subtotal sebagai teks pada field txtTotal
            txtTotal.setText(String.valueOf(subTotal));
        } catch (Exception e) {
            txtTotal.setText("");
        }
    }//GEN-LAST:event_txtDpKeyReleased

    private void btnSimpanPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanPesananActionPerformed
        String query = "INSERT INTO pemesanan (id_pemesanan, nama_pelanggan, nik, notlpn_pelanggan, id_karyawan, tanggal_pemesanan, id_mobil, harga, lama_sewa, dp, total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Ambil data dari JTextField
            String idPemesanan = txtIDPesanan.getText();  // ID Pemesanan
            String namaPelanggan = txtNamaPelanggan.getText();     // Nama Pelanggan
            String nik = txtNik.getText();                // NIK
            String noTelp = txtNoTlpnPelanggan.getText();          // No. Telepon
            String idKaryawan = txtIDKaryawan.getText();  // ID Karyawan            

            // Ambil tanggal dari JSpinner
            java.util.Date tanggal = (java.util.Date) txtTanggal.getValue(); // Ambil nilai dari JSpinner
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd"); // Format tanggal yang diinginkan
            String tanggalPemesanan = sdf.format(tanggal);  // Ubah tanggal menjadi string dalam format "yyyy-MM-dd"

            // Siapkan PreparedStatement untuk memasukkan data ke dalam tabel pemesanan
            PreparedStatement statement = koneksi.prepareStatement(query);

            // Set nilai parameter untuk query
            statement.setString(1, idPemesanan);       // ID Pemesanan
            statement.setString(2, namaPelanggan);     // Nama Pelanggan
            statement.setString(3, nik);               // NIK
            statement.setString(4, noTelp);            // No. Telepon
            statement.setString(5, idKaryawan);        // ID Karyawan
            statement.setString(6, tanggalPemesanan);  // Tanggal Pemesanan            
            
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int selectedRow = tblPemesanan.getSelectedRow();

        // Periksa apakah ada baris yang dipilih
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Silakan pilih karyawan yang ingin dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Ambil ID pemesanan yang dipilih
        String idPesanan = tblPemesanan.getValueAt(selectedRow, 0).toString();

        // Konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data pesanan dengan ID Pesanan: " + idPesanan + "?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Hapus data dari database
                String query = "DELETE FROM pemesanan WHERE id_pemesanan = '" + idPesanan + "'";
                Statement statement = koneksi.createStatement();
                statement.executeUpdate(query);

                // Hapus baris dari tabel
                ((DefaultTableModel) tblPemesanan.getModel()).removeRow(selectedRow);

                // Tampilkan notifikasi sukses
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data pemesanan berhasil dihapus");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Data gagal dihapus: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // Pastikan pengguna memilih baris yang akan di-edit
        int selectedRow = tblPemesanan.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin di-edit terlebih dahulu!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Ambil data dari setiap kolom
        String idPemesanan = tblPemesanan.getValueAt(selectedRow, 0).toString();
        String namaPelanggan = tblPemesanan.getValueAt(selectedRow, 1).toString();
        String nik = tblPemesanan.getValueAt(selectedRow, 2).toString();
        String noTelp = tblPemesanan.getValueAt(selectedRow, 3).toString();
        String idKaryawan = tblPemesanan.getValueAt(selectedRow, 4).toString();
        String tanggalPemesanan = tblPemesanan.getValueAt(selectedRow, 5).toString();
        String idMobil = tblPemesanan.getValueAt(selectedRow, 6).toString();
        String harga = tblPemesanan.getValueAt(selectedRow, 7).toString();
        String lamaSewa = tblPemesanan.getValueAt(selectedRow, 8).toString();
        String dp = tblPemesanan.getValueAt(selectedRow, 9).toString();
        String total = tblPemesanan.getValueAt(selectedRow, 10).toString();        
        
        // Set data ke JTextField di panel Pemesanan
        txtIDPesanan.setText(idPemesanan);
        txtNamaPelanggan.setText(namaPelanggan);
        txtNik.setText(nik);
        txtNoTlpnPelanggan.setText(noTelp);
        txtIDKaryawan.setText(idKaryawan);
        txtTotal.setText(total);
        
        // Parsing tanggal jika perlu, misalnya jika memakai JSpinner
        try {
            java.util.Date date = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(tanggalPemesanan);
            txtTanggal.setValue(date); // Mengatur JSpinner tanggal
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        // Set field lainnya
        txtIDMobil.setText(idMobil);
        txtHargaMobil.setText(harga);
        txtLama.setText(lamaSewa);
        txtDp.setText(dp);        

        // Pindah ke tab Pemesanan
        tabPane.setSelectedIndex(0);                       
    }//GEN-LAST:event_btnUbahActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        dataTabel();
    }//GEN-LAST:event_txtCariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCekDataMobil;
    private javax.swing.JButton btnCekDataPelanggan;
    private javax.swing.JButton btnSimpanPesanan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panelPemesanan;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JTable tblPemesanan;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtDp;
    private javax.swing.JTextField txtHargaMobil;
    private javax.swing.JTextField txtIDKaryawan;
    private javax.swing.JTextField txtIDMobil;
    private javax.swing.JTextField txtIDPesanan;
    private javax.swing.JTextField txtLama;
    private javax.swing.JTextField txtNamaPelanggan;
    private javax.swing.JTextField txtNik;
    private javax.swing.JTextField txtNoTlpnPelanggan;
    private javax.swing.JSpinner txtTanggal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
