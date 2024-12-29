package com.hotelogix.smoke.frontdesk.CashCounter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.frontdesk.CashCounter.CashCounterPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class FrontdeskContinueTrialPage
{

public 	FrontdeskContinueTrialPage()
{
    	PageFactory.initElements(GenericMethods.driver, SpanishXpath.class);
}
public static String text="Another user with the same username is already logged in to the system. Would you like to continue?";


    @FindBy(xpath="//a[text()='Continue with Trial']")
    public static WebElement CountinueWithTrail_BT;

    @FindBy(xpath="//td[@class='contentarea05']")
    public static WebElement text_TX;

    @FindBy(xpath="//td[@class='contentarea05']//a")
    public static WebElement Yes_BT;

public static class SpanishXpath
{
	@FindBy(xpath="//a[text()='Continuar con la versión de prueba']")
    public static WebElement CountinueWithTrail_BT;

}



    public CashCounterPage fn_ClickCountinueWithTrail_BT() throws Exception
    {
    	try
    	{
        String str=GenericMethods.driver.getCurrentUrl();
        if(str.contains("confirmation")) {
        	//Assert.assertEquals(str.contains(text), true);
        	GenericMethods.clickElement(Yes_BT);
        }
        GenericMethods.clickElement(CountinueWithTrail_BT);
        GenericMethods.driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
        } catch(Exception e){
        	throw e;
    	}
    	 CashCounterPage AHO = PageFactory.initElements(GenericMethods.driver, CashCounterPage.class);
         return AHO;
    }





}
