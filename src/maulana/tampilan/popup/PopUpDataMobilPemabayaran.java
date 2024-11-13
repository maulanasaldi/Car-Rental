/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maulana.tampilan.popup;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import maulana.koneksi.KoneksiDB;
import maulana.tampilan.data.Pembayaran;

/**
 *
 * @author mmaul
 */
public class PopUpDataMobilPemabayaran extends javax.swing.JPanel {

    private Connection koneksi = new KoneksiDB().connect();
    private DefaultTableModel tabmode;    
    public Pembayaran mobilPembayaran = null;
    private JDialog parentDialog;

    public PopUpDataMobilPemabayaran(JDialog dialog) {
        this.parentDialog = dialog;
        initComponents();
        dataTable();
        init();
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
    }

    private void dataTable() {
        Object[] baris = {"ID MOBIL", "MEREK", "JENIS", "PLAT NOMOR", "KAPASITAS", "TARIF", "STATUS", "GAMBAR"};
        tabmode = new DefaultTableModel(null, baris);
        String cariItem = txtCari.getText();
        try {
            // Modifikasi query untuk memilih data gambar (kolom gambar bisa diberi nama 'gambar' dalam database)
            String sql = "SELECT id_mobil, merek, jenis, plat_nomor, kapasitas, harga_mobil, status, gambar FROM mobil WHERE id_mobil LIKE '%" + cariItem + "%' OR merek LIKE '%" + cariItem + "%' ORDER BY id_mobil ASC";
            Statement stat = koneksi.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                // Mengambil gambar dalam bentuk BLOB
                Blob blob = hasil.getBlob("gambar");
                ImageIcon imageIcon = null;
                if (blob != null) {
                    byte[] imgData = blob.getBytes(1, (int) blob.length());
                    Image image = Toolkit.getDefaultToolkit().createImage(imgData);
                    imageIcon = new ImageIcon(image);
                }

                // Menambahkan data ke dalam tabel
                tabmode.addRow(new Object[]{
                    hasil.getString(1), // ID Mobil
                    hasil.getString(2), // Merek
                    hasil.getString(3), // Jenis
                    hasil.getString(4), // Plat Nomor
                    hasil.getString(5), // Kapasitas
                    hasil.getString(6), // Tarif
                    hasil.getString(7), // Status
                    imageIcon // Gambar
                });
            }
            tblMobil.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal dipanggil: " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMobil = new maulana.swing.TabelFlatLaf();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setLayout(new java.awt.BorderLayout());

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        tblMobil.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMobil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMobilMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblMobil);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        dataTable();
    }//GEN-LAST:event_txtCariKeyReleased

    private void tblMobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMobilMouseClicked
// Mendapatkan baris yang dipilih
        int selectedRow = tblMobil.getSelectedRow();
        if (selectedRow >= 0) {            
            // Mengambil data dari tabel ke dalam objek mobil pembayaran
            mobilPembayaran.idMobil = tblMobil.getValueAt(selectedRow, 0).toString();
            mobilPembayaran.merek = tblMobil.getValueAt(selectedRow, 1).toString();
            mobilPembayaran.jenis = tblMobil.getValueAt(selectedRow, 2).toString();
            mobilPembayaran.platNomor = tblMobil.getValueAt(selectedRow, 3).toString();
            mobilPembayaran.kapasitas = tblMobil.getValueAt(selectedRow, 4).toString();
            mobilPembayaran.tarif = tblMobil.getValueAt(selectedRow, 5).toString();
            mobilPembayaran.status = tblMobil.getValueAt(selectedRow, 6).toString();

            // Mengambil gambar dari kolom "GAMBAR" (kolom ke-7)
            ImageIcon imageIconMobilPembayaran = (ImageIcon) tblMobil.getValueAt(selectedRow, 7);

            // Jika gambar ada, kirim ke kelas Pesanan untuk diupdate
            if (imageIconMobilPembayaran != null) {
                int fixedWidth = 212;
                int fixedHeight = 264;

                Image scaledImage = imageIconMobilPembayaran.getImage().getScaledInstance(fixedWidth, fixedHeight, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(scaledImage);

                // Misalnya, Pesanan adalah instance objek dari kelas Pesanan
                mobilPembayaran.setLblGambar(resizedIcon); // Update gambar di lblGambar
            } else {
                mobilPembayaran.setLblGambar(null); // Set null jika tidak ada gambar
            }

            // Panggil method untuk menangani item terpilih
            mobilPembayaran.itemTerpilihMobil();
            parentDialog.dispose();
        }
    }//GEN-LAST:event_tblMobilMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private maulana.swing.TabelFlatLaf tblMobil;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
