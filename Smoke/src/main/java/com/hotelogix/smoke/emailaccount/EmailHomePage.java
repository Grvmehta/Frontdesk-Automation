package com.hotelogix.smoke.emailaccount;

import java.awt.PageAttributes;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.admin.WebTravelAgent.TravleAgent_LoginPage;
//import com.hotelogix.anonymousTest.generalTest;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class EmailHomePage {

	@FindBy(xpath="//span[text()='Inbox']")
	public static WebElement InboxLink;

	@FindBy(xpath="//div[@class='Cp']//div//table//tr")
	public static List<WebElement> AllMail;

	@FindBy(xpath="//div[@id='ShellMail']//a")
	public static WebElement MailLink;

	@FindBy(xpath="//form[@action='move_messages.php']//tbody/tr[5]//tbody//tr")
	public static List<WebElement>  AllMails;


	public static ArrayList<String> al=new ArrayList<String>();

	public InboxMailPage ClickOnMail() throws Exception{
		GenericMethods.clickElement(MailLink);
		Thread.sleep(2000);

		InboxMailPage IMP=PageFactory.initElements(GenericMethods.driver,InboxMailPage.class);
		return IMP;

	}

	public void GetAccountDetailsForGuest(String hotelName,String subject) throws Exception
	{
		try
		{
		GenericMethods.driver.switchTo().frame(1);
		int count=GenericMethods.tr_count(AllMails);
		for(int i=2;i<=count;i+=2)
		{
		String hname=GenericMethods.driver.findElement(By.xpath("//form[@name='FormMsgsINBOX']/table/tbody/tr[5]/td/table/tbody/tr/td/table//tr["+i+"]/td[2]/label")).getText();
		String sub=GenericMethods.driver.findElement(By.xpath("//form[@name='FormMsgsINBOX']/table/tbody/tr[5]/td/table/tbody/tr/td/table//tr["+i+"]/td[5]/b/a")).getText();
		if(hname.equalsIgnoreCase(hotelName)&& sub.startsWith(subject))
		{
		 GenericMethods.driver.findElement(By.xpath("//form[@name='FormMsgsINBOX']/table/tbody/tr[5]/td/table/tbody/tr/td/table//tr["+i+"]/td[5]/b/a")).click();
		 break;

		}
		}
		}
		catch(Exception e)
		{
			throw e;
		}

	}


	public ArrayList<String>  GetBookingAmtDetail() throws Exception
	{

        try
        {
		String  ta=GenericMethods.driver.findElement(By.xpath("//div[@id='printDiv']/table/tbody/tr[7]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/strong")).getText();
		String tt=GenericMethods.driver.findElement(By.xpath("//div[@id='printDiv']/table/tbody/tr[7]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[2]/strong")).getText();
		JavascriptExecutor jsx = (JavascriptExecutor)GenericMethods.driver;
		jsx.executeScript("scroll(0, 500)");
		String policy=GenericMethods.driver.findElement(By.xpath("//div[@id='printDiv']//tr[15]//tr[2]//td[2]")).getText();

	    al.add(ta);
	    al.add(tt);
	    al.add(policy);
		return al;
        }
        catch(Exception e)
        {
        	throw e;
        }

	}

	public  ArrayList<String> GetChargesFromMail(){
		try{
	List<WebElement> Alltr=	GenericMethods.driver.findElements(By.xpath("//div[@class='gs']/div[7]/div/table/tbody/tr/td/div/table/tbody/tr[7]/td/table/tbody/tr[3]/td/table/tbody/tr"));
	int c=GenericMethods.tr_count(GenericMethods.driver.findElements(By.xpath("//div[@class='gs']/div[7]/div/table/tbody/tr/td/div/table/tbody/tr[7]/td/table/tbody/tr[3]/td/table/tbody/tr")));
	Thread.sleep(2000);
	for(int i=2;i<=3;i++){
	Alltr=	GenericMethods.driver.findElements(By.xpath("//div[@class='gs']/div[7]/div/table/tbody/tr/td/div/table/tbody/tr[7]/td/table/tbody/tr[3]/td/table/tbody/tr"));
	Thread.sleep(2000);
	String s=Alltr.get(i).findElement(By.xpath("//div[@class='gs']/div[7]/div/table/tbody/tr/td/div/table/tbody/tr[7]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]/strong")).getText();
	Thread.sleep(2000);
	al.add(s);
	}
	String policy=GenericMethods.driver.findElement(By.xpath("//div[@class='gs']/div[7]/div/table/tbody/tr/td/div/table/tbody/tr[15]//tr[2]//td[2]")).getText();
	al.add(policy);

		}
	catch(Exception e){
	System.out.println(e);
	}
	return al;

	}




	public ArrayList<String> GetGuestLoginDetails() throws InterruptedException
	{
		String dtail=GenericMethods.getText(GenericMethods.driver.findElement(By.xpath("//html/body/table[4]/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td")));
		System.out.println(dtail);

		int i=dtail.indexOf("http");
		int k= dtail.indexOf("&hidLanguageId=1");
		int l=dtail.indexOf("Login Id");
		int m=dtail.indexOf("Username");
		int n=dtail.indexOf("Password");
		int o=dtail.indexOf("Thank you");
		String guestLink= dtail.substring(i, k+18).trim();
		String lId=dtail.substring(l+10,m-1).trim();
		String uName=dtail.substring(m+10, n-1).trim();
		String pwd=dtail.substring(n+9, o-1).trim();
		al.add(guestLink);
		al.add(lId);
		al.add(uName);
		al.add(pwd);

		return al;


	}
	
	
	public ArrayList<String> fn_getTALogin() throws InterruptedException
	{
		String dtail=GenericMethods.getText(GenericMethods.driver.findElement(By.xpath("//html/body/table[4]/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td")));
		System.out.println(dtail);
		
		String[] arr=dtail.split("\n");
		String guestLink=arr[4];
		
		int l=dtail.indexOf("Login Id");
		int m=dtail.indexOf("Username");
		int n=dtail.indexOf("Password");
		int o=dtail.indexOf("Thank you");
		
		String lId=dtail.substring(l+10,m-1).trim();
		String uName=dtail.substring(m+10, n-1).trim();
		String pwd=dtail.substring(n+9, o-1).trim();
		al.add(guestLink);
		al.add(lId);
		al.add(uName);
		al.add(pwd);
		return al;
	}
	

	
}