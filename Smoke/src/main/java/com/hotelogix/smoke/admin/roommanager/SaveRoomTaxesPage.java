package com.hotelogix.smoke.admin.roommanager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class SaveRoomTaxesPage
{
	@FindBy(id="taxNameMulName_0")
	public static WebElement taxTitle;

	@FindBy(id="taxShortName")
	public static WebElement taxShortName;

	@FindBy(id="descriptionMulDes_0")
	public static WebElement description;

	@FindBy(id="woSlabTaxAmount")
	public  WebElement txtbx_taxPercent;

	@FindBy(xpath="//select[@id='slabTaxAppliedOnPV']")
	public static WebElement taxType;

	@FindBy(xpath="//select[@id='slabTaxAppliedOnPV']//option[2]")
	public static WebElement selectTaxType;

	@FindBy(xpath="//select[@id='accountCodeId']")
	public static WebElement select_acntcode;

	@FindBy(xpath="//a[@id='addNewAccountCode']")
	public static WebElement addnewaccnt;

	@FindBy(xpath="//input[@id='title']")
	public static WebElement acc_title;

	@FindBy(xpath="//input[@name='accountCode']")
	public static WebElement acc_code;

	@FindBy(xpath="//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']")
	public static WebElement acc_savebtn;

	@FindBy(xpath="//div[@class='ui-dialog-buttonset']//button[2]")
	public static WebElement acc_cancelbtn;

	@FindBy(xpath="//input[@id='slabChargeTypeFV']")
    public WebElement rb_Rs;
	
	@FindBy(xpath="//select[@id='slabTaxAppliedOnFV']")
	public WebElement drpdwn_taxType;
	
	
	@FindBy(name="Submit5")
	public static WebElement saveBtn;

	public static String taxName="Tax"+GenericMethods.randomNumber();
	public static String ShortName="Short Name"+GenericMethods.randomNumber();
    public static String RoomTaxAcntTitle;
    public static String RoomTaxAcntCode;


	public static void accountCode() throws Exception
    {
		try
		{
		 GenericMethods.clickElement(addnewaccnt);
		 RoomTaxAcntTitle=GenericMethods.generateRandomString();
 	     GenericMethods.sendKeys(acc_title, RoomTaxAcntTitle);
 	     Thread.sleep(4000);
 	     RoomTaxAcntCode=GenericMethods.generateRandomString();
 	     GenericMethods.js_Sendkey(acc_code, RoomTaxAcntCode);
 	    Thread.sleep(2000);
 	    GenericMethods.clickElement(acc_savebtn);
 	   // GenericMethods.Alert_Accept();
		}
		catch(Exception e)
		{
			throw e;
		}
    }


	public  RoomTaxesLandingPage saveRoomTaxes() throws Exception
	{
		try
		{
		GenericMethods.sendKeys(taxTitle, taxName);
		GenericMethods.sendKeys(taxShortName, ShortName);
		accountCode();
		Thread.sleep(2000);
		GenericMethods.sendKeys(description, taxName);
		GenericMethods.sendKeys(txtbx_taxPercent, "5");
		//GenericMethods.clickElement(taxType);
		GenericMethods.selectElementByIndex(taxType, 2);
		GenericMethods.clickElement(saveBtn);
		
		RoomTaxesLandingPage RTLP = PageFactory.initElements(GenericMethods.driver, RoomTaxesLandingPage.class);
		return RTLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public RoomTaxesLandingPage fn_addRoomTax(String taxName,String txtAmt,String txtType) throws Exception {
		try {
		GenericMethods.sendKeys(taxTitle, taxName);
		GenericMethods.sendKeys(taxShortName, taxName);
		accountCode();
		Thread.sleep(2000);
		GenericMethods.clickElement(rb_Rs);
		GenericMethods.sendKeys(txtbx_taxPercent, txtAmt);
		GenericMethods.selectElement(drpdwn_taxType, txtType);
		GenericMethods.clickElement(saveBtn);
		}catch(Exception e) {
			throw e;
		}
		RoomTaxesLandingPage RTP=PageFactory.initElements(GenericMethods.driver, RoomTaxesLandingPage.class);
		return RTP;
	}
	


}
