package maulana.tampilan.data;

import maulana.tampilan.popup.FormMobil;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
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
        tabelMobil.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold;");
        tabelMobil.putClientProperty(FlatClientProperties.STYLE, ""
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
                String tarif = hasil.getString("tarif");
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
        tabelMobil = new javax.swing.JTable();
        btnTambah = new maulana.swing.Button();
        btnEdit = new maulana.swing.Button();
        btnHapus = new maulana.swing.Button();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Data Mobil");

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCari.setMargin(new java.awt.Insets(2, 2, 2, 6));
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        scroll.setBorder(null);

        tabelMobil.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelMobil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scroll.setViewportView(tabelMobil);
        if (tabelMobil.getColumnModel().getColumnCount() > 0) {
            tabelMobil.getColumnModel().getColumn(0).setMaxWidth(40);
            tabelMobil.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabelMobil.getColumnModel().getColumn(3).setPreferredWidth(300);
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
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll)
                .addGap(10, 10, 10))
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
                String query = "INSERT INTO mobil (id_mobil, merek, jenis, plat_nomor, kapasitas, tarif, status, gambar) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
    }//GEN-LAST:event_btnTambahActionPerformed

    // Method untuk format Rupiah
    private String formatRupiah(String tarif) {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        int intTarif = Integer.parseInt(tarif);
        return format.format(intTarif);
    }

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int selectedRow = tabelMobil.getSelectedRow();

        // Periksa apakah ada baris yang dipilih
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Silakan pilih mobil yang ingin dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Ambil ID mobil yang dipilih
        String idMobil = tabelMobil.getValueAt(selectedRow, 0).toString();

        // Konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus mobil dengan ID: " + idMobil + "?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
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
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
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

        // Ambil gambar dari kolom tabel
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

        // Set gambar pada form
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
                ImageIcon newGambar = edit.getGambar();

                try {
                    // Simpan data yang telah diedit ke database
                    String query = "UPDATE mobil SET merek = ?, jenis = ?, plat_nomor = ?, kapasitas = ?, tarif = ?, status = ? WHERE id_mobil = ?";
                    PreparedStatement preparedStatement = koneksi.prepareStatement(query);
                    preparedStatement.setString(1, newMerek);
                    preparedStatement.setString(2, newJenis);
                    preparedStatement.setString(3, newPlatNomer);
                    preparedStatement.setString(4, newKapasitas);
                    preparedStatement.setString(5, newTarif);
                    preparedStatement.setString(6, newStatus);
                    preparedStatement.setString(7, newID);
                    preparedStatement.executeUpdate();

                    // Perbarui data yang telah diedit di tabel
                    DefaultTableModel model = (DefaultTableModel) tabelMobil.getModel();
                    model.setValueAt(newMerek, selectedRow, 1);
                    model.setValueAt(newJenis, selectedRow, 2);
                    model.setValueAt(newPlatNomer, selectedRow, 3);
                    model.setValueAt(newKapasitas, selectedRow, 4);
                    model.setValueAt(newTarif, selectedRow, 5);
                    model.setValueAt(newStatus, selectedRow, 6);
                    model.setValueAt(newGambar, selectedRow, 7); // Update gambar jika diubah
                    
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
    private javax.swing.JTable tabelMobil;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
