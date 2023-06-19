package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import comp_decmp.Compressor;
import comp_decmp.Decompressor;

public class AppFrame extends JFrame implements ActionListener{
    JButton CompressButton;
    JButton DecompressButton;
    AppFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CompressButton = new JButton("Select file to Compress");
        CompressButton.setBounds(300, 100, 200, 30);
        CompressButton.addActionListener(this);
        DecompressButton = new JButton("Select file to Decompress");
        DecompressButton.setBounds(250, 100, 200, 30);
        DecompressButton.addActionListener(this);
        this.add(CompressButton);
        this.add(DecompressButton);
        this.setSize(1000, 1000);
        this.getContentPane().setBackground(Color.gray);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==CompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response=fileChooser.showSaveDialog(null);
            if (response==JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    Compressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null,e.toString());
                }
            }
        }
         if (e.getSource()==DecompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response=fileChooser.showSaveDialog(null);
            if (response==JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    Decompressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null,e.toString());
                }
            }
        }
    }

}
