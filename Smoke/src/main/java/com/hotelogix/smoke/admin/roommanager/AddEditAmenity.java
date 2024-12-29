package com.hotelogix.smoke.admin.roommanager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddEditAmenity
{
	@FindBy(id="titleMulTang_0")
	public static WebElement amenityTitle;
	// Amenity Title

	@FindBy(id="descriptionMulTang_0")
	public static WebElement amenityDescription;
	// Amenity Description

	@FindBy(name="Submit5")
	public static WebElement save;
	//Save Button Submit5



	static String amenityName="Test Amenity1";
//	static String expMessage1="- Amenity ";
//	static String expMessage2=" Saved Successfully";
//


   public static  int randomNumber = GenericMethods.randomNumber();
   public  static String name=amenityName+randomNumber;
	//static String expMessage=expMessage1+'"'+amenityName+randomNumber+'"'+expMessage2;


   
   
   
	public  AmenitiesLandingPage save_amenity() throws Exception
	{
		//..Method enters details required to add amenity and saves it
		//..Navigates to AmenitiesLandingPage
		try
		{
		GenericMethods.sendKeys(amenityTitle,name);
		GenericMethods.sendKeys(amenityDescription, "Test Description"+randomNumber);
		GenericMethods.clickElement(save);

		//..Initializing AmenitiesLandingPage
		AmenitiesLandingPage ALP = PageFactory.initElements(GenericMethods.driver, AmenitiesLandingPage.class);
		return ALP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


}
