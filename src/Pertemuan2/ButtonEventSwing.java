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
public class ButtonEventSwing extends JFrame {
    public ButtonEventSwing() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel label = new JLabel("Hello world");
        label.setBounds(130,40,400,30);
        
        JButton button = new JButton("Klik");
        button.setBounds(130,100,100,40);
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                label.setText("Hello Pemograman II");
            }
        });
        
        this.add(button);
        this.add(label);
        
        this.setSize(400,500);
        this.setLayout(null);
  
   
}
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ButtonEventSwing b = new ButtonEventSwing();
                b.setVisible(true);
            }
        });
    }
    }
