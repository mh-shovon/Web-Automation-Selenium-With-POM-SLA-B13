package Class_And_Practice.com.parabank.parasoft.test;

import Class_And_Practice.com.parabank.parasoft.pages.BasePage;
import Class_And_Practice.com.parabank.parasoft.pages.Page;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    Page page;
    private Properties properties;

    public BaseTest() {
        properties = new Properties();
        String projectPath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        System.out.println("Project Path: " + projectPath);
        try {
            FileInputStream fileInputStream = new FileInputStream(projectPath);
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void setupBrowser() {
        String browserName = properties.getProperty("browserName");
        if (Objects.equals(browserName, "firefox")) {
            driver = new FirefoxDriver();
        } else if (Objects.equals(browserName, "chrome")) {
            driver = new ChromeDriver();
        } else if (Objects.equals(browserName, "firefox-headless")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
        } else if (Objects.equals(browserName, "edge")) {
            driver = new EdgeDriver();
        } else if (Objects.equals(browserName, "safari")) {
            driver = new SafariDriver();
        } else {
            throw new RuntimeException("Browser is not supported: " + browserName);
        }
        driver.manage().window().maximize();
        driver.get(properties.getProperty("baseUrl"));

        page = new BasePage(driver);
    }

    @AfterMethod
    public void closeBrowser(ITestResult result) {
        System.out.println("Test " + result.getName() + " - " + (result.isSuccess() ? "PASSED" : "FAILED"));
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(result.getName());
        }
        driver.close();
    }

    public String getUserName() {
        return properties.getProperty("userName");
    }

    public String getPassword() {
        return properties.getProperty("userPassword");
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public void takeScreenshot(String name) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir") + "/build/screenshots/";
            File destFile = new File(currentDir + name + "_" + System.currentTimeMillis() + ".png");
            destFile.getParentFile().mkdirs();
            FileUtils.copyFile(scrFile, destFile);
            System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Failed to capture screenshot: " + e.getMessage(), e);
        }
    }
}
