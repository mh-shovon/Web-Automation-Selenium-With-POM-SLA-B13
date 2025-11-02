package assignment_com_parabank_parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage fillUsername(String username){
        getWebElement(By.cssSelector("input[name='username']")).sendKeys(username);
        return this;
    }

    public LoginPage fillUserPassword(String password){
        getWebElement(By.cssSelector("input[name='password']")).sendKeys(password);
        return this;
    }

    public OverviewPage clickLoginBtn(){
        click(By.cssSelector("input[value='Log In']"));
        return goTo(OverviewPage.class);
    }

    public LoginPage clickLoginBtnForFail(){
        click(By.cssSelector("input[value='Log In']"));
        return this;
    }

    public boolean isLoginErrorMessageFound(){
        return getWebElementSize(By.cssSelector(".error")) > 0;
    }
}
