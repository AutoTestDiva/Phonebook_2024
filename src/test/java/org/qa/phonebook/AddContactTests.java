package org.qa.phonebook;

import org.qa.phonebook.models.Contact;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @DataProvider
    public Iterator<Object[]> newContact(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kan", "1234567890", "kan@gmail.com", "Berlin", "actor"});
        list.add(new Object[]{"Oliver1", "Kan", "1234567898", "kan@gmail.com", "Berlin", "actor"});
        list.add(new Object[]{"Oliver2", "Kan", "1234567899", "kan@gmail.com", "Berlin", "actor"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> newContactWithCSVFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader= new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            list.add(new Object[]{new Contact()
                    .setName(split[0])
                    .setSurname(split[1])
                    .setPhone(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDescription(split[5])});
        line = reader.readLine();
        }
        return list.iterator();
    }
    @Test(dataProvider = "newContact")
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

    @Test(dataProvider = "newContactWithCSVFile")
    public void addContactPositiveTestFromDataProviderWithCSV(Contact contact) {
        app.getContact().fillContactForm(contact);
        app.getContact().pause(1000);
        app.getContact().clickOnSaveButton();
        app.getContact().pause(1000);
        Assert.assertEquals(Integer.toString(app.getContact().sizeOfContacts()), "1");
    }
}
