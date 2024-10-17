package maulana.swing;

import javax.swing.*;
import java.awt.*;

public class LoadingDialog extends JDialog {

    public LoadingDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
    }

    private void initComponents() {
        // Memuat GIF sebagai ImageIcon
        ImageIcon loadingIcon = new ImageIcon(getClass().getResource("/icon/loading.gif"));

        // Membuat JLabel untuk menampilkan GIF
        JLabel label = new JLabel(loadingIcon);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        add(label);

        setUndecorated(true); // Menghilangkan border dialog
        setSize(200, 200); // Ukuran dialog loading
        setLocationRelativeTo(null); // Menempatkan dialog di tengah layar
        getContentPane().setBackground(new Color(0,0,0,0)); // Latar belakang putih
    }
}
