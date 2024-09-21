package org.qa.phonebook;

import org.qa.phonebook.frameWork.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", "chrome"));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod //(enabled = false)
    public void tearDown() {
        app.stop();
    }


    @BeforeMethod
    public void startTest() {
    logger.info("Start test");
    }

    @AfterMethod
    public void stopTest(){
        logger.info("Stop test");
    }
}
