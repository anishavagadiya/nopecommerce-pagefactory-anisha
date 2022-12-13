package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PaymentCheckOut extends Utility {
    @CacheLookup
    @FindBy(id = "CreditCardType")
    WebElement cardType;
    @CacheLookup
    @FindBy(id = "CardholderName")
    WebElement cardHolderNameField;
    @CacheLookup
    @FindBy(id = "CardNumber")
    WebElement cardNumberField;
    @CacheLookup
    @FindBy(id = "ExpireMonth")
    WebElement expireMonthField;
    @CacheLookup
    @FindBy(id = "ExpireYear")
    WebElement expireYearField;
    @CacheLookup
    @FindBy(id = "CardCode")
    WebElement cardCodeField;
    @CacheLookup
    @FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']")
    WebElement continuebutton;

    public PaymentCheckOut() {
        PageFactory.initElements(driver, this);
    }
    public void selectCardTypeFromDropDown(String text) {
        Reporter.log("Select card from drop down " +cardType.toString());
        selectByValueFromDropDown(cardType, text);
    }

    public void enterCardHolderName(String text) {
        Reporter.log("Enter the cardholder name in name field "+cardHolderNameField.toString());
        sendTextToElement(cardHolderNameField, text);
    }

    public void enterCardNumber(String text) {
        Reporter.log("Enter the card number in number field "+cardNumberField.toString());
        sendTextToElement(cardNumberField, text);
    }

    public void selectExpiryMonthFromDropDown(String text) {
        Reporter.log("Select the expiry month from list " +expireMonthField.toString());
        selectByValueFromDropDown(expireMonthField, text);
    }

    public void selectExpiryYearFromDropDown(String text) {
        Reporter.log("Select the expiry year from list "+expireYearField.toString());
        selectByValueFromDropDown(expireYearField, text);
    }

    public void enterCardCode(String text) {
        Reporter.log("Enter card code "+cardCodeField.toString());
        sendTextToElement(cardCodeField, text);
    }

    public void clickOnContinueButton() {
        Reporter.log("Click on continue button " +continuebutton.toString());
        clickOnElement(continuebutton);
    }



}
