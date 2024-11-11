package maulana.tampilan.popup;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import maulana.koneksi.KoneksiDB;
import maulana.tampilan.data.Pembayaran;

public class PopUpDataPemesanan extends javax.swing.JPanel {

    private Connection koneksi = new KoneksiDB().connect();
    private DefaultTableModel tabmode;
    public Pembayaran pemesanan = null;
    private JDialog parentDialog;

    public PopUpDataPemesanan(JDialog dialog) {
        this.parentDialog = dialog;
        initComponents();
        dataTable();
        init();
    }
    
    private void init(){
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
        Object[] baris = {"ID Pemesanan", "Nama Pelanggan", "NIK", "No. Tlp Pelanggan ", "Id Karyawan", "Tgl Pemesanan", "ID Mobil", "Harga", "Lama Sewa", "DP", "Total"};
        tabmode = new DefaultTableModel(null, baris);
        String cariItem = txtCari.getText();
        try {
            String sql = "SELECT * FROM pemesanan WHERE id_pemesanan LIKE '%" + cariItem + "%' OR nama_pelanggan LIKE '%" + cariItem + "%' ORDER BY id_pemesanan ASC";
            Statement stat = koneksi.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                tabmode.addRow(new Object[]{
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
            tblPelanggan.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal dipanggil" + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPelanggan = new maulana.swing.TabelFlatLaf();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setLayout(new java.awt.BorderLayout());

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        tblPelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPelangganMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPelanggan);

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

    private void tblPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPelangganMouseClicked
        int tabelPelanggan = tblPelanggan.getSelectedRow();
        pemesanan.idPesanan = tblPelanggan.getValueAt(tabelPelanggan, 0).toString();
        pemesanan.namaPelanggan = tblPelanggan.getValueAt(tabelPelanggan, 1).toString();
        pemesanan.noTlpnPelanggan = tblPelanggan.getValueAt(tabelPelanggan, 3).toString();
        pemesanan.idMobil = tblPelanggan.getValueAt(tabelPelanggan, 6).toString();
        pemesanan.hargaMobil = tblPelanggan.getValueAt(tabelPelanggan, 7).toString();
        pemesanan.lamaSewa = tblPelanggan.getValueAt(tabelPelanggan, 8).toString();
        pemesanan.dp = tblPelanggan.getValueAt(tabelPelanggan, 9).toString();
        pemesanan.totalHarga = Integer.parseInt(tblPelanggan.getValueAt(tabelPelanggan, 10).toString());       
        pemesanan.itemTerpilihPemesanan();        
        parentDialog.dispose();
    }//GEN-LAST:event_tblPelangganMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private maulana.swing.TabelFlatLaf tblPelanggan;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
