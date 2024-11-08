package maulana.tampilan.popup;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import maulana.koneksi.KoneksiDB;
import maulana.tampilan.data.Pemesanan;

/**
 *
 * @author mmaul
 */
public class PopUpDataPelanggan extends javax.swing.JPanel {

    private Connection koneksi = new KoneksiDB().connect();
    private DefaultTableModel tabmode;
    public Pemesanan pelanggan = null;

    public PopUpDataPelanggan() {
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
                + "background:$Panel.background");
    }

    private void dataTable() {
        Object[] baris = {"NIK", "N0. SIM", "NAMA", "NO. TELEPON", "ALAMAT"};
        tabmode = new DefaultTableModel(null, baris);
        String cariItem = txtCari.getText();
        try {
            String sql = "SELECT * FROM pelanggan WHERE nik LIKE '%" + cariItem + "%' OR nama_pelanggan LIKE '%" + cariItem + "%' ORDER BY nik ASC";
            Statement stat = koneksi.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5)
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPelanggan = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(52, 52, 52));

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
        jScrollPane1.setViewportView(tblPelanggan);

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tblPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPelangganMouseClicked
        int tabelPelanggan = tblPelanggan.getSelectedRow();
        pelanggan.nik = tblPelanggan.getValueAt(tabelPelanggan, 0).toString();
        pelanggan.noSim = tblPelanggan.getValueAt(tabelPelanggan, 1).toString();
        pelanggan.namaPelanggan = tblPelanggan.getValueAt(tabelPelanggan, 2).toString();
        pelanggan.noTelepon = tblPelanggan.getValueAt(tabelPelanggan, 3).toString();
        pelanggan.alamatPelanggan = tblPelanggan.getValueAt(tabelPelanggan, 4).toString();
        pelanggan.itemTerpilihPelanggan();
        
    }//GEN-LAST:event_tblPelangganMouseClicked

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        dataTable();
    }//GEN-LAST:event_txtCariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPelanggan;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
