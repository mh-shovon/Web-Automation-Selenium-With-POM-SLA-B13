package com.parabank.parasoft.pages;

import com.parabank.parasoft.utils.BatchThirteenUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferFundsPage extends BasePage {
    public TransferFundsPage(WebDriver driver) {
        super(driver);
    }

    public TransferFundsPage fillAmount(int amount) {
        getWebElement(By.id("amount")).sendKeys(String.valueOf(amount));
        BatchThirteenUtil.waitForDomStable();
        return this;
    }

    public TransferFundsPage selectFromAccount(int index) {
        BatchThirteenUtil.waitForDomStable();
        getSelect(By.id("fromAccountId")).selectByIndex(index);
        return this;
    }

    public TransferFundsPage selectToAccount(int index) {
        BatchThirteenUtil.waitForDomStable();
        getSelect(By.id("toAccountId")).selectByIndex(index);
        return this;
    }

    public TransferCompletePage clickTransferButton() {
        clickElement(By.cssSelector("input[value='Transfer']"));
        BatchThirteenUtil.waitForDomStable();
        return goTo(TransferCompletePage.class);
    }
}
