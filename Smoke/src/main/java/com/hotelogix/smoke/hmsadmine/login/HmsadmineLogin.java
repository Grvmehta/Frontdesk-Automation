package com.hotelogix.smoke.hmsadmine.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.frontdesk.FrontdeskTrialPage.FrontdeskContinueTrialPage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class HmsadmineLogin {
	
	
	@FindBy(xpath="//input[@id='hotelCodeId']")
	public static WebElement Hotel_Code;

	@FindBy(xpath="//input[@id='userNameId']")
	public static WebElement Username;

	@FindBy(xpath="//input[@id='passwordId']")
	public static WebElement Password;

	@FindBy(xpath="//*[@id='recaptcha-anchor']/div[1]")
	public static WebElement TxtBx_Captcha;

	@FindBy(xpath="//input[@name='Submit52']")
	public static WebElement Login;
	
	
	
	public HmsadmineLogin()
	{
		PageFactory.initElements(GenericMethods.driver, this);
	}

	public HmsadmineHomePage HMSAdmineLogin(int iTestCaseRow) throws Exception{
		try{
			GenericMethods.sendKeys(Hotel_Code,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_HotelCode)));//12937
			GenericMethods.sendKeys(Username,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_EmailAddressUsername)));//harish.selenium30@hotelogix.com
			
			//GenericMethods.sendKeys(TxtBx_Captcha, "111111");
			//  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Password))
			GenericMethods.sendKeys(Password,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Password)));//111111//ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Password))
			//GenericMethods.clickElement(TxtBx_Captcha);
			Thread.sleep(15000);
			GenericMethods.clickElement(Login);
			GenericMethods.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MINUTES);
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}
		HmsadmineHomePage HAO = PageFactory.initElements(GenericMethods.driver, HmsadmineHomePage.class);
		return HAO;
	
		
	}
}

