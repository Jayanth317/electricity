package com.example;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.*;

public class UpdateInformation extends JFrame implements ActionListener {
    JLabel Customer, Address, MeterNumber, City, State, Email, ranNum, Phone;
    JTextField CustomerField, AddressField, MeterNumberFieldyField, Field, EmailField, PhoneField, CityField,
            StateField;
    JButton Next, Cancel;
    String MeterNumberValue;

    UpdateInformation(String MeterNumberValue) {
        super("Update information");
        this.MeterNumberValue = MeterNumberValue;
        setBounds(300, 400, 800, 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        Customer = new JLabel("Customer");
        Customer.setBounds(100, 40, 140, 20);
        Customer.setFont(new Font("Cambria", Font.BOLD, 12));
        add(Customer);

        MeterNumber = new JLabel("Meter Number");
        MeterNumber.setBounds(100, 70, 140, 20);
        MeterNumber.setFont(new Font("Cambria", Font.BOLD, 12));
        add(MeterNumber);

        Address = new JLabel("Address");
        Address.setBounds(100, 100, 140, 20);
        Address.setFont(new Font("Cambria", Font.BOLD, 12));
        add(Address);
        AddressField = new JTextField("Address");
        AddressField.setBounds(250, 100, 150, 20);
        AddressField.setFont(new Font("Cambria", Font.BOLD, 12));
        add(AddressField);

        City = new JLabel("City");
        City.setBounds(100, 130, 140, 20);
        City.setFont(new Font("Cambria", Font.BOLD, 12));
        add(City);
        CityField = new JTextField("City");
        CityField.setBounds(250, 130, 150, 20);
        CityField.setFont(new Font("Cambria", Font.BOLD, 12));
        add(CityField);

        State = new JLabel("State");
        State.setBounds(100, 160, 140, 20);
        State.setFont(new Font("Cambria", Font.BOLD, 12));
        add(State);
        StateField = new JTextField("StateField");
        StateField.setBounds(250, 160, 150, 20);
        StateField.setFont(new Font("Cambria", Font.BOLD, 12));
        add(StateField);

        Email = new JLabel("New Email");
        Email.setBounds(100, 190, 140, 20);
        Email.setFont(new Font("Cambria", Font.BOLD, 12));
        add(Email);
        EmailField = new JTextField("Email");
        EmailField.setBounds(250, 190, 150, 20);
        EmailField.setFont(new Font("Cambria", Font.BOLD, 12));
        add(EmailField);

        Phone = new JLabel("New Phone");
        Phone.setBounds(100, 220, 140, 20);
        Phone.setFont(new Font("Cambria", Font.BOLD, 12));
        add(Phone);
        PhoneField = new JTextField("Phone");
        PhoneField.setBounds(250, 220, 150, 20);
        PhoneField.setFont(new Font("Cambria", Font.BOLD, 12));
        add(PhoneField);

        // Buttons
        Next = new JButton("Update");
        Next.setBackground(Color.black);
        Next.setForeground(Color.ORANGE);
        Next.setBounds(100, 250, 100, 20);
        Next.addActionListener(this);
        add(Next);

        Cancel = new JButton("Cancel");
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.ORANGE);
        Cancel.setBounds(220, 250, 100, 20);
        Cancel.addActionListener(this);
        add(Cancel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg) {
        if (arg.getSource() == Next) {
            String AddressValue = AddressField.getText();
            String CityValue = CityField.getText();
            String StateValue = StateField.getText();
            String EmailValue = EmailField.getText();
            String PhoneValue = PhoneField.getText();

            String query1 = "update NewCustomer set AddressValue =  '" + AddressValue + 
            "',CityValue = '" + CityValue + "',StateValue = '" + StateValue + "',EmailValue = '" + EmailValue + "' ,PhoneValue = '"
                    + PhoneValue + "' where MeterNumberValue = '"+MeterNumberValue+"' ";
            try {
                DbConnect db = new DbConnect();
                db.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Customer details updated succesfully!");
                setVisible(false);
                new MeterInfo(MeterNumberValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateInformation("");
    }
}