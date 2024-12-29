package com.hotelogix.smoke.frontdesk.Accounts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

import junit.framework.Assert;

public class AccountsLandingPage {

	
@FindBy(xpath="//a[text()='Hotel']")
public  WebElement Link_Hotel;

@FindBy(xpath="//form/table/tbody/tr[4]/td/table/tbody/tr")
public List<WebElement> Data_AllAccStat;

@FindBy(xpath="//a[text()='POS']")
public WebElement Link_POS;









   public HotelLedgerLandingPage fn_ClickHotel() throws Exception{
	try{
		GenericMethods.clickElement(Link_Hotel);
	}catch(Exception e){
	    throw e;
	}
		HotelLedgerLandingPage  HLLP=PageFactory.initElements(GenericMethods.driver, HotelLedgerLandingPage.class);
		return HLLP;
	}


		public void fn_ValidateAccountsPage() throws Exception{
			try{
			   String title= GenericMethods.driver.getTitle();
			   Thread.sleep(2000);
			   Assert.assertEquals(title.contains("Accounts"), true);
			}
			 catch(Exception e){
			 throw e;
			}
		}
	
	

	
	
	
	
	

}
