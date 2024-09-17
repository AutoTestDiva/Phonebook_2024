package org.qa.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        //precondition: user should be logged out
        if(!isLoginLinkPresent()){
            clickOnSignOutButton();
        }
        //click on Login Link - (By.xpath("//a[contains(text(),'LOGIN')]"))
        clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest(){
        //enter email - [placeholder='Email'] - css
        fillLoginRegistrationForm("test2024@gmail.com", "Test_2024$");

        //click on Login button
        click(By.xpath("//button[.='Login']"));

        //Assert Sign out button displayed - //button[contains(.,'Sign Out')] - XPath
        Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]")));
    }

}
