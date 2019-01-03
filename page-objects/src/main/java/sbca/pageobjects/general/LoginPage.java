package sbca.pageobjects.general;

import sbca.framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(tagName = "h2")
    private WebElement header;

    @FindBy(id = "sso_Email")
    private WebElement email;

    @FindBy(id = "sso_Password")
    private WebElement password;

    @FindBy(css = "input[class='button primary']")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return submitButton.isDisplayed();
    }

    public void enterEmail(String emailText) {
        this.email.clear();
        this.email.sendKeys(emailText);
    }

    public void enterPassword(String passwordText) {
        this.password.clear();
        this.password.sendKeys(passwordText);
    }

    public void login() {
        enterEmail("rstraavaldson@mailinator.com");
        enterPassword("P@55w0rd");
        this.submitButton.click();
    }

}
