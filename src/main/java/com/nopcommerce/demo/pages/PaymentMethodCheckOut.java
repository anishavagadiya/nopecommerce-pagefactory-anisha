package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PaymentMethodCheckOut extends Utility {
    @CacheLookup
    @FindBy(css = "#paymentmethod_1")
    WebElement creditcard;
    @CacheLookup
    @FindBy(xpath = "//ol[1]/li[4]/div[2]/div[1]/button[1]")
    WebElement continuebutton;

    public PaymentMethodCheckOut() {
        PageFactory.initElements(driver, this);
    }
    public void clickOnCreditCard() {
        Reporter.log("Click on credit card " + creditcard.toString());
        clickOnElement(creditcard);
    }

    public void clickOnContinue() {
        Reporter.log("Click on continue button " + continuebutton.toString());
        clickOnElement(continuebutton);
    }




}
