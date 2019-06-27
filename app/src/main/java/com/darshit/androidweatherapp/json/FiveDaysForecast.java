package com.darshit.androidweatherapp.json;

public class FiveDaysForecast {

    private Forecast dailyForecast;

    public FiveDaysForecast(Forecast dailyForecast) {
        this.dailyForecast = dailyForecast;
    }

    public Forecast getDailyForecast() {
        return dailyForecast;
    }
}
