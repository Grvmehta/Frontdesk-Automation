package com.hotelogix.smoke.admin.PriceManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddActivationDateCR {

	@FindBy(xpath="//table[@class='table-content']//td[3]//input")
	public static WebElement activateForever_CB;

	@FindBy(xpath="//input[@name='Submit332']")
	public static WebElement save_BT;

	@FindBy(xpath="//input[@name='chk']")
	public static WebElement CheckBox;

	@FindBy(xpath="//input[@type='submit']")
	public static WebElement Save_Btn;


	public  ListOfPackageCentralizedRate activateForeverPackateCR() throws Exception{
		
		try
		{
		GenericMethods.clickElement(activateForever_CB);
		Thread.sleep(2000);
		GenericMethods.clickElement(save_BT);
		String abc=GenericMethods.Alert_Accept();
		System.out.println(abc);
		String def="Activating the Package forever will remove all the other Activation dates.\n"+
				 " Do you wish to continue?";
		Assert.assertEquals(abc, def);
		ListOfPackageCentralizedRate pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackageCentralizedRate.class);

		return pageobj;
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public void VerifyAlert() throws Exception{
		GenericMethods.js_Click(CheckBox);


		GenericMethods.clickElement(Save_Btn);

		try{  Alert A1 =GenericMethods.driver.switchTo().alert();

		  String Alert1 = A1.getText();
		  System.out.println("Pop_UpText :" + Alert1);	}catch(Exception e){System.out.println(e);}
		}


	public ListOfPackageCentralizedRate ActivateForever() throws Exception{
		GenericMethods.js_Click(CheckBox);


		GenericMethods.clickElement(Save_Btn);

		try{  Alert A1 =GenericMethods.driver.switchTo().alert();

		  String Alert1 = A1.getText();
		  System.out.println("Pop_UpText :" + Alert1);
		  A1.accept();
		  Thread.sleep(3000);
		  }catch(Exception e){System.out.println(e);}

		ListOfPackageCentralizedRate CPL=PageFactory.initElements(GenericMethods.driver,ListOfPackageCentralizedRate.class );
		return CPL;
		}

}
