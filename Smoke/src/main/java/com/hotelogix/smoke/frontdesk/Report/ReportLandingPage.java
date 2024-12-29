package com.hotelogix.smoke.frontdesk.Report;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ReportLandingPage {

	@FindBy(xpath="//strong[text()='Occupancy Report']")
	public static WebElement OccupancyReport_BT;

	@FindBy(xpath="//strong[text()='Revenue Report']")
	public static WebElement RevenueReport_BT;

	@FindBy(xpath="//a[text()='House Count Report']")
	public static WebElement HouseCountReport_BT;  //

	@FindBy(xpath="//span[text()='House Count Report']")
	public static WebElement HouseCountReport_TITLE;

	@FindBy(xpath="//input[@id='txtSearchDateTo']")
	public static WebElement DateTextTo;

	@FindBy(xpath="//strong[text()='Financial Report ']")
	public static WebElement FinancialReport_BT;

	@FindBy(xpath="//a[text()='Monthly Summary Report']")
	public static WebElement MonthlySummaryReport_Link;

	@FindBy(xpath="//a[text()='Cashier Report']")
	public static WebElement CashierReport_Link;


	@FindBy(xpath="//strong[text()='Discount Report']")
	public static WebElement DiscountReport_BT;

	@FindBy(xpath="//a[text()='Discounts/Allowance Given']")
	public static WebElement DiscountAllowance_Link;

	@FindBy(xpath="//strong[text()='POS Report']")
	public static WebElement POSReport_BT;

	@FindBy(xpath="//a[text()='Daily Sales Report']")
	public static WebElement DailySalesReport_Link;

	@FindBy(xpath="//strong[text()='Reservation Report']")
	public static WebElement ReservationReport_BT;

	@FindBy(xpath="//a[text()='No Show Report']")
	public static WebElement NoShowReport_Link;

	public void fn_VerifyReportPage() throws Exception
	{
		try
		{
		String str=GenericMethods.driver.getTitle();
		Assert.assertEquals(str, "Reports");
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

	public void fn_ClickOFinancialReport() throws Exception
	{
		try
		{
		GenericMethods.clickElement(FinancialReport_BT);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public FRMonthlySummeryReport fn_ClickMonthlySummaryReport_BT() throws Exception
	{
		try
		{
		GenericMethods.clickElement(MonthlySummaryReport_Link);
		FRMonthlySummeryReport MSR=PageFactory.initElements(GenericMethods.driver, FRMonthlySummeryReport.class);
		return MSR;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public void fn_ClickOccupancyReport() throws Exception
	{
		try
		{
		GenericMethods.clickElement(OccupancyReport_BT);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public ORHouseCountReport fn_ClickHouseCountReport() throws Exception
	{
		try
		{
		GenericMethods.clickElement(HouseCountReport_BT);
		ORHouseCountReport HCR=PageFactory.initElements(GenericMethods.driver, ORHouseCountReport.class);
		return HCR;
		}
		catch(Exception e)
		{
			throw e;
		}

	}

	public void fn_ClickRevenueReport() throws Exception
	{
		try
		{
		GenericMethods.clickElement(RevenueReport_BT);
		}
		catch(Exception e)
	      {
			throw e;
	     }

	}


	public CashierReportPage fn_ClickCashierReport() throws Exception
	{
		try
		{
		GenericMethods.clickElement(CashierReport_Link);
		CashierReportPage CR=PageFactory.initElements(GenericMethods.driver, CashierReportPage.class);
		return CR;
		}
		catch(Exception e)
		{
			throw e;
		}

	}

	public void fn_DiscountReport() throws Exception
	{
		try
		{
		GenericMethods.clickElement(DiscountReport_BT);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public DiscountAllowanceReportPage fn_DiscountAllowance_Link() throws Exception
	{
		try
		{
		GenericMethods.clickElement(DiscountAllowance_Link);
		DiscountAllowanceReportPage DAR=PageFactory.initElements(GenericMethods.driver, DiscountAllowanceReportPage.class);
		return DAR;
		}
		catch(Exception e)
		{
			throw e;
		}

	}

	public void fn_POSReport() throws Exception{
		GenericMethods.clickElement(POSReport_BT);
	}

	public DailySalesReportPage fn_DailySalesReport_Link() throws Exception{
		GenericMethods.clickElement(DailySalesReport_Link);
		DailySalesReportPage DSR=PageFactory.initElements(GenericMethods.driver, DailySalesReportPage.class);
		return DSR;

	}

	public void fn_ReservationReport() throws Exception
	{
		try
		{
		GenericMethods.clickElement(ReservationReport_BT);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public NoShowReportPage fn_NoShowReport_Link() throws Exception
	{
		try
		{
		GenericMethods.clickElement(NoShowReport_Link);
		NoShowReportPage DSR=PageFactory.initElements(GenericMethods.driver, NoShowReportPage.class);
		return DSR;
		}
		catch(Exception e)
		{
			throw e;
		}

	}



}