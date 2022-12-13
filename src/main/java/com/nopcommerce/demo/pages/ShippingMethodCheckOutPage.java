package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ShippingMethodCheckOutPage extends Utility {
    @CacheLookup
    @FindBy(id = "shippingoption_1")
    WebElement nextdayAir;

    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]")
    WebElement continuebutton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='shippingoption_2']")
    WebElement secondayAir;

    public ShippingMethodCheckOutPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickOnRedioButtonBextDayAir() {
        Reporter.log("Click on radio button for next day air shipping: "+nextdayAir.toString());
        clickOnElement(nextdayAir);
    }

    public void clickOnContinue() {
        Reporter.log("Click on continue button "+continuebutton.toString());
        clickOnElement(continuebutton);
    }

    public void clickOn2ndDayAir() {
        Reporter.log("Click on 2nd day air shipping: "+secondayAir.toString());
        clickOnElement(secondayAir);
    }



}
