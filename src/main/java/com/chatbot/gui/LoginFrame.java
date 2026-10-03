package com.chatbot.gui;

import com.chatbot.database.UserDAO;
import com.chatbot.model.User;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    // Colors
    private final Color DARK_BLUE = new Color(28, 45, 100);
    private final Color PURPLE = new Color(92, 63, 220);
    private final Color LIGHT_BG = new Color(245, 248, 255);
    private final Color BLUE = new Color(40, 130, 240);

    public LoginFrame() {

        setTitle("AI Chatbot - Login");
        setSize(1050, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main panel
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        // =====================================================
        // LEFT SIDE
        // =====================================================

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(PURPLE);

        leftPanel.setBorder(
                BorderFactory.createEmptyBorder(65, 50, 40, 50)
        );

        JLabel aiLabel = new JLabel("AI");
        aiLabel.setFont(new Font("Arial", Font.BOLD, 68));
        aiLabel.setForeground(Color.WHITE);
        aiLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel chatbotLabel = new JLabel("AI Chatbot");
        chatbotLabel.setFont(new Font("Arial", Font.BOLD, 46));
        chatbotLabel.setForeground(Color.WHITE);
        chatbotLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel tagline = new JLabel(
                "<html><center>Your Smart Companion<br>" +
                "for Instant Answers</center></html>"
        );

        tagline.setFont(new Font("Arial", Font.PLAIN, 23));
        tagline.setForeground(Color.WHITE);
        tagline.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftPanel.add(aiLabel);
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(chatbotLabel);
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(tagline);

        leftPanel.add(Box.createVerticalStrut(65));

        addFeature(
                leftPanel,
                "Ask Anything",
                "Get instant answers"
        );

        addFeature(
                leftPanel,
                "Smart & Fast",
                "Powered by AI"
        );

        addFeature(
                leftPanel,
                "Learn & Explore",
                "Your knowledge partner"
        );


        // =====================================================
        // RIGHT SIDE
        // =====================================================

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(LIGHT_BG);

        rightPanel.setBorder(
                BorderFactory.createEmptyBorder(55, 70, 45, 70)
        );

        JLabel welcomeLabel = new JLabel("Welcome Back!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        welcomeLabel.setForeground(new Color(10, 35, 75));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitleLabel = new JLabel(
                "Log in to continue to AI Chatbot"
        );
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        subtitleLabel.setForeground(new Color(85, 105, 140));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        rightPanel.add(welcomeLabel);
        rightPanel.add(Box.createVerticalStrut(8));
        rightPanel.add(subtitleLabel);

        rightPanel.add(Box.createVerticalStrut(45));


        // =====================================================
        // USERNAME
        // =====================================================

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(
                new Font("Arial", Font.BOLD, 18)
        );
        usernameLabel.setForeground(
                new Color(20, 45, 95)
        );
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        usernameField = new JTextField();
        usernameField.setFont(
                new Font("Arial", Font.PLAIN, 18)
        );
        usernameField.setMaximumSize(
                new Dimension(390, 58)
        );

        usernameField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(160, 190, 245)
                        ),
                        BorderFactory.createEmptyBorder(
                                5, 15, 5, 15
                        )
                )
        );


        // =====================================================
        // PASSWORD
        // =====================================================

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(
                new Font("Arial", Font.BOLD, 18)
        );
        passwordLabel.setForeground(
                new Color(20, 45, 95)
        );
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordField = new JPasswordField();
        passwordField.setFont(
                new Font("Arial", Font.PLAIN, 18)
        );

        passwordField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(160, 190, 245)
                        ),
                        BorderFactory.createEmptyBorder(
                                5, 15, 5, 15
                        )
                )
        );

        // Password panel
        JPanel passwordPanel = new JPanel(new BorderLayout());
        passwordPanel.setBackground(Color.WHITE);
        passwordPanel.setMaximumSize(
                new Dimension(390, 58)
        );

        passwordPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(160, 190, 245)
                )
        );

        passwordField.setBorder(
                BorderFactory.createEmptyBorder(
                        5, 15, 5, 5
                )
        );

        JButton showPasswordButton =
                new JButton("Show");

        showPasswordButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        showPasswordButton.setForeground(BLUE);
        showPasswordButton.setBorderPainted(false);
        showPasswordButton.setFocusPainted(false);
        showPasswordButton.setContentAreaFilled(false);

        passwordPanel.add(
                passwordField,
                BorderLayout.CENTER
        );

        passwordPanel.add(
                showPasswordButton,
                BorderLayout.EAST
        );


        // =====================================================
        // SHOW / HIDE PASSWORD
        // =====================================================

        final char defaultEchoChar =
                passwordField.getEchoChar();

        showPasswordButton.addActionListener(e -> {

            if (passwordField.getEchoChar() == 0) {

                passwordField.setEchoChar(
                        defaultEchoChar
                );

                showPasswordButton.setText("Show");

            } else {

                passwordField.setEchoChar((char) 0);

                showPasswordButton.setText("Hide");
            }
        });


        // =====================================================
        // LOGIN BUTTON
        // =====================================================

        JButton loginButton =
                new JButton("Login");

        loginButton.setFont(
                new Font("Arial", Font.BOLD, 20)
        );

        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(BLUE);

        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);

        loginButton.setMaximumSize(
                new Dimension(390, 58)
        );

        // IMPORTANT: Login action
        loginButton.addActionListener(e -> login());


        // =====================================================
        // OR
        // =====================================================

        JPanel orPanel = new JPanel(
                new BorderLayout(10, 0)
        );

        orPanel.setBackground(LIGHT_BG);
        orPanel.setMaximumSize(
                new Dimension(390, 30)
        );

        JSeparator line1 = new JSeparator();
        JSeparator line2 = new JSeparator();

        JLabel orLabel = new JLabel("OR");
        orLabel.setFont(
                new Font("Arial", Font.PLAIN, 15)
        );

        orLabel.setForeground(
                new Color(100, 110, 130)
        );

        orLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        orPanel.add(line1, BorderLayout.WEST);
        orPanel.add(orLabel, BorderLayout.CENTER);
        orPanel.add(line2, BorderLayout.EAST);


        // =====================================================
        // REGISTER BUTTON
        // =====================================================

        JButton registerButton =
                new JButton("Create New Account");

        registerButton.setFont(
                new Font("Arial", Font.BOLD, 17)
        );

        registerButton.setForeground(BLUE);
        registerButton.setBackground(Color.WHITE);

        registerButton.setFocusPainted(false);

        registerButton.setMaximumSize(
                new Dimension(390, 45)
        );

        registerButton.addActionListener(e -> {

            new RegisterFrame();
            dispose();

        });


        // =====================================================
        // ADD COMPONENTS
        // =====================================================

        rightPanel.add(usernameLabel);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(usernameField);

        rightPanel.add(Box.createVerticalStrut(25));

        rightPanel.add(passwordLabel);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(passwordPanel);

        rightPanel.add(Box.createVerticalStrut(30));

        rightPanel.add(loginButton);

        rightPanel.add(Box.createVerticalStrut(20));

        rightPanel.add(orPanel);

        rightPanel.add(Box.createVerticalStrut(15));

        rightPanel.add(registerButton);


        // =====================================================
        // MAIN PANEL
        // =====================================================

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        add(mainPanel);

        setVisible(true);
    }


    // =========================================================
    // FEATURE METHOD
    // =========================================================

    private void addFeature(
            JPanel panel,
            String title,
            String description
    ) {

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        titleLabel.setForeground(Color.WHITE);

        JLabel descriptionLabel =
                new JLabel(description);

        descriptionLabel.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        descriptionLabel.setForeground(
                new Color(225, 230, 255)
        );

        titleLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        descriptionLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        panel.add(titleLabel);
        panel.add(
                Box.createVerticalStrut(2)
        );
        panel.add(descriptionLabel);
        panel.add(
                Box.createVerticalStrut(25)
        );
    }


    // =========================================================
    // LOGIN METHOD
    // =========================================================

    private void login() {

        String username =
                usernameField.getText().trim();

        String password =
                new String(
                        passwordField.getPassword()
                );

        // Check empty fields
        if (username.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter your username.",
                    "Login",
                    JOptionPane.WARNING_MESSAGE
            );

            usernameField.requestFocus();
            return;
        }

        if (password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter your password.",
                    "Login",
                    JOptionPane.WARNING_MESSAGE
            );

            passwordField.requestFocus();
            return;
        }


        // Connect to database
        UserDAO userDAO =
                new UserDAO();

        User user =
                userDAO.loginUser(
                        username,
                        password
                );


        // Login successful
        if (user != null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Welcome, " + user.getName() + "!",
                    "Login Successful",
                    JOptionPane.INFORMATION_MESSAGE
            );

            new ChatFrame(user);

            dispose();

        }

        // Login failed
        else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid username or password.\n" +
                    "Please check your details and try again.",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE
            );

            passwordField.setText("");
            passwordField.requestFocus();
        }
    }
}