package com.hotelogix.smoke.admin.UserManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.admin.PosManager.AddEditPOSPoint;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class UsersLevelList {

	@FindBy(xpath="//td[text()='User Levels List']")
	public static WebElement UserLevelsList;

	@FindBy(xpath="//a[text()='Add a New User Level']")
	public static WebElement AddANewUserLevel;


	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr")
	public static List<WebElement> tr_count_ULL;

	@FindBy(xpath="//img[@src='http://hotelogix.stayezee.com/images/on.GIF']")
	public static WebElement StatusActive;

	public void fn_verifyUserLevelList()
	{
		String abc=UserLevelsList.getText();

		Assert.assertEquals(abc, "User Levels List");
	}


	public AddEditUserLevelPage AddNew_UserLevel() throws Exception
	{
		try
		{
		GenericMethods.clickElement(AddANewUserLevel);
		}
		catch(NoSuchElementException e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		AddEditUserLevelPage AEULP=PageFactory.initElements(GenericMethods.driver, AddEditUserLevelPage.class);
		return AEULP;


	}

	public  void verify_UserLevel() throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<String>();
		int trcount=GenericMethods.tr_count(tr_count_ULL);

		for(int i=2;i<trcount;i++)
		{

           String data= GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[3]")).getText();
           arr.add(data);
           if(data.equals(AddEditUserLevelPage.abc))
           {
           Assert.assertEquals(data, AddEditUserLevelPage.abc);
  		   String src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]//img")).getAttribute("src");
  		   Assert.assertEquals(src.endsWith("on.GIF"),true);
	       break;
           }
		}
		Assert.assertEquals(arr.contains(AddEditUserLevelPage.abc), true);
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






}
