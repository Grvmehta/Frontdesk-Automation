package com.hotelogix.smoke.admin.PriceManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.admin.Console.AddTravelAgentPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class TravelAgentPackagesLandingPage {


	@FindBy(xpath="//table[@class='list_viewnew']//td[8]/a")
	public static WebElement addViewPackage;

	@FindBy(xpath="//div[@class='headingtxt']//tr//td[2]")
	public static WebElement pgetitle;

	
	@FindBy(xpath="//table[@class='list_viewnew']//tr")
	public List<WebElement> trcount;


	public static String data;

	public ListOfPackagesTravelAgent1 fn_NavigateTopackageListpageForTA() throws Exception
	{
		try
		{
		GenericMethods.clickElement(addViewPackage);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(2000);
			GenericMethods.js_Click(addViewPackage);
		}
		catch(Exception e)
		{
			throw e;
		}
		ListOfPackagesTravelAgent1 pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesTravelAgent1.class);
		return pageobj;
    }


	
	
	
	public ListOfPackagesTravelAgent1 clkAddViewPkg_specificTA(String TA) throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<String>();
		int count=GenericMethods.tr_count(trcount);
	    for(int i=2;i<=count;i++)
	    {
	    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
	    	arr.add(data);
	    	if(data.contains(TA))
	    	{
	    		Assert.assertEquals(data.contains(AddTravelAgentPage.TaName), true);
	    		GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).click();
	    		break;
	    	}
	    }
	    
	    Assert.assertEquals(arr.contains(TA), true);
	    
	    ListOfPackagesTravelAgent1 LTA1=PageFactory.initElements(GenericMethods.driver, ListOfPackagesTravelAgent1.class);
	    return LTA1;
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


	public static void verify_title() throws InterruptedException
	{
		String text=GenericMethods.getText(pgetitle);
		Assert.assertEquals(text,"List of Registered Travel Agent");
	}

}
