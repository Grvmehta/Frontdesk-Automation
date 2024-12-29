package com.hotelogix.smoke.admin.roommanager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.itextpdf.text.pdf.hyphenation.TernaryTree.Iterator;

public class SaveRoomTypesPage
{
	@FindBy(xpath="//input[@id='titleMulTang_0']")
	public static WebElement rmtype_name;

	@FindBy(name="accronym")
	public static WebElement shortName;

	@FindBy(id="descriptionMulTang_0")
	public static WebElement description;

	////td[@class='padingtd']//tr[17]//td[2]/tr
	@FindBy(xpath="//td[@class='padingtd']//table//tbody//tr[17]/td[2]/table/tbody/tr")
	public static List<WebElement> checkBox;

	@FindBy(name="Submit5")
	public static WebElement saveButton;


	@FindBy(xpath="//input[@name='taxes[]']")
	public static WebElement clickChkBox;

	@FindBy(xpath="//td[@class='padingtd']//tr[14]//tbody//td[1]")
	public static WebElement amenities;
	
	@FindBy(xpath="//a[text()='Room Types  List']")
	public static WebElement link_RoomTypeList; 


	public static ArrayList<String> arr=new ArrayList<String>();
	public static String roomtype_txt;
	static String actMessage= "saved successfully";
	static int size;

	public static void getTaxsize()
	{
		size = checkBox.size();
		SaveRoomTypesPage.size=size;
	}

	//@FindBy(xpath="//td[@class='padingtd']//table//tbody//tr[17]/td[2]//tr[size]/td")
	//public static WebElement chkbx;
	//@FindBy(xpath="xpath=(//td[@class='padingtd']//table//tbody//tr[17]/td[2]//tbody//input[@type='checkbox'])[last()]")

	public  void clickCheckBox() throws Exception
	{
		try
		{
		if(clickChkBox.isSelected())
		{
			//clickChkBox.click();
			//clickChkBox.click();
			System.out.println("is already selected");
		}
		else
		{
			clickChkBox.click();

		}
		//Assert.assertTrue(clickChkBox.isSelected());

		//System.out.println(size);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public RoomTypesLandingPage fn_clkRoomTypeList() throws Exception
	{
		try
		{
		GenericMethods.clickElement(link_RoomTypeList);
		RoomTypesLandingPage RTLP=PageFactory.initElements(GenericMethods.driver, RoomTypesLandingPage.class);
		return RTLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public RoomTypesLandingPage saveRoomType() throws Exception
	{
		

		try
		{
			
			roomtype_txt=rmtype_name.getAttribute("value");
			//GenericMethods.sendKeys(shortName, GenericMethods.generateRandomString());
			//GenericMethods.sendKeys(description, roomtype_txt);
			int count1=GenericMethods.tr_count(checkBox);
			for(int i=1;i<=count1;i++)
			{
				String tax=GenericMethods.driver.findElement(By.xpath("//td[@class='padingtd']//table//tbody//tr[17]/td[2]/table/tbody/tr["+i+"]//td[2]/table//td")).getText();
			    arr.add(tax);
			    if(tax.contains(SaveRoomTaxesPage.taxName))
			    {
			    	WebElement ele=GenericMethods.driver.findElement(By.xpath("//td[@class='padingtd']//table//tbody//tr[17]/td[2]/table/tbody/tr["+i+"]/td/input"));
			    	ele.click();
			    	break;
			    }
			}	
			Assert.assertEquals(arr.contains(SaveRoomTaxesPage.taxName), true);
		   GenericMethods.clickElement(saveButton);
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{

			Thread.sleep(2000);
			GenericMethods.clickElement(saveButton);

		}

		RoomTypesLandingPage RTLP=PageFactory.initElements(GenericMethods.driver, RoomTypesLandingPage.class);
		return RTLP;

	}

	public  void verify_roomtax() throws Exception
	{
		try
		{
		int count1=GenericMethods.tr_count(checkBox);
		for(int i=1;i<=count1;i++)
		{

		String tax=GenericMethods.driver.findElement(By.xpath("//td[@class='padingtd']//table//tbody//tr[17]/td[2]/table/tbody/tr["+i+"]//td[2]/table//td")).getText();
		arr.add(tax);
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


	public  void chkamenity() throws Exception
	{
		//..Method adds available amenities in list_option displayed on SaveRoomTypesPage
		//..Checks for added amenity displayed under Available Amenities
		try
		{
			
			ArrayList<String> arr=new ArrayList<String>();
		WebElement select=GenericMethods.driver.findElement(By.xpath("//td[@class='padingtd']//tr[14]//tbody//td[1]/select"));
		Select sel=new Select(select);
		List<WebElement> list_option=sel.getOptions();
		java.util.Iterator<WebElement> str= list_option.iterator();
		while(str.hasNext()==true)
		{
			
			arr.add(str.next().getText());
						
		}
		
//		if(arr.contains(AddEditAmenity.name))
//		{
			/*System.out.println(list_option);
			System.out.println("Added amenity is being displayed on Add/Edit Amenity page");*/
			Assert.assertTrue(arr.contains(AddEditAmenity.name));
//		}
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
