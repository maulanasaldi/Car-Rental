/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maulana.koneksi;
import java.sql.*;

/**
 *
 * @author saldi
 */
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
            System.out.println("Gagal koneksi database"+ex);
        }
        return koneksi;
    }
}
