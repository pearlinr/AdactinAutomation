package com.cucumber.stepdefinition;

import java.io.File;
import java.io.IOException;

import com.cucumber.listener.Reporter;

import BassClass.BaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
@Before
public void beforehook() {
	
}
@After
public void afterhook(Scenario s) throws Exception  {
	if (s.isFailed()) {
		File takesScreenShot = BaseClass.takesScreenShot(s.getName());
		Reporter.addScreenCaptureFromPath(takesScreenShot.getAbsolutePath());
	}
}
}
