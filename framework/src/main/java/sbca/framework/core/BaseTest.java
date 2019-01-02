package sbca.framework.core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {

        String outputDirectory = System.getProperty("build.output");
        System.out.print("________________" + outputDirectory);

        System.setProperty("webdriver.chrome.driver","..\\framework\\target\\classes\\chromedriver.exe");
        ChromeDriverManager.chromedriver();
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
