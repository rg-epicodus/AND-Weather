package com.example.guest.weather;

import android.support.test.rule.ActivityTestRule;

import com.example.guest.weather.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Guest on 10/17/17.
 */

public class MainActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateButton(){
        onView(withId(R.id.showForecastButto)).perform(click());
    }
}
