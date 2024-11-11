package maulana.tampilan.data;

import maulana.tampilan.popup.FormPelanggan;
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
        Object[] baris = {"NIK", "NO. SIM", "NAMA", "NO. TELEPON", "ALAMAT"};
        tabelModel = new DefaultTableModel(null, baris);
        JTableHeader tabelHeader = tabelPelanggan.getTableHeader();
        ((DefaultTableCellRenderer) tabelHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
        String cariItem = txtCari.getText();

        try {
            String query = "SELECT * FROM pelanggan WHERE nik LIKE '%" + cariItem + "%' OR nama_pelanggan LIKE'%" + cariItem + "%' ORDER BY nik ASC";
            Statement statment = koneksi.createStatement();
            ResultSet hasil = statment.executeQuery(query);
            while (hasil.next()) {
                tabelModel.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5)
                });
            }
            tabelPelanggan.setModel(tabelModel);
            // Mengatur lebar kolom
            TableColumn column;
            column = tabelPelanggan.getColumnModel().getColumn(0); // Kolom "NIK"            
            column.setPreferredWidth(100);       // Lebar maksimum
            column = tabelPelanggan.getColumnModel().getColumn(1); // Kolom "No. SIM"
            column.setPreferredWidth(100);
            column = tabelPelanggan.getColumnModel().getColumn(2); // Kolom "Nama"
            column.setPreferredWidth(100);
            column = tabelPelanggan.getColumnModel().getColumn(3); // Kolom "No Telepon"
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
        tabelPelanggan = new maulana.swing.TabelFlatLaf();
        btnTambah = new maulana.swing.ButtonAction();
        btnEdit = new maulana.swing.ButtonAction();
        buttonAction3 = new maulana.swing.ButtonAction();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Data Pelanggan");

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCari.setMargin(new java.awt.Insets(2, 2, 2, 6));
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        tabelPelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        scroll.setViewportView(tabelPelanggan);

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

        buttonAction3.setText("HAPUS");
        buttonAction3.setMargin(new java.awt.Insets(2, 10, 2, 10));
        buttonAction3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction3ActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 492, Short.MAX_VALUE)
                        .addComponent(buttonAction3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING)
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
                    .addComponent(buttonAction3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE))
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
        FormPelanggan tambahDataPelanggan = new FormPelanggan();
        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Batal", "Simpan"};
        GlassPanePopup.showPopup(new SimplePopupBorder(tambahDataPelanggan, "Tambah Data Pelanggan", actions, (pc, i) -> {
            if (i == 1) {
                // Ambil data dari form
                String nik = tambahDataPelanggan.getTxtNIK();
                String noSim = tambahDataPelanggan.getTxtNoSim();
                String nama = tambahDataPelanggan.getTxtNama();
                String noTelepon = tambahDataPelanggan.getTxtNoTelepon();
                String alamat = tambahDataPelanggan.getTxtAlamat();

                // Tambahkan data ke tabel
                DefaultTableModel model = (DefaultTableModel) tabelPelanggan.getModel();
                model.addRow(new Object[]{nik, noSim, nama, noTelepon, alamat});

                try {
                    // Simpan data ke database
                    String query = "INSERT INTO pelanggan (nik, no_sim, nama_pelanggan, notlpn_pelanggan, alamat_pelanggan) VALUES ('" + nik + "', '" + noSim + "', '" + nama + "', '" + noTelepon + "', '" + alamat + "')";
                    Statement statement = koneksi.createStatement();
                    statement.executeUpdate(query);
                    pc.closePopup();
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data pelanggan berhasil ditambahkan");
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
        int selectedRow = tabelPelanggan.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin di-edit terlebih dahulu!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Ambil data dari baris yang dipilih
        String nik = tabelPelanggan.getValueAt(selectedRow, 0).toString();
        String noSim = tabelPelanggan.getValueAt(selectedRow, 1).toString();
        String nama = tabelPelanggan.getValueAt(selectedRow, 2).toString();
        String noTelepon = tabelPelanggan.getValueAt(selectedRow, 3).toString();
        String alamat = tabelPelanggan.getValueAt(selectedRow, 4).toString();

        // Buat form TambahPelanggan dan set data yang diambil dari tabel
        FormPelanggan editDataPelanggan = new FormPelanggan();
        editDataPelanggan.setTxtNIK(nik);  // Set NIK ke field NIK di form pelanggan
        editDataPelanggan.setTxtNoSim(noSim); // Set No SIM ke field No SIM di form pelanggan
        editDataPelanggan.setTxtNama(nama);  // Set Nama ke field Nama di form pelanggan
        editDataPelanggan.setTxtNoTelepon(noTelepon);    // Set No Telepon ke field No Telepon di form pelanggan
        editDataPelanggan.setTxtAlamat(alamat);  // Set Alamat ke field Alamat di form pelanggan

        // Tampilkan popup untuk mengedit data
        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Batal", "Simpan"};

        GlassPanePopup.showPopup(new SimplePopupBorder(editDataPelanggan, "Edit Data Pelanggan", actions, (pc, i) -> {
            if (i == 1) {
                // Ambil data yang telah diedit dari form pelanggan
                String newNIK = editDataPelanggan.getTxtNIK();
                String newNoSim = editDataPelanggan.getTxtNoSim();
                String newNama = editDataPelanggan.getTxtNama();
                String newNoTelepon = editDataPelanggan.getTxtNoTelepon();
                String newAlamat = editDataPelanggan.getTxtAlamat();

                try {
                    // Simpan data yang telah diedit ke database
                    String query = "UPDATE pelanggan SET no_sim = ?, nama_pelanggan = ?,  notlpn_pelanggan = ?, alamat_pelanggan = ? WHERE nik = ?";
                    PreparedStatement preparedStatement = koneksi.prepareStatement(query);
                    preparedStatement.setString(1, newNoSim);
                    preparedStatement.setString(2, newNama);
                    preparedStatement.setString(3, noTelepon);
                    preparedStatement.setString(4, newAlamat);
                    preparedStatement.setString(5, newNIK);
                    preparedStatement.executeUpdate();

                    // Perbarui data yang telah diedit di tabel pelanggan
                    DefaultTableModel model = (DefaultTableModel) tabelPelanggan.getModel();
                    model.setValueAt(newNoSim, selectedRow, 1);
                    model.setValueAt(newNama, selectedRow, 2);
                    model.setValueAt(newNoTelepon, selectedRow, 3);
                    model.setValueAt(newAlamat, selectedRow, 4);

                    Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data pelanggan berhasil diperbarui");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Data gagal diperbarui: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

                pc.closePopup();
            } else {
                pc.closePopup();
            }
        }), option);
    }//GEN-LAST:event_btnEditActionPerformed

    private void buttonAction3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction3ActionPerformed
        int selectedRow = tabelPelanggan.getSelectedRow();

        // Periksa apakah ada baris yang dipilih
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Silakan pilih data pelanggan yang ingin dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Ambil ID pelanggan yang dipilih
        String idPelanggan = tabelPelanggan.getValueAt(selectedRow, 0).toString();

        // Konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data pelanggan dengan ID: " + idPelanggan + "?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Hapus data dari database
                String query = "DELETE FROM pelanggan WHERE nik = '" + idPelanggan + "'";
                Statement statement = koneksi.createStatement();
                statement.executeUpdate(query);

                // Hapus baris dari tabel
                ((DefaultTableModel) tabelPelanggan.getModel()).removeRow(selectedRow);

                // Tampilkan notifikasi sukses
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data pelanggan berhasil dihapus");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Data gagal dihapus: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_buttonAction3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private maulana.swing.ButtonAction btnEdit;
    private maulana.swing.ButtonAction btnTambah;
    private maulana.swing.ButtonAction buttonAction3;
    private javax.swing.JLabel jLabel1;
    private maulana.swing.PanelRounded panel;
    private javax.swing.JScrollPane scroll;
    private maulana.swing.TabelFlatLaf tabelPelanggan;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
