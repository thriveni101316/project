package com.objectrepository;

import org.openqa.selenium.By;

public class Locators {

	public final By JRI_HomePage_Sigin_Link = By.id("jriTop_signin9");
	public final By JRI_HomePage_CreateAnAccount_Link = By.id("signup-link9");
	public final By JRI_HomePage_Name_EditBox = By.name("signup_name");
	public final By JRI_HomePage_Mobile_EditBox = By.id("signup_mobileno");
	public final By JRI_HomePage_Email_EditBox = By.id("signup_email");
	public final By JRI_HomePage_Password_EditBox = By.id("signup_password");
	public final By JRI_HomePage_Newsletters_CheckBox = By.id("checkbox1");
	public final By JRI_HomePage_Terms_CheckBox = By.id("checkbox");
	public final By JRI_HomePage_CreateAccount_Button = By.id("imgbtnSubmit");

	
	//Invalid error messages
	public final By JRI_HomePage_Mobile_ErroeMsg = By.id("lblpopMobileErrorMsg");
	
	//SignIn
	public final By JRI_SignIn_Email_Editbox = By.name("txtUserName");
	public final By JRI_SignIn_Password_Editbox = By.name("txtPasswd");
	public final By JRI_SignIn_SecureSignIN_Button = By.name("imgbtnSignin");
	
	//SignOut
	public final By JRI_SignOut_Signout_button = By.id("jriTop_signOut");
	
	
	//MobileDirectory
	public final By JRI_Directory_AddMobileNumber_Button = By.className("addMobileLink");
	public final By JRI_Directory_Add_Button = By.id("btnPopupAddMobile");
	public final By JRI_Directory_MobileNo_Editbox = By.id("txtpopMobileNo");
	public final By JRI_Directory_ServiceProvider_Dropdown = By.id("ddlpopMobileSP");
	public final By JRI_Directory_NickName_Dropdown = By.id("txtpopMobileNickname");
	public final By JRI_Directory_Location_Dropdown = By.id("ddlpopMobileLocation");
	public final By JRI_Directory_Cancel_EditBox = By.xpath("//input[@id=\"img1\"]");
	public final By JRI_Directory_ErrorMsg_Dropdown = By.id("lblpopMobileErrorMsg");
	public final By JRI_Directory = By.cssSelector("img[title='Directory']");
	public final By JRI_Directory_Cancel = By.id("img1");



}
