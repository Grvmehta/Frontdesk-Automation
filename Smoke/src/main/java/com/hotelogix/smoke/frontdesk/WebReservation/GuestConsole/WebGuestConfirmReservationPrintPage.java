package com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.hotelogix.smoke.genericandbase.GenericMethods;

public class WebGuestConfirmReservationPrintPage {
	
	@FindBy(xpath="//strong[contains(text(),'Reservation Id#')]")
	public static WebElement ReservationId;
	
	
	
	
	
public String GetReservationId() throws InterruptedException{
String text=GenericMethods.getText(ReservationId);
String rid=text.substring(text.length()-8, text.length());
return rid;
}
	
	
	
	

}
