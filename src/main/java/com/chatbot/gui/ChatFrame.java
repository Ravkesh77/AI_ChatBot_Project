package com.chatbot.gui;

import com.chatbot.chatbot.Chatbot;
import com.chatbot.database.ChatDAO;
import com.chatbot.model.ChatMessage;
import com.chatbot.model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ChatFrame extends JFrame {

    private JPanel messagesPanel;
    private JTextField messageField;

    private Chatbot chatbot;
    private ChatDAO chatDAO;
    private User user;

    // Colors
    private final Color PRIMARY = new Color(70, 70, 200);
    private final Color SECONDARY = new Color(90, 55, 220);
    private final Color BACKGROUND = new Color(245, 247, 252);
    private final Color BOT_BUBBLE = Color.WHITE;
    private final Color USER_BUBBLE = new Color(65, 105, 225);
    private final Color TEXT_DARK = new Color(35, 40, 55);

    public ChatFrame(User user) {

        this.user = user;

        chatbot = new Chatbot();
        chatDAO = new ChatDAO();

        setTitle("AI Chatbot - Chat");
        setSize(850, 650);
        setMinimumSize(new Dimension(700, 550));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main window
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND);

        // =========================
        // HEADER
        // =========================

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(PRIMARY);
        header.setBorder(new EmptyBorder(15, 25, 15, 20));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setOpaque(false);

        JLabel title = new JLabel("AI Chatbot");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(Color.WHITE);

        JLabel subtitle = new JLabel("Your smart companion");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitle.setForeground(new Color(225, 230, 255));

        titlePanel.add(title);
        titlePanel.add(Box.createVerticalStrut(3));
        titlePanel.add(subtitle);

        // User name
        JLabel userLabel = new JLabel("👤 " + user.getName());
        userLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        userLabel.setForeground(Color.WHITE);

        JButton historyButton = createHeaderButton("History");

        JPanel rightHeader = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        rightHeader.setOpaque(false);
        rightHeader.add(userLabel);
        rightHeader.add(historyButton);

        header.add(titlePanel, BorderLayout.WEST);
        header.add(rightHeader, BorderLayout.EAST);

        // =========================
        // CHAT AREA
        // =========================

        messagesPanel = new JPanel();
        messagesPanel.setLayout(new BoxLayout(messagesPanel, BoxLayout.Y_AXIS));
        messagesPanel.setBackground(BACKGROUND);
        messagesPanel.setBorder(new EmptyBorder(20, 25, 20, 25));

        JScrollPane scrollPane = new JScrollPane(messagesPanel);

        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setBackground(BACKGROUND);
        scrollPane.getViewport().setBackground(BACKGROUND);

        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        // =========================
        // INPUT AREA
        // =========================

        JPanel inputContainer = new JPanel(new BorderLayout(12, 0));
        inputContainer.setBackground(Color.WHITE);
        inputContainer.setBorder(
                new EmptyBorder(15, 20, 15, 20)
        );

        messageField = new JTextField();
        messageField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        messageField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(210, 215, 230)
                        ),
                        new EmptyBorder(10, 15, 10, 15)
                )
        );

        messageField.setToolTipText("Type your message here...");

        JButton sendButton = new JButton("Send");
        sendButton.setFont(
                new Font("Segoe UI", Font.BOLD, 14)
        );
        sendButton.setForeground(Color.WHITE);
        sendButton.setBackground(PRIMARY);
        sendButton.setFocusPainted(false);
        sendButton.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 25, 10, 25
                )
        );
        sendButton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        inputContainer.add(
                messageField,
                BorderLayout.CENTER
        );

        inputContainer.add(
                sendButton,
                BorderLayout.EAST
        );

        // =========================
        // ADD EVERYTHING
        // =========================

        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(inputContainer, BorderLayout.SOUTH);

        add(mainPanel);

        // =========================
        // WELCOME MESSAGE
        // =========================

        addBotMessage(
                "Hello " + user.getName() +
                "! 👋\n\n" +
                "I'm your AI assistant. How can I help you today?"
        );

        // =========================
        // BUTTON ACTIONS
        // =========================

        sendButton.addActionListener(
                e -> sendMessage()
        );

        messageField.addActionListener(
                e -> sendMessage()
        );

        historyButton.addActionListener(
                e -> showHistory()
        );

        setVisible(true);
    }

    // =====================================================
    // SEND MESSAGE
    // =====================================================

    private void sendMessage() {

        String message =
                messageField.getText().trim();

        if (message.isEmpty()) {
            return;
        }

        // Show user message
        addUserMessage(message);

        // Get chatbot response
        String response =
                chatbot.getResponse(message);

        // Show bot response
        addBotMessage(response);

        // Save chat
        ChatMessage chat =
                new ChatMessage(
                        user.getId(),
                        message,
                        response
                );

        chatDAO.saveChat(chat);

        messageField.setText("");
    }

    // =====================================================
    // USER MESSAGE
    // =====================================================

    private void addUserMessage(String message) {

        JPanel row = new JPanel(
                new FlowLayout(
                        FlowLayout.RIGHT,
                        0,
                        5
                )
        );

        row.setOpaque(false);
        row.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel bubble = createBubble(
                message,
                USER_BUBBLE,
                Color.WHITE
        );

        row.add(bubble);

        messagesPanel.add(row);
        messagesPanel.add(Box.createVerticalStrut(5));

        refreshChat();
    }

    // =====================================================
    // BOT MESSAGE
    // =====================================================

    private void addBotMessage(String message) {

        JPanel row = new JPanel(
                new FlowLayout(
                        FlowLayout.LEFT,
                        0,
                        5
                )
        );

        row.setOpaque(false);
        row.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel botContainer = new JPanel(
                new BorderLayout(8, 0)
        );

        botContainer.setOpaque(false);

        JLabel botIcon = new JLabel("🤖");
        botIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 22));

        JLabel bubble = createBubble(
                message,
                BOT_BUBBLE,
                TEXT_DARK
        );

        botContainer.add(
                botIcon,
                BorderLayout.WEST
        );

        botContainer.add(
                bubble,
                BorderLayout.CENTER
        );

        row.add(botContainer);

        messagesPanel.add(row);
        messagesPanel.add(Box.createVerticalStrut(5));

        refreshChat();
    }

    // =====================================================
    // MESSAGE BUBBLE
    // =====================================================

    private JLabel createBubble(
            String text,
            Color background,
            Color foreground
    ) {

        JLabel label = new JLabel(
                "<html><div style='width: 400px;'>" +
                        text.replace(
                                "\n",
                                "<br>"
                        ) +
                        "</div></html>"
        );

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        label.setForeground(foreground);

        label.setOpaque(true);
        label.setBackground(background);

        label.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(225, 228, 238)
                        ),
                        new EmptyBorder(
                                12,
                                15,
                                12,
                                15
                        )
                )
        );

        return label;
    }

    // =====================================================
    // HEADER BUTTON
    // =====================================================

    private JButton createHeaderButton(String text) {

        JButton button = new JButton(text);

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        button.setForeground(PRIMARY);
        button.setBackground(Color.WHITE);

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        8,
                        16,
                        8,
                        16
                )
        );

        button.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        return button;
    }

    // =====================================================
    // REFRESH CHAT
    // =====================================================

    private void refreshChat() {

        messagesPanel.revalidate();
        messagesPanel.repaint();

        SwingUtilities.invokeLater(() -> {

            Container parent =
                    messagesPanel.getParent();

            if (parent instanceof JViewport) {

                JScrollPane scrollPane =
                        (JScrollPane)
                                parent.getParent();

                JScrollBar vertical =
                        scrollPane
                                .getVerticalScrollBar();

                vertical.setValue(
                        vertical.getMaximum()
                );
            }
        });
    }

    // =====================================================
    // HISTORY
    // =====================================================

    private void showHistory() {

        chatDAO.showChatHistory(
                user.getId()
        );

        JOptionPane.showMessageDialog(
                this,
                "Chat history has been printed in the console.",
                "Chat History",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}