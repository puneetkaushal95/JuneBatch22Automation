package com.envision.automation.pages;

import com.envision.automation.framework.core.BasePage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPage extends BasePage {

    WebDriver driver;
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public LoginPage enterUsername(String emailId) throws IOException, InterruptedException {
        typeInto("LoginPage.tbxEmailAddress", emailId);
        return this;
    }

    public LoginPage enterPassword(String password) throws IOException, InterruptedException {
        typeInto("LoginPage.tbxPassword", password);
        return this;
    }

    public HomePage clickOnSignIn() throws IOException {
        clickOn("LoginPage.btnSignIn");
        return new HomePage(driver);
    }
}
