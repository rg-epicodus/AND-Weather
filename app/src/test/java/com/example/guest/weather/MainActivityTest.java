package com.example.guest.weather;

import android.os.Build;
import android.widget.TextView;

import com.example.guest.weather.ui.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertTrue;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateTextViewContent() {
        TextView mAppNameTextView = (TextView) activity.findViewById(R.id.appNameTextView);
        assertTrue("PlayedThat".equals(mAppNameTextView.getText().toString()));
    }
}
