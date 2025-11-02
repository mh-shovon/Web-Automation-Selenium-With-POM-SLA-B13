package Class_And_Practice.com.parabank.parasoft.test;

import Class_And_Practice.com.parabank.parasoft.pages.LoginPage;
import Class_And_Practice.com.parabank.parasoft.pages.OverViewPage;
import Class_And_Practice.com.parabank.parasoft.utils.BatchThirteenUtil;
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
                .fillUserPassword(getPassword())
                .clickLoginBtnForFail();
        Assert.assertTrue(loginPage.isLoginErrorMessageFound());
    }

    @Test
    public void checkLoginWithOutUserPasswordShouldFail() {
        LoginPage loginPage = page.goTo(LoginPage.class);
        loginPage = loginPage
                .fillUsername(getUserName())
                .clickLoginBtnForFail();
        Assert.assertTrue(loginPage.isLoginErrorMessageFound());
    }

    @Test
    public void checkLoginWithValidCredentialShouldSucceedV1() throws InterruptedException {
        LoginPage loginPage = page.goTo(LoginPage.class);
        loginPage = loginPage
                .fillUsername(getUserName())
                .fillUserPassword(getPassword());

        OverViewPage overViewPage = loginPage
                .clickLoginBtn();
        Assert.assertTrue(overViewPage.isLogoutLinkDisplayed());
    }

    @Test
    public void checkLoginWithValidCredentialShouldSucceedV2() {
        OverViewPage overViewPage = page.goTo(LoginPage.class)
                .fillUsername(getUserName())
                .fillUserPassword(getPassword())
                .clickLoginBtn();
        Assert.assertTrue(overViewPage.isLogoutLinkDisplayed());
    }

    @Test
    public void checkLoginWithValidCredentialShouldSucceedV() {
        OverViewPage overViewPage = page.goTo(LoginPage.class)
                .doLogin(getUserName(), getPassword());
        Assert.assertTrue(overViewPage.isLogoutLinkDisplayed());
    }
}
