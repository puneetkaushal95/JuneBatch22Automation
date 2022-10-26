package com.envision.automation.framework.core;

import com.envision.automation.framework.utils.ConfigLoader;
import com.envision.automation.framework.utils.ExtentManager;
import com.envision.automation.framework.utils.ExtentTestManager;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {

    public static WebDriver driver;

    //@BeforeSuite
    public void loadConfigurations() throws IOException {
        ConfigLoader.loadConfigurations();
        ExtentManager.getReporter();
    }

   // @BeforeMethod
    public void loadBrowser(Method methodName){
        ExtentTestManager.startTest(methodName.getName(),"");
        this.driver = BasePage.launchBrowser(ConfigLoader.getBrowserType());
    }

    //@AfterMethod
    public void tearDownBrowser(){
        BasePage.closeBrowser();
        ExtentTestManager.stopTest();
    }

    //@AfterSuite
    public void tearDownConfigurations(){
        driver = null;
        ExtentManager.getReporter().flush();
        ExtentManager.getReporter().close();
    }
}

