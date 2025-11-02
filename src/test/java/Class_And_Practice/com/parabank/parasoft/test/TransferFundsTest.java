package Class_And_Practice.com.parabank.parasoft.test;

import Class_And_Practice.com.parabank.parasoft.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferFundsTest extends BaseTest {
    @Test
    public void transferFundsShouldSucceedV1() {
        LoginPage loginPage = page.goTo(LoginPage.class);

        OverViewPage overViewPage = loginPage
                .fillUsername(getUserName())
                .fillUserPassword(getPassword())
                .clickLoginBtn();
        Assert.assertTrue(overViewPage.isLogoutLinkDisplayed());

        TransferFundsPage transferFundsPage = overViewPage
                .clickTransferFundsLink();

        int transferAmount  = 1000;
        TransferCompletePage transferCompletePage = transferFundsPage
                .fillAmount(transferAmount)
                .selectFromAccount(0)
                .selectToAccount(0)
                .clickTransferButton();

        Assert.assertTrue(transferCompletePage.isTransferComplete(transferAmount));
    }

    @Test
    public void transferFundsShouldSucceedV2() {
        int transferAmount  = 1000;
        TransferCompletePage transferCompletePage = page.goTo(LoginPage.class)
                .fillUsername(getUserName())
                .fillUserPassword(getPassword())
                .clickLoginBtn()
                .clickTransferFundsLink()
                .fillAmount(transferAmount)
//                .selectFromAccount(1)
//                .selectToAccount(1)
                .clickTransferButton();

        Assert.assertTrue(transferCompletePage.isTransferComplete(transferAmount));
    }

    @Test
    public void transferFundsShouldSucceedV3() {
        int transferAmount  = 1000;
        TransferCompletePage transferCompletePage = page.goTo(LoginPage.class)
                .doLogin(getUserName(), getPassword())
                .clickTransferFundsLink()
                .fillAmount(transferAmount)
//                .selectFromAccount(1)
//                .selectToAccount(1)
                .clickTransferButton();

        Assert.assertTrue(transferCompletePage.isTransferComplete(transferAmount));
    }
}
