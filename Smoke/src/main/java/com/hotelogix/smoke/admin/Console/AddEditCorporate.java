package com.hotelogix.smoke.admin.Console;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddEditCorporate {
	@FindBy(xpath="//input[@name='businessName']")
	public static WebElement cName;

	@FindBy(xpath="//input[@name='address1']")
	public static WebElement Addres;

	@FindBy(xpath="//select[@name='countryId']")
	public static WebElement country;

	@FindBy(xpath="//select[@name='stateId']")
	public static WebElement state;

	@FindBy(xpath="//input[@name='city']")
	public static WebElement city;

	@FindBy(xpath="//input[@name='zipCode']")
	public static WebElement zipCode;

	@FindBy(xpath="//select[@name='salution']")
	public static WebElement salutation;

	@FindBy(xpath="//input[@name='fName']")
	public static WebElement fName;

	@FindBy(xpath="//input[@name='lName']")
	public static WebElement lName;

	@FindBy(xpath="//input[@name='designation']")
	public static WebElement designation;

	@FindBy(xpath="//input[@name='phoneNo']")
	public static WebElement ofcNo;

	@FindBy(xpath="//input[@name='email']")
	public static WebElement eMail;

	@FindBy(xpath="//input[@id='chkSameAsMainfficeAddress']")
	public static WebElement SameAsMainOfficeAddress_CB;

	@FindBy(xpath="//input[@id='chkSameAsContact']")
	public static WebElement SameAsMainContacPerson_CB;

	@FindBy(xpath="//tbody//tr[7]//td[2]/input")
	public static WebElement save_BT;
	public static String corporateName;




	public  ListOfRegisteredCorporateLP fn_fillForm() throws Exception
	{
		try
		{
		corporateName=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(cName, corporateName);
		GenericMethods.sendKeys(Addres,GenericMethods.generateRandomString());
		GenericMethods.selectElementByIndex(country, 99);
		Thread.sleep(1000);
		GenericMethods.selectElementByIndex(state, 4);
		GenericMethods.sendKeys(city,GenericMethods.generateRandomString());
		GenericMethods.sendKeys(zipCode, GenericMethods.generateRandomString());
		GenericMethods.selectElementByIndex(salutation, 3);
		GenericMethods.sendKeys(fName, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(lName, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(designation, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(ofcNo,GenericMethods.generateRandomString());
		GenericMethods.sendKeys(eMail, GenericMethods.generateRandomString()+"@gmail.com");
		GenericMethods.clickElement(SameAsMainOfficeAddress_CB);
		GenericMethods.clickElement(SameAsMainContacPerson_CB);
		Thread.sleep(2000);
		GenericMethods.js_Click(save_BT);
		ListOfRegisteredCorporateLP pageobj = PageFactory.initElements(GenericMethods.driver, ListOfRegisteredCorporateLP.class);
		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  ListOfRegisteredCorporateLP registerACorporate() throws Exception
	{
		try
		{
		new AddEditCorporate().fn_fillForm();
		Thread.sleep(1000);
		GenericMethods.clickElement(save_BT);
		}
		catch(Exception e)
		{
			throw e;
		}
		ListOfRegisteredCorporateLP pageobj = PageFactory.initElements(GenericMethods.driver, ListOfRegisteredCorporateLP.class);
		return pageobj;
	}

}
