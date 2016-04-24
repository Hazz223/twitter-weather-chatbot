package com.harry.winser.twitter.chatbot.services.schedular;

import com.harry.winser.twitter.chatbot.services.notifier.TwitterWeatherNotifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class WeatherSchedulingImpl implements WeatherScheduling {

    private TwitterWeatherNotifier twitterWeatherNotifier;

    @Autowired
    public WeatherSchedulingImpl(TwitterWeatherNotifier twitterWeatherNotifier) {
        this.twitterWeatherNotifier = twitterWeatherNotifier;
    }

    @Override
    @Scheduled(cron = "0 15 7 * * *")
    public void morningWeatherTweet() {

        System.out.println("Sending morning tweet");
        this.twitterWeatherNotifier.notifyTimeForecast(LocalTime.of(9, 0));
    }

    @Override
    @Scheduled(cron = "0 0 16 * * *")
    public void afternoonTweet() {

        System.out.println("Sending afternoon tweet");
        this.twitterWeatherNotifier.notifyTimeForecast(LocalTime.of(18, 0));
    }
}
