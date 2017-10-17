package com.example.guest.weather.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.weather.R;
import com.example.guest.weather.models.Forecast;
import com.example.guest.weather.ui.ForecastDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 10/17/17.
 */

public class ForecastListAdapter extends RecyclerView.Adapter<ForecastListAdapter.ForecastViewHolder>{
    private ArrayList<Forecast> mForecasts = new ArrayList<>();
    private Context mContext;

    public ForecastListAdapter(Context context, ArrayList<Forecast> forecasts) {
        mContext = context;
        mForecasts = forecasts;
    }

    @Override
    public ForecastListAdapter.ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_list_item, parent, false);
        ForecastViewHolder viewHolder = new ForecastViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastListAdapter.ForecastViewHolder holder, int position) {
        holder.bindForecast(mForecasts.get(position));
    }

    @Override
    public int getItemCount() {
        return mForecasts.size();
    }

    public class ForecastViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.forecastImageView) ImageView mForecastImageView;
        @Bind(R.id.temp_maxTextView) TextView mTempMaxTextView;
        @Bind(R.id.temp_minTextView) TextView mTempMinTextView;
        @Bind(R.id.currentWeatherTextView) TextView mCurrentWeatherTextView;
        @Bind(R.id.mainTextView) TextView mMainTextView;
        @Bind(R.id.timeDateTextView) TextView mDate;

        private Context mContext;

        public ForecastViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindForecast(Forecast forecast) {
            String iconUrl = "http://openweathermap.org/img/w/" + (forecast.getImageUrl()) + ".png";
            Picasso.with(mContext).load(iconUrl).into(mForecastImageView);
            mDate.setText(Integer.toString(forecast.getTimeForecast()));
            mMainTextView.setText(forecast.getMain());
            mCurrentWeatherTextView.setText(forecast.getCurrentWeather());
            mTempMaxTextView.setText("Max Temp: " + Double.toString(forecast.getTemp_max()) + "\u00b0" + "F");
            mTempMinTextView.setText("Min Temp: " + Double.toString(forecast.getTemp_min())+ "\u00b0" + "F");
        }

        @Override
        public void onClick(View v) {
            Log.d("click listener", "working!");
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, ForecastDetailActivity.class);
            intent.putExtra("position", itemPosition + "");
            intent.putExtra("forecasts", Parcels.wrap(mForecasts));
            mContext.startActivity(intent);
        }
    }

}
