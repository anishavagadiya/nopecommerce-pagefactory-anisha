package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.basetest.BaseTest;
import com.nopcommerce.demo.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

public class ComputerTest extends BaseTest {
    HomePage homePage;
    DeskTopPage deskTopPage;
    BuildYourComputerPage buildYourOwnComputerPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutAsGuestPage checkOutAsGuestPage;
    BillingCheckOutPage checkOutPage;
    ShippingMethodCheckOutPage checkoutPage1;
    PaymentMethodCheckOut checkOutPage2;
    PaymentCheckOut checkOutPage3;
    ConfirmOrderPage confirmOrderPage;
    CompletedCheckoutPage completedCheckoutPage;

    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        deskTopPage = new DeskTopPage();
        buildYourOwnComputerPage = new BuildYourComputerPage();
        shoppingCartPage = new ShoppingCartPage();
        checkOutAsGuestPage = new CheckOutAsGuestPage();
        checkOutPage = new BillingCheckOutPage();
        checkoutPage1 = new ShippingMethodCheckOutPage();
        checkOutPage2 = new PaymentMethodCheckOut();
        checkOutPage3 = new PaymentCheckOut();
        confirmOrderPage = new ConfirmOrderPage();
        completedCheckoutPage = new CompletedCheckoutPage();
    }
    @Test(groups = {"sanity","regression"})
    public void verifyProductArrangeInAlphaBaticalOrder() {
        homePage.selectMenu("computers");
        homePage.clickOnDeskTop();
        deskTopPage.selectSortByName("Name: Z to A");
        Map<String, ArrayList> mapArrays = deskTopPage.arrangeProductInDescendingOrder();
        Assert.assertEquals(mapArrays.get("originalProductsName"), mapArrays.get("afterSortByZToAProductsName"));
    }

    @Test(groups = { "smoke","regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homePage.selectMenu("computers");
        homePage.clickOnDeskTop();
        Thread.sleep(5000);
        deskTopPage.selectSortByName("Name: A to Z");
        Thread.sleep(5000);
        deskTopPage.clickOnAddToCart();
        Assert.assertEquals(buildYourOwnComputerPage.VerifytheTextBuildyourowncomputer(),"Build your own computer" , "Text is not Display");
        buildYourOwnComputerPage.selectProcessor("1");
        buildYourOwnComputerPage.selectRam("5");
        buildYourOwnComputerPage.selectHDDRadio();
        buildYourOwnComputerPage.selectOSRadiVistaPremium();
        buildYourOwnComputerPage.selectSoftware();
        Thread.sleep(5000);
        Assert.assertEquals(buildYourOwnComputerPage.VerifythePrice(),"$1,475.00" , "Price is not match");
        buildYourOwnComputerPage.clickOnAddToCartButton();
        Thread.sleep(5000);
        Assert.assertEquals(buildYourOwnComputerPage.VerifytheMessageOnTopGreenbar(),"The product has been added to your shopping cart","Message doesnot match");
        buildYourOwnComputerPage.clickOnCloseBar();
        buildYourOwnComputerPage.mouseHoverOnShoppingCart();
        buildYourOwnComputerPage.clickOnShoppingCart();
        Assert.assertEquals(shoppingCartPage.verifyTheShoppingCartText(),"Shopping cart","Text is not display");
        shoppingCartPage.updateQuantity();
        Thread.sleep(5000);
        shoppingCartPage.updateShoppingCart();
        Assert.assertEquals(shoppingCartPage.verifyTheTotalPrice(),"$2,950.00","Price is not match");
        shoppingCartPage.clickOnCheckBox();
        shoppingCartPage.clickOnCheckOutButton();
        Assert.assertEquals(checkOutAsGuestPage.VerifytheWelComeText(),"Welcome, Please Sign In!","Text is not matched");
        checkOutAsGuestPage.clickOnAsGuestButton();
        //Fill ALl Fields
        checkOutPage.enterBillingFirstName("John");
        checkOutPage.enterBillingLastName("Smith");
        checkOutPage.enterBillingEmailAddress("john@example.com");
        checkOutPage.selectCountryFromDropDown("233");
        checkOutPage.selectStateFromDropDown("0");
        checkOutPage.enterBillingCity("London");
        checkOutPage.enterBillingAddress("4,Oxford Street");
        checkOutPage.enterBillingZipcode("W2 4TR");
        checkOutPage.enterBillingPhoneNumber("5665995116994");
        checkOutPage.clickOnCheckOutButton();
        Thread.sleep(5000);
        checkoutPage1.clickOnRedioButtonBextDayAir();
        checkoutPage1.clickOnContinue();
        checkOutPage2.clickOnCreditCard();
        checkOutPage2.clickOnContinue();
        checkOutPage3.enterCardHolderName("John Smith");
        checkOutPage3.enterCardNumber("5555555555554444");
        checkOutPage3.selectExpiryMonthFromDropDown("5");
        checkOutPage3.selectExpiryYearFromDropDown("2024");
        checkOutPage3.enterCardCode("3101");
        checkOutPage3.clickOnContinueButton();
        Assert.assertEquals(confirmOrderPage.VerifyCreditCardPaymentMethod(),"Credit Card","Method is not correct");
        Assert.assertEquals(confirmOrderPage.verifyShippingMethod(),"Next Day Air","method is not correct");
        Assert.assertEquals(confirmOrderPage.verifytheTotalPrice(),"$2,950.00","Price is not Match");
        confirmOrderPage.clickOnConFirm();
        Assert.assertEquals(completedCheckoutPage.verifyThankYouText(),"Thank you","Text isnot Display");
        Assert.assertEquals(completedCheckoutPage.verifySucessOrderText(),"Your order has been successfully processed!","Text isnot Display");
        completedCheckoutPage.clickOnContinue();
        Assert.assertEquals(homePage.verifyWelComeText(),"Welcome to our store","Text isnot Display");

    }
}
