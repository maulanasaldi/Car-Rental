package maulana.tampilan.popup;

import java.awt.event.KeyEvent;

public class FormPelanggan extends javax.swing.JPanel {

    public String getTxtNIK() {
        return txtNikPelanggan.getText();
    }

    public void setTxtNIK(String nik) {
        txtNikPelanggan.setText(nik);
    }
    
    public String getTxtNoSim(){
        return txtNoSimPelanggan.getText();
    }
    
    public void setTxtNoSim(String noSim){
        txtNoSimPelanggan.setText(noSim);
    }
    
    public String getTxtNama() {
        return txtNamaPelanggan.getText();
    }

    public void setTxtNama(String nama) {
        txtNamaPelanggan.setText(nama);
    }        
    
    public String getTxtNoTelepon(){
        return txtNoTlpnPelanggan.getText();
    }
    
    public void setTxtNoTelepon(String noTelepon){
        txtNoTlpnPelanggan.setText(noTelepon);
    }        
    
    public String getTxtAlamat() {
        return txtAlamat.getText();
    }

    public void setTxtAlamat(String alamat) {
        txtAlamat.setText(alamat);
    }    
    

    public FormPelanggan() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNikPelanggan = new maulana.swing.TextFieldFlatLaf();
        txtNoSimPelanggan = new maulana.swing.TextFieldFlatLaf();
        txtNamaPelanggan = new maulana.swing.TextFieldFlatLaf();
        txtNoTlpnPelanggan = new maulana.swing.TextFieldFlatLaf();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("NIK");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nama Lengkap");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("No. Telepon");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Alamat");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("No. SIM");

        txtNikPelanggan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNikPelangganKeyPressed(evt);
            }
        });

        txtNoSimPelanggan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoSimPelangganKeyPressed(evt);
            }
        });

        txtNamaPelanggan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaPelangganKeyPressed(evt);
            }
        });

        txtNoTlpnPelanggan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoTlpnPelangganKeyPressed(evt);
            }
        });

        txtAlamat.setColumns(20);
        txtAlamat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtNoSimPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNamaPelanggan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNoTlpnPelanggan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNikPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNikPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoSimPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoTlpnPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNikPelangganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNikPelangganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {            
            txtNoSimPelanggan.requestFocus();
        }
    }//GEN-LAST:event_txtNikPelangganKeyPressed

    private void txtNoSimPelangganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoSimPelangganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNamaPelanggan.requestFocus();
        }
    }//GEN-LAST:event_txtNoSimPelangganKeyPressed

    private void txtNamaPelangganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaPelangganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNoTlpnPelanggan.requestFocus();
        }
    }//GEN-LAST:event_txtNamaPelangganKeyPressed

    private void txtNoTlpnPelangganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoTlpnPelangganKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtAlamat.requestFocus();
        }
    }//GEN-LAST:event_txtNoTlpnPelangganKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAlamat;
    private maulana.swing.TextFieldFlatLaf txtNamaPelanggan;
    private maulana.swing.TextFieldFlatLaf txtNikPelanggan;
    private maulana.swing.TextFieldFlatLaf txtNoSimPelanggan;
    private maulana.swing.TextFieldFlatLaf txtNoTlpnPelanggan;
    // End of variables declaration//GEN-END:variables
}
