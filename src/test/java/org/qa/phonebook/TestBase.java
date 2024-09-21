package org.qa.phonebook;

import org.qa.phonebook.frameWork.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", "chrome"));

    @BeforeMethod
    public void setUp(){
        app.init();
    }

    @AfterMethod //(enabled = false)
    public void  tearDown(){
        app.stop();
    }
}
