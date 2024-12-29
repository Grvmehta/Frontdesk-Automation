package com.hotelogix.smoke.admin.PriceManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddActivationDateTA {
	@FindBy(xpath="//input[@name='chk']")
	public static WebElement activateForever_CB;

	@FindBy(xpath="//input[@name='Submit332']")
	public static WebElement save_BT;

	public static void activateForeverPOPUPmsgPackateTA() throws Exception{
		//GenericMethods.windowHandle(ListOfPackagesTravelAgent.windowID);
		GenericMethods.clickElement(activateForever_CB);
		GenericMethods.clickElement(save_BT);
		String abc=GenericMethods.ActionOnAlert("Dismiss");
	//	System.out.println(abc.length());
	//	System.out.println(abc);
		if(abc.contains("Activating the Package forever will remove all the other Activation dates.")){
			System.out.println("Popup message Matched");
		}
		else{
			System.out.println("not matched");
		}
		Assert.assertEquals(abc.length(), 100);
	}

	public  ListOfPackagesTravelAgent1 activateForeverPackageTA() throws Exception{
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
     
        ListOfPackagesTravelAgent1 LTA1=PageFactory.initElements(GenericMethods.driver, ListOfPackagesTravelAgent1.class);

        return LTA1;
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
