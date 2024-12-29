package com.hotelogix.smoke.frontdesk.CashCounter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class OpenCashCounter {

	@FindBy(xpath="//input[@name='btnCashDrawerNew']")
	public WebElement btn_Enter;
	
	public FrontdeskLandingPage fn_clkEnter() throws Exception {
		try {
		GenericMethods.clickElement(btn_Enter);
		}catch(Exception e) {
			throw e;
		}
		FrontdeskLandingPage FLP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
		return FLP;
	}
}
