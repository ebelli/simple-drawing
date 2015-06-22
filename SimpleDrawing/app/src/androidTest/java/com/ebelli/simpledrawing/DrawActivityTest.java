package com.ebelli.simpledrawing;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by ebelli on 22/06/15.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class DrawActivityTest {

    @Rule
    public ActivityTestRule<DrawActivity> mActivityRule = new ActivityTestRule<>(
            DrawActivity.class);

    @Test
    public void testViews(){
        onView(withId(R.id.drawView)).check(matches(isDisplayed()));
    }

}
