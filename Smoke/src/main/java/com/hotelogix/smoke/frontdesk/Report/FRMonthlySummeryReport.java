package com.hotelogix.smoke.frontdesk.Report;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class FRMonthlySummeryReport {


	@FindBy(xpath="//select[@id='month']")
	public static WebElement Month_DD;

	@FindBy(xpath="//select[@id='year']")
	public static WebElement Year_DD;

	@FindBy(xpath="(//input[@name=''])[2]")
	public static WebElement MSRGo_BT;

	@FindBy(xpath="//fieldset[@id='reportDateTdId']")
	public static WebElement MessageWithDateFrom;

	@FindBy(xpath="//span[text()='Monthly Summary Report']")
	public static WebElement MonthlySummaryReport_TITLE;

	@FindBy(xpath="//input[@value='Print']")
	public static WebElement Print_BT;

	@FindBy(xpath="//input[@name='btnExport']")
	public static WebElement Export_BT;




      public void fn_VerifyMonthlyReport(String month, String year){
		try{
		GenericMethods.selectElement(Month_DD, month);
		GenericMethods.selectElement(Year_DD, year);
		GenericMethods.js_Click(MSRGo_BT);
		Select se=new Select(Month_DD);
		String monthtext=se.getFirstSelectedOption().getText();
		Select yeartext=new Select(Year_DD);
		String yeart=yeartext.getFirstSelectedOption().getText();

		String ab= "for"+ " "+ monthtext+"," +" "+ yeart;

		String str=GenericMethods.getText(MessageWithDateFrom);
		if(str.contains(ab))
		{
			Assert.assertTrue(str.contains(ab));
			System.out.println("Monthly Report found in Monthly Summery Report Page");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		catch(AssertionError e)
		{
			throw e;
		}
	}
      public void fn_ClickPrintBT() throws Exception
      {
    	  try
    	  {
			GenericMethods.clickElement(Print_BT);
    	  }
    	  catch(Exception e)
    	  {
    		  throw e;
    	  }
			}

	public void fn_PrintWindowhandle() throws Exception{

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		Reporter.log("Handle Print Pop-Up");

	}
      public void Fn_MonthlySummaryReportPage() throws Exception
      {
    	  try
    	  {
    	String str=GenericMethods.getText(MonthlySummaryReport_TITLE);
  		Assert.assertEquals(str, "Monthly Summary Report");
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
      public static void fn_ClickExportBT() throws Exception{
  		GenericMethods.clickElement(Export_BT);
  	}
  	public void DownloadNightAuditReportFile() throws Exception{

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

}
