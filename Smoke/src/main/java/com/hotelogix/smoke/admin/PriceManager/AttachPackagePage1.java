package com.hotelogix.smoke.admin.PriceManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AttachPackagePage1 {



	public static String textTitle;



	@FindBy(xpath="//input[@id='chkId_1']")
	public static WebElement Radio_Btn1;


	@FindBy(xpath="//input[@value='Attach']")
	public static WebElement Attach_Btn;


	@FindBy(xpath="//form[@id='frmListView']//table[2]")
	public static WebElement tabletrs;

	@FindBy(xpath="//div[text()='Attach Package']")
	public static WebElement pageTitle;

	@FindBy(xpath="//form//table[2]//tr[2]//td[3]")
	public static WebElement PkgTitle;






    public static String data(){

    	String value1 = null;


		List<WebElement> rows= tabletrs.findElements(By.tagName("tr"));
		//int rsize=rows.size();




		for(int rnum=0;rnum<1;rnum++)

		{

	List<WebElement> columns=rows.get(rnum).findElements(By.xpath("//form[@id='frmListView']//table[2]//td[3]"));
int  colsize=columns.size();
System.out.println(colsize);


		for(int cnum=0;cnum<columns.size();cnum++)

		{


		String value=columns.get(cnum).getText();
		int i=value.indexOf("(");

        //String[] a=value.split("(");
         value1=value.substring(0, i).trim();
		if(value1.equals(attachPackages.c.trim()))
		{
			System.out.println(value1 +" matched");
			break;

		}

       }

}
		Assert.assertEquals(value1, attachPackages.c.trim(),"Pass");
		return value1;
}

public  void VerifyPage() throws InterruptedException{

String Wintitle=GenericMethods.driver.getTitle();
String titlePage=GenericMethods.getText(pageTitle);
if(Wintitle.equals(titlePage)){
	System.out.println(Wintitle + " page title showing");
          }

}


public GroupBookingSource AttachPackage() throws Exception{


    textTitle=GenericMethods.getText(PkgTitle);
    System.out.println(textTitle + " is being attached to group");
    GenericMethods.clickElement(Radio_Btn1);
    GenericMethods.clickElement(Attach_Btn);
    GroupBookingSource GBS=PageFactory.initElements(GenericMethods.driver, GroupBookingSource.class);
    return GBS;


}






}
