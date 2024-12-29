package com.hotelogix.smoke.admin.General;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.hotelogix.smoke.admin.BaseClass.AdmineHome;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class DefaultSettingLandingPage {


@FindBy(xpath="//tr[@id='checOutPolicyText']//td//a")
public static WebElement ChangeEarlyCheck;


@FindBy(xpath="//input[@id='earlyChkOutChrg']")
public static WebElement EarlyCheckoutCharge_Txtbox;

@FindBy(xpath="//div[@class='headingtxt']//td[2]")
public static WebElement pgeTitle;

@FindBy(xpath="//div[@id='_divnightAuditModeDom111']/a")
public static WebElement nightAudit_chngelnk;

@FindBy(xpath="//select[@id='nightAuditTimeHour']")
public static WebElement NAudit_hour;

@FindBy(xpath="//select[@id='nightAuditTimeMins']")
public static WebElement NAudit_min;

@FindBy(xpath="//select[@id='nightAuditTimeAMPM']")
public static WebElement NAudit_AMPM;

@FindBy(xpath="//select[@id='nightAuditCalendarDate']")
public static WebElement NAudit_CalDate;

@FindBy(xpath="//div[@id='divnightAuditMode']//input")
public static WebElement NAudit_okbtn;

@FindBy(xpath="//input[@class='disablethis button']")
public static WebElement save_btn;

@FindBy(xpath="//td[@class='error']")
public static WebElement Save_pgeMsg;

@FindBy(xpath="//div[@id='_divcheckInTimeDom1']/a")
public static WebElement Checkin_chngelnk;

@FindBy(xpath="//select[@id='checkInTimeHour']")
public static WebElement Chkin_hour;

@FindBy(xpath="//select[@id='checkInTimeMins']")
public static WebElement Chkin_min;

@FindBy(xpath="//select[@id='checkInTimeAMPM']")
public static WebElement  Chkin_AMPM;

@FindBy(xpath="//div[@id='divcheckInTime']//input")
public static WebElement Checkin_okbtn;

@FindBy(xpath="//div[@id='_divcheckOutTimeDom1']/a")
public static WebElement Checkout_chngelnk;

@FindBy(xpath="//select[@id='checkOutTimeHour']")
public static WebElement Chkout_hour;

@FindBy(xpath="//select[@id='checkOutTimeMins']")
public static WebElement Chkout_min;

@FindBy(xpath="//select[@id='checkOutTimeAMPM']")
public static WebElement Chkout_AMPM;

@FindBy(xpath="//div[@id='divcheckOutTime']//input")
public static WebElement Chkout_okbtn;

@FindBy(xpath="//tr[@id='checOutPolicyText']//a")
public static WebElement earlyChkout_chngelnk;

@FindBy(xpath="//input[@id='earlyChkOutTime']")
public static WebElement earlyChkOut_input;

@FindBy(xpath="//input[@name='earlyChkOutChrg']")
public static WebElement earlyChkout_Charge;

@FindBy(xpath="//input[contains(@onclick,'earlyChkOutTime')]")
public static WebElement earlyChkout_okbtn;

@FindBy(xpath="//td[@id='checOutPolicyTextShow']")
public static WebElement earlyChkoutPolicy;


public static String saveMsg="- Default Settings Saved Successfully";



public void SetChargeForEarlyCheckout(String charge) throws Exception
{
		GenericMethods.sendKeys(EarlyCheckoutCharge_Txtbox, charge);



}

public static void verify_pgeTitle() throws InterruptedException
{
	   String txt=GenericMethods.getText(pgeTitle);
	  try{
	   if(txt.equals("Defaults Settings")){
		   AdmineHome.bResult=true;
		   Reporter.log("Default Settings page title is verified",true);
	   }else{
		 AdmineHome.bResult=false;

	   }
	   }
	  catch(Exception e){
		   if(AdmineHome.bResult=false){
			   Reporter.log("Please check on with Default Settings page title",true);
		   }


	   }

	   //Assert.assertEquals(txt, "Defaults Settings");
}

public  void change_nightAudit() throws Exception
{
	try
	{
	   GenericMethods.clickElement(nightAudit_chngelnk);
	   GenericMethods.selectElement(NAudit_hour, "02");
	   GenericMethods.selectElement(NAudit_min, "00");
	   GenericMethods.selectElement(NAudit_AMPM, "AM");
	   GenericMethods.selectElement(NAudit_CalDate, "Next Calendar Date");
	   GenericMethods.clickElement(NAudit_okbtn);
	 //  GenericMethods.clickElement(save_btn);
	}
	catch(Exception e)
	{
		throw e;
	}
}

public  void verify_pgeMsg() throws Exception
{
	try
	{
	   String msg=GenericMethods.getText(Save_pgeMsg);
	   Assert.assertEquals(msg, saveMsg);
	}
	catch(AssertionError e)
	{
		throw e;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public  void change_checkinTime() throws Exception
{
	try
	{
	   GenericMethods.clickElement(Checkin_chngelnk);
	   GenericMethods.selectElement(Chkin_hour, "12");
	   GenericMethods.selectElement(Chkin_min, "00");
	   GenericMethods.selectElement(Chkin_AMPM, "AM");
	   GenericMethods.clickElement(Checkin_okbtn);
	  // GenericMethods.clickElement(save_btn);
	}
	catch(Exception e)
	{
		throw e;
	}
}

public  void change_checkoutTime() throws Exception
{
	try
	{
	   GenericMethods.clickElement(Checkout_chngelnk);
	   GenericMethods.selectElement(Chkout_hour, "12");
	   GenericMethods.selectElement(Chkout_min, "00");
	   GenericMethods.selectElement(Chkout_AMPM, "PM");
	   GenericMethods.clickElement(Chkout_okbtn);
	   //GenericMethods.clickElement(save_btn);
	}
	catch(Exception e)
	{
		throw e;
	}
}

public static String i="3.00";
public void change_earlyCheckoutCharge() throws Exception
{
	   GenericMethods.clickElement(earlyChkout_chngelnk);
	   Actions acobj= new Actions(GenericMethods.driver);
	   acobj.sendKeys(earlyChkout_Charge, Keys.chord(Keys.CONTROL, "a"), i).build().perform() ;
	   GenericMethods.clickElement(earlyChkout_okbtn);
	   GenericMethods.clickElement(save_btn);


}


public void fn_verifyEarlyChkoutCharge() throws InterruptedException
{
	   String text=GenericMethods.getText(earlyChkoutPolicy);
	   Assert.assertTrue(text.contains(i));
}





}
