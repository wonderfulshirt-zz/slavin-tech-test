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
    public void shouldCreateCustomerWithOnlyRequiredFields() {
        String businessName = UUID.randomUUID().toString();
        NewSupplierContactDialog newSupplierContactDialog = new NewSupplierContactDialog((driver));
        newSupplierContactDialog.setBusinessNameTextBox(businessName);
        newSupplierContactDialog.clickSaveButton();
        newSupplierContactDialog.waitForSaveButtonToBeInvisible();

        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.setSearchTextBox(businessName);
        contactsPage.clickSearchButton();
        contactsPage.waitForNumberOfRecordsTextToEqual("1");
        contactsPage = new ContactsPage(driver);
        contactsPage.validateContactsTableCellText(0,3,businessName);
        contactsPage.clickTableCell(0, 3);

        ContactPageMain contactPageMain = new ContactPageMain(driver);
        contactPageMain.validateContactTitleNameIs(businessName);
        contactPageMain.validateContactTitleTypeIs("Supplier");
    }

    @Test
    public void shouldCreateCustomerWithAllFieldsComplete() {
        // complete every field and save. Validate values entered on the customer record screen.
    }

    @Test
    public void shouldNotCreateCustomerWithBusinessNameOmitted() {
        NewSupplierContactDialog newSupplierContactDialog = new NewSupplierContactDialog((driver));
        newSupplierContactDialog.setBusinessNameTextBox("");
        newSupplierContactDialog.clickSaveButton();
        newSupplierContactDialog.waitForValidationSummaryErrorsToBeVisible();
    }

}

