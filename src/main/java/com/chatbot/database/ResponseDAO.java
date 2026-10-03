package com.chatbot.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResponseDAO {

    public String getResponse(String intent) {

        String sql =
                "SELECT r.response_text " +
                "FROM responses r " +
                "JOIN intents i ON r.intent_id = i.id " +
                "WHERE i.intent_name = ? LIMIT 1";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, intent);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("response_text");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addResponse(int intentId, String response) {

        String sql =
                "INSERT INTO responses(intent_id, response_text) " +
                "VALUES (?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, intentId);
            ps.setString(2, response);

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}