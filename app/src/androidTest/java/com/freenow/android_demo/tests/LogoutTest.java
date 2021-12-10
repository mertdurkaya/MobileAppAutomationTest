package com.freenow.android_demo.tests;

import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;

import com.freenow.android_demo.activities.MainActivity;
import com.freenow.android_demo.pages.HomePage;
import com.freenow.android_demo.pages.LoginPage;
import com.freenow.android_demo.resources.Data;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class LogoutTest{

    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    @Before
    public void setUp(){
        loginPage.typeUserName(Data.userName);
        loginPage.typePassword(Data.password);
        loginPage.clickLogin();
        SystemClock.sleep(2000);
    }

    @Test
    public void logoutAlreadyLoggedIn() {
        homePage.openDrawer();
        homePage.clickLogout();
    }

}
