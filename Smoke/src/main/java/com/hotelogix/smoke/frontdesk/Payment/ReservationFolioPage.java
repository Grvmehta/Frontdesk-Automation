package com.hotelogix.smoke.frontdesk.Payment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ReservationFolioPage
{

	@FindBy(xpath="//td[@class='front_tbl_lft']//table[@class='bat_frn_paytbl']//tr//td[2]//input")
	public static List<WebElement> chkboxCount;


	@FindBy(xpath="//div[@class='bat_account_statement']")
	public static WebElement backToAccStmt;
	
	@FindBy(xpath="//input[@value='checkbox']")
	public WebElement CB_Master;
	
	@FindBy(xpath="//input[@id='btnTaxExmptGR']")
	public WebElement Btn_TaxExempt;
	
	@FindBy(xpath="//td[@class='front_tbl_lft']/table[@class='bat_frn_paytbl']/tbody/tr")
    public List<WebElement> AllRecords;	
	
	@FindBy(xpath="//select[@id='taxExmptReson']")
	public WebElement DD_selectReason;
	
	
	@FindBy(xpath="//input[contains(@id,'chkExmpt_')]")
	public List<WebElement> CB_AllReason;
	
	@FindBy(xpath="//button[@id='txExmptSave-button']")
	public WebElement Btn_Exempt;
	
	
	
	
	public String taxExemptionReason;
	
public void fn_TaxExempt() throws Exception{
try{
GenericMethods.clickElement(CB_Master);	
GenericMethods.clickElement(Btn_TaxExempt);
taxExemptionReason=GenericMethods.selectValueFromDropdownUsingIndex(DD_selectReason, 1);
int size=CB_AllReason.size();
for(int i=0;i<=size-1;i++){
	CB_AllReason.get(i).click();
}
GenericMethods.clickElement(Btn_Exempt);
}
catch(Exception e){
	throw e;
}
}
	

	public float fn_getTaxAmt() throws Exception{
		float rate=0.0f;
		try{
			int size=AllRecords.size();
			for(int i=size-1;i<=size;i++){
			String rateAmt=GenericMethods.driver.findElement(By.xpath("//td[@class='front_tbl_lft']/table[@class='bat_frn_paytbl']/tbody/tr["+i+"]/td[7]")).getText();
			rate=GenericMethods.fn_getRateFromRateString(rateAmt);
			break;
		}
		}
		catch(Exception e){
			throw e;
		}	
		return rate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public AccountStatementLandingPage fn_verifyPaidAmt() throws Exception
	{
		try
		{
		int count=GenericMethods.tr_count(chkboxCount);
	    for(int i=2;i<=count;i+=2)
	    {
	    	String str1=GenericMethods.driver.findElement(By.xpath("//td[@class='front_tbl_lft']//table[@class='bat_frn_paytbl']//tr["+i+"]//td[4]")).getText();
	    	//li.add(str1);
	    	if(str1.contains("Paid by "+AccountStatementLandingPage.str1Value+" with Cash"))
	    	{
	    		String str=GenericMethods.driver.findElement(By.xpath("//td[@class='front_tbl_lft']//table[@class='bat_frn_paytbl']//tr["+i+"]//td[8]")).getText();
	    		if(str.contains(AccountStatementLandingPage.amt1))
	    		{
	    		//Assert.assertTrue(str.contains(amt));
//	    		WebElement ele1=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]"));
//	    		ele1.click();
	            System.out.println("Paid amount has been successfully routed to selected guest ID folio.");
	            break;
	    		}

	    	}
	    }
	    GenericMethods.clickElement(backToAccStmt);
	    AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
		return ASP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public AccountStatementLandingPage fn_verifyRoutedCustomChrgTxt() throws Exception
	{
		int count=GenericMethods.tr_count(chkboxCount);
	    for(int i=2;i<=count;i++)
	    {
	    	String str1=GenericMethods.driver.findElement(By.xpath("//td[@class='front_tbl_lft']//table[@class='bat_frn_paytbl']//tr["+i+"]//td[4]")).getText();
	    	//li.add(str1);
	    	if(str1.contains(AccountStatementLandingPage.CustomCharge))
	    	{
	    		System.out.println("Posted custom charge has been successfully routed to the selected guest ID.");
	            break;


	    	}
	    }
	    GenericMethods.clickElement(backToAccStmt);
	    AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
		return ASP;

	}


	public AccountStatementLandingPage fn_verifyRoutedPaymentTxt() throws Exception
	{
		int count=GenericMethods.tr_count(chkboxCount);
	    for(int i=2;i<=count;i++)
	    {
	    	String str1=GenericMethods.driver.findElement(By.xpath("//td[@class='front_tbl_lft']//table[@class='bat_frn_paytbl']//tr["+i+"]//td[4]")).getText();
	    	//li.add(str1);
	    	if(str1.contains("Paid by "+AccountStatementLandingPage.routedGuestN+" with Cash"))
	    	{
	    		System.out.println("Paid amount has been successfully routed to the selected guest ID.");
	            break;


	    	}
	    }
	    GenericMethods.clickElement(backToAccStmt);
	    AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
		return ASP;

	}

	public AccountStatementLandingPage fn_verifyRoutedOtherChrgTxt() throws Exception
	{
		try
		{
		int count=GenericMethods.tr_count(chkboxCount);
	    for(int i=2;i<=count;i++)
	    {
	    	String str1=GenericMethods.driver.findElement(By.xpath("//td[@class='front_tbl_lft']//table[@class='bat_frn_paytbl']//tr["+i+"]//td[4]")).getText();
	    	//li.add(str1);
	    	if(str1.contains(AccountStatementLandingPage.product) && str1.contains(AccountStatementLandingPage.folioNum))
	    	{
	    		System.out.println("Posted other charge has been successfully routed to the selected guest ID.");
	            break;


	    	}
	    }
	    GenericMethods.clickElement(backToAccStmt);
	    AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
		return ASP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}




}
