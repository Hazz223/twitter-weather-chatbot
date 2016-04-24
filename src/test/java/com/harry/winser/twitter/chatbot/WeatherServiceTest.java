package com.harry.winser.twitter.chatbot;


import com.harry.winser.twitter.chatbot.services.weather.WeatherServiceImpl;
import org.bitpipeline.lib.owm.ForecastWeatherData;
import org.bitpipeline.lib.owm.OwmClient;
import org.junit.Test;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherServiceTest {

    // This is also a part integration test with the external client. Not great, or proper testing practise.
    // Don't hate me!

    private OwmClient client = new OwmClient();
    private WeatherServiceImpl weatherService = new WeatherServiceImpl(client);

    @Test
    public void shouldReturnCurrentWeatherForLondon(){


    }

    @Test
    public void shouldGetClosestToHour(){

        ForecastWeatherData weatherByDateAndTime = this.weatherService.getTodaysForecastByTime(LocalTime.of(20, 0));

        assertThat(weatherByDateAndTime).isInstanceOf(ForecastWeatherData.class);

    }

}
