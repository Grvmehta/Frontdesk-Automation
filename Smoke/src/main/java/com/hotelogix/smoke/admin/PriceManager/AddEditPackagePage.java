package com.hotelogix.smoke.admin.PriceManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddEditPackagePage {
	
	public static String packageName;
	
	
	@FindBy(xpath="//form//table//tr[3]/td/table//td[2]/input")
	public static WebElement PackageName_TxtBox;
	
	
	@FindBy(xpath="//input[@name='minStay']")
	public static WebElement LengthFStay_TxtBox;
	

	
	@FindBy(xpath="//td//textarea")
	public static WebElement Description_TxtBox;
	@FindBy(xpath="	//input[@name='next']")
	public static WebElement Save_Btn;
	
	
	
	
	
	
	
	@FindBy(xpath="//input[@name='pkgShortName']")
	public static WebElement PackageShortName;
	
public ListOfPackagesPage AddingPackage() throws Exception{
	
	packageName=AddEditGroupPage.generateRandomString();
	GenericMethods.sendKeys(PackageName_TxtBox,  packageName);
	String shortName=AddEditGroupPage.generateRandomString();
	GenericMethods.sendKeys(PackageShortName, shortName);
	GenericMethods.sendKeys(LengthFStay_TxtBox, "2");
	
	GenericMethods.sendKeys(Description_TxtBox,"Alot Inside the package" );
	GenericMethods.clickElement(Save_Btn);
	ListOfPackagesPage LOP=PageFactory.initElements(GenericMethods.driver, ListOfPackagesPage .class);
	return LOP;
		
}
	
	
	
	
	
	

}
