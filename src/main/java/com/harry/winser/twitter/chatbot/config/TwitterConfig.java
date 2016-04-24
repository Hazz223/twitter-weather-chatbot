package com.harry.winser.twitter.chatbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

@Configuration
public class TwitterConfig {

    @Bean
    public Twitter twitterInstance(){

        return new TwitterFactory().getInstance();
    }

}
