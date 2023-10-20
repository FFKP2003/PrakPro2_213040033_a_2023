/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan6;

// ini adalah baris import yang menyertakan berbagai kelas yang dibutuhkan
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Faqih firdaus k.p
 */

// ini adalah baris turunan dari JFrame dengan membuat kelas untuk menampilkan GUI
public class HelloConfirmDialog extends JFrame {
    
    public HelloConfirmDialog() { // baris ini adalah sebuah konstruktor
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // untuk membuat tampilan keluar saat di tutup
        this.setLayout(new FlowLayout()); // baris ini untuk mengatur tata letak menggunakan FlowLayout

        JButton button = new JButton("Exit"); // baris ini untuk membuat tombol exit
        button.setBounds(130, 100, 100, 40); // baris ini untuk mengatur posisi dan ukuran tombol exit

        // baris kode ini untuk menambahkan aksi ke tombol simpan dan ketika tombol tersebut di tekan actionperformed akan di eksekusi
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /* 
                baris ini pengkondisian untuk menampilkan dialog konfirmasi kepada pengguna 
                dan hasil konfirmasi akan menentukan jika ya program akan keluar exit atau jika tidak menampilkan pesan "anda menekan tombol NO"
                */
                int confirmation = JOptionPane.showConfirmDialog(HelloConfirmDialog.this,
                        "Apakah anda yakin ingin keluar dari  aplikasi", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(HelloConfirmDialog.this, "Anda menekan tombol NO");
                }
            }
        });

        // baris ini untuk menambahkan tombol
        this.add(button);
        // baris ini untuk mengatur ukuran jendela menjadi 200x200 
        this.setSize(200, 200);
    }

    // baris kode ini adalah metode main fungsinya untuk mengatur nya menjadi terlihat dan seharusnya operasi penggunaan swing akan dijalankan.
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloConfirmDialog f = new HelloConfirmDialog();
                f.setVisible(true);
            }
        });
    }
}

