package com.hotelogix.smoke.frontdesk.Accounts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class POSPointLedgersListLandingPage {
	
	
	
	
@FindBy(xpath="//select[@name='maxEntries']")
public WebElement DD_View;


@FindBy(xpath="//form/table/tbody/tr[3]/td/table/tbody/tr")
public List<WebElement> AllPOSPoint;



public POSLedgerLandingPage fn_ClickOnLedgerLinkForThePOS(String str) throws Exception{
try{
	GenericMethods.selectElement(DD_View, "All");
	Thread.sleep(2000);
	GenericMethods.ActionOnAlert("Accept");
	Thread.sleep(2000);
int size=AllPOSPoint.size()-1;
for(int i=2;i<=size;i++){
Thread.sleep(2000);
String pos=GenericMethods.driver.findElement(By.xpath("//form/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();
Thread.sleep(2000);
if(pos.contains(str)){

GenericMethods.driver.findElement(By.xpath("//form/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[4]/a")).click();
break;
}
}
}
catch(Exception e){
throw e;		
}
POSLedgerLandingPage PLLP=PageFactory.initElements(GenericMethods.driver, POSLedgerLandingPage.class);
return PLLP;
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
