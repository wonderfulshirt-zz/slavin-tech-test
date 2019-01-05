package sbca.tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import java.util.concurrent.TimeUnit;
import sbca.pageobjects.login.LoginPage;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver","..\\framework\\target\\classes\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        LoginPage loginPage = new LoginPage(driver);
        WebElement emailTextBox = loginPage.getEmailTextBox();
        WebElement passwordTextBox = loginPage.getPasswordTextBox();
        WebElement submitButton = loginPage.getSubmitButton();

        driver.get("https://app.sageone.com/login");
        loginPage.enterTextInElement(emailTextBox, "rstraavaldson@mailinator.com");
        loginPage.enterTextInElement(passwordTextBox, "P@55w0rd");
        loginPage.clickElementWithJS(submitButton);

    }

    @AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

}
