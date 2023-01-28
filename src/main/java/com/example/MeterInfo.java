package com.example;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MeterInfo extends JFrame implements ActionListener {
    JLabel MeterNumber, MeterNumberValue1, Meterty, Location, Supplier, Billing, header, Note;

    JButton Back, Submit; // submit
    Choice MeterTy, MeterLoc, PowerSupp, BillType;
    String MeternumberValue;

    MeterInfo(String MeterNumberValue) {
        super("Meter details");
        this.MeternumberValue = MeternumberValue;
        setSize(700, 500);
        setLocation(400, 300);

        JPanel jp = new JPanel();
        jp.setLayout(null);
        jp.setBackground(Color.LIGHT_GRAY);
        add(jp);

        // insert images
        ImageIcon i1 = new ImageIcon("//home//maniac//Desktop//electricity//src//icon//image2.png");
        Image i12 = i1.getImage().getScaledInstance(8, 8, Image.SCALE_DEFAULT);

        header = new JLabel("Meter details");
        header.setBounds(100, 10, 140, 20);
        header.setFont(new Font("Tahoma", Font.BOLD, 18));
        jp.add(header);

        MeterNumber = new JLabel("Meter Number");
        MeterNumber.setBounds(100, 40, 140, 20);
        MeterNumber.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(MeterNumber);

        MeterNumberValue1 = new JLabel(MeterNumberValue);
        MeterNumberValue1.setBounds(250, 40, 140, 20);
        MeterNumberValue1.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(MeterNumberValue1);

        Meterty = new JLabel("Meter Type");
        Meterty.setBounds(100, 70, 140, 20);
        Meterty.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(Meterty);
        MeterTy = new Choice();
        MeterTy.add("Analog");
        MeterTy.add("Digital");
        MeterTy.add("Smart");
        MeterTy.setBounds(250, 70, 150, 20);
        add(MeterTy);

        Location = new JLabel("Meter Location");
        Location.setBounds(100, 100, 140, 20);
        Location.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(Location);
        MeterLoc = new Choice();
        MeterLoc.add("Interior");
        MeterLoc.add("Exterior");
        MeterLoc.setBounds(250, 100, 150, 20);
        add(MeterLoc);

        Supplier = new JLabel("Power Supplier");
        Supplier.setBounds(100, 130, 140, 20);
        Supplier.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(Supplier);
        PowerSupp = new Choice();
        PowerSupp.add("Local");
        PowerSupp.add("State");
        PowerSupp.add("Central");
        PowerSupp.add("Overseas");
        PowerSupp.setBounds(250, 130, 150, 20);
        add(PowerSupp);

        Billing = new JLabel("Billing Type");
        Billing.setBounds(100, 160, 140, 20);
        Billing.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(Billing);
        BillType = new Choice();
        BillType.add("Residential");
        BillType.add("Industrial");
        BillType.add("Conservation");
        BillType.setBounds(250, 160, 150, 20);
        add(BillType);

        Note = new JLabel("Billing is done for 30 days as normal ");
        Note.setBounds(100, 200, 300, 20);
        Note.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(Note);
        // Buttons
        Back = new JButton("Submit", new ImageIcon(i12));
        Back.setBackground(Color.black);
        Back.setForeground(Color.ORANGE);
        Back.setBounds(100, 250, 100, 20);
        Back.addActionListener(this);
        jp.add(Back);

        Submit = new JButton("Cancel", new ImageIcon(i12));
        Submit.setBackground(Color.black);
        Submit.setForeground(Color.ORANGE);
        Submit.setBounds(220, 250, 100, 20);
        Submit.addActionListener(this);
        jp.add(Submit);

        setLayout(new BorderLayout());
        add(jp);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg) {
        if (arg.getSource() == Submit) {
            setVisible(false);
        } else {
            String MeterNumberValue1 = this.MeternumberValue;
            String MeterType = MeterTy.getSelectedItem();
            String MeterLocation = MeterLoc.getSelectedItem();
            String PowerSupplier = PowerSupp.getSelectedItem();
            String BillingType = BillType.getSelectedItem();
            String Days = "30";

            String query1 = "insert into meterInfo values('" 
                    + MeterNumberValue1 + "','" 
                    + MeterType + "','" 
                    + MeterLocation + "','"
                    + PowerSupplier + "','" 
                    + BillingType + "','"
                    + Days + "')";

            try {
                DbConnect db = new DbConnect();
                db.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Customer details added succesfully!");
                setVisible(false);
                new Login();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new MeterInfo("");
    }
}
