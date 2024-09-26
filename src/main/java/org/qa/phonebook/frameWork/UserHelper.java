package org.qa.phonebook.frameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qa.phonebook.models.User;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver driver) {
        super(driver);
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

    public void fillLoginRegistrationForm(User user) {
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
    }

    public void fillLoginRegistrationFormForScreencast(User user) {
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        pause(500);
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
        pause(500);
    }



    public boolean isSignOutButtonPresent() {
        return isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[.='Login']"));
    }

    public void login() {
        clickOnLoginLink();
        fillLoginRegistrationForm(new User().setEmail("test2024@gmail.com").setPassword("Test_2024$"));
        clickOnLoginButton();
    }
}
