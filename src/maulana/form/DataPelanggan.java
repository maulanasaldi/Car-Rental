package maulana.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import koneksi.KoneksiDB;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.toast.Notifications;

public class DataPelanggan extends javax.swing.JPanel {

    private Connection koneksi = new KoneksiDB().connect();
    private DefaultTableModel tabelModel;

    public DataPelanggan() {
        initComponents();
        init();
        dataTabel();
    }

    private void init() {
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");
        tabelPelanggan.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");
        tabelPelanggan.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;"
                + "background:$Table.background;");
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

    private void dataTabel() {
        Object[] baris = {"NIK", "NAMA", "JENIS KELAMIN", "NO. HANDPHONE", "PEKERJAAN", "NO. SIM", "ALAMAT"};
        tabelModel = new DefaultTableModel(null, baris);
        JTableHeader tabelHeader = tabelPelanggan.getTableHeader();
        ((DefaultTableCellRenderer) tabelHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
        String cariItem = txtCari.getText();

        try {
            String query = "SELECT * FROM pelanggan WHERE nik LIKE '%" + cariItem + "%' OR nama LIKE'%" + cariItem + "%' ORDER BY nik ASC";
            Statement statment = koneksi.createStatement();
            ResultSet hasil = statment.executeQuery(query);
            while (hasil.next()) {
                tabelModel.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6),
                    hasil.getString(7)
                });
            }
            tabelPelanggan.setModel(tabelModel);
            // Mengatur lebar kolom
            TableColumn column;
            column = tabelPelanggan.getColumnModel().getColumn(0); // Kolom "NIK"            
            column.setPreferredWidth(100);       // Lebar maksimum
            column = tabelPelanggan.getColumnModel().getColumn(1); // Kolom "Nama"
            column.setPreferredWidth(100);
            column = tabelPelanggan.getColumnModel().getColumn(2); // Kolom "Jenis Kelamin"
            column.setPreferredWidth(100);
            column = tabelPelanggan.getColumnModel().getColumn(3); // Kolom "No Handphone"
            column.setPreferredWidth(100);
            // Refresh tabel
            tabelPelanggan.revalidate();
            tabelPelanggan.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal dipanggil");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new maulana.swing.PanelRounded();
        jLabel1 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        scroll = new javax.swing.JScrollPane();
        tabelPelanggan = new javax.swing.JTable();
        btnTambah = new maulana.swing.Button();
        btnEdit = new maulana.swing.Button();
        btnHapus = new maulana.swing.Button();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Data Pelanggan");

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCari.setMargin(new java.awt.Insets(2, 2, 2, 6));
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        scroll.setBorder(null);

        tabelPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Password", "Alamat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelPelanggan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scroll.setViewportView(tabelPelanggan);
        if (tabelPelanggan.getColumnModel().getColumnCount() > 0) {
            tabelPelanggan.getColumnModel().getColumn(0).setMaxWidth(40);
            tabelPelanggan.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabelPelanggan.getColumnModel().getColumn(3).setPreferredWidth(300);
        }

        btnTambah.setBackground(new java.awt.Color(51, 204, 0));
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("TAMBAH");
        btnTambah.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(204, 204, 0));
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("EDIT");
        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(204, 0, 0));
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("HAPUS");
        btnHapus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        FormPelanggan tambah = new FormPelanggan();
        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Batal", "Simpan"};
        GlassPanePopup.showPopup(new SimplePopupBorder(tambah, "Tambah Karyawan", actions, (pc, i) -> {
            if (i == 1) {
                // Ambil data dari form
                String nik = tambah.getTxtNIK();
                String nama = tambah.getTxtNama();
                String gender = tambah.getSelectedGender();
                String noHandphone = tambah.getTxtNoHP();
                String pekerjaan = tambah.getTxtPekerjaan();
                String noSIM = tambah.getTxtNoSIM();
                String alamat = tambah.getTxtAlamat();

                // Tambahkan data ke tabel
                DefaultTableModel model = (DefaultTableModel) tabelPelanggan.getModel();
                model.addRow(new Object[]{nik, nama, gender, noHandphone, pekerjaan, noSIM, alamat});

                try {
                    // Simpan data ke database
                    String query = "INSERT INTO pelanggan (nik, nama, jenisKelamin, noHandphone, pekerjaan, noSIM, alamat) VALUES ('" + nik + "', '" + nama + "', '" + gender + "', '" + noHandphone + "', '" + pekerjaan + "', '" + noSIM + "', '" + alamat + "')";
                    Statement statement = koneksi.createStatement();
                    statement.executeUpdate(query);
                    pc.closePopup();
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data karyawan berhasil ditambahkan");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                pc.closePopup();
            } else {
                pc.closePopup();
            }
        }), option);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int selectedRow = tabelPelanggan.getSelectedRow();

        // Periksa apakah ada baris yang dipilih
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Silakan pilih karyawan yang ingin dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Ambil ID karyawan yang dipilih
        String idKaryawan = tabelPelanggan.getValueAt(selectedRow, 0).toString();

        // Konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus karyawan dengan ID: " + idKaryawan + "?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Hapus data dari database
                String query = "DELETE FROM karyawan WHERE id = '" + idKaryawan + "'";
                Statement statement = koneksi.createStatement();
                statement.executeUpdate(query);

                // Hapus baris dari tabel
                ((DefaultTableModel) tabelPelanggan.getModel()).removeRow(selectedRow);

                // Tampilkan notifikasi sukses
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data karyawan berhasil dihapus");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Data gagal dihapus: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Pastikan pengguna memilih baris yang akan di-edit
        int selectedRow = tabelPelanggan.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin di-edit terlebih dahulu!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Ambil data dari baris yang dipilih
        String nik = tabelPelanggan.getValueAt(selectedRow, 0).toString();
        String nama = tabelPelanggan.getValueAt(selectedRow, 1).toString();
        String gender = tabelPelanggan.getValueAt(selectedRow, 2).toString();
        String noHandphone = tabelPelanggan.getValueAt(selectedRow, 3).toString();
        String pekerjaan = tabelPelanggan.getValueAt(selectedRow, 4).toString();
        String noSIM = tabelPelanggan.getValueAt(selectedRow, 5).toString();
        String alamat = tabelPelanggan.getValueAt(selectedRow, 6).toString();

        // Buat form TambahKaryawan dan set data yang diambil dari tabel
        FormPelanggan edit = new FormPelanggan();
        edit.setTxtNIK(nik);  // Set ID ke field ID di form
        edit.setTxtNama(nama);  // Set Nama ke field Nama di form
        edit.setSelectedGender(gender);  // Set Password ke field Password di form
        edit.setTxtNoHP(noHandphone);
        edit.setTxtPekerjaan(pekerjaan);
        edit.setTxtNoSIM(noSIM);
        edit.setTxtAlamat(alamat);  // Set Alamat ke field Alamat di form

        // Tampilkan popup untuk mengedit data
        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Batal", "Simpan"};

        GlassPanePopup.showPopup(new SimplePopupBorder(edit, "Edit Karyawan", actions, (pc, i) -> {
            if (i == 1) {
                // Ambil data yang telah diedit dari form
                String newNIK = edit.getTxtNIK();
                String newNama = edit.getTxtNama();
                String newGender = edit.getSelectedGender();
                String newNoHandphone = edit.getTxtNoHanphone();
                String newPekerjaan = edit.getTxtPekerjaan();
                String newNoSIM = edit.getTxtNoSIM();
                String newAlamat = edit.getTxtAlamat();

                try {
                    // Simpan data yang telah diedit ke database
                    String query = "UPDATE karyawan SET nama = ?, password = ?, alamat = ? WHERE id = ?";
                    PreparedStatement preparedStatement = koneksi.prepareStatement(query);
                    preparedStatement.setString(1, newNama);
                    preparedStatement.setString(2, newGender);
                    preparedStatement.setString(3, newNoHandphone);
                    preparedStatement.setString(4, newPekerjaan);
                    preparedStatement.setString(5, newNoSIM);
                    preparedStatement.setString(6, newAlamat);
                    preparedStatement.setString(7, newNIK);
                    preparedStatement.executeUpdate();

                    // Perbarui data yang telah diedit di tabel
                    DefaultTableModel model = (DefaultTableModel) tabelPelanggan.getModel();
                    model.setValueAt(newNama, selectedRow, 1);
                    model.setValueAt(newGender, selectedRow, 2);
                    model.setValueAt(newNoHandphone, selectedRow, 3);
                    model.setValueAt(newPekerjaan, selectedRow, 4);
                    model.setValueAt(newNoSIM, selectedRow, 5);                    
                    model.setValueAt(newAlamat, selectedRow, 6);

                    Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data karyawan berhasil diperbarui");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Data gagal diperbarui: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

                pc.closePopup();
            } else {
                pc.closePopup();
            }
        }), option);
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        dataTabel();
    }//GEN-LAST:event_txtCariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private maulana.swing.Button btnEdit;
    private maulana.swing.Button btnHapus;
    private maulana.swing.Button btnTambah;
    private javax.swing.JLabel jLabel1;
    private maulana.swing.PanelRounded panel;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tabelPelanggan;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
