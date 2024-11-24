package maulana.koneksi;
import java.sql.*;
import javax.swing.JOptionPane;

public class KoneksiDB {
    private Connection koneksi;
    public Connection connect(){       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Koneksi berhasil");
        } catch (ClassNotFoundException ex) {
            System.out.println("Gagal koneksi"+ex);           
        }
        String url = "jdbc:mysql://localhost:3306/car-rental";
        try {
            koneksi = DriverManager.getConnection(url,"root","");
            System.out.println("Berhasil koneksi database");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
            "MySQL belum di aktifkan.\nSilakan aktifkan MySQL terlebih dahulu untuk terhubung dengan database.", 
            "Koneksi Gagal", 
            JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            System.out.println("Gagal koneksi database"+ex);            
        }
        return koneksi;
    }
}
