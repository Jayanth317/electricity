package com.example;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class DepositDetails extends JFrame implements ActionListener {
    Choice MeterNumberChoice, MonthNumberChoice;
    JTable table;
    JButton Search, Print;

    DepositDetails() {
        super("Deposit details");
        setBounds(300,400,700,400);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel MeterNumber = new JLabel("Search by Meter Number");
        MeterNumber.setBounds(100, 10, 200, 20);
        add(MeterNumber);

        MeterNumberChoice = new Choice();
        MeterNumberChoice.setBounds(300, 10, 200, 20);
        add(MeterNumberChoice);
        try {
            DbConnect db = new DbConnect();
            ResultSet rs = db.s.executeQuery("select * from NewCustomer");
            while (rs.next()) {
                MeterNumberChoice.add(rs.getString("MeterNumberValue"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel MonthNumber = new JLabel("Search by Month");
        MonthNumber.setBounds(100, 40, 200, 20);
        add(MonthNumber);

        MonthNumberChoice = new Choice();
        MonthNumberChoice.add("January");
        MonthNumberChoice.add("February");
        MonthNumberChoice.add("March");
        MonthNumberChoice.add("April");
        MonthNumberChoice.add("May");
        MonthNumberChoice.add("June");
        MonthNumberChoice.add("July");
        MonthNumberChoice.add("August");
        MonthNumberChoice.add("September");
        MonthNumberChoice.add("October");
        MonthNumberChoice.add("November");
        MonthNumberChoice.add("December");
        MonthNumberChoice.setBounds(300, 40, 200, 20);
        add(MonthNumberChoice);

        table = new JTable();
        try {
            DbConnect db = new DbConnect();
            ResultSet rs = db.s.executeQuery("select * from Bill");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 100, 700, 600);
        add(sp);

        Search = new JButton("Search");
        Search.setBounds(100, 70, 100, 20);
        Search.addActionListener(this);
        add(Search);

        Print = new JButton("Print");
        Print.setBounds(200, 70, 100, 20);
        Print.addActionListener(this);
        add(Print);

        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent arg) {
        if (arg.getSource() == Search) {
            String query = "select * from Bill where MeterNumber = " +MeterNumberChoice.getSelectedItem() + " and BillingMonth =  '"+MonthNumberChoice.getSelectedItem()+"' ";
            try {
                DbConnect db = new DbConnect();
                ResultSet rs = db.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new DepositDetails();
    }

    

}
