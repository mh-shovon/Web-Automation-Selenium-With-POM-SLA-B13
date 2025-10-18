package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverViewPage extends BasePage{
    public OverViewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoutLinkDisplayed(){
        return getWebElementSize(By.cssSelector("a[href='logout.htm']")) > 0;
    }

    public OpenNewAccountPage clickOpenNewAccountLink() {
        clickElement(By.cssSelector("a[href='openaccount.htm']"));
        return goTo(OpenNewAccountPage.class);
    }

    public TransferFundsPage clickTransferFundsLink() {
        clickElement(By.cssSelector("a[href='transfer.htm']"));
        return goTo(TransferFundsPage.class);
    }
}
