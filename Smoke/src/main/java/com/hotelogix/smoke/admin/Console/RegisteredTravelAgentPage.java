package com.hotelogix.smoke.admin.Console;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




import com.hotelogix.smoke.genericandbase.GenericMethods;

public class RegisteredTravelAgentPage {


	public static String src;


	@FindBy(xpath="//td[text()='List of Registered Travel Agent']")
	public static WebElement TitleOfPage;

	@FindBy(xpath="//a[@title='Add a Travel Agent']")
	public static WebElement AddTravelAgent_Btn;

	@FindBy(xpath="//a[@title='Delete Selected Travel Agent(s)']")
	public static WebElement DeleteTravelAgent_Btn;

	@FindBy(xpath="//a[@title='Cancel']")
	public static WebElement Cacel_Btn;

	@FindBy(xpath="//a[text()='Main']")
	public static WebElement Main_Link;

	@FindBy(xpath="//span[text()='Search Registered Travel Agent:']")
	public static WebElement SearchText;

	@FindBy(xpath="//input[@name='searchTitle']")
	public static WebElement SearchTextBox;

	@FindBy(xpath="//input[@type='submit']")
	public static WebElement Search_Btn;

	@FindBy(xpath="//div[@class='error_new']")
	public static WebElement Add_verifyMsg;

	@FindBy(xpath="//input[@name='id[]']")
	public static List<WebElement> CheckBox;


public String checkStatus(){
	int trcount=GenericMethods.tr_count(CheckBox);
	 int tr=trcount+2;
	    for(int i=2;i<=tr;i++){
	    String  Tname=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[4]")).getText();
	    if(Tname.contains(AddTravelAgentPage.TaName)){
	    System.out.println(AddTravelAgentPage.TaName +"  Find ");
	     src= GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[10]/a/img")).getAttribute("src");
	     break;
	    }
	    }

		return src;






}


public AddTravelAgentPage AddTravelAgent_Btn() throws Exception{

	try{
	GenericMethods.clickElement(AddTravelAgent_Btn);
	}catch(Exception e){

	WebElement ele1 =GenericMethods.ExplicitWait(AddTravelAgent_Btn, "//a[@title='Add a Travel Agent']");
		ele1.click();
	}




	AddTravelAgentPage ATA=PageFactory.initElements(GenericMethods.driver,AddTravelAgentPage.class);
    return ATA;

}

public void Verify_RegisteredTravelAgent() throws InterruptedException{
	String str;
	try{
	str=GenericMethods.getText(Add_verifyMsg);
	}catch(Exception e){

		Thread.sleep(3500);
		str=GenericMethods.getText(Add_verifyMsg);
	}


	System.out.println(str);
	     if(str.contains("saved successfully")){
	    	 System.out.println( str + "showing ");
	     }else System.out.println("not saved");

}














}
