package com.freenow.android_demo.pages;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.support.test.espresso.ViewInteraction;

import com.freenow.android_demo.R;

public class LoginPage extends BasePage{

    public void typeUserName(String userName) {
        ViewInteraction edtUsername = onView(
                allOf(withId(R.id.edt_username),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.TextInputLayout")),
                                        0), 0)));
        edtUsername.perform(typeText(userName), closeSoftKeyboard());
    }

    public void typePassword(String password) {
        ViewInteraction edtPassword = onView(
                allOf(withId(R.id.edt_password),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.TextInputLayout")),
                                        0),
                                0)));

        edtPassword.perform(typeText(password), closeSoftKeyboard());
    }

    public void clickLogin() {
        ViewInteraction btnLogin = onView(
                allOf(withId(R.id.btn_login), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2)));

        btnLogin.perform(click());
    }
}
