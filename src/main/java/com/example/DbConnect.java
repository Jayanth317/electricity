package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {

    Connection c;
    Statement s;

    DbConnect() {

        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity", "root", "Jayanth@2001");
            s = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    
    }

}



