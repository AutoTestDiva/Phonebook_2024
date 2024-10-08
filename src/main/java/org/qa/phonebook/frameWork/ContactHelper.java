package org.qa.phonebook.frameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qa.phonebook.models.Contact;

import java.util.List;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddLink() {
        click(By.xpath("//a[contains(text(),'ADD')]"));
    }

    public void clickOnSaveButton() {
        click(By.xpath("//b[contains(text(),'Save')]"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("input:nth-child(1)"), contact.getName());
        type(By.cssSelector("input:nth-child(2)"), contact.getSurname());
        type(By.cssSelector("input:nth-child(3)"), contact.getPhone());
        type(By.cssSelector("input:nth-child(4)"), contact.getEmail());
        type(By.cssSelector("input:nth-child(5)"), contact.getAddress());
        type(By.cssSelector("input:nth-child(6)"), contact.getDescription());
    }

    public boolean isContactAdded(String text){
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for(WebElement el: contacts){
            if (el.getText().contains(text))
                return true;
        }
        return false;
    }

    public void removeContact() {
        pause(1000);
        click(By.cssSelector(".contact-item_card__2SOIM")); //contact-card
        click(By.xpath("//button[contains(text(),'Remove')]"));
        pause(1000);
    }

    public int sizeOfContacts(){
        if(isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
            return  driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }

    public void addContact() {
        clickOnAddLink();
        fillContactForm(new Contact()
                .setName("James")
                .setSurname("Bond")
                .setPhone("1234567890")
                .setEmail("james@gmail.com")
                .setAddress("Leipzig")
                .setDescription("actor"));
        clickOnSaveButton();
    }
}
