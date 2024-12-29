package com.hotelogix.smoke.admin.PriceManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class GroupBookingSource {


public static String status="http://hotelogix.stayezee.com/images/on.GIF";





@FindBy(xpath="//a[text()='Attach Package']")
public static WebElement AttachPackage;


@FindBy(xpath="  //a[@title='Add a Group ']")
public static WebElement AddGroup_Btn;

 @FindBy(xpath="//form[@name='frmListView']//table//tr[2]/td")
public static WebElement VerifyGroupAddMsg;


 @FindBy(xpath="//table[@class='list_viewnew']//tr[2]/td[8]/a/img")
 public static WebElement StatusIcon;


 @FindBy(xpath=" //a[text()='Manage Source(s)']")
 public static WebElement ManageSource_link;


 @FindBy(xpath=" //form[@name='frmListView']//table//tr[3]//table//tr[2]//table//td")
 public static WebElement SourceColData;

 @FindBy(xpath="//select[@name='maxEntries']")
 public static WebElement view_DepDwn;


 @FindBy(xpath="//form[@name='frmListView']//table//tr[3]//table//tr[2]//table//tr[2]/td")
 public static WebElement SourceColData1;

 @FindBy(xpath="//table[@class='list_viewnew']/tbody//tr//input[@type='checkbox']")
	public static List<WebElement> checkBox;



 @FindBy(xpath="//*[@id='row_440']/td[6]/table/tbody/tr/td[1]")
 public static WebElement AttachedPackage;



 public static attachPackages attachPackage() throws Exception
	{
		//windowID=GenericMethods.GetCurrentWindowID();
		GenericMethods.clickElement(AttachPackage);
		attachPackages pageobj=	PageFactory.initElements(GenericMethods.driver, attachPackages.class);
		return pageobj;
	}



public AttachPackagePage1 AttachPackage() throws Exception
{
//    int count=GenericMethods.tr_count(checkBox);
//    for(int i=2;i<=count;i++)
//    {
//	    String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
//	    if(data.equals(AddEditGroupPage.gname))
//	    {
	    	GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]//td[7]//a[3]")).click();
//	        break;
//	    }

//    }

	AttachPackagePage1 APP1=PageFactory.initElements(GenericMethods.driver,AttachPackagePage1.class );
	return APP1;
}

public AddEditGroupPage AddGroup() throws Exception{

	GenericMethods.clickElement(AddGroup_Btn);
	AddEditGroupPage AEG=PageFactory.initElements(GenericMethods.driver,AddEditGroupPage.class);
	return AEG;
}


public static void verifyGroup() throws InterruptedException{

	String msg=GenericMethods.getText(VerifyGroupAddMsg);
		if(msg.contains(AddEditGroupPage.gname)){
			System.out.println(msg + "/n"+ " Group added ");
		}else System.out.println("not added");

		String status1=StatusIcon.getAttribute("src");
         System.out.println(status1);
         if(status1.equals(GroupBookingSource.status)){
        	 System.out.println("Icon is set to activate");
         }else System.out.println("Not activate");

}




public ManageSource MangaeSource_link() throws Exception
{
    int count=GenericMethods.tr_count(checkBox);
    for(int i=2;i<=count;i++)
    {
	    String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
	    if(data.equals(AddEditGroupPage.gname))
	    {
	    	GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]//a[2]")).click();
	        break;
	    }

    }
    ManageSource MS=PageFactory.initElements(GenericMethods.driver,ManageSource.class);
	return MS;
}

public static void VerifyWebSource(){


	String s=SourceColData.getText();
	if(s.equals(ManageSource.source)){

		System.out.println("Source type is Web");

	}else System.out.println("Missmatch source");

}


public static void VerifyTravelAgentSource(){


	String s=SourceColData1.getText();
	if(s.contains(ManageSource.source1)){

		System.out.println("Source type is Travel Agent");

	}else System.out.println("Missmatch source");

}


public static void VerifyAttachedPackage()
{
	int item_count=GenericMethods.tr_count(checkBox);
	for(int k=2;k<=item_count;k++)
	{
		String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[6]//td[1]")).getText();
		//System.out.println(data);
		if(data.contains(AttachPackagePage1.textTitle))
		{
			System.out.println("Package has been successfully saved to group.");
			break;
		}

	}
}


public static GroupBookingSource view() throws Exception
{

    GenericMethods.selectElement(view_DepDwn, "All");
    GenericMethods.ActionOnAlert("Accept");
    GenericMethods.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    GroupBookingSource GBS=    PageFactory.initElements(GenericMethods.driver, GroupBookingSource.class);
    return GBS;

}






}
