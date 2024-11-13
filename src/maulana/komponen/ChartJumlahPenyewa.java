package maulana.komponen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import maulana.koneksi.KoneksiDB;

public class ChartJumlahPenyewa extends javax.swing.JPanel {

    private int[] data = new int[12]; // Array untuk menyimpan jumlah penyewaan per bulan
    private String[] labels = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    private Color barColor = new Color(79, 129, 189);
    private Color chartBackgroundColor = new Color(51, 51, 51);
    private Color axisColor = Color.WHITE;
    private Color textColor = new Color(190,190,190);
    private Connection koneksi = new KoneksiDB().connect();

    public ChartJumlahPenyewa() {
        initComponents();
        setOpaque(false);
        data = getTotalPembayaranPerBulan(); // Ambil data dari database
    }

    // Fungsi untuk mengambil data jumlah penyewaan per bulan dari database
    private int[] getTotalPembayaranPerBulan() {
        int[] pembayaranData = new int[12]; // Mengasumsikan 12 bulan

        try {
            // Query untuk mengambil total pembayaran per bulan
            String query = "SELECT MONTH(tanggal_pembayaran) AS bulan, SUM(total_harga) AS total_pembayaran "
                    + "FROM pembayaran "
                    + "GROUP BY bulan "
                    + "ORDER BY bulan";
            Statement statement = koneksi.createStatement();
            ResultSet hasil = statement.executeQuery(query);

            // Memasukkan data hasil query ke dalam array
            while (hasil.next()) {
                int bulan = hasil.getInt("bulan") - 1; // Mengonversi bulan dari 1-12 menjadi 0-11 untuk indeks array
                int totalPembayaran = hasil.getInt("total_pembayaran");
                pembayaranData[bulan] = totalPembayaran;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data pembayaran: " + e.getMessage());
        }

        return pembayaranData;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Membuat objek Graphics2D untuk menggambar dengan antialiasing
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Mendapatkan lebar dan tinggi panel
        int width = getWidth();
        int height = getHeight();

        // Tentukan padding di sekitar grafik dan lebar batang
        int padding = 50;  // Memberikan jarak agar grafik tidak terlalu rapat
        int barWidth = (width - padding * 2) / data.length; // Lebar batang grafik dengan jarak antar batang

        // Menghitung nilai maksimum dari data untuk skala grafik
        int maxDataValue = 1; // Setidaknya 1 untuk menghindari pembagian dengan 0
        for (int i = 0; i < data.length; i++) {
            if (data[i] > maxDataValue) {
                maxDataValue = data[i]; // Menyimpan nilai terbesar
            }
        }

        // Gambar latar belakang grafik dengan rounded corners
        g2d.setColor(chartBackgroundColor);
        g2d.fillRoundRect(0, 0, width, height, 30, 30);  // Menggunakan fillRoundRect untuk latar belakang melengkung

        // Menentukan posisi untuk sumbu X dan Y
        int xAxisY = height - padding;  // Posisi sumbu X (horizontal)
        int yAxisX = padding;  // Posisi sumbu Y (vertikal)

        // Gambar sumbu X dan Y dengan warna yang ditentukan
        g2d.setColor(axisColor);
        g2d.drawLine(yAxisX, padding, yAxisX, xAxisY);  // Sumbu Y vertikal
        g2d.drawLine(yAxisX, xAxisY, width - padding, xAxisY);  // Sumbu X horizontal

        // Gambar batang dan label untuk setiap data
        for (int i = 0; i < data.length; i++) {
            // Hitung tinggi batang berdasarkan data dan nilai maksimum, dengan sedikit penyesuaian agar lebih pendek
            int barHeight = (int) ((double) data[i] / maxDataValue * (height - padding * 2) * 0.9); // Mengurangi 0.8 untuk memendekkan grafik
            int x = padding + i * barWidth;  // Posisi horizontal batang
            int y = xAxisY - barHeight;  // Posisi vertikal batang

            // Gambar batang dengan rounded corners
            g2d.setColor(barColor);
            g2d.fillRoundRect(x, y, barWidth - 10, barHeight, 20, 20);  // Batang dengan sudut membulat

            // Tampilkan nilai di atas batang
            g2d.setColor(textColor);
            g2d.drawString(String.valueOf(data[i]), x + (barWidth / 4), y - 5);  // Menampilkan nilai data di atas batang

            // Tampilkan label bulan di bawah batang
            g2d.setColor(textColor);
            g2d.drawString(labels[i], x + (barWidth / 4), xAxisY + 20);  // Menampilkan label untuk setiap bulan
        }

        // Tampilkan label "Jumlah Penyewa" di atas grafik
        g2d.setColor(textColor);
        g2d.setFont(new Font("sansserif", Font.BOLD, 22));
        g2d.drawString("Pendapatan Perbulan", (width - g2d.getFontMetrics().stringWidth("Jumlah Penyewa")) / 2, padding - 10);
        // Menyusun teks "Jumlah Penyewa" di tengah bagian atas grafik
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 725, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
