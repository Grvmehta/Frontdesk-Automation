package com.hotelogix.smoke.admin.PriceManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class CenteralizePackageLandingPage {
	
	
	public static String attr;
	public static String attr1; 
	public static String text;

	public static String icon;
public static String text1;
public static String icon1;
	
	
	
	@FindBy(xpath="//td[text()='List of Packages (Centralized Rate)']")
	public static WebElement title1;
	
	@FindBy(xpath="	//a[@title='Attach a Package']")
	public static WebElement AttachPackage_Btn;           
	
	@FindBy(xpath="	//td[@id='errorTd']")
	public static WebElement PackageSavedMsg;               

	@FindBy(xpath="//a[text()='Configure']")
	public static WebElement Configure_Link;   
	

	@FindBy(xpath="//table[@class='list_viewnew']//td[7]/img")
	public static WebElement Activation_Data; 
	
	@FindBy(xpath="//table[@class='list_viewnew']//td[7]/a")
	public static WebElement Activation_Data1; 
	
	
	
	@FindBy(xpath="//a[text()='Add Activation Date']")
	public static WebElement AddActivationDate_link;              
	
	
	@FindBy(xpath=" //table[@class='list_viewnew']//td[9]/img")
	public static WebElement ImgStatus;  
	
	
	@FindBy(xpath="//table[@class='list_viewnew']//td[7]")
	public static WebElement Activation_column; 
	
	
	
public AttachPackagePage AttachPackage_Btn() throws Exception{
	 GenericMethods.clickElement(AttachPackage_Btn);
	 AttachPackagePage AP=PageFactory.initElements(GenericMethods.driver, AttachPackagePage.class);
	 return AP;
}

public void VerifyAttachedPackage() throws Exception{
	GenericMethods.checkElementDisplay(PackageSavedMsg);
	String msg=GenericMethods.getText(PackageSavedMsg);
	System.out.println(msg);
}
	
public EditPackageDetail Configure_Link() throws Exception{
attr=Activation_Data.getAttribute("src");	
	GenericMethods.clickElement(Configure_Link);
	EditPackageDetail EPD=PageFactory.initElements(GenericMethods.driver, EditPackageDetail.class);
	return EPD;
}
	
public void ValidateActivationCol() throws InterruptedException{
	
attr1=GenericMethods.getText(Activation_Data1);
if(attr.equals(attr1)){
	System.out.println("Package not configured");
}else System.out.println("Package configured");
	
}

public AddActivationDate ActivationDate() throws Exception{
	
	 text=AddActivationDate_link.getText();
	 System.out.println(text);
     icon=ImgStatus.getAttribute("src");	
     System.out.println(icon);	 
	 
	
	GenericMethods.clickElement(AddActivationDate_link);
	AddActivationDate AAD=PageFactory.initElements(GenericMethods.driver,AddActivationDate.class);
	return AAD;
}

public void VerifyActivationcolumnNStatus(){
	
	
 text1=Activation_column.getText();
 System.out.println(text1);
 icon1=ImgStatus.getAttribute("src");
 
 if(text.equals(text1)){
	 System.out.println("Activation status not changed");
 }else System.out.println("Activation column  has been changed");
 
	if(icon.equals(icon1)){
		System.out.println("Icon not changed");
	}else System.out.println("Icon has been changed");
	
	
}



}
