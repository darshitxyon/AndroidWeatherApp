package com.darshit.androidweatherapp.json;

import java.util.List;

public class FiveWeathers {

    private String dt_txt;

    private Main main;

    private List<WeatherResults> conditions;

    public FiveWeathers(String dt_txt, Main main, List<WeatherResults> conditions) {
        this.dt_txt = dt_txt;
        this.main = main;
        this.conditions = conditions;
    }

    public String getDt_txt(){
        return dt_txt;
    }

    public Main getMain() {
        return main;
    }

    public List<WeatherResults> getConditions() {
        return conditions;
    }
}
