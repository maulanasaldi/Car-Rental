package maulana.panel.report;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import maulana.koneksi.KoneksiDB;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleDocxReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import raven.toast.Notifications;

public class ReportPelanggan extends javax.swing.JPanel {

    private Connection koneksi = new KoneksiDB().connect();
    private DefaultTableModel model;

    public ReportPelanggan() {
        initComponents();
        model = new DefaultTableModel();
        tabel.setModel(model);

        model.addColumn("NIK");
        model.addColumn("No SIM");
        model.addColumn("Nama Pelanggan");
        model.addColumn("No Telepon");
        model.addColumn("alamat");

        loadDataPelanggan();
    }

    private void loadDataPelanggan() {
        model.setRowCount(0); // Bersihkan data tabel

        try {
            Connection conn = new KoneksiDB().connect();
            String sql = "SELECT nik, no_sim, nama_pelanggan, notlpn_pelanggan, alamat_pelanggan FROM pelanggan";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Object[] rowData = {
                    rs.getString("nik"),
                    rs.getString("no_sim"),
                    rs.getString("nama_pelanggan"),
                    rs.getString("notlpn_pelanggan"),
                    rs.getString("alamat_pelanggan")
                };
                model.addRow(rowData);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error saat mengambil data pelanggan: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new maulana.swing.TabelFlatLaf();
        jLabel1 = new javax.swing.JLabel();
        buttonAction1 = new maulana.swing.ButtonActionFlatLaf();
        buttonAction2 = new maulana.swing.ButtonActionFlatLaf();
        buttonAction3 = new maulana.swing.ButtonActionFlatLaf();
        buttonAction4 = new maulana.swing.ButtonActionFlatLaf();

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Report Pelanggan");

        buttonAction1.setText("LIHAT");
        buttonAction1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction1ActionPerformed(evt);
            }
        });

        buttonAction2.setText("CETAK KE PDF");
        buttonAction2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction2ActionPerformed(evt);
            }
        });

        buttonAction3.setText("CETAK KE WORD");
        buttonAction3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction3ActionPerformed(evt);
            }
        });

        buttonAction4.setText("CETAK KE EXCEL");
        buttonAction4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonAction4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAction3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAction2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAction2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAction3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAction4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAction1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction1ActionPerformed
        try {
            // Path dari file .jasper hasil kompilasi file .jrxml
            String reportPath = "src/maulana/report/ReportPelanggan.jasper";

            // Membuat koneksi database
            Connection conn = new KoneksiDB().connect();

            // Parameter laporan jika ada (kita bisa menambahkan parameter yang dibutuhkan)
            Map<String, Object> parameters = new HashMap<>();

            // Mengisi laporan dengan data dari database
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parameters, conn);

            // Menampilkan laporan dalam viewer
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException e) {
            System.out.println("Error saat menampilkan laporan: " + e.getMessage());
        }
    }//GEN-LAST:event_buttonAction1ActionPerformed

    private void buttonAction2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction2ActionPerformed
        // Path ke file .jasper (file laporan yang telah dikompilasi)
        String reportPath = "src/maulana/report/ReportPelanggan.jasper"; // Ganti dengan path file .jasper Anda

        try {
            // Load file laporan yang telah dikompilasi
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportPath);

            // Mengisi laporan dengan data (parameter bisa disesuaikan)
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), koneksi);

            // Membuat instance JFileChooser
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Pilih Lokasi untuk Menyimpan Laporan");

            // Mengatur tipe file filter agar hanya menyimpan file Excel
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setSelectedFile(new File("ReportPelanggan.pdf")); // Nama default untuk PDF

            // Menampilkan dialog simpan
            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                // Mengambil path file yang dipilih oleh user
                File fileToSave = fileChooser.getSelectedFile();

                // Memastikan file memiliki ekstensi .pdf
                String filePath = fileToSave.getAbsolutePath();
                if (!filePath.endsWith(".pdf")) {
                    filePath += ".pdf";
                }

                // Simpan laporan ke file yang dipilih
                JasperExportManager.exportReportToPdfFile(jasperPrint, filePath);
                // Tampilkan notifikasi sukses                
                JOptionPane.showMessageDialog(this, "Laporan berhasil disimpan di: " + filePath);
            }
        } catch (JRException e) {
            JOptionPane.showMessageDialog(this, "Gagal membuat atau menyimpan laporan: " + e.getMessage());
        }
    }//GEN-LAST:event_buttonAction2ActionPerformed

    private void buttonAction3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction3ActionPerformed
        // Path ke file .jasper (file laporan yang telah dikompilasi)
        String reportPath = "src/maulana/report/ReportPelanggan.jasper"; // Ganti dengan path file .jasper Anda

        try {
            // Load file laporan yang telah dikompilasi
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportPath);

            // Mengisi laporan dengan data (parameter bisa disesuaikan)
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), koneksi);

            // Membuat instance JFileChooser
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Pilih Lokasi untuk Menyimpan Laporan");

            // Mengatur tipe file filter agar hanya menyimpan file Word
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setSelectedFile(new File("ReportPelanggan.docx")); // Nama default untuk Word

            // Menampilkan dialog simpan
            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                // Mengambil path file yang dipilih oleh user
                File fileToSave = fileChooser.getSelectedFile();

                // Memastikan file memiliki ekstensi .docx
                String filePath = fileToSave.getAbsolutePath();
                if (!filePath.endsWith(".docx")) {
                    filePath += ".docx";
                }

                // Menggunakan JRDocxExporter untuk menyimpan laporan dalam format Word
                JRDocxExporter exporter = new JRDocxExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(filePath));

                // Konfigurasi laporan Word (opsional)
                SimpleDocxReportConfiguration configuration = new SimpleDocxReportConfiguration();
                exporter.setConfiguration(configuration);

                // Ekspor laporan ke Word
                exporter.exportReport();

                JOptionPane.showMessageDialog(this, "Laporan berhasil disimpan di: " + filePath);
            }
        } catch (JRException e) {
            JOptionPane.showMessageDialog(this, "Gagal membuat atau menyimpan laporan: " + e.getMessage());
        }
    }//GEN-LAST:event_buttonAction3ActionPerformed

    private void buttonAction4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAction4ActionPerformed
        // Path ke file .jasper (file laporan yang telah dikompilasi)
        String reportPath = "src/maulana/report/ReportPelanggan.jasper"; // Ganti dengan path file .jasper Anda

        try {
            // Load file laporan yang telah dikompilasi
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportPath);

            // Mengisi laporan dengan data (parameter bisa disesuaikan)
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), koneksi);

            // Membuat instance JFileChooser
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Pilih Lokasi untuk Menyimpan Laporan");

            // Mengatur tipe file filter agar hanya menyimpan file Excel
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setSelectedFile(new File("ReportPelanggan.xlsx")); // Nama default untuk Excel

            // Menampilkan dialog simpan
            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                // Mengambil path file yang dipilih oleh user
                File fileToSave = fileChooser.getSelectedFile();

                // Memastikan file memiliki ekstensi .xlsx
                String filePath = fileToSave.getAbsolutePath();
                if (!filePath.endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }

                // Menggunakan JRXlsxExporter untuk menyimpan laporan dalam format Excel
                JRXlsxExporter exporter = new JRXlsxExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(filePath));

                // Konfigurasi laporan Excel
                SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
                configuration.setOnePagePerSheet(false);
                configuration.setDetectCellType(true);
                configuration.setCollapseRowSpan(false);
                exporter.setConfiguration(configuration);

                // Ekspor laporan
                exporter.exportReport();

                JOptionPane.showMessageDialog(this, "Laporan berhasil disimpan di: " + filePath);
            }
        } catch (JRException e) {
            JOptionPane.showMessageDialog(this, "Gagal membuat atau menyimpan laporan: " + e.getMessage());
        }
    }//GEN-LAST:event_buttonAction4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private maulana.swing.ButtonActionFlatLaf buttonAction1;
    private maulana.swing.ButtonActionFlatLaf buttonAction2;
    private maulana.swing.ButtonActionFlatLaf buttonAction3;
    private maulana.swing.ButtonActionFlatLaf buttonAction4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private maulana.swing.TabelFlatLaf tabel;
    // End of variables declaration//GEN-END:variables
}
