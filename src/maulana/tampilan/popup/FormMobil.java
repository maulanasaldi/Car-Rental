package maulana.tampilan.popup;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FormMobil extends javax.swing.JPanel {

    private byte[] gambarBytes;

    public String getTxtID() {
        return txtID.getText();
    }

    public void setTxtID(String id) {
        txtID.setText(id);
    }

    public String getTxtMerek() {
        return txtMerek.getText();
    }

    public void setTxtMerek(String merek) {
        txtMerek.setText(merek);
    }

    public String getTxtJenis() {
        return txtJenis.getText();
    }

    public void setTxtJenis(String jenis) {
        txtJenis.setText(jenis);
    }

    public String getTxtPlatNomer() {
        return txtPlatNomer.getText();
    }

    public void setTxtPlatNomer(String platNomer) {
        txtPlatNomer.setText(platNomer);
    }

    public String getTxtKapasitas() {
        return txtKapasitas.getText();
    }

    public void setTxtKapasitas(String kapasitas) {
        txtKapasitas.setText(kapasitas);
    }

    public String getTxtTarif() {
        return txtTarif.getText();
    }

    public void setTxtTarif(String tarif) {
        txtTarif.setText(tarif);
    }

    public String getSelectedStatus() {
        if (rbTersedia.isSelected()) {
            return "Tersedia";
        } else if (rbTidakTersedia.isSelected()) {
            return "Tidak Tersedai";
        }
        return null;
    }

    public void setSelectedStatus(String status) {
        if (status.equalsIgnoreCase("Tersedia")) {
            rbTersedia.setSelected(true);
        } else if (status.equalsIgnoreCase("Tidak Tersedia")) {
            rbTidakTersedia.setSelected(true);
        }
    }

    public void setGambar(ImageIcon gambar) {
        lblImagePreview.setIcon(gambar); // lblImagePreview adalah JLabel untuk menampilkan gambar
    }

    public ImageIcon getGambar() {
        return (ImageIcon) lblImagePreview.getIcon();
    }

    public byte[] getGambarBytes() {
        return gambarBytes;
    }

    public FormMobil() {
        initComponents();

    }

    private void chooseImage(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                // Tampilkan gambar
                ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                Image scaledImage = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                lblImagePreview.setIcon(new ImageIcon(scaledImage));

                // Simpan gambar sebagai byte array untuk disimpan ke database
                gambarBytes = Files.readAllBytes(selectedFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtMerek = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtJenis = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rbTersedia = new javax.swing.JRadioButton();
        rbTidakTersedia = new javax.swing.JRadioButton();
        txtPlatNomer = new javax.swing.JTextField();
        txtKapasitas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTarif = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lblImagePreview = new javax.swing.JLabel();
        btnPilihGambar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID");

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtID.setEnabled(false);
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDKeyPressed(evt);
            }
        });

        txtMerek.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMerek.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMerekKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Merek");

        txtJenis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtJenis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJenisKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Jenis");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Plat Nomer");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Status");

        buttonGroup1.add(rbTersedia);
        rbTersedia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbTersedia.setText("Tersedia");
        rbTersedia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rbTersediaKeyPressed(evt);
            }
        });

        buttonGroup1.add(rbTidakTersedia);
        rbTidakTersedia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbTidakTersedia.setText("Tidak Tersedia");
        rbTidakTersedia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rbTidakTersediaKeyPressed(evt);
            }
        });

        txtPlatNomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPlatNomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPlatNomerKeyPressed(evt);
            }
        });

        txtKapasitas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtKapasitas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKapasitasKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Kapasitas");

        txtTarif.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTarif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTarifKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Tarif");

        lblImagePreview.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnPilihGambar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPilihGambar.setText("Pilih Gambar");
        btnPilihGambar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihGambarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Gambar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbTersedia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbTidakTersedia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE))
                            .addComponent(txtID)
                            .addComponent(txtMerek)
                            .addComponent(txtJenis)
                            .addComponent(txtPlatNomer, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtKapasitas, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTarif, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPilihGambar)
                            .addComponent(lblImagePreview, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMerek))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtJenis)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlatNomer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKapasitas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTersedia, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(rbTidakTersedia, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImagePreview, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPilihGambar)))
                .addGap(58, 58, 58))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtMerek.requestFocus();
        }
    }//GEN-LAST:event_txtIDKeyPressed

    private void txtMerekKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMerekKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtJenis.requestFocus();
        }
    }//GEN-LAST:event_txtMerekKeyPressed

    private void txtJenisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJenisKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPlatNomer.requestFocus();
        }
    }//GEN-LAST:event_txtJenisKeyPressed

    private void rbTidakTersediaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbTidakTersediaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtJenis.requestFocus();
        }
    }//GEN-LAST:event_rbTidakTersediaKeyPressed

    private void rbTersediaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbTersediaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtJenis.requestFocus();
        }
    }//GEN-LAST:event_rbTersediaKeyPressed

    private void txtPlatNomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlatNomerKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtKapasitas.requestFocus();
        }
    }//GEN-LAST:event_txtPlatNomerKeyPressed

    private void txtKapasitasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKapasitasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtTarif.requestFocus();
        }
    }//GEN-LAST:event_txtKapasitasKeyPressed

    private void txtTarifKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTarifKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            rbTersedia.requestFocus();
        }
    }//GEN-LAST:event_txtTarifKeyPressed

    private void btnPilihGambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihGambarActionPerformed
        chooseImage(evt);
    }//GEN-LAST:event_btnPilihGambarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPilihGambar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblImagePreview;
    private javax.swing.JRadioButton rbTersedia;
    private javax.swing.JRadioButton rbTidakTersedia;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JTextField txtKapasitas;
    private javax.swing.JTextField txtMerek;
    private javax.swing.JTextField txtPlatNomer;
    private javax.swing.JTextField txtTarif;
    // End of variables declaration//GEN-END:variables
}
