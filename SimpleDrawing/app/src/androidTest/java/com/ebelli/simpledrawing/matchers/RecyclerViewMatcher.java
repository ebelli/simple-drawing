package com.ebelli.simpledrawing.matchers;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by ebelli on 30/09/15.
 */
public class RecyclerViewMatcher {
    private final int recyclerViewId;


    public RecyclerViewMatcher(int recyclerViewId) {
        this.recyclerViewId = recyclerViewId;
    }

    public Matcher<View> atPosition(final int position) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {

            }

            @Override
            protected boolean matchesSafely(View view) {
                RecyclerView recyclerView =
                        (RecyclerView) view.getRootView().findViewById(recyclerViewId);
                if (recyclerView != null && recyclerView.getId() == recyclerViewId) {
                    return  (recyclerView.getChildAt(position) == view);
                } else {
                    return false;
                }
            }
        };
    }
}
