package com.example.guest.weather.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.weather.R;
import com.example.guest.weather.models.Forecast;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastDetailFragment extends Fragment {
//    @Bind(R.id.forecastImageView) ImageView mImageLabel;
    @Bind(R.id.currentWeatherTextView) TextView mCurrentWeatherLabel;


    private Forecast mForecast;

    public static ForecastDetailFragment newInstance(Forecast forecast) {
        ForecastDetailFragment forecastDetailFragment = new ForecastDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("forecast", Parcels.wrap(forecast));
        forecastDetailFragment.setArguments(args);
        return forecastDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mForecast = Parcels.unwrap(getArguments().getParcelable("forecast"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast_detail, container, false);
        ButterKnife.bind(this, view);

//        Picasso.with(view.getContext()).load(mForecast.getImageUrl()).into(mImageLabel);

        mCurrentWeatherLabel.setText(mForecast.getCurrentWeather());


        return view;
    }
}

