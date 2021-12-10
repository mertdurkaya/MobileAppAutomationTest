package com.freenow.android_demo.pages;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.RootMatchers;

import com.freenow.android_demo.R;

public class HomePage extends BasePage{

    public void searchDriverByName(String searchText) {
        ViewInteraction edtSearch = onView(
                allOf(withId(R.id.textSearch),
                        childAtPosition(
                                allOf(withId(R.id.searchContainer),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                                1)),
                                0)));
        edtSearch.perform(typeText(searchText))
        .perform(closeSoftKeyboard());
    }


    public void selectDriver(String driverName) {
        onView(withText(driverName))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }

    public void openDrawer(){
        ViewInteraction btnDrawer = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.AppBarLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        btnDrawer.perform(click());

    }

    public void clickLogout() {

        ViewInteraction btnLogout = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        1),
                        isDisplayed()));
        btnLogout.perform(click());
    }
}
