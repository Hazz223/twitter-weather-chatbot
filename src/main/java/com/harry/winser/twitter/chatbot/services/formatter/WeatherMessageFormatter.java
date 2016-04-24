package com.harry.winser.twitter.chatbot.services.formatter;


import org.bitpipeline.lib.owm.ForecastWeatherData;

import java.time.LocalTime;

public interface WeatherMessageFormatter {

    Message formatForecastWeather(ForecastWeatherData weatherData, LocalTime time);
}
