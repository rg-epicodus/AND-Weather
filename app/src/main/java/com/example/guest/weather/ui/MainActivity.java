package com.example.guest.weather.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guest.weather.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.showForecastButton) Button mShowForecastButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mShowForecastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Show Forecast Clicked", Toast.LENGTH_LONG).show();
                String location = mLocationEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, ForecastListActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });
    }
}
