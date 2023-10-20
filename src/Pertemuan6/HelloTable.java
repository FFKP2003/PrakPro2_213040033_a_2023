/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan6;

// ini adalah baris import yang menyertakan berbagai kelas yang dibutuhkan
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

/**
 *
 * @author Faqih firdaus k.p
 */

// ini adalah baris turunan dari JFrame dengan membuat kelas untuk menampilkan GUI
public class HelloTable extends JFrame {
    
    public HelloTable() { // baris ini adalah sebuah konstruktor
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // untuk membuat tampilan keluar saat di tutup
        
        JLabel labelInput = new JLabel("Nama: "); // untuk menampilkan teks nama di GUI 
        labelInput.setBounds(15,40,350,10); // untuk mengatur posisi dan ukuran labelInput
        
        JTextField textField = new JTextField(); // untuk memasukkan teks nama atau bisa dibilang sebuah form nya
        textField.setBounds(15,60,350,30); // untuk mengatur posisi dan ukuran textfield
        
        JLabel labelRadio = new JLabel("Jenis Member: "); // untuk menampilkan teks Jenis Member di GUI
        labelRadio.setBounds(15,100,350,10); // untuk mengatur posisi dan ukuran labelRadio
        
        JRadioButton radioButton1 = new JRadioButton("Silver", true); // untuk menampilkan pilihan radioButton untuk Member Silver 
        radioButton1.setBounds(15,115,350,30); // untuk mengatur posisi dan ukuran radioButton1
        
        JRadioButton radioButton2 = new JRadioButton("Gold"); // untuk menampilkan pilihan radioButton untuk Member Gold
        radioButton2.setBounds(15,145,350,30); // untuk mengatur posisi dan ukuran radioButton2
        
        JRadioButton radioButton3 = new JRadioButton("Platinum"); // untuk menampilkan pilihan radioButton untuk Member Platinum
        radioButton3.setBounds(15,175,350,30); // untuk mengatur posisi dan ukuran radioButton3
        
        /* 
       Ini membuat pengelompokkan tombol radio menggunakan ButtonGroup 
       dan menambahkan tombol radio ke dalam kelompok ini dan dipastikan hanya satu tombol yang di pilih 
       */
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        bg.add(radioButton3);
        
        JButton button = new JButton("Simpan"); // Untuk menampilkan sebuah tombol simpan untuk menyimpan apa yang sudah di inputkan
        button.setBounds(15,205,100,40); // untuk mengatur posisi dan ukuran tombol simpan
        
        javax.swing.JTable table = new JTable(); // untuk membuat sebuah tabel output
        JScrollPane scrollableTable = new JScrollPane(table); // untuk membuat sebuah tabel scrollpane
        scrollableTable.setBounds(15,250,350,200); // untuk mengatur ukuran scrollableTable
        
        // sebuah konstruktor dari kelas MyTableModel dan di gunakan untuk tablemodel
        MyTableModel tableModel = new MyTableModel(); 
        table.setModel(tableModel); 
        
        // baris kode ini untuk menambahkan aksi ke tombol simpan dan ketika tombol tersebut di tekan actionperformed akan di eksekusi                  
        button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // ini adalah baris kode pengkondisian untuk memilih jenis Member
            String jenisMember = "";
            if(radioButton1.isSelected()) {
                jenisMember = radioButton1.getText();
            }
            if(radioButton2.isSelected()) {
                jenisMember = radioButton2.getText();
            }
            if(radioButton3.isSelected()) {
                jenisMember = radioButton3.getText();
            }
            
            String nama = textField.getText(); // baris ini untuk menampilkan text nama di dalam tabel output
            // baris kode ini adalah untuk menampilkan output atau hasil dari sebuah input
            tableModel.add(new ArrayList<>(Arrays.asList(nama, jenisMember))); 
        }
    });
        
         /* 
       Ini adalah kode untuk menambahkan semua komponen GUI ke dalam frame (JFrame) menggunakan this.add() 
       untuk mengatur tampilan  dan posisi komponen-komponen tersebut dalam frame.
       */
        this.add(button);
        this.add(textField);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(radioButton3);
        this.add(labelInput);
        this.add(scrollableTable);
        
        this.setSize(400,500); // baris ini untuk mengatur ukuran GUI
        this.setLayout(null); // baris ini menunjukkan setLayout yang menjadi null
    }
    // baris kode ini adalah metode main fungsinya untuk mengatur nya menjadi terlihat dan seharusnya operasi penggunaan swing akan dijalankan.   
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               HelloTable f = new HelloTable();
               f.setVisible(true);
           }
        });
      }
   } 
