package com.hotelogix.smoke.frontdesk.Report;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ORHouseCountReport {


	@FindBy(xpath="//span[text()='House Count Report']")
	public static WebElement HouseCountReport_TITLE;

	@FindBy(xpath="//input[@id='txtSearchDateFrom']")
	public static WebElement DateTextFrom;

	@FindBy(xpath="//fieldset[@id='reportDateTdId']")
	public static WebElement MessageWithDateFrom;

	@FindBy(xpath="//tr[@class='gtoolbar-repdetails']//img[contains(@onclick,'fnFromDateSelect();')]")
	public static WebElement FromCal_IMG;

	@FindBy(xpath="//tr[@class='gtoolbar-repdetails']//img[contains(@onclick,'fnToDateSelect();')]")
	public static WebElement ToCal_IMG;

	@FindBy(xpath="//table[@id='sr-calContainerPopup_t']//tr//td//a")
	public static WebElement ToDate_Date;

	@FindBy(xpath="//a[contains(.,'Next Month')]")
	public static WebElement NextMonth_ICON;

	@FindBy(xpath="//input[@value='Go']")
	public static WebElement HCRGo_BT;

//	@FindBy(xpath="//img[@name='imgCal2']")
//	public static WebElement FromCal_IMG;


	public void HouseCountReportSection() throws Exception
	{
		try
		{
		String str=GenericMethods.getText(HouseCountReport_TITLE);
		Assert.assertEquals(str, "House Count Report");
	    Thread.sleep(3000);
		}
		catch(Exception e)
		{
			throw e;
		}
		catch(AssertionError e)
		{
			throw e;
		}
    }

	public void fn_VerifySearchedDate() throws Exception
	{
		try
		{
		String DatefromText=DateTextFrom.getAttribute("value");
		String str=GenericMethods.getText(MessageWithDateFrom);
		if(str.contains(DatefromText))
		{
		    Assert.assertTrue(str.contains(DatefromText));
			System.out.println("Monthly Report found between Searched Date");
		}
		}
		catch(Exception e)
		{
			throw e;
		}
		catch(AssertionError e)
		{
			throw e;
		}

	}

	public void fn_GetMonthlyReport() throws Exception
	{
		try
		{
		GenericMethods.js_Click(FromCal_IMG);
		//GenericMethods.clickElement(ToCal_IMG);
		GenericMethods.clickElement(ToDate_Date);
		GenericMethods.js_Click(ToCal_IMG);
		GenericMethods.clickElement(NextMonth_ICON);
		GenericMethods.clickElement(ToDate_Date);
		GenericMethods.js_Click(HCRGo_BT);
		}
		catch(Exception e)
		{
			throw e;
		}

	}

}
