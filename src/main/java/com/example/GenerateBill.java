package com.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.*;

public class GenerateBill extends JFrame implements ActionListener {
    Choice BillingMonthChoice;
    JButton Generate;
    JLabel Email, MeterNumber,MeterNumberValue1;
    String MeterNumberValue;
    JTextArea area;

    GenerateBill(String MeterNumberValue) {
        super("Generated Bill");
        this.MeterNumberValue= MeterNumberValue;
        setBounds(300, 0, 500, 800);
        setLayout(new BorderLayout());
    

        JPanel panel = new JPanel();
        
        MeterNumber = new JLabel("Meter Number");
        MeterNumber.setBounds(10, 10, 140, 20);
        MeterNumber.setFont(new Font("Cambria", Font.BOLD, 12));
        panel.add(MeterNumber);

        MeterNumberValue1 = new JLabel(MeterNumberValue);
        MeterNumberValue1.setBounds(250, 10, 140, 20);
        MeterNumberValue1.setFont(new Font("Cambria", Font.BOLD, 12));
        panel.add(MeterNumberValue1);

        Email = new JLabel("Select Month of Billing");
        Email.setBounds(10, 40, 140, 20);
        Email.setFont(new Font("Cambria", Font.BOLD, 12));
        panel.add(Email);

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
        BillingMonthChoice.setBounds(250, 30, 150, 20);
        panel.add(BillingMonthChoice);

         area = new JTextArea(35, 30);
        area.setText("\tClick on the generate bill button \n\t to print bill of selected month");
        add(area);
        add(panel,"North");

        JScrollPane pane = new JScrollPane(area);
        add(pane,"Center");
        

        Generate = new JButton("Generate");
        Generate.setBackground(Color.black);
        Generate.setForeground(Color.ORANGE);
        Generate.setBounds(100, 10, 100, 20);
        Generate.addActionListener(this);
        add(Generate,"South");

        setVisible(true);
    }

    public static void main(String[] args) {
        new GenerateBill("");
    }

    @Override
    public void actionPerformed(ActionEvent arg) {
                // setVisible(false);
                try {
                    DbConnect db = new DbConnect();
                    String month = BillingMonthChoice.getSelectedItem();
                    area.setText("KPTCL \n Electricity for the month of '"+month+"' ");
                    ResultSet rs = db.s.executeQuery( "select * from NewCustomer where MeterNumberValue = '"+MeterNumberValue+"' ");
                    while (rs.next()){
                        area.append("\nCustomer Name : " + rs.getString("CustomerValue"));
                        area.append("\nAddress : " + rs.getString("AddressValue"));
                        area.append("\nCity : " + rs.getString("CityValue"));
                        area.append("\nState : " + rs.getString("StateValue"));
                        area.append("\nEmail : " + rs.getString("EmailValue"));
                        area.append("\nPhone Number : " + rs.getString("PhoneValue"));
                    }
                    rs = db.s.executeQuery( "select * from meterInfo where MeterNumber = '"+MeterNumberValue+"' ");
                    while (rs.next()){
                        area.append("\n\nMeter Type : " + rs.getString("MeterType"));
                        area.append("\nMeter Location : " + rs.getString("MeterLocation"));
                        area.append("\nPower Supplier : " + rs.getString("PowerSupplier"));
                        area.append("\nBilling Type : " + rs.getString("BillingType"));
                        area.append("\nBilling done for : " + rs.getString("Days") + "days");
                    }
                    rs = db.s.executeQuery( "select * from Bill where MeterNumber = '"+MeterNumberValue+"' and BillingMonth = '"+month+"' ");
                    while (rs.next()){
                        area.append("\n\n Present Month : " + rs.getString("BillingMonth"));
                        area.append("\n Units consumed : " + rs.getString("UnitsConsumed"));
                        area.append("\n Total Bill : " + rs.getString("TotalBill"));
                        area.append("\n Billing Status : " + rs.getString("Status"));
                    }
                    rs = db.s.executeQuery( "select * from taxation ");
                    while (rs.next()){
                        area.append("\n\nPer Unit Cost : " + rs.getString("perunitCost"));
                        area.append("\n Meter Rent : " + rs.getString("meterRent"));
                        area.append("\n Service Charges : " + rs.getString("serviceCharge"));
                        area.append("\n Service Tax : " + rs.getString("serviceTax"));
                        area.append("\n Fund Tax : " + rs.getString("fundTax"));
                        area.append("\n Fixed Tax : " + rs.getString("fixedTax"));
                        
                        
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

    }
}
