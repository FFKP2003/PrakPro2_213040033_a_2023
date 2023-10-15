/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan5;
import java.awt. *;
import java.awt.event. *;
import javax.swing. *;
/**
 *
 * @author Faqih firdaus k.p
 */

// ini adalah baris turunan dari JFrame dengan membuat kelas untuk menampilkan GUI
public class Latihan3 extends JFrame {
    // baris ini untuk memastikan apakah checkboxSelected telah dipilih
    private boolean checkBoxSelected; 
    // sebuah konstruktor
    public Latihan3() { 
        // baris kode ini untuk menginisialisasi CheckBoxSelected dengan false
        this.checkBoxSelected = false; 
        // untuk membuat tampilan keluar saat di tutup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        /* untuk membuat teks dengan nama Form Biodata 
        untuk menandakan bahwa ini adalah judul dan di simpan di posisi tengah 
        */
        JLabel headerLabel = new JLabel("Form Biodata", JLabel.CENTER);
        
        //  untuk mengelompokkan komponen-komponen GUI.
        JPanel controlPanel = new JPanel();
        // untuk memberikan controlPanel mengatur layout menjadi FlowLayout
        controlPanel.setLayout(new FlowLayout());
        
        // Membuat panel lain yang akan digunakan untuk komponen-komponen input.
        JPanel panel = new JPanel();
        // mengatur ukuran panel
        panel.setSize(700,700);
        // mengatur GridBagLayout yang akan digunakan untuk panel
        GridBagLayout layout = new GridBagLayout();
        // untuk megatur GridBagLayout sebagai layout panel 
        panel.setLayout(layout);
        // untuk membuat objek GridBagConstraints yang digunakan untuk mengatur tata letak dalam GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        
        // untuk menampilkan teks nama di GUI 
        JLabel labelInputNama = new JLabel("Nama : "); 
        // untuk memasukkan teks nama atau bisa dibilang sebuah form nya (textField)
        JTextField textFieldNama = new JTextField(); 
        // untuk menampilkan teks Notelp di GUI 
        JLabel labelInputNotelp = new JLabel("Nomor HP : ");
        // untuk memasukkan teks Notelp atau bisa dibilang sebuah form nya (textField)
        JTextField textFieldNotelp = new JTextField();
        // untuk menampilkan teks Jenis Kelamin di GUI
        JLabel labelJenisKelamin = new JLabel("Jenis Kelamin : ");
        // membuat label untuk input radio button jenis kelamin LK
        JRadioButton radioButtonLK = new JRadioButton("Laki-Laki", true);
        // membuat label untuk input radio button jenis kelamin PR
        JRadioButton radioButtonPR = new JRadioButton("Perempuan");
        // untuk membuat CheckBox WNA
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        // untuk membuat button Simpan 
        JButton button = new JButton("Simpan");
        // untuk membuat textArea sebagai tempat output pengisian BioData
        JTextArea txtOutput = new JTextArea("");
       
        // untuk mengatur ukuran objek GridBagConstraints menjadi memenuhi panjang horizontal
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // mengatur letak objek GridBagConstraints ke posisi x = 0
        gbc.gridx = 0;
        // mengatur letak objek GridBagConstraints ke posisi y = 0
        gbc.gridy = 0;
        /* Menambahkan sebuah panel yang berisi labelNama 
        dan akan sesuai dengan gbc.fill,gridx dan gridy 
        yang sudah ditentukan sebelumnya
        */
        panel.add(labelInputNama,gbc);
       
        // mengatur letak objek GridBagConstraints ke posisi x = 0
        gbc.gridx = 0;
        // mengatur letak objek GridBagConstraints ke posisi y = 1
        gbc.gridy = 1;
        /* Menambahkan sebuah panel yang berisi textFieldNama
        dan akan sesuai dengan gbc gridx dan gridy 
        yang sudah ditentukan sebelumnya
        */
        panel.add(textFieldNama,gbc);
        
        // mengatur letak objek GridBagConstraints ke posisi x = 0
        gbc.gridx = 0;
        // mengatur letak objek GridBagConstraints ke posisi y = 2
        gbc.gridy = 2;
        /* Menambahkan sebuah panel yang berisi labelInputNotelp 
        dan akan sesuai dengan gbc gridx dan gridy 
        yang sudah ditentukan sebelumnya
        */
        panel.add(labelInputNotelp,gbc);
        
        // mengatur letak objek GridBagConstraints ke posisi x = 0
        gbc.gridx = 0;
        // mengatur letak objek GridBagConstraints ke posisi y = 3
        gbc.gridy = 3;
        /* Menambahkan sebuah panel yang berisi textFieldNotelp 
        dan akan sesuai dengan gbc gridx dan gridy 
        yang sudah ditentukan sebelumnya
        */
        panel.add(textFieldNotelp,gbc);
        
        // mengatur letak objek GridBagConstraints ke posisi x = 1
        gbc.gridx = 1;
        // mengatur letak objek GridBagConstraints ke posisi y = 0
        gbc.gridy = 0;
        /* Menambahkan sebuah panel yang berisi labelJenisKelamin
        dan akan sesuai dengan gbc gridx dan gridy 
        yang sudah ditentukan sebelumnya
        */
        panel.add(labelJenisKelamin,gbc);
      
        // mengatur letak objek GridBagConstraints ke posisi x = 1
        gbc.gridx = 1;
        // mengatur letak objek GridBagConstraints ke posisi y = 1
        gbc.gridy = 1;
        /* Menambahkan sebuah panel yang berisi radioButtonLK
        dan akan sesuai dengan gbc gridx dan gridy 
        yang sudah ditentukan sebelumnya
        */
        panel.add(radioButtonLK,gbc);
       
        // mengatur letak objek GridBagConstraints ke posisi x = 1
        gbc.gridx = 1;
        // mengatur letak objek GridBagConstraints ke posisi y = 2
        gbc.gridy = 2;
        /* Menambahkan sebuah panel yang berisi radioButtonPR
        dan akan sesuai dengan gbc gridx dan gridy 
        yang sudah ditentukan sebelumnya
        */
        panel.add(radioButtonPR,gbc);
        
        // mengatur letak objek GridBagConstraints ke posisi x = 1
        gbc.gridx = 1;
        // mengatur letak objek GridBagConstraints ke posisi y = 3
        gbc.gridy = 3;
        /* Menambahkan sebuah panel yang berisi CheckBox
        dan akan sesuai dengan gbc gridx dan gridy 
        yang sudah ditentukan sebelumnya
        */
        panel.add(checkBox, gbc);
        
        // untuk mengatur ukuran objek GridBagConstraints menjadi memenuhi panjang Vertical
        gbc.fill = GridBagConstraints.VERTICAL;
        // mengatur letak objek GridBagConstraints ke posisi x = 0
        gbc.gridx = 0;
        // mengatur letak objek GridBagConstraints ke posisi y = 4
        gbc.gridy = 4;
        // mengatur ukuran GridBagConstraints  width = 2
        gbc.gridwidth = 2;
         /* Menambahkan sebuah panel yang berisi button
        dan akan sesuai dengan gbc.fill, gridx, gridy dan gridwidth
        yang sudah ditentukan sebelumnya
        */
        panel.add(button, gbc);
        
        /* untuk mengelompokkan RadioButton 
        agar hanya bisa satu saja yang dapat dipilih sekaligus 
        */
         ButtonGroup bg = new ButtonGroup();
        // menambahkan radioButtonLk
        bg.add(radioButtonLK);
        // menambahkan radioButtonPR
        bg.add(radioButtonPR);
        
        /* baris kode ini untuk menambahkan itemlistener fungsinya saat checkbox berubah dipilih
        atau tidak dipilih itemlistener akan dipanggil untuk memperbarui sebuah checkbox 
        */
         checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == 1;
            }
        });
    
        /* baris kode ini untuk menambahkan aksi ke tombol simpan 
         dan ketika tombol tersebut di tekan actionperformed akan di eksekusi 
         */
    button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ini adalah baris kode pengkondisian untuk memilih jenis kelamin berbentuk radioButton
                String nama = textFieldNama.getText();
                String noTelp = textFieldNotelp.getText();
                String jenisKelamin = "";
                String WNA = "";

                if (radioButtonLK.isSelected()) {
                    jenisKelamin = radioButtonLK.getText();
                }
                if (radioButtonPR.isSelected()) {
                    jenisKelamin = radioButtonPR.getText();
                }

                // jika checkBoxSelected bernilai true,
                if (checkBoxSelected) {
                    // string WNA: Ya dimasukan ke textarea
                    WNA = "Ya";
                    // jika checkBoxSelected bernilai false,
                } else {
                    // string WNA: Bukan dimasukan ke textarea
                    WNA = "Bukan";
                }
                // baris kode ini adalah untuk menampilkan output atau hasil dari sebuah input
                txtOutput.append(" Nama  : " + nama + "\n" +
                        " Nomor HP   : " + noTelp + "\n" +
                        " Jenis Kelamin  : " + jenisKelamin + "\n" +
                        " WNA    : " + WNA + "\n =============================== \n");

                // kembalikan textfield Nama dan Notelp ke kondisi awal
                textFieldNama.setText("");
                textFieldNotelp.setText("");
            }
        });

     // menambahkan panel 
        controlPanel.add(panel);
        // atur layout frame menjadi GridLayout dengan 3 baris, 2 kolom
        this.setLayout(new GridLayout(3, 2));
        /* masukan semua komponen tadi (headerLabel, controlPanel, txtoutput) ke
         frame */
        this.add(headerLabel);
        this.add(controlPanel);
        this.add(txtOutput);
        
         // membuat frame dengan ukuran 700 x 700
        this.setSize(700, 700);
    }

    /* baris kode ini adalah metode main fungsinya untuk mengatur nya menjadi terlihat 
    dan seharusnya operasi penggunaan swing akan dijalankan. 
    */

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Latihan3 f = new Latihan3();
                f.setVisible(true);
            }
        });
    }
}
