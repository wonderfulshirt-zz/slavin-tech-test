package sbca.tests.base;

import org.openqa.selenium.WebDriver;
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
        loginPage.login("rstraavaldson@mailinator.com", "P@55w0rd");
    }

    @AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

}
