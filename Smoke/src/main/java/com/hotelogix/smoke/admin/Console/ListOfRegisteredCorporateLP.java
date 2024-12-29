package com.hotelogix.smoke.admin.Console;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.admin.UserManager.AddEditUser;
import com.hotelogix.smoke.admin.UserManager.UsersListLandingPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

	public class ListOfRegisteredCorporateLP {

		@FindBy(xpath="//input[@type='checkbox']")
		public static List<WebElement> trCount;

		@FindBy(xpath="//div[@class='headingtxt']//tr//td[2]")
		public static WebElement title;

		@FindBy(xpath="//div[@id='listing-icons']//li[3]//img")
		public static WebElement addACorporate;

		@FindBy(xpath="//input[@name='searchTitle']")
		public static WebElement src_txtBox;

		@FindBy(xpath="//input[@value='Search']")
		public static WebElement src_BT;

		@FindBy(xpath="//table[@class='list_viewnew']//tr[2]//td[4]/a")
		public static WebElement regCorporateName;

		@FindBy(xpath="//select[@name='maxEntries']")
		public static WebElement view_drpdown;

		public static void verifyPage() throws InterruptedException{
			String abc=GenericMethods.getText(title);
			Assert.assertEquals(abc, "List of Registered Corporate");
		}

		public  void  view_all() throws Exception
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

		public  AddEditCorporate fn_NavigateToAddEditCorporate() throws Exception
		{
			try
			{
			GenericMethods.clickElement(addACorporate);
			}
			catch(NoSuchElementException e)
			{
				Thread.sleep(3000);
				GenericMethods.js_Click(addACorporate);
			}
			AddEditCorporate pageobj=	PageFactory.initElements(GenericMethods.driver, AddEditCorporate.class);
			return pageobj;
		}

		public  void fn_verifyRegCorporate() throws Exception
		{
			try
			{
			ArrayList<String> arr=new ArrayList<String>();
			int count=GenericMethods.tr_count(trCount);
			for(int i=2;i<=count;i++)
			{
				String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[4]/a")).getText();
				arr.add(data);
				Assert.assertEquals(data, AddEditCorporate.corporateName);
				String src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[10]//img")).getAttribute("src");
				Assert.assertEquals(src.endsWith("on.GIF"),true);
				break;
			}
			Assert.assertEquals(arr.contains(AddEditCorporate.corporateName), true);
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

		public static String findCorpName(int i){

			String name= GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[4]/a")).getText();
			return name;
			}







	}


