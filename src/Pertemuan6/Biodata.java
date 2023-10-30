/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// ini adalah baris import yang menyertakan berbagai kelas yang dibutuhkan
package Pertemuan6;
import java.awt.event. *;
import javax.swing. *;
import javax.swing.table.*;
import java.util.*;
/**
 *
 * @author Faqih firdaus k.p
 */

// ini adalah baris turunan dari JFrame dengan membuat kelas untuk menampilkan GUI
public class Biodata extends JFrame {
    private boolean CheckBoxSelected; // baris ini untuk memastikan apakah checkboxSelected telah dipilih
    
    public Biodata() { // sebuah konstruktor
        this.CheckBoxSelected = false; // untuk menginisialisasi CheckBoxSelected dengan false
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // untuk membuat tampilan keluar saat di tutup
        
       JLabel labelInput = new JLabel("Nama : "); // untuk menampilkan teks nama di GUI 
       labelInput.setBounds(15, 40, 350, 10); // untuk mengatur posisi dan ukuran labelInput
       
       JTextField textFieldNama = new JTextField(); // untuk memasukkan teks nama atau bisa dibilang sebuah form nya
       textFieldNama.setBounds(15,60,350,30); // untuk mengatur posisi dan ukuran textfieldNama
       
       JLabel labelTelepon = new JLabel("No Telepon : "); // untuk menampilkan teks no Telepon di GUI
       labelTelepon.setBounds(15, 90, 350, 30); // untuk mengatur posisi dan ukuran label
       
       JTextField textFieldTelepon = new JTextField(); // untuk memasukkan teks no telepon atau sebuah form nya
       textFieldTelepon.setBounds(15,120,350,30); // untuk mengatur posisi dan ukuran textfieldTelepon
        
       JLabel labelRadio = new JLabel("Jenis Kelamin : "); // untuk menampilkan teks Jenis Kelamin di GUI
       labelRadio.setBounds(15,160,140,30); // untuk mengatur posisi dan ukuran labelRadio
       
       JRadioButton radioButtonLK = new JRadioButton("Laki-Laki", true); // untuk menampilkan pilihan Radio button untuk LK
       radioButtonLK.setBounds(15,190,350,30); // untuk mengatur posisi dan ukuran radioButton LK
       
       JRadioButton radioButtonPR = new JRadioButton("Perempuan"); // untuk menampilkan pilihan Radio button untuk PR
       radioButtonPR.setBounds(15,220,350,30); // untuk mengatur posisi dan ukuran radioButton PR
       
        /* 
       Ini membuat pengelompokkan tombol radio menggunakan ButtonGroup 
       dan menambahkan tombol radio ke dalam kelompok ini dan dipastikan hanya satu tombol yang di pilih 
       */
       ButtonGroup bg = new ButtonGroup();
       bg.add(radioButtonLK);
       bg.add(radioButtonPR);
       
       JCheckBox checkBox = new JCheckBox("Warga Negara Asing"); // untuk menampilkan sebuah CheckBox WNA
       checkBox.setBounds(15,250,350,30); // untuk mengatur posisi dan ukuran CheckBox WNA
       
       JButton button = new JButton("Simpan"); // Untuk menampilkan sebuah tombol simpan untuk menyimpan apa yang sudah di inputkan
       button.setBounds(15,290,100,40); // untuk mengatur posisi dan ukuran tombol simpan
       
       javax.swing.JTable table = new JTable(); // untuk membuat sebuah tabel output
       JScrollPane scrollableTable = new JScrollPane(table); // untuk membuat sebuah tabel scrollpane
       scrollableTable.setBounds(15,350,350,200); // untuk mengatur ukuran scrollableTable
       
      
                
       /* 
       baris kode ini untuk menambahkan itemlistener fungsinya saat checkbox berubah dipilih 
       atau tidak dipilih itemlistener akan dipanggil untuk memperbarui sebuah checkbox
       */
       checkBox.addItemListener(new ItemListener() {
       public void itemStateChanged(ItemEvent e) {
           CheckBoxSelected = e.getStateChange()==1;
       }
    });
       // sebuah konstruktor dari kelas BiodataTableModel dan di gunakan untuk tablemodel
       BiodataTableModel tableModel = new BiodataTableModel();
       table.setModel(tableModel);

        
       // baris kode ini untuk menambahkan aksi ke tombol simpan dan ketika tombol tersebut di tekan actionperformed akan di eksekusi                  
       button.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           
            String nama = textFieldNama.getText(); // baris ini untuk menampilkan text nama di dalam tabel output
            String noTelp = textFieldTelepon.getText(); // baris ini untuk menampilkan text no telepon di dalam tabel output
            String jenisKelamin = ""; // baris ini untuk menampilkan text jenis kelamin di dalam tabel output 
            String WNA = ""; // baris ini untuk menampilkan text WNA di dalam tabel output
            
            // ini adalah baris kode pengkondisian untuk memilih jenis kelamin
            if(radioButtonLK.isSelected()) {
                jenisKelamin = radioButtonLK.getText();
            }
            if(radioButtonPR.isSelected()) {
                jenisKelamin = radioButtonPR.getText();
            }   
            // ini adalah baris kode pengkondisian untuk memilih apakah yang mengisi data tersebut adalah WNA atau bukan
            if (CheckBoxSelected) {
                WNA = "Ya";
            }else {
                WNA = "Bukan";
            }
              
             // baris kode ini adalah untuk menampilkan output atau hasil dari sebuah input
            tableModel.add(new ArrayList<>(Arrays.asList(nama,noTelp, jenisKelamin, WNA )));

            // baris kode ini untuk mengosongkan atau menghilangkan setelah informasi di tampilkan
            textFieldNama.setText("");
            textFieldTelepon.setText("");
            checkBox.setSelected(false);
               
            
             
        }
         
    });
      
       /* 
       Ini adalah kode untuk menambahkan semua komponen GUI ke dalam frame (JFrame) menggunakan this.add() 
       untuk mengatur tampilan  dan posisi komponen-komponen tersebut dalam frame.
       */
       this.add(button);
       this.add(radioButtonLK);
       this.add(radioButtonPR);
       this.add(textFieldNama);
       this.add(textFieldTelepon); 
       this.add(checkBox);
       this.add(labelInput);
       this.add(labelRadio);
       this.add(labelTelepon);
       this.add(scrollableTable);
       
       this.setSize(400,500);  // baris ini untuk mengatur ukuran GUI
       this.setLayout(null); // baris ini menunjukkan setLayout yang menjadi null
       
    
    }
    
    // baris kode ini adalah metode main fungsinya untuk mengatur nya menjadi terlihat dan seharusnya operasi penggunaan swing akan dijalankan.
     public static void main(String[] args) {
           javax.swing.SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                   Biodata f = new Biodata();
                   f.setVisible(true);
               }
           });          
    }
}
    



