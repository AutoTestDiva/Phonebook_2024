package org.qa.phonebook;

import org.qa.phonebook.models.Contact;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        //precondition: user should be logged out
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().login();
        app.getContact().clickOnAddLink();
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().fillContactForm(new Contact().setName("James").setSurname("Bond").setPhone("1234567890")
                .setEmail("james@gmail.com").setAddress("Leipzig").setDescription("actor"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded("James"));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }

}
