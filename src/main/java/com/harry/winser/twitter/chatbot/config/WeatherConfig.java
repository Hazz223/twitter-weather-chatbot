package com.harry.winser.twitter.chatbot.config;

import org.bitpipeline.lib.owm.OwmClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherConfig {

    @Bean
    public OwmClient getOpenWeatherClient(){
        return new OwmClient();
    }

}
