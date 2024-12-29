package com.hotelogix.smoke.admin.PriceManager;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddEditGroupPage {
	public static String gname;
	public static String desc;
	
	
	  private static final String CHAR_LIST ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
      private static final int RANDOM_STRING_LENGTH = 5;
	
	
	

	@FindBy(xpath="//input[@name='groupName']")
	public static WebElement GroupName;   
	
	
	@FindBy(xpath="//td[@class='comments']/textarea")
	public static WebElement Description;   

	
	@FindBy(xpath="	//input[@value='Save']")
	public static WebElement Save_Btn;  
	
	
	
public GroupBookingSource AddingGroup() throws Exception{

gname=AddEditGroupPage.generateRandomString();
	
GenericMethods.sendKeys(GroupName, gname);
desc=AddEditGroupPage.generateRandomString();
		
		GenericMethods.sendKeys(Description, desc);
		GenericMethods.clickElement(Save_Btn);
		
		GroupBookingSource GBS=PageFactory.initElements(GenericMethods.driver, GroupBookingSource.class);
		return GBS;	
}
	
	

 public  static String generateRandomString(){
       
      StringBuffer randStr = new StringBuffer();
      for(int i=0; i<RANDOM_STRING_LENGTH; i++){
          int number = getRandomNumber();
          char ch = CHAR_LIST.charAt(number);
          randStr.append(ch);
      }
      return randStr.toString();
  }

 
 
 
 private static int getRandomNumber() {
      int randomInt = 0;
      Random randomGenerator = new Random();
      randomInt = randomGenerator.nextInt(CHAR_LIST.length());

      if (randomInt - 1 == -1) {
          return randomInt;
      } else {
          return randomInt - 1;
      }
  }
   
	
	
	
}
