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
//        @Bind(R.id.forecastImageView) ImageView mForecastImageView;
//        @Bind(R.id.forecastTempTextView) TextView mTempTextView;
        @Bind(R.id.currentWeatherTextView) TextView mCurrentWeatherTextView;
//        @Bind(R.id.categoryTextView) TextView mCategoryTextView;
//        @Bind(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public ForecastViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindForecast(Forecast forecast) {
//            Picasso.with(mContext).load(forecast.getImageUrl()).into(mForecastImageView);
            mCurrentWeatherTextView.setText(forecast.getCurrentWeather());
//            mCategoryTextView.setText(forecast.getCategories().get(0));
//            mRatingTextView.setText("Rating: " + forecast.getRating() + "/5");
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
