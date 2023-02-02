package com.example;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class BillDetails extends JFrame {
    String MeterNumberValue;
    BillDetails(String MeterNumberValue){
        super("Bill Details ");
        this.MeterNumberValue = MeterNumberValue;
        getContentPane().setBackground(Color.lightGray);
        setBounds(300,400,600,400);

        JTable table = new JTable();

        try {
            DbConnect db = new DbConnect();
            String query = "select * from Bill where MeterNumber = '"+MeterNumberValue+"'";
            ResultSet rs = db.s.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,600,400);
        add(sp);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BillDetails("");
    }
}
