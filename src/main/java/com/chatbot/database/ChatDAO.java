package com.chatbot.database;

import com.chatbot.model.ChatMessage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChatDAO {

    public void saveChat(ChatMessage chat) {

        String sql =
                "INSERT INTO chat_history" +
                "(user_id, user_message, bot_response)" +
                " VALUES (?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, chat.getUserId());
            ps.setString(2, chat.getUserMessage());
            ps.setString(3, chat.getBotResponse());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showChatHistory(int userId) {

        String sql =
                "SELECT * FROM chat_history WHERE user_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        "You: " + rs.getString("user_message")
                );

                System.out.println(
                        "Bot: " + rs.getString("bot_response")
                );

                System.out.println("---------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}