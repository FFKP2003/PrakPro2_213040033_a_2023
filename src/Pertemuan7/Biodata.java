package Pertemuan7;

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

public class Biodata extends JFrame {
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


    public Biodata() {
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

        JLabel labelInputNama = new JLabel("Nama : ");
        labelInputNama.setBounds(15, 40, 350, 10);
        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        JLabel labelInputNotelp = new JLabel("NoTelp : ");
        labelInputNotelp.setBounds(15, 90, 350, 30);
        
        JTextField textFieldNotelp = new JTextField();
        textFieldNotelp.setBounds(15, 120, 350, 30);
        
        JLabel labelRadio = new JLabel("Jenis Kelamin : "); // untuk menampilkan teks Jenis Kelamin di GUI
        labelRadio.setBounds(15,150,140,30); // untuk mengatur posisi dan ukuran labelRadio
        
        JRadioButton radioButtonL = new JRadioButton("Laki-Laki", true);
        radioButtonL.setBounds(15, 170, 350, 30);

        JRadioButton radioButtonP = new JRadioButton("Perempuan");
        radioButtonP.setBounds(15, 190, 350, 30);

        JLabel labelInputAlamat = new JLabel("Alamat : ");
        labelInputAlamat.setBounds(15, 210, 350, 30);
        
        JTextArea textFieldAlamat = new JTextArea("");
        textFieldAlamat.setBounds(15, 235, 500, 100);

        JButton Button = new JButton("Simpan");
        Button.setBounds(15, 390, 100, 40);
        
        JButton ubahButton = new JButton("Ubah");
        ubahButton.setBounds(225, 390, 100, 40);
        
        JButton hapusButton = new JButton("Hapus");
        hapusButton.setBounds(120, 390, 100, 40);
        
        JButton simpanButton = new JButton("Simpan Ke File");
        simpanButton.setBounds(330, 390, 120, 40);
        
        JButton buttonFile = new JButton("Simpan Ke File");
        buttonFile.setBounds(465, 380, 130, 40);

        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 440, 650, 200);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButtonL);
        bg.add(radioButtonP);
        
        BiodataTableModel tableModel = new BiodataTableModel();
        table.setModel(tableModel);

        Button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String noTelp = textFieldNotelp.getText();
                String alamat = textFieldAlamat.getText();
                String jenisKelamin = "";

                if (radioButtonL.isSelected()) {
                    jenisKelamin = radioButtonL.getText();
                }
                if (radioButtonP.isSelected()) {
                    jenisKelamin = radioButtonP.getText();
                }


                if (nama.trim().isEmpty() || noTelp.trim().isEmpty() || alamat.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(Biodata.this, "Form input tidak boleh ada yang kosong!", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    int confirmation = JOptionPane.showConfirmDialog(Biodata.this,
                            "Yakin ingin menyimpan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        tableModel.add(new ArrayList<>(Arrays.asList(nama, noTelp, jenisKelamin, alamat)));
                        textFieldNama.setText("");
                        textFieldNotelp.setText("");
                        textFieldAlamat.setText("");
                    } else {
                        JOptionPane.showMessageDialog(Biodata.this, "Anda tidak memasukan data");
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
        
        ubahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
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
        
         simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpanFile(tableModel.getData());
            }
        });
         
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(Button);
        buttonPanel.add(hapusButton);
        buttonPanel.add(ubahButton);  
        buttonPanel.add(simpanButton);  
        
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

        this.setSize(700, 700);
        this.setLayout(null);
    }

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