package Class_And_Practice.com.parabank.parasoft.test;

import Class_And_Practice.com.parabank.parasoft.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewAccountTest extends BaseTest {
    @Test
    public void openNewAccountShouldSucceedV1() {
        LoginPage loginPage = page.goTo(LoginPage.class);

        OverViewPage overViewPage = loginPage
                .fillUsername(getUserName())
                .fillUserPassword(getPassword())
                .clickLoginBtn();
        Assert.assertTrue(overViewPage.isLogoutLinkDisplayed());

        OpenNewAccountPage openNewAccountPage = overViewPage
                .clickOpenNewAccountLink();

        AccountOpenedPage accountOpenedPage = openNewAccountPage
                .selectAccountType(1)
                .clickOpenAccountButton();
        Assert.assertTrue(accountOpenedPage.hasAccountOpenedId());
    }

    @Test
    public void openNewAccountShouldSucceedV2() {
        AccountOpenedPage accountOpenedPage = page.goTo(LoginPage.class)
                .fillUsername(getUserName())
                .fillUserPassword(getPassword())
                .clickLoginBtn()
                .clickOpenNewAccountLink()
                .selectAccountType(1)
                .clickOpenAccountButton();
        Assert.assertTrue(accountOpenedPage.hasAccountOpenedId());
    }

    @Test
    public void openNewAccountShouldSucceedV3() {
        AccountOpenedPage accountOpenedPage = page.goTo(LoginPage.class)
                .doLogin(getUserName(), getPassword())
                .clickOpenNewAccountLink()
                .selectAccountType(1)
                .clickOpenAccountButton();
        Assert.assertTrue(accountOpenedPage.hasAccountOpenedId());
    }

    @Test
    public void openNewAccountShouldSucceedV4() {
        AccountOpenedPage accountOpenedPage = page.goTo(LoginPage.class)
                .clickRegisterLink()
                .doRegister()
                .clickOpenNewAccountLink()
                .selectAccountType(1)
                .clickOpenAccountButton();
        Assert.assertTrue(accountOpenedPage.hasAccountOpenedId());
    }
}
