package org.testing.test;

import org.openqa.selenium.WebDriver;
import org.testing.driver.DriverSingleton;
import org.testing.util.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    @BeforeMethod()
    public void setUp() { driver = DriverSingleton.getDriver(); }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() { DriverSingleton.closeDriver(); }
}
