package sbca.pageobjects.contacts;

import org.testng.Assert;
import sbca.pageobjects.framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPageMain extends BasePage {

    @FindBy(css = "span[class='contact-header__title-name']")
    private WebElement contactTitleName;

    @FindBy(css = "span[class='contact-header__title-type']")
    private WebElement contactTitleType;

    public CustomerPageMain(WebDriver driver) {
        super(driver);
    }

    public void validateContactTitleNameIs(String text) {
        waitForElementTextToBe(contactTitleName, text);
    }

    public void validateContactTitleTypeIsCustomer() {
        //waitForElementTextToBe(contactTitleType, " (Customer)");
        Assert.assertTrue(contactTitleType.getText().contains("Customer"));
    }

    public void validateContactTitleTypeIsSupplier() {
        waitForElementTextToBe(contactTitleType, " (Supplier)");
    }
}
