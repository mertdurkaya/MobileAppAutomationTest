package com.freenow.android_demo.tests;

import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;

import com.freenow.android_demo.activities.MainActivity;
import com.freenow.android_demo.pages.HomePage;
import com.freenow.android_demo.pages.LoginPage;
import com.freenow.android_demo.resources.Data;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;

public class LoginTest {

    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    @Test
    public void loginTest() {
        loginPage.typeUserName(Data.userName);
        loginPage.typePassword(Data.password);
        loginPage.clickLogin();
        SystemClock.sleep(2000);
    }

    @After
    public void tearDown(){
        homePage.openDrawer();
        homePage.clickLogout();
    }
}
