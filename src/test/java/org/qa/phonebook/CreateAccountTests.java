package org.qa.phonebook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {


    @BeforeMethod
    public void ensurePrecondition() {
        //precondition: user should be logged out
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        //click on Login Link - (By.xpath("//a[contains(text(),'LOGIN')]"))
        app.getUser().clickOnLoginLink();
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        //enter email - [placeholder='Email'] - css
        app.getUser().fillLoginRegistrationForm(new User().setEmail("test2024@gmail.com").setPassword("Test_2024$"));
        //click on registration button - //button[text()='Registration' - XPath
        app.getUser().clickOnRegistrationButton();

        //Assert alert is appeared
        // Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
