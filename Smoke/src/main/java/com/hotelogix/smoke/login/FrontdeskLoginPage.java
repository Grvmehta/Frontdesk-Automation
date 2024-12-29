package com.hotelogix.smoke.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.frontdesk.FrontdeskTrialPage.FrontdeskContinueTrialPage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class FrontdeskLoginPage
{


	@FindBy(xpath="//input[@id='hotelCodeId']")
	public static WebElement Hotel_Code;

	@FindBy(xpath="//input[@id='userNameId']")
	public static WebElement Username;

	@FindBy(xpath="//input[@id='passwordId']")
	public static WebElement Password;

	@FindBy(xpath="//input[@id='txtCaptcha']")
	public static WebElement TxtBx_Captcha;

	@FindBy(xpath="//input[@name='Submit52']")
	public static WebElement Login;

	public AdminLoginPage fn_verifyURL() throws Exception{
		try{String URL=GenericMethods.driver.getCurrentUrl();
		if(URL.startsWith("http://hotelogix.stayezee.com")){
			Assert.assertEquals(URL.startsWith("http://hotelogix.stayezee.com"),true);
			GenericMethods.driver.get("http://hotelogix.stayezee.com/admine/");
		}
		AdminLoginPage ALP=PageFactory.initElements(GenericMethods.driver, AdminLoginPage.class);
		return ALP;
		}catch(AssertionError e){
			throw e;
		}
		catch(Exception e){
			throw e;
		}
	}



	public FrontdeskContinueTrialPage Frontdesklogin_12719() throws Exception
	{

		GenericMethods.sendKeys(Hotel_Code, "12719");
		GenericMethods.sendKeys(Username, "deepa.kthayat@hotelogix.com");
		GenericMethods.sendKeys(Password, "deepak");
		GenericMethods.clickElement(Login);
		FrontdeskContinueTrialPage BP = PageFactory.initElements(GenericMethods.driver, FrontdeskContinueTrialPage.class);
		return BP;

	}


	public FrontdeskContinueTrialPage Frontdesklogin_12725() throws Exception
	{
		GenericMethods.sendKeys(Hotel_Code, "12725");
		GenericMethods.sendKeys(Username, "c.handravijayeciimt@gmail.com");
		GenericMethods.sendKeys(Password, "bdc776d0");
		GenericMethods.clickElement(Login);
		GenericMethods.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		FrontdeskContinueTrialPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskContinueTrialPage.class);
		return AHO;
	}

	public FrontdeskContinueTrialPage Frontdesklogin_12735() throws Exception
	{
		GenericMethods.sendKeys(Hotel_Code, "12735");
		GenericMethods.sendKeys(Username, "harish.hotelogix.30@gmail.com");
		GenericMethods.sendKeys(Password, "123456");
		GenericMethods.clickElement(Login);
		GenericMethods.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		FrontdeskContinueTrialPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskContinueTrialPage.class);
		return AHO;
	}


	public  FrontdeskContinueTrialPage Frontdesklogin_12940() throws Exception{

		GenericMethods.sendKeys(Hotel_Code, "12940");
		GenericMethods.sendKeys(Username, "deepak.thayat.hotelogix@gmail.com");
		GenericMethods.sendKeys(Password, "deepak");
		GenericMethods.clickElement(Login);
		FrontdeskContinueTrialPage BP = PageFactory.initElements(GenericMethods.driver, FrontdeskContinueTrialPage.class);
		return BP;

	}

	public FrontdeskContinueTrialPage FrontDesklogin_12933() throws Exception
	{

		GenericMethods.sendKeys(Hotel_Code, "12933");
		GenericMethods.sendKeys(Username, "harishsele.nium30@gmail.com");
		GenericMethods.sendKeys(Password, "111111");
		GenericMethods.clickElement(Login);
		GenericMethods.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MINUTES);
		FrontdeskContinueTrialPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskContinueTrialPage.class);
		return AHO;
	}


	public  FrontdeskContinueTrialPage Frontdesklogin_20819() throws Exception{

		try
		{
			GenericMethods.sendKeys(Hotel_Code, "20819");
			GenericMethods.sendKeys(Username, "barkha.kapoorhms@gmail.com");
			GenericMethods.sendKeys(Password, "a899c22c");
			Thread.sleep(3000);
			GenericMethods.clickElement(Login);
			FrontdeskContinueTrialPage BP = PageFactory.initElements(GenericMethods.driver, FrontdeskContinueTrialPage.class);
			return BP;
		}
		catch(Exception e)
		{
			throw e;
		}

	}


	public  FrontdeskContinueTrialPage Frontdesklogin_20857() throws Exception{

		GenericMethods.sendKeys(Hotel_Code, "20857");
		GenericMethods.sendKeys(Username, "kapoor.barkhahms@gmail.com");
		GenericMethods.sendKeys(Password, "f790ed9e");
		Thread.sleep(10000);
		GenericMethods.clickElement(Login);
		FrontdeskContinueTrialPage BP = PageFactory.initElements(GenericMethods.driver, FrontdeskContinueTrialPage.class);
		return BP;

	}


	public  FrontdeskContinueTrialPage Frontdesklogin_20858() throws Exception{

		GenericMethods.sendKeys(Hotel_Code, "20858");
		GenericMethods.sendKeys(Username, "bkapoorhms@gmail.com");
		GenericMethods.sendKeys(Password, "bd6da36f");
		Thread.sleep(10000);
		GenericMethods.clickElement(Login);
		FrontdeskContinueTrialPage BP = PageFactory.initElements(GenericMethods.driver, FrontdeskContinueTrialPage.class);
		return BP;

	}


	public FrontdeskContinueTrialPage Frontdesklogin_11744() throws Exception
	{

		GenericMethods.sendKeys(Hotel_Code, "11744");
		GenericMethods.sendKeys(Username, "khanna.akash2141@yahoo.co.in");
		GenericMethods.sendKeys(Password, "111111");
		GenericMethods.clickElement(Login);
		FrontdeskContinueTrialPage BP = PageFactory.initElements(GenericMethods.driver, FrontdeskContinueTrialPage.class);
		return BP;

	}


	public  FrontdeskContinueTrialPage Frontdesklogin_20803() throws Exception
	{

		GenericMethods.sendKeys(Hotel_Code, "20803");
		GenericMethods.sendKeys(Username, "thayatdeepak007@gmail.com");
		GenericMethods.sendKeys(Password, "deepak");
		Thread.sleep(10000);
		GenericMethods.clickElement(Login);
		FrontdeskContinueTrialPage BP = PageFactory.initElements(GenericMethods.driver, FrontdeskContinueTrialPage.class);
		return BP;

	}


	public FrontdeskContinueTrialPage FrontDesklogin_20787() throws Exception{
		try{
			GenericMethods.sendKeys(Hotel_Code, "20787");
			GenericMethods.sendKeys(Username, "harish.selenium31@gmail.com");
			GenericMethods.sendKeys(Password, "111111");
			Thread.sleep(10000);
			GenericMethods.clickElement(Login);
			GenericMethods.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MINUTES);
		}catch(NoSuchElementException e){
			GenericMethods.driver.navigate().refresh();
			Thread.sleep(10000);
			GenericMethods.sendKeys(Hotel_Code, "20787");
			GenericMethods.sendKeys(Username, "harish.selenium31@gmail.com");
			GenericMethods.sendKeys(Password, "111111");
			Thread.sleep(10000);
			GenericMethods.clickElement(Login);
		}catch(Exception e){

			String str=e.getLocalizedMessage();
			System.out.println(str);
		}
		FrontdeskContinueTrialPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskContinueTrialPage.class);
		return AHO;
	}


	public FrontdeskContinueTrialPage FrontDesklogin_12181() throws Exception{
		try{
			GenericMethods.sendKeys(Hotel_Code, "12181");
			GenericMethods.sendKeys(Username, "nktkapoor72@gmail.com");
			GenericMethods.sendKeys(Password, "efd88f90");
			Thread.sleep(10000);
			GenericMethods.clickElement(Login);
			GenericMethods.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MINUTES);
		}catch(NoSuchElementException e){
			GenericMethods.driver.navigate().refresh();
			Thread.sleep(10000);
			GenericMethods.sendKeys(Hotel_Code, "20787");
			GenericMethods.sendKeys(Username, "harish.selenium31@gmail.com");
			GenericMethods.sendKeys(Password, "111111");
			Thread.sleep(10000);
			GenericMethods.clickElement(Login);
		}catch(Exception e){

			String str=e.getLocalizedMessage();
			System.out.println(str);
		}
		FrontdeskContinueTrialPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskContinueTrialPage.class);
		return AHO;
	}

	public FrontdeskContinueTrialPage frondesklogin() throws Exception{
		try{
			// AL.FrontDeskLogin(iTestCaseRow);
			GenericMethods.sendKeys(Hotel_Code, "20806");
			GenericMethods.sendKeys(Username, "harish.selenium33@gmail.com");
			GenericMethods.sendKeys(Password, "111111");
			GenericMethods.sendKeys(TxtBx_Captcha, "12345");
			GenericMethods.clickElement(Login);
			FrontdeskContinueTrialPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskContinueTrialPage.class);
			return AHO;
		}catch(Exception e){
			throw e;
		}
	}

	public FrontdeskContinueTrialPage FrontDeskLogin(int iTestCaseRow) throws Exception{
		try{
			// ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_HotelCode))
			//ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_EmailAddressUsername))
			GenericMethods.sendKeys(Hotel_Code,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_HotelCode)));//12937
			GenericMethods.sendKeys(Username,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_EmailAddressUsername)));//harish.selenium30@hotelogix.com
			if(GenericMethods.driver.getTitle().contains("http://livestable.hx.local/frontdesk/login/login/")){
				GenericMethods.sendKeys(TxtBx_Captcha, "111111");
			}else if(GenericMethods.driver.getTitle().contains("http://hotelogix.stayezee.com/frontdesk/login/login")){
				GenericMethods.sendKeys(TxtBx_Captcha, "111111");
			    Thread.sleep(5000);;
			}
			GenericMethods.sendKeys(TxtBx_Captcha, "111111");
			//  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Password))
			GenericMethods.sendKeys(Password,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Password)));//111111//ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Password))
			Thread.sleep(10000);
			GenericMethods.clickElement(Login);
			GenericMethods.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MINUTES);
		}catch(NoSuchElementException e){
			GenericMethods.driver.navigate().refresh();
			GenericMethods.sendKeys(Hotel_Code, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_HotelCode)));
			GenericMethods.sendKeys(Username, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_EmailAddressUsername)));
			GenericMethods.sendKeys(Password, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Password)));
			Thread.sleep(1000);
			GenericMethods.clickElement(Login);
		}catch(Exception e){
			String str=e.getLocalizedMessage();
			System.out.println(str);
		}
		System.out.println("Clicked on login++++++++++++++++++++++");
		FrontdeskContinueTrialPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskContinueTrialPage.class);
		return AHO;
	}

	public  FrontdeskContinueTrialPage Frontdesklogin_13009() throws Exception
	{

		GenericMethods.sendKeys(Hotel_Code, "13009");
		GenericMethods.sendKeys(Username, "kbarkha.hms@gmail.com");
		GenericMethods.sendKeys(Password, "455f3443");
		Thread.sleep(10000);
		GenericMethods.clickElement(Login);
		FrontdeskContinueTrialPage BP = PageFactory.initElements(GenericMethods.driver, FrontdeskContinueTrialPage.class);
		return BP;

	}


	public  FrontdeskContinueTrialPage Frontdesklogin_20807() throws Exception
	{

		GenericMethods.sendKeys(Hotel_Code, "20807");
		GenericMethods.sendKeys(Username, "anonymousmailid001@gmail.com");
		GenericMethods.sendKeys(Password, "deepak");
		Thread.sleep(10000);
		GenericMethods.clickElement(Login);
		FrontdeskContinueTrialPage BP = PageFactory.initElements(GenericMethods.driver, FrontdeskContinueTrialPage.class);
		return BP;

	}

	public FrontdeskContinueTrialPage FrontDesklogin_20805() throws Exception{
		try{
			GenericMethods.sendKeys(Hotel_Code, "20805");
			GenericMethods.sendKeys(Username, "harish.selenium32@gmail.com");
			GenericMethods.sendKeys(Password, "111111");
			Thread.sleep(10000);
			GenericMethods.clickElement(Login);
			GenericMethods.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MINUTES);
		}catch(NoSuchElementException e){
			GenericMethods.driver.navigate().refresh();
			Thread.sleep(10000);
			GenericMethods.sendKeys(Hotel_Code, "20805");
			GenericMethods.sendKeys(Username, "harish.selenium32@gmail.com");
			GenericMethods.sendKeys(Password, "111111");
			Thread.sleep(10000);
			GenericMethods.clickElement(Login);
		}catch(Exception e){

			String str=e.getLocalizedMessage();
			System.out.println(str);
		}
		FrontdeskContinueTrialPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskContinueTrialPage.class);
		return AHO;
	}


	public FrontdeskContinueTrialPage FrontDeskLoginwithargument(int iTestCaseRow,String username,int password) throws Exception{
		try{
			// ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_HotelCode))
			//ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_EmailAddressUsername))
			GenericMethods.sendKeys(Hotel_Code,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_HotelCode)));//12937
			GenericMethods.sendKeys(Username,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_EmailAddressUsername)));//harish.selenium30@hotelogix.com
			if(GenericMethods.driver.getTitle().contains("http://livestable.hx.local/frontdesk/login/login/")){
				GenericMethods.sendKeys(TxtBx_Captcha, "111111");
			}else if(GenericMethods.driver.getTitle().contains("http://hotelogix.stayezee.com/frontdesk/login/login")){
				GenericMethods.sendKeys(TxtBx_Captcha, "111111");
			}

			GenericMethods.sendKeys(TxtBx_Captcha, "111111");
			//  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Password))
			GenericMethods.sendKeys(Password,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Password)));
			Thread.sleep(1000);
			GenericMethods.clickElement(Login);
			GenericMethods.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MINUTES);
		}catch(NoSuchElementException e){
			GenericMethods.driver.navigate().refresh();
			GenericMethods.sendKeys(Hotel_Code, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_HotelCode)));
			GenericMethods.sendKeys(Username, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_EmailAddressUsername)));
			GenericMethods.sendKeys(Password, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Password)));
			Thread.sleep(1000);
			GenericMethods.clickElement(Login);
		}catch(Exception e){
			String str=e.getLocalizedMessage();
			System.out.println(str);
		}
		FrontdeskContinueTrialPage AHO = PageFactory.initElements(GenericMethods.driver, FrontdeskContinueTrialPage.class);
		return AHO;
	}

}
