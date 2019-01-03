package sbca.pageobjects.login;

import sbca.framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sbca.pageobjects.summary.SummaryPage;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {

    @FindBy(tagName = "h2")
    private WebElement header;

    @FindBy(id = "sso_Email")
    private WebElement emailTextBox;

    @FindBy(id = "sso_Password")
    private WebElement passwordTextBox;

    @FindBy(css = "input[class='button primary']")
    private WebElement submitButton;

    private String loginPageAddress = "https://app.sageone.com/login";
    private String emailText = "rstraavaldson@mailinator.com";
    private String passwordText = "P@55w0rd";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return submitButton.isDisplayed();
    }

    public void login() {
        enterTextInWebElement(emailTextBox, emailText);
        enterTextInWebElement(passwordTextBox, passwordText);
        this.submitButton.click();
    }

    public void loginSuccess() {
        driver.get(loginPageAddress);

        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isInitialized());

        login();

        SummaryPage summaryPage = new SummaryPage(driver);
        assertTrue(summaryPage.isInitialized());

    }

}
