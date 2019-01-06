package sbca.pageobjects.contacts;

import sbca.framework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCustomerDialog extends BasePage {

    @FindBy(id = "carbon-dialog-title")
    private WebElement dialogTitle;

    @FindBy(css = "input[name='contact[company]']")
    private WebElement businessNameTextBox;

    @FindBy(css = "input[name='contact[company]'][class='carbon-textbox__input common-input__input--error common-input__input']")
    private WebElement businessNameTextBoxError;

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

    public boolean isInitialized() {
        return saveButton.isDisplayed();
    }

    public void setBusinessNameTextBox(String text) {
        enterTextInElement(businessNameTextBox, text);
    }

    public void setContactNameTextBox(String text) {
        enterTextInElement(contactNameTextBox, text);
    }

    public void setReferenceTextBox(String text) {
        enterTextInElement(referenceTextBox, text);
    }

    public void setEmailTextBox(String text) {
        enterTextInElement(emailTextBox, text);
    }

    public void setTelephoneTextBox(String text) {
        enterTextInElement(telephoneTextBox, text);
    }

    public void clickSaveButton() {
        clickElementWithJS(saveButton);
    }

    public void waitforSaveButtonToBeInvisible() {
        waitForElementToBeInvisible(saveButton);
    }
    

}
