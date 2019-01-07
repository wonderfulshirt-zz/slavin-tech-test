package sbca.tests.contacts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sbca.pageobjects.contacts.*;
import sbca.pageobjects.global.NavigationMenu;
import sbca.tests.framework.BaseTest;
import sbca.tests.framework.TestListener;
import java.util.UUID;

@Listeners(TestListener.class)
public class CreateNewCustomerTests extends BaseTest {

    @BeforeMethod
    public void shouldLoadContactsPageViaGlobalNavigationMenu() {
        NavigationMenu navigationMenu = new NavigationMenu(driver);
        navigationMenu.clickContactsMenuItem();
        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.setSearchTextBox("");
        contactsPage.clickSearchButton();
        contactsPage.clickNewCustomerButton();
    }

    @Test
    public void shouldCreateCustomerWithOnlyRequiredFields() {
        String businessName = UUID.randomUUID().toString();
        NewCustomerContactDialog newCustomerContactDialog = new NewCustomerContactDialog((driver));
        newCustomerContactDialog.setBusinessNameTextBox(businessName);
        newCustomerContactDialog.clickSaveButton();
        newCustomerContactDialog.waitForSaveButtonToBeInvisible();

        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.setSearchTextBox(businessName);
        contactsPage.clickSearchButton();
        contactsPage.waitForNumberOfRecordsTextToEqual("1");
        contactsPage = new ContactsPage(driver);
        contactsPage.validateContactsTableCellText(0,3,businessName);
        contactsPage.clickTableCell(0, 3);

        ContactPageMain contactPageMain = new ContactPageMain(driver);
        contactPageMain.validateContactTitleNameIs(businessName);
        contactPageMain.validateContactTitleTypeIs("Customer");
    }

    @Test
    public void shouldCreateCustomerWithAllFieldsComplete() {
        // complete every field and save. Validate values entered on the customer record screen.
    }

    @Test
    public void shouldNotCreateCustomerWithBusinessNameOmitted() {
        NewCustomerContactDialog newCustomerContactDialog = new NewCustomerContactDialog((driver));
        newCustomerContactDialog.setBusinessNameTextBox("");
        newCustomerContactDialog.clickSaveButton();
        newCustomerContactDialog.waitForValidationSummaryErrorsToBeVisible();
    }

}

