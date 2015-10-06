package com.ebelli.simpledrawing;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.ebelli.simpledrawing.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;

/**
 * Created by ebelli on 18/06/15.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testViews(){
        onView(withId(R.id.fabNew)).check(matches(isDisplayed()));
        onView(withId(R.id.rvDrawings)).check(matches(isDisplayed()));
    }

    @Test
    public void testCreateDeletDrawing(){
        onView(withId(R.id.fabNew)).perform(click());
        onView(withId(R.id.action_save)).perform(click());
//        onData(anything()).inAdapterView(withId(R.id.rvDrawings)).atPosition(0).check(matches(isDisplayed()));
        onView(withId(R.id.rvDrawings)).perform(RecyclerViewActions.actionOnItemAtPosition(0, longClick()));
        onView(withId(android.R.id.button1)).perform(click());
    }

    @Test
    public void testShowDeleteIcon(){
        onView(withId(R.id.fabNew)).perform(click());
        onView(withId(R.id.action_save)).perform(click());
        onView(withId(R.id.rvDrawings)).perform(RecyclerViewActions.actionOnItemAtPosition(0, longClick()));
        onView(withId(R.id.action_delete)).check(matches(isDisplayed()));
    }

}
