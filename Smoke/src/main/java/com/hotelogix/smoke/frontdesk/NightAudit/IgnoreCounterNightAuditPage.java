package com.hotelogix.smoke.frontdesk.NightAudit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class IgnoreCounterNightAuditPage {
	
	
	@FindBy(xpath="//table/tbody/tr[1]/th[7]/input")
	public WebElement CB_IgnoreAllCounter;
	
	
	@FindBy(xpath="//table/tbody/tr[1]/td[3]/input")
	public WebElement Btn_ContinueNightAudit;
	
	
	
public NightAuditSummaryPage IgnoreCounterForNightAudit() throws Exception{
try{
		GenericMethods.clickElement(CB_IgnoreAllCounter);
		GenericMethods.clickElement(Btn_ContinueNightAudit);
		
}
catch(Exception e){
throw e;
}
NightAuditSummaryPage NAS=PageFactory.initElements(GenericMethods.driver, NightAuditSummaryPage.class);
return NAS;
		
	}
}
