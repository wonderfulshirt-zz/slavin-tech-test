package sbca.tests.contacts;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sbca.pageobjects.contacts.ContactsPage;
import sbca.pageobjects.contacts.CreateNewCustomerDialog;
import sbca.pageobjects.global.NavigationMenu;
import sbca.tests.base.BaseTest;
import java.util.UUID;
import static org.testng.Assert.assertEquals;

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
        createNewCustomerDialog.waitforSaveButtonToBeInvisible();

        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.setSearchTextBox(businessName);
        contactsPage.clickSearchButton();
        contactsPage.waitForNumberOfRecordsTextToEqual("1");
        contactsPage.validateContactsTableCellText(0,3,businessName);
    }

    @Test
    public void shouldCreateCustomerWithAllFieldsComplete() {

    }


    @Test
    public void shouldNotCreateCustomerWithBusinessNameOmitted() {

    }

}

