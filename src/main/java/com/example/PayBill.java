package com.example;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Choice;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PayBill extends JFrame implements ActionListener {
    JLabel BillingMonth, Customer, UnitsConsumed, CustomerField, UnitsConsumedField, MeterNumber, MeterNumberField,
            TotalBill, TotalBillField, Status, StatusField;
    Choice BillingMonthChoice;
    String MeterNumberValue;
    JButton Pay, Back;

    PayBill(String MeterNumberValue) {
        super("Pay bill");
        this.MeterNumberValue = MeterNumberValue;
        setBounds(300, 400, 600, 400);
        setLayout(null);

        JLabel header = new JLabel(" Pay your bills");
        header.setBounds(100, 10, 200, 20);
        header.setFont(new Font("Serif", Font.BOLD, 16));
        add(header);

        Customer = new JLabel("Customer");
        Customer.setBounds(100, 40, 140, 20);
        Customer.setFont(new Font("Cambria", Font.BOLD, 12));
        add(Customer);
        CustomerField = new JLabel("");
        CustomerField.setBounds(250, 40, 150, 20);
        CustomerField.setFont(new Font("Cambria", Font.BOLD, 12));
        add(CustomerField);

        MeterNumber = new JLabel("MeterNumber");
        MeterNumber.setBounds(100, 70, 100, 20);
        add(MeterNumber);
        MeterNumberField = new JLabel("");
        MeterNumberField.setBounds(250, 70, 150, 20);
        add(MeterNumberField);

        UnitsConsumed = new JLabel("UnitsConsumed");
        UnitsConsumed.setBounds(100, 100, 140, 20);
        UnitsConsumed.setFont(new Font("Cambria", Font.BOLD, 12));
        add(UnitsConsumed);
        UnitsConsumedField = new JLabel("");
        UnitsConsumedField.setBounds(250, 100, 150, 20);
        UnitsConsumedField.setFont(new Font("Cambria", Font.BOLD, 12));
        add(UnitsConsumedField);

        BillingMonth = new JLabel("Billing Month");
        BillingMonth.setBounds(100, 130, 140, 20);
        BillingMonth.setFont(new Font("Cambria", Font.BOLD, 12));
        add(BillingMonth);

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
        BillingMonthChoice.setBounds(250, 130, 150, 20);
        add(BillingMonthChoice);

        TotalBill = new JLabel("TotalBill");
        TotalBill.setBounds(100, 160, 140, 20);
        TotalBill.setFont(new Font("Cambria", Font.BOLD, 12));
        add(TotalBill);
        TotalBillField = new JLabel("");
        TotalBillField.setBounds(250, 160, 150, 20);
        TotalBillField.setFont(new Font("Cambria", Font.BOLD, 12));
        add(TotalBillField);

        Status = new JLabel("Status");
        Status.setBounds(100, 190, 140, 20);
        Status.setFont(new Font("Cambria", Font.BOLD, 12));
        add(Status);
        StatusField = new JLabel("");
        StatusField.setBounds(250, 190, 150, 20);
        StatusField.setFont(new Font("Cambria", Font.BOLD, 12));
        add(StatusField);

        try {
            DbConnect db = new DbConnect();
            ResultSet rs = db.s
                    .executeQuery("select *  from NewCustomer where MeterNumberValue ='" + MeterNumberValue + "' ");
            while (rs.next()) {
                MeterNumberField.setText(MeterNumberValue);
                CustomerField.setText(rs.getString("CustomerValue"));
            }
            rs = db.s.executeQuery("select * from Bill where meterNumber = '" + MeterNumberValue
                    + "' and BillingMonth = '" + BillingMonthChoice.getSelectedItem() + "' ");
            while (rs.next()) {
                UnitsConsumedField.setText(rs.getString("UnitsConsumed"));
                TotalBillField.setText(rs.getString("TotalBill"));
                StatusField.setText(rs.getString("Status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        BillingMonthChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg) {
                try {
                    DbConnect db = new DbConnect();
                    ResultSet rs = db.s.executeQuery("select * from Bill where meterNumber = '" + MeterNumberValue
                            + "' and BillingMonth = '" + BillingMonthChoice.getSelectedItem() + "' ");
                    while (rs.next()) {
                        UnitsConsumedField.setText(rs.getString("UnitsConsumed"));
                        TotalBillField.setText(rs.getString("TotalBill"));
                        StatusField.setText(rs.getString("Status"));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Pay = new JButton("Pay");
        Pay.setBackground(Color.black);
        Pay.setForeground(Color.ORANGE);
        Pay.setBounds(100, 250, 100, 20);
        Pay.addActionListener(this);
        add(Pay);

        Back = new JButton("Back");
        Back.setBackground(Color.black);
        Back.setForeground(Color.ORANGE);
        Back.setBounds(220, 250, 100, 20);
        Back.addActionListener(this);
        add(Back);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent arg) {
        if (arg.getSource() == Back) {
            setVisible(false);
        } else if (arg.getSource() == Pay) {
            try {
                DbConnect db = new DbConnect();
                db.s.executeUpdate("update Bill set Status = 'Paid' where MeterNumber = '" + MeterNumberValue + "' ");
                JOptionPane.showMessageDialog(null, "Paid successfully");
                setVisible(false);
                new UPI(MeterNumberValue );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new PayBill("");
    }
}
