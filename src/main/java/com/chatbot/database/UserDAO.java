package com.chatbot.database;

import com.chatbot.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public boolean registerUser(User user) {

        String sql =
                "INSERT INTO users(name, username, password) VALUES (?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            if (con == null) {
                System.out.println("ERROR: Database connection is NULL.");
                return false;
            }

            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Registration failed.");
            e.printStackTrace();
            return false;
        }
    }

    public User loginUser(String username, String password) {

        String sql =
                "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection con = DatabaseConnection.getConnection()) {

            if (con == null) {
                System.out.println("ERROR: Database connection is NULL.");
                return null;
            }

            System.out.println("Database connected successfully.");
            System.out.println("Trying username: " + username);

            try (PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, username);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    System.out.println("LOGIN USER FOUND!");

                    return new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("username"),
                            rs.getString("password")
                    );
                }

                System.out.println("NO USER FOUND.");

            }

        } catch (Exception e) {

            System.out.println("LOGIN DATABASE ERROR:");
            e.printStackTrace();
        }

        return null;
    }
}