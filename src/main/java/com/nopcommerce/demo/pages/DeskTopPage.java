package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeskTopPage extends Utility {
    @CacheLookup
    @FindBy(name = "products-orderby")
    WebElement sortByName;
    @CacheLookup
    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]")
    WebElement addToCart;

    public DeskTopPage() {
        PageFactory.initElements(driver, this);
    }
    public void selectSortByName(String text) {
        Reporter.log("Select by name" + text + " to name field " + sortByName.toString());
        selectByVisibleTextFromDropDown(sortByName, text);
        // selectByValueFromDropDown(sortByName, text);
    }

    public void clickOnAddToCart()  {
        Reporter.log("Click on Element" + addToCart.toString());
        clickOnElement(addToCart);
    }

    public Map<String, ArrayList> arrangeProductInDescendingOrder() {
        Map<String, ArrayList> mapArrays = new HashMap<String, ArrayList>();
        List<WebElement> products = driver.findElements(By.xpath("//h2/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
//        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(By.id("products-orderby"), "Name: Z to A");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h2/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        mapArrays.put("originalProductsName", originalProductsName);
        mapArrays.put("afterSortByZToAProductsName", afterSortByZToAProductsName);
        return mapArrays;

    }


}
