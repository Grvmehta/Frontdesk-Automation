package com.hotelogix.smoke.admin.PriceManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

import junit.framework.Assert;

public class AddActivationDateFD {

    @FindBy(xpath="//table[@class='table-content']//td[3]//input")
    public static WebElement activateForever_CB;

    @FindBy(xpath="//input[@name='Submit332']")
    public static WebElement save_BT;

    public ListOfPackagesFrontdesk activateForeverPackateFD() throws Exception
    {
    	try
    	{
       
        GenericMethods.clickElement(activateForever_CB);
        GenericMethods.clickElement(save_BT);
        Thread.sleep(3000);
        String abc=GenericMethods.ActionOnAlert("Accept");
        System.out.println(abc);
        String def="Activating the Package forever will remove all the other Activation dates.\n"+
				 " Do you wish to continue?";
        Assert.assertEquals(abc, def);
     
        ListOfPackagesFrontdesk pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesFrontdesk.class);

        return pageobj;
    	}
    	catch(AssertionError e)
    	{
    		throw e;
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}
    }
}

