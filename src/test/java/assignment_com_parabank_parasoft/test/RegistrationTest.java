package assignment_com_parabank_parasoft.test;

import assignment_com_parabank_parasoft.pages.LoginPage;
import assignment_com_parabank_parasoft.pages.OverViewPage;
import assignment_com_parabank_parasoft.pages.RegistrationPage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    @Test
    public void registerWithOnlyFirstShouldFail() {
        LoginPage loginPage = page.goTo(LoginPage.class);

        RegistrationPage rp = loginPage
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .clickRegisterForFail();
        Assert.assertTrue(rp.isRegisterErrorMessageDisplayed(9));

    }

    @Test
    public void registerWithOnlyFirstAndLastShouldFail() {
        LoginPage loginPage = page.goTo(LoginPage.class);

        RegistrationPage registrationPage = loginPage
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .clickRegisterForFail();
        Assert.assertTrue(registrationPage.isRegisterErrorMessageDisplayed(8));

    }

    @Test
    public void registerV1ShouldSucceed() {
        String username = LoremIpsum.getInstance().getTitle(2).replaceAll(" ", "");
        LoginPage loginPage = page.goTo(LoginPage.class);

        RegistrationPage registrationPage = loginPage
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress(LoremIpsum.getInstance().getCity())
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateFull())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillPhone(LoremIpsum.getInstance().getPhone())
                .fillSsn(LoremIpsum.getInstance().getZipCode())
                .fillUsername(username)
                .fillPassword(username)
                .fillConfirmPassword(username);

        OverViewPage overViewPage = registrationPage
                .clickRegisterButton();
        Assert.assertTrue(overViewPage.isLogoutLinkDisplayed());
    }

    @Test
    public void registerV2ShouldSucceed() {
        String username = LoremIpsum.getInstance().getTitle(2).replaceAll(" ", "");
        OverViewPage overViewPage = page.goTo(LoginPage.class)
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress(LoremIpsum.getInstance().getCity())
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateFull())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillPhone(LoremIpsum.getInstance().getPhone())
                .fillSsn(LoremIpsum.getInstance().getZipCode())
                .fillUsername(username)
                .fillPassword(username)
                .fillConfirmPassword(username)
                .clickRegisterButton();
        Assert.assertTrue(overViewPage.isLogoutLinkDisplayed());
    }

    @Test
    public void registerV3ShouldSucceed() {
        OverViewPage overViewPage = page.goTo(LoginPage.class)
                .clickRegisterLink()
                .doRegister();
        Assert.assertTrue(overViewPage.isLogoutLinkDisplayed());
    }
}
