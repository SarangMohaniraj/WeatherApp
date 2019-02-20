package com.example.a10013063.weatherapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Forecast {
    String date;
    int high;
    int low;
    String icon;
    int icon01d, icon01n, icon02d, icon02n, icon03, icon04, icon09, icon10d, icon10n, icon11, icon13, icon50, imgRes;


    public Forecast(String date, double high, double low, String icon) {
        this.date = date;
        this.high = (int)Math.round(high);
        this.low = (int)Math.round(low);
        this.icon = icon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = (int)Math.round(high);
    }

    public int getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = (int)Math.round(low);
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void countIcon(String cIcon){
        switch(cIcon){
            case "01d" :
                icon01d++;
                break;
            case "01n" :
                icon01n++;
                break;
            case "02d" :
                icon02d++;
                break;
            case "02n" :
                icon02n++;
                break;
            case "03d" :
                icon03++;
                break;
            case "03n" :
                icon03++;
                break;
            case "04d" :
                icon04++;
                break;
            case "04n" :
                icon04++;
                break;
            case "09d" :
                icon09++;
                break;
            case "09n" :
                icon09++;
                break;
            case "10d" :
                icon10d++;
                break;
            case "10n" :
                icon10n++;
                break;
            case "11d" :
                icon11++;
                break;
            case "11n" :
                icon11++;
                break;
            case "13d" :
                icon13++;
                break;
            case "13n" :
                icon13++;
                break;
            case "50d" :
                icon50++;
                break;
            case "50n" :
                icon50++;
                break;
        }

    }

    public void verifyIcon(){
        List<Integer> icons = new ArrayList<>();
        icons.add(icon01d);
        icons.add(icon01n);
        icons.add(icon02d);
        icons.add(icon02n);
        icons.add(icon03);
        icons.add(icon04);
        icons.add(icon09);
        icons.add(icon10d);
        icons.add(icon10n);
        icons.add(icon11);
        icons.add(icon13);
        icons.add(icon50);

        Integer max = Collections.max(icons);


        if(max == icon01d)
            this.icon = "01d";
        else if(max == icon01n)
            this.icon = "01n";
        else if(max == icon02d)
            this.icon = "02d";
        else if(max == icon02n)
            this.icon = "02n";
        else if(max == icon03)
            this.icon = "03d";
        else if(max == icon04)
            this.icon = "04d";
        else if(max == icon09)
            this.icon = "09d";
        else if(max == icon10d)
            this.icon = "10d";
        else if(max == icon10n)
            this.icon = "10n";
        else if(max == icon11)
            this.icon = "11d";
        else if(max == icon13)
            this.icon = "13d";
        else if(max == icon50)
            this.icon = "50d";

    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(String icon) {
        switch (icon) {
            case "01d":
                this.imgRes = R.drawable.clear_day;
                break;
            case "01n":
                this.imgRes = R.drawable.clear_night;
                break;
            case "02d":
                this.imgRes = R.drawable.partly_cloudy_day;
                break;
            case "02n":
                this.imgRes = R.drawable.partly_cloudy_night;
                break;
            case "03d":
                this.imgRes = R.drawable.scattered_clouds;
                break;
            case "03n":
                this.imgRes = R.drawable.scattered_clouds;
                break;
            case "04d":
                this.imgRes = R.drawable.broken_clouds;
                break;
            case "04n":
                this.imgRes = R.drawable.broken_clouds;
                break;
            case "09d":
                this.imgRes = R.drawable.rain_showers;
                break;
            case "09n":
                this.imgRes = R.drawable.rain_showers;
                break;
            case "10d":
                this.imgRes = R.drawable.rain_day;
                break;
            case "10n":
                this.imgRes = R.drawable.rain_night;
                break;
            case "11d":
                this.imgRes = R.drawable.thunderstorm;
                break;
            case "11n":
                this.imgRes = R.drawable.thunderstorm;
                break;
            case "13d":
                this.imgRes = R.drawable.snow;
                break;
            case "13n":
                this.imgRes = R.drawable.snow;
                break;
            case "50d":
                this.imgRes = R.drawable.mist;
                break;
            case "50n":
                this.imgRes = R.drawable.mist;
                break;
        }

    }
}
