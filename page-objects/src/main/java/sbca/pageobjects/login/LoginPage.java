package sbca.pageobjects.login;

import sbca.pageobjects.framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void setEmailTextBox(String text) {
        enterTextInElement(emailTextBox, text);
    }

    public void setPasswordTextBox(String text) {
        enterTextInElement(passwordTextBox, text);
    }

    public void clickSubmitButton() {
        clickElementWithJS(submitButton);
    }

}
