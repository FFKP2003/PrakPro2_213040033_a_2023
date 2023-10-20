/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan6;
// ini adalah baris import yang menyertakan berbagai kelas yang dibutuhkan
import java.awt.event. *;
import javax.swing. *;
/**
 *
 * @author Faqih firdaus k.p
 */

// ini adalah baris turunan dari JFrame dengan membuat kelas untuk menampilkan GUI
public class HelloScrollPane extends JFrame {

    public HelloScrollPane() { // baris ini adalah sebuah konstruktor
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // untuk membuat tampilan keluar saat di tutup

        JLabel labelInput = new JLabel("Input Nama:"); // untuk menampilkan teks nama di GUI 
        labelInput.setBounds(130, 40, 100, 10); // untuk mengatur posisi dan ukuran labelInput

        JTextField textField = new JTextField(); // untuk memasukkan teks nama atau bisa dibilang sebuah form nya
        textField.setBounds(130, 60, 100, 30); // untuk mengatur posisi dan ukuran textfield

        JButton button = new JButton("Klik"); // baris ini untuk membuat tombol klik
        button.setBounds(130, 100, 100, 40); // baris ini untuk mengatur posisi dan ukuran tombol klik

        JTextArea txtOutput = new JTextArea(""); // baris ini untuk membuat textarea output
        JScrollPane scrollableTextArea = new JScrollPane(txtOutput); // baris ini untuk memberikan bilah geser(scrollbar) jika teksnya melebihi ruang 
        scrollableTextArea.setBounds(130, 150, 100, 100); // baris ini mengatur posisi dan ukuran dari scrollableTextarea
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // baris ini untuk mengatur bilah geser horizontal
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // baris ini untuk mengatur bilah geser vertikal

        // baris kode ini untuk menambahkan aksi ke tombol simpan dan ketika tombol tersebut di tekan actionperformed akan di eksekusi                  
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // baris kode ini adalah untuk menampilkan output atau hasil dari sebuah input
                String nama = textField.getText();
                txtOutput.append("Hello " + nama + "\n");
                // baris kode ini untuk mengosongkan atau menghilangkan setelah informasi di tampilkan
                textField.setText("");
            }
        });

        /* 
       Ini adalah kode untuk menambahkan semua komponen GUI ke dalam frame (JFrame) menggunakan this.add() 
       untuk mengatur tampilan  dan posisi komponen-komponen tersebut dalam frame.
       */
        this.add(button);
        this.add(textField);
        this.add(labelInput);
        this.add(scrollableTextArea);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    // baris kode ini adalah metode main fungsinya untuk mengatur nya menjadi terlihat dan seharusnya operasi penggunaan swing akan dijalankan.
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloScrollPane f = new HelloScrollPane();
                f.setVisible(true);
            }
        });
    }
}
