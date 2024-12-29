package com.hotelogix.smoke.admin.General;

import java.awt.print.Pageable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class TaxExemptListPage {
	
	
	
	
@FindBy(xpath="//td[text()='No Entries Found']")
public WebElement Text_NoEntriesFound;


@FindBy(xpath="//a[text()='Add a Reason ']")
public WebElement Link_AddAReason;


@FindBy(xpath="//select[@name='maxEntries']")
public WebElement DD_View;


@FindBy(xpath="//input[@name='title']")
public WebElement TxtBx_Reason;

@FindBy(xpath="//textarea[@name='description']")
public WebElement TxtBx_Description;


@FindBy(xpath="//input[@value='Save']")
public WebElement Btn_SaveReason;


@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr[2]/td[1]")
public WebElement Txt_DataInFirstRow;


public AddTaxExemptReasonPage fn_clkAddTaxExempt() throws Exception{
	try{
	GenericMethods.clickElement(Link_AddAReason);
	
	AddTaxExemptReasonPage ATE=PageFactory.initElements(GenericMethods.driver, AddTaxExemptReasonPage.class);
	return ATE;
	}catch(Exception e){
		throw e;
	}
}



public void fn_verifyTaxExemptReason(int iTestCaseRow) throws Exception{
try{
	
	GenericMethods.selectElement(DD_View, "All");
	GenericMethods.ActionOnAlert("Accept");
	
if(Txt_DataInFirstRow.getText().equals("No Entries Found")){
fn_AddReason(iTestCaseRow);
	
}
else if(Txt_DataInFirstRow.getText().equals("1")) {
	Reporter.log("This is the prerequisite as we need reason to tax exempt and the reason is already is there. ", true);
	
}
	
}
catch(Exception e){
throw e;
}
}

public void fn_AddReason(int iTestCaseRow) throws Exception{
	try{
			
	GenericMethods.clickElement(Link_AddAReason);
	GenericMethods.sendKeys(TxtBx_Reason, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ReasonForTaxExempt)));
	GenericMethods.clickElement(Btn_SaveReason);		
	}
	catch(Exception e){
	throw e;
	}
	}



public void fn_verifyTERCount(int iTestCaseRow) throws Exception{
	try{
	String str=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr[2]/td")).getText();
	if(str.equals("No Entries Found")==true){
		AddTaxExemptReasonPage ATE=fn_clkAddTaxExempt();
		ATE.fn_AddReason(ExcelUtil.getCellData_intData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	}
	}catch(Exception e){
		throw e;
	}
}
	

}
