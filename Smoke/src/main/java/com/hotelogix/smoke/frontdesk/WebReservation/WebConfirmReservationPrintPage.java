package com.hotelogix.smoke.frontdesk.WebReservation;


import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class WebConfirmReservationPrintPage {


	public static ArrayList<String> al1=new ArrayList<String> ();



@FindBy(xpath="//div[@id='printDiv']/table/tbody/tr[7]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td[2]/strong")
public static WebElement TotalAmt;

@FindBy(xpath="//div[@id='printDiv']/table/tbody/tr[7]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[2]/strong")
public static WebElement TotalTax;

@FindBy(xpath="//div[@id='printDiv']/table/tbody/tr[7]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/strong")
public static WebElement TotalAmtWithTAx;

@FindBy(xpath="//strong[contains(text(),'Reservation Id#')]")
public static WebElement ReservationId;

@FindBy(xpath="//div[@id='printDiv']/table/tbody/tr[15]/td/table/tbody/tr[2]//tr[2]//td[2]")
public static WebElement cancellationPolicy;


public void CloseWindow() throws InterruptedException{
		Thread.sleep(2000);
		GenericMethods.driver.close();
}


public ArrayList<String> GetAmtDetails() throws InterruptedException{
String tamt=GenericMethods.getText(TotalAmt);
String ttax=GenericMethods.getText(TotalTax);
String TamtTax=GenericMethods.getText(TotalAmtWithTAx);
al1.add(tamt);
al1.add(ttax);
al1.add(TamtTax);
return al1;


}


public ArrayList<String> GetResrvDetails() throws InterruptedException
{
String tamt=GenericMethods.getText(TotalAmt);
String ttax=GenericMethods.getText(TotalTax);
String cancelPolicy=GenericMethods.getText(cancellationPolicy);
al1.add(tamt);
al1.add(ttax);
al1.add(cancelPolicy);
return al1;


}


public String GetReservationId() throws InterruptedException
{
String text=GenericMethods.getText(ReservationId);
String rid=text.substring(text.length()-8, text.length());
return rid;
}



}
