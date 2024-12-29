package com.hotelogix.smoke.admin.PriceManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AttachPackagePage {
	
	
	
public static String pkgName;
	
	
	@FindBy(xpath="//div[text()='Attach Packages']")
	public static WebElement Pagetitle; 
	
	
	@FindBy(xpath="//input[@id='chkId_1']")
	public static WebElement Package1;         
	
	@FindBy(xpath="//td[@id='tdCancellationPolicy_1']")
	public static WebElement PackageName1;   
	
	
	@FindBy(xpath="//input[@id='chkId_3']")
	public static WebElement Package3;
	
	@FindBy(xpath="//td[@id='tdCancellationPolicy_3']")
	public static WebElement PackageName3;
	
	@FindBy(xpath="//input[@id='chkId_4']")
	public static WebElement Package4;    
	
	@FindBy(xpath="//td[@id='tdCancellationPolicy_4']")
	public static WebElement PackageName4;    
	
	@FindBy(xpath="//input[@value='Attach']")
	public static WebElement Attach_Btn; 
	
	
	
public void VerifyPage(){
		
		String title=GenericMethods.driver.getTitle();
		if(title.contains("Attach Package")){
			System.out.println(title + " Page dispalying");
		}else {System.out.println("Page not displaying");}
		
	GenericMethods.driver.close();	
}
	

public CenteralizePackageLandingPage AttachPackage() throws Exception{
	
	
	GenericMethods.clickElement(Package3);
	pkgName=GenericMethods.getText(PackageName3);
	//System.out.println(pkgName);
	
	GenericMethods.clickElement(Attach_Btn);
	Thread.sleep(4000);
	
	CenteralizePackageLandingPage CPL=PageFactory.initElements(GenericMethods.driver,CenteralizePackageLandingPage.class );
	return CPL;
	
}




	
	

}
