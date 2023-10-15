/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan2;
import java.awt.event. *;
import javax.swing. *;
/**
 *
 * @author Faqih firdaus k.p
 */
public class Latihan4 extends JFrame { 
    
    public Latihan4(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        JLabel labelNama = new JLabel("Input Nama");
        labelNama.setBounds(130,30,100,30);
        
        JTextField textFieldNama = new JTextField("");
        textFieldNama.setBounds(130, 60, 100, 30);
        
        JLabel labelNoTelepon = new JLabel("Input No Telepon");
        labelNoTelepon.setBounds(130,90,100,30);
        
        JTextField textFieldNoTelepon = new JTextField("");
        textFieldNoTelepon.setBounds(130, 120, 100, 30);
        
        JButton button = new JButton("Klik");
        button.setBounds(130, 160, 100, 40);
        
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(100, 210, 160, 100);
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String Telepon = textFieldNoTelepon.getText();
                txtOutput.append("Nama : " + nama + "\n" + "Telepon : " + Telepon +  "\n");
                textFieldNama.setText("");
                textFieldNoTelepon.setText("");
            }
        });
        
        this.add(button);
        this.add(textFieldNama);
        this.add(labelNama);
        this.add(textFieldNoTelepon);
        this.add(labelNoTelepon);         
        this.add(txtOutput);
        
        this.setSize(400,500);
        this.setLayout(null);
        }
                public static void main(String[] args) {
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            Latihan4 h = new Latihan4();
                            h.setVisible(true);
                        }
                    });
                      
                }
}



