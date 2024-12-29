package com.hotelogix.smoke.admin.PosManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.admin.PriceManager.AddSpecialPeriodPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class POSPointsLandingPage {



	@FindBy(xpath="//td[text()='List of POS Points']")
	public static String POSPTitle;

	@FindBy(xpath="//a[@title='Add a POS Point']")
	public static WebElement AddAPOSPoint;

	@FindBy(xpath="//table[@class='list_viewnew']//tbody//tr[2]//td[9]//a")
	public static WebElement POSEdit;

	@FindBy(xpath="//td[@id='msgArea']")
	public static WebElement pge_msg;

	@FindBy(xpath="//select[@name='maxEntries']")
	public static WebElement view_drpdown;

	@FindBy(xpath="//table[@class='list_viewnew']//tr")
	public static List<WebElement> trcount;

	public static String scr_value="on.GIF";


    public static String msg;

	public  AddEditPOSPoint AddEditPOSPoint() throws Exception
	{
		try
		{
	GenericMethods.clickElement(AddAPOSPoint);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(AddAPOSPoint);
		}
		catch(Exception e)
		{
			throw e;
		}
	AddEditPOSPoint APPP=PageFactory.initElements(GenericMethods.driver, AddEditPOSPoint.class);
	return APPP;
	}


	public  AddEditPOSPoint EditPOSPoint() throws Exception
	{
		try
		{
		GenericMethods.clickElement(POSEdit);
		}
		catch(Exception e)
		{
			throw e;
		}
		AddEditPOSPoint APOP=PageFactory.initElements(GenericMethods.driver, AddEditPOSPoint.class);
		return APOP;

	}

	public void verify_AddNewPdtLnk() throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<String>();
		int count=GenericMethods.tr_count(trcount);

		for(int i=2;i<count;i++)
		{
	        
         String data= GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[3]")).getText();
         arr.add(data);
         if(data.equals(AddEditPOSPoint.b))
         {
        	 Assert.assertEquals(data, AddEditPOSPoint.b);
        	 String lnktxt=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[4]")).getText();
        	 //boolean result=lnktxt.contains("0 Items / Add new");
        	 Assert.assertEquals(lnktxt.equalsIgnoreCase("0 Items / Add new"), true);
        	 break;
         }
		}

       Assert.assertEquals(arr.contains(AddEditPOSPoint.b), true);
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

	public static AddEditPOSCategory AddNew_SamePOSP()
	{
		int count=GenericMethods.tr_count(trcount);

		for(int i=2;i<count;i++){
	        String BText=AddEditPOSPoint.b;

String data= GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[3]")).getText();

		if(!BText.equals(data))
		{
			System.out.println("Searcing for POS Point");
		}else{
			System.out.println("POS Point Found");
			Assert.assertEquals(data, BText);
			GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[4]//a[2]")).click();

	break;
		}
		}
AddEditPOSCategory APC = PageFactory.initElements(GenericMethods.driver, AddEditPOSCategory.class);
return APC;

	}

	public  AddPOSProduct clk_addNewPOSPdtLnk() throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<String>();
		int count=GenericMethods.tr_count(trcount);

		for(int i=2;i<count;i++)
		{
	    
            String data= GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[3]")).getText();
            arr.add(data);
            if(data.equals(AddEditPOSPoint.b))
            {
            	Assert.assertEquals(data, AddEditPOSPoint.b);
            	GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[5]//a[2]")).click();
            	break;
            }
	    }
		Assert.assertEquals(arr.contains(AddEditPOSPoint.b), true);

		AddPOSProduct POPLP=PageFactory.initElements(GenericMethods.driver, AddPOSProduct.class);
		return POPLP;
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



	public String verify_PgeMsg() throws Exception
	{
		try
		{
		msg=GenericMethods.getText(pge_msg);
	    return msg;
		}
		catch(Exception e)
		{
			throw e;
		}
	}



	public  void verify_POSPoint() throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<String>();
		int POS_count=GenericMethods.tr_count(trcount);
		for(int i=2;i<=POS_count;i++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[3]")).getText();
			arr.add(data);
			if(data.equals(AddEditPOSPoint.POSPointName))
			{
				//System.out.println(data);
				Assert.assertEquals(data, AddEditPOSPoint.POSPointName);
				String status=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[10]//img")).getAttribute("src");
			
				Assert.assertEquals(status.endsWith("on.GIF"),true);
				break;
		    }
	   }
		Assert.assertEquals(arr.contains(AddEditPOSPoint.POSPointName), true);
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



	public  void  view_all() throws Exception
    {
		try
		{
    	GenericMethods.selectElement(view_drpdown, "All");
    	GenericMethods.Alert_Accept();
		}
		catch(Exception e)
		{
			throw e;
		}
    }


public static String findPOSPoint(int i) throws Exception
{

		String name= GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[@class='main-field']")).getText();
		return name;
		}


	public  AddEditPOSPoint clickOnSpecificEdit( String POSPointName) throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<String>();
		int count=	GenericMethods.tr_count(trcount);
		for(int i=2;i<=count;i++)
		{
			String name= GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
		    arr.add(name);
			if(name.contains(POSPointName))
			{
				Assert.assertEquals(name.contains(POSPointName),true);
			    GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[9]//a")).click();
			    break;
		    }
		}
		//Assert.assertEquals(arr.contains(POSPointName), true);

		AddEditPOSPoint pageobj=PageFactory.initElements(GenericMethods.driver, AddEditPOSPoint.class);
		return pageobj;
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

	public  AddEditPOSCategory clk_AddNewCategory( String POSPointName) throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<String>();
		int count=	GenericMethods.tr_count(trcount);
		for(int i=2;i<=count;i++)
		{
			String name= GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
		    arr.add(name);
		     if(name.equals(POSPointName))
		       {
		    	 Assert.assertEquals(name, POSPointName);
			     GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[4]//a[2]")).click();
			     break;
		       }
	    }
		Assert.assertEquals(arr.contains(POSPointName), true);
		AddEditPOSCategory pageobj=PageFactory.initElements(GenericMethods.driver, AddEditPOSCategory.class);
		return pageobj;
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


	
	public void fn_chkPOSTax() throws Exception{
		try{
		GenericMethods.selectElement(view_drpdown, "All");
		GenericMethods.Alert_Accept();
		AddEditPOSPoint AEP= clickOnSpecificEdit("Restaurant");
		AEP.fn_selectPOSTax();
		POSProductsList POSP=fn_clkPdtLink();
		AddPOSProduct APP=POSP.fn_clkSpecifiedPOSPdt();
		APP.fn_verifyTaxSelection();
		}catch(Exception e){
			throw e;
		}
	}
	

	public POSProductsList fn_clkPdtLink() throws Exception{
		try{
			
		int count=GenericMethods.tr_count(trcount);
		for(int i=2;i<=count;i++){
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			if(data.contains("Restaurant")){
				
				GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[5]/a")).click();
				break;
			}
		}
		
		POSProductsList POSP=PageFactory.initElements(GenericMethods.driver, POSProductsList.class);
		return POSP;
		}catch(Exception e){
			throw e;
		}
	}
	

}

