package com.hotelogix.smoke.admin.PriceManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ListOfPackagesCorporate

{
  @FindBy(xpath="//div[@class='headingtxt']//tbody//td[2]")
  public static WebElement pg_title;

  @FindBy(xpath="//table[@class='list_viewnew']//tr[2]//td[8]/a")
  public static WebElement addviewpkg_lnk;

  public static ListOfPackagesCorporate1 click_addviewpkg() throws Exception
  {
	  GenericMethods.clickElement(addviewpkg_lnk);
	  ListOfPackagesCorporate1 LPC1=PageFactory.initElements(GenericMethods.driver, ListOfPackagesCorporate1.class);
	  return LPC1;
  }
}
