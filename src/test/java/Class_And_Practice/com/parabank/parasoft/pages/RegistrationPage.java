package Class_And_Practice.com.parabank.parasoft.pages;

import com.thedeanda.lorem.LoremIpsum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage fillFirstName(String firstName) {
        getWebElement(By.id("customer.firstName")).sendKeys(firstName);
        return this;
    }

    public RegistrationPage fillLastName(String lastName) {
        getWebElement(By.id("customer.lastName")).sendKeys(lastName);
        return this;
    }

    public RegistrationPage fillAddress(String address) {
        getWebElement(By.id("customer.address.street")).sendKeys(address);
        return this;
    }

    public RegistrationPage fillCity(String city) {
        getWebElement(By.id("customer.address.city")).sendKeys(city);
        return this;
    }

    public RegistrationPage fillState(String state) {
        getWebElement(By.id("customer.address.state")).sendKeys(state);
        return this;
    }

    public RegistrationPage fillZipCode(String zipCode) {
        getWebElement(By.id("customer.address.zipCode")).sendKeys(zipCode);
        return this;
    }

    public RegistrationPage fillPhone(String phone) {
        getWebElement(By.id("customer.phoneNumber")).sendKeys(phone);
        return this;
    }

    public RegistrationPage fillSsn(String ssn) {
        getWebElement(By.id("customer.ssn")).sendKeys(ssn);
        return this;
    }

    public RegistrationPage fillUsername(String username) {
        getWebElement(By.id("customer.username")).sendKeys(username);
        return this;
    }

    public RegistrationPage fillPassword(String password) {
        getWebElement(By.id("customer.password")).sendKeys(password);
        return this;
    }

    public RegistrationPage fillConfirmPassword(String confirmPassword) {
        getWebElement(By.id("repeatedPassword")).sendKeys(confirmPassword);
        return this;
    }

    public OverViewPage clickRegisterButton() {
        clickElement(By.cssSelector("input[value='Register']"));
        return goTo(OverViewPage.class);
    }

    public RegistrationPage clickRegisterForFail() {
        clickElement(By.cssSelector("input[value='Register']"));
        return this;
    }

    public boolean isRegisterErrorMessageDisplayed(int expectedErrorCount) {
        return getWebElementSize(By.cssSelector("span[class='error']")) >= expectedErrorCount;
    }

    public OverViewPage doRegister() {
        String username = LoremIpsum.getInstance().getTitle(2).replaceAll(" ", "");
        return fillFirstName(LoremIpsum.getInstance().getFirstName())
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
    }
}
