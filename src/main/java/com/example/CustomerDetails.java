package com.example;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class CustomerDetails extends JFrame implements ActionListener {
    Choice MeterNumberChoice, MonthNumberChoice;
    JTable table;
    JButton Search, Print;

    CustomerDetails() {
        super("Customer details");
        setBounds(300,400,600,400);

        table = new JTable();
        try {
            DbConnect db = new DbConnect();
            ResultSet rs = db.s.executeQuery("select * from NewCustomer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 100, 700, 600);
        add(sp);

        Print = new JButton("Print");
        Print.addActionListener(this);
        add(Print, "South");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg) {
        try {
            table.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CustomerDetails();
    }

}
