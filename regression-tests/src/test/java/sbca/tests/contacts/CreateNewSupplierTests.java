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
public class CreateNewSupplierTests extends BaseTest {

    @BeforeMethod
    public void shouldLoadContactsPageViaGlobalNavigationMenu() {
        NavigationMenu navigationMenu = new NavigationMenu(driver);
        navigationMenu.clickContactsMenuItem();
        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.setSearchTextBox("");
        contactsPage.clickSearchButton();
        contactsPage.clickNewSupplierButton();
    }

    @Test
    public void shouldCreateSupplierWithOnlyRequiredFields() {
        String businessName = UUID.randomUUID().toString();
        NewContactDialogBase newContactDialogBase = new NewContactDialogBase((driver));
        newContactDialogBase.setBusinessNameTextBox(businessName);
        newContactDialogBase.clickSaveButton();
        newContactDialogBase.waitForSaveButtonToBeInvisible();

        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.setSearchTextBox(businessName);
        contactsPage.clickSearchButton();
        contactsPage.waitForNumberOfRecordsTextToEqual("1");
        contactsPage = new ContactsPage(driver);
        contactsPage.validateContactsTableCellText(0,3,businessName);
        contactsPage.clickTableCell(0, 3);

        ContactPageMain contactPageMain = new ContactPageMain(driver);
        contactPageMain.validateContactTitleNameIs(businessName);
        contactPageMain.validateContactTitleTypeContains("Supplier");
    }

    @Test
    public void shouldCreateSupplierWithAllFieldsComplete() {
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
        contactsPage = new ContactsPage(driver);
        contactsPage.validateContactsTableCellText(0,3,businessName);
        contactsPage.clickTableCell(0, 3);

        ContactPageMain contactPageMain = new ContactPageMain(driver);
        contactPageMain.validateContactTitleNameIs(businessName);
        contactPageMain.validateContactTitleTypeContains("Supplier");

        // Validate other inputs here
    }

    @Test
    public void shouldNotCreateSupplierWithBusinessNameOmitted() {
        NewContactDialogBase newContactDialogBase = new NewContactDialogBase((driver));
        newContactDialogBase.setBusinessNameTextBox("");
        newContactDialogBase.clickSaveButton();
        newContactDialogBase.waitForValidationSummaryErrorsToBeVisible();
    }

}

