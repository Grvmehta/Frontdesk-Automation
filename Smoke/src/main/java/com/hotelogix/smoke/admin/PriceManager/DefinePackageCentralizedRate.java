package com.hotelogix.smoke.admin.PriceManager;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import com.hotelogix.smoke.genericandbase.GenericMethods;

public class DefinePackageCentralizedRate {
	public static String newPackagePrice;

	@FindBy(xpath="//form[@id='frmEditView']//td//tbody//tr")
	public static List<WebElement> table;

	@FindBy(xpath="//input[@value='Continue']")
	public static WebElement continue_BT;

	@FindBy(xpath="//tr/td[@class='page-heading-small']")
	public static WebElement title;

	public static PackageDetailsCentralisedRate clickOnContinue_BT() throws Exception{
		GenericMethods.clickElement(continue_BT);
		PackageDetailsCentralisedRate pageobj=	PageFactory.initElements(GenericMethods.driver, PackageDetailsCentralisedRate.class);
		return pageobj;
	}



	public static String editPackagePrice(String Actual, String newPrice) throws Exception{
		newPackagePrice=newPrice;
        int trcount=GenericMethods.tr_count(table);
     //   System.out.println("gettdfortr" + trcount);

        for(int i=2;i<trcount;i++){
        String data=GenericMethods.driver.findElement(By.xpath("//form[@id='frmEditView']//td//tbody//tr["+i+"]//td")).getText();
       // System.out.println(data);

        if(data.equals(Actual))
        {

            WebElement toclick=GenericMethods.driver.findElement(By.xpath("//form[@id='frmEditView']//td//tbody//tr["+i+"]//td[7]/input"));
           // toclick.click();
            Actions action= new Actions(GenericMethods.driver);
            action.moveToElement(toclick).click().perform();
            //toclick.clear();
            //GenericMethods.sendKeys(toclick, newPrice);
//            Robot rb=new Robot();
//
//            rb.keyPress(KeyEvent.VK_ENTER);
//            rb.keyRelease(KeyEvent.VK_ENTER);
            toclick.sendKeys(Keys.chord(Keys.CONTROL, "a"), newPrice);
            action.moveToElement(title).click().perform();
            break;
        }
//        else{
//        	System.out.println("Record not present");
//        }


        }

       return Actual;
    }
}
