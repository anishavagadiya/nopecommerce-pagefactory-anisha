package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BillingCheckOutPage extends Utility {
    @CacheLookup
    @FindBy(id = "BillingNewAddress_FirstName")
    WebElement firstNamefield;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_LastName")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_Email")
    WebElement emailAddressField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement countryField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_StateProvinceId")
    WebElement stateField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_City")
    WebElement cityField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement addressField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipCodeField;
    @CacheLookup
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumberField;
    @CacheLookup
    @FindBy(xpath = "//div[1]/button[4]")
    WebElement checkout;

    public BillingCheckOutPage() {
        PageFactory.initElements(driver, this);
    }
    public void enterBillingFirstName(String text) {
        Reporter.log("Enter First name " + text + " to firstname field " + firstNamefield.toString());

        sendTextToElement(firstNamefield, text);
    }

    public void enterBillingLastName(String text) {
        Reporter.log("Enter Lastname " + text + " to lastname field " + lastNameField.toString());
        sendTextToElement(lastNameField, text);
    }

    public void enterBillingEmailAddress(String text) {
        Reporter.log("Enter Email " + text + " to Email field " + emailAddressField.toString());
        sendTextToElement(emailAddressField, text);
    }

    public void selectCountryFromDropDown(String text) {
        Reporter.log("Enter Country " + text + " to country field " + countryField.toString());
        selectByValueFromDropDown(countryField, text);
    }

    public void selectStateFromDropDown(String text) {
        Reporter.log("Enter StateField " + text + " to State field " + stateField.toString());

        selectByValueFromDropDown(stateField, text);
    }

    public void enterBillingCity(String text) {
        Reporter.log("Enter city " + text + " to city field " + cityField.toString());
        sendTextToElement(cityField, text);
    }

    public void enterBillingAddress(String text) {
        Reporter.log("Enter Address " + text + " to Address field " + addressField.toString());
        sendTextToElement(addressField, text);
    }

    public void enterBillingZipcode(String text) {
        Reporter.log("Enter Zipcode " + text + " to Zipcode field " + zipCodeField.toString());
        sendTextToElement(zipCodeField, text);
    }

    public void enterBillingPhoneNumber(String text) {
        Reporter.log("Enter PhoneNumber " + text + " to Phonenumber field " + phoneNumberField.toString());
        sendTextToElement(phoneNumberField, text);
    }

    public void clickOnCheckOutButton() {
        Reporter.log("Click on checkout Button " + checkout.toString());
        clickOnElement(checkout);
    }


}
