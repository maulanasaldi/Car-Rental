package maulana.tampilan.data;

import com.formdev.flatlaf.FlatClientProperties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import maulana.koneksi.KoneksiDB;

public class Dashboard extends javax.swing.JPanel {

    private Connection koneksi = new KoneksiDB().connect();

    public Dashboard() {
        initComponents();
        init();
        updateCounts();
    }

    private void init() {
        card1.putClientProperty(FlatClientProperties.STYLE, "arc:20;");
        card2.putClientProperty(FlatClientProperties.STYLE, "arc:20;");
        card3.putClientProperty(FlatClientProperties.STYLE, "arc:20;");
    }

    // Metode untuk menghitung jumlah data di tabel tertentu
    private int getDataCount(String tableName) {
        int count = 0;
        String query = "SELECT COUNT(*) AS total FROM " + tableName;
        try (PreparedStatement stmt = koneksi.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    // Metode untuk mengupdate label
    public void updateCounts() {
        lblTotalPelanggan.setText(String.valueOf(getDataCount("pelanggan")));
        lblTotalSupir.setText(String.valueOf(getDataCount("supir")));
        lblTotalMobil.setText(String.valueOf(getDataCount("mobil")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chartJumlahPenyewa1 = new maulana.komponen.ChartJumlahPenyewa();
        card1 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();
        lblTotalPelanggan = new javax.swing.JLabel();
        lbDescription = new javax.swing.JLabel();
        card2 = new javax.swing.JPanel();
        lbTitle1 = new javax.swing.JLabel();
        lbIcon1 = new javax.swing.JLabel();
        lblTotalSupir = new javax.swing.JLabel();
        lbDescription1 = new javax.swing.JLabel();
        card3 = new javax.swing.JPanel();
        lbTitle2 = new javax.swing.JLabel();
        lbIcon2 = new javax.swing.JLabel();
        lblTotalMobil = new javax.swing.JLabel();
        lbDescription2 = new javax.swing.JLabel();

        javax.swing.GroupLayout chartJumlahPenyewa1Layout = new javax.swing.GroupLayout(chartJumlahPenyewa1);
        chartJumlahPenyewa1.setLayout(chartJumlahPenyewa1Layout);
        chartJumlahPenyewa1Layout.setHorizontalGroup(
            chartJumlahPenyewa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chartJumlahPenyewa1Layout.setVerticalGroup(
            chartJumlahPenyewa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );

        card1.setBackground(new java.awt.Color(51, 51, 51));

        lbTitle.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(190, 190, 190));
        lbTitle.setText("Pelanggan");

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maulana/icon/customer64.png"))); // NOI18N

        lblTotalPelanggan.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lblTotalPelanggan.setForeground(new java.awt.Color(190, 190, 190));
        lblTotalPelanggan.setText("0");

        lbDescription.setForeground(new java.awt.Color(190, 190, 190));
        lbDescription.setText("Total Mobil");
        lbDescription.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));

        javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
        card1.setLayout(card1Layout);
        card1Layout.setHorizontalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle)
                    .addGroup(card1Layout.createSequentialGroup()
                        .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDescription)
                            .addComponent(lblTotalPelanggan))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(card1Layout.createSequentialGroup()
                        .addComponent(lblTotalPelanggan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        card2.setBackground(new java.awt.Color(51, 51, 51));

        lbTitle1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTitle1.setForeground(new java.awt.Color(190, 190, 190));
        lbTitle1.setText("Supir");

        lbIcon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maulana/icon/chauffeur.png"))); // NOI18N

        lblTotalSupir.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lblTotalSupir.setForeground(new java.awt.Color(190, 190, 190));
        lblTotalSupir.setText("0");

        lbDescription1.setForeground(new java.awt.Color(190, 190, 190));
        lbDescription1.setText("Total Supir");
        lbDescription1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));

        javax.swing.GroupLayout card2Layout = new javax.swing.GroupLayout(card2);
        card2.setLayout(card2Layout);
        card2Layout.setHorizontalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle1)
                    .addGroup(card2Layout.createSequentialGroup()
                        .addComponent(lbIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDescription1)
                            .addComponent(lblTotalSupir))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        card2Layout.setVerticalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(card2Layout.createSequentialGroup()
                        .addComponent(lblTotalSupir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDescription1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        card3.setBackground(new java.awt.Color(51, 51, 51));

        lbTitle2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTitle2.setForeground(new java.awt.Color(190, 190, 190));
        lbTitle2.setText("Mobil");

        lbIcon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/maulana/icon/car64.png"))); // NOI18N

        lblTotalMobil.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lblTotalMobil.setForeground(new java.awt.Color(190, 190, 190));
        lblTotalMobil.setText("0");

        lbDescription2.setForeground(new java.awt.Color(190, 190, 190));
        lbDescription2.setText("Total Mobil");
        lbDescription2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));

        javax.swing.GroupLayout card3Layout = new javax.swing.GroupLayout(card3);
        card3.setLayout(card3Layout);
        card3Layout.setHorizontalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle2)
                    .addGroup(card3Layout.createSequentialGroup()
                        .addComponent(lbIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDescription2)
                            .addComponent(lblTotalMobil))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        card3Layout.setVerticalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(card3Layout.createSequentialGroup()
                        .addComponent(lblTotalMobil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDescription2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chartJumlahPenyewa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chartJumlahPenyewa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel card3;
    private maulana.komponen.ChartJumlahPenyewa chartJumlahPenyewa1;
    private javax.swing.JLabel lbDescription;
    private javax.swing.JLabel lbDescription1;
    private javax.swing.JLabel lbDescription2;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbIcon1;
    private javax.swing.JLabel lbIcon2;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTitle1;
    private javax.swing.JLabel lbTitle2;
    private javax.swing.JLabel lblTotalMobil;
    private javax.swing.JLabel lblTotalPelanggan;
    private javax.swing.JLabel lblTotalSupir;
    // End of variables declaration//GEN-END:variables
}
