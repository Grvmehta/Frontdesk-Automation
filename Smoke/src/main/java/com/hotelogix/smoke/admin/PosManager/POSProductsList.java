package com.hotelogix.smoke.admin.PosManager;

import java.awt.print.Pageable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class POSProductsList {
	@FindBy(xpath="//input[@type='checkbox']")
	public static List<WebElement> tr_count;

	@FindBy(xpath="//table[@class='table-content']//tr[2]//td[4]")
	public static WebElement productName1;

	@FindBy(xpath="//input[@name='prodName']")
	public static WebElement search_txtBox;

	@FindBy(xpath="//label//input[2]")
	public static WebElement go_BT;

	@FindBy(xpath="//select[@name='maxEntries']")
	public static WebElement view_drpdown;
	
	
	public void verify_addedPOSProduct() throws Exception
	{
		try
		{
		GenericMethods.sendKeys(search_txtBox, AddPOSProduct.productName);
		GenericMethods.clickElement(go_BT);
		String name=GenericMethods.getText(productName1);
	    if(name.equals(AddPOSProduct.productName))
	    {
		Assert.assertEquals(name, AddPOSProduct.productName);
		String src=GenericMethods.driver.findElement(By.xpath("//table[@class='table-content']//tr[2]//td[9]//img")).getAttribute("src");
		Assert.assertEquals(src.endsWith("on.GIF"), true);
	    }
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
	
	public void fn_viewAll() throws Exception{
		try{
		GenericMethods.selectElement(view_drpdown, "All");
		GenericMethods.Alert_Accept();
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public AddPOSProduct fn_clkSpecifiedPOSPdt() throws Exception{
		try{
		fn_viewAll();
		int count=GenericMethods.tr_count(tr_count);
		for(int i=2;i<count;i++){
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='table-content']//tr["+i+"]//td[4]")).getText();
			if(data.equals("Sample White (Chicken) chilli soup")){
				GenericMethods.driver.findElement(By.xpath("//table[@class='table-content']//tr["+i+"]//td[8]/a")).click();
				break;
			}
		}
		
		AddPOSProduct APP=PageFactory.initElements(GenericMethods.driver, AddPOSProduct.class);
		return APP;
		}catch(Exception e){
			throw e;
		}
		
	}




	

	}

