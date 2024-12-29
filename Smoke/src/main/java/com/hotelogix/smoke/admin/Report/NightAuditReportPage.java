package com.hotelogix.smoke.admin.Report;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class NightAuditReportPage {
	
	

	@FindBy(xpath="//table[@class='list_viewnew']//tr/td[5]/a")
	public static WebElement  ViewReport;
	

	
	
	
	
public static void NightAuditReport_Page(){
		
		String title=GenericMethods.driver.getTitle();
		if(title.contains("Audit Report")){
		System.out.println(title + "page");
}
		else System.out.println("we are not on the page");
}


public NightAuditPage ViewReport_link() throws Exception{
	
	GenericMethods.clickElement(ViewReport);
	NightAuditPage NAP=PageFactory.initElements(GenericMethods.driver,NightAuditPage.class);
	return NAP;
}






}
