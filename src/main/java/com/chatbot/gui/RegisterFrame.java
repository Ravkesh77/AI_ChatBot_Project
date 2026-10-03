package com.chatbot.gui;

import com.chatbot.database.UserDAO;
import com.chatbot.model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RegisterFrame extends JFrame {

    private JTextField nameField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    private final Color DARK_BLUE = new Color(18, 42, 95);
    private final Color BLUE = new Color(40, 130, 240);
    private final Color PURPLE = new Color(100, 70, 220);
    private final Color LIGHT_BG = new Color(245, 248, 255);

    public RegisterFrame() {

        setTitle("AI Chatbot - Create Account");
        setSize(850, 560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        // =========================================================
        // LEFT SIDE - BRANDING
        // =========================================================

        JPanel leftPanel = new GradientPanel(DARK_BLUE, PURPLE);

        leftPanel.setLayout(
                new BoxLayout(leftPanel, BoxLayout.Y_AXIS)
        );

        leftPanel.setBorder(
                new EmptyBorder(50, 45, 40, 45)
        );

        JLabel robot = new JLabel("AI");

        robot.setFont(
                new Font("Arial", Font.BOLD, 55)
        );

        robot.setForeground(Color.WHITE);
        robot.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel chatbotTitle = new JLabel("AI Chatbot");

        chatbotTitle.setFont(
                new Font("Arial", Font.BOLD, 38)
        );

        chatbotTitle.setForeground(Color.WHITE);
        chatbotTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel tagline = new JLabel(
                "<html><center>" +
                "Your Smart Companion<br>" +
                "for Instant Answers" +
                "</center></html>"
        );

        tagline.setFont(
                new Font("Arial", Font.PLAIN, 18)
        );

        tagline.setForeground(
                new Color(220, 230, 255)
        );

        tagline.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        leftPanel.add(Box.createVerticalGlue());

        leftPanel.add(robot);

        leftPanel.add(
                Box.createVerticalStrut(15)
        );

        leftPanel.add(chatbotTitle);

        leftPanel.add(
                Box.createVerticalStrut(15)
        );

        leftPanel.add(tagline);

        leftPanel.add(
                Box.createVerticalStrut(50)
        );

        JLabel feature1 = createFeature(
                "Create Your Account",
                "Join the AI Chatbot community"
        );

        JLabel feature2 = createFeature(
                "Ask Anything",
                "Get instant and accurate answers"
        );

        JLabel feature3 = createFeature(
                "Learn & Explore",
                "Your personal knowledge partner"
        );

        leftPanel.add(feature1);

        leftPanel.add(
                Box.createVerticalStrut(20)
        );

        leftPanel.add(feature2);

        leftPanel.add(
                Box.createVerticalStrut(20)
        );

        leftPanel.add(feature3);

        leftPanel.add(Box.createVerticalGlue());


        // =========================================================
        // RIGHT SIDE - REGISTER FORM
        // =========================================================

        JPanel rightPanel = new JPanel();

        rightPanel.setBackground(LIGHT_BG);

        rightPanel.setLayout(
                new BoxLayout(
                        rightPanel,
                        BoxLayout.Y_AXIS
                )
        );

        rightPanel.setBorder(
                new EmptyBorder(35, 55, 35, 55)
        );


        // Title

        JLabel welcome = new JLabel(
                "Create Your Account"
        );

        welcome.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        30
                )
        );

        welcome.setForeground(
                new Color(20, 30, 50)
        );

        welcome.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        JLabel subtitle = new JLabel(
                "Register to start using AI Chatbot"
        );

        subtitle.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        16
                )
        );

        subtitle.setForeground(
                new Color(100, 110, 130)
        );

        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        rightPanel.add(welcome);

        rightPanel.add(
                Box.createVerticalStrut(7)
        );

        rightPanel.add(subtitle);

        rightPanel.add(
                Box.createVerticalStrut(22)
        );


        // =========================================================
        // NAME
        // =========================================================

        JLabel nameLabel =
                createLabel("Full Name");

        rightPanel.add(nameLabel);

        rightPanel.add(
                Box.createVerticalStrut(5)
        );

        nameField = new JTextField();

        styleTextField(nameField);

        nameField.setToolTipText(
                "Enter your full name"
        );

        rightPanel.add(nameField);


        rightPanel.add(
                Box.createVerticalStrut(12)
        );


        // =========================================================
        // USERNAME
        // =========================================================

        JLabel usernameLabel =
                createLabel("Username");

        rightPanel.add(usernameLabel);

        rightPanel.add(
                Box.createVerticalStrut(5)
        );

        usernameField = new JTextField();

        styleTextField(usernameField);

        usernameField.setToolTipText(
                "Choose a username"
        );

        rightPanel.add(usernameField);


        rightPanel.add(
                Box.createVerticalStrut(12)
        );


        // =========================================================
        // PASSWORD
        // =========================================================

        JLabel passwordLabel =
                createLabel("Password");

        rightPanel.add(passwordLabel);

        rightPanel.add(
                Box.createVerticalStrut(5)
        );

        JPanel passwordPanel =
                createPasswordPanel();

        rightPanel.add(passwordPanel);


        rightPanel.add(
                Box.createVerticalStrut(12)
        );


        // =========================================================
        // CONFIRM PASSWORD
        // =========================================================

        JLabel confirmLabel =
                createLabel("Confirm Password");

        rightPanel.add(confirmLabel);

        rightPanel.add(
                Box.createVerticalStrut(5)
        );

        JPanel confirmPanel =
                createConfirmPasswordPanel();

        rightPanel.add(confirmPanel);


        rightPanel.add(
                Box.createVerticalStrut(20)
        );


        // =========================================================
        // REGISTER BUTTON
        // =========================================================

        JButton registerButton =
                new JButton("Create Account");

        styleMainButton(registerButton);

        registerButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        rightPanel.add(registerButton);


        rightPanel.add(
                Box.createVerticalStrut(12)
        );


        // =========================================================
        // BACK TO LOGIN
        // =========================================================

        JButton loginButton =
                new JButton("Back to Login");

        styleRegisterButton(loginButton);

        loginButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        rightPanel.add(loginButton);


        // =========================================================
        // BUTTON ACTIONS
        // =========================================================

        registerButton.addActionListener(
                e -> register()
        );

        loginButton.addActionListener(e -> {

            new LoginFrame();

            dispose();
        });


        // Press ENTER to register

        confirmPasswordField.addActionListener(
                e -> register()
        );


        // =========================================================
        // ADD PANELS
        // =========================================================

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        add(mainPanel);

        setVisible(true);
    }


    // =============================================================
    // REGISTER FUNCTION
    // =============================================================

    private void register() {

        String name =
                nameField.getText().trim();

        String username =
                usernameField.getText().trim();

        String password =
                new String(
                        passwordField.getPassword()
                );

        String confirmPassword =
                new String(
                        confirmPasswordField.getPassword()
                );


        // Empty fields

        if (name.isEmpty()
                || username.isEmpty()
                || password.isEmpty()
                || confirmPassword.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields.",
                    "Registration Required",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }


        // Password confirmation

        if (!password.equals(confirmPassword)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Passwords do not match.",
                    "Password Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }


        // Password length

        if (password.length() < 6) {

            JOptionPane.showMessageDialog(
                    this,
                    "Password must contain at least 6 characters.",
                    "Weak Password",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }


        // Create User

        User user =
                new User(
                        name,
                        username,
                        password
                );


        // Database

        UserDAO userDAO =
                new UserDAO();

        boolean success =
                userDAO.registerUser(user);


        if (success) {

            JOptionPane.showMessageDialog(
                    this,
                    "Registration successful!",
                    "Account Created",
                    JOptionPane.INFORMATION_MESSAGE
            );

            new LoginFrame();

            dispose();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Registration failed.\n" +
                    "Username may already exist.",
                    "Registration Failed",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // =============================================================
    // LABEL
    // =============================================================

    private JLabel createLabel(String text) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        label.setForeground(DARK_BLUE);

        label.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        return label;
    }


    // =============================================================
    // TEXT FIELD
    // =============================================================

    private void styleTextField(
            JTextField field
    ) {

        field.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        field.setBackground(Color.WHITE);

        field.setForeground(
                new Color(30, 40, 60)
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(
                                        140,
                                        190,
                                        250
                                ),
                                1
                        ),

                        BorderFactory.createEmptyBorder(
                                5,
                                12,
                                5,
                                12
                        )
                )
        );

        field.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        43
                )
        );

        field.setPreferredSize(
                new Dimension(
                        400,
                        43
                )
        );
    }


    // =============================================================
    // PASSWORD PANEL
    // =============================================================

    private JPanel createPasswordPanel() {

        JPanel panel =
                new JPanel(
                        new BorderLayout()
                );

        panel.setBackground(Color.WHITE);

        panel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        43
                )
        );

        panel.setPreferredSize(
                new Dimension(
                        400,
                        43
                )
        );

        panel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                190,
                                210,
                                240
                        ),
                        1
                )
        );


        passwordField =
                new JPasswordField();

        passwordField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        passwordField.setBorder(
                BorderFactory.createEmptyBorder(
                        5,
                        12,
                        5,
                        5
                )
        );


        JButton showButton =
                createShowButton(
                        passwordField
                );


        panel.add(
                passwordField,
                BorderLayout.CENTER
        );

        panel.add(
                showButton,
                BorderLayout.EAST
        );

        return panel;
    }


    // =============================================================
    // CONFIRM PASSWORD PANEL
    // =============================================================

    private JPanel createConfirmPasswordPanel() {

        JPanel panel =
                new JPanel(
                        new BorderLayout()
                );

        panel.setBackground(Color.WHITE);

        panel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        43
                )
        );

        panel.setPreferredSize(
                new Dimension(
                        400,
                        43
                )
        );

        panel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                190,
                                210,
                                240
                        ),
                        1
                )
        );


        confirmPasswordField =
                new JPasswordField();

        confirmPasswordField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        confirmPasswordField.setBorder(
                BorderFactory.createEmptyBorder(
                        5,
                        12,
                        5,
                        5
                )
        );


        JButton showButton =
                createShowButton(
                        confirmPasswordField
                );


        panel.add(
                confirmPasswordField,
                BorderLayout.CENTER
        );

        panel.add(
                showButton,
                BorderLayout.EAST
        );

        return panel;
    }


    // =============================================================
    // SHOW / HIDE PASSWORD
    // =============================================================

    private JButton createShowButton(
            JPasswordField field
    ) {

        JButton button =
                new JButton("Show");

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        12
                )
        );

        button.setForeground(BLUE);

        button.setBackground(Color.WHITE);

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        5,
                        10,
                        5,
                        10
                )
        );

        button.setFocusPainted(false);

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );


        button.addActionListener(e -> {

            if (field.getEchoChar() == '\u0000') {

                field.setEchoChar('•');

                button.setText("Show");

            } else {

                field.setEchoChar('\u0000');

                button.setText("Hide");
            }
        });

        return button;
    }


    // =============================================================
    // MAIN BUTTON
    // =============================================================

    private void styleMainButton(
            JButton button
    ) {

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16
                )
        );

        button.setForeground(Color.WHITE);

        button.setBackground(BLUE);

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        11,
                        30,
                        11,
                        30
                )
        );

        button.setFocusPainted(false);

        button.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        46
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );
    }


    // =============================================================
    // LOGIN BUTTON
    // =============================================================

    private void styleRegisterButton(
            JButton button
    ) {

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        button.setForeground(BLUE);

        button.setBackground(Color.WHITE);

        button.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                130,
                                190,
                                250
                        ),
                        1
                )
        );

        button.setFocusPainted(false);

        button.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        43
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );
    }


    // =============================================================
    // LEFT SIDE FEATURES
    // =============================================================

    private JLabel createFeature(
            String title,
            String description
    ) {

        JLabel label =
                new JLabel(
                        "<html>" +
                        "<b><font size='5' color='white'>" +
                        title +
                        "</font></b><br>" +
                        "<font size='3' color='#D8E4FF'>" +
                        description +
                        "</font>" +
                        "</html>"
                );

        label.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        return label;
    }


    // =============================================================
    // GRADIENT PANEL
    // =============================================================

    private static class GradientPanel
            extends JPanel {

        private final Color color1;
        private final Color color2;


        public GradientPanel(
                Color color1,
                Color color2
        ) {

            this.color1 = color1;
            this.color2 = color2;

            setOpaque(false);
        }


        @Override
        protected void paintComponent(
                Graphics g
        ) {

            Graphics2D g2 =
                    (Graphics2D) g.create();


            int width =
                    getWidth();

            int height =
                    getHeight();


            GradientPaint gradient =
                    new GradientPaint(
                            0,
                            0,
                            color1,
                            width,
                            height,
                            color2
                    );


            g2.setPaint(gradient);

            g2.fillRect(
                    0,
                    0,
                    width,
                    height
            );


            g2.dispose();

            super.paintComponent(g);
        }
    }
}