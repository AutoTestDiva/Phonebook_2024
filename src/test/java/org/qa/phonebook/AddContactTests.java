package org.qa.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase{
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
    }

    @Test
    public void addContactPositiveTest(){
        type(By.cssSelector("input:nth-child(1)"), "James");
        type(By.cssSelector("input:nth-child(2)"), "Bond");
        type(By.cssSelector("input:nth-child(3)"), "1234567890");
        type(By.cssSelector("input:nth-child(4)"), "james@gmail.com");
        type(By.cssSelector("input:nth-child(5)"), "Leipzig");
        type(By.cssSelector("input:nth-child(6)"), "actor");
        click(By.xpath("//b[contains(text(),'Save')]"));
        Assert.assertTrue(isContactAdded("James"));
    }
    public boolean isContactAdded(String text){
        List<WebElement>contacts = driver.findElements(By.cssSelector("h2"));
        for(WebElement el: contacts){
            if (el.getText().contains(text))
                return true;
        }
        return false;
    }
    @AfterMethod
    public void postCondition(){
        click(By.cssSelector(".contact-item_card__2SOIM")); //contact-card
        click(By.xpath("//button[contains(text(),'Remove')]"));
    }
}
