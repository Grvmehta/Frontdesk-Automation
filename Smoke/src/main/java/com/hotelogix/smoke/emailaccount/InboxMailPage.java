package com.hotelogix.smoke.emailaccount;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



import com.hotelogix.smoke.genericandbase.GenericMethods;

public class InboxMailPage {


	@FindBy(xpath="//div[@autoid='_lvv_a']//div")
	public static List<WebElement> AllMail;

	@FindBy(xpath="//div[@id='Item.MessageUniqueBody']/div/div/div/a")
	public static WebElement LinkToGuestConsole;


	@FindBy(xpath="//div[@id='Item.MessageUniqueBody']/div/div/div")
	public static WebElement WholeData;

	@FindBy(xpath="//div[@id='x_printDiv']/table/tbody/tr[7]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/strong")
	public static WebElement MailReservationAmt;

	@FindBy(xpath="//div[@id='x_printDiv']/table/tbody/tr[7]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[2]/strong")
	public static WebElement MailReservationTax;

	@FindBy(xpath="//div[@id='x_printDiv']/table/tbody/tr[7]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/strong")
	public static WebElement MailReservationAmtwitTax;


	public static ArrayList<String> al=new ArrayList<String>();





public void ClickOnAccountDetailMail() throws InterruptedException{

	GenericMethods.driver.navigate().refresh();
	Thread.sleep(10000);
//int size=GenericMethods.tr_count(AllMail);
List<WebElement> AllMail=GenericMethods.driver.findElements(By.xpath("//div[@autoid='_lvv_a']//div"));
for(int i=2;i<=AllMail.size()-1;i++){
	AllMail=GenericMethods.driver.findElements(By.xpath("//div[@autoid='_lvv_a']//div"));
	String a=AllMail.get(i).findElement(By.xpath("//div[@autoid='_lvv_a']//div["+i+"]/div[1]/div[4]/div[2]/span[1]/span")).getText();

if(a.equalsIgnoreCase("Account Details")){

GenericMethods.driver.findElement(By.xpath("//div[@autoid='_lvv_a']//div["+i+"]/div[1]/div[4]/div[2]/span[1]/span")).click();
break;
}
}
}



public ArrayList<String> GetDetail() throws InterruptedException{
String link=LinkToGuestConsole.getAttribute("href");
System.out.println(link);
al.add(link);
String a=GenericMethods.getText(WholeData);
int a1= a.indexOf("Password");
String pwd=a.substring(a1+9,a1+18).trim();
int b1=a.indexOf("Username");
String uname= a.substring(b1+9, a1-1).trim();
int c1=a.indexOf("Login Id");
String id=a.substring(c1+9, b1-1).trim();
al.add(id);
al.add(uname);
al.add(pwd);
return al;
}


public void ClickOnWebReservationDetail() throws InterruptedException
{
	GenericMethods.driver.navigate().refresh();
	Thread.sleep(10000);
    //int size=GenericMethods.tr_count(AllMail);
    List<WebElement> AllMail=GenericMethods.driver.findElements(By.xpath("//div[@autoid='_lvv_a']//div"));
    for(int i=2;i<=AllMail.size()-1;i++)
    {
	  AllMail=GenericMethods.driver.findElements(By.xpath("//div[@autoid='_lvv_a']//div"));
	  String a=AllMail.get(i).findElement(By.xpath("//div[@autoid='_lvv_a']//div["+i+"]/div[1]/div[3]/div[1]/span/span")).getText();

      if(a.contains("ManSarovaR"))
      {
	    String b=AllMail.get(i).findElement(By.xpath("//div[@autoid='_lvv_a']//div["+i+"]/div[1]/div[4]/div[2]/span[1]/span")).getText();
	    if(b.contains("Web Booking confirmation for Reservation ID#"))
	    {
		  GenericMethods.driver.findElement(By.xpath("//div[@autoid='_lvv_a']//div["+i+"]/div[1]/div[4]/div[2]/span[1]/span")).click();
		  break;
	    }


      }
    }
}


public ArrayList<String> GetBookingAmountDetail() throws InterruptedException
{
String amt=GenericMethods.getText(MailReservationAmt).trim();
String tax=GenericMethods.getText(MailReservationTax).trim();
String amtWithTax=GenericMethods.getText(MailReservationAmtwitTax).trim();
al.add(amt);
al.add(tax);
al.add(amtWithTax);
return al;

}

}






