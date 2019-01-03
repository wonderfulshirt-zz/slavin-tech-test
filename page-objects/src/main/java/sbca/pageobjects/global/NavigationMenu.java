package sbca.pageobjects.global;

import sbca.framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationMenu extends BasePage {

    @FindBy(css = "a[href='/contacts/contacts']")
    private WebElement contactsMenuItem;

    public NavigationMenu(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return contactsMenuItem.isDisplayed();
    }
}
