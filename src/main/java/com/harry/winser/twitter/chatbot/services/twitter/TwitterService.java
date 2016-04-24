package com.harry.winser.twitter.chatbot.services.twitter;


import com.harry.winser.twitter.chatbot.services.formatter.Message;

import java.util.List;

public interface TwitterService {

    void sendDirectMessages(List<String> userNames, Message message);

}
