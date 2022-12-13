package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class RegisterPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement registerText;

    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "LastName")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailID;

    @CacheLookup
    @FindBy(id = "Password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;

    @CacheLookup
    @FindBy(id = "register-button")
    WebElement register;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement registration;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]")
    WebElement continueTab;

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }
    public String verifyRegisterText() {
        Reporter.log("Verify register text: "+registerText.toString());
        return getTextFromElement(registerText);
    }

    public void enterFirstName(String text) {
        Reporter.log("Enter the first name to field "+firstName.toString());
        sendTextToElement(firstName, text + getAlphaNumericString(5));
    }

    public void enterLastName(String text) {
        Reporter.log("Enter the last name to field " +lastName.toString());
        sendTextToElement(lastName, text + getAlphaNumericString(5));
    }

    public void email(String text) {
        Reporter.log("Enter the email to email field " +emailID.toString());
        sendTextToElement(emailID, text);
    }

    public void enterPassword(String text) {
        Reporter.log("Enter the password to password field " +password.toString());
        sendTextToElement(password, text);
    }

    public void enterConfirmPassword(String text) {
        Reporter.log("Enter the confirm password " +confirmPassword.toString());
        sendTextToElement(confirmPassword, text);
    }

    public void clickOnRegisterButton() {
        Reporter.log("Click in register button " +register.toString());
        clickOnElement(register);
    }

    public String verifyRegistration() {
        Reporter.log("Verify the registration " +registration.toString());
        return getTextFromElement(registration);
    }

    public void clickOnContinue() {
        Reporter.log("Click on continue button " +continueButton.toString());
        clickOnElement(continueButton);
    }

    public void clickOnContinueTab() {
        Reporter.log("Click on continue tab " +continueTab.toString());
        clickOnElement(continueTab);
    }



}
