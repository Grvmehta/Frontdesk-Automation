package com.hotelogix.smoke.admin.PriceManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddSpecialPeriodPage {

	@FindBy(xpath="//div[text()='Add/Edit Special Period']")
	public static WebElement AddEditSpecialPeriod;

	@FindBy(xpath="//input[@name='title']")
	public static WebElement SpecialPeriodTitle;

	@FindBy(xpath="//select[@id='seasonAttributeId']")
	public static WebElement SelSeasonAttribute;

	@FindBy(xpath="//img[@id='showCalFrom']")
	public static WebElement StartCalIcon;

	@FindBy(xpath="//div[@id='calFromContainer']//table//tr//div//a[2]")
	public static WebElement StartCalmonth;

	@FindBy(xpath="//select[@id='calFromContainer_nav_month']")
	public static WebElement SelMonth;

	@FindBy(xpath="//input[@id='calFromContainer_nav_year']")
	public static WebElement StartCalEntrYr;

	@FindBy(xpath="//button[@id='calFromContainer_nav_submit']")
	public static WebElement StartCalOk;

	@FindBy(xpath="//div[@id='calFromContainer']//td[3]/a")
	public static WebElement StartDate;

	@FindBy(xpath="//div[@id='calToContainer']//td[4]/a")
	public static WebElement EndDate;


	@FindBy(xpath="//img[@id='showCalTo']")
	public static WebElement EndCalIcon;

	@FindBy(xpath="//div[@id='calToContainer']//table//div//a[2]")
	public static WebElement EndCalmonth;

	@FindBy(xpath="//select[@id='calToContainer_nav_month']")
	public static WebElement EndSelMonth;

	@FindBy(xpath="//input[@id='calToContainer_nav_year']")
	public static WebElement EndEntrYr;

	@FindBy(xpath="//button[@id='calToContainer_nav_submit']")
	public static WebElement EndCalOk;

	@FindBy(xpath="//input[@value='Save']")
	public static WebElement Save;

	public static String Sam_Tit;

	public void fn_EnterMandatoryFieldsForAddSeason() throws Exception
	{
		GenericMethods.sendKeys(SpecialPeriodTitle, "Sample Special Period");
		GenericMethods.selectElement(SelSeasonAttribute, "High");
		GenericMethods.clickElement(StartCalIcon);
		GenericMethods.clickElement(StartCalmonth);
		GenericMethods.selectElement(SelMonth, "Aug");
		GenericMethods.sendKeys(StartCalEntrYr, "2016");
		GenericMethods.clickElement(StartCalOk);
		GenericMethods.clickElement(StartDate);

		GenericMethods.clickElement(EndCalIcon);
		GenericMethods.clickElement(EndCalmonth);
		GenericMethods.selectElement(EndSelMonth, "Oct");
		GenericMethods.sendKeys(EndEntrYr, "2020");
		GenericMethods.clickElement(EndCalOk);


	}

	public String fn_SPMandatory() throws Exception
	{
		try
		{
		Sam_Tit=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(SpecialPeriodTitle, Sam_Tit);
		//String Sam_Tit=abc;
		GenericMethods.selectElementByIndex(SelSeasonAttribute, 1);
		GenericMethods.clickElement(StartCalIcon);
		//GenericMethods.clickElement(StartCalmonth);
		//GenericMethods.selectElement(SelMonth, "Aug");
		//StartCalEntrYr.clear();
		//Thread.sleep(1000);
		//GenericMethods.sendKeys(StartCalEntrYr, "2026");
		//Thread.sleep(1000);
		//GenericMethods.clickElement(StartCalOk);
		//Thread.sleep(500);
		GenericMethods.clickElement(StartDate);

		GenericMethods.clickElement(EndCalIcon);
		/*GenericMethods.clickElement(EndCalmonth);
		GenericMethods.selectElement(EndSelMonth, "Oct");
		EndEntrYr.clear();
		GenericMethods.sendKeys(EndEntrYr, "2028");
		Thread.sleep(500);
		GenericMethods.clickElement(EndCalOk);*/
		Thread.sleep(500);
		GenericMethods.clickElement(EndDate);
		GenericMethods.clickElement(Save);
		return Sam_Tit;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public SpecialPeriodLandingPage save() throws Exception
	{

		GenericMethods.clickElement(Save);
		SpecialPeriodLandingPage SPLL = PageFactory.initElements(GenericMethods.driver, SpecialPeriodLandingPage.class);
		return SPLL;
	}


}
