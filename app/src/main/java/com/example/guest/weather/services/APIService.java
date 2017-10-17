package com.example.guest.weather.services;

import com.example.guest.weather.Constants;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Request;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

/**
 * Created by Guest on 10/17/17.
 */

public class APIService {
    public static void findRestaurants(String location, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YOUR_QUERY_PARAMETER, location);
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY);
        String url = urlBuilder.build().toString();

        Request request= new Request.Builder()
                .url(url)
                .header("Authorization", Constants.API_KEY)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }
}
