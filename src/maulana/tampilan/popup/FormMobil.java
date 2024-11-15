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
        return txtIDMobil.getText();
    }

    public void setTxtID(String id) {
        txtIDMobil.setText(id);
    }

    public String getTxtMerek() {
        return txtMerekMobil.getText();
    }

    public void setTxtMerek(String merek) {
        txtMerekMobil.setText(merek);
    }

    public String getTxtJenis() {
        return txtJenisMobil.getText();
    }

    public void setTxtJenis(String jenis) {
        txtJenisMobil.setText(jenis);
    }

    public String getTxtPlatNomer() {
        return txtPlatNomor.getText();
    }

    public void setTxtPlatNomer(String platNomer) {
        txtPlatNomor.setText(platNomer);
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
                // Membaca file gambar yang dipilih
                ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());

                // Menyesuaikan gambar dengan ukuran JLabel (lblImagePreview)
                Image img = imageIcon.getImage();
                Image scaledImg = img.getScaledInstance(lblImagePreview.getWidth(), lblImagePreview.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImg);

                // Menampilkan gambar pada lblImagePreview
                lblImagePreview.setIcon(scaledIcon);

                // Menyimpan gambar sebagai byte array untuk disimpan ke database
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
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rbTersedia = new javax.swing.JRadioButton();
        rbTidakTersedia = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblImagePreview = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIDMobil = new maulana.swing.TextFieldFlatLaf();
        txtMerekMobil = new maulana.swing.TextFieldFlatLaf();
        txtJenisMobil = new maulana.swing.TextFieldFlatLaf();
        txtPlatNomor = new maulana.swing.TextFieldFlatLaf();
        txtKapasitas = new maulana.swing.TextFieldFlatLaf();
        txtTarif = new maulana.swing.TextFieldFlatLaf();
        buttonActionFlatLaf1 = new maulana.swing.ButtonActionFlatLaf();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Merek");

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

        buttonGroup1.add(rbTidakTersedia);
        rbTidakTersedia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbTidakTersedia.setText("Tidak Tersedia");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Kapasitas");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Tarif");

        lblImagePreview.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Gambar");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        txtIDMobil.setEnabled(false);

        txtMerekMobil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMerekMobilKeyPressed(evt);
            }
        });

        txtJenisMobil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJenisMobilKeyPressed(evt);
            }
        });

        txtPlatNomor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPlatNomorKeyPressed(evt);
            }
        });

        txtKapasitas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKapasitasKeyPressed(evt);
            }
        });

        buttonActionFlatLaf1.setText("PILIH GAMBAR");
        buttonActionFlatLaf1.setMargin(new java.awt.Insets(2, 5, 2, 5));
        buttonActionFlatLaf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionFlatLaf1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonActionFlatLaf1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbTersedia, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbTidakTersedia)
                                .addGap(0, 11, Short.MAX_VALUE))
                            .addComponent(lblImagePreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMerekMobil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtJenisMobil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPlatNomor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKapasitas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTarif, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIDMobil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMerekMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJenisMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlatNomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKapasitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTersedia, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(rbTidakTersedia, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImagePreview, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonActionFlatLaf1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMerekMobilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMerekMobilKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtJenisMobil.requestFocus();
        }
    }//GEN-LAST:event_txtMerekMobilKeyPressed

    private void txtJenisMobilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJenisMobilKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPlatNomor.requestFocus();
        }
    }//GEN-LAST:event_txtJenisMobilKeyPressed

    private void txtPlatNomorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlatNomorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtKapasitas.requestFocus();
        }
    }//GEN-LAST:event_txtPlatNomorKeyPressed

    private void txtKapasitasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKapasitasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtTarif.requestFocus();
        }
    }//GEN-LAST:event_txtKapasitasKeyPressed

    private void buttonActionFlatLaf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionFlatLaf1ActionPerformed
        chooseImage(evt);
    }//GEN-LAST:event_buttonActionFlatLaf1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private maulana.swing.ButtonActionFlatLaf buttonActionFlatLaf1;
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
    private maulana.swing.TextFieldFlatLaf txtIDMobil;
    private maulana.swing.TextFieldFlatLaf txtJenisMobil;
    private maulana.swing.TextFieldFlatLaf txtKapasitas;
    private maulana.swing.TextFieldFlatLaf txtMerekMobil;
    private maulana.swing.TextFieldFlatLaf txtPlatNomor;
    private maulana.swing.TextFieldFlatLaf txtTarif;
    // End of variables declaration//GEN-END:variables
}
