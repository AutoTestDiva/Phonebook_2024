package org.qa.phonebook;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        //precondition: user should be logged out
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        login();
        clickOnAddLink();
    }

    @Test
    public void addContactPositiveTest() {
        fillContactForm(new Contact().setName("James").setSurname("Bond").setPhone("1234567890")
                .setEmail("james@gmail.com").setAddress("Leipzig").setDescription("actor"));
        clickOnSaveButton();
        Assert.assertTrue(isContactAdded("James"));
    }

    @AfterMethod
    public void postCondition() {
        removeContact();
    }

}
