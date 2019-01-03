package sbca.tests.loginpage;

import org.testng.annotations.Test;
import sbca.framework.core.BaseTest;
import sbca.pageobjects.general.LoginPage;
import static org.testng.Assert.assertTrue;
import org.testng.Reporter;

public class LoginPageTests extends BaseTest {

    private String loginPageAddress = "https://app.sageone.com/login";

    @Test
    public void loginSuccess() {
        driver.get(loginPageAddress);

        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isInitialized());
    }

}
