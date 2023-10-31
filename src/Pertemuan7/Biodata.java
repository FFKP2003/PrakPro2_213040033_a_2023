package Pertemuan7;

// ini adalah baris import yang menyertakan berbagai kelas yang dibutuhkan
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

// ini adalah baris turunan dari JFrame dengan membuat kelas untuk menampilkan GUI
public class Biodata extends JFrame {
    
    // baris ini untuk menyimpan data yang ada dalam objek data ke dalam sebuah file dengan nama data.txt
    private void simpanFile(ArrayList<ArrayList<String>> data) {
        int konfirmasi = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menyimpan file '.txt' ?",
                "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if(konfirmasi == JOptionPane.YES_OPTION) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));

                for(ArrayList<String> row : data) {
                    for (String s : row) {
                        writer.write(s + "\t");
                    }

                    writer.newLine();
                }
                writer.close();
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan ke file ini");
            }
            catch(IOException e) {
                JOptionPane.showMessageDialog(null, "Data gagal disimpan ke file ini.");
                e.printStackTrace();
            }
        }
    }


    public Biodata() { // sebuah konstruktor
        // baris ini untuk menambahkan sebuah windowListener ketika pengguna mencoba menutup jendela program menampilkan dialog konfirmasi apakah anda yakin ingin keluar jika ya jendela akan ditutup dan jika tidak jendela akan tetap terbuka
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int exit = JOptionPane.showConfirmDialog(null,
                        "Apakah anda yakin ingin keluar?", "Keluar",
                        JOptionPane.YES_NO_OPTION);

                if (exit == JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

        JLabel labelInputNama = new JLabel("Nama : "); // untuk menampilkan teks nama di GUI
        labelInputNama.setBounds(15, 40, 350, 10); // untuk mengatur posisi dan ukuran labelInputNama
        
        JTextField textFieldNama = new JTextField(); // untuk memasukkan teks nama atau bisa dibilang sebuah form nya
        textFieldNama.setBounds(15, 60, 350, 30); // untuk mengatur posisi dan ukuran textfieldNama

        JLabel labelInputNotelp = new JLabel("NoTelp : "); // untuk menampilkan teks no telepon di GUI
        labelInputNotelp.setBounds(15, 90, 350, 30); // untuk mengatur posisi dan ukuran labelInputNotelepon
        
        JTextField textFieldNotelp = new JTextField(); // untuk memasukkan teks no telepon atau bisa dibilang sebuah form nya
        textFieldNotelp.setBounds(15, 120, 350, 30); // untuk mengatur posisi dan ukuran textfieldNotelepon
        
        JLabel labelRadio = new JLabel("Jenis Kelamin : "); // untuk menampilkan teks Jenis Kelamin di GUI
        labelRadio.setBounds(15,150,140,30); // untuk mengatur posisi dan ukuran labelRadio
        
        JRadioButton radioButtonL = new JRadioButton("Laki-Laki", true); // untuk menampilkan pilihan radioButton untuk Laki-Laki
        radioButtonL.setBounds(15, 170, 350, 30); // untuk mengatur posisi dan ukuran radioButtonL

        JRadioButton radioButtonP = new JRadioButton("Perempuan"); // untuk menampilkan pilihan radioButton untuk Perempuan
        radioButtonP.setBounds(15, 190, 350, 30); // untuk mengatur posisi dan ukuran radioButtonP

        JLabel labelInputAlamat = new JLabel("Alamat : "); // untuk menampilkan teks Alamat di GUI
        labelInputAlamat.setBounds(15, 210, 350, 30); // untuk mengatur posisi dan ukuran labelInputAlamat
        
        JTextArea textFieldAlamat = new JTextArea(""); // untuk memasukkan teks Alamat atau bisa dibilang sebuah form nya
        textFieldAlamat.setBounds(15, 235, 500, 100); // untuk mengatur posisi dan ukuran textFieldAlamat

        JButton Button = new JButton("Simpan"); // Untuk menampilkan sebuah tombol simpan untuk menyimpan apa yang sudah di inputkan
        Button.setBounds(15, 390, 100, 40); // untuk mengatur posisi dan ukuran tombol simpan
        
        JButton ubahButton = new JButton("Ubah"); // Untuk menampilkan sebuah tombol ubah untuk mengubah apa yang sudah di inputkan
        ubahButton.setBounds(225, 390, 100, 40); // untuk mengatur posisi dan ukuran tombol ubah
        
        JButton hapusButton = new JButton("Hapus"); // Untuk menampilkan sebuah tombol hapus untuk menghapus data yang sudah di simpan
        hapusButton.setBounds(120, 390, 100, 40); // untuk mengatur posisi dan ukuran tombol hapus
        
        JButton simpanButton = new JButton("Simpan Ke File"); // Untuk menampilkan sebuah tombol simpan ke file untuk menyimpan data dengan nama data.txt
        simpanButton.setBounds(330, 390, 120, 40); // untuk mengatur posisi dan ukuran tombol simpan ke file

        javax.swing.JTable table = new JTable(); // untuk membuat sebuah tabel output
        JScrollPane scrollableTable = new JScrollPane(table); // untuk membuat sebuah tabel scrollpane
        scrollableTable.setBounds(15, 440, 650, 200); // untuk mengatur ukuran scrollableTable

        /* 
       Ini membuat pengelompokkan tombol radio menggunakan ButtonGroup 
       dan menambahkan tombol radio ke dalam kelompok ini dan dipastikan hanya satu tombol yang di pilih 
       */
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButtonL);
        bg.add(radioButtonP);
        
        // sebuah konstruktor dari kelas BiodataTableModel dan di gunakan untuk tablemodel
        BiodataTableModel tableModel = new BiodataTableModel();
        table.setModel(tableModel);

        // baris kode ini untuk menambahkan aksi ke tombol simpan dan ketika tombol tersebut di tekan actionperformed akan di eksekusi                  
        Button.addActionListener(new ActionListener() {
            
            // ini adalah Logic untuk nama, nomor telepon, alamat dan jenis kelamin agar ditampilkan di Table
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String noTelp = textFieldNotelp.getText();
                String alamat = textFieldAlamat.getText();
                String jenisKelamin = "";
            // ini adalah baris kode pengkondisian untuk memilih jenis Kelamin
                if (radioButtonL.isSelected()) {
                    jenisKelamin = radioButtonL.getText();
                }
                if (radioButtonP.isSelected()) {
                    jenisKelamin = radioButtonP.getText();
                }

            // ini adalah baris kode pengkondisian untuk menyimpan data yang sudah diinputkan dan inputan tidak boleh kosong

                if (nama.trim().isEmpty() || noTelp.trim().isEmpty() || alamat.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(Biodata.this, "Form input tidak boleh ada yang kosong!", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    // Menampilkan dialog konfirmasi dengan dua tombol pilihan (YES dan NO)
                    // dan menyimpan hasilnya dalam variabel konfirmasi
                    int confirmation = JOptionPane.showConfirmDialog(Biodata.this,
                            "Yakin ingin menyimpan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                    // Memasukkan objek nama, nomortelp, jenisKelamin, Alamat kedalam array
                    // yang kemudian ditampilkan ke Table dan di kembalikan ke default pada inputan
                    if (confirmation == JOptionPane.YES_OPTION) {
                        tableModel.add(new ArrayList<>(Arrays.asList(nama, noTelp, jenisKelamin, alamat)));
                        textFieldNama.setText("");
                        textFieldNotelp.setText("");
                        textFieldAlamat.setText("");
                    } else {
                        // Menampilkan dialog pesan dengan informasi bahwa pengguna telah menekan tombol "NO"
                        JOptionPane.showMessageDialog(Biodata.this, "Anda tidak menyimpan data");
                         textFieldNama.setText("");
                         textFieldNotelp.setText("");
                         textFieldAlamat.setText("");
                         
                    }
                }
            }

        });
           
             
        // Membuat ActionListener untuk tombol "Hapus"
       hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if(selectedRow >= 0) {
                    int option = JOptionPane.showConfirmDialog(Biodata.this, "Apakah Anda yakin ingin menghapus data ini ?",
                            "Konfirmasi", JOptionPane.YES_NO_OPTION);

                     // Hapus baris yang dipilih dari model tabel
                    if(option == JOptionPane.YES_OPTION) {
                        tableModel.remove(selectedRow);
                        JOptionPane.showMessageDialog(Biodata.this, "Data berhasil dihapus!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(Biodata.this, "Pilih baris yang akan dihapus!",
                            "Konfirmasi", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
       // Membuat ActionListener untuk tombol "Ubah"
        ubahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow(); // Mendapatkan baris yang dipilih dalam tabel
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan diubah!");
                    return;
                    
                }

                String jenisKelamin = "";
                String nama = textFieldNama.getText();
                String nomorHP = textFieldNotelp.getText();
                String alamat = textFieldAlamat.getText();

                if(radioButtonL.isSelected() && radioButtonP.isSelected()) {
                    JOptionPane.showMessageDialog(Biodata.this, "Hanya satu jenis kelamin yang bisa dipilih!",
                            "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
                else if (radioButtonL.isSelected()) {
                    jenisKelamin = radioButtonL.getText();
                }
                else if(radioButtonP.isSelected()) {
                    jenisKelamin = radioButtonP.getText();
                }
                else {
                    // Memberikan notifikasi jika jenis kelamin belum dipilih
                    JOptionPane.showMessageDialog(Biodata.this, "Pilih jenis kelamin terlebih dahulu!",
                            "Kesalahan", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(nama.isEmpty() || nomorHP.isEmpty() || alamat.isEmpty()) {
                    JOptionPane.showMessageDialog(Biodata.this, "Semua input harus diisi!",
                            "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    int konfirmasi = JOptionPane.showConfirmDialog(Biodata.this, "Apakah anda yakin ingin mengubah data ini ?",
                            "Konfirmasi", JOptionPane.YES_NO_OPTION);
                    JOptionPane.showMessageDialog(Biodata.this, "Data berhasil diubah!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    

                    // Memperbarui nilai-nilai komponen GUI dengan data dari baris yang dipilih
                    if(konfirmasi == JOptionPane.YES_OPTION) {
                        ArrayList<String> data = new ArrayList<String>(Arrays.asList(nama, nomorHP, jenisKelamin, alamat));
                        tableModel.update(data, row);
                        textFieldNama.setText("");
                        textFieldNotelp.setText("");
                        textFieldAlamat.setText("");
                        labelRadio.setText("Jenis Kelamin: ");
                    }
                }
            }
        });     
        
        // Membuat ActionListener untuk tombol "Simpan Ke File"
         simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpanFile(tableModel.getData());
            }
        });
         
        JPanel buttonPanel = new JPanel(); // untuk menampilkan panel GUI dimana tombol tombol akan di tetapkan
        buttonPanel.add(Button); // untuk menambahkan tombol simpan dalam sebuah panel
        buttonPanel.add(hapusButton); // untuk menambahkan tombol hapus dalam sebuah panel
        buttonPanel.add(ubahButton); // untuk menambahkan tombol ubah dalam sebuah panel
        buttonPanel.add(simpanButton); // untuk menambahkan tombol simpan ke file dalam sebuah panel
        
        // untuk Menampilkan objek-objek kedalam frame
        this.add(Button);
        this.add(simpanButton);
        this.add(hapusButton);
        this.add(ubahButton);
        this.add(labelInputNama);
        this.add(textFieldNama);
        this.add(labelInputNotelp);
        this.add(textFieldNotelp);
        this.add(labelRadio);
        this.add(radioButtonL);
        this.add(radioButtonP);
        this.add(labelInputAlamat);
        this.add(textFieldAlamat);
        this.add(scrollableTable);

        // Untuk mengatur ukuran frame
        this.setSize(700, 700);
        this.setLayout(null);
    }

    // baris kode ini adalah method main fungsinya untuk mengatur nya menjadi terlihat dan seharusnya operasi penggunaan swing akan dijalankan.   
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Biodata f = new Biodata();
                f.setVisible(true);
            }
        });
    }
}