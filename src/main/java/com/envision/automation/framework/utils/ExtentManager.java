package com.envision.automation.framework.utils;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports suiteReport;

    public static synchronized ExtentReports getReporter(){
        try{
            if (suiteReport == null){
                String extentReportPath = System.getProperty("user.dir")+"/src/test/resources/extentReports";
                File f = new File(extentReportPath);
                if (!f.isDirectory()){
                    f.mkdirs();
                }
                suiteReport = new ExtentReports(extentReportPath + "//TestResults-" + new SimpleDateFormat("dd.MM.yyyy.hh.mm.ss").format(new Date()) + ".html");
            }
        }catch (Exception e){

        }
        return suiteReport;
    }
}
