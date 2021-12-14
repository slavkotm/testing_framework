package org.testing.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.model.Order;

import java.time.Duration;

public class SearchResultOnTravellingPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "https://smorodina.com";
    private static final String MAIN_INPUT = "//*[@id='mainSearchFieldInput']";
    private static final String MAIN_BUTTON = "//*[@id='mainSearchButton']";
    private static final String BUTTON_TESTING_ONE = "//*[@id='searchCategories']/div/button[2]";
    private static final String BUTTON_WHICH_ELEMENT = "//a[@href='/objects/paleontologicheskiy-muzey-im-yu-a-orlova-g-moskva']/b";
    private static final String ARRIVAL_CITY = "//*[@id='flights-destination-prepop-bbf7f70dad1eb1eb261b0b381b1e0588']";
    private static final String DEPARTURE_CITY = "//*[@id='flights-origin-prepop-bbf7f70dad1eb1eb261b0b381b1e0588']";

    @FindBy(xpath = MAIN_INPUT)
    private WebElement searchInputMain;

    @FindBy(xpath = MAIN_BUTTON)
    private WebElement searchButtonMain;

    @FindBy(xpath = BUTTON_TESTING_ONE)
    private WebElement searchTabViews;

    @FindBy(xpath = BUTTON_WHICH_ELEMENT)
    private WebElement searchButtonWhichElement;

    @FindBy(xpath = ARRIVAL_CITY)
    private WebElement searchInputArrivalCity;

    @FindBy(xpath = DEPARTURE_CITY)
    private WebElement searchInputDepartureCity;

    public SearchResultOnTravellingPage inputDepartureAndArrivalCity(Order order) {
        searchInputDepartureCity.sendKeys(order.getDepartureCity());
        searchInputArrivalCity.sendKeys(order.getArrivalCity());
        logger.info("input departure and arrival city complete...");
        return this;
    }

    public SearchResultOnTravellingPage searchPlaceTravelling(Order order) {
        searchInputMain.sendKeys(order.getDepartureCity());
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(MAIN_BUTTON)));
        return this;
    }

    public SearchResultOnTravellingPage completePlaceTravelling() {
        searchButtonMain.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_TESTING_ONE)));
        return this;
    }

    public SearchResultOnTravellingPage completeWhichElement() {
        searchButtonWhichElement.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(DEPARTURE_CITY)));
        return this;
    }

    public SearchResultOnTravellingPage completeView() {
        searchTabViews.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_WHICH_ELEMENT)));
        return this;
    }

    public SearchResultOnTravellingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SearchResultOnTravellingPage openPage() {
        driver.navigate().to(PAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(MAIN_INPUT)));
        return this;
    }
}
