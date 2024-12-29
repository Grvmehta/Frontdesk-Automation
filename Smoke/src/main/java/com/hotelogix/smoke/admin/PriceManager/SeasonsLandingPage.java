package com.hotelogix.smoke.admin.PriceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class SeasonsLandingPage {

	@FindBy(xpath="//td[text()='Season List']")
	public static WebElement SeasonList;

	@FindBy(xpath="//a[@title='Add a Season']")
	public static WebElement Add_Season;

	@FindBy(xpath="//table[@id='mainSeasonTable']//tr[2]//td[3]")
	public static WebElement NewSeason_Title;

	@FindBy(xpath="//table[@id='mainSeasonTable']/tbody/tr")
	public static List<WebElement> tr_count_SL;
	
	
	@FindBy(xpath="//a[@title='Delete Selected Season(s)']")
	public WebElement btn_deleteSeason;

	public AddSeasonPage Add_Season() throws Exception
	{
		try
		{
		GenericMethods.clickElement(Add_Season);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(Add_Season);
		}
		catch(Exception e)
		{
			throw e;
		}
		AddSeasonPage ASP=PageFactory.initElements(GenericMethods.driver, AddSeasonPage.class);
		return ASP;
	}

	public void fn_VerifySeasonsLandingPage()
	{
		String abc=SeasonsLandingPage.SeasonList.getText();
		Assert.assertEquals(abc, "Season List");
	}



	public  void fn_verifySeasonLP() throws Exception
	{
		try
		{
			ArrayList<String> arr=new ArrayList<String>();

		int trcount=GenericMethods.tr_count(tr_count_SL);
       // String data1=null;
		for(int i=2;i<trcount;i++)
		{
	     
	     //String BText=AddSeasonPage.b;

         String data= GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[3]")).getText();
         arr.add(data);
		 //data1=data;  
        /* if(data.equals(AddSeasonPage.b))
		     {
			   Assert.assertEquals(data, AddSeasonPage.b);
			   break;
		     }*/
		}
		Thread.sleep(3000);
		Assert.assertEquals(arr.contains(AddSeasonPage.b),true);
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
	
	
	public void fn_deleteSeason() throws Exception
	{
		try
		{
		int count=GenericMethods.tr_count(tr_count_SL);
		for(int i=2;i<=count;i++)
		{
	         String data= GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[3]")).getText();
             if(data.equals(AddSeasonPage.b))
             {
            	 Thread.sleep(2000);
            	 Assert.assertEquals(data, AddSeasonPage.b);
            	 WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[2]/input"));
            	 GenericMethods.js_Click(ele);
            	 break;
             }
		}
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	
	public void fn_clkDeleteSeasonBtn() throws Exception
	{
		try
		{
		GenericMethods.clickElement(btn_deleteSeason);
		GenericMethods.Alert_Accept();
		}
		catch(Exception e) 
		{
		
			throw e;
		}
	}

	
}


