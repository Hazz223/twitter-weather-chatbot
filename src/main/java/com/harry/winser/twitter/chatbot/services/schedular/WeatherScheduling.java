package com.harry.winser.twitter.chatbot.services.schedular;


public interface WeatherScheduling {

    /**
     * Morning tweet for the weather. This is for 7:15
     */
    void morningWeatherTweet();

    /**
     * Tweet for the afternoon, so i know if it'll rain. This will be for 16:00
     */
    void afternoonTweet();

}
