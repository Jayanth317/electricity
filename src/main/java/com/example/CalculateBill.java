package com.example;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculateBill extends JFrame implements ActionListener {
    JLabel Customer, Address, AddressField, UserName, UserNameField, UnitsConsumed, BillingMonth, header;
    JTextField UnitsConsumedField;
    JButton Submit, Cancel;
    Choice MeterNumberChoice, BillingMonthChoice;

    CalculateBill() {
        // distance from left,top,width,height
        setSize(700, 500);
        setLocation(400, 300);

        JPanel jp = new JPanel();
        jp.setLayout(null);
        jp.setBackground(Color.CYAN);
        add(jp);

        // insert images
        ImageIcon i1 = new ImageIcon("//home//maniac//Desktop//electricity//src//icon//image2.png");
        Image i12 = i1.getImage().getScaledInstance(8, 8, Image.SCALE_DEFAULT);

        header = new JLabel("Calculate your bill");
        header.setBounds(100, 10, 340, 20);
        header.setFont(new Font("Tahoma", Font.BOLD, 18));
        jp.add(header);

        Customer = new JLabel("Meter Number");
        Customer.setBounds(100, 40, 140, 20);
        Customer.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(Customer);

        MeterNumberChoice = new Choice();
        try {
            DbConnect db = new DbConnect();
            ResultSet rs = db.s.executeQuery("select * from NewCustomer");
            while (rs.next()) {
                MeterNumberChoice.add(rs.getString("MeterNumberValue"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        MeterNumberChoice.setBounds(250, 40, 150, 20);
        add(MeterNumberChoice);

        UserName = new JLabel("UserName");
        UserName.setBounds(100, 70, 140, 20);
        UserName.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(UserName);
        UserNameField = new JLabel();
        UserNameField.setBounds(250, 70, 140, 20);
        UserNameField.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(UserNameField);

        Address = new JLabel("Address");
        Address.setBounds(100, 100, 140, 20);
        Address.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(Address);
        AddressField = new JLabel();
        AddressField.setBounds(250, 100, 150, 20);
        AddressField.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(AddressField);

        MeterNumberChoice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent s) {
                try {
                    DbConnect db = new DbConnect();
                    ResultSet rs2 = db.s.executeQuery(
                            "select * from NewCustomer where MeterNumberValue = '" + MeterNumberChoice.getSelectedItem()
                                    + "'");
                    while (rs2.next()) {
                        UserNameField.setText(rs2.getString("CustomerValue"));
                        AddressField.setText(rs2.getString("AddressValue"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        UnitsConsumed = new JLabel("UnitsConsumed");
        UnitsConsumed.setBounds(100, 130, 140, 20);
        UnitsConsumed.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(UnitsConsumed);
        UnitsConsumedField = new JTextField("");
        UnitsConsumedField.setBounds(250, 130, 150, 20);
        UnitsConsumedField.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(UnitsConsumedField);

        BillingMonth = new JLabel("Billing Month");
        BillingMonth.setBounds(100, 160, 140, 20);
        BillingMonth.setFont(new Font("Cambria", Font.BOLD, 12));
        jp.add(BillingMonth);

        BillingMonthChoice = new Choice();
        BillingMonthChoice.add("January");
        BillingMonthChoice.add("February");
        BillingMonthChoice.add("March");
        BillingMonthChoice.add("April");
        BillingMonthChoice.add("May");
        BillingMonthChoice.add("June");
        BillingMonthChoice.add("July");
        BillingMonthChoice.add("August");
        BillingMonthChoice.add("September");
        BillingMonthChoice.add("October");
        BillingMonthChoice.add("November");
        BillingMonthChoice.add("December");
        BillingMonthChoice.setBounds(250, 160, 150, 20);
        jp.add(BillingMonthChoice);

        // Buttons
        Submit = new JButton("Submit", new ImageIcon(i12));
        Submit.setBackground(Color.black);
        Submit.setForeground(Color.ORANGE);
        Submit.setBounds(100, 250, 100, 20);
        Submit.addActionListener(this);
        jp.add(Submit);

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
            String MeterNumberValue = MeterNumberChoice.getSelectedItem();
            int UnitsConsumed = Integer.parseInt(UnitsConsumedField.getText());
            String MonthSelected = BillingMonthChoice.getSelectedItem();

            int totalBill = 0;
            String query1 = "select * from taxation";
            try {
                DbConnect db = new DbConnect();
                ResultSet rs = db.s.executeQuery(query1);

                while (rs.next()) {
                    totalBill += UnitsConsumed * Integer.parseInt(rs.getString("perunitCost"));
                    totalBill += Integer.parseInt(rs.getString("meterRent"))
                            + Integer.parseInt(rs.getString("serviceCharge"))
                            + Integer.parseInt(rs.getString("serviceTax"))
                            + Integer.parseInt(rs.getString("fundTax"))
                            + Integer.parseInt(rs.getString("fixedTax"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            String query2 = "insert into Bill values('"
            + MeterNumberValue + "','"
            + MonthSelected + "','"
            + UnitsConsumed + "','"
            + totalBill + "','Not Paid')";

            try {
                DbConnect db = new DbConnect();
                db.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Billing done successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new CalculateBill();

    }
}
