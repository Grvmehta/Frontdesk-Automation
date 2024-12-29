package com.hotelogix.smoke.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.hotelogix.anonymousTest.generalTest;
import com.hotelogix.smoke.emailaccount.EmailHomePage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class EmailAccountLoginPage {



	@FindBy(xpath="//input[@id='cred_userid_inputtext']")
	public static WebElement UserMailId;

	@FindBy(xpath="//input[@id='cred_password_inputtext']")
	public static WebElement Password;

	@FindBy(xpath="//span[@id='cred_sign_in_button']")
	public static WebElement SignInBtn;


	@FindBy(xpath="//input[@name='login_username']")
	public static WebElement UserName;

	@FindBy(xpath="//input[@name='secretkey']")
	public static WebElement PasswdField;


	@FindBy(xpath="//input[@value='Login']")
	public static WebElement Login;









	public EmailHomePage DoLogin() throws Exception{


		GenericMethods.sendKeys(UserMailId, "deepak.thayat@hotelogix.com");
		GenericMethods.sendKeys(Password, "Tuya0015");
		System.out.println(SignInBtn.isEnabled());
		System.out.println(SignInBtn.isDisplayed());
		Actions a=new Actions(GenericMethods.driver);
		a.click(SignInBtn);
		Thread.sleep(2000);
		GenericMethods.js_Click(GenericMethods.driver.findElement(By.xpath("//span[text()='Sign in']")));
		Thread.sleep(2000);
		GenericMethods.js_Click(GenericMethods.driver.findElement(By.xpath("//span[text()='Sign in']")));
		Thread.sleep(2000);
		EmailHomePage EHP=PageFactory.initElements(GenericMethods.driver, EmailHomePage.class);
		return EHP;
	}

	public EmailHomePage DoSquirrelMailLogin() throws Exception
	{
		try
		{
		GenericMethods.sendKeys(UserName, "rajiv");
		GenericMethods.sendKeys(PasswdField, "rajivt");
		GenericMethods.clickElement(Login);
		EmailHomePage EHP=PageFactory.initElements(GenericMethods.driver, EmailHomePage.class);
		return EHP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}
