package maulana.tampilan.popup;

import java.awt.event.KeyEvent;

public class FormKaryawan extends javax.swing.JPanel {

    public String getSelectedJabatan() {
        if (rbKaryawan.isSelected()) {
            return "Karyawan";
        } else if (rbOwner.isSelected()) {
            return "Owner";
        }
        return null;
    }

    public void setSelectedJabatan(String gender) {
        if (gender.equalsIgnoreCase("Karyawan")) {
            rbKaryawan.setSelected(true);
        } else if (gender.equalsIgnoreCase("Owner")) {
            rbOwner.setSelected(true);
        }
    }

    public String getTxtAlamat() {
        return txtAlamatKaryawan.getText();
    }

    public void setTxtAlamat(String alamat) {
        txtAlamatKaryawan.setText(alamat);
    }

    public String getTxtID() {
        return txtIDKaryawan.getText();
    }

    public void setTxtID(String id) {
        txtIDKaryawan.setText(id);
    }

    public String getTxtNama() {
        return txtIDKaryawan.getText();
    }

    public void setTxtNama(String nama) {
        txtIDKaryawan.setText(nama);
    }

    public String getTxtNoHP() {
        return txtNoTlpKaryawan.getText();
    }

    public void setTxtNoHP(String noHP) {
        txtNoTlpKaryawan.setText(noHP);
    }

    public String getTxtPassword() {
        return txtPassword.getText();
    }

    public void setTxtPassword(String password) {
        txtPassword.setText(password);
    }

    public FormKaryawan() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rbKaryawan = new javax.swing.JRadioButton();
        rbOwner = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtIDKaryawan = new maulana.swing.TextFieldFlatLaf();
        txtNamaKaryawan = new maulana.swing.TextFieldFlatLaf();
        txtNoTlpKaryawan = new maulana.swing.TextFieldFlatLaf();
        txtPassword = new maulana.swing.TextFieldFlatLaf();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAlamatKaryawan = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nama Lengkap");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Jabatan");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("No. Telepon");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Alamat");

        buttonGroup1.add(rbKaryawan);
        rbKaryawan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbKaryawan.setText("Karyawan");
        rbKaryawan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rbKaryawanKeyPressed(evt);
            }
        });

        buttonGroup1.add(rbOwner);
        rbOwner.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbOwner.setText("Owner");
        rbOwner.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rbOwnerKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Password");

        txtIDKaryawan.setEnabled(false);
        txtIDKaryawan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDKaryawanKeyPressed(evt);
            }
        });

        txtNoTlpKaryawan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoTlpKaryawanKeyPressed(evt);
            }
        });

        txtAlamatKaryawan.setColumns(20);
        txtAlamatKaryawan.setRows(5);
        jScrollPane2.setViewportView(txtAlamatKaryawan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNoTlpKaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(txtIDKaryawan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNamaKaryawan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbKaryawan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbOwner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbKaryawan)
                    .addComponent(rbOwner))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoTlpKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rbKaryawanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbKaryawanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNoTlpKaryawan.requestFocus();
        }
    }//GEN-LAST:event_rbKaryawanKeyPressed

    private void rbOwnerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbOwnerKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNoTlpKaryawan.requestFocus();
        }
    }//GEN-LAST:event_rbOwnerKeyPressed

    private void txtIDKaryawanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKaryawanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNamaKaryawan.requestFocus();
        }
    }//GEN-LAST:event_txtIDKaryawanKeyPressed

    private void txtNoTlpKaryawanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoTlpKaryawanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtAlamatKaryawan.requestFocus();
        }
    }//GEN-LAST:event_txtNoTlpKaryawanKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbKaryawan;
    private javax.swing.JRadioButton rbOwner;
    private javax.swing.JTextArea txtAlamatKaryawan;
    private maulana.swing.TextFieldFlatLaf txtIDKaryawan;
    private maulana.swing.TextFieldFlatLaf txtNamaKaryawan;
    private maulana.swing.TextFieldFlatLaf txtNoTlpKaryawan;
    private maulana.swing.TextFieldFlatLaf txtPassword;
    // End of variables declaration//GEN-END:variables
}
