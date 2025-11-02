package assignment_com_parabank_parasoft.test;

import assignment_com_parabank_parasoft.pages.BasePage;
import assignment_com_parabank_parasoft.pages.Page;
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
        driver.get("https://parabank.parasoft.com/parabank/");

        page = new BasePage(driver);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
