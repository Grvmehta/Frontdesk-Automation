package com.hotelogix.smoke.admin.PriceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.admin.General.AddBookingPolicyPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class SpecialPeriodLandingPage {


	@FindBy(xpath="//td[text()='Special Periods List']")
	public static WebElement SpecialPeriodsTitle;

	@FindBy(xpath="//a[text()='Add a Special Period']")
	public static WebElement AddSpecialPeriod;

	@FindBy(xpath="//table[@id='mainSeasonTable']/tbody/tr")
	public static List<WebElement> tr_count_SP;
		
	@FindBy(xpath="//select[@name='maxEntries']")
	public WebElement drpdown_view;
	
	@FindBy(xpath="//a[text()='Delete Selected Special Period(s)']")
	public WebElement link_deleteSelectedSP;

	
	
	public static ArrayList<String> arr=new ArrayList<String>();
	
	public AddSpecialPeriodPage add_special_period() throws Exception
	{

		try
		{
		GenericMethods.clickElement(AddSpecialPeriod);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(AddSpecialPeriod);
		}
		catch(Exception e)
		{
			throw e;
		}
		AddSpecialPeriodPage ASP=PageFactory.initElements(GenericMethods.driver, AddSpecialPeriodPage.class);
		return ASP;
	}

	
	public void fn_viewAll() throws Exception
	{
		try
		{
		GenericMethods.selectElement(drpdown_view, "All");
		GenericMethods.Alert_Accept();
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	public  void fn_verifySpecialP() throws Exception
	{
		try
		{
		
		int trcount=GenericMethods.tr_count(tr_count_SP);

		for(int i=2;i<trcount;i++)
		{

           String data= GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[3]")).getText();
           arr.add(data);
		}
		Assert.assertEquals(arr.contains(AddSpecialPeriodPage.Sam_Tit), true);
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

	public static void fn_verifySpLandingPage()
	{
		String b1=SpecialPeriodLandingPage.SpecialPeriodsTitle.getText();
		Assert.assertEquals(b1, "Special Periods List");
	}
	
	
	
	public void fn_selectSP() throws Exception
	{
		try
		{
		int count=GenericMethods.tr_count(tr_count_SP);
		for(int i=2;i<=count;i++)
		{
	           String data= GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[3]")).getText();
               arr.add(data);
               if(data.equals(AddSpecialPeriodPage.Sam_Tit))
               {
            	   WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[2]/input"));
            	   ele.click();
            	   break;
               }
		}
		Assert.assertEquals(arr.contains(AddSpecialPeriodPage.Sam_Tit), true);
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
	
	
	
	public void fn_clkDeleteSP() throws Exception
	{
		try
		{
		GenericMethods.clickElement(link_deleteSelectedSP);
		GenericMethods.Alert_Accept();
		}
		catch(Exception e)
		{
			throw e;
		}
	}
}
