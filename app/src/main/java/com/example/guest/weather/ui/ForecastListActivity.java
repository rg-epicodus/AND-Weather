package com.example.guest.weather.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.telecom.Call;

import com.example.guest.weather.R;
import com.example.guest.weather.models.Forecast;
import com.example.guest.weather.services.APIService;
import com.squareup.picasso.Downloader;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 10/17/17.
 */

public class ForecastListActivity extends AppCompatActivity {
    public static final String TAG = ForecastListActivity.class.getSimpleName();

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
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
    }

    private void getForecasts(String location) {
        final APIService apiService = new APIService();
        apiService.findForecasts(location, new ItemTouchHelper.Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Downloader.Response response) {
                forecasts = apiService.processResults(response);

                ForecastListActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        mAdapter = new ForecastListAdapter(getApplicationContext(), forecasts);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(ForecastListActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
