/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import compressordecompressor.CompressorDecompressor;
import compressordecompressor.Decompress;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.plaf.FileChooserUI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 91887
 */
public class View extends JFrame implements ActionListener {
    JButton compressbutton;
    JButton decompressbutton;
    View(){
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        compressbutton =new JButton("Select a file to compress ");
        compressbutton.addActionListener(this);
        compressbutton.setBounds(30, 100, 200, 30);
        decompressbutton=new JButton("Select file to decompress");
        decompressbutton.addActionListener(this);
        decompressbutton.setBounds(260, 100, 200, 30);
        this.add(compressbutton);
        this.add(decompressbutton);
        this.setSize(500,200);
        this.getContentPane().setBackground(Color.red);
       // this.getContentPane().
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressbutton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            if(response==filechooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                try{
                    CompressorDecompressor.method(file);
                    JOptionPane.showMessageDialog(null,"Compression is done");
                } catch (Exception excp) {
                    JOptionPane.showMessageDialog(null, excp.toString()); 
                }
            }
        }
        if(e.getSource()==decompressbutton){
            JFileChooser chosefile=new JFileChooser();
            int response =chosefile.showSaveDialog(null);
            if(response==chosefile.APPROVE_OPTION){
                File f=new File(chosefile.getSelectedFile().getAbsolutePath());
                try{
                    Decompress.method(f);
                    JOptionPane.showMessageDialog(null,"DeCompression is done");
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
    }
    public static void main(String[] args) {
        View frame=new View();
        frame.setVisible(true);
    }
}
