package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
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

    public RegistrationPage clickRegisterLink(){
        click(By.linkText("Register"));
        return goTo(RegistrationPage.class);
    }

    public LookUpPage clickForgotLoginInfoLink(){
        click(By.linkText("Forgot login info"));
        return goTo(LookUpPage.class);
    }

    public OverViewPage clickLoginBtn(){
        click(By.cssSelector("input[value='Log In']"));
        return goTo(OverViewPage.class);
    }

    public LoginPage clickLoginBtnForFail(){
        click(By.cssSelector("input[value='Log In']"));
        return this;
    }

    public boolean isLoginErrorMessageFound(){
        return getWebElementSize(By.cssSelector(".error")) > 0;
    }
}
