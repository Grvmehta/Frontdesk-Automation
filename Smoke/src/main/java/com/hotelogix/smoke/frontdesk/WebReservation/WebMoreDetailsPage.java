package com.hotelogix.smoke.frontdesk.WebReservation;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


import com.hotelogix.smoke.genericandbase.GenericMethods;

public class WebMoreDetailsPage
{
    @FindBy(xpath="//form[@id='frmWebRes']//table//tr[7]//td[@class='lineheight18']//span[2]")
    public static WebElement price;

    @FindBy(xpath="//table[@class='tbl-contentNew']//table//tr//td[2]//strong")
	public static WebElement Price_Text;

    @FindBy(xpath="//span[@class='avg-rate']")
    public static WebElement AvgRate;

    public static int Price;

    public int fn_VerifyDiscount() throws Exception
    {
        try{
        String sobj=GenericMethods.getText(price);
        String Disobj =sobj.substring(3, 5);
        int price=Integer.parseInt(Disobj);
        String Disobj1 =WebSelectRoomPage.discPrice.substring(23, 25);
        int percent=Integer.parseInt(Disobj1);
        Integer dis=WebReservationHomePage.fn_CheckTax(price, percent);
        Integer acu=price-dis;
        String sab=acu.toString();
        String DiscountPrirce=GenericMethods.getText(AvgRate);
        String abc=DiscountPrirce.substring(22, 25);
        Assert.assertEquals(abc.trim(), sab);
        }catch(Exception e){
            throw e;
        }
        return Price;
    }


    public void fn_verifyPriceDisc() throws Exception
    {
    	try
    	{
    	String a=WebSelectRoomPage.discPrice.trim();
    	//System.out.println(a.trim());
    	String text=GenericMethods.getText(price);
    	System.out.println(text);
    	Assert.assertTrue(text.contains(WebSelectRoomPage.pPrice));
    	Assert.assertTrue(text.contains(a));
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}
    	catch(AssertionError e)
    	{
    		throw e;
    	}
    }

}
