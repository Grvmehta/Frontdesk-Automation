package com.hotelogix.smoke.admin.UserManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddEditUser {

	public static String windowID;

	@FindBy(xpath="//div[@class='headingtxt']//tr//td[2]")
	public static WebElement title;

	@FindBy(xpath="//input[@name='employeeId']")
	public static WebElement empID_txtfild;

	@FindBy(xpath="//input[@name='fName']")
	public static WebElement fName_txtfild;

	@FindBy(xpath="//input[@name='lName']")
	public static WebElement lName_txtfild;

	@FindBy(xpath="//input[@name='address1']")
	public static WebElement address_txtfild;

	@FindBy(xpath="//select[@name='countryId']")
	public static WebElement country_DrpDwn;

	@FindBy(xpath="//select[@name='stateId']")
	public static WebElement state_DrpDwn;

	@FindBy(xpath="//input[@name='city']")
	public static WebElement city_txtfild;

	@FindBy(xpath="//input[@name='zipCode']")
	public static WebElement zipCode_txtfild;

	@FindBy(xpath="//input[@name='phoneNo']")
	public static WebElement phoneNo_txtfild;

	@FindBy(xpath="//select[@name='gender']")
	public static WebElement gender_DrpDwn;

	@FindBy(xpath="//select[@name='identityType']")
	public static WebElement IDType_DepDwn;

	@FindBy(xpath="//input[@name='identityValue']")
	public static WebElement IdNo;

	@FindBy(xpath="//select[@name='departmentId']")
	public static WebElement department_drpDwn;

	@FindBy(xpath="//input[@name='designation']")
	public static WebElement designation_TxtFld;

	@FindBy(xpath="//input[@name='email']")
	public static WebElement email_TxtFld;

	@FindBy(xpath="//input[@name='password']")
	public static WebElement pass_TxtFld;

	@FindBy(xpath="//input[@name='confirm_password']")
	public static WebElement cnfPass_TxtFld;

	@FindBy(xpath="//select[@name='userType']")
	public static WebElement userTyp_drpDwn;

	@FindBy(xpath="//div[@id='perListDiv']/a")
	public static WebElement viewEditReport_link;

	@FindBy(xpath="//input[@value='Save User']")
	public static WebElement saveUser_BT;

    @FindBy(xpath="//select[@name='Available_Counters']")
    public static WebElement availableCounters;

    @FindBy(xpath="//input[@class='btn-style']")
    public static WebElement rightArrow;




	public static void verifyPage() throws InterruptedException{
		String abc=GenericMethods.getText(title);
		if(abc.equals("Users List")){
			System.out.println("Page"+ " "+ abc+"is verified" );
		}
		else
			System.out.println("Page titel Not matched");
	}
	public static String userFname;
	public  void fillUserDetails() throws Exception
	{

		try
		{
		userFname=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(empID_txtfild, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(fName_txtfild, userFname);
	//	GenericMethods.sendKeys(lName_txtfild, "qe");
		GenericMethods.sendKeys(address_txtfild, GenericMethods.generateRandomString());
		GenericMethods.selectElement(country_DrpDwn, "India");
		Thread.sleep(1000);
		GenericMethods.selectElement(state_DrpDwn, "Uttar Pradesh");
		GenericMethods.sendKeys(city_txtfild, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(phoneNo_txtfild, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(zipCode_txtfild, GenericMethods.generateRandomString());
		GenericMethods.selectElement(gender_DrpDwn, "Male");
		GenericMethods.selectElementByIndex(IDType_DepDwn, 1);
		Thread.sleep(1000);
		GenericMethods.selectElementByIndex(department_drpDwn, 5);
        GenericMethods.selectElementByIndex(availableCounters, 0);
        GenericMethods.clickElement(rightArrow);
		GenericMethods.sendKeys(IdNo, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(designation_TxtFld, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(email_TxtFld, GenericMethods.generateRandomString()+"@gmail.com");
		String pass=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(pass_TxtFld,"123456" );
		GenericMethods.sendKeys(cnfPass_TxtFld, "123456");
		GenericMethods.selectElementByIndex(userTyp_drpDwn, 1);
		Thread.sleep(2000);
		}
		catch(NoSuchElementException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public SetReportPermission fn_NavigateSetReportPermsn() throws Exception
	{

		try
		{
		GenericMethods.checkElementDisplay(viewEditReport_link);
		GenericMethods.clickElement(viewEditReport_link);

		}
		catch(NoSuchElementException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		SetReportPermission pageobj=PageFactory.initElements(GenericMethods.driver, SetReportPermission.class);
		return pageobj;

	}

	public  UsersListLandingPage clickOnSave_BT() throws Exception
	{
		try
		{
		GenericMethods.clickElement(saveUser_BT);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(saveUser_BT);
		}
		catch(Exception e)
		{
			throw e;
		}
		UsersListLandingPage pageobj=	PageFactory.initElements(GenericMethods.driver, UsersListLandingPage.class);

	    return pageobj;
	}

	
	
	public List<String> verify_UserLevel() throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<String>();
		Select sel=new Select(userTyp_drpDwn);
		List<WebElement> ele=sel.getOptions();
		for(WebElement ele1:ele)
		{
			arr.add(ele1.getText());
		}
		
		return arr;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}
