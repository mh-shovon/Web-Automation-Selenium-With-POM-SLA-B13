package assignment_com_parabank_parasoft.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage extends Page {
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getWebElement(By selector) {
        try {
            return driver.findElement(selector);
        } catch (NoSuchElementException e) {
            System.err.println("Element not found: " + selector);
        } catch (Exception e) {
            System.err.println("Unexpected error in getWebElement: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<WebElement> getWebElements(By selector) {
        try {
            return driver.findElements(selector);
        } catch (NegativeArraySizeException e) {
            System.err.println("Elements not found: " + selector);
        } catch (Exception e) {
            System.out.println("Unexpected error in getWebElements: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String getText(By selector) {
        return getWebElement(selector).getText().trim();
    }

    @Override
    public void clickElement(By selector) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(selector))).click();
        } catch (NoSuchElementException e) {
            System.err.println("Element not clickable: " + selector);
        } catch (Exception e) {
            System.err.println("Unexpected error during clicking: " + e.getMessage());
        }
    }

    @Override
    public Select getSelect(By selector) {
        return new Select(getWebElement(selector));
    }

    @Override
    public void setWait(By selector) {
        try {
            wait.until(ExpectedConditions.visibilityOf(getWebElement(selector)));
        } catch (NoSuchElementException e) {
            System.err.println("Element not clickable: " + selector);
        } catch (Exception e) {
            System.err.println("Unexpected error during Wait: " + e.getMessage());
        }
    }

    @Override
    public int getWebElementSize(By selector) {
        return getWebElements(selector).size();
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }
}
