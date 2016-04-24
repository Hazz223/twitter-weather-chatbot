package com.harry.winser.twitter.chatbot.services.twitter;

import com.harry.winser.twitter.chatbot.services.formatter.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;

@Service
public class TwitterServiceImpl implements TwitterService {

    private Twitter twitter;

    @Autowired
    public TwitterServiceImpl(Twitter twitter) {
        this.twitter = twitter;
    }

    @Override
    public void sendDirectMessages(List<String> userNames, Message message) {

        userNames.stream().forEach(x -> {
            try {
                this.twitter.sendDirectMessage(x, message.toString());
            } catch (TwitterException e) {
                // todo Add proper logging here. Will make it much easier...
                e.printStackTrace();
            }
        });
    }
}
