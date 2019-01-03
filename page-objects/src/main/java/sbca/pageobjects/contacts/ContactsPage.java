package sbca.pageobjects.contacts;

import sbca.framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sbca.pageobjects.summary.SummaryPage;

public class ContactsPage extends BasePage {

    @FindBy(id = "main-menu")
    private WebElement mainMenu;

    @FindBy(css = "h1[contains(text(), 'Contacts')]")
    private WebElement header;

    public ContactsPage(WebDriver driver) {
        super(driver);
    }
//
//    public boolean isInitialized() {
//        return submitButton.isDisplayed();
//    }

}
