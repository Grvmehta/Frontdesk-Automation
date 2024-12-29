package com.hotelogix.smoke.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole.WebGuestConsoleLandingPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class WebGuestConsoleLoginPage {


@FindBy(xpath="//input[@id='txtGuestId']")
public static WebElement GuestIdTextField;

@FindBy(xpath="//input[@id='txtUsername']")
public static WebElement UserMailTextField;

@FindBy(xpath="//input[@id='txtPass']")
public static WebElement PasswordField;

@FindBy(xpath="//input[@value='Login']")
public static WebElement LoginBtn;

public WebGuestConsoleLandingPage DoLogin(String id,String user,String pwd) throws Exception{

	System.out.println(GuestIdTextField.isEnabled());
	System.out.println(GuestIdTextField.isDisplayed());
GenericMethods.sendKeys(GuestIdTextField, id);
GenericMethods.sendKeys(UserMailTextField, user);
GenericMethods.sendKeys(PasswordField, pwd);
GenericMethods.clickElement(LoginBtn);
WebGuestConsoleLandingPage WGC=PageFactory.initElements(GenericMethods.driver,WebGuestConsoleLandingPage.class );
return WGC;
}






}
