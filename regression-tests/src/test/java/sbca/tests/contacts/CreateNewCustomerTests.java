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
        NewContactDialogBase newContactDialogBase = new NewContactDialogBase((driver));
        newContactDialogBase.setBusinessNameTextBox(businessName);
        newContactDialogBase.clickSaveButton();
        newContactDialogBase.waitForSaveButtonToBeInvisible();

        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.setSearchTextBox(businessName);
        contactsPage.clickSearchButton();
        contactsPage.waitForNumberOfRecordsTextToEqual("1");
        contactsPage.validateContactsTableCellText(0,3,businessName);
        contactsPage.clickTableCell(0, 3);

        ContactPageMain contactPageMain = new ContactPageMain(driver);
        contactPageMain.validateContactTitleNameIs(businessName);
        contactPageMain.validateContactTitleTypeContains("Customer");
    }

    @Test
    public void shouldCreateCustomerWithAllFieldsComplete() {
        String businessName = UUID.randomUUID().toString();
        NewContactDialogBase newContactDialogBase = new NewContactDialogBase((driver));
        newContactDialogBase.setBusinessNameTextBox(businessName);

        // Add other inputs here

        newContactDialogBase.clickSaveButton();
        newContactDialogBase.waitForSaveButtonToBeInvisible();

        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.setSearchTextBox(businessName);
        contactsPage.clickSearchButton();
        contactsPage.waitForNumberOfRecordsTextToEqual("1");
        contactsPage.validateContactsTableCellText(0,3,businessName);
        contactsPage.clickTableCell(0, 3);

        ContactPageMain contactPageMain = new ContactPageMain(driver);
        contactPageMain.validateContactTitleNameIs(businessName);
        contactPageMain.validateContactTitleTypeContains("Customer");

        // Validate other inputs here
    }

    @Test
    public void shouldNotCreateCustomerWithBusinessNameOmitted() {
        NewContactDialogBase newContactDialogBase = new NewContactDialogBase((driver));
        newContactDialogBase.setBusinessNameTextBox("");
        newContactDialogBase.clickSaveButton();
        newContactDialogBase.waitForValidationSummaryErrorsToBeVisible();
    }

    @Test
    public void shouldFailBecauseBusinessNameIsARequiredField() {
        NewContactDialogBase newContactDialogBase = new NewContactDialogBase((driver));
        newContactDialogBase.setBusinessNameTextBox("");
        newContactDialogBase.clickSaveButton();
        // Validation stops the form from closing, so this step will fail
        newContactDialogBase.waitForSaveButtonToBeInvisible();
    }

}

