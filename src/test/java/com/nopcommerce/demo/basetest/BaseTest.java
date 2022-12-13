package com.nopcommerce.demo.basetest;

import com.nopcommerce.demo.propertyreader.PropertyReader;
import com.nopcommerce.demo.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod
    public void setUp(){

        selectBrowser(browser);
    }

    @AfterMethod
    public void tearDown(){

        closeBrowser();
    }
}
