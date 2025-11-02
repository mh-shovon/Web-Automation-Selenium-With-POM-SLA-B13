package assignment_com_parabank_parasoft.test;

import assignment_com_parabank_parasoft.pages.LoginPage;
import assignment_com_parabank_parasoft.pages.OverviewPage;
import assignment_com_parabank_parasoft.utils.BatchThirteenUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void checkLoginPageTitle() {
        LoginPage loginPage = page.goTo(LoginPage.class);
        Assert.assertEquals(loginPage.getPageTitle(), BatchThirteenUtil.PAGE_TITLE);
    }

    @Test
    public void checkLoginWithOutCredentialShouldFailV1() {
        LoginPage loginPage = page.goTo(LoginPage.class);
        loginPage = loginPage
                .fillUsername("")
                .fillUserPassword("")
                .clickLoginBtnForFail();
        Assert.assertTrue(loginPage.isLoginErrorMessageFound());
    }

    @Test
    public void checkLoginWithOutCredentialShouldFail2V2() {
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
                .fillUserPassword("shovon666700")
                .clickLoginBtnForFail();
        Assert.assertTrue(loginPage.isLoginErrorMessageFound());
    }

    @Test
    public void checkLoginWithOutUserPasswordShouldFail() {
        LoginPage loginPage = page.goTo(LoginPage.class);
        loginPage = loginPage
                .fillUsername("shovon666700")
                .clickLoginBtnForFail();
        Assert.assertTrue(loginPage.isLoginErrorMessageFound());
    }

    @Test
    public void checkLoginWithInvalidCredentialShouldFailedV1() {
        LoginPage loginPage = page.goTo(LoginPage.class);
        loginPage = loginPage
                .fillUsername("1256")
                .fillUserPassword("165165")
                .clickLoginBtnForFail();
        Assert.assertTrue(loginPage.isLoginErrorMessageFound());
    }

    public void checkLoginWithInvalidCredentialShouldFailedV2() {
        LoginPage loginPage = page.goTo(LoginPage.class)
                .fillUsername("1256")
                .fillUserPassword("165165")
                .clickLoginBtnForFail();
        Assert.assertTrue(loginPage.isLoginErrorMessageFound());
    }

    @Test
    public void checkLoginWithValidCredentialShouldSucceedV1() {
        LoginPage loginPage = page.goTo(LoginPage.class);
        loginPage = loginPage
                .fillUsername("shovon666700")
                .fillUserPassword("shovon666700");

        OverviewPage overViewPage = loginPage
                .clickLoginBtn();
        Assert.assertTrue(overViewPage.isLogoutLinkDisplayed());
    }

    @Test
    public void checkLoginWithValidCredentialShouldSucceed2() {
        OverviewPage overViewPage = page.goTo(LoginPage.class)
                .fillUsername("shovon666700")
                .fillUserPassword("shovon666700")
                .clickLoginBtn();
        Assert.assertTrue(overViewPage.isLogoutLinkDisplayed());
    }
}
