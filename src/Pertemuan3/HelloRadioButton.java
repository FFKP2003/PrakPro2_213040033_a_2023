/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan3;
import java.awt.event. *;
import javax.swing. *;
/**
 *
 * @author Faqih firdaus k.p
 */
public class HelloRadioButton extends JFrame {
    
    public HelloRadioButton() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       JLabel labelInput = new JLabel("Nama: ");
       labelInput.setBounds(15, 40, 350, 10);
       
       JTextField textField = new JTextField();
       textField.setBounds(15,60,350,30);
       
       JLabel labelRadio = new JLabel("Jenis Member : ");
       labelRadio.setBounds(15,100,350,10);
       
       JRadioButton radioButton1 = new JRadioButton("Silver :", true);
       radioButton1.setBounds(15,115,350,30);
       
       JRadioButton radioButton2 = new JRadioButton("Gold ");
       radioButton2.setBounds(15,145,350,30);
                     
       JRadioButton radioButton3 = new JRadioButton("Platinum :");
       radioButton3.setBounds(15,175,350,30);
       
       ButtonGroup bg = new ButtonGroup();
       bg.add(radioButton1);
       bg.add(radioButton2);
       bg.add(radioButton3);
       
       JButton button = new JButton("Simpan");
       button.setBounds(15,205,100,40);

       JTextArea txtOutput = new JTextArea("");
       txtOutput.setBounds(15,250,350,100);
       
       button.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               String jenisMember = "";
               if(radioButton1.isSelected()) { 
                   jenisMember = radioButton1.getText();
               }
               if(radioButton2.isSelected()) {
                   jenisMember = radioButton2.getText();
               }
               if(radioButton3.isSelected()) {
                   jenisMember = radioButton3.getText();
               }
               
               String nama = textField.getText();
               txtOutput.append("Hello " + nama +"\n");
               txtOutput.append("Anda adalah member " + jenisMember + "\n");
               textField.setText("");
               }
       });
       
       this.add(button);
       this.add(textField);
       this.add(labelRadio);
       this.add(radioButton1);
       this.add(radioButton2);
       this.add(radioButton3);
       this.add(labelInput);
       this.add(txtOutput);
       
       this.setSize(400,500);
       this.setLayout(null);
       
    
       }
     public static void main(String[] args) {
           javax.swing.SwingUtilities.invokeLater(new Runnable() {
               public void run() {
                   HelloRadioButton g = new HelloRadioButton();
                   g.setVisible(true);
               }
           });          
    }
}
    


