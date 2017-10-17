package com.example.guest.weather.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.guest.weather.R;
import com.example.guest.weather.adapters.ForecastListAdapter;
import com.example.guest.weather.models.Forecast;
import com.example.guest.weather.services.APIService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Guest on 10/17/17.
 */

public class ForecastListActivity extends AppCompatActivity {
    public static final String TAG = ForecastListActivity.class.getSimpleName();
    @Bind(R.id.testText) TextView mTestText;
//    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private ForecastListAdapter mAdapter;

    public ArrayList<Forecast> forecasts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        getForecasts(location);

        mTestText.setText("Weather near " + location);
        System.out.println("Weather near " + location);
    }

    private void getForecasts(String location) {
        final APIService apiService = new APIService();
        apiService.findForecasts(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e){
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.d(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }













//                forecasts = apiService.processResults(response);
//
//                ForecastListActivity.this.runOnUiThread(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        mAdapter = new ForecastListAdapter(getApplicationContext(), forecasts);
//                        mRecyclerView.setAdapter(mAdapter);
//                        RecyclerView.LayoutManager layoutManager =
//                                new LinearLayoutManager(ForecastListActivity.this);
//                        mRecyclerView.setLayoutManager(layoutManager);
//                        mRecyclerView.setHasFixedSize(true);
//                    }
//                });
//            }
        });
    }
}
