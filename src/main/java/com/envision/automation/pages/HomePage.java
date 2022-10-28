package com.envision.automation.pages;

import com.envision.automation.framework.core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
//import org.testng.Assert;

import java.io.IOException;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    public HomePage checkIfSignOutDisplayed() throws IOException {
        boolean status = isDisplayed("HomePage.lnkSignOut");
        Assert.assertTrue("Element Sign Out not displayed", status);
        return this;
    }

    public String getUsernameLoggedIn() throws IOException {
        String name = getWebElementText("HomePage.lnkUserLoggedIn");
        return name;
    }

    public HomePage checkIfUsernameLoggedInIsValid(String severus_snape) throws IOException {
        long[] userLoggedIn = new long[0];
        Assert.assertEquals(userLoggedIn, getUsernameLoggedIn());
        return this;
    }
}
