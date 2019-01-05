package sbca.pageobjects.contacts;

import org.jsoup.Connection;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sbca.framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCustomerDialog extends BasePage {

    @FindBy(id = "carbon-dialog-title")
    private WebElement dialogTitle;

    @FindBy(css = "input[name='contact[company]']")
    private WebElement businessNameTextBox;

    @FindBy(css = "input[name='contact[addresses_attributes][0][contacts_attributes][0][name]']")
    private WebElement contactNameTextBox;

    @FindBy(css = "input[name='contact[reference]']")
    private WebElement referenceTextBox;

    @FindBy(css = "input[name='contact[addresses_attributes][0][contacts_attributes][0][email]']")
    private WebElement emailTextBox;

    @FindBy(css = "input[name='contact[addresses_attributes][0][contacts_attributes][0][mobile]']")
    private WebElement mobileTextBox;

    @FindBy(css = "input[name='contact[addresses_attributes][0][contacts_attributes][0][telephone]']")
    private WebElement telephoneTextBox;

    @FindBy(css = "button[data-element='save']")
    private WebElement saveButton;

    public CreateNewCustomerDialog(WebDriver driver) {
        super(driver);
    }

    public void waitForCreateNewCustomerDialogToBeInvisible() {
        wait.until(ExpectedConditions.invisibilityOf(saveButton));
    }

    public boolean isInitialized() {
        return saveButton.isDisplayed();
    }

    public WebElement getBusinessNameTextBox() {
        return businessNameTextBox;
    }

//    public void enterTextInBusinessNameTextBox(String text) {
//        enterTextInElement(businessNameTextBox, text);
//    }

    public void clickSaveButton() {
        saveButton.isDisplayed();
        saveButton.click();
    }

}
