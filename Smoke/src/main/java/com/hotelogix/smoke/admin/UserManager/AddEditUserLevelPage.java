package com.hotelogix.smoke.admin.UserManager;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddEditUserLevelPage {

	@FindBy(xpath="//input[@name='title']")
	public static WebElement UserLevelTitle;

	@FindBy(xpath="//input[@name='frontDeskKeeper']")
	public static WebElement WorkAreaPOSPointsFDK;

	@FindBy(xpath="//input[@name='houseKeeper']")
	public static WebElement WorkAreaPOSPointsHK;

	@FindBy(xpath="//input[@name='adminConsoleKeeper']")
	public static WebElement WorkAreaPOSPointsAC;

	@FindBy(xpath="//input[@name='reportConsoleKeeper']")
	public static WebElement WorkAreaPOSPointsRC;

	@FindBy(xpath="//select[@id='defaultModule']")
	public static WebElement DefaultVWorkA;

	@FindBy(xpath="//textarea[@name='description']")
	public static WebElement AddUserLevelDesc;

	@FindBy(xpath="//input[@value='Save Changes']")
	public static WebElement UserLevelSaveChanges;

	public static String abc;

	public String fn_EnterUserLevel() throws Exception
	{
		try
		{
		abc=GenericMethods.generateRandomString();

		GenericMethods.sendKeys(UserLevelTitle, abc);

		GenericMethods.clickElement(WorkAreaPOSPointsAC);
		GenericMethods.clickElement(WorkAreaPOSPointsFDK);
		GenericMethods.clickElement(WorkAreaPOSPointsHK);
		GenericMethods.clickElement(WorkAreaPOSPointsRC);

		GenericMethods.selectElement(DefaultVWorkA, "Frontdesk");
		String def=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(AddUserLevelDesc, def);


		return abc;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public UsersLevelList UserLevel_SaveChanges() throws Exception
	{
		try
		{
		GenericMethods.clickElement(UserLevelSaveChanges);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(2000);
			GenericMethods.js_Click(UserLevelSaveChanges);
		}
		catch(Exception e)
		{
			throw e;
		}
		UsersLevelList ULL=PageFactory.initElements(GenericMethods.driver, UsersLevelList.class);
		return ULL;
	}

}
