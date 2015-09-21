package com.ebelli.simpledrawing.matchers;

import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;

import com.ebelli.simpledrawing.DrawView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/**
 * Created by ebelli on 20/09/15.
 */
public class BackgroundColorMatchers {


    @NonNull
    public static Matcher<View> withBackGroundColor(final int color) {
        return withBackGroundColor(Matchers.is(color));
    }

    public static Matcher<View> withBackGroundColor(final Matcher<Integer> matcherColor) {
        return new BoundedMatcher<View,DrawView>(DrawView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("background color");

            }

            @Override
            public boolean matchesSafely(final DrawView drawView) {
                ColorDrawable color = (ColorDrawable)drawView.getBackground();
                return matcherColor.matches(color.getColor());
            }
        };

    }

}
