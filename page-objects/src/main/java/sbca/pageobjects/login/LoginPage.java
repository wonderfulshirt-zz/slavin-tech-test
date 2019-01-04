package sbca.pageobjects.login;

import sbca.framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sbca.pageobjects.summary.SummaryPage;
import sbca.pageobjects.global.NavigationMenu;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {

    @FindBy(tagName = "h2")
    private WebElement pagetTitle;

    @FindBy(id = "sso_Email")
    private WebElement emailTextBox;

    @FindBy(id = "sso_Password")
    private WebElement passwordTextBox;

    @FindBy(css = "input[class='button primary']")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return submitButton.isDisplayed();
    }

    public void enterTextInEmailTextBox(String text) {
        waitForElementToBeVisible(emailTextBox);
        emailTextBox.clear();
        emailTextBox.sendKeys(text);
    }

    public void enterTextInPasswordTextBox(String text) {
        waitForElementToBeVisible(passwordTextBox);
        passwordTextBox.clear();
        passwordTextBox.sendKeys(text);
    }

    public void enterCredentialsAndClickSubmit(String username, String password) {
        enterTextInEmailTextBox(username);
        enterTextInPasswordTextBox(password);
        this.submitButton.click();
    }

    public void login(String username, String password) {
        driver.get("https://app.sageone.com/login");
        //assertTrue(isInitialized());
        waitForElementToBeVisible(submitButton);
        enterCredentialsAndClickSubmit(username, password);
    }

}
