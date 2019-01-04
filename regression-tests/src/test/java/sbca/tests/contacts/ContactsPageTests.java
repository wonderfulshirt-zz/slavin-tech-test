package sbca.tests.contacts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sbca.tests.base.BaseTest;
import sbca.pageobjects.global.NavigationMenu;
import sbca.pageobjects.contacts.*;

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

        String businessName = UUID.randomUUID().toString().replace("-", "");;

        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.clickNewCustomerButton();

        CreateNewCustomerDialog createNewCustomerDialog = new CreateNewCustomerDialog(driver);
        createNewCustomerDialog.enterTextInBusinessNameTextBox(businessName);
        createNewCustomerDialog.clickSaveButton();
        createNewCustomerDialog.waitForCreateNewCustomerDialogToBeInvisible();

        contactsPage.enterSearchText(businessName);
        contactsPage.clickSearchButton();

        contactsPage.waitForNumberOfContactsInTableToEqual("1");
        contactsPage.checkContactsTableCellText(1, 3, businessName);

    }
}
