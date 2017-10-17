package com.example.guest.weather.adapters;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.guest.weather.models.Forecast;
import com.example.guest.weather.ui.ForecastDetailFragment;


import java.util.ArrayList;

/**
 * Created by Guest on 10/17/17.
 */

public class ForecastPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Forecast> mForecasts;

    public ForecastPagerAdapter(FragmentManager fm, ArrayList<Forecast> forecasts) {
        super(fm);
        mForecasts = forecasts;
    }

    @Override
    public Fragment getItem(int position) {
        return ForecastDetailFragment.newInstance(mForecasts.get(position));
    }

    @Override
    public int getCount() {
        return mForecasts.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mForecasts.get(position).getCurrentWeather();
    }
}
