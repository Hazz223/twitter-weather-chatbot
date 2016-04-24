package com.harry.winser.twitter.chatbot.config;

import org.bitpipeline.lib.owm.OwmClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherConfig {

    @Value("${open.weather.api.key}")
    private String apiKey;

    @Bean
    public OwmClient getOpenWeatherClient(){
        OwmClient client = new OwmClient();
        client.setAPPID(apiKey);
        return client;
    }

}
