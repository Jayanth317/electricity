package com.example;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JButton signup,cancel;
    Login() {

        // Set the title name -- this should always be in first
        super("Login page");
        // change background
        getContentPane().setBackground(Color.WHITE);
        // to prevent default values, everything is set to null
        setLayout(null);

        // creating labels
        JLabel user = new JLabel("UserName");
        // To locate the text within the box - works only if setLayout is kept null
        user.setBounds(100, 20, 100, 20);
        add(user);
        
        // creating place for label
        JTextField userField = new JTextField("Enter Customer name");
        // To locate the text within the box - works only if setLayout is kept null
        userField.setBounds(200, 20, 150, 20);
        add(userField);

        JLabel password = new JLabel("Password");
        password.setBounds(100, 60, 100, 20);
        add(password);
        JTextField passwordField = new JTextField("Enter the password");
        passwordField.setBounds(200, 60, 150, 20);
        add(passwordField);

        JLabel capcha = new JLabel("Capcha ");
        capcha.setBounds(100, 100, 100, 20);
        add(capcha);
        JTextField capchaField = new JTextField("Enter capcha as seen below");
        capchaField.setBounds(200, 100, 150, 20);
        add(capchaField);

        JLabel role = new JLabel("Role");
        role.setBounds(100, 140, 100, 20);
        add(role);

        // Create dropdown box
        Choice loginoption = new Choice();
        loginoption.add("Admin");
        loginoption.add("HQ");
        loginoption.add("customer");
        loginoption.setBounds(200, 140, 150, 20);
        add(loginoption);

        // Button for logging in
        ImageIcon i1 = new ImageIcon("\\icon\\image1.jpg");
        Image i11 = i1.getImage().getScaledInstance(8, 8, Image.SCALE_DEFAULT);
        JButton log = new JButton("Login", new ImageIcon(i11));
        // new ImageIcon can be replaced with new Imageicon(imagenum)
        log.setBounds(150, 200, 100, 20);
        add(log);

        ImageIcon i2 = new ImageIcon("\\icon\\image1.jpg");
        Image i22 = i2.getImage().getScaledInstance(8, 8, Image.SCALE_DEFAULT);
        cancel = new JButton("Cancel", new ImageIcon(i22));
        cancel.setBounds(270, 200, 100, 20);
        cancel.addActionListener(this);
        add(cancel);

        JLabel ques = new JLabel("Have no login ID? Then sign up...!");
        ques.setBounds(500, 500, 100, 20);
        
        ImageIcon i3 = new ImageIcon("\\icon\\image1.jpg");
        Image i32 = i3.getImage().getScaledInstance(8, 8, Image.SCALE_DEFAULT);
        signup = new JButton("Signup", new ImageIcon(i32));
        signup.setBounds(390, 200, 100, 20);
        signup.addActionListener(this);
        add(signup);

        setSize(600, 400);
        setLocation(670, 600);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == signup){
            new Signup();
        }else if (e.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
