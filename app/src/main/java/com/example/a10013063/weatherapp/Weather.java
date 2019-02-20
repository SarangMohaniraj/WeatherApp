package com.example.a10013063.weatherapp;

public class Weather {
    int zip;
    String city;
    String currentDate;
    int currentTemp;
    int todayHigh;
    int todayLow;
    String description;
    String icon;
    String quote;
    int imgRes;

    public Weather(int zip) {
        this.zip = zip;
    }

    public Weather(String zip) {
        this.zip = Integer.parseInt(zip);
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public int getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(double currentTemp) {
        this.currentTemp = (int)Math.round(currentTemp);
    }

    public int getTodayHigh() {
        return todayHigh;
    }

    public void setTodayHigh(double todayHigh) {
        this.todayHigh = (int)Math.round(todayHigh);
    }

    public int getTodayLow() {
        return todayLow;
    }

    public void setTodayLow(double todayLow) {
        this.todayLow = (int)Math.round(todayLow);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getQuote() {
        return quote;
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

    public void setQuote(String icon){

        switch (icon) {
            case "01d":
                this.quote = "it is too clear to go out";
                break;
            case "01n":
                this.quote = "alien lifeforms are safer at night";
                break;
            case "02d":
                this.quote = "aliens, don't be fooled by the cover of the clouds";
                break;
            case "02n":
                this.quote = "the moon is visible as well as your home galaxies";
                break;
            case "03d":
                this.quote = "you are shielded by the clouds, but be wary";
                break;
            case "03n":
                this.quote = "the clouds and darkness give you cover";
                break;
            case "04d":
                this.quote = "this is your time to be outside in the human world during the day";
                break;
            case "04n":
                this.quote = "have fun, but don't get caught by humans!";
                break;
            case "09d":
                this.quote = "the rain will moisturize you from the dry Earth atmosphere";
                break;
            case "09n":
                this.quote = "perfect weather to wear a hood to hide in your human disguise";
                break;
            case "10d":
                this.quote = "the sunshowers are a beautiful event on Earth";
                break;
            case "10n":
                this.quote = "it's gloomy outside, might as well stay underground";
                break;
            case "11d":
                this.quote = "don't worry, lightning on Earth is not as bad as it is on your planet";
                break;
            case "11n":
                this.quote = "don't get struck by lightning! even the MIB can't help you then";
                break;
            case "13d":
                this.quote = "go outside and experience the sensations of Earth!!";
                break;
            case "13n":
                this.quote = "clumsy aliens should NOT go outside in the slippery conditions";
                break;
            case "50d":
                this.quote = "the morning dew will refresh you for your human jobs";
                break;
            case "50n":
                this.quote = "the heavy night mist allows you to reveal yourself without harm";
                break;
            default:
                this.quote = "the conditions are unknown! the alien world is on lockdown!";
                break;
        }

    }
}

