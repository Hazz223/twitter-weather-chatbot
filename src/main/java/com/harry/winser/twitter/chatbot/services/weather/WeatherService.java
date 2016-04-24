package com.harry.winser.twitter.chatbot.services.weather;


import org.bitpipeline.lib.owm.ForecastWeatherData;
import org.bitpipeline.lib.owm.WeatherStatusResponse;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface WeatherService {

    String getWeather();

    Map<LocalTime,ForecastWeatherData> getTodaysWeather();

    /**
     * Only works for 06:00, 09:00, 12:00, 15:00, 18:00, 21:00 due to api constraints
     * @param time
     * @return
     */
    ForecastWeatherData getTodaysForecastByTime(LocalTime time);

}
