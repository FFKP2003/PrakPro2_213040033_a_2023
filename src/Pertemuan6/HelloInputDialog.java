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
public class HelloInputDialog extends JFrame {

    public HelloInputDialog() { // baris ini adalah sebuah konstruktor
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // untuk membuat tampilan keluar saat di tutup
        this.setLayout(new FlowLayout()); // baris ini untuk mengatur tata letak menggunakan FlowLayout

        JButton button = new JButton("input"); // baris ini untuk membuat tombol input 
        button.setBounds(130, 100, 100, 40); // baris ini untuk mengatur posisi dan ukuran tombol input

        // baris kode ini untuk menambahkan aksi ke tombol simpan dan ketika tombol tersebut di tekan actionperformed akan di eksekusi
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 /* 
                baris ini untuk menampilkan dialog dengan HelloInputDialog dengan pesan inputkan nama anda 
                lalu tunjukan pesan yang tadi dengan menginputkan nama dan dengan pesan hello + nama
                */
                String nama = JOptionPane.showInputDialog(HelloInputDialog.this, "Inputkan nama anda");
                JOptionPane.showMessageDialog(HelloInputDialog.this, "Hello, " + nama);
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
                HelloInputDialog f = new HelloInputDialog();
                f.setVisible(true);
            }
        });
    }
}
