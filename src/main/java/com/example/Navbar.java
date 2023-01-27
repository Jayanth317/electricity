package com.example;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.*;
import java.awt.event.*;

public class Navbar extends JFrame {
    Navbar() {
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(450, 150, 700, 400);
        ImageIcon i1 = new ImageIcon("//home//maniac//Desktop//electricity//src//icon//image2.png");
        Image i12 = i1.getImage().getScaledInstance(700, 400, Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12);
        JLabel image = new JLabel(i13);
        add(image);

        ImageIcon i2 = new ImageIcon("//home//maniac//Desktop//electricity//src//icon//image2.png");
        Image i22 = i2.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);

        //object of the main navbar
        JMenuBar navbar = new JMenuBar();

        //menu that pops up when navbar item is clicked - like dropdown
        //navbar elements
        JMenu Home = new JMenu("Home");
        navbar.add(Home);

        JMenu Billing = new JMenu("Billing");
        navbar.add(Billing);

        JMenu Help = new JMenu("Help");
        navbar.add(Help);

        //dropdown elements
        //Home button
        JMenuItem HomeScreen = new JMenuItem("Home", new ImageIcon(i22));
        HomeScreen.setBackground(Color.GREEN);
        HomeScreen.setFont(new Font("SERIF", Font.ITALIC, 15));
        Home.add(HomeScreen);

        JMenuItem User = new JMenuItem("User", new ImageIcon(i22));
        User.setBackground(Color.CYAN);
        User.setFont(new Font("SERIF", Font.ITALIC, 15));
        Home.add(User);

        //Billing button
        JMenuItem Bill = new JMenuItem("Bill");
        Bill.setBackground(Color.GRAY);
        Bill.setFont(new Font("SERIF", Font.ITALIC, 16));
        Bill.setIcon(new ImageIcon(i22));
        Bill.setMnemonic('Q');
        Bill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Billing.add(Bill);

        
        JMenuItem GSTBill = new JMenuItem("GST Bill");
        GSTBill.setBackground(Color.GRAY);
        GSTBill.setFont(new Font("SERIF", Font.ITALIC, 16));
        GSTBill.setIcon(new ImageIcon(i22));
        GSTBill.setMnemonic('R');
        GSTBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Billing.add(GSTBill);

        JMenuItem GSTBill2 = new JMenuItem("GSTBill with VAT");
        GSTBill2.setBackground(Color.GRAY);
        GSTBill2.setFont(new Font("SERIF", Font.ITALIC, 16));
        GSTBill2.setIcon(new ImageIcon(i22));
        GSTBill2.setMnemonic('S');
        GSTBill2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Billing.add(GSTBill2);

        //Help button
        JMenuItem helpInBilling = new JMenuItem("Help in Billing..?");
        helpInBilling.setBackground(Color.GRAY);
        helpInBilling.setFont(new Font("SERIF", Font.ITALIC, 16));
        helpInBilling.setIcon(new ImageIcon(i22));
        helpInBilling.setMnemonic('S');
        helpInBilling.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Help.add(helpInBilling);

        JMenuItem LoginIssues = new JMenuItem("Issues with login?");
        LoginIssues.setBackground(Color.GRAY);
        LoginIssues.setFont(new Font("SERIF", Font.ITALIC, 16));
        LoginIssues.setIcon(new ImageIcon(i22));
        LoginIssues.setMnemonic('S');
        LoginIssues.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Help.add(LoginIssues);


        setJMenuBar(navbar);
        setLayout(new FlowLayout());

        setVisible(true);
    }

    public static void main(String[] args) {
        new Navbar();
    }
}
