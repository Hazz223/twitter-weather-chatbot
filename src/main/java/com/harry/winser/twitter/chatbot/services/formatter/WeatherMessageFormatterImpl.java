package com.harry.winser.twitter.chatbot.services.formatter;

import org.bitpipeline.lib.owm.ForecastWeatherData;
import org.bitpipeline.lib.owm.WeatherData;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
public class WeatherMessageFormatterImpl implements WeatherMessageFormatter {

    @Override
    public Message formatForecastWeather(ForecastWeatherData weatherData, LocalTime time) {

        List<WeatherData.WeatherCondition> weatherConditions = weatherData.getWeatherConditions();
        // todo: extra validation around this...
        WeatherData.WeatherCondition weatherCondition = weatherConditions.get(0);
        String description = weatherCondition.getDescription();

        String messageBody = String.format("At %s, the weather is predicted to be: '%s'",
                time.toString(),
                description);

        return new Message(messageBody);
    }
}
