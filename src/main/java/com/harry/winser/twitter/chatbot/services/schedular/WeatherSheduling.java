package com.harry.winser.twitter.chatbot.services.schedular;


public interface WeatherSheduling {

    /**
     * Morning tweet for the weather. This is for 7:30
     */
    void morningWeatherTweet();

    /**
     * Tweet for the afternoon, so i know if it'll rain. This will be for 15:00
     */
    void afternoonTweet();

}
