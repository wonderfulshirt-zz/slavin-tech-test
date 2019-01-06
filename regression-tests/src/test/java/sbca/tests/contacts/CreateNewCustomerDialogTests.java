package sbca.tests.contacts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sbca.pageobjects.contacts.ContactsPage;
import sbca.pageobjects.contacts.CreateNewCustomerDialog;
import sbca.pageobjects.global.NavigationMenu;
import sbca.tests.framework.BaseTest;
import sbca.tests.framework.TestListener;

import java.util.UUID;
import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class CreateNewCustomerDialogTests extends BaseTest {

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
        CreateNewCustomerDialog createNewCustomerDialog = new CreateNewCustomerDialog(driver);
        createNewCustomerDialog.setBusinessNameTextBox(businessName);
        createNewCustomerDialog.clickSaveButton();
        createNewCustomerDialog.waitForSaveButtonToBeInvisible();

        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.setSearchTextBox(businessName);
        contactsPage.clickSearchButton();
        contactsPage.waitForNumberOfRecordsTextToEqual("1");
        contactsPage.validateContactsTableCellText(0,3,businessName);
        contactsPage.clickTableCell(0, 3);
    }

    @Test
    public void shouldCreateCustomerWithAllFieldsComplete() {

    }


    @Test
    public void shouldNotCreateCustomerWithBusinessNameOmitted() {

    }

}

