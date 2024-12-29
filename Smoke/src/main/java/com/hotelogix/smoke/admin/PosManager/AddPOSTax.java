package com.hotelogix.smoke.admin.PosManager;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddPOSTax {

	@FindBy(xpath="//input[@id='taxNameMulName_0']")
	public static WebElement TaxTitle;

	@FindBy(xpath="//input[@id='taxShortName']")
	public static WebElement TaxIDSN;

	@FindBy(xpath="//input[@type='radio']")
	public static WebElement TPRadio;

	@FindBy(xpath="//input[@name='tax']")
	public static WebElement Tax;

	@FindBy(xpath="//textarea[@id='descriptionMulDes_0']")
	public static WebElement TaxDesc;

	@FindBy(xpath="//input[@type='submit']")
	public static WebElement SaveTaxPOS;

	@FindBy(xpath="//select[@id='accountCodeId']")
	public static WebElement select_code;

	@FindBy(xpath="//a[@id='addNewAccountCode']")
	public static WebElement addnewaccnt;

	@FindBy(xpath="//input[@id='title']")
	public static WebElement acc_title;

	@FindBy(xpath="//input[@id='accountCode']")
	public static WebElement acc_code;

	@FindBy(xpath="//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']")
	public static WebElement acc_savebtn;

	@FindBy(xpath="//div[@class='ui-dialog-buttonset']//button[2]")
	public static WebElement acc_cancelbtn;


	public static String TaxName;
	public static String POSTaxAcntTitle;
    public static String POSTaxAcntCode;

	public static void accountCode() throws Exception
    {
		try
		{
	   GenericMethods.clickElement(addnewaccnt);
	   POSTaxAcntTitle=GenericMethods.generateRandomString();
 	   GenericMethods.sendKeys(acc_title, POSTaxAcntTitle);
 	   Thread.sleep(2000);
 	   POSTaxAcntCode=GenericMethods.generateRandomString();
 	   GenericMethods.sendKeys(acc_code, POSTaxAcntCode);
 	   Thread.sleep(2000);
 	   GenericMethods.clickElement(acc_savebtn);
 	   GenericMethods.ActionOnAlert("Accept");
		}
		catch(Exception e)
		{
			throw e;
		}
    }


	public String AddPTax() throws Exception
	{

		try
		{
		TaxName=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(TaxTitle, TaxName);

		String cde=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(TaxIDSN, cde);

		accountCode();
		Thread.sleep(2000);
		//GenericMethods.selectElement(select_code, "aghPx");


		GenericMethods.clickElement(TPRadio);
        GenericMethods.sendKeys(Tax, "10");

        String efg=GenericMethods.generateRandomString();
        GenericMethods.sendKeys(TaxDesc, efg);

		return TaxName;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public POSTaxListPage SaveTax() throws Exception
	{
		try
		{
		GenericMethods.clickElement(SaveTaxPOS);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(SaveTaxPOS);
		}
		catch(Exception e)
		{
			throw e;
		}
		POSTaxListPage PTLP=PageFactory.initElements(GenericMethods.driver, POSTaxListPage.class);
		return PTLP;
	}

}
