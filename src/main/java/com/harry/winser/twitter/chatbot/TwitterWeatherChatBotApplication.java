package com.harry.winser.twitter.chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling
public class TwitterWeatherChatBotApplication {

	public static void main(String[] args) {

		SpringApplication.run(TwitterWeatherChatBotApplication.class, args);
	}

	@PostConstruct
	public void startUp(){
		System.out.println("Application has started.");
	}

}
