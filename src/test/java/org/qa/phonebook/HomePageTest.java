package org.qa.phonebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePageTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
    driver= new ChromeDriver();
    driver.get("https://telranedu.web.app");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void isHomeComponentPresentTest(){
        driver.findElement(By.)
    }


    @AfterMethod
    public void  tearDown(){
    driver.quit();
    }
}
