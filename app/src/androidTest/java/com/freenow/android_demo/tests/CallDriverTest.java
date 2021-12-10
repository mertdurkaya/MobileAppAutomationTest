package com.freenow.android_demo.tests;

import android.content.Intent;
import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;

import com.freenow.android_demo.activities.MainActivity;
import com.freenow.android_demo.pages.DriverProfilePage;
import com.freenow.android_demo.pages.HomePage;
import com.freenow.android_demo.pages.LoginPage;
import com.freenow.android_demo.resources.Data;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class CallDriverTest {

    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();
    private final DriverProfilePage driverProfile = new DriverProfilePage();

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    @Before
    public void setUp(){

    }

    @Test
    public void lLogInAndCallDriverSuccessfully() {
        loginPage.typeUserName(Data.userName);
        loginPage.typePassword(Data.password);
        loginPage.clickLogin();
        SystemClock.sleep(2000);
        homePage.searchDriverByName(Data.searchText);
        homePage.selectDriver(Data.driverName);
        driverProfile.clickCallButton();
        SystemClock.sleep(2000);
        Intent intent = new Intent();
        mActivityTestRule.launchActivity(intent);
        SystemClock.sleep(2000);

    }

    @After
    public void tearDown(){
        homePage.openDrawer();
        homePage.clickLogout();
    }
}
