package com.hotelogix.smoke.frontdesk.Accounts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class POSLedgerLandingPage {
	
	
	@FindBy(xpath="//form/table/tbody/tr[4]/td/table/tbody/tr")
	public List<WebElement> AllStats;

	@FindBy(xpath="//input[@id='searchFolioNo']")
	public WebElement TxtBx_folioSearchBox;
	
	@FindBy(xpath="//input[@type='submit' and @name='Submit']")
	public WebElement Btn_Search;
	
	
public String fn_VerifyPOSInvoice(String invToMatch) throws Exception{
String fNum=null;
try{
	
GenericMethods.sendKeys(TxtBx_folioSearchBox, invToMatch);	
GenericMethods.clickElement(Btn_Search);
 fNum=GenericMethods.driver.findElement(By.xpath("//form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[4]/a")).getText();
if(fNum.equals(invToMatch)){
	Assert.assertEquals(fNum, invToMatch);
Reporter.log(fNum+" :as actual folio number" +invToMatch+" :as expected folio number" , true);
}
}
catch(Exception e){
throw e;
}
return fNum;
}
}
