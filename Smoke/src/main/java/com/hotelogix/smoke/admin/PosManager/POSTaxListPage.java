package com.hotelogix.smoke.admin.PosManager;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.admin.PriceManager.AddSpecialPeriodPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class POSTaxListPage {

	@FindBy(xpath="//td[text()='POS Tax List']")
	public static WebElement PTList;

	@FindBy(xpath="//a[@title='Add a Tax']")
	public static WebElement AddTax;

	@FindBy(xpath="//table[@class='list_viewnew']//tr")
	public static List<WebElement> POST;

	public AddPOSTax AddTax() throws Exception
	{
		try
		{
		GenericMethods.clickElement(AddTax);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(AddTax);
		}
		catch(Exception e)
		{
			throw e;
		}
		AddPOSTax APT = PageFactory.initElements(GenericMethods.driver, AddPOSTax.class);
		return APT;

	}

	public  void fn_verifyPOST() throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<String>();
		int trcount=GenericMethods.tr_count(POST);

		for(int i=2;i<trcount;i++)
		{
         String data= GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
		 arr.add(data);
		 if(data.equals(AddPOSTax.TaxName))
		 {
            Assert.assertEquals(data, AddPOSTax.TaxName);
		    String src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]//img")).getAttribute("src");
		    Assert.assertTrue(src.endsWith("on.GIF"));
		    break;
		}

	  }
		Assert.assertEquals(arr.contains(AddPOSTax.TaxName), true);
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
