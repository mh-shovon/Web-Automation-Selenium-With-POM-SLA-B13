package assignment_com_parabank_parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoutLinkDisplayed(){
        return getWebElementSize(By.cssSelector("a[href='logout.htm']")) > 0;
    }
}
