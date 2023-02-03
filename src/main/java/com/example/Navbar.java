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

public class Navbar extends JFrame implements ActionListener {
    String atype, meterValue;

    Navbar(String atype, String meterValue) {
        this.atype = atype;
        this.meterValue = meterValue;
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(300, 400, 700, 480);
        ImageIcon i1 = new ImageIcon("//home//maniac//Desktop//electricity//src//icon//image2.png");
        Image i12 = i1.getImage().getScaledInstance(700, 400, Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12);
        JLabel image = new JLabel(i13);
        add(image);

        ImageIcon i2 = new ImageIcon("//home//maniac//Desktop//electricity//src//icon//image2.png");
        Image i22 = i2.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);

        // object of the main navbar
        JMenuBar navbar = new JMenuBar();

        // menu that pops up when navbar item is clicked - like dropdown
        // navbar elements
        JMenu Home = new JMenu("Home");

        JMenu BillGeneration = new JMenu("Bill Generation");

        JMenu Information = new JMenu("Information");

        JMenu Bills = new JMenu("Bills");

        JMenu Utility = new JMenu("Utility");

        JMenu Exit = new JMenu("Exit");
        if (atype.equals("Admin")) {
            navbar.add(Home);
        } else {
            navbar.add(BillGeneration);
            navbar.add(Information);
            navbar.add(Bills);
        }
        navbar.add(Utility);
        navbar.add(Exit);

        // Home
        JMenuItem NewUser = new JMenuItem("NewUser", new ImageIcon(i22));
        NewUser.setBackground(Color.CYAN);
        NewUser.setFont(new Font("SERIF", Font.ITALIC, 15));
        NewUser.addActionListener(this);
        NewUser.setMnemonic('Q');
        NewUser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        JMenuItem CustomerDetails = new JMenuItem("CustomerDetails", new ImageIcon(i22));
        CustomerDetails.setBackground(Color.CYAN);
        CustomerDetails.setFont(new Font("SERIF", Font.ITALIC, 15));
        CustomerDetails.addActionListener(this);
        CustomerDetails.setMnemonic('Q');
        CustomerDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        JMenuItem DepositDetails = new JMenuItem("Deposit details", new ImageIcon(i22));
        DepositDetails.setBackground(Color.CYAN);
        DepositDetails.setFont(new Font("SERIF", Font.ITALIC, 15));
        DepositDetails.addActionListener(this);
        DepositDetails.setMnemonic('Q');
        DepositDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        JMenuItem CalculateBill = new JMenuItem("Calculate your Bill");
        CalculateBill.setBackground(Color.cyan);
        CalculateBill.setFont(new Font("SERIF", Font.ITALIC, 16));
        CalculateBill.setIcon(new ImageIcon(i22));
        CalculateBill.setMnemonic('S');
        CalculateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        CalculateBill.addActionListener(this);

        // Bills
        JMenuItem BillDetails = new JMenuItem("Bill Details");
        BillDetails.setBackground(Color.LIGHT_GRAY);
        BillDetails.setFont(new Font("SERIF", Font.ITALIC, 16));
        BillDetails.setIcon(new ImageIcon(i22));
        BillDetails.setMnemonic('R');
        BillDetails.addActionListener(this);
        BillDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        JMenuItem PayBill = new JMenuItem("Pay your Bill");
        PayBill.setBackground(Color.LIGHT_GRAY);
        PayBill.setFont(new Font("SERIF", Font.ITALIC, 16));
        PayBill.setIcon(new ImageIcon(i22));
        PayBill.setMnemonic('S');
        PayBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        PayBill.addActionListener(this);

        // BillGeneration
        JMenuItem GenerateBill = new JMenuItem("Generate Bill");
        GenerateBill.setBackground(Color.MAGENTA);
        GenerateBill.setFont(new Font("SERIF", Font.ITALIC, 16));
        GenerateBill.setIcon(new ImageIcon(i22));
        GenerateBill.setMnemonic('S');
        GenerateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        GenerateBill.addActionListener(this);

        // Information
        JMenuItem UpdateInformation = new JMenuItem("Update information");
        UpdateInformation.setBackground(Color.orange);
        UpdateInformation.setFont(new Font("SERIF", Font.ITALIC, 16));
        UpdateInformation.setIcon(new ImageIcon(i22));
        UpdateInformation.setMnemonic('S');
        UpdateInformation.addActionListener(this);
        UpdateInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        JMenuItem ViewInformation = new JMenuItem("View information");
        ViewInformation.setBackground(Color.orange);
        ViewInformation.setFont(new Font("SERIF", Font.ITALIC, 16));
        ViewInformation.setIcon(new ImageIcon(i22));
        ViewInformation.setMnemonic('S');
        ViewInformation.addActionListener(this);
        ViewInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        // Utility
        JMenuItem Notepad = new JMenuItem("Notepad");
        Notepad.setBackground(Color.PINK);
        Notepad.setFont(new Font("SERIF", Font.ITALIC, 16));
        Notepad.setIcon(new ImageIcon(i22));
        Notepad.setMnemonic('Q');
        Notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Notepad.addActionListener(this);

        JMenuItem Calculator = new JMenuItem("Calculator");
        Calculator.setBackground(Color.pink);
        Calculator.setFont(new Font("SERIF", Font.ITALIC, 16));
        Calculator.setIcon(new ImageIcon(i22));
        Calculator.setMnemonic('Q');
        Calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Calculator.addActionListener(this);

        //Exit
        JMenuItem Close = new JMenuItem("Close Window");
        Close.setBackground(Color.gray);
        Close.setFont(new Font("SERIF", Font.ITALIC, 16));
        Close.setIcon(new ImageIcon(i22));
        Close.setMnemonic('Q');
        Close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Close.addActionListener(this);

        Home.add(NewUser);
        Home.add(CustomerDetails);
        Home.add(DepositDetails);
        Home.add(CalculateBill);

        BillGeneration.add(GenerateBill);

        Bills.add(BillDetails);
        Bills.add(PayBill);

        Information.add(UpdateInformation);
        Information.add(ViewInformation);

        Utility.add(Notepad);
        Utility.add(Calculator);

        Exit.add(Close);
        setJMenuBar(navbar);
        setLayout(new FlowLayout());

        setVisible(true);
    }

    public static void main(String[] args) {
        new Navbar("", "");
    }

    @Override
    public void actionPerformed(ActionEvent arg) {
        String msg = arg.getActionCommand();
        if (msg.equals("NewUser")) {
            new NewCustomer();
        } else if (msg.equals("CustomerDetails")) {
            new CustomerDetails();
        } else if (msg.equals("Deposit details")) {
            new DepositDetails();
        } else if (msg.equals("Calculate your Bill")) {
            new CalculateBill();
        } else if (msg.equals("View information")) {
            new ViewInformation(meterValue);
        } else if (msg.equals("Update information")) {
            new UpdateInformation(meterValue,"");
        } else if (msg.equals("Bill Details")) {
            new BillDetails(meterValue);
        } else if (msg.equals("Notepad")) {
            try {
                // notepad is the notepad.exe equivalent of linux
                Runtime.getRuntime().exec("notepad");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Calculator")) {
            try {
                // galculator is the calculator equivalent of linux
                Runtime.getRuntime().exec("galculator");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Pay your Bill")) {
            new PayBill(meterValue);
        } else if (msg.equals("Generate Bill")) {
            new GenerateBill(meterValue);
        }else if(msg.equals("Close Window")){
            setVisible(false);
        }

    }
}
