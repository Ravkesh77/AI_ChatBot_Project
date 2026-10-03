package com.chatbot.gui;

import javax.swing.*;
import java.awt.*;

public class AdminFrame extends JFrame {

    public AdminFrame() {

        setTitle("AI Chatbot - Admin Panel");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(
                new GridLayout(4, 1, 15, 15)
        );

        panel.setBorder(
                BorderFactory.createEmptyBorder(30, 50, 30, 50)
        );

        JLabel title = new JLabel(
                "ADMIN PANEL",
                SwingConstants.CENTER
        );

        JButton usersButton =
                new JButton("View Users");

        JButton historyButton =
                new JButton("View Chat History");

        JButton responseButton =
                new JButton("Manage Responses");

        panel.add(title);
        panel.add(usersButton);
        panel.add(historyButton);
        panel.add(responseButton);

        add(panel);

        usersButton.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "User management can be added here."
                )
        );

        historyButton.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "Chat history management can be added here."
                )
        );

        responseButton.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "Response management can be added here."
                )
        );

        setVisible(true);
    }
}