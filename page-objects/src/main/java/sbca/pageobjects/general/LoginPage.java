package sbca.pageobjects.general;

import org.openqa.selenium.By;
import sbca.framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h2")
    private WebElement header;

    @FindBy(id = "sso_Email")
    private WebElement email;

    @FindBy(id = "sso_Password")
    private WebElement password;

    @FindBy(css = "input[class='button-primary']")
    private WebElement submitButton;
}
