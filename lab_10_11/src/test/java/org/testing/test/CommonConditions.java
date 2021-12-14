package org.testing.test;

import org.openqa.selenium.WebDriver;
import org.testing.driver.DriverSingleton;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {
    protected WebDriver driver;

    @BeforeMethod()
    public void setUp() { driver = DriverSingleton.getDriver(); }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() { DriverSingleton.closeDriver(); }
}
