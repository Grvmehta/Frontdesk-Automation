package com.hotelogix.smoke.admin.roommanager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;


public class RoomTaxesLandingPage
{
	@FindBy(xpath="//a[text()='Add a Tax']")
	public static WebElement addaTax;

	@FindBy(xpath="//div[@class='error_new']")
	public static WebElement roomtax_msg;

	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr")
	public static List<WebElement> tax_count;

	@FindBy(xpath="//select[@name='maxEntries']")
	public  WebElement drpdwn_view;

	public static String tax_src="on.GIF";


	ArrayList<String> arr= new ArrayList<String>();
	
	public  SaveRoomTaxesPage clickAddRoomTaxes() throws Exception
	{
		try
		{
		GenericMethods.clickElement(addaTax);

		SaveRoomTaxesPage SRTP = PageFactory.initElements(GenericMethods.driver, SaveRoomTaxesPage.class);
		return SRTP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  String verify_roomtax() throws Exception
	{
		try
		{
		String taxpge_msg=GenericMethods.getText(roomtax_msg);
		//Assert.assertTrue(taxpge_msg.contains(SaveRoomTaxesPage.taxName));

		return taxpge_msg;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public  void chk_taxstatus() throws Exception
	{
		try
		{
		GenericMethods.selectElement(drpdwn_view, "All");
		GenericMethods.Alert_Accept();
		int count1=GenericMethods.tr_count(tax_count);
		//System.out.println(count1);
		for(int i=2;i<=count1;i++)
		{

			String data1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			arr.add(data1);
			if(data1.equals(SaveRoomTaxesPage.taxName))
			{
			//Assert.assertEquals(data1, SaveRoomTaxesPage.taxName);
			String data2=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]//img")).getAttribute("src");
			Assert.assertEquals(data2.contains(tax_src), true);
			break;
			}

		}
		Assert.assertEquals(arr.contains(SaveRoomTaxesPage.taxName), true);

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
	
	
	public void fn_verifyTax(String taxname,String txtAmt,String txtType) throws Exception {
		try {
		ArrayList<String> arr=new ArrayList<String>();		
		GenericMethods.selectElement(drpdwn_view, "All");
		GenericMethods.Alert_Accept();
		int row_count=GenericMethods.tr_count(tax_count);
		for(int i=2;i<=row_count;i++) {
			String str=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tbody//tr["+i+"]//td[3]")).getText();
			arr.add(str);		
			break;
		}
		if(arr.contains(taxname)!=false) {
			 SaveRoomTaxesPage SRT=clickAddRoomTaxes();
		     SRT.fn_addRoomTax(taxname, txtAmt, txtType);		     
	}
		}catch(Exception e) {
			throw e;
		}
	}
}
