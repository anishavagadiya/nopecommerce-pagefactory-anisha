package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.basetest.BaseTest;
import com.nopcommerce.demo.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyPageNavigation() {
        mouseHoverToElement(By.xpath("//a[@href='/computers']"));
        homePage.selectMenu("computers");
    }

}
