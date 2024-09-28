package org.qa.phonebook;

import org.qa.phonebook.models.Contact;
import org.qa.phonebook.utils.DataProviders;
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
        app.getContact().fillContactForm(new Contact()
                .setName("James")
                .setSurname("Bond")
                .setPhone("1234567890")
                .setEmail("james@gmail.com")
                .setAddress("Leipzig")
                .setDescription("actor"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded("James"));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }

      @Test(dataProvider = "newContact", dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProvider(String name, String surname, String phone,
                                                       String email, String address,String description) {
        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setSurname(surname)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description));

        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(name));
    }

    @Test(dataProvider = "newContactWithCSVFile", dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProviderWithCSV(Contact contact) {
        app.getContact().fillContactForm(contact);
        app.getContact().pause(1000);
        app.getContact().clickOnSaveButton();
        app.getContact().pause(1000);
        Assert.assertEquals(Integer.toString(app.getContact().sizeOfContacts()), "1");
    }
}
