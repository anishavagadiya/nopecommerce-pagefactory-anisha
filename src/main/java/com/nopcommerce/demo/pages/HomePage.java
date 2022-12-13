package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktop;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Welcome to our store')]")
    WebElement welcomeText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logoutButton;
    @CacheLookup
    @FindBy(xpath = "//div/ul[@class='top-menu notmobile']/li[2]/a[@href='/electronics']")
    WebElement electronicMouseHover;
    @CacheLookup
    @FindBy(xpath = "//body[1]/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]")
    WebElement cellPhoneClick;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    public void selectMenu(String menu) {
        String mainmenu = menu.toLowerCase();
        String expression = "//a[@href ='/" + mainmenu + "']";
        driver.findElement(By.xpath(expression)).click();
        String currentUrl = driver.getCurrentUrl();
        //  Assert.assertEquals("Navigated successfully", currentUrl,"Do not Navigate" + menu);

    }

    public void clickOnDeskTop() {
        Reporter.log("Click on Desktop" + desktop.toString());
        clickOnElement(desktop);
    }

    public void mouseHoverOnElectronics() {
        Reporter.log("Mouse hover on electronics" + electronicMouseHover.toString());
        mouseHoverToElement(electronicMouseHover);

    }

    public void mouseHoverOnCellPhoneAndClick() {
        Reporter.log("click on cellphone" + cellPhoneClick.toString());
        mouseHoverToElementAndClick(cellPhoneClick);

    }

    public String verifyWelComeText() {
        Reporter.log("Verify welcome Text" + welcomeText.toString());
        return getTextFromElement(welcomeText);
    }

    public void clickOnLogOut() {
        Reporter.log("Click on Logout" + logoutButton.toString());
        clickOnElement(logoutButton);
    }


}
