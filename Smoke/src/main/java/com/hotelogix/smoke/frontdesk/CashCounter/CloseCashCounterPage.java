package com.hotelogix.smoke.frontdesk.CashCounter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class CloseCashCounterPage {

	@FindBy(xpath="//input[@name='btnCloseCounter']")
	public WebElement btn_CLoseWithdraw;
	
	public CashCounterPage fn_clkCloseWithdrawBtn() throws Exception {
		try {
		GenericMethods.clickElement(btn_CLoseWithdraw);
		}catch(Exception e) {
			throw e;
		}
		CashCounterPage CCP=PageFactory.initElements(GenericMethods.driver, CashCounterPage.class);
		return CCP;
	}
	
	
	
}
