package com.hotelogix.smoke.admin.WebTravelAgent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.frontdesk.WebReservation.WebReservationHomePage;
import com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole.WebGuestConsoleLandingPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class TravleAgent_LoginPage {
	@FindBy(xpath="//td[@class='title']")
	public static WebElement txt_header;

	@FindBy(xpath="//label/input[@id='txtCode']")
	public static WebElement loginId_txt;

	@FindBy(xpath="//label/input[@id='txtUsername']")
	public static WebElement emailAddress_txt;

	@FindBy(xpath="//td/input[@id='txtPass']")
	public static WebElement password_txt;

	@FindBy(xpath="//td/input[@name='rememberOnMac']")
	public static WebElement rememver_CB;

	@FindBy(xpath="//td/input[@value='Login']")
	public static WebElement login_BT;

	public  String verify_pageHeader() throws Exception
	{
		try
		{
		String txt=GenericMethods.getText(txt_header);
		return txt;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public static WebReservationHomePage login_TA() throws Exception{
		GenericMethods.sendKeys(loginId_txt, "21143");
		GenericMethods.sendKeys(emailAddress_txt, "brkhkapoor@gmail.com");
		GenericMethods.sendKeys(password_txt, "111111");
		GenericMethods.clickElement(login_BT);

		WebReservationHomePage pageobj = PageFactory.initElements(GenericMethods.driver, WebReservationHomePage.class);
		return pageobj;
	}
	
	
	public TAReservationHomePage DoLogin(String id,String user,String pwd) throws Exception{

		try
		{
		//System.out.println(loginId_txt.isEnabled());
		//System.out.println(loginId_txt.isDisplayed());
	   GenericMethods.sendKeys(loginId_txt, id);
	   GenericMethods.sendKeys(emailAddress_txt, user);
	   GenericMethods.sendKeys(password_txt, pwd);
	   GenericMethods.clickElement(login_BT);
	   TAReservationHomePage TARP=PageFactory.initElements(GenericMethods.driver,TAReservationHomePage.class );
	   return TARP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}
