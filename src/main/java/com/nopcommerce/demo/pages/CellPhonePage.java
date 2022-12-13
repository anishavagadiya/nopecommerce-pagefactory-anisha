package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CellPhonePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@class='page-title']/h1[text() = 'Cell phones']")
    WebElement cellphonesText;
    @CacheLookup
    @FindBy(xpath = "//div/a[text()='List']")
    WebElement listView;
    @CacheLookup
    @FindBy(xpath = "//h2/a[text()='Nokia Lumia 1020']")
    WebElement nokiaLumia;

    public CellPhonePage() {
        PageFactory.initElements(driver, this);
    }
    public String verifyCellPhoneText() {
        Reporter.log("Verify cellphone text" + cellphonesText.toString());
        return getTextFromElement(cellphonesText);
    }

    public void clickOnList() {
        Reporter.log("click on list" + listView.toString());
        clickOnElement(listView);
    }

    public void clickOnNokia() throws InterruptedException {
        Reporter.log("click on nokia" + nokiaLumia.toString());
        Thread.sleep(5000);
        clickOnElement(nokiaLumia);
    }


}
