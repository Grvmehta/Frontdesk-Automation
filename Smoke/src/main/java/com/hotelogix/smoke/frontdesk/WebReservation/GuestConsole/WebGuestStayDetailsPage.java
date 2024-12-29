package com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.hotelogix.smoke.genericandbase.GenericMethods;

import junit.framework.Assert;

public class WebGuestStayDetailsPage {
	
	
	
	@FindBy(xpath="//img[@id='calIn']")
    public static WebElement CheckINCalender_IMG;
    
    @FindBy(xpath="//input[@id='non']")
    public static WebElement NightEditBox_ED;
    
    @FindBy(xpath="//table[@id='webresCalPopup_t']//tbody//tr//td//a")
    public static WebElement CheckInCalenderDate_Link;
    
    @FindBy(xpath="//img[@id='calOut']")
    public static WebElement CheckOutCalender_IMG;
    
    @FindBy(name="noOfAdult")
    public static WebElement Adult_DD;
    
    @FindBy(name="Submit")
    public static WebElement CheckAvalibility_BT;
    
    @FindBy(xpath="//td[text()='Stay Details']")
    public static WebElement StayDetailTitle;
   


@FindBy(xpath="//table[@id='webresCalPopup_t']//tbody//tr//td//a")
    public static List<WebElement> DateCollection;




public WebGuestSelectRoomPage fn_CheckAvability() throws Exception{
        GenericMethods.clickElement(CheckINCalender_IMG);
        GenericMethods.clickElement(CheckInCalenderDate_Link);
        GenericMethods.sendKeys(NightEditBox_ED, "1");
        Calendar cal = Calendar.getInstance();
        System.out.println("current date: " + cal.getTime());
        cal.add(Calendar.DATE, 1);
        Date dob=cal.getTime();
        String st=dob.toString();
        String[] parts=st.split(" ");
        String parts2=parts[2];
        System.out.println(parts2);
        GenericMethods.clickElement(CheckOutCalender_IMG);
        for(WebElement date: DateCollection ){
            String strobj=date.getText();
            if(parts2.contains(strobj)){
            date.click();
            break;
        }
        }
        GenericMethods.selectElement(Adult_DD, "1");
        GenericMethods.clickElement(CheckAvalibility_BT);
        
        WebGuestSelectRoomPage WSR=PageFactory.initElements(GenericMethods.driver, WebGuestSelectRoomPage.class);
        return WSR;
        }








public void ValidateTitle() throws InterruptedException{
String act=GenericMethods.getText(StayDetailTitle).trim();
Assert.assertEquals("Stay Details", act);
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
