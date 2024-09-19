package org.qa.phonebook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
    driver= new ChromeDriver();
    driver.get("https://telranedu.web.app");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isHomeComponentPresent(){
        return driver.findElements(By.xpath("//h1[text()='Home Component']")).size()>0;
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    public boolean  isElementPresent2(By locator){
        try {
            driver.findElement(locator);
            return true;
        }catch (NoSuchElementException ex){
            return false;
        }
    }

    @AfterMethod(enabled = false)
    public void  tearDown(){
    driver.quit();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if (alert ==null){
            return false;
        }else {
            driver.switchTo().alert();
            //ok
            alert.accept();
            return true;
        }
    }

    public void clickOnLoginLink() {
        click(By.xpath("//a[contains(text(),'LOGIN')]"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[contains(.,'Sign Out')])"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[contains(text(),'LOGIN')]"));
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//button[text()='Registration']"));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.cssSelector("[placeholder='Email']"), email);
        type(By.cssSelector("[placeholder='Password']"), password);
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[.='Login']"));
    }

    public void clickOnAddLink() {
        click(By.xpath("//a[contains(text(),'ADD')]"));
    }

    public void clickOnSaveButton() {
        click(By.xpath("//b[contains(text(),'Save')]"));
    }

    public void fillContactForm(String name, String surname, String phone, String email, String address, String description) {
        type(By.cssSelector("input:nth-child(1)"), name);
        type(By.cssSelector("input:nth-child(2)"), surname);
        type(By.cssSelector("input:nth-child(3)"), phone);
        type(By.cssSelector("input:nth-child(4)"), email);
        type(By.cssSelector("input:nth-child(5)"), address);
        type(By.cssSelector("input:nth-child(6)"), description);
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
        click(By.cssSelector(".contact-item_card__2SOIM")); //contact-card
        click(By.xpath("//button[contains(text(),'Remove')]"));
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

    public void addContact() {
        clickOnAddLink();
        fillContactForm("James", "Bond", "1234567890", "james@gmail.com", "Leipzig", "actor");
        clickOnSaveButton();
    }

    public void login() {
        clickOnLoginLink();
        fillLoginRegistrationForm("test2024@gmail.com", "Test_2024$");
        clickOnLoginButton();
    }
}
