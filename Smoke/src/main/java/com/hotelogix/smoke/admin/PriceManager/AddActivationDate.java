package com.hotelogix.smoke.admin.PriceManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddActivationDate {
	

	@FindBy(xpath="//input[@name='chk']")
	public static WebElement CheckBox;             
	
	
	
	@FindBy(xpath="//input[@type='submit']")
	public static WebElement Save_Btn;    
	
	
	
	
	
	
	
public void VerifyAlert() throws Exception{
	GenericMethods.js_Click(CheckBox);
	
	
	GenericMethods.clickElement(Save_Btn);

	try{  Alert A1 =GenericMethods.driver.switchTo().alert();
	  
	  String Alert1 = A1.getText();
	  System.out.println("Pop_UpText :" + Alert1);	}catch(Exception e){System.out.println(e);}
	}
	
public CenteralizePackageLandingPage ActivateForever() throws Exception{
	GenericMethods.js_Click(CheckBox);
	
	
	GenericMethods.clickElement(Save_Btn);

	try{  Alert A1 =GenericMethods.driver.switchTo().alert();
	  
	  String Alert1 = A1.getText();
	  System.out.println("Pop_UpText :" + Alert1);	
	  A1.accept();
	  Thread.sleep(3000);
	  }catch(Exception e){System.out.println(e);}
	
	CenteralizePackageLandingPage CPL=PageFactory.initElements(GenericMethods.driver,CenteralizePackageLandingPage.class );
	return CPL;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
