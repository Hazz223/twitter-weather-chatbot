package com.harry.winser.twitter.chatbot.services.notifier;


import java.time.LocalTime;

public interface TwitterWeatherNotifier {

    void notifyTimeForecast(LocalTime localTime);

}
