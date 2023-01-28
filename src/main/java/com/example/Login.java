package com.example;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton signup, cancel, login;
    JTextField userField, passwordField, capchaField;
    JLabel user, password, capcha, ques;
    Choice loginoption;

    Login() {

        // Set the title name -- this should always be in first
        super("Login page");
        // change background
        getContentPane().setBackground(Color.WHITE);
        // to prevent default values, everything is set to null
        setLayout(null);

        // creating labels
        // To locate the text within the box - works only if setLayout is kept null
        user = new JLabel("UserName");
        user.setBounds(100, 20, 100, 20);
        add(user);
        // creating place for label
        // To locate the text within the box - works only if setLayout is kept null
        userField = new JTextField("Enter Customer name");
        userField.setBounds(200, 20, 150, 20);
        add(userField);

        // Labels and its textfields
        password = new JLabel("Password");
        password.setBounds(100, 60, 100, 20);
        add(password);
        passwordField = new JTextField("Enter the password");
        passwordField.setBounds(200, 60, 150, 20);
        add(passwordField);

        capcha = new JLabel("Capcha ");
        capcha.setBounds(100, 100, 100, 20);
        add(capcha);
        capchaField = new JTextField("Enter capcha as seen below");
        capchaField.setBounds(200, 100, 150, 20);
        add(capchaField);

        JLabel role = new JLabel("Role");
        role.setBounds(100, 140, 100, 20);
        add(role);

        // Create dropdown box
        loginoption = new Choice();
        loginoption.add("Admin");
        loginoption.add("HQ");
        loginoption.add("customer");
        loginoption.setBounds(200, 140, 150, 20);
        add(loginoption);

        // Button for logging in
        ImageIcon i1 = new ImageIcon("//home//maniac//Desktop//electricity//src//icon//image2.png");
        Image i11 = i1.getImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT);
        login = new JButton("Login", new ImageIcon(i11));
        // new ImageIcon can be replaced with new Imageicon(imagenum)
        login.setBounds(150, 200, 100, 20);
        login.addActionListener(this);
        add(login);

        ImageIcon i2 = new ImageIcon("//home//maniac//Desktop//electricity//src//icon//image2.png");
        Image i22 = i2.getImage().getScaledInstance(8, 8, Image.SCALE_DEFAULT);
        cancel = new JButton("Cancel", new ImageIcon(i22));
        cancel.setBounds(270, 200, 100, 20);
        cancel.addActionListener(this);
        add(cancel);

        ques = new JLabel("Have no login ID? Then sign up...!");
        ques.setBounds(100, 170, 250, 20);
        add(ques);

        ImageIcon i3 = new ImageIcon("//home//maniac//Desktop//electricity//src//icon//image2.png");
        Image i32 = i3.getImage().getScaledInstance(8, 8, Image.SCALE_DEFAULT);
        signup = new JButton("Signup", new ImageIcon(i32));
        signup.setBounds(390, 200, 100, 20);
        signup.addActionListener(this);
        setVisible(false);
        add(signup);

        setSize(600, 400);
        setLocation(670, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String userValue = userField.getText();
            String passwordValue = passwordField.getText();
            String atype = loginoption.getSelectedItem();
            try {
                DbConnect db = new DbConnect();
                /* */ String query = "SELECT * from logindata where userValue = '" + userValue
                        + "'and passwordValue = '" + passwordValue + "' and atype = '" + atype + "'";

                // only the data that is present in database is extracted
                ResultSet rs = db.s.executeQuery(query);

                // if the data is available...
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    setVisible(false);
                    new Navbar();
                } else {
                    JOptionPane.showMessageDialog(null, "invalid login!");
                    userField.setText("");
                    passwordField.setText("");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == signup) {
            new Signup();
        } else if (e.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}


