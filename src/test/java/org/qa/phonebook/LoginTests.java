package org.qa.phonebook;

import org.qa.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        //precondition: user should be logged out
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        //click on Login Link - (By.xpath("//a[contains(text(),'LOGIN')]"))
        app.getUser().clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest(){
        //enter email - [placeholder='Email'] - css
        app.getUser().fillLoginRegistrationForm(new User().setEmail("test2024@gmail.com").setPassword("Test_2024$"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //Assert Sign out button displayed - //button[contains(.,'Sign Out')] - XPath
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }
    @Test
    public void loginNegativeWithoutEmailTest(){
        //enter email - [placeholder='Email'] - css
        app.getUser().fillLoginRegistrationForm(new User().setPassword("Test_2024$"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //Assert Sign out button displayed - //button[contains(.,'Sign Out')] - XPath
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
    @Test
    public void loginNegativeWithoutPasswordTest(){
        //enter email - [placeholder='Email'] - css
        app.getUser().fillLoginRegistrationForm(new User().setEmail("test2024@gmail.com"));
        //click on Login button
        app.getUser().clickOnLoginButton();
        //Assert Sign out button displayed - //button[contains(.,'Sign Out')] - XPath
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
