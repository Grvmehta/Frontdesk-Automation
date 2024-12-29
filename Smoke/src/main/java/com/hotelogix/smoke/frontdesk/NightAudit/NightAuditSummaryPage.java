package com.hotelogix.smoke.frontdesk.NightAudit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class NightAuditSummaryPage {
	
	
	@FindBy(xpath="//table/tbody/tr[1]/td[2]/input")
	public WebElement Btn_ContinueToWork;
	
	
	
	
public FrontdeskLandingPage clickOnContinueToWork() throws Exception{
try{
GenericMethods.clickElement(Btn_ContinueToWork);	
}
	
catch(Exception e){
	throw e;
}
FrontdeskLandingPage FLP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
return FLP;
	
	
}
	
	
	

}
