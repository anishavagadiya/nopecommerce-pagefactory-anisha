package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NokiaLumiaPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Nokia Lumia 1020')]")
    WebElement nokiaText;

    @CacheLookup
    @FindBy(xpath = "//span[@id='price-value-20']")
    WebElement nokiaPrice;

    @CacheLookup
    @FindBy(css = "#product_enteredQuantity_20")
    WebElement changeqty;

    @CacheLookup
    @FindBy(css = "#add-to-cart-button-20")
    WebElement nokiaAddToCart;

    @CacheLookup
    @FindBy(xpath = "//body/div[@id='bar-notification']/div[1]/p[1]")
    WebElement productAddedText;

    @CacheLookup
    @FindBy(xpath = "//body/div[@id='bar-notification']/div[1]/span[1]")
    WebElement clickOnXButton;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping cart')]")
    WebElement mouseHoverShoppingCart;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Go to cart')]")
    WebElement clickOnCart;

    public NokiaLumiaPage() {
        PageFactory.initElements(driver, this);
    }
    public String verifyNokiaLumiaText() {
        Reporter.log("Verify Nokia Lumia Text: " + nokiaText.toString());
        return getTextFromElement(nokiaText);
    }

    public String verifyPrice() {
        Reporter.log("Verify the price " + nokiaPrice.toString());
        return getTextFromElement(nokiaPrice);
    }

    public void updateNokiaQuantity(String qty) {
        Reporter.log("Update the product quantity " +changeqty.toString());
        //driver.findElement(changeqty).clear();
        changeqty.clear();
        sendTextToElement(changeqty, qty);
    }

    public void nokiaAddToCartButton() {
        Reporter.log("Click on Nokia to cart " + nokiaAddToCart.toString());
        clickOnElement(nokiaAddToCart);
    }

    public String verifyProductAddedToTheCartMessage() {
        Reporter.log("Verify the text product to the cart " + productAddedText.toString());
        return getTextFromElement(productAddedText);
    }

    public void clickOnCrossButton() {
        Reporter.log("Click on cross button to cancel " + clickOnXButton.toString());
        clickOnElement(clickOnXButton);
    }

    public void clickOnShoppingCart() {
        Reporter.log("Mouse Hover to shopping cart " + mouseHoverShoppingCart.toString());
        mouseHoverToElement(mouseHoverShoppingCart);
        Reporter.log("Click on cart button " + clickOnCart.toString());
        clickOnElement(clickOnCart);
    }



}
