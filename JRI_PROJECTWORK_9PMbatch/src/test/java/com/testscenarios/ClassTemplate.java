package com.testscenarios;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.objectrepository.Locators;
import com.utilities.WrapperClass;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class ClassTemplate extends WrapperClass {
	
	Locators loc = new Locators();
	int count = 0;

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

//	@AfterMethod
//	public void afterMethod() throws Exception {
//		takeScreenshot();
//	}

	@AfterClass
	public void afterMethod() {
		driver.close();
	}

	@Test
	public void TC_019_OpenJRIWebsite() throws Exception {
		//loaddata("./src/test/resources/testdata/inputdata.properties");
		// Develop the code form here
		loaddata(System.getProperty("user.dir")+"//src//test//resources//testdata//inputdata.properties");
		String browserName=getdata("JRI_HomePage_URL");
		driver.get(browserName);
		String currentUrl = driver.getCurrentUrl();
		assertEquals(browserName, currentUrl);
	}
	@Test
	public void TC_020_Mobileservices_BlankData() throws Exception
	{
		//TC_019_OpenJRIWebsite();
		loaddata(System.getProperty("user.dir")+"//src//test//resources//testdata//inputdata.properties");
		String browserName=getdata("JRI_HomePage_URL");
		driver.get(browserName);
		clickByAnyLocator(loc.JRI_HomePage_Sigin_Link);
		sendkeysByAnyLocator(loc.JRI_SignIn_Email_Editbox, "thriveni6630@gmail.com");
		sendkeysByAnyLocator(loc.JRI_SignIn_Password_Editbox, "123456");
		Thread.sleep(6000);//Enter captcha
		clickByAnyLocator(loc.JRI_SignIn_SecureSignIN_Button);
		clickByAnyLocator(loc.JRI_Directory_AddMobileNumber_Button);
		clickByAnyLocator(loc.JRI_Directory_Add_Button);
		waitForElementToBeClickable(loc.JRI_SignOut_Signout_button, 3);
		clickByAnyLocator(loc.JRI_SignOut_Signout_button);
		assertByElementText(loc.JRI_HomePage_Mobile_ErroeMsg, "Enter mobile number");
		
	}
	@Test
	public void TC_021_Mobileservices_invalidData() throws Exception
	{
		//TC_019_OpenJRIWebsite();
		loaddata(System.getProperty("user.dir")+"//src//test//resources//testdata//inputdata.properties");
		String browserName=getdata("JRI_HomePage_URL");
		driver.get(browserName);
		clickByAnyLocator(loc.JRI_HomePage_Sigin_Link);
		sendkeysByAnyLocator(loc.JRI_SignIn_Email_Editbox, "thriveni6630@gmail.com");
		sendkeysByAnyLocator(loc.JRI_SignIn_Password_Editbox, "123456");
		Thread.sleep(6000);//Enter captcha
		clickByAnyLocator(loc.JRI_SignIn_SecureSignIN_Button);
		clickByAnyLocator(loc.JRI_Directory_AddMobileNumber_Button);
		sendkeysByAnyLocator(loc.JRI_Directory_MobileNo_Editbox, "1234567890");
		selectCustomiseOptionFromTheDropdownValues(loc.JRI_Directory_ServiceProvider_Dropdown, "AIRTEL");
		//Thread.sleep(3000);
		waitForElementVisible(loc.JRI_Directory_Location_Dropdown, 3);
		sendkeysByAnyLocator(loc.JRI_Directory_NickName_Dropdown, "invalid");
		selectCustomiseOptionFromTheDropdownValues(loc.JRI_Directory_Location_Dropdown, "Andhra Pradesh");
		clickByAnyLocator(loc.JRI_Directory_Add_Button);
		validateTheErrorMessage("Enter valid mobile number",loc.JRI_Directory_ErrorMsg_Dropdown);
		assertByElementText(loc.JRI_HomePage_Mobile_ErroeMsg, "Enter valid mobile number");
		waitForElementToBeClickable(loc.JRI_SignOut_Signout_button, 3);
		clickByAnyLocator(loc.JRI_SignOut_Signout_button);
		
	}
	@Test
	public void TC_022_Mobileservices_validData() throws Exception
	{
		//TC_019_OpenJRIWebsite();
		loaddata(System.getProperty("user.dir")+"//src//test//resources//testdata//inputdata.properties");
		String browserName=getdata("JRI_HomePage_URL");
		driver.get(browserName);
		clickByAnyLocator(loc.JRI_HomePage_Sigin_Link);
		sendkeysByAnyLocator(loc.JRI_SignIn_Email_Editbox, "thriveni6630@gmail.com");
		sendkeysByAnyLocator(loc.JRI_SignIn_Password_Editbox, "123456");
		Thread.sleep(6000);//Enter captcha
		clickByAnyLocator(loc.JRI_SignIn_SecureSignIN_Button);
		clickByAnyLocator(loc.JRI_Directory_AddMobileNumber_Button);
		sendkeysByAnyLocator(loc.JRI_Directory_MobileNo_Editbox, "9705891063");
		selectCustomiseOptionFromTheDropdownValues(loc.JRI_Directory_ServiceProvider_Dropdown, "VI");
		sendkeysByAnyLocator(loc.JRI_Directory_NickName_Dropdown, "Nanna");
		selectCustomiseOptionFromTheDropdownValues(loc.JRI_Directory_Location_Dropdown, "Andhra Pradesh");
		clickByAnyLocator(loc.JRI_Directory_Add_Button);
		Assertion assertion = new Assertion();
		assertion.assertNotEquals(loc.JRI_HomePage_Mobile_ErroeMsg, "Enter valid mobile number");
		waitForElementToBeClickable(loc.JRI_SignOut_Signout_button, 3);
		clickByAnyLocator(loc.JRI_SignOut_Signout_button);
		
		
	}
	@Test(dataProvider="getExcelData")
	public void TC_023_MobileNumberFunctionality(String mbleNo,String service,String name,String location) throws Exception
	{
		
		if(count<1)
		{
			loaddata(System.getProperty("user.dir")+"//src//test//resources//testdata//inputdata.properties");
			String browserName=getdata("JRI_HomePage_URL");
			driver.get(browserName);
			clickByAnyLocator(loc.JRI_HomePage_Sigin_Link);
			sendkeysByAnyLocator(loc.JRI_SignIn_Email_Editbox, "thriveni6630@gmail.com");
			sendkeysByAnyLocator(loc.JRI_SignIn_Password_Editbox, "123456");
			Thread.sleep(6000);//Enter captcha
			clickByAnyLocator(loc.JRI_SignIn_SecureSignIN_Button);
			count++;
		}
		clickByAnyLocator(loc.JRI_Directory_AddMobileNumber_Button);
		sendkeysByAnyLocator(loc.JRI_Directory_MobileNo_Editbox, mbleNo);
		selectCustomiseOptionFromTheDropdownValues(loc.JRI_Directory_ServiceProvider_Dropdown,service );
		//waitForElementVisible(loc.JRI_Directory_Location_Dropdown, 3);
		Thread.sleep(3000);
		sendkeysByAnyLocator(loc.JRI_Directory_NickName_Dropdown, name);
		selectCustomiseOptionFromTheDropdownValues(loc.JRI_Directory_Location_Dropdown, location);
		clickByAnyLocator(loc.JRI_Directory_Add_Button);
		Thread.sleep(3000);
		
		if(getTheElementTextUsingAnyLocator(loc.JRI_HomePage_Mobile_ErroeMsg).equalsIgnoreCase("Mobile number already exists"))
		{
			clickByAnyLocator(loc.JRI_Directory_Cancel);
		}
		if(getTheElementTextUsingAnyLocator(loc.JRI_HomePage_Mobile_ErroeMsg).equalsIgnoreCase("You can not add more than 10 mobile numbers to your account"))
		{
			assertByElementText(loc.JRI_HomePage_Mobile_ErroeMsg, "You can not add more than 10 mobile numbers to your account");
		}
			
		
		
	}
	
	@DataProvider
	public String[][] getExcelData() throws IOException
	{
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\JRI_TestCases_9PMbatch_ProjectWorkAssignment.xlsx";
		FileInputStream fis = new FileInputStream(path);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(3);
		int sheetCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(1).getLastCellNum();
		String loginData[][] = new String[sheetCount][cellCount];
		for(int i=1;i<=sheetCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				loginData[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return loginData;
	}
}
