package com.hotelogix.smoke.admin.PriceManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class EditPackageDetail {
	
	
	@FindBy(xpath="//input[@value='Save']")
	public static WebElement Save_Btn;
	
	
	
public CenteralizePackageLandingPage Save_Edit() throws Exception{
	
	GenericMethods.clickElement(Save_Btn);
	CenteralizePackageLandingPage CPL=PageFactory.initElements(GenericMethods.driver,CenteralizePackageLandingPage.class );
	return CPL;
}
	
	
	

}
