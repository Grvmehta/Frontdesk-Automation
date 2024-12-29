package com.hotelogix.smoke.admin.PosManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class POSCategories {

	@FindBy(xpath="//td[@class='container_box']//tr[2]//table//tr")
	public static  List<WebElement> trCount;

	@FindBy(xpath="//tr//td[@class='main-field']")
	public  WebElement name;
	
	@FindBy(xpath="//select[@name='maxEntries']")
	public WebElement drpdown_view;

	@FindBy(xpath="//a[text()='POS Points']")
	public WebElement link_POSPoints;

	public void fn_viewAll() throws Exception
	{
		try
		{
		GenericMethods.selectElement(drpdown_view, "All");
		GenericMethods.Alert_Accept();
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	



	public  void verify_addedPOSCategory( ) throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<String>();
		int count=	GenericMethods.tr_count(trCount);
		for(int i=2;i<=count;i++)
		{
			String name= GenericMethods.driver.findElement(By.xpath("//td[@class='container_box']//tr[2]//table//tr["+i+"]//td[3]")).getText();
		    arr.add(name);
			if(name.equals(AddEditPOSCategory.name))
		    {
				Thread.sleep(1000);
			   Assert.assertEquals(name, AddEditPOSCategory.name);
			   String src=GenericMethods.driver.findElement(By.xpath("//td[@class='container_box']//tr[2]//table//tr["+i+"]//td[8]//img")).getAttribute("src");
			   Assert.assertEquals(src.endsWith("on.GIF"), true);
			   break;
		     }
	    }
		Assert.assertEquals(arr.contains(AddEditPOSCategory.name), true);
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

	public static AddPOSProduct clickOnAddProduct(){
		int count=	GenericMethods.tr_count(trCount);
		for(int i=2;i<=count;i++){
			String name= GenericMethods.driver.findElement(By.xpath("//td[@class='container_box']//tr[2]//table//tr["+i+"]//td[3]")).getText();
		if(name.equals(AddEditPOSCategory.name)){
			GenericMethods.driver.findElement(By.xpath("//tbody//tr["+i+"]//td[5]//a[2]")).click();
			break;
		}else{
			System.out.println("not clicked on add new for product");
		}

		}
		AddPOSProduct pageobj=PageFactory.initElements(GenericMethods.driver , AddPOSProduct.class);

		return pageobj;
	}

	
	public POSPointsLandingPage clk_lnkPOSPoint() throws Exception
	{
		try
		{
		GenericMethods.clickElement(link_POSPoints);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(link_POSPoints);
		}
		catch(Exception e)
		{
			throw e;
		}
		POSPointsLandingPage PPLP=PageFactory.initElements(GenericMethods.driver, POSPointsLandingPage.class);
		return PPLP;
	}
	
}
