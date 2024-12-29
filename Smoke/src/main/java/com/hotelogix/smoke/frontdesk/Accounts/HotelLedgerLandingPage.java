package com.hotelogix.smoke.frontdesk.Accounts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

import junit.framework.Assert;

public class HotelLedgerLandingPage {
	
	
	@FindBy(xpath="//form/table/tbody/tr[4]/td/table/tbody/tr")
	public List<WebElement> Data_AllAccStat;
	
	
	
	
	@FindBy(xpath="//a[text()='POS']")
	public WebElement Link_POS;
	
	
	
	
	
public POSPointLedgersListLandingPage fn_ClickOnPOS() throws Exception{
try{
GenericMethods.clickElement(Link_POS);
Thread.sleep(2000);
}
catch(Exception e){
throw e;
}
POSPointLedgersListLandingPage PPL=PageFactory.initElements(GenericMethods.driver, POSPointLedgersListLandingPage.class);
return PPL;
}
	
	
public String fn_getInv(String invToMatch) throws Exception{
		String inv=null;

		try{
			int size=Data_AllAccStat.size()-1;
			System.out.println("Accounts page size of tr:::"+size);
		for(int i=3;i<=size;i+=3){
			Thread.sleep(2000);
			System.out.println("Value of i is:::"+i);
			inv=GenericMethods.driver.findElement(By.xpath("//form/table/tbody/tr[4]/td/table/tbody/tr["+i+"]/td[4]/a")).getText();
			System.out.println("Invoice value came as::::"+inv);
			Thread.sleep(2000);
			System.out.println("before if invToMatch value is:::"+invToMatch);	
			if(inv.equals(invToMatch)){
			System.out.println("in if invToMatch value is:::"+invToMatch);	
				//Thread.sleep(2000);
				break;
			}

			
			
		}
		Thread.sleep(2000);
		Assert.assertEquals(invToMatch, inv);
			
			
			
		}
		catch(Exception e){
			throw e;
		}

		return inv;
		}
	
	

}
