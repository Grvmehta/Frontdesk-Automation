package com.hotelogix.smoke.hmsadmine.login;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;

import junit.framework.Assert;

public class ImportCsvPage {
	
	@FindBy(xpath="//input[@name='file']")
	public WebElement chooseFileBtn;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement submitBtn;
	
	
	@FindBy(xpath="//input[@id='validationAll']")
	public WebElement validateBtn;
	
	@FindBy(xpath="/html/body/table/tbody/tr[3]/td/table/tbody/tr[1]/td")
	public WebElement titleTxt;
	
	
	@FindBy(xpath="//input[@id='importRsv']")
	public WebElement importBtn;
	
	
	@FindBy(xpath="//input[@id='importRsv']")
	public WebElement filenameTxt;
	
	@FindBy(xpath="//input[@type='file']")
	public WebElement fileNameTxt;
	
	@FindBy(xpath="//div[@id='progressbar']")
	public WebElement loadingelementProgressBar;
	
	@FindBy(xpath="//tbody/tr[3]/td/table/tbody/tr[2]/td")
	public WebElement successMsg;
	
	//tbody/tr[3]/td/table/tbody/tr[2]/td
	
	
	
	
	
	public String parentID="";
	
	
public	ImportCsvPage()
{
	PageFactory.initElements(GenericMethods.driver,this);
}

public void clickingChooseFile(int iTestCaseRow,String expected) throws Exception
{
try
{
	parentID=GenericMethods.GetCurrentWindowID();
	//GenericMethods.driver.close();
	GenericMethods.windowHandle(parentID);
	
	
	String text=	GenericMethods.getText(titleTxt);
	System.out.println("Title::::::"+text);
	Assert.assertEquals(text, "Upload Csv");

	
	
	
	/*Set<String> handles4=GenericMethods. driver.getWindowHandles();
	//handles4.remove(ParentID);
	GenericMethods.driver.switchTo().window(handles4.iterator().next());
	Thread.sleep(2000);
	
	*/
		//GenericMethods.clickElement(chooseFileBtn);
		
		GenericMethods.sendKeys(chooseFileBtn, "C:\\Users\\Gaurav\\Desktop\\bookingImportTraining.csv");
		
		Thread.sleep(2000);
		
	//String fileNameTxt=	handlingFileUpload();
	System.out.println("fileNameTxt::::::::::::::::::"+fileNameTxt);
	//	Assert.assertEquals(expected,fileNameTxt);
		//GenericMethods.getText(filenameTxt);
		
		//Thread.sleep(4000);
		GenericMethods.clickElement(submitBtn);
		
		Thread.sleep(2000);
		
		String text1=	GenericMethods.getText(titleTxt);
		System.out.println("Title2::::::"+text1);
		Assert.assertEquals(text1, "Upload Csv > Csv Listing");
		
		GenericMethods.clickElement(validateBtn);
		
		WebDriverWait wait = new WebDriverWait(GenericMethods.driver,30);


		wait.until(ExpectedConditions.invisibilityOf(loadingelementProgressBar));
		
		/* final WebElement we= GenericMethods.getWebElement("Hotelogix_progressbar");
		   WebDriverWait wait=new WebDriverWait(GenericMethods.driver, 200);
		   wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		   wait.until(new ExpectedCondition<Boolean>() {
			    public Boolean apply(WebDriver driver) {
			    	driver=GenericMethods.driver;
			    	boolean result=false;
			    		System.out.println(we.getAttribute("aria-valuenow"));
			        if(we.getAttribute("aria-valuenow").equals("100"))
			        {
			        	System.out.println("in if::::::"+we.getAttribute("aria-valuenow"));
			        	result=true;
			        	//break;
			        	//return true;
			        }
					return result;
					
			 
			    	//return result;
			    }
			});
		*/   
		Thread.sleep(2000);
		
		GenericMethods.clickElement(importBtn);
		

		WebDriverWait wait1 = new WebDriverWait(GenericMethods.driver,30);


		wait1.until(ExpectedConditions.invisibilityOf(loadingelementProgressBar));

		
		Thread.sleep(8000);
		
		wait1.until(ExpectedConditions.visibilityOf(successMsg));
		
		Thread.sleep(2000);
		
	String s5=	GenericMethods.getText(successMsg);
		System.out.println("msg text:::"+s5);
		
	Assert.assertEquals("RESERVATION CREATED SUCCESSFULLY", s5);
		//Thread.sleep(30000);
		
		/*GenericMethods.driver.close();
		
		Thread.sleep(3000);
		
		GenericMethods.Switch_Parent_Window(parentID);*/
}
catch(Exception e)
{
	GenericMethods.driver.close();
	
	GenericMethods.Switch_Parent_Window(parentID);
		e.printStackTrace();
	throw e;
}

finally
{
	
	System.out.println("In finally block");
GenericMethods.driver.close();
Thread.sleep(2000);	
GenericMethods.Switch_Parent_Window(parentID);

}
}

public String handlingFileUpload() throws Exception
{
	try
	{	 
		Robot rb = new Robot();
	
	 
	    // copying File path to Clipboard
	    StringSelection str = new StringSelection("C:\\Users\\Gaurav\\Desktop\\bookingImportTraining.csv");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	 
	     // press Contol+V for pasting
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	 Thread.sleep(2000);
	 
	 rb.keyPress(KeyEvent.VK_ENTER);
	 rb.keyRelease(KeyEvent.VK_ENTER);
	    // for pressing and releasing Enter
	    
	 rb.keyPress(KeyEvent.VK_TAB);
	 rb.keyRelease(KeyEvent.VK_TAB);
	 
	 Thread.sleep(2000);
	 
	 rb.keyPress(KeyEvent.VK_TAB);
	 rb.keyRelease(KeyEvent.VK_TAB);
	 
	 Thread.sleep(2000);
	 
	 rb.keyPress(KeyEvent.VK_ENTER);
	 rb.keyRelease(KeyEvent.VK_ENTER);
	   
	    Thread.sleep(2000);
	   String name= GenericMethods.getText(fileNameTxt);
	    System.out.println("name::::::::::::"+name);
	   	 return name;
	}
	catch(Exception e)
	{
		throw e;
	}
}






}
