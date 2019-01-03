package sbca.tests.contacts;

import org.testng.annotations.Test;
import sbca.tests.base.BaseTest;
import sbca.pageobjects.global.NavigationMenu;
import sbca.pageobjects.contacts.ContactsPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactsPageTests extends BaseTest {
    @Test
    public void loadContactsPageViaGlobalNavigationMenu() {
        NavigationMenu navigationMenu = new NavigationMenu(driver);
        assertTrue(navigationMenu.isInitialized());

        
        //        ContactsPage contactsPage = new ContactsPage(driver);
//        assertTrue(contactsPage)
    }
}
