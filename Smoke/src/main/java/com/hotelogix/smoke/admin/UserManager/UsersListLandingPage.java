package com.hotelogix.smoke.admin.UserManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.admin.PosManager.POSPointsLandingPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class UsersListLandingPage {

	@FindBy(xpath="//td[text()='Users List']")
	public static WebElement UsersList;


	@FindBy(xpath="//input[@type='checkbox']")
	public static List<WebElement> trCount;

	@FindBy(xpath="//tr//td[@class='main-field']")
	public static WebElement name;

	@FindBy(xpath="//a[@title='Add a new user']/img")
	public static WebElement addNewUser_BT;

	@FindBy(xpath="//div[@class='headingtxt']//tr//td[2]")
	public static WebElement title;

	@FindBy(xpath="//input[@name='searchTitle']")
	public static WebElement srchTxtBox;

	@FindBy(xpath="//input[@value='Search']")
	public static WebElement srch_BT;

	@FindBy(xpath="//tr[2]//td[4]")
	public static WebElement expUserName;
	
	@FindBy(xpath="//select[@name='maxEntries']")
	public static WebElement view_drpdown;

	public static void verifyPage() throws InterruptedException{
		String abc=GenericMethods.getText(title);
		if(abc.equals("Users List")){
			System.out.println("Page"+ " "+ abc+"is verified" );
		}
		else
			System.out.println("Page titel Not matched");
	}
	
	public void view_all() throws Exception
    {
		try
		{
    	GenericMethods.selectElement(view_drpdown, "All");
    	GenericMethods.ActionOnAlert("Accept");
		}
		catch(Exception e)
		{
			throw e;
		}
    }



	public  AddEditUser fn_navigateToAddEditUser() throws Exception
	{
		try
		{
		GenericMethods.clickElement(addNewUser_BT);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(addNewUser_BT);
		}
		catch(Exception e)
		{
			throw e;
		}
		AddEditUser pageobj = PageFactory.initElements(GenericMethods.driver, AddEditUser.class);
		return pageobj;
	}

	public  void  fn_verifyAddedUser(String userFname) throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<String>();
		int count=GenericMethods.tr_count(trCount);
		for(int i=2;i<=count;i++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[4]")).getText();
			arr.add(data);
			Assert.assertEquals(data, userFname);
            String src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[9]//img")).getAttribute("src");
            Assert.assertEquals(src.endsWith("on.GIF"),true);
            break;
		}
		
		Assert.assertEquals(arr.contains(userFname), true);
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






public static String findUserName(int i)
{

		String name= GenericMethods.driver.findElement(By.xpath("//tr["+i+"]//td[@class='main-field']")).getText();
		return name;
		}


public static void chkStatus(){
	int count=	GenericMethods.tr_count(trCount);
	for(int i=2;i<=count;i++){
		String name=findUserName(i);
	if(name.equals(AddEditUser.userFname)){
	String src=	GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[9]/img")).getAttribute("src");
	if(src.contains("on.GIF")){
		System.out.println("Status is ON");
	}else{
		System.out.println("status is Off");
	}
	break;
	}else{
		System.out.println("Added category matched on POS categories page");
	}
}

}

	public void fn_verifyUserList()
	{
		String abc=UsersList.getText();
		Assert.assertEquals(abc, "Users List");
	}
}
