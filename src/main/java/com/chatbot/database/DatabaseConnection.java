package com.chatbot.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/chatbot";

    private static final String USER = "root";

    private static final String PASSWORD =
            "Ravkesh@297";

    public static Connection getConnection() {

        try {
            Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("MYSQL CONNECTED SUCCESSFULLY!");

            return con;

        } catch (Exception e) {

            System.out.println("========== MYSQL ERROR ==========");
            e.printStackTrace();
            System.out.println("=================================");

            return null;
        }
    }
}