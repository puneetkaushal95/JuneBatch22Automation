package com.envision.automation.framework.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.get;

public class ExtentTestManager {

    static ExtentReports report = ExtentManager.getReporter();
//    static ThreadLocal<Extent Test> extent_Test = new ThreadLocal<ExtentTest>();
    static ThreadLocal<Integer> testId = new ThreadLocal<Integer>();
    static Map<Integer, ExtentTest> testMap = new HashMap<Integer, ExtentTest>();

    public synchronized static ExtentTest getTest(){
        return (ExtentTest) testMap.get((int)(long) Thread.currentThread().getId());
    }

    public synchronized static ExtentTest startTest(String testName, String description){
        ExtentTest test = report.startTest(testName);
//        extent_Test.set(test);
//        testMap.put((int)(long) Thread.currentThread().getId(),extent_Test.get());
        return test;
    }

    public synchronized static void stopTest(){
        report.endTest((ExtentTest) testMap.get((int) (long) Thread.currentThread().getId()));
    }
}
