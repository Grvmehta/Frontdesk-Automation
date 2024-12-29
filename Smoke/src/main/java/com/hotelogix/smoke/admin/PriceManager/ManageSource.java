package com.hotelogix.smoke.admin.PriceManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ManageSource {
	
	
public static String source="Web";
public static String source1="Travel Agent";
	
	
	@FindBy(xpath="//div[@id='popup_head']")
	public static WebElement pageTitle;    

	
	@FindBy(xpath="	//select[@id='refType']")
	public static WebElement DropDown;  
	
	
	
	@FindBy(xpath="	//input[@id='chkId_1']")
	public static WebElement CheckBox;
	
	
	@FindBy(xpath="//table[2]//tr[2]/td[3]")
	public static WebElement SourceType;
	
	
	@FindBy(xpath="//input[@value='Save']")
	public static WebElement Save_Btn;
	
	
public void verifyPage(){
		
		
String Title=GenericMethods.driver.getTitle();
System.out.println(Title);
String Title1=pageTitle.getText();
if(Title.equals(Title1)){
	System.out.println(Title + " This is title ");
}else {
	System.out.println("Title not match");
}
		
}
	
	
public GroupBookingSource WebSource() throws Exception{
	

	GenericMethods.selectElement(DropDown, source);
	GenericMethods.clickElement(CheckBox);
	GenericMethods.clickElement(Save_Btn);
	Thread.sleep(2000);
     GroupBookingSource GBS=PageFactory.initElements(GenericMethods.driver, GroupBookingSource.class);
	return GBS;	
}

public GroupBookingSource TravelAgentSource() throws Exception{
	GenericMethods.selectElement(DropDown, source1);
	GenericMethods.clickElement(CheckBox);
	GenericMethods.clickElement(Save_Btn);
	Thread.sleep(2000);
	GroupBookingSource GBS=PageFactory.initElements(GenericMethods.driver, GroupBookingSource.class);
	return GBS;	
	
	
}



	

}
