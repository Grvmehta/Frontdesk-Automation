package com.hotelogix.smoke.admin.PriceManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ListOfPackagesCorporate1

{
   @FindBy(xpath="//a[@title='Attach a Package']")
   public static WebElement attachPkg_btn;

   public static String windowID;

   public static attachPackages click_attackPkgbtn() throws Exception
   {
	   windowID=GenericMethods.GetCurrentWindowID();
	   GenericMethods.clickElement(attachPkg_btn);
	   attachPackages pageobj=	PageFactory.initElements(GenericMethods.driver, attachPackages.class);
	   return pageobj;
   }
}
