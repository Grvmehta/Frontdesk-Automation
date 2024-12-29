package com.hotelogix.smoke.admin.PosManager;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddEditPOSCategory {
	@FindBy(xpath="//input[@name='catName']")
	public static WebElement catTitel;

	@FindBy(xpath="//textarea[@name='description']")
	public static WebElement discription;

	@FindBy(xpath="//input[@value='Save']")
	public static WebElement save_BT;

	       public static String name;
	       public  void fn_fillDetails() throws Exception
	       {
	    	   try
	    	   {
	    	   name=GenericMethods.generateRandomString();
	    	   GenericMethods.sendKeys(catTitel, name);
	    	   GenericMethods.sendKeys(discription, GenericMethods.generateRandomString());
	    	   }
	    	   catch(Exception e)
	    	   {
	    		   throw e;
	    	   }
	       }

	       public  POSCategories fn_addPOSCategory() throws Exception
	       {
	    	   try
	    	   {
	    	   new AddEditPOSCategory().fn_fillDetails();
	    	   GenericMethods.clickElement(save_BT);

	    	   POSCategories pageobj=PageFactory.initElements(GenericMethods.driver, POSCategories.class);
	    	   return pageobj;
	    	   }
	    	   catch(Exception e)
	    	   {
	    		   throw e;
	    	   }
	       }
}
