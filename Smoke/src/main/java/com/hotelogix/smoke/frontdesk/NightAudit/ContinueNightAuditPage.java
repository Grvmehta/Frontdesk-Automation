package com.hotelogix.smoke.frontdesk.NightAudit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ContinueNightAuditPage {
	
	
	
	@FindBy(xpath="//table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[3]/input")
	public WebElement Btn_ContinueNightAudit;
	
	
	
	
public IgnoreCounterNightAuditPage ClickToContinueNightAudit() throws Exception{
try{
	Thread.sleep(2000);
	GenericMethods.clickElement(Btn_ContinueNightAudit);
	
}
catch(Exception e){
throw e;
}
	
IgnoreCounterNightAuditPage ICNA=PageFactory.initElements(GenericMethods.driver, IgnoreCounterNightAuditPage.class);
	return ICNA;
	
}

}
