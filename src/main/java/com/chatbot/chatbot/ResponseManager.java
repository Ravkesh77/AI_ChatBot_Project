package com.chatbot.chatbot;

import com.chatbot.database.ResponseDAO;

public class ResponseManager {

    private ResponseDAO responseDAO;

    public ResponseManager() {
        responseDAO = new ResponseDAO();
    }

    public String getResponse(String intent) {

        String databaseResponse =
                responseDAO.getResponse(intent);

        if (databaseResponse != null) {
            return databaseResponse;
        }

        switch (intent) {

            case "GREETING":
                return "Hello! How can I help you?";

            case "NAME":
                return "My name is JavaBot.";

            case "HOW_ARE_YOU":
                return "I am fine! Thanks for asking.";

            case "JAVA":
                return "Java is a popular object-oriented programming language.";

            case "OOP":
                return "OOP stands for Object-Oriented Programming.";

            case "HELP":
                return "Sure! Tell me what you need help with.";

            case "GOODBYE":
                return "Goodbye! Have a nice day.";

            default:
                return "Sorry, I don't understand that yet.";
        }
    }
}