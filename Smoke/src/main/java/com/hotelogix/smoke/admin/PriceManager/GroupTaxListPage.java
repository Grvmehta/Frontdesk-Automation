package com.hotelogix.smoke.admin.PriceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class GroupTaxListPage {





	@FindBy(xpath="//select[@name='maxEntries']")
    public static WebElement view_DepDwn;

	@FindBy(xpath="//td[text()='List of Group Tax']")
	public static WebElement PageTitle;

	@FindBy(xpath="//a[text()='Add a Group Tax']")
	public static WebElement AddGroupTax_Btn;

	@FindBy(xpath="//form[@name='frmListView']//table//tr[2]/td")
	public static WebElement GroupTaxMsg;

	@FindBy(xpath="//table[@class='list_viewnew']/tbody//tr")
	public static List<WebElement> trcount;


	public static String src_value="on.GIF";

public static void VerifyPage() throws InterruptedException
{
	//String winTitle=GenericMethods.driver.getTitle();
	String pageTitle=GenericMethods.getText(PageTitle);
	Assert.assertEquals(pageTitle, "List of Group Tax");


}

public  void fn_viewAll() throws Exception
{

	try
	{
    GenericMethods.selectElement(view_DepDwn, "All");
    GenericMethods.ActionOnAlert("Accept");
    GenericMethods.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	catch(Exception e)
	{
		throw e;
	}
   
   }

public AddEditGroupTaxPage AddGroupTax_Btn() throws Exception{

	try
	{
	GenericMethods.clickElement(AddGroupTax_Btn);
	Thread.sleep(3000);
	AddEditGroupTaxPage AEGT=PageFactory.initElements(GenericMethods.driver,AddEditGroupTaxPage.class);
	return AEGT;
	}
	catch(Exception e)
	{
		throw e;
	}
}

public static void VerifySaveMsg()
{

	String msg=GroupTaxMsg.getText();
	if(msg.contains(AddEditGroupTaxPage.groupTax))
	{
		System.out.println(AddEditGroupTaxPage.groupTax + " Added sucessfully");
	}

}

public  void verify_savedGroupTax()
{
	ArrayList<String> arr=new ArrayList<String>();
	int item_count=GenericMethods.tr_count(trcount);
	for(int k=2;k<=item_count;k++)
	{
		String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[3]")).getText();
        arr.add(data);
		if(data.contains(AddEditGroupTaxPage.groupTax))
		{
			Assert.assertEquals(data, AddEditGroupTaxPage.groupTax);
			String status=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[7]//img")).getAttribute("src");
			Assert.assertEquals(status.endsWith("on.GIF"),true);
			break;
		}

	}
	Assert.assertEquals(arr.contains(AddEditGroupTaxPage.groupTax), true);
}




}
