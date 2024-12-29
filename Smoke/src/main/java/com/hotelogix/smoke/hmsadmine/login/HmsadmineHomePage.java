package com.hotelogix.smoke.hmsadmine.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class HmsadmineHomePage {
	
	@FindBy(xpath="//*[@id='listMenuRoot']/li[6]")
	public WebElement hotelsNew;
	
	
public	HmsadmineHomePage()
{
	PageFactory.initElements(GenericMethods.driver,this);
}

public void clickOnHotelsNew() throws Exception
{
	GenericMethods.clickElement(hotelsNew);
}

}
