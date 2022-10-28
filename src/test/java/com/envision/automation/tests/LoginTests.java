package com.envision.automation.tests;

import com.envision.automation.framework.core.BaseTest;
import com.envision.automation.framework.utils.DataGenerator;
import com.envision.automation.pages.HomePage;
import com.envision.automation.pages.LandingPage;
import com.envision.automation.pages.LoginPage;
import org.json.simple.JSONObject;
import org.junit.Test;


import javax.xml.crypto.Data;
import java.io.IOException;

public class LoginTests extends BaseTest {

    @Test
    public void validateSuccessfulLoginToApplication() throws IOException, InterruptedException {
        JSONObject loginData = jsonUtils.getJSONObject(jsonUtils.mainJsonObj, "loginData");
        String username = jsonUtils.getJsonObjectValue(loginData, "username");
        String password = jsonUtils.getJsonObjectValue(loginData, "password");
        String loginName = jsonUtils.getJsonObjectValue(loginData, "loginName");

        LandingPage landingPage = new LandingPage(driver );
        LoginPage loginPage = landingPage
                .launchAutomationPractiseApplication()
                .clickOnSignIn();

        HomePage homePage = loginPage
                .enterUsername(username)
                .enterPassword(password)
                .clickOnSignIn();

        homePage
                .checkIfSignOutDisplayed()
                .checkIfUsernameLoggedInIsValid(loginName);
    }

    @Test
    public void validateSuccessfulLoginUsingRandomData() throws IOException, InterruptedException {
        System.out.println(DataGenerator.getUsername() + "=" + DataGenerator.getPassword() + "=" + DataGenerator.getLoginName());
        LandingPage landingPage = new LandingPage(driver );
        LoginPage loginPage = landingPage
                .launchAutomationPractiseApplication()
                .clickOnSignIn();

        HomePage homePage = loginPage
                .enterUsername(DataGenerator.getUsername())
                .enterPassword(DataGenerator.getPassword())
                .clickOnSignIn();

        homePage
                .checkIfSignOutDisplayed()
                .checkIfUsernameLoggedInIsValid(DataGenerator.getLoginName());
    }
}
