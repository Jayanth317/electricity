package com.example;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;

public class Signup extends JFrame implements ActionListener {
	// Buttons are to be declared globally to prevent access issues
	JButton signup, back, cancel;
	Choice loginoption;
	JTextField userField, passwordField, MeterNumberField;

	Signup() {

		setBounds(450, 150, 700, 400);
		getContentPane().setBackground(Color.CYAN);
		setLayout(null);
		// setVisible(true);

		JLabel role = new JLabel("Signup as ");
		role.setBounds(100, 40, 100, 20);
		role.setFont(new Font("Cambria", Font.BOLD, 16));
		add(role);

		loginoption = new Choice();
		loginoption.add("Admin");
		loginoption.add("customer");
		loginoption.setBounds(200, 40, 150, 20);
		add(loginoption);

		loginoption.addFocusListener(null);

		JLabel MeterNumber = new JLabel("MeterNumber");
		MeterNumber.setBounds(100, 70, 100, 20);
		MeterNumber.setVisible(false);
		add(MeterNumber);
		MeterNumberField = new JTextField("");
		MeterNumberField.setBounds(200, 70, 150, 20);
		MeterNumberField.setVisible(false);
		add(MeterNumberField);

		JLabel user = new JLabel("User Name");
		user.setBounds(100, 100, 100, 20);
		add(user);
		userField = new JTextField("");
		userField.setBounds(200, 100, 150, 20);
		add(userField);

		JLabel password = new JLabel("Password");
		password.setBounds(100, 130, 100, 20);
		add(password);
		passwordField = new JTextField("");
		passwordField.setBounds(200, 130, 150, 20);
		add(passwordField);

		loginoption.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent i) {
				String user = loginoption.getSelectedItem();
				if (user.equals("customer")) {
					MeterNumber.setVisible(true);
					MeterNumberField.setVisible(true);
					userField.setEditable(false);
				} else {
					MeterNumber.setVisible(false);
					MeterNumberField.setVisible(false);
				}
			}
		});

		user.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent fe) {

			}

			@Override
			public void focusLost(FocusEvent fe) {
				try {
					DbConnect db = new DbConnect();
					ResultSet rs = db.s.executeQuery(
							"select  * from logindata where meterValue =  '" + userField.getText() + "' ");
					while (rs.next()) {
						user.setText(rs.getString("userValue"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		ImageIcon i1 = new ImageIcon("//home//maniac//Desktop//electricity//src//icon//image2.png");
		Image i12 = i1.getImage().getScaledInstance(8, 8, Image.SCALE_DEFAULT);
		signup = new JButton("signup", new ImageIcon(i12));
		signup.setBounds(200, 200, 100, 20);
		signup.addActionListener(this);
		add(signup);

		ImageIcon i2 = new ImageIcon("//home//maniac//Desktop//electricity//src//icon//image2.png");
		Image i22 = i2.getImage().getScaledInstance(8, 8, Image.SCALE_DEFAULT);
		cancel = new JButton("cancel", new ImageIcon(i22));
		cancel.setBounds(200, 260, 100, 20);
		cancel.addActionListener(this);
		add(cancel);

		ImageIcon i3 = new ImageIcon("//home//maniac//Desktop//electricity//src//icon//image2.png");
		Image i32 = i3.getImage().getScaledInstance(8, 8, Image.SCALE_DEFAULT);
		back = new JButton("Back", new ImageIcon(i32));
		back.setBackground(Color.green);
		back.setForeground(Color.ORANGE);
		back.setBounds(200, 230, 100, 20);
		back.addActionListener(this);
		add(back);

		JPanel panel = new JPanel();
		panel.setBounds(50, 20, 350, 340);
		panel.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 2, true), "main box"));
		panel.setLayout(null);
		add(panel);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == signup) {
			String atype = loginoption.getSelectedItem();
			String userValue = userField.getText();
			String passwordValue = passwordField.getText();
			String meterValue = MeterNumberField.getText();

			try {
				DbConnect db = new DbConnect();
				String query = null;
				if (atype.equals("Admin")) {
					// query has to be written to insert into the database
					query = "Insert into logindata values('"
							+ meterValue + "','"
							+ userValue + "','"
							+ passwordValue + "','"
							+ atype + "')";
				} else {
					query = "update logindata set userValue = '"
							+ userValue + "',passwordValue = '"
							+ passwordValue + "',atype = '"
							+ atype + "' where meterValue = '"
							+ meterValue + "'";
				}
				// Here the database is being updated with addtional rows
				db.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "account created");
				setVisible(false);
				new Login();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource() == back) {
			setVisible(false);
			new Login();

		} else if (e.getSource() == cancel) {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Signup();
	}
}
