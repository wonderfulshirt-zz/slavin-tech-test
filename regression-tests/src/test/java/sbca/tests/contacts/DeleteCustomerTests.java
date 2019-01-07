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
public class DeleteCustomerTests extends BaseTest {

    private String businessContactName;

    @BeforeMethod
    public void shouldCreateNewCustomer() {
        setBusinessContactName(UUID.randomUUID().toString());
        String businessName = getBusinessContactName();

        NavigationMenu navigationMenu = new NavigationMenu(driver);
        navigationMenu.clickContactsMenuItem();

        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.setSearchTextBox("");
        contactsPage.clickSearchButton();
        contactsPage.clickNewCustomerButton();

        NewContactDialogBase newContactDialogBase = new NewContactDialogBase((driver));
        newContactDialogBase.setBusinessNameTextBox(businessName);
        newContactDialogBase.clickSaveButton();
        newContactDialogBase.waitForSaveButtonToBeInvisible();

        contactsPage.setSearchTextBox(businessName);
        contactsPage.clickSearchButton();
        contactsPage.waitForNumberOfRecordsTextToEqual("1");
    }

    @Test
    public void shouldDeleteTheSelectedCustomer() {
        ContactsPage contactsPage = new ContactsPage(driver);
        contactsPage.clickTableRowCheckbox(0);
        contactsPage.clickDeleteIcon();

        DeleteContactDialog deleteContactDialog = new DeleteContactDialog(driver);
        deleteContactDialog.clickYesButton();
        deleteContactDialog.waitForYesButtonToBeInvisible();

        contactsPage.setSearchTextBox(getBusinessContactName());
        contactsPage.clickSearchButton();
        contactsPage.waitForNumberOfRecordsTextToEqual("0");
    }

    public void setBusinessContactName(String businessContactName) {
        this.businessContactName = businessContactName;
    }

    public String getBusinessContactName() {
        return businessContactName;
    }

}
