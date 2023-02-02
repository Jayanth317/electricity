package com.example;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

//Runnable is implemented as multi inheritence is not allowed
public class Splash extends JFrame implements Runnable, ActionListener {
    // To implement run method, thread class should have an object
    Thread t;
    JButton login;

    Splash() {
        // insert images - inner parenthesis should contain location or the url of image
        ImageIcon i1 = new ImageIcon("//home//maniac//Desktop//electricity//src//icon//image2.png");
        Image i11 = i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel image = new JLabel(i12);
        add(image);

        // set visibility
        setVisible(true);

        int x = 1;
        for (int i = 2; i < 600; i += 4, x += 1) {
            // dimensions of window
            setSize(i + x, i);
            // set location on screen
            setLocation(700 - ((i + x) / 2), 400 - (i / 2));
            try {
                Thread.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        JButton login = new JButton("Login");
        login.setBounds(300,400,600,400);
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        setVisible(false);
        login.addActionListener(this);
        add(login);

        t = new Thread();
        t.start();
     
        
        new Login();
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            new Login();
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }

}