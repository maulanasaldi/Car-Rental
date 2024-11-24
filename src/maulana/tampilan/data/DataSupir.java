package maulana.tampilan.data;

import maulana.tampilan.popup.FormSupir;
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

public class DataSupir extends javax.swing.JPanel {

    private Connection koneksi = new KoneksiDB().connect();
    private DefaultTableModel tabelModel;

    public DataSupir() {
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
        Object[] baris = {"ID", "NAMA", "NO. TELEPON", "ALAMAT", "TARIF"};
        tabelModel = new DefaultTableModel(null, baris);
        JTableHeader tabelHeader = tabelSopir.getTableHeader();
        ((DefaultTableCellRenderer) tabelHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
        String cariItem = txtCari.getText();

        try {
            String query = "SELECT * FROM supir WHERE id_supir LIKE '%" + cariItem + "%' OR nama_supir LIKE'%" + cariItem + "%' ORDER BY id_supir ASC";
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
            tabelSopir.setModel(tabelModel);
            // Mengatur lebar kolom
            TableColumn column;
            column = tabelSopir.getColumnModel().getColumn(0); // Kolom "ID"            
            column.setMaxWidth(60);       // Lebar maksimum
            column = tabelSopir.getColumnModel().getColumn(1); // Kolom "Nama"
            column.setPreferredWidth(100);
            column = tabelSopir.getColumnModel().getColumn(2); // Kolom "Nomor Ponsel"
            column.setPreferredWidth(100);
            column = tabelSopir.getColumnModel().getColumn(3); // Kolom "Alamat"
            column.setPreferredWidth(300);
            // Refresh tabel
            tabelSopir.revalidate();
            tabelSopir.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal dipanggil");
        }
    }

    private void autoNumber(FormSupir tambah) {
        try {
            String sql = "SELECT id_supir FROM supir ORDER BY id_supir DESC LIMIT 1"; // Mengambil ID terakhir
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Asumsikan default ID jika tidak ada entri di tabel
            String nextID = "SP0001";

            if (rs.next()) {
                String id_supir = rs.getString("id_supir").substring(2); // Mengambil ID tanpa awalan "SP"
                int Angka = Integer.parseInt(id_supir) + 1; // Menaikkan angka

                // Menentukan jumlah nol di depan berdasarkan nilai Angka
                String Nol = String.format("%04d", Angka); // Membuat format string "000", "00", "0", atau "" sesuai dengan nilai Angka
                nextID = "SP" + Nol; // Membuat ID baru
            }

            // Mengatur ID baru ke form
            tambah.setTxtID(nextID);

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
        tabelSopir = new maulana.swing.TabelFlatLaf();
        buttonAction1 = new maulana.swing.ButtonActionFlatLaf();
        buttonAction2 = new maulana.swing.ButtonActionFlatLaf();
        buttonAction3 = new maulana.swing.ButtonActionFlatLaf();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Data Supir");

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCari.setMargin(new java.awt.Insets(2, 2, 2, 6));
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        tabelSopir.setModel(new javax.swing.table.DefaultTableModel(
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
        scroll.setViewportView(tabelSopir);

        buttonAction1.setText("TAMBAH");
        buttonAction1.setMargin(new java.awt.Insets(2, 10, 2, 10));
        buttonAction1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction1ActionPerformed(evt);
            }
        });

        buttonAction2.setText("UBAH");
        buttonAction2.setMargin(new java.awt.Insets(2, 10, 2, 10));
        buttonAction2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction2ActionPerformed(evt);
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
            .addComponent(scroll)
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
                        .addComponent(buttonAction2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAction2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAction3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void buttonAction1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction1ActionPerformed
        FormSupir tambahDataSupir = new FormSupir();
        autoNumber(tambahDataSupir);
        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Batal", "Simpan"};
        GlassPanePopup.showPopup(new SimplePopupBorder(tambahDataSupir, "Tambah Data Supir", actions, (pc, i) -> {
            if (i == 1) {
                // Ambil data dari form
                String id = tambahDataSupir.getTxtID();
                String nama = tambahDataSupir.getTxtNama();
                String noTelepon = tambahDataSupir.getTxtNoTelepon();
                String alamat = tambahDataSupir.getTxtAlamat();
                String tarif = tambahDataSupir.getTxtTarif();

                // Tambahkan data ke tabel
                DefaultTableModel model = (DefaultTableModel) tabelSopir.getModel();
                model.addRow(new Object[]{id, nama, noTelepon, alamat, tarif});

                try {
                    // Simpan data ke database
                    String query = "INSERT INTO supir (id_supir, nama_supir, no_telepon_supir, alamat_supir, tarif_supir) VALUES ('" + id + "', '" + nama + "', '" + noTelepon + "', '" + alamat + "', '" + tarif + "')";
                    Statement statement = koneksi.createStatement();
                    statement.executeUpdate(query);
                    pc.closePopup();
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data supir berhasil ditambahkan");
                } catch (Exception e) {
                    e.printStackTrace();
                    Notifications.getInstance().show(Notifications.Type.ERROR, "Data supir gagal ditambahkan");
                }

                pc.closePopup();
            } else {
                pc.closePopup();
            }
        }), option);
    }//GEN-LAST:event_buttonAction1ActionPerformed

    private void buttonAction2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction2ActionPerformed
        // Pastikan pengguna memilih baris yang akan di-edit
        int selectedRow = tabelSopir.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diubah terlebih dahulu!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Ambil data dari baris yang dipilih
        String id = tabelSopir.getValueAt(selectedRow, 0).toString();
        String nama = tabelSopir.getValueAt(selectedRow, 1).toString();
        String noTelepon = tabelSopir.getValueAt(selectedRow, 2).toString();
        String alamat = tabelSopir.getValueAt(selectedRow, 3).toString();
        String tarif = tabelSopir.getValueAt(selectedRow, 4).toString();

        // Buat form supir dan set data yang diambil dari tabel
        FormSupir editDataSupir = new FormSupir();
        editDataSupir.setTxtID(id);  // Set ID ke field ID di form
        editDataSupir.setTxtNama(nama);  // Set Nama ke field Nama di form
        editDataSupir.setTxtNoTelepon(noTelepon);  // Set Nomer Telepon ke field Nomer Telepon di form
        editDataSupir.setTxtAlamat(alamat);  // Set Alamat ke field Alamat di form
        editDataSupir.setTxtTarif(tarif); // Set Nomer Telepon ke field Nomer Telepon di form

        // Tampilkan popup untuk mengedit data
        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Batal", "Simpan"};

        GlassPanePopup.showPopup(new SimplePopupBorder(editDataSupir, "Ubah Data Supir", actions, (pc, i) -> {
            if (i == 1) {
                // Ambil data yang telah diedit dari form supir
                String newID = editDataSupir.getTxtID();
                String newNama = editDataSupir.getTxtNama();
                String newNoTelepon = editDataSupir.getTxtNoTelepon();
                String newAlamat = editDataSupir.getTxtAlamat();
                String newTarif = editDataSupir.getTxtTarif();

                try {
                    // Simpan data yang telah diedit ke database
                    String query = "UPDATE supir SET nama_supir = ?, no_telepon_supir = ?, alamat_supir = ?, tarif_supir = ? WHERE id_supir = ?";
                    PreparedStatement preparedStatement = koneksi.prepareStatement(query);
                    preparedStatement.setString(1, newNama);
                    preparedStatement.setString(2, newNoTelepon);
                    preparedStatement.setString(3, newAlamat);
                    preparedStatement.setString(4, newTarif);
                    preparedStatement.setString(5, newID);
                    preparedStatement.executeUpdate();

                    // Perbarui data yang telah diedit di tabel supir
                    DefaultTableModel model = (DefaultTableModel) tabelSopir.getModel();
                    model.setValueAt(newNama, selectedRow, 1);
                    model.setValueAt(newNoTelepon, selectedRow, 2);
                    model.setValueAt(newAlamat, selectedRow, 3);
                    model.setValueAt(newTarif, selectedRow, 4);

                    Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data supir berhasil diperbarui");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Data gagal diperbarui: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

                pc.closePopup();
            } else {
                pc.closePopup();
            }
        }), option);
    }//GEN-LAST:event_buttonAction2ActionPerformed

    private void buttonAction3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction3ActionPerformed
        int selectedRow = tabelSopir.getSelectedRow();

        // Periksa apakah ada baris yang dipilih
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Silakan pilih data supir yang ingin dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Ambil ID sopir yang dipilih
        String idSupir = tabelSopir.getValueAt(selectedRow, 0).toString();

        // Konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data supir dengan ID: " + idSupir + "?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Hapus data dari database
                String query = "DELETE FROM supir WHERE id_supir = '" + idSupir + "'";
                Statement statement = koneksi.createStatement();
                statement.executeUpdate(query);

                // Hapus baris dari tabel
                ((DefaultTableModel) tabelSopir.getModel()).removeRow(selectedRow);

                // Tampilkan notifikasi sukses
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data supir berhasil dihapus");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Data gagal dihapus: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_buttonAction3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private maulana.swing.ButtonActionFlatLaf buttonAction1;
    private maulana.swing.ButtonActionFlatLaf buttonAction2;
    private maulana.swing.ButtonActionFlatLaf buttonAction3;
    private javax.swing.JLabel jLabel1;
    private maulana.swing.PanelRounded panel;
    private javax.swing.JScrollPane scroll;
    private maulana.swing.TabelFlatLaf tabelSopir;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
