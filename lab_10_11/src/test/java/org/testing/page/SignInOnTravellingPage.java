package org.testing.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.model.User;

import java.time.Duration;

public class SignInOnTravellingPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private static final String SIGN_IN_PAGE_URL = "https://smorodina.com";
    private static final String BUTTON_SIGN_IN = "//a[@id='show_registration_modal' and @class='ui-link']";
    private static final String USER_EMAIL = "//input[@id='user_login_email' and @class='email span12']";
    private static final String USER_PASSWORD = "//input[@id='user_login_password' and @class='password span12']";
    private static final String SIGN_IN_BANNER = "//div[@id='regLoginModal' and @class='modal hide fade reg-modal in']/div[@class='modal-content']";
    private static final String BUTTON_ENTER = "//button[@id='login']/span";

    @FindBy(xpath = BUTTON_SIGN_IN)
    private WebElement buttonSignIn;

    @FindBy(xpath = USER_EMAIL)
    private WebElement fieldUserEmail;

    @FindBy(xpath = USER_PASSWORD)
    private WebElement fieldUserPassword;

    @FindBy(xpath = BUTTON_ENTER)
    private WebElement buttonEnter;

    public SignInOnTravellingPage(WebDriver driver) {
        super(driver);
    }

    public SignInOnTravellingPage clickOnButtonSignIn() {
        buttonSignIn.click();
        logger.info("sign in complete...");
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SIGN_IN_BANNER)));
        return this;
    }

    public SignInOnTravellingPage inputInFieldUserEmailAndPasswordClickSigIn(User user) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(USER_EMAIL)));
        fieldUserEmail.sendKeys(user.getEmail());
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(USER_PASSWORD)));
        fieldUserPassword.sendKeys(user.getPassword());
        buttonEnter.click();
        logger.info("input data for sign in complete...");
        return this;
    }

    @Override
    public SignInOnTravellingPage openPage() {
        driver.navigate().to(SIGN_IN_PAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_SIGN_IN)));
        return this;
    }

    public String getUserEmail() {
        return fieldUserEmail.getAttribute("content");
    }

    public String getUserPassword() {
        return fieldUserPassword.getAttribute("content");
    }
}
