package sbca.tests.contacts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sbca.pageobjects.contacts.ContactsPage;
import sbca.pageobjects.contacts.CreateNewContactDialogBase;
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
        CreateNewContactDialogBase createNewContactDialogBase = new CreateNewContactDialogBase(driver);
        createNewContactDialogBase.setBusinessNameTextBox(businessName);
        createNewContactDialogBase.clickSaveButton();
        createNewContactDialogBase.waitForSaveButtonToBeInvisible();

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

