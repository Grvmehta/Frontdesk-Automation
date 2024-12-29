package com.hotelogix.smoke.admin.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesTravelAgent1;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ListOfRegisteredTravelAgentLP {

	@FindBy(xpath="//table[@class='list_viewnew']//td[11]/a")
	public static WebElement sendEmailLink;

	@FindBy(xpath="//input[@name='id[]']")
	public static List<WebElement> CheckBox;

	@FindBy(xpath="//a[@title='Add a Travel Agent']")
	public static WebElement AddTravelAgent_Btn;

	@FindBy(xpath="//a[@title='Delete Selected Travel Agent(s)']")
	public static WebElement DeleteTravelAgent_Btn;

	@FindBy(xpath="//div[@class='error_new']")
	public static WebElement Add_verifyMsg;

	@FindBy(xpath="//select[@name='maxEntries']")
	public static WebElement view_drpdown;
	
	@FindBy(xpath="//table[@class='list_viewnew']//tr")
	public List<WebElement> trcount; 


	public static String src;

	public  void  view_all() throws Exception
    {
		try
		{
    	GenericMethods.selectElement(view_drpdown, "All");
    	GenericMethods.ActionOnAlert("Accept");
		}
		catch(Exception e)
		{
			throw e;
		}
	
    }



	public static void sendEmail() throws Exception
	{
       try
       {
		GenericMethods.clickElement(sendEmailLink);
		String msg=GenericMethods.ActionOnAlert("Accept");
		Assert.assertEquals(msg, "E-mail sent Successfully.");
       }
       catch(Exception e)
       {
    	   throw e;
       }
	}



public AddTravelAgentPage AddTravelAgent_Btn() throws Exception{

	try
	{
	   GenericMethods.clickElement(AddTravelAgent_Btn);
	}
	catch(NoSuchElementException e)
	{
		Thread.sleep(2500);
		GenericMethods.js_Click(AddTravelAgent_Btn);

	}
	catch(Exception e)
	{
		throw e;
	}

	AddTravelAgentPage ATA=PageFactory.initElements(GenericMethods.driver,AddTravelAgentPage.class);
    return ATA;

}

public void fn_verifyRegisteredTA() throws Exception
{
	try
	{
		ArrayList<String> arr=new ArrayList<String>();
	int count=GenericMethods.tr_count(trcount);
	for(int i=2;i<=count;i++)
	{
	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[4]")).getText();
	arr.add(data);
	Assert.assertEquals(data, AddTravelAgentPage.TaName);
	String src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[10]//img")).getAttribute("src");
	Assert.assertEquals(src.endsWith("on.GIF"),true);
	break;
	}
	Assert.assertEquals(arr.contains(AddTravelAgentPage.TaName), true);
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



public void fn_sendEmail() throws Exception
{
	try
	{
	ArrayList<String> arr=new ArrayList<String>();
	int count=GenericMethods.tr_count(trcount);
	for(int i=2;i<=count;i++)
	{
		String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[4]")).getText();
		arr.add(data);
		if(data.contains(AddTravelAgentPage.TaName))
		{
			Assert.assertEquals(data.contains(AddTravelAgentPage.TaName),true);
			GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[11]/a")).click();
			break;

		}
	}
	
	Assert.assertEquals(arr.contains(AddTravelAgentPage.TaName), true);
    String txt=GenericMethods.Alert_Accept();
    Assert.assertEquals(txt.equals("E-mail sent Successfully."), true);
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







}