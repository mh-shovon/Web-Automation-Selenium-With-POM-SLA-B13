package assignment_com_parabank_parasoft.pages;

import assignment_com_parabank_parasoft.utils.BatchThirteenUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;

public abstract class Page {
    WebDriver driver;

    WebDriverWait wait;

    public  Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(BatchThirteenUtil.WAIT_TIME));
    }

    public abstract WebElement getWebElement(By selector);

    public abstract List<WebElement> getWebElements(By selector);

    public abstract String getText(By selector);

    public abstract void clickElement(By selector);

    public abstract Select getSelect(By selector);

    public abstract void setWait(By locator);

    public abstract int getWebElementSize(By selector);

    public abstract String getPageTitle();

    public <T extends BasePage> T goTo(Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
