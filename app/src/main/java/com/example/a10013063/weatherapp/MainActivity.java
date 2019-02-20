package com.example.a10013063.weatherapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ConstraintLayout splash;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        splash = findViewById(R.id.id_splash);
        progressBar = findViewById(R.id.id_progressBar);

        if (getIntent().hasExtra("zip"))
            new KeyCall().execute(getIntent().getStringExtra("zip")); //Retrieve Weather


    }

    public class KeyCall extends AsyncTask<String, Integer, Void> { //change first void to string

        String zip;
        String line;
        String raw = "";
        String apiKey = "&appid=fb487abb9da90a9812139e5cad260695&units=imperial";

        Weather weather;
        List<Forecast> forecastList = new ArrayList<>(); // holds forecast
        TextView currentDate;
        TextView todayHigh;
        TextView todayLow;
        TextView currentTemp;
        TextView description;
        TextView quote;
        TextView city;
        TextView day1High;
        TextView day1Low;
        TextView day1Date;
        ImageView day1Img;
        TextView day2High;
        TextView day2Low;
        TextView day2Date;
        ImageView day2Img;
        TextView day3High;
        TextView day3Low;
        TextView day3Date;
        ImageView day3Img;
        TextView day4High;
        TextView day4Low;
        TextView day4Date;
        ImageView day4Img;
        ImageView currentImg;

        @Override
        protected void onPreExecute() {
            splash.setVisibility(View.VISIBLE);
            currentImg = findViewById(R.id.id_imageview_current);
            currentImg.setVisibility(View.INVISIBLE);
        }



        @Override
        protected Void doInBackground(String... strings) {
            zip = strings[0];
            weather = new Weather(zip);

            getCurrent();
            getForecast();

            try {
                Thread.sleep(500); //so there is always a consistent visually appealing progress bar
            } catch (InterruptedException e) {}
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        public void getCurrent() {
            try {
                raw = "";
                String current = "http://api.openweathermap.org/data/2.5/weather?zip=";
                URL key = new URL(current + zip + apiKey);
                BufferedReader reader = new BufferedReader(new InputStreamReader(key.openStream()));
                while ((line = reader.readLine()) != null) {
                    raw += line;
                }
                reader.close();
                JSONObject data = new JSONObject(raw);
                JSONObject main = data.getJSONObject("main");
                weather.setCurrentTemp(main.getDouble("temp"));
                weather.setTodayHigh(main.getDouble("temp_max"));
                weather.setTodayLow(main.getDouble("temp_min"));
                weather.setCity(data.getString("name"));
                weather.setDescription(data.getJSONArray("weather").getJSONObject(0).getString("description"));
                weather.setCurrentDate(new Date((long) (Integer.parseInt(data.getString("dt"))) * 1000).toString().substring(0, 11));
                weather.setIcon(data.getJSONArray("weather").getJSONObject(0).getString("icon"));
                weather.setImgRes(weather.getIcon());
                weather.setQuote(weather.getIcon());

            } catch (Exception e) {
                if (e instanceof MalformedURLException) {
                    Toast.makeText(MainActivity.this, "Please Enter a Valid Zip Code", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        }

        public void getForecast() {
            try {
                raw = "";
                String forecast = "http://api.openweathermap.org/data/2.5/forecast?zip=";
                URL key = new URL(forecast + zip + apiKey);
                BufferedReader reader = new BufferedReader(new InputStreamReader(key.openStream()));
                while ((line = reader.readLine()) != null) {
                    raw += line;
                }
                reader.close();

                JSONObject data = new JSONObject(raw);
                JSONArray list = data.getJSONArray("list");

                int days = 0;
                String prev = weather.getCurrentDate();
                int j = 0;
                while (days < 5 && j < list.length()) {
                    String daily = new Date((long) (Integer.parseInt(list.getJSONObject(j).getString("dt"))) * 1000).toString().substring(0, 11);
                    double high = Double.parseDouble(list.getJSONObject(j).getJSONObject("main").getString("temp_max"));
                    double low = Double.parseDouble(list.getJSONObject(j).getJSONObject("main").getString("temp_min"));
                    String icon = list.getJSONObject(j).getJSONArray("weather").getJSONObject(0).getString("icon");
                    if(!forecastList.isEmpty())
                        forecastList.get(days-1).countIcon(icon);
                    if (!daily.equals(prev)) { //different day than before
                        if(forecastList != null && !forecastList.isEmpty()) {
                            forecastList.get(days-1).verifyIcon();
                            forecastList.get(days-1).setImgRes(forecastList.get(days-1).getIcon());
                        }

                        forecastList.add(new Forecast(daily, high, low, icon));
                        prev = "";
                        prev += daily;
                        days++;
                    } else if(days!= 0) { //same day as before
                        if (low < forecastList.get(days - 1).getLow()) {
                            forecastList.get(days - 1).setLow(low);
                        }
                        if (high > forecastList.get(days - 1).getHigh()) {
                            forecastList.get(days - 1).setHigh(high);
                        }
                    }

                    j++;

                }


            } catch (Exception e) {}
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            currentDate = findViewById(R.id.id_currentDate);
            todayHigh = findViewById(R.id.id_todayHigh);
            todayLow = findViewById(R.id.id_todayLow);
            currentTemp = findViewById(R.id.id_currentTemp);
            description = findViewById(R.id.id_description);
            quote = findViewById(R.id.id_quote);
            city = findViewById(R.id.id_city);
            day1High = findViewById(R.id.id_day1_high);
            day1Low = findViewById(R.id.id_day1_low);
            day1Date = findViewById(R.id.id_day1_date);
            day1Img = findViewById(R.id.id_day1_img);
            day2High = findViewById(R.id.id_day2_high);
            day2Low = findViewById(R.id.id_day2_low);
            day2Date = findViewById(R.id.id_day2_date);
            day2Img = findViewById(R.id.id_day2_img);
            day3High = findViewById(R.id.id_day3_high);
            day3Low = findViewById(R.id.id_day3_low);
            day3Date = findViewById(R.id.id_day3_date);
            day3Img = findViewById(R.id.id_day3_img);
            day4High = findViewById(R.id.id_day4_high);
            day4Low = findViewById(R.id.id_day4_low);
            day4Date = findViewById(R.id.id_day4_date);
            day4Img = findViewById(R.id.id_day4_img);

            currentImg.setVisibility(View.VISIBLE);
            currentImg.setImageResource(weather.getImgRes());
            currentDate.setText(weather.getCurrentDate());
            todayHigh.setText(weather.getTodayHigh() + "°");
            todayLow.setText(weather.getTodayLow() + "°");
            currentTemp.setText(weather.getCurrentTemp() + "°");
            description.setText(weather.getDescription());
            quote.setText(weather.getQuote());
            city.setText(weather.getCity());
            day1High.setText(forecastList.get(0).getHigh() + "°");
            day1Low.setText(forecastList.get(0).getLow() + "°");
            day1Date.setText(forecastList.get(0).getDate());
            day1Img.setImageResource(forecastList.get(0).getImgRes());
            day2High.setText(forecastList.get(1).getHigh() + "°");
            day2Low.setText(forecastList.get(1).getLow() + "°");
            day2Date.setText(forecastList.get(1).getDate());
            day2Img.setImageResource(forecastList.get(1).getImgRes());
            day3High.setText(forecastList.get(2).getHigh() + "°");
            day3Low.setText(forecastList.get(2).getLow() + "°");
            day3Date.setText(forecastList.get(2).getDate());
            day3Img.setImageResource(forecastList.get(2).getImgRes());
            day4High.setText(forecastList.get(3).getHigh() + "°");
            day4Low.setText(forecastList.get(3).getLow() + "°");
            day4Date.setText(forecastList.get(3).getDate());
            day4Img.setImageResource(forecastList.get(3).getImgRes());
            splash.setVisibility(View.GONE);



        }
    }
}


