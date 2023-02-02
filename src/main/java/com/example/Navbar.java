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
    String atype,meterValue;

    Navbar(String atype,String meterValue) {
        this.atype = atype;
        this.meterValue = meterValue;
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(450, 150, 700, 400);
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

        JMenu Report = new JMenu("Report");

        JMenu Information = new JMenu("Information");

        JMenu User = new JMenu("User");

        JMenu Utility = new JMenu("Utility");

        JMenu Exit = new JMenu("Exit");
        // if (atype.equals("Admin")) {
            navbar.add(Home);
        // } else {
            navbar.add(Report);
            navbar.add(Information);
            navbar.add(User);
        // }
        navbar.add(Utility);
        navbar.add(Exit);

        // dropdown elements
        // Home button
        JMenuItem HomeScreen = new JMenuItem("Home", new ImageIcon(i22));
        HomeScreen.setBackground(Color.GREEN);
        HomeScreen.setFont(new Font("SERIF", Font.ITALIC, 15));
        HomeScreen.setMnemonic('Q');
        HomeScreen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        JMenuItem User1 = new JMenuItem("User", new ImageIcon(i22));
        User1.setBackground(Color.CYAN);
        User1.setFont(new Font("SERIF", Font.ITALIC, 15));
        User1.setMnemonic('Q');
        User1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

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

        JMenuItem DepositDetails = new JMenuItem("Deposit details",new ImageIcon(i22));
        DepositDetails.setBackground(Color.CYAN);
        DepositDetails.setFont(new Font("SERIF", Font.ITALIC, 15));
        DepositDetails.addActionListener(this);
        DepositDetails.setMnemonic('Q');
        DepositDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        // Billing button
        JMenuItem Bill = new JMenuItem("CalculateBill");
        Bill.setBackground(Color.GRAY);
        Bill.setFont(new Font("SERIF", Font.ITALIC, 16));
        Bill.setIcon(new ImageIcon(i22));
        Bill.setMnemonic('Q');
        Bill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Bill.addActionListener(this);

        JMenuItem BillDetails = new JMenuItem("Bill Details");
        BillDetails.setBackground(Color.GRAY);
        BillDetails.setFont(new Font("SERIF", Font.ITALIC, 16));
        BillDetails.setIcon(new ImageIcon(i22));
        BillDetails.setMnemonic('R');
        BillDetails.addActionListener(this);
        BillDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        JMenuItem PayBill = new JMenuItem("Pay your Bill");
        PayBill.setBackground(Color.GRAY);
        PayBill.setFont(new Font("SERIF", Font.ITALIC, 16));
        PayBill.setIcon(new ImageIcon(i22));
        PayBill.setMnemonic('S');
        PayBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        PayBill.addActionListener(this);
            
        JMenuItem GenerateBill = new JMenuItem("Generate Bill");
        GenerateBill.setBackground(Color.GRAY);
        GenerateBill.setFont(new Font("SERIF", Font.ITALIC, 16));
        GenerateBill.setIcon(new ImageIcon(i22));
        GenerateBill.setMnemonic('S');
        GenerateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        GenerateBill.addActionListener(this);

        // User button
        JMenuItem UserInBilling = new JMenuItem("User in Billing..?");
        UserInBilling.setBackground(Color.GRAY);
        UserInBilling.setFont(new Font("SERIF", Font.ITALIC, 16));
        UserInBilling.setIcon(new ImageIcon(i22));
        UserInBilling.setMnemonic('S');
        UserInBilling.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        JMenuItem LoginIssues = new JMenuItem("Issues with login?");
        LoginIssues.setBackground(Color.GRAY);
        LoginIssues.setFont(new Font("SERIF", Font.ITALIC, 16));
        LoginIssues.setIcon(new ImageIcon(i22));
        LoginIssues.setMnemonic('S');
        LoginIssues.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        JMenuItem UpdateInformation = new JMenuItem("Update information");
        UpdateInformation.setBackground(Color.GRAY);
        UpdateInformation.setFont(new Font("SERIF", Font.ITALIC, 16));
        UpdateInformation.setIcon(new ImageIcon(i22));
        UpdateInformation.setMnemonic('S');
        UpdateInformation.addActionListener(this);
        UpdateInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        JMenuItem ViewInformation = new JMenuItem("View information");
        ViewInformation.setBackground(Color.GRAY);
        ViewInformation.setFont(new Font("SERIF", Font.ITALIC, 16));
        ViewInformation.setIcon(new ImageIcon(i22));
        ViewInformation.setMnemonic('S');
        ViewInformation.addActionListener(this);
        ViewInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        JMenuItem Notepad = new JMenuItem("Notepad");
        Notepad.setBackground(Color.GRAY);
        Notepad.setFont(new Font("SERIF", Font.ITALIC, 16));
        Notepad.setIcon(new ImageIcon(i22));
        Notepad.setMnemonic('Q');
        Notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Notepad.addActionListener(this);

        JMenuItem Calculator = new JMenuItem("Calculator");
        Calculator.setBackground(Color.GRAY);
        Calculator.setFont(new Font("SERIF", Font.ITALIC, 16));
        Calculator.setIcon(new ImageIcon(i22));
        Calculator.setMnemonic('Q');
        Calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        Calculator.addActionListener(this);

        Home.add(HomeScreen);
        User.add(User1);
        User.add(NewUser);
        User.add(CustomerDetails);
        User.add(DepositDetails);
        User.add(GenerateBill);
        User.add(BillDetails);
        User.add(PayBill);
        Report.add(UserInBilling);
        Report.add(LoginIssues);
        Information.add(UpdateInformation);
        Information.add(ViewInformation);
        Utility.add(Notepad);
        Utility.add(Calculator);

        setJMenuBar(navbar);
        setLayout(new FlowLayout());

        setVisible(true);
    }

    public static void main(String[] args) {
        new Navbar("","");
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
        } else if (msg.equals("CalculateBill")) {
            new MeterInfo(msg);
        }else if(msg.equals("View information")){
            new ViewInformation(meterValue);
        }else if(msg.equals("Update information")){
            new UpdateInformation(meterValue);
        }else if(msg.equals("Bill Details")){
            new BillDetails(meterValue);
        }else if(msg.equals("Notepad")){
            try {
                //notepad is the notepad.exe equivalent of linux
                Runtime.getRuntime().exec("notepad");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(msg.equals("Calculator")){
            try {
                //galculator is the calculator equivalent of linux
                Runtime.getRuntime().exec("galculator");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(msg.equals("Pay your Bill")){
            new PayBill(meterValue);
        }else if(msg.equals("Generate Bill")){
            new GenerateBill(meterValue);
        }

    }
}
