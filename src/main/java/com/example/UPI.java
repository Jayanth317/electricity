package com.example;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class UPI extends JFrame implements ActionListener{
    String MeterNumberValue;
    JButton Cancel;

    UPI(String MeterNumberValue) {
        super("UPI Payments");
        this.MeterNumberValue = MeterNumberValue;
        setBounds(300,400,600,400);

        setLayout(null);

        JEditorPane ep = new JEditorPane();
        ep.setEditable(false);
        try {
            ep.setPage("https://paytm.com/online-payments");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Not loading!");
            ep.setContentType("text/html");
            ep.setText("<html>Sorry could not load :( </html>");
        }
    
        
        JScrollPane sp = new JScrollPane(ep);
        add(sp);

        Cancel = new JButton("Cancel");
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.ORANGE);
        Cancel.setBounds(0, 00, 100, 20);
        Cancel.addActionListener(this);
        add(Cancel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new UPI( "");
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
        new PayBill(MeterNumberValue); 
    }
}
