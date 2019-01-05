package sbca.tests.contacts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sbca.pageobjects.contacts.ContactsPage;
import sbca.pageobjects.contacts.CreateNewCustomerDialog;
import sbca.pageobjects.global.NavigationMenu;
import sbca.tests.base.BaseTest;

import java.util.UUID;

public class CreateNewCustomerDialogTests extends BaseTest {

    @BeforeTest
    public void loadContactsPageViaGlobalNavigationMenu() {
        NavigationMenu navigationMenu = new NavigationMenu(driver);
        navigationMenu.clickContactsMenuItem();
    }

    @Test
    public void createCustomerWithMinimumRequiredFields() {
        // Declarations
        ContactsPage contactsPage = new ContactsPage(driver);
        WebElement searchTextBox = contactsPage.getSearchTextBox();
        WebElement searchButton = contactsPage.getSearchButton();

        CreateNewCustomerDialog createNewCustomerDialog = new CreateNewCustomerDialog(driver);
        WebElement businessNameTextBox = createNewCustomerDialog.getBusinessNameTextBox();
        String businessName = UUID.randomUUID().toString();

        // Test
        contactsPage.clickNewCustomerButton();

        createNewCustomerDialog.enterTextInElement(businessNameTextBox, businessName);
        createNewCustomerDialog.clickSaveButton();
        createNewCustomerDialog.waitForCreateNewCustomerDialogToBeInvisible();

        contactsPage.enterTextInElement(searchTextBox, businessName);
        contactsPage.clickElementWithJS(searchButton);

        contactsPage.waitForNumberOfContactsInTableToEqual("1");
        contactsPage.checkContactsTableCellText(1, 3, businessName);

    }

    @Test
    public void isNotPossibleToCreateCustomerWithNoBusinessName() {

    }

}

