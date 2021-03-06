package com.ebelli.simpledrawing;

import android.graphics.Color;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.ebelli.simpledrawing.view.DrawActivity;
import com.ebelli.simpledrawing.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuku.ambilwarna.AmbilWarnaDialog;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.ebelli.simpledrawing.matchers.BackgroundColorMatchers.withBackGroundColor;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;

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

    @Test
    public void testActionBarMenu(){
        onView(withId(R.id.action_colorpicker)).check(matches(isDisplayed()));
        onView(withId(R.id.action_save)).check(matches(isDisplayed()));
        onView(withId(R.id.action_clear)).check(matches(isDisplayed()));
        onView(withId(R.id.action_fill)).check(matches(isDisplayed()));
    }

    @Test
    public void testActionBarShowColorPicker(){
        onView(withId(R.id.action_colorpicker)).perform(click());
        allOf(isDisplayed(), is(instanceOf(AmbilWarnaDialog.class)));

    }

    @Test
    public void testSetBackgroundColor(){
        onView(withId(R.id.drawView)).check(matches(withBackGroundColor(Color.WHITE)));
        onView(withId(R.id.action_fill)).perform(click());
        onView(withId(R.id.drawView)).check(matches(withBackGroundColor(Color.BLACK)));
    }

    @Test
    public void testSaveDrawing(){
        onView(withId(R.id.drawView)).perform(scrollTo());
        onView(withId(R.id.action_save)).perform(click());
        allOf(isDisplayed(), is(instanceOf(MainActivity.class)));
    }
}
