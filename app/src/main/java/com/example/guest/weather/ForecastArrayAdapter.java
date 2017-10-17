package com.example.guest.weather;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by Guest on 10/17/17.
 */

public class ForecastArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mForecasts;

    public ForecastArrayAdapter(Context mContext, int resource, String[] mForecasts) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mForecasts = mForecasts;
    }

    @Override
    public Object getItem(int position) {
        String forecast = mForecasts[position];
        return String.format("%s \nServes great: %s", forecast);
    }

    @Override
    public int getCount() {
        return mForecasts.length;
    }
}
