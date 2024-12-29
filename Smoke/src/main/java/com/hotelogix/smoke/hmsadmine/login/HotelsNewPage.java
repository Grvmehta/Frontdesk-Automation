package com.hotelogix.smoke.hmsadmine.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class HotelsNewPage {
	
	@FindBy(id="searchHName")
	public WebElement searchTxtbx;
	
	@FindBy(xpath="//input[@name='Submit']")
	public WebElement searchBtn;
	
	
	
	
public	HotelsNewPage()
{
	PageFactory.initElements(GenericMethods.driver,this);
}

public void searchHotelId(int iTestCaseRow) throws Exception
{
	searchTxtbx.clear();
	GenericMethods.sendKeys(searchTxtbx,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_HotelCode)));
	
	GenericMethods.clickElement(searchBtn);
	
}

public int validatingHotel(int iTestCaseRow ) throws Exception
{
	int size=GenericMethods.driver.findElements(By.xpath("//form/table/tbody/tr[3]/td/table/tbody/tr")).size();
	String text="";
	String result=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_HotelCode));
	System.out.println("result::::::"+result);
	int iValue=0;
	for(int i=1;i<size-1;i++)
	{
		text=GenericMethods.driver.findElement(By.xpath("//form/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[4]")).getText();
		System.out.println("text:::::"+text);
		if(text.contains(result))
		{
			iValue=i;
			System.out.println("In IF::iValue is::"+iValue);
			break;
		}
	}
	
	return iValue;
}
public void clickingOnImportRsv(int iValue) throws Exception
{
	WebElement ele=GenericMethods.driver.findElement(By.xpath("//form/table/tbody/tr[3]/td/table/tbody/tr["+iValue+"]/td[17]/a"));
	GenericMethods.clickElement(ele);
/*String text=	GenericMethods.getText(titleTxt);
	Assert.assertEquals(text, "Upload Csv");
*/	
}

}
