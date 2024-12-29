package com.hotelogix.smoke.admin.General;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddTaxExemptReasonPage {

	@FindBy(xpath="//input[@name='title']")
	public WebElement TxtBx_Reason;

	@FindBy(xpath="//textarea[@name='description']")
	public WebElement TxtBx_Description;


	@FindBy(xpath="//input[@value='Save']")
	public WebElement Btn_SaveReason;
	
	
	
	public void fn_AddReason(int iTestCaseRow) throws Exception{
		try{
				
		GenericMethods.sendKeys(TxtBx_Reason, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ReasonForTaxExempt)));
		GenericMethods.clickElement(Btn_SaveReason);		
		}
		catch(Exception e){
		throw e;
		}
		}
}
