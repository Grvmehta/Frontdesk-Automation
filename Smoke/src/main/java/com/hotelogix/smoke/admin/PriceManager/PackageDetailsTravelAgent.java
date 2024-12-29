package com.hotelogix.smoke.admin.PriceManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class PackageDetailsTravelAgent {
	public static String priceOfPAckage;

	@FindBy(xpath="//input[@name='btnSubmit']")
	public static WebElement save_Bt;

	@FindBy(xpath="//td[@class='table-head-inside-light']//a")
	public static WebElement view_Link;

	@FindBy(xpath="//td[@class='table-validity']//table//tbody//tr[3]//tbody//tr")
	public static List<WebElement> roomTypeDetails;



	public static void getPackageRate(String Actual) throws Exception{
		GenericMethods.clickElement(view_Link);
		getPackagePrice( Actual);
	}

	public  ListOfPackagesTravelAgent1 clickOnSave_BT() throws Exception{

		try
		{
		GenericMethods.clickElement(save_Bt);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(1000);
			GenericMethods.js_Click(save_Bt);
		}
		catch(Exception e)
		{
			throw e;
		}
		ListOfPackagesTravelAgent1 pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesTravelAgent1.class);
		return pageobj;

	}

	public static String getPackagePrice(String Actual){
		 int trcount=GenericMethods.tr_count(roomTypeDetails);
        System.out.println("gettdfortr" + trcount);

        for(int i=2;i<trcount;i++){
        	//table[@class='list_viewnew']//tbody//tr["+i+"]//td[4]
        String data=GenericMethods.driver.findElement(By.xpath("//td[@class='table-validity']//table//tbody//tr[3]//tbody//tr["+i+"]/td")).getText();
        System.out.println(data);
        if(data.equals(Actual))
        {
            WebElement toclick=GenericMethods.driver.findElement(By.xpath("//td[@class='table-validity']//table//tbody//tr[3]//tbody//tr["+i+"]//td[4]/a"));
           priceOfPAckage=toclick.getText();
           break;

        }else{
        	System.out.println("No record Found");
        }

	}
        return  priceOfPAckage;
}



}