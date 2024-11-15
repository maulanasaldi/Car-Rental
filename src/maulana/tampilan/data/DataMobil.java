package maulana.tampilan.data;

import maulana.tampilan.popup.FormMobil;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import maulana.koneksi.KoneksiDB;
import raven.popup.DefaultOption;
import raven.popup.GlassPanePopup;
import raven.popup.component.SimplePopupBorder;
import raven.toast.Notifications;

public class DataMobil extends javax.swing.JPanel {

    private Connection koneksi = new KoneksiDB().connect();
    private DefaultTableModel tabelModel;

    public DataMobil() {
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
        Object[] baris = {"ID", "MEREK", "JENIS", "PLAT NOMOR", "KAPASITAS", "TARIF", "STATUS", "GAMBAR"};
        tabelModel = new DefaultTableModel(null, baris) {
            @Override
            public Class<?> getColumnClass(int column) {
                return column == 7 ? ImageIcon.class : String.class;
            }
        };
        JTableHeader tabelHeader = tabelMobil.getTableHeader();
        ((DefaultTableCellRenderer) tabelHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
        String cariItem = txtCari.getText();

        try {
            String query = "SELECT * FROM mobil WHERE id_mobil LIKE ? OR jenis LIKE ? ORDER BY id_mobil ASC";
            PreparedStatement preparedStatement = koneksi.prepareStatement(query);
            preparedStatement.setString(1, "%" + cariItem + "%");
            preparedStatement.setString(2, "%" + cariItem + "%");
            ResultSet hasil = preparedStatement.executeQuery();

            while (hasil.next()) {
                String id = hasil.getString("id_mobil");
                String merek = hasil.getString("merek");
                String jenis = hasil.getString("jenis");
                String platNomor = hasil.getString("plat_nomor");
                String kapasitas = hasil.getString("kapasitas");
                String tarif = hasil.getString("harga_mobil");
                String status = hasil.getString("status");

                // Mengambil data gambar dari database
                byte[] gambarBytes = hasil.getBytes("gambar");
                ImageIcon gambarIcon = null;

                if (gambarBytes != null && gambarBytes.length > 0) {
                    Image img = Toolkit.getDefaultToolkit().createImage(gambarBytes);
                    Image resizedImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    gambarIcon = new ImageIcon(resizedImg);
                }

                // Tambahkan baris ke model tabel
                tabelModel.addRow(new Object[]{id, merek, jenis, platNomor, kapasitas, tarif, status, gambarIcon});
            }

            tabelMobil.setModel(tabelModel);

            // Mengatur lebar kolom
            tabelMobil.getColumnModel().getColumn(0).setMaxWidth(60);
            tabelMobil.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabelMobil.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabelMobil.getColumnModel().getColumn(3).setPreferredWidth(300);
            tabelMobil.getColumnModel().getColumn(7).setPreferredWidth(60);

            // Tambahkan renderer untuk kolom gambar
            tabelMobil.getColumnModel().getColumn(7).setCellRenderer(new TableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = new JLabel();
                    if (value instanceof ImageIcon) {
                        label.setIcon((ImageIcon) value);
                    }
                    label.setHorizontalAlignment(JLabel.CENTER);
                    return label;
                }
            });

            tabelMobil.revalidate();
            tabelMobil.repaint();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal dipanggil: " + e.getMessage());
        }
    }

    private void autoNumber(FormMobil tambah) {
        try {
            String sql = "SELECT id_mobil FROM mobil ORDER BY id_mobil DESC LIMIT 1"; // Mengambil ID terakhir
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Asumsikan default ID jika tidak ada entri di tabel
            String nextID = "MB0001";

            if (rs.next()) {
                String id_mobil = rs.getString("id_mobil").substring(2); // Mengambil ID tanpa awalan "MB"
                int Angka = Integer.parseInt(id_mobil) + 1; // Menaikkan angka

                // Menentukan jumlah nol di depan berdasarkan nilai Angka
                String Nol = String.format("%03d", Angka); // Membuat format string "000", "00", "0", atau "" sesuai dengan nilai Angka
                nextID = "MB" + Nol; // Membuat ID baru
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
        tabelMobil = new maulana.swing.TabelFlatLaf();
        buttonAction1 = new maulana.swing.ButtonActionFlatLaf();
        buttonAction2 = new maulana.swing.ButtonActionFlatLaf();
        buttonAction3 = new maulana.swing.ButtonActionFlatLaf();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Data Mobil");

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCari.setMargin(new java.awt.Insets(2, 2, 2, 6));
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        tabelMobil.setModel(new javax.swing.table.DefaultTableModel(
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
        scroll.setViewportView(tabelMobil);

        buttonAction1.setText("TAMBAH");
        buttonAction1.setMargin(new java.awt.Insets(2, 10, 2, 10));
        buttonAction1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction1ActionPerformed(evt);
            }
        });

        buttonAction2.setText("EDIT");
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
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 492, Short.MAX_VALUE)
                        .addComponent(buttonAction3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAction2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(buttonAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAction2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAction3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
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

    // Method untuk format Rupiah
    private String formatRupiah(String tarif) {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        int intTarif = Integer.parseInt(tarif);
        return format.format(intTarif);
    }

    private byte[] convertToBytes(ImageIcon icon) {
        try {
            BufferedImage bufferdImage = new BufferedImage(
                    icon.getIconWidth(),
                    icon.getIconHeight(),
                    BufferedImage.TYPE_INT_RGB
            );
            Graphics g = bufferdImage.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferdImage, "jpg", baos);
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        dataTabel();
    }//GEN-LAST:event_txtCariKeyReleased

    private void buttonAction1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction1ActionPerformed
        FormMobil tambahDataMobil = new FormMobil();
        autoNumber(tambahDataMobil);
        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Batal", "Simpan"};
        GlassPanePopup.showPopup(new SimplePopupBorder(tambahDataMobil, "Tambah mobil", actions, (pc, i) -> {
            if (i == 1) {
                // Ambil data dari form
                String id = tambahDataMobil.getTxtID();
                String merek = tambahDataMobil.getTxtMerek();
                String jenis = tambahDataMobil.getTxtJenis();
                String platNomer = tambahDataMobil.getTxtPlatNomer();
                String kapasitas = tambahDataMobil.getTxtKapasitas();
                String tarif = tambahDataMobil.getTxtTarif();
                String status = tambahDataMobil.getSelectedStatus();
                byte[] gambar = tambahDataMobil.getGambarBytes(); // Mengambil gambar dalam bentuk byte array

                // Validasi data
                if (id.isEmpty() || merek.isEmpty() || jenis.isEmpty() || platNomer.isEmpty() || kapasitas.isEmpty() || tarif.isEmpty()) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, "Semua field harus diisi!");
                    return;
                }

                if (gambar == null || gambar.length == 0) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, "Gambar mobil harus dipilih!");
                    return;
                }

                // Tambahkan data ke tabel
                DefaultTableModel model = (DefaultTableModel) tabelMobil.getModel();
                model.addRow(new Object[]{id, merek, jenis, platNomer, kapasitas, formatRupiah(tarif), status, gambar});

                // Simpan data ke database dengan PreparedStatement
                String query = "INSERT INTO mobil (id_mobil, merek, jenis, plat_nomor, kapasitas, harga_mobil, status, gambar) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = koneksi.prepareStatement(query)) {
                    preparedStatement.setString(1, id);
                    preparedStatement.setString(2, merek);
                    preparedStatement.setString(3, jenis);
                    preparedStatement.setString(4, platNomer);
                    preparedStatement.setInt(5, Integer.parseInt(kapasitas));
                    preparedStatement.setInt(6, Integer.parseInt(tarif));
                    preparedStatement.setString(7, status);
                    preparedStatement.setBytes(8, gambar); // Menyimpan gambar sebagai BLOB

                    preparedStatement.executeUpdate();
                    dataTabel();
                    pc.closePopup();
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data mobil berhasil ditambahkan");
                } catch (Exception e) {
                    e.printStackTrace();
                    Notifications.getInstance().show(Notifications.Type.ERROR, "Data mobil gagal ditambahkan!");
                }
            } else {
                pc.closePopup();
            }
        }), option);
    }//GEN-LAST:event_buttonAction1ActionPerformed

    private void buttonAction2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction2ActionPerformed
        // Pastikan pengguna memilih baris yang akan di-edit
        int selectedRow = tabelMobil.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin di-edit terlebih dahulu!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Ambil data dari baris yang dipilih
        String id = tabelMobil.getValueAt(selectedRow, 0).toString();
        String merek = tabelMobil.getValueAt(selectedRow, 1).toString();
        String jenis = tabelMobil.getValueAt(selectedRow, 2).toString();
        String platNomor = tabelMobil.getValueAt(selectedRow, 3).toString();
        String kapasitas = tabelMobil.getValueAt(selectedRow, 4).toString();
        String tarif = tabelMobil.getValueAt(selectedRow, 5).toString();
        String status = tabelMobil.getValueAt(selectedRow, 6).toString();
        ImageIcon gambar = (ImageIcon) tabelMobil.getValueAt(selectedRow, 7);

        // Buat form mobil dan set data yang diambil dari tabel
        FormMobil edit = new FormMobil();
        edit.setTxtID(id);
        edit.setTxtMerek(merek);
        edit.setTxtJenis(jenis);
        edit.setTxtPlatNomer(platNomor);
        edit.setTxtKapasitas(kapasitas);
        edit.setTxtTarif(tarif);
        edit.setSelectedStatus(status);
        if (gambar != null) {
            edit.setGambar(gambar);
        }

        // Tampilkan popup untuk mengedit data
        DefaultOption option = new DefaultOption() {
            @Override
            public boolean closeWhenClickOutside() {
                return true;
            }
        };
        String actions[] = new String[]{"Batal", "Simpan"};

        GlassPanePopup.showPopup(new SimplePopupBorder(edit, "Edit Mobil", actions, (pc, i) -> {
            if (i == 1) {
                // Ambil data yang telah diedit dari form
                String newID = edit.getTxtID();
                String newMerek = edit.getTxtMerek();
                String newJenis = edit.getTxtJenis();
                String newPlatNomer = edit.getTxtPlatNomer();
                String newKapasitas = edit.getTxtKapasitas();
                String newTarif = edit.getTxtTarif();
                String newStatus = edit.getSelectedStatus();
                byte[] gambarBytes = edit.getGambarBytes();

                try {
                    // Simpan data yang telah diedit ke database
                    String query = "UPDATE mobil SET merek = ?, jenis = ?, plat_nomor = ?, kapasitas = ?, harga_mobil = ?, status = ?, gambar = ? WHERE id_mobil = ?";
                    PreparedStatement preparedStatement = koneksi.prepareStatement(query);
                    preparedStatement.setString(1, newMerek);
                    preparedStatement.setString(2, newJenis);
                    preparedStatement.setString(3, newPlatNomer);
                    preparedStatement.setString(4, newKapasitas);
                    preparedStatement.setString(5, newTarif);
                    preparedStatement.setString(6, newStatus);
                    preparedStatement.setBytes(7, gambarBytes);
                    preparedStatement.setString(8, newID);
                    preparedStatement.executeUpdate();

                    // Perbarui data yang telah diedit di tabel
                    DefaultTableModel model = (DefaultTableModel) tabelMobil.getModel();
                    model.setValueAt(newMerek, selectedRow, 1);
                    model.setValueAt(newJenis, selectedRow, 2);
                    model.setValueAt(newPlatNomer, selectedRow, 3);
                    model.setValueAt(newKapasitas, selectedRow, 4);
                    model.setValueAt(newTarif, selectedRow, 5);
                    model.setValueAt(newStatus, selectedRow, 6);
                    model.setValueAt(gambarBytes, selectedRow, 7);

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
    }//GEN-LAST:event_buttonAction2ActionPerformed

    private void buttonAction3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction3ActionPerformed
        int selectedRow = tabelMobil.getSelectedRow();

        // Periksa apakah ada baris yang dipilih
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Silakan pilih mobil yang ingin dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Ambil ID mobil yang dipilih
        String idMobil = tabelMobil.getValueAt(selectedRow, 0).toString();

        // Konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data mobil dengan ID: " + idMobil + "?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Hapus data dari database
                String query = "DELETE FROM mobil WHERE id_mobil = '" + idMobil + "'";
                Statement statement = koneksi.createStatement();
                statement.executeUpdate(query);

                // Hapus baris dari tabel
                ((DefaultTableModel) tabelMobil.getModel()).removeRow(selectedRow);

                // Tampilkan notifikasi sukses
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Data mobil berhasil dihapus");
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
    private maulana.swing.TabelFlatLaf tabelMobil;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
