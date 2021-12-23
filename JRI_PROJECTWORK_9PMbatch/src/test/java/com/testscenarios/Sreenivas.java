package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.WrapperClass;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

public class Sreenivas extends WrapperClass {

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("edge")) {
			edgeBrowserLaunch();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			firefoxBrowserLaunch();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			chromeBrowserLaunch();
		} else {
			System.out.println("Please check the browser name****");
		}
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		takeScreenshot();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void tc_001_Invoke_the_JRI_Home_page() throws Exception {
		loaddata("./src/test/resources/testdata/inputdata.properties");

		// Develop the code form here

	}

}
