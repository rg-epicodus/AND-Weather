package com.example.guest.weather.services;

import android.util.Log;

import com.example.guest.weather.Constants;
import com.example.guest.weather.models.Forecast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 10/17/17.
 */

public class APIService {
    public static void findForecasts(String location, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.LOCATION_QUERY_PARAMETER, location);
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY);
        String url = urlBuilder.build().toString();
        Log.v("String url", url);
        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }

    public ArrayList<Forecast> processResults(Response response) {
        ArrayList<Forecast> forecasts = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            JSONObject apiJSON = new JSONObject(jsonData);
            JSONArray listJSON = apiJSON.getJSONArray("list");
            for (int i = 0; i < listJSON.length(); i++) {
                JSONObject mainJSON = listJSON.getJSONObject(i);
                double temp = mainJSON.getDouble("temp");
                double temp_max = mainJSON.getDouble("temp_max");
                double temp_min = mainJSON.getDouble("temp_min");
                String currentWeather = mainJSON.getString("description");
                int timeForecast = mainJSON.getInt("dt");
                Forecast forecast = new Forecast(temp, temp_max, temp_min, currentWeather, timeForecast);
                forecasts.add(forecast);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return forecasts;
    }
}
