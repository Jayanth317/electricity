package com.example;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewCustomer extends JFrame implements ActionListener {
    JLabel Customer, Address, MeterNumber, City, State, Email, ranNum, Phone;
    JTextField CustomerField, AddressField, MeterNumberFieldyField, Field, EmailField, PhoneField, CityField,
            StateField;
    JButton Next, Cancel;

    NewCustomer() {
        // distance from left,top,width,height
        setSize(700, 500);
        setLocation(400, 300);

        JPanel jp = new JPanel();
        jp.setLayout(null);
        jp.setBackground(Color.CYAN);
        add(jp);

        // Random function to generate random meter number
        Random random = new Random();
        long number = Math.abs(random.nextLong() % 100000);

        // insert images
        ImageIcon i1 = new ImageIcon("//home//maniac//Desktop//electricity//src//icon//image2.png");
        Image i12 = i1.getImage().getScaledInstance(8, 8, Image.SCALE_DEFAULT);

        Customer = new JLabel("Customer");
        Customer.setBounds(100, 40, 140, 20);
        Customer.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(Customer);
        CustomerField = new JTextField("Customer Name");
        CustomerField.setBounds(250, 40, 150, 20);
        CustomerField.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(CustomerField);

        Address = new JLabel("Address");
        Address.setBounds(100, 70, 140, 20);
        Address.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(Address);
        AddressField = new JTextField("Address");
        AddressField.setBounds(250, 70, 150, 20);
        AddressField.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(AddressField);

        MeterNumber = new JLabel("Meter Number");
        MeterNumber.setBounds(100, 100, 140, 20);
        MeterNumber.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(MeterNumber);
        ranNum = new JLabel("");
        ranNum.setBounds(250, 100, 100, 20);
        ranNum.setText("" + number);
        jp.add(ranNum);

        City = new JLabel("City");
        City.setBounds(100, 130, 140, 20);
        City.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(City);
        CityField = new JTextField("City");
        CityField.setBounds(250, 130, 150, 20);
        CityField.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(CityField);

        State = new JLabel("State");
        State.setBounds(100, 160, 140, 20);
        State.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(State);
        StateField = new JTextField("StatField");
        StateField.setBounds(250, 160, 150, 20);
        StateField.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(StateField);

        Email = new JLabel("New Email");
        Email.setBounds(100, 190, 140, 20);
        Email.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(Email);
        EmailField = new JTextField("Email");
        EmailField.setBounds(250, 190, 150, 20);
        EmailField.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(EmailField);

        Phone = new JLabel("New Phone");
        Phone.setBounds(100, 220, 140, 20);
        Phone.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(Phone);
        PhoneField = new JTextField("Phone");
        PhoneField.setBounds(250, 220, 150, 20);
        PhoneField.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(PhoneField);

        // Buttons
        Next = new JButton("Next", new ImageIcon(i12));
        Next.setBackground(Color.black);
        Next.setForeground(Color.ORANGE);
        Next.setBounds(100, 250, 100, 20);
        Next.addActionListener(this);
        jp.add(Next);

        Cancel = new JButton("Cancel", new ImageIcon(i12));
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.ORANGE);
        Cancel.setBounds(220, 250, 100, 20);
        Cancel.addActionListener(this);
        jp.add(Cancel);

        setLayout(new BorderLayout());
        add(jp);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg) {
        if (arg.getSource() == Cancel) {
            setVisible(false);
        } else {
            String CustomerValue = CustomerField.getText();
            String MeterNumberValue = ranNum.getText();
            String AddressValue = AddressField.getText();
            String CityValue = CityField.getText();
            String StateValue = StateField.getText();
            String EmailValue = EmailField.getText();
            String PhoneValue = PhoneField.getText();

            String query1 = "insert into NewCustomer values('"
                    + CustomerValue + "','"
                    + MeterNumberValue + "','"
                    + AddressValue + "','"
                    + CityValue + "','"
                    + StateValue + "','"
                    + EmailValue + "','"
                    + PhoneValue + "')";
            String query2 = "insert into logindata values('"
                    + MeterNumberValue + "','"
                    + CustomerValue + "','','')";

            try {
                DbConnect db = new DbConnect();
                db.s.executeUpdate(query1);
                db.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Customer details added succesfully!"+MeterNumberValue);
                setVisible(false);
                
                new MeterInfo(MeterNumberValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new NewCustomer();

    }
}
