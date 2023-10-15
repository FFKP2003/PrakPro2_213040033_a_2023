/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// ini adalah baris import yang menyertakan berbagai kelas yang dibutuhkan
package Pertemuan3;
import java.awt.event. *;
import javax.swing. *;
/**
 *
 * @author Faqih firdaus k.p
 */

// ini adalah baris turunan dari JFrame dengan membuat kelas untuk menampilkan GUI
public class Latihan3 extends JFrame {
    private boolean CheckBoxSelected; // baris ini untuk memastikan apakah checkboxSelected telah dipilih
    
    public Latihan3() { // sebuah konstruktor
        this.CheckBoxSelected = false; // untuk menginisialisasi CheckBoxSelected dengan false
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // untuk membuat tampilan keluar saat di tutup
        
       JLabel labelInput = new JLabel("Nama : "); // untuk menampilkan teks di GUI 
       labelInput.setBounds(15, 40, 350, 10); // untuk mengatur posisi dan ukuran label 
       
       JTextField textFieldNama = new JTextField(); // untuk memasukkan teks nama atau bisa dibilang sebuah form nya
       textFieldNama.setBounds(15,60,350,30);
       
       JLabel labelTelepon = new JLabel("No HP : ");
       labelTelepon.setBounds(15, 100, 350, 10);
       
       JTextField textFieldTelepon = new JTextField();
       textFieldTelepon.setBounds(15,120,350,30);
        
       JLabel labelRadio = new JLabel("Jenis Kelamin : ");
       labelRadio.setBounds(15,160,140,10);
       
       JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
       radioButton1.setBounds(15,190,350,30);
       
       JRadioButton radioButton2 = new JRadioButton("Perempuan");
       radioButton2.setBounds(15,220,350,30);  
       
       // Ini membuat pengelompokkan tombol radio menggunakan ButtonGroup dan menambahkan tombol radio ke dalam kelompok ini.dan dipastikan hanya satu tombol yang di pilih 
       ButtonGroup bg = new ButtonGroup();
       bg.add(radioButton1);
       bg.add(radioButton2);
       
       JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
       checkBox.setBounds(15,250,350,30);
       
       JButton button = new JButton("Simpan");
       button.setBounds(15,290,100,40);
       
       JTextArea txtOutput = new JTextArea("");
       txtOutput.setBounds(15,340,350,100);
       
// baris kode ini untuk menambahkan itemlistner fungsinya saat checkbox berubah dipili atau tidak dipilih itemlistener akan dipanggil untuk memperbarui sebuah checkbox
        checkBox.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {
            CheckBoxSelected = e.getStateChange()==1;
        }
    });
        
       // baris kode ini untuk menambahkan aksi ke tombol simpan dan ketika tombol tersebut di tekan actionperformed akan di eksekusi
       button.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // ini adalah bari kode pengkondisian untuk memilih jenis kelamin
               String jenisKelamin = "";
               if(radioButton1.isSelected()) { 
                   jenisKelamin = radioButton1.getText();
               }
               if(radioButton2.isSelected()) {
                   jenisKelamin = radioButton2.getText();
               }
               
       
                   String nama = textFieldNama.getText();
                   String Telepon = textFieldTelepon.getText();
                  
                   // baris kode ini adalah untuk menampilkan output atau hasil dari sebuah input
                   txtOutput.append("Nama              : " + nama + "\n" + "Nomor HP       : " +Telepon + "\n" + "Jenis Kelamin : " + jenisKelamin + "\n");
                   textFieldNama.setText("");
                   textFieldTelepon.setText("");
                   
                 
                 if (CheckBoxSelected) {
                   txtOutput.append("WNA : " + "Ya\n");
               }else {
                   txtOutput.append("WNA : " + "Bukan\n");
               }
               txtOutput.append("==============================\n");
               // baris kode ini untuk mengosongkan atau menghilangkan setelah informasi di tampilkan
               textFieldNama.setText("");
               textFieldTelepon.setText("");
               checkBox.setSelected(false);
               
             
           }
         
       });
      
       // Ini adalah kode untuk menambahkan semua komponen GUI ke dalam frame (JFrame) menggunakan this.add() untuk mengatur tampilan  dan posisi komponen-komponen tersebut dalam frame.
       this.add(button);
        this.add(radioButton1);
       this.add(radioButton2);
       this.add(textFieldNama);
       this.add(textFieldTelepon); 
       this.add(checkBox);
       this.add(labelInput);
       this.add(labelRadio);
       this.add(labelTelepon);
       this.add(txtOutput);
       
       this.setSize(400,500);
       this.setLayout(null);
       
    
       }
    
    // baris kode ini adalah metode main fungsinya untuk mengatur nya menjadi terlihat dan seharusnya operasi penggunaan swing akan dijalankan.
     public static void main(String[] args) {
           javax.swing.SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                   Latihan3 g = new Latihan3();
                   g.setVisible(true);
               }
           });          
    }
}
    



