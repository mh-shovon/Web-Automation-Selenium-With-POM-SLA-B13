package com.parabank.parasoft.test;

import com.parabank.parasoft.pages.BasePage;
import com.parabank.parasoft.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    Page page;
    @BeforeMethod
    public void setupBrowser(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.parabank.parasoft.com/parabank/index.htm");

        page = new BasePage(driver);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
