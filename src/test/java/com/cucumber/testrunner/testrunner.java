package com.cucumber.testrunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;
import com.cucumber.listener.Reporter;

import BassClass.BaseClass;
import Helper.ConfigReader;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"com.cucumber.listener.ExtentCucumberFormatter:src\\test\\resource\\com\\cucumber\\reoprts\\ExtentReport\\extent.html"
		//		,"json:src\\test\\resource\\com\\cucumber\\reports\\report.json"
		//		,"junit:src\\test\\resource\\com\\cucumber\\reports"
		//		,"html:src\\test\\resource\\com\\cucumber\\reports"
				} 
		
		,features="src\\test\\java\\com\\cucumber\\feature",glue="com.cucumber.stepdefinition"
	,monochrome=true
	,tags= {"@TC_117"}
//	,dryRun=false,strict=true
				)
public class TestRunner extends BaseClass {
	
@BeforeClass
public static void browserLaunch() throws Exception {
	ConfigReader cr=new ConfigReader();
	browser(cr.getBrowserName());
	
}
@AfterClass
public static void quit() {
	driverQuit();
	Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resource\\com\\cucumber\\prop\\extent-config.xml"));
}
}
