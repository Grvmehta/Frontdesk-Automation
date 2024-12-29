package com.hotelogix.smoke.frontdesk.FrontdeskHome;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class GroupReservationPage {
	
	
	
	
	@FindBy(xpath="//span[@class='tname']")
	public WebElement title_GroupResPage;
	
	@FindBy(xpath="//input[@id='btnGrpSave']")
	public WebElement Btn_Reserve;
	
	
	
	
public FrontdeskLandingPage ClickOnReserve() throws Exception{
try{
	Thread.sleep(3000);
GenericMethods.clickElement(Btn_Reserve);

}
catch(Exception e){
	
throw e;
}
Thread.sleep(3000);
FrontdeskLandingPage FLP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
return FLP;
}
			
	
	
	
	

}
