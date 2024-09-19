package org.qa.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        //precondition: user should be logged out
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        login();
        addContact();
    }

    @Test
    public void removeContactPositiveTest() {
        int sizeBefore = sizeOfContacts();
        removeContact();
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }
}
