package org.qa.phonebook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase{

    @Test
    public void isHomeComponentPresentTest(){
       //System.out.println("Home Component is "+ isHomeComponentPresent());
//       System.out.println("Home Component is "+
//               isElementPresent(By.xpath("//h1[text()='Home Component']")));

        Assert.assertTrue(isHomeComponentPresent());
    }


}
