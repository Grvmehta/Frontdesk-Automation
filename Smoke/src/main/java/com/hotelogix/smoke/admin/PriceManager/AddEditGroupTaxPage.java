package com.hotelogix.smoke.admin.PriceManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddEditGroupTaxPage {

	public static String groupTax;


	@FindBy(xpath="//input[@id='groupNameMulName_0']")
	public static WebElement GroupName_txtBox;

	@FindBy(xpath="//tr[9]//td[1]//input")
	public static WebElement RoomTax;

	@FindBy(xpath="//tr[9]//td[2]//input")
	public static WebElement PosTax;


	@FindBy(xpath="//input[@value='Save']")
	public static WebElement Save_Btn;




public GroupTaxListPage AddingGroupTax() throws Exception{

	try
	{
 groupTax=AddEditGroupPage.generateRandomString();
GenericMethods.sendKeys(GroupName_txtBox, groupTax);
GenericMethods.clickElement(RoomTax);
GenericMethods.clickElement(PosTax);
GenericMethods.clickElement(Save_Btn);
GroupTaxListPage GTL=PageFactory.initElements(GenericMethods.driver,GroupTaxListPage.class);
return GTL;
	}
	catch(Exception e)
	{
		throw e;
	}

}





}
