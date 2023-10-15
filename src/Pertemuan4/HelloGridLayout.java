/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan4;
import java.awt. *;
import java.awt.event. *;
import javax.swing. *;
/**
 *
 * @author Faqih firdaus k.p
 */

// ini adalah baris kode untuk mendeklarasikan kelas HelloGridLayout yaitu turunan dari JFrame dan untuk mengimplementasikan ActionListener dan fungsi kelas ini adalah frame untuk GUI. 
public class HelloGridLayout extends JFrame implements ActionListener  {
    private JButton buttonA; // ini adalah pendeklarasian sembilan tombol yang digunakan untuk papan permainan tic-tac-toe.
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;
    private JButton buttonE;
    private JButton buttonF;
    private JButton buttonG;
    private JButton buttonH;
    private JButton buttonI;
    
    // baris kode ini adalah deklarasi sebuah variabel buttons dari sembilan tombol dan variabel boolean gameOver itu untuk menandakan bahwa permainan telah berakhir.
    private JButton[] buttons;
    private boolean gameOver;

    // ini adalah baris kode konstruktor dan pada baris ke 32 itu fungsinya untuk menghentikan output ketika di tutup dan untuk mengatur operasi penutupan output ketika tombol penutup di klik.
    public HelloGridLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gameOver = false; // baris kodei ini untuk menandakan bahwa permainan belum dimulai.
        
        // baris kode ini untuk merespon tindakan pengguna dengan menambahkan ActionListener.
        buttonA = new JButton("");
        buttonB = new JButton("");
        buttonC = new JButton("");
        buttonD = new JButton("");
        buttonE = new JButton("");
        buttonF = new JButton("");
        buttonG = new JButton("");
        buttonH = new JButton("");
        buttonI = new JButton("");
      
        buttons = new JButton[9];
        buttons[0] = buttonA;
        buttons[1] = buttonB;
        buttons[2] = buttonC;
        buttons[3] = buttonD;
        buttons[4] = buttonE;
        buttons[5] = buttonF;
        buttons[6] = buttonG;
        buttons[7] = buttonH;
        buttons[8] = buttonI;
        
        buttonA.addActionListener(this);
        buttonB.addActionListener(this);
        buttonC.addActionListener(this);
        buttonD.addActionListener(this);
        buttonE.addActionListener(this);
        buttonF.addActionListener(this);
        buttonG.addActionListener(this);
        buttonH.addActionListener(this);
        buttonI.addActionListener(this);
        
        // baris kode ini untuk mengatur tata letak tandanya GridLayout itu tata letaknya di bikin 3baris dan 3 kolom.
        this.setLayout(new GridLayout(3, 3));
        
        // ini adalah baris kode untuk menambahkan tombol tombol pada frame sesuai dengan tata letak GridLayout yang udah diatur sebelumnya.
        this.add(buttonA);
        this.add(buttonB);
        this.add(buttonC);
        this.add(buttonD);
        this.add(buttonE);
        this.add(buttonF);
        this.add(buttonG);
        this.add(buttonH);
        this.add(buttonI);
        
        // baris kode ini untuk mengatur ukuran frame.
        this.setSize(300, 400);
        
    }

    // baris kode ini yaitu pengkondisian dimana ketika salah satu tombol diklik ia akan muncul tombol O dan X secara bergantian logikanya seperti ini jika tombol di klik mengeluarkan O ketika permainan belum ada pemenang atau belum berakhir dan klik selanjutnya akan mengganti teks tombol X.
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            JButton button = (JButton) e.getSource();
            if (button.getText().isEmpty()) {
                button.setText("0");
                checkWinner();
                if (!gameOver) {
                    for (int i = 0; i < buttons.length; i++) {
                        if(buttons[i].getText().isEmpty()) {
                           buttons[i].setText("X");
                           break;
                        }               
                    }
                    checkWinner(); // kode baris ini untuk mengecek apakah sudah ada pemenangnya atau permainan nya seri. 
                }
            }
        }
    }
    
    // baris kode ini menjelaskan bahwa winner itu digunakan untuk menyimpan simbol X dan O dari pemain yang menang dalam permainan dan di inisialisasikan dengan string kosong.
    private void checkWinner() {
        String winner = "";
        // kode baris ini fungsinya untuk pengecekan apakah tombol A ini memiliki teks yang tidak kosong dan apakah tombol A tersebut memiliki teks yang sama dengan tombol B dan C jika ada kesamaan, maka pemain yang memiliki tanda pada tombol A dialah pemenangnya dan variabel winner yang ada di baris 115 tersebut akan merubah tombol A,B dan C menjadi warna merah untuk menunjukkan bahwa pemain tersebut telah menang.
        if (!buttonA.getText().isEmpty()
            && buttonA.getText().equals(buttonB.getText())
            && buttonA.getText().equals(buttonC.getText())) 
        {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonB.setForeground(Color.RED);
            buttonC.setForeground(Color.RED);
        } else if (!buttonD.getText().isEmpty()
            && buttonD.getText().equals(buttonE.getText())
            && buttonD.getText().equals(buttonF.getText()))
        {
            winner = buttonD.getText();
            buttonD.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonF.setForeground(Color.RED);
        } else if (!buttonG.getText().isEmpty()
            && buttonG.getText().equals(buttonH.getText())
            && buttonG.getText().equals(buttonI.getText()))
        {
            winner = buttonG.getText();
            buttonG.setForeground(Color.RED);
            buttonH.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        } else if (!buttonA.getText().isEmpty()
            && buttonA.getText().equals(buttonD.getText())
            && buttonA.getText().equals(buttonG.getText()))
        {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonD.setForeground(Color.RED);
            buttonG.setForeground(Color.RED);
        } else if (!buttonB.getText().isEmpty()
            && buttonB.getText().equals(buttonE.getText())
            && buttonB.getText().equals(buttonH.getText()))
        {
            winner = buttonB.getText();
            buttonB.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonH.setForeground(Color.RED);
        } else if (!buttonC.getText().isEmpty()
            && buttonC.getText().equals(buttonF.getText())
            && buttonC.getText().equals(buttonI.getText()))
        {
            winner = buttonC.getText();
            buttonC.setForeground(Color.RED);
            buttonF.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        } else if (!buttonA.getText().isEmpty()
            && buttonA.getText().equals(buttonE.getText())
            && buttonA.getText().equals(buttonI.getText()))
        {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        } else if (!buttonC.getText().isEmpty()
            && buttonC.getText().equals(buttonE.getText())
            && buttonC.getText().equals(buttonG.getText()))
        {
            winner = buttonC.getText();
            buttonC.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonG.setForeground(Color.RED);
        } 

        gameOver = !winner.isEmpty(); // baris kode ini adalah jika winner tidak kosong atau sudah ada pemenagnya maka game tersebut telah selesai.
    }
    
    // baris kode ini adalah metode main fungsinya untuk mengatur nya menjadi terlihat dan seharusnya operasi penggunaan swing akan dijalankan.
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloGridLayout f = new HelloGridLayout();
                f.setVisible(true);
            }
        });
    }   
}

