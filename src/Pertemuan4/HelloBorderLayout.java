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
public class HelloBorderLayout extends JFrame {
    public HelloBorderLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel labelPertanyaan = new JLabel("Apakah ibukota Indonesia?");
        JLabel labelHasil = new JLabel("Jawab pertanyaan di atas");
                
                JButton buttonA = new JButton("Jakarta");
                JButton buttonB = new JButton("Bandung");
                JButton buttonC = new JButton("Surabaya");
                
                buttonA.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        labelHasil.setText("Jawaban anda benar");
                    }
                });
                
                buttonB.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        labelHasil.setText("Jawaban anda salah");
                    }
                });
                
                buttonC.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        labelHasil.setText("Jawaban anda salah");
                    }
                });
                
                this.add(labelPertanyaan, BorderLayout.NORTH);
                this.add(labelHasil, BorderLayout.SOUTH);
                this.add(buttonA, BorderLayout.WEST);
                this.add(buttonB, BorderLayout.CENTER);
                this.add(buttonC, BorderLayout.EAST);
                
                this.setSize(400, 200);
    }
                public static void main(String[] args) {
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        HelloBorderLayout f = new HelloBorderLayout();
                        f.setVisible(true);
                }
});
}
}
