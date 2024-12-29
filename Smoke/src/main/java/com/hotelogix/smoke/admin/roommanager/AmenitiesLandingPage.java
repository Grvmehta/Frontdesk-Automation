package com.hotelogix.smoke.admin.roommanager;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AmenitiesLandingPage
{

	//@FindBy(xpath="//div[@id='heading_new']//ul//li[3]//a[2][@title='Add an Amenity ']")
	//public static WebElement addAmenity;
	////div[@id='heading_new']//ul//li[3]//a[2][@title='Add an Amenity ']


	@FindBy(xpath="//a[text()='Add an Amenity ']")
	public static WebElement addAmenity;

	@FindBy(xpath="//div[@class='error_new']")
	public static WebElement message;

	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr")
	public static List<WebElement> count;


	public static String src_value="on.GIF";

//	static String amenityName="Test Amenity1";
//	static String expMessage1="- Amenity ";
//	static String expMessage2=" Saved Successfully";
//
//	static int randomNumber = GenericMethods.randomNumber();
//	static String expMessage=expMessage1+'"'+amenityName+randomNumber+'"'+expMessage2;
//


	public void verify_pageTitle() throws Exception
	{
		try
		{
		String str=GenericMethods.driver.getTitle();
		Assert.assertEquals(str, "Amenities List");
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

	public  AddEditAmenity addAmenity() throws Exception
	{
		//..Method navigates to AddEditAmenity page
		//..Taking return of AddEditAmenity page
		try
		{
		GenericMethods.clickElement(addAmenity);
		AddEditAmenity AEA=PageFactory.initElements(GenericMethods.driver, AddEditAmenity.class);
		return AEA;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public  void verify_savedmsg() throws Exception
	{
		//..Method verifies message displayed on saving amenity
		//..Fetches text of message being displayed
		try
		{
		String amenity_msg=GenericMethods.getText(message);
		Assert.assertEquals(amenity_msg, "- Amenity "+'"'+AddEditAmenity.name+'"'+" Saved Successfully");
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


	public  void verify_amenity() throws Exception
	{
		//..Method compares text of each amenity with added amenity text
		//..Verifies added amenity

		try
		{
		int amenity_count=GenericMethods.tr_count(count);
		for(int i=2;i<=amenity_count;i++)
		{
			String amenity_name=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[3]")).getText();
			if(amenity_name.equals(AddEditAmenity.name))
			{
				//System.out.println(amenity_name);
				Assert.assertEquals(amenity_name, AddEditAmenity.name);
				String status=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[6]//img")).getAttribute("src");
				if(status.contains(src_value))
				{
					Assert.assertTrue(status.contains(src_value));
					//System.out.println("Added amenity is being displayed");
					//System.out.println("Status of added amenity is active");
					break;
				}
			}
		}
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
