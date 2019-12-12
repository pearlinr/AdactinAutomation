package com.cucumber.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Script {

	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;

	@BeforeClass
	public void launch() throws IOException {
		htmlreporter = new ExtentHtmlReporter("C:\\Users\\admin\\eclipse-workspace2\\Adactin\\reports\\extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		test = extent.createTest("Home Page");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\resources\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		if (driver.getCurrentUrl().contains("facebook")) {
			test.log(Status.PASS, "URL Correct");
		} else {
			test.log(Status.FAIL, test.addScreenCaptureFromPath(screenshot()) + "URL Wrong");
		}
		
		if (driver.getTitle().contains("facebook")) {
			test.log(Status.PASS, "Title Correct");
		} else {
			test.log(Status.FAIL, test.addScreenCaptureFromPath(screenshot()) + "Title Wrong");
		}
	}
	
	@Test
	public void action() throws IOException {
		WebElement e = driver.findElement(By.name("email"));
		e.sendKeys("Kalaivani");
		if (e.getAttribute("value").equals("KalaiVani")) {
			test.log(Status.PASS, "Email Correct");
		} else {
			test.log(Status.FAIL, test.addScreenCaptureFromPath(screenshot()) + "Email Wrong");
		}
	}

	@AfterClass
	public void close() {
		driver.quit();
		extent.flush();
	}
	
	public static String screenshot() throws IOException {
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dec = new File("C:\\Users\\admin\\eclipse-workspace2\\Adactin\\Image\\Error Image"
				+ System.currentTimeMillis() + ".png");
		FileUtils.copyFile(src, dec);
		String path = dec.getAbsolutePath();
		return path;
	}
}
