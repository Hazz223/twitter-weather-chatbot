package com.harry.winser.twitter.chatbot.services.formatter;


public class Message {

    private String body;

    public Message(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Hey! Listen!\r\n" + this.body;
    }
}
