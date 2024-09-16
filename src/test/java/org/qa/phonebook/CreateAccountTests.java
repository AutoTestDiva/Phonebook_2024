package org.qa.phonebook;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{


    @BeforeMethod
    public void ensurePrecondition(){
        //precondition: user should be logged out
        if(!isElementPresent(By.xpath("//a[contains(text(),'LOGIN')]"))){
            click(By.xpath("//button[contains(.,'Sign Out')])"));
        }
        //click on Login Link - (By.xpath("//a[contains(text(),'LOGIN')]"))
        click(By.xpath("//a[contains(text(),'LOGIN')]"));
    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        //enter email - [placeholder='Email'] - css
        type(By.cssSelector("[placeholder='Email']"), "test2024@gmail.com");

        //enter password - [placeholder='Password'] - css
        type(By.cssSelector("[placeholder='Password']"), "Test_2024$");

        //click on registration button - //button[text()='Registration' - XPath
        click(By.xpath("//button[text()='Registration']"));

        //click on Login button
      //  driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();

        //Assert alert is appeared
       // Assert.assertTrue(isAlertPresent());
    }



   /* @Test
    public void newUserRegistrationPositiveTest(){
    //enter email - [placeholder='Email'] - css
        driver.findElement(By.cssSelector("[placeholder='Email']")).click();
        driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("test2024@gmail.com");

    //enter password - [placeholder='Password'] - css
        driver.findElement(By.cssSelector("[placeholder='Password']")).click();
        driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Test_2024$");

    //click on registration button - //button[text()='Registration' - XPath
    //   driver.findElement(By.xpath("//button[text()='Registration']")).click();

        //click on Login button
        driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();

    //Assert Sign out button displayed - //button[contains(.,'Sign Out')] - XPath
        Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]")));
    }
    */
}
