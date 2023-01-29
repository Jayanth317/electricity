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

public class Navbar extends JFrame implements ActionListener{
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
        HomeScreen.setMnemonic('Q');
        HomeScreen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Home.add(HomeScreen);

        JMenuItem User = new JMenuItem("User", new ImageIcon(i22));
        User.setBackground(Color.CYAN);
        User.setFont(new Font("SERIF", Font.ITALIC, 15));
        User.setMnemonic('Q');
        User.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Home.add(User);

        JMenuItem NewUser = new JMenuItem("NewUser", new ImageIcon(i22));
        NewUser.setBackground(Color.CYAN);
        NewUser.setFont(new Font("SERIF", Font.ITALIC, 15));
        NewUser.addActionListener(this);
        NewUser.setMnemonic('Q');
        NewUser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Home.add(NewUser);

        JMenuItem CustomerDetails = new JMenuItem("CustomerDetails", new ImageIcon(i22));
        CustomerDetails.setBackground(Color.CYAN);
        CustomerDetails.setFont(new Font("SERIF", Font.ITALIC, 15));
        CustomerDetails.addActionListener(this);
        CustomerDetails.setMnemonic('Q');
        CustomerDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Home.add(CustomerDetails);

        JMenuItem DepositDetails = new JMenuItem("DepositDetails", new ImageIcon(i22));
        DepositDetails.setBackground(Color.CYAN);
        DepositDetails.setFont(new Font("SERIF", Font.ITALIC, 15));
        DepositDetails.addActionListener(this);
        DepositDetails.setMnemonic('Q');
        DepositDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Home.add(DepositDetails);
        //Billing button
        JMenuItem Bill = new JMenuItem("CalculateBill");
        Bill.setBackground(Color.GRAY);
        Bill.setFont(new Font("SERIF", Font.ITALIC, 16));
        Bill.setIcon(new ImageIcon(i22));
        Bill.setMnemonic('Q');
        Bill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Bill.addActionListener(this);
        Billing.add(Bill);

        
        JMenuItem GSTBill = new JMenuItem("GST Bill");
        GSTBill.setBackground(Color.GRAY);
        GSTBill.setFont(new Font("SERIF", Font.ITALIC, 16));
        GSTBill.setIcon(new ImageIcon(i22));
        GSTBill.setMnemonic('R');
        GSTBill.addActionListener(this);
        GSTBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Billing.add(GSTBill);

        JMenuItem GSTBill2 = new JMenuItem("GSTBill with VAT");
        GSTBill2.setBackground(Color.GRAY);
        GSTBill2.setFont(new Font("SERIF", Font.ITALIC, 16));
        GSTBill2.setIcon(new ImageIcon(i22));
        GSTBill2.setMnemonic('S');
        GSTBill2.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent arg) {
        String msg = arg.getActionCommand();
        if(msg.equals("NewUser")){
            new NewCustomer();
        }else if(msg.equals("CustomerDetails")){
            new Login();
        }else if (msg.equals("DepositDetails")){

        }else if (msg.equals("CalculateBill")){
            new MeterInfo(msg);
        }
    }
}
