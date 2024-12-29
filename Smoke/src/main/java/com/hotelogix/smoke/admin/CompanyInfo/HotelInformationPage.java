package com.hotelogix.smoke.admin.CompanyInfo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class HotelInformationPage {

	@FindBy(xpath="//td[text()='Hotel Information']")
	public static WebElement HotelInformation;

	@FindBy(xpath="//input[@name='address1']")
	public static WebElement Address1;

	@FindBy(xpath="//input[@name='city']")
	public static WebElement HotelInfCity;

	@FindBy(xpath="//input[@name='zipCode']")
	public static WebElement ZipCode;

	@FindBy(xpath="//input[@name='billingSameAddress']")
	public static WebElement SameAsHotelAddress;

	@FindBy(xpath="//select[@name='bSal']")
	public static WebElement Salutation;

	@FindBy(xpath="//input[@value='Save Hotel Info']")
	public static WebElement SaveHotelInfo;

	@FindBy(xpath="//table[@class='table-content']//tr[2]//td[2]")
	public static WebElement HotelSave_Validation;

	@FindBy(xpath="//input[@name='logo']")
	public WebElement btn_hotelLogo;

	public void fn_EnterHotelInformation(String FilePath) throws Exception
	{

		GenericMethods.clickElement(btn_hotelLogo);
		Thread.sleep(4000);
		GenericMethods.autoit(FilePath, "File Upload");
		Address1.clear();

		try{
			GenericMethods.sendKeys(Address1, "123/43");
		}catch(Exception e){

			String abc = "//input[@name='address1']";
			WebElement ele1=GenericMethods.ExplicitWait(Address1, abc);
			ele1.sendKeys("123/43");

		}

		HotelInfCity.clear();

		try{
			GenericMethods.sendKeys(HotelInfCity, "Noida");
		}catch(Exception e){

			String abc = "//input[@name='city']";
			WebElement ele1=GenericMethods.ExplicitWait(HotelInfCity, abc);
			ele1.sendKeys("Noida");

		}

		ZipCode.clear();


		try{
			GenericMethods.sendKeys(ZipCode, "208001");
		}catch(Exception e){
			String abc2 = "//input[@name='zipCode']";
			WebElement ele1=GenericMethods.ExplicitWait(ZipCode, abc2);
			ele1.sendKeys("208001");


		}



		try{
			GenericMethods.clickElement(SameAsHotelAddress);
		}catch(Exception e){
			String abc3 = "//input[@name='billingSameAddress']";
			WebElement ele1=GenericMethods.ExplicitWait(ZipCode, abc3);
			ele1.click();

		}
		
		GenericMethods.selectElement(Salutation, "Mr.");
		try{
			Thread.sleep(2000);
			GenericMethods.clickElement(SaveHotelInfo);
		}catch(Exception e){
			String abc4 = "//input[@value='Save Hotel Info']";
			WebElement ele1=GenericMethods.ExplicitWait(SaveHotelInfo, abc4);
			Thread.sleep(2000);
			ele1.click();

		}

	}

	public void fn_verifyHotelSave() throws InterruptedException
	{
		try
		{
			Thread.sleep(2000);
			String abc=HotelSave_Validation.getText();

			Assert.assertEquals(abc, "- Hotel Information saved successfully");

		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			String abc5 = "//table[@class='table-content']//tr[2]//td[2]";
			WebElement ele1=GenericMethods.ExplicitWait(HotelSave_Validation, abc5);
			Thread.sleep(2000);
			Assert.assertEquals(abc5, "- Hotel Information saved successfully");

		}




	}




}
