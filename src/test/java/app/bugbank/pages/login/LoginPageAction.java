package app.bugbank.pages.login;

import app.bugbank.utils.SeleniumUtils;
import app.bugbank.utils.SetUp;
import org.springframework.stereotype.Component;
import org.testng.asserts.Assertion;

@Component
public class LoginPageAction extends LoginElementMap {

    Assertion assertion = new Assertion();


    public void accesHomePage() {
        SetUp.getDriver().navigate().to("https://bugbank.netlify.app");
        SeleniumUtils.waitUntilAppears(imgLogo, 15L);
        assertion.assertTrue(imgLogo.isDisplayed());
    }
}
