package maulana.tampilan.data;

import maulana.tampilan.popup.FormKaryawan;
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
import maulana.koneksi.KoneksiDB;
import maulana.tampilan.main.Main;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.toast.Notifications;

public class DataKaryawan extends javax.swing.JPanel {

    private Connection koneksi = new KoneksiDB().connect();
    private DefaultTableModel tabelModel;
    private Main main;

    public DataKaryawan() {
        initComponents();
        init();
        dataTabel();
    }

    private void init() {
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;"
                + "background:$Table.background");
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
                + "background:$TextField.background");
    }

    private void dataTabel() {
        Object[] baris = {"ID", "NAMA", "JABATAN", "NO. TELEPON", "ALAMAT", "PASSWORD"};
        tabelModel = new DefaultTableModel(null, baris);
        JTableHeader tabelHeader = tabelKaryawan.getTableHeader();
        ((DefaultTableCellRenderer) tabelHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
        String cariItem = txtCari.getText();

        try {
            String query = "SELECT * FROM karyawan WHERE id_karyawan LIKE '%" + cariItem + "%' OR nama_karyawan LIKE'%" + cariItem + "%' ORDER BY id_karyawan ASC";
            Statement statment = koneksi.createStatement();
            ResultSet hasil = statment.executeQuery(query);
            while (hasil.next()) {
                tabelModel.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6)
                });
            }
            tabelKaryawan.setModel(tabelModel);
            // Mengatur lebar kolom
            TableColumn column;
            column = tabelKaryawan.getColumnModel().getColumn(0); // Kolom "ID"            
            column.setMaxWidth(70);       // Lebar maksimum
            column = tabelKaryawan.getColumnModel().getColumn(1); // Kolom "Nama"
            column.setPreferredWidth(100);
            column = tabelKaryawan.getColumnModel().getColumn(2); // Kolom "Jenis Kelamin"
            column.setPreferredWidth(80);
            column = tabelKaryawan.getColumnModel().getColumn(3); // Kolom "No. Handphone"
            column.setPreferredWidth(80);
            // Refresh tabel
            tabelKaryawan.revalidate();
            tabelKaryawan.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal dipanggil");
        }
    }

    private void autoNumber(FormKaryawan tambahDataKaryawan) {
        try {
            String sql = "SELECT id_karyawan FROM karyawan ORDER BY id_karyawan DESC LIMIT 1"; // Mengambil ID terakhir
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Asumsikan default ID jika tidak ada entri di tabel
            String nextID = "2124001";

            if (rs.next()) {
                String id_karyawan = rs.getString("id_karyawan").substring(4); // Mengambil ID tanpa awalan "2124"
                int Angka = Integer.parseInt(id_karyawan) + 1; // Menaikkan angka

                // Menentukan jumlah nol di depan berdasarkan nilai Angka
                String Nol = String.format("%03d", Angka); // Menambahkan nol jika angka kurang dari 3 digit
                nextID = "2124" + Nol; // Membuat ID baru
            }

            // Mengatur ID baru ke form
            tambahDataKaryawan.setTxtID(nextID);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Auto nomor gagal: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new maulana.swing.PanelRounded();
        jLabel1 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        scroll = new javax.swing.JScrollPane();
        tabelKaryawan = new maulana.swing.TabelFlatLaf();
        btnTambah = new maulana.swing.ButtonActionFlatLaf();
        btnEdit = new maulana.swing.ButtonActionFlatLaf();
        btnEdit1 = new maulana.swing.ButtonActionFlatLaf();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Data Karyawan");

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCari.setMargin(new java.awt.Insets(2, 2, 2, 6));
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        tabelKaryawan.setModel(new javax.swing.table.DefaultTableModel(
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
        scroll.setViewportView(tabelKaryawan);

        btnTambah.setText("TAMBAH");
        btnTambah.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setText("EDIT");
        btnEdit.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnEdit1.setText("HAPUS");
        btnEdit1.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 830, Short.MAX_VALUE))))
            .addComponent(scroll)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE))
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

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        dataTabel();
    }//GEN-LAST:event_txtCariKeyReleased

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        FormKaryawan tambahDataKaryawan = new FormKaryawan();
        autoNumber(tambahDataKaryawan);
        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Batal", "Simpan"};
        GlassPanePopup.showPopup(new SimplePopupBorder(tambahDataKaryawan, "Tambah Karyawan", actions, (pc, i) -> {
            if (i == 1) {
                // Ambil data dari form
                String id_karyawan = tambahDataKaryawan.getTxtID();
                String nama = tambahDataKaryawan.getTxtNama();
                String jabatan = tambahDataKaryawan.getSelectedJabatan();
                String noHandphone = tambahDataKaryawan.getTxtNoHP();
                String alamat = tambahDataKaryawan.getTxtAlamat();
                String password = tambahDataKaryawan.getTxtPassword();

                // Tambahkan data ke tabel
                DefaultTableModel model = (DefaultTableModel) tabelKaryawan.getModel();
                model.addRow(new Object[]{id_karyawan, nama, jabatan, noHandphone, alamat, password});

                try {
                    // Simpan data ke database
                    String query = "INSERT INTO karyawan (id_karyawan, nama_karyawan, jabatan, no_telepon_karyawan, alamat_karyawan, password) VALUES ('" + id_karyawan + "', '" + nama + "', '" + jabatan + "', '" + noHandphone + "', '" + alamat + "', '" + password + "')";
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

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Pastikan pengguna memilih baris yang akan di-edit
        int selectedRow = tabelKaryawan.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin di-edit terlebih dahulu!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Ambil data dari baris yang dipilih
        String idKaryawan = tabelKaryawan.getValueAt(selectedRow, 0).toString();
        String namaKaryawan = tabelKaryawan.getValueAt(selectedRow, 1).toString();
        String jabatan = tabelKaryawan.getValueAt(selectedRow, 2).toString();
        String noTlpKaryawan = tabelKaryawan.getValueAt(selectedRow, 3).toString();
        String alamatKaryawan = tabelKaryawan.getValueAt(selectedRow, 4).toString();
        String password = tabelKaryawan.getValueAt(selectedRow, 5).toString();        

        // Buat form mobil dan set data yang diambil dari tabel
        FormKaryawan editDataKaryawan = new FormKaryawan();
        editDataKaryawan.setTxtID(idKaryawan);
        editDataKaryawan.setTxtNama(namaKaryawan);
        editDataKaryawan.setSelectedJabatan(jabatan);
        editDataKaryawan.setTxtNoHP(noTlpKaryawan);
        editDataKaryawan.setTxtAlamat(alamatKaryawan);
        editDataKaryawan.setTxtPassword(password);        

        // Tampilkan popup untuk mengedit data
        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Batal", "Simpan"};

        GlassPanePopup.showPopup(new SimplePopupBorder(editDataKaryawan, "Edit Data Karyawan", actions, (pc, i) -> {
            if (i == 1) {
                // Ambil data yang telah diedit dari form
                String newIDKaryawan = editDataKaryawan.getTxtID();
                String newNamaKaryawan = editDataKaryawan.getTxtNama();
                String newJabatan = editDataKaryawan.getSelectedJabatan();
                String newNoTlpKaryawan = editDataKaryawan.getTxtNoHP();
                String newAlamatKaryawan = editDataKaryawan.getTxtAlamat();
                String newPassword = editDataKaryawan.getTxtPassword();                

                try {
                    // Simpan data yang telah diedit ke database
                    String query = "UPDATE karyawan SET nama_karyawan = ?, jabatan = ?, no_telepon_karyawan = ?, alamat_karyawan = ?, password = ? WHERE id_karyawan = ?";
                    PreparedStatement preparedStatement = koneksi.prepareStatement(query);
                    preparedStatement.setString(1, newNamaKaryawan);
                    preparedStatement.setString(2, newJabatan);
                    preparedStatement.setString(3, newNoTlpKaryawan);
                    preparedStatement.setString(4, newAlamatKaryawan);
                    preparedStatement.setString(5, newPassword);                                        
                    preparedStatement.setString(6, newIDKaryawan);
                    preparedStatement.executeUpdate();

                    // Perbarui data yang telah diedit di tabel
                    DefaultTableModel model = (DefaultTableModel) tabelKaryawan.getModel();
                    model.setValueAt(newNamaKaryawan, selectedRow, 1);
                    model.setValueAt(newJabatan, selectedRow, 2);
                    model.setValueAt(newNoTlpKaryawan, selectedRow, 3);
                    model.setValueAt(newAlamatKaryawan, selectedRow, 4);
                    model.setValueAt(newPassword, selectedRow, 5);                    

                    dataTabel();

                    Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data mobil berhasil diperbarui");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Data gagal diperbarui: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

                pc.closePopup();
            } else {
                pc.closePopup();
            }
        }), option);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit1ActionPerformed
        int selectedRow = tabelKaryawan.getSelectedRow();

        // Periksa apakah ada baris yang dipilih
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Silakan pilih karyawan yang ingin dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Ambil ID karyawan yang dipilih
        String idKaryawan = tabelKaryawan.getValueAt(selectedRow, 0).toString();

        // Konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data karyawan dengan ID: " + idKaryawan + "?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Hapus data dari database
                String query = "DELETE FROM karyawan WHERE id_karyawan = '" + idKaryawan + "'";
                Statement statement = koneksi.createStatement();
                statement.executeUpdate(query);

                // Hapus baris dari tabel
                ((DefaultTableModel) tabelKaryawan.getModel()).removeRow(selectedRow);

                // Tampilkan notifikasi sukses
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data karyawan berhasil dihapus");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Data gagal dihapus: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEdit1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private maulana.swing.ButtonActionFlatLaf btnEdit;
    private maulana.swing.ButtonActionFlatLaf btnEdit1;
    private maulana.swing.ButtonActionFlatLaf btnTambah;
    private javax.swing.JLabel jLabel1;
    private maulana.swing.PanelRounded panel;
    private javax.swing.JScrollPane scroll;
    private maulana.swing.TabelFlatLaf tabelKaryawan;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
