package com.hotelogix.smoke.admin.WebManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.hotelogix.smoke.admin.WebTravelAgent.WebReservationHomePageTA;
import com.hotelogix.smoke.frontdesk.WebReservation.WebReservationHomePage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class WebReservationSettingPage {

	public static String msg;



	@FindBy(xpath="//td[@class='error']")
	public static WebElement txt_msg;

	@FindBy(xpath="//input[@name='bookByCC']")
	public static WebElement CreditCard_CheckBox;


	@FindBy(xpath="  //input[@name='btnSave']")
	public static WebElement Save_Btn;

	@FindBy(xpath="//td[@class='padingtd']//tbody//tr[10]//textarea")
	public static WebElement secureCanvasURL;

public void VerifyPagetitle(){

	String title=GenericMethods.driver.getTitle();
	if(title.contains("Web Reservation Settings"))	{
		System.out.println(title + " page appearing");
	}else System.out.println("Page not there");
}


public String VerifySavedSettings() throws Exception{

	try
	{
		if(CreditCard_CheckBox.isSelected()==false)
		{
	      GenericMethods.clickElement(CreditCard_CheckBox);
	       Thread.sleep(2000);
		}
	       GenericMethods.clickElement(Save_Btn);
	       msg=GenericMethods.getText(txt_msg);
           return msg;
	} 
	catch(Exception e)
	{
		throw e;
	}
}


public static String ParentID;
public  WebReservationHomePage launchSecureCanvasURL() throws Exception
{
	try
	{
	ParentID= GenericMethods.GetCurrentWindowID();
	String URL= GenericMethods.getText(secureCanvasURL);
	GenericMethods.driver.navigate().to(URL);
	
	WebReservationHomePage pageobj=PageFactory.initElements(GenericMethods.driver, WebReservationHomePage.class);
    return pageobj;
	}
	catch(Exception e)
	{
		throw e;
	}
}

//public static WebReservationHomePageTA launchSecureCanvasURLTA() throws Exception
//{
//	ParentID= GenericMethods.GetCurrentWindowID();
//	String URL= GenericMethods.getText(secureCanvasURL);
//	GenericMethods.driver.navigate().to(URL);
//	//GenericMethods.fn_OpenAdmin("FF", URL);
//	//GenericMethods.windowHandle(ParentID);
//	WebReservationHomePageTA WRTA=PageFactory.initElements(GenericMethods.driver, WebReservationHomePageTA.class);
//    return WRTA;
//}



}
