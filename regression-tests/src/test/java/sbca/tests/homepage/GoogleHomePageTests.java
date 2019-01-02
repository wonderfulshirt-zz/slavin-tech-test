package sbca.tests.homepage;

import org.testng.annotations.Test;
import sbca.framework.core.BaseTest;
import sbca.pageobjects.homepage.GoogleHomepage;

public class GoogleHomePageTests extends BaseTest {

    @Test
    public void homepageTests() {
        GoogleHomepage googleHomepage = new GoogleHomepage(getDriver());
    }
}