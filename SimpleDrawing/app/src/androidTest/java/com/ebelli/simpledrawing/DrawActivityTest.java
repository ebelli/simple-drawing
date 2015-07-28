package com.ebelli.simpledrawing;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuku.ambilwarna.AmbilWarnaDialog;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
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
    }

    @Test
    public void testActionBarShowColorPicker(){
        onView(withId(R.id.action_colorpicker)).perform(click());
        allOf(isDisplayed(), is(instanceOf(AmbilWarnaDialog.class)));

    }

    @Test
    public void testSetColor(){
        }

}
