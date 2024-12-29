package com.hotelogix.smoke.admin.UserManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class SetReportPermission {

	@FindBy(xpath="//tr/td[@class='page-heading']")
	public static WebElement title;

	@FindBy(xpath="//input[@name='chkAll']")
	public static WebElement chkAll;

	@FindBy(xpath="//input[@name='save']")
	public static WebElement save_Bt;

	public static String a;

	public static void focusonChildWindow() throws Exception{
		String a=GenericMethods.windowHandle_admin(AddEditUser.windowID);
		SetReportPermission.a=a;
	}

	public  String  verifyPage() throws Exception
	{

		try
		{
	  String name= GenericMethods.getText(title);
      return name;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

    public  static AddEditUser fn_clkSave() throws Exception
    {
    	GenericMethods.clickElement(save_Bt);
    	AddEditUser AEU=PageFactory.initElements(GenericMethods.driver, AddEditUser.class);
    	return AEU;
    }



	public   AddEditUser selectAllReport() throws Exception
	{

		try
		{
		GenericMethods.clickElement(chkAll);
		Thread.sleep(2000);
		GenericMethods.clickElement(save_Bt);
		AddEditUser AEU=PageFactory.initElements(GenericMethods.driver, AddEditUser.class);
    	return AEU;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}
