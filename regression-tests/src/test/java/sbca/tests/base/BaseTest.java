package sbca.tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.util.concurrent.TimeUnit;
import sbca.pageobjects.login.LoginPage;
import sbca.pageobjects.summary.SummaryPage;
import static org.testng.Assert.assertTrue;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver","..\\framework\\target\\classes\\chromedriver.exe");
    }

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://app.sageone.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSuccess();

    }

    @AfterTest
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }
}
