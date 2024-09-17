package org.qa.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        //precondition: user should be logged out
        if(!isLoginLinkPresent()){
            clickOnSignOutButton();
        }
        clickOnLoginLink();
        fillLoginRegistrationForm("test2024@gmail.com", "Test_2024$");
        click(By.xpath("//button[.='Login']"));
        click(By.xpath("//a[contains(text(),'ADD')]"));

            type(By.cssSelector("input:nth-child(1)"), "James");
            type(By.cssSelector("input:nth-child(2)"), "Bond");
            type(By.cssSelector("input:nth-child(3)"), "1234567890");
            type(By.cssSelector("input:nth-child(4)"), "james@gmail.com");
            type(By.cssSelector("input:nth-child(5)"), "Leipzig");
            type(By.cssSelector("input:nth-child(6)"), "actor");
            click(By.xpath("//b[contains(text(),'Save')]"));
    }

    @Test
    public void removeContactPositiveTest(){
        int sizeBefore = sizeOfContacts();
        click(By.cssSelector(".contact-item_card__2SOIM")); //contact-card
        click(By.xpath("//button[contains(text(),'Remove')]"));
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }

    public void pause(int millis)  {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public int sizeOfContacts(){
        if(isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
            return  driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }

}
