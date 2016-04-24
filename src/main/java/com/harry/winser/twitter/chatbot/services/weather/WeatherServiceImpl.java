package com.harry.winser.twitter.chatbot.services.weather;


import org.apache.commons.lang3.time.DateUtils;
import org.bitpipeline.lib.owm.*;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class WeatherServiceImpl implements WeatherService {

    private OwmClient weatherClient;

    @Autowired
    public WeatherServiceImpl(OwmClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @Override
    public String getWeather() {

        try {

            WeatherStatusResponse weatherStatusResponse = this.weatherClient.currentWeatherAtCity("London");

            if (weatherStatusResponse.hasWeatherStatus()) {

                StatusWeatherData weatherData = weatherStatusResponse.getWeatherStatus().get(0);

                return weatherData.getWeatherConditions().get(0).getDescription();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }

        return "Failed to get weather data...";
    }

    public ForecastWeatherData getTodaysForecastByTime(LocalTime time) {

        int givenHour = time.getHour();
        ForecastWeatherData result = null;

        Map<LocalTime, ForecastWeatherData> todaysWeather = this.getTodaysWeather();

        result = todaysWeather.entrySet().stream()
                .filter(entry -> {
                    int forecastHour = entry.getKey().getHour();
                    return forecastHour == givenHour || ((forecastHour + 1) == givenHour) || ((forecastHour - 1) == givenHour);
                })
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nothing cam back"))
                .getValue();

        return result;
    }

    @Override
    public Map<LocalTime, ForecastWeatherData> getTodaysWeather() {

        Map<LocalTime, ForecastWeatherData> forecast = new HashMap<>();
        Date today = new Date();

        try {
            WeatherForecastResponse response = this.weatherClient.forecastWeatherAtCity(2643741);

            if (response.hasForecasts()) {
                List<ForecastWeatherData> forecasts = response.getForecasts();

                forecast = forecasts.stream()
                        .filter(x -> DateUtils.isSameDay(today, new Date(x.getDateTime() * 1000)))
                        .collect(Collectors
                                .toMap(x -> new Date(x.getDateTime() * 1000).toInstant().atZone(ZoneId.of("GMT")).toLocalTime(),
                                        x -> x));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return forecast;
    }
}
