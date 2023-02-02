package com.example;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

public class ViewInformation extends JFrame implements ActionListener {
    JButton cancel;
    String meterValue;

    ViewInformation(String meterValue) {
        super("Customer information");
        this.meterValue = meterValue;
        setBounds(300,400,600,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Viewing customer information");
        heading.setBounds(100, 10, 300, 20);
        heading.setFont(new Font("tahoma", Font.BOLD, 16));
        add(heading);

        JLabel Name = new JLabel("Name");
        Name.setBounds(100, 40, 300, 20);
        add(Name);

        JLabel NameField = new JLabel("");
        NameField.setBounds(400, 40, 300, 20);
        add(NameField);

        JLabel Meter = new JLabel("Meter");
        Meter.setBounds(100, 60, 300, 20);
        add(Meter);

        JLabel MeterField = new JLabel("");
        MeterField.setBounds(400, 60, 300, 20);
        add(MeterField);

        JLabel Address = new JLabel("Address");
        Address.setBounds(100, 80, 300, 20);
        add(Address);

        JLabel AddressField = new JLabel("");
        AddressField.setBounds(400, 80, 300, 20);
        add(AddressField);

        JLabel City = new JLabel("City");
        City.setBounds(100, 100, 300, 20);
        add(City);

        JLabel CityField = new JLabel("");
        CityField.setBounds(400, 100, 300, 20);
        add(CityField);

        JLabel State = new JLabel("State");
        State.setBounds(100, 120, 300, 20);
        add(State);

        JLabel StateField = new JLabel("");
        StateField.setBounds(400, 120, 300, 20);
        add(StateField);

        JLabel Phone = new JLabel("Phone");
        Phone.setBounds(100, 140, 300, 20);
        add(Phone);

        JLabel PhoneField = new JLabel("");
        PhoneField.setBounds(400, 140, 300, 20);
        add(PhoneField);

        JLabel Email = new JLabel("Email");
        Email.setBounds(100, 160, 300, 20);
        add(Email);

        JLabel EmailField = new JLabel("");
        EmailField.setBounds(400, 160, 300, 20);
        add(EmailField);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.CYAN);
        cancel.setBounds(100, 200, 100, 20);
        cancel.addActionListener(this);
        add(cancel);

        try {
            DbConnect db = new DbConnect();
            ResultSet rs = db.s.executeQuery("select * from NewCustomer where MeterNumberValue = '" + meterValue + "'");
            while (rs.next()) {
                NameField.setText(rs.getString("CustomerValue"));
                AddressField.setText(rs.getString("AddressValue"));
                CityField.setText(rs.getString("CityValue"));
                StateField.setText(rs.getString("StateValue"));
                EmailField.setText(rs.getString("EmailValue"));
                PhoneField.setText(rs.getString("PhoneValue"));
                MeterField.setText(meterValue);
            }
        } catch (Exception e) {
            //
        }

        // add image
        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewInformation("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            setVisible(false);
        }
    }
}
