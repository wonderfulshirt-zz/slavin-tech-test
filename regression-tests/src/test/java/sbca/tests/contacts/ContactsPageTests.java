package sbca.tests.contacts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sbca.tests.base.BaseTest;
import sbca.pageobjects.global.NavigationMenu;
import sbca.pageobjects.contacts.*;
import org.openqa.selenium.WebElement;

import java.util.UUID;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactsPageTests extends BaseTest {

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
        String businessName = UUID.randomUUID().toString().replace("-", "");

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
}
