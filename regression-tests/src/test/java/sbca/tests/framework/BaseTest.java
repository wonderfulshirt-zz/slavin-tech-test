package sbca.tests.framework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import sbca.pageobjects.login.LoginPage;

@Listeners(TestListener.class)
public class BaseTest {

    protected static WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        String path = System.getProperty("user.dir");
        System.out.println(path);

        // WHEN RUNNING WITH MVN
        System.setProperty("webdriver.chrome.driver", path + "\\classes\\chromedriver.exe");

        // WHEN RUNNING WITH A TESTNG RUN CONFIG IN THE IDE
//        System.setProperty("webdriver.chrome.driver", path + "\\target\\classes\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://app.sageone.com/login");
        loginPage.setEmailTextBox("rstraavaldson@mailinator.com");
        loginPage.setPasswordTextBox("P@55w0rd");
        loginPage.clickSubmitButton();
    }

    @AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

//    @AfterMethod
//    public void afterMethod(ITestResult result) {
//        String methodName = result.getMethod().getMethodName();
//        String status = result.getStatus(;
//    }

    public void takeScreenshot(String testMethodName) {
        String workingDir = System.getProperty("user.dir");
        File screenshotsDir = new File(workingDir + "\\screenshots");
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String filename = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + "_" + testMethodName + ".jpg";

        try {
            if(!screenshotsDir.exists()) {
                screenshotsDir.mkdir();
            }

            FileUtils.copyFile(screenshot, new File(screenshotsDir + "\\" + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception{
//
//        //Convert web driver object to TakeScreenshot
//        TakesScreenshot scrShot = ((TakesScreenshot)webdriver);
//
//        //Call getScreenshotAs method to create image file
//        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//
//        //Move image file to new destination
//        File DestFile = new File(fileWithPath);
//
//        //Copy file at destination
//        FileUtils.copyFile(SrcFile, DestFile);
//
//    }
//
//    private void takeScreenshot(String className, String method, LocalTime timestamp) {
//        if (driver instanceof TakesScreenshot) {
//            TakesScreenshot screenshotTakingDriver = (TakesScreenshot) this.driver;
//            try {
//                File localScreenshots = new File(new File("target"), "screenshots");
//                if (!localScreenshots.exists() || !localScreenshots.isDirectory()) {
//                    localScreenshots.mkdirs();
//                }
//                File screenshot = new File(localScreenshots, className + "_" + method + "_" + timestamp.getHour() + "." + timestamp.getMinute() + ".png");
//                FileUtils.moveFile(screenshotTakingDriver.getScreenshotAs(OutputType.FILE), screenshot);
//                //logger.info("Screenshot for class={} method={} saved in: {}", className, method, screenshot.getAbsolutePath());
//                System.out.println("Screenshot saved.");
//            } catch (Exception e1) {
//                //logger.error("Unable to take screenshot", e1);
//            }
//        } else {
//            System.out.println("Can't take screenshots so skipping it.");
//            //logger.info("Driver '{}' can't take screenshots so skipping it.", driver.getClass());
//        }
//    }
}