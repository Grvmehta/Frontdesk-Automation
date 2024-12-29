package com.hotelogix.smoke.frontdesk.Report;

import java.awt.Robot;
import java.awt.event.KeyEvent;






import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class CashierReportPage {


	@FindBy(xpath="//select[@id='counter']")
	public static WebElement Counter_DD;

	@FindBy(xpath="//select[@id='posPointId']")
	public static WebElement PosPoint_DD;

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

	@FindBy(xpath="(//input[@name=''])[2]")
	public static WebElement HCRGo_BT;

	@FindBy(xpath="//input[@value='Print']")
	public static WebElement Print_BT;

	@FindBy(xpath="//input[@name='btnExport']")
	public static WebElement Export_BT;



	public void fn_InputDate(String counter, String POS) throws Exception
	{

		try
		{
		GenericMethods.selectElement(Counter_DD, counter);
		GenericMethods.selectElement(PosPoint_DD, POS);
		GenericMethods.js_Click(FromCal_IMG);
		GenericMethods.clickElement(ToDate_Date);
		GenericMethods.js_Click(ToCal_IMG);
		GenericMethods.clickElement(NextMonth_ICON);
		GenericMethods.clickElement(ToDate_Date);
		GenericMethods.clickElement(HCRGo_BT);
		}
		catch(Exception e)
		{
			throw e;
		}

		}

	 public void fn_ClickPrintBT() throws Exception{
			GenericMethods.clickElement(Print_BT);
			}

	public void fn_PrintWindowhandle() throws Exception
	{
        try
        {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		Reporter.log("Handle Print Pop-Up");
        }
        catch(Exception e)
        {
        	throw e;
        }
	}

	public static void fn_ClickExportBT() throws Exception
	{
		try
		{
		GenericMethods.clickElement(Export_BT);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	public void DownloadNightAuditReportFile() throws Exception
	{

		try
		{
        Robot robo=new Robot();
        fn_ClickExportBT();
        robo.keyPress(KeyEvent.VK_TAB);
           robo.keyPress(KeyEvent.VK_TAB);
           robo.keyPress(KeyEvent.VK_TAB);
           robo.keyPress(KeyEvent.VK_TAB);
           Thread.sleep(1500);
           robo.keyPress(KeyEvent.VK_ENTER);
           Thread.sleep(2000);
           Reporter.log("Handle Export Downloading Pop-Up", true);
		}
		catch(Exception e)
		{
			throw e;
		}
        }

}
