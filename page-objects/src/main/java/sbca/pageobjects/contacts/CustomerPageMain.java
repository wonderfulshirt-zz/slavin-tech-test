package sbca.pageobjects.contacts;

import sbca.framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPageMain extends BasePage {

    @FindBy()
    private WebElement contactTitleName;

    @FindBy()
    private WebElement contactTitleType;

    public CustomerPageMain(WebDriver driver) {
        super(driver);
    }

    public void validateContactTitleName(String text) {
        waitForElementTextToBe(contactTitleName, text);
    }

    public void validateContactTitleType(String text) {
        waitForElementTextToBe(contactTitleName, text);
    }
}
