package com.hotelogix.smoke.frontdesk.FrontdeskHome;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class NightAuditLandingPage
{

   @FindBy(xpath="//input[@value='Continue Night Audit']")
   public static WebElement contNightaudit;

   @FindBy(xpath="//input[@name='ExitToFDNsBtn']")
   public static WebElement abandonNA;

   @FindBy(xpath="//input[@value='Abandon & Return To Frontdesk']")
	public static WebElement AbandonAndReturnToFrontdesk_BT;

	public void fn_ValidateTitle() throws Exception
	{

   	 try
   	 {
   	  String str= GenericMethods.driver.getTitle();
       Assert.assertEquals(str, "Night Audit");
   	 }
   	 catch(Exception e)
   	 {
   		 throw e;
   	 }

	}




	public FrontdeskLandingPage fn_ContinueNightAudit() throws Exception
	{
		String str= GenericMethods.driver.getTitle();
	    Assert.assertEquals(str, "Night Audit");
		GenericMethods.clickElement(abandonNA);
		FrontdeskLandingPage FLP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
		return FLP;
	}


	public FrontdeskLandingPage fn_ClickAbandonAndReturnToFrontdesk_BT() throws Exception{

	   	 try{
	   		GenericMethods.js_Click(AbandonAndReturnToFrontdesk_BT);

	   	 }catch(NoSuchElementException e){
	   		GenericMethods.js_Click(AbandonAndReturnToFrontdesk_BT);
	   	   	// GenericMethods.clickElement(AbandonAndReturnToFrontdesk_BT);

	   	 } catch(Exception e){
	   		 e.printStackTrace();
	   	 }
	   	 FrontdeskLandingPage FLP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
		return FLP;
	        }

}
