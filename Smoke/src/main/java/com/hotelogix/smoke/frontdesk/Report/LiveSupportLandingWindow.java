package com.hotelogix.smoke.frontdesk.Report;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


import com.hotelogix.smoke.genericandbase.GenericMethods;

public class LiveSupportLandingWindow {


	@FindBy(xpath="//iframe[@id='lz_chat_content']")
    public static WebElement iframe_ID;

    @FindBy(xpath="//li[contains(.,'Leave a Message')]")
    public static WebElement LeaveaMessage_Tab;

    @FindBy(xpath="//table[@id='lz_form_111']//input")
    public static WebElement Name_ED;

    @FindBy(xpath="//table[@id='lz_form_112']//input")
    public static WebElement Email_ED;

    @FindBy(xpath="//table[@id='lz_form_113']//input")
    public static WebElement Company_ED;

    @FindBy(xpath="//table[@id='lz_form_114']//textarea")
    public static WebElement YourQuestion_ED;

    @FindBy(xpath="//select[@id='lz_form_groups']")
    public static WebElement Department_DD;

    @FindBy(xpath="//input[@id='lz_action_button']")
    public static WebElement StartChat_BT;






	public String fn_ValidateTitle() throws Exception{

   	 try{

   		return  GenericMethods.driver.getTitle();
   	
   	
   	 }catch(Exception e){
   		 throw e;
   	 }

     }



	public void fn_ValidateAllLeaveaMessageElements() throws Exception
	  {

	    	 try{
	    		 GenericMethods.fn_switchiframe(iframe_ID);
	    		 GenericMethods.clickElement(LeaveaMessage_Tab);
	    	 boolean name=GenericMethods.isEnable("Name EditBox", Name_ED);
	    	 Assert.assertEquals(name, true);
	    	 boolean email=GenericMethods.isEnable("Email EditBox", Email_ED);
	    	 Assert.assertEquals(email, true);
	    	 boolean company=GenericMethods.isEnable("Company EditBox", Company_ED);
	    	 Assert.assertEquals(company, true);
	    	 boolean YourQuestion=GenericMethods.isEnable("YourQuestion EditBox", YourQuestion_ED);
	    	 Assert.assertEquals(YourQuestion, true);
	    	 boolean Department=GenericMethods.isEnable("Department DropDown", Department_DD);
	    	 Assert.assertEquals(Department, true);
	    	 boolean StartChat=GenericMethods.isEnable("StartChat Button", StartChat_BT);
	    	 Assert.assertEquals(StartChat, true);
	    	 GenericMethods.fn_defaultcontentofiframe();
	    	 }catch(Exception e){
	    		 throw e;
	    	 }
	         }


	public void fn_ValidateAllLiveChatElements() throws Exception
	{

   	 try{
   		 GenericMethods.fn_switchiframe(iframe_ID);
   	 boolean name=GenericMethods.isEnable("Name EditBox", Name_ED);
   	 Assert.assertEquals(name, true);
   	 boolean email=GenericMethods.isEnable("Email EditBox", Email_ED);
   	 Assert.assertEquals(email, true);
   	 boolean company=GenericMethods.isEnable("Company EditBox", Company_ED);
   	 Assert.assertEquals(company, true);
   	 boolean YourQuestion=GenericMethods.isEnable("YourQuestion EditBox", YourQuestion_ED);
   	 Assert.assertEquals(YourQuestion, true);
   	 boolean Department=GenericMethods.isEnable("Department DropDown", Department_DD);
   	 Assert.assertEquals(Department, true);
   	 boolean StartChat=GenericMethods.isEnable("StartChat Button", StartChat_BT);
   	 Assert.assertEquals(StartChat, true);
   	 GenericMethods.fn_defaultcontentofiframe();
   	 }
   	 catch(Exception e)
   	 {
   		 throw e;
   	 }

	}


}
