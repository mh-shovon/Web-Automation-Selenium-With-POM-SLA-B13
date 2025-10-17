package com.parabank.parasoft.test;

import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.OverViewPage;
import com.parabank.parasoft.util.BatchThirteenUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void checkLoginPageTitle() {
        LoginPage loginPage = page.goTo(LoginPage.class);
        Assert.assertEquals(loginPage.getPageTitle(), BatchThirteenUtil.PAGE_TITLE);
    }

    @Test
    public void checkLoginWithOutCredentialShouldFail() {
        LoginPage loginPage = page.goTo(LoginPage.class);
        loginPage = loginPage
                .fillUsername("")
                .fillUserPassword("")
                .clickLoginBtnForFail();
        Assert.assertTrue(loginPage.isLoginErrorMessageFound());
    }

    @Test
    public void checkLoginWithOutCredentialShouldFail2() {
        LoginPage loginPage = page.goTo(LoginPage.class)
                .fillUsername("")
                .fillUserPassword("")
                .clickLoginBtnForFail();
        Assert.assertTrue(loginPage.isLoginErrorMessageFound());
    }

    @Test
    public void checkLoginWithOutUserNameShouldFail() {
        LoginPage loginPage = page.goTo(LoginPage.class);
        loginPage = loginPage
                .fillUserPassword("asdf")
                .clickLoginBtnForFail();
        Assert.assertTrue(loginPage.isLoginErrorMessageFound());
    }

    @Test
    public void checkLoginWithOutUserPasswordShouldFail() {
        LoginPage loginPage = page.goTo(LoginPage.class);
        loginPage = loginPage
                .fillUsername("sqa")
                .clickLoginBtnForFail();
        Assert.assertTrue(loginPage.isLoginErrorMessageFound());
    }

    @Test
    public void checkLoginWithValidCredentialShouldSucceed() {
        LoginPage loginPage = page.goTo(LoginPage.class);
        loginPage = loginPage
                .fillUsername("sqa")
                .fillUserPassword("sqa");

        OverViewPage overViewPage = loginPage
                .clickLoginBtn();
        Assert.assertTrue(overViewPage.isLogoutLinkDisplayed());
    }

    @Test
    public void checkLoginWithValidCredentialShouldSucceed2() {
        OverViewPage overViewPage = page.goTo(LoginPage.class)
                .fillUsername("sqa")
                .fillUserPassword("sqa")
                .clickLoginBtn();
        Assert.assertTrue(overViewPage.isLogoutLinkDisplayed());
    }
}
