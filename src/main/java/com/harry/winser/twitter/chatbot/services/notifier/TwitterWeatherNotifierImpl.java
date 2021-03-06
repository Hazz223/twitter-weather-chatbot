package com.harry.winser.twitter.chatbot.services.notifier;


import com.google.common.collect.Lists;
import com.harry.winser.twitter.chatbot.services.formatter.Message;
import com.harry.winser.twitter.chatbot.services.formatter.WeatherMessageFormatter;
import com.harry.winser.twitter.chatbot.services.twitter.TwitterService;
import com.harry.winser.twitter.chatbot.services.weather.WeatherService;
import org.bitpipeline.lib.owm.ForecastWeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalTime;

@Service
public class TwitterWeatherNotifierImpl implements TwitterWeatherNotifier {

    private TwitterService twitterService;
    private WeatherService weatherService;
    private WeatherMessageFormatter weatherMessageFormatter;

    @Autowired
    public TwitterWeatherNotifierImpl(TwitterService twitterService, WeatherService weatherService, WeatherMessageFormatter weatherMessageFormatter) {
        this.twitterService = twitterService;
        this.weatherService = weatherService;
        this.weatherMessageFormatter = weatherMessageFormatter;
    }

    public void notifyTimeForecast(LocalTime time) {

        ForecastWeatherData forecast = this.weatherService.getTodaysForecastByTime(time);

        Message message = this.weatherMessageFormatter.formatForecastWeather(forecast, time);

        this.twitterService.sendDirectMessages(Lists.newArrayList("Hazz223"), message);
    }
}
