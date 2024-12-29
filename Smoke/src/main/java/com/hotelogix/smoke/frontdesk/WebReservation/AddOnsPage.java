package com.hotelogix.smoke.frontdesk.WebReservation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddOnsPage {

    public static String AddOnsName;


    @FindBy(xpath="//table[@class='tbl-contentNew tbl-addons']//tr[2]//td[3]/strong")
    public static WebElement AddonsName;

    @FindBy(xpath="//input[@name='addInc[]']")
    public static WebElement AddonsName_CB;

    @FindBy(xpath="//input[@value='Add']")
    public static WebElement Add_BT;




    public WebAddMoreRoomPage fn_SelectAddons() throws Exception
    {

        try
        {
           AddOnsName=GenericMethods.getText(AddonsName);
           GenericMethods.clickElement(AddonsName_CB);
           GenericMethods.clickElement(Add_BT);
           WebAddMoreRoomPage WAMR= PageFactory.initElements(GenericMethods.driver, WebAddMoreRoomPage.class);
           return WAMR;
        }
        catch(Exception e)
        {
            throw e;
        }

    }




}