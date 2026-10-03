package com.chatbot.model;

public class Intent {

    private int id;
    private String intentName;
    private String description;

    public Intent() {
    }

    public Intent(int id, String intentName, String description) {
        this.id = id;
        this.intentName = intentName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}