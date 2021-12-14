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

public class OrderHotelTicketsOnTravellingPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "https://smorodina.com";
    private static final String BOOKING_HOTEL = "/html/body/div[1]/div/div[2]/a[4]/div[2]";
    private static final String NAME_HOTEL_OR_CITY = "//*[@id=\"hotels-destination-6f3a79b96cd68114d6b1bd7d30a50b8a\"]";
    private static final String BUTTON_PRICE = "//*[@id=\"hotels-form-6f3a79b96cd68114d6b1bd7d30a50b8a\"]/div[5]/button";

    @FindBy(xpath = BOOKING_HOTEL)
    private WebElement buttonBookingHotels;

    @FindBy(xpath = NAME_HOTEL_OR_CITY)
    private WebElement fieldNameHotelOrCity;

    @FindBy(xpath = BUTTON_PRICE)
    private WebElement buttonPrice;

    public OrderHotelTicketsOnTravellingPage clickOnButtonBookingHotels() {
        buttonBookingHotels.click();
        logger.info("booking hotels complete...");
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(NAME_HOTEL_OR_CITY)));
        return this;
    }

    public OrderHotelTicketsOnTravellingPage inputInFieldHotelOrCityAndClickButtonSearch(Order order) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(NAME_HOTEL_OR_CITY)));
        fieldNameHotelOrCity.sendKeys(order.getHotel());
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BUTTON_PRICE)));
        buttonPrice.click();
        logger.info("input hotel or city complete...");
        return this;
    }

    public OrderHotelTicketsOnTravellingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public OrderHotelTicketsOnTravellingPage openPage() {
        driver.navigate().to(PAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BOOKING_HOTEL)));
        return this;
    }

    public String getFieldNameHotelOrCity() {
        return fieldNameHotelOrCity.getAttribute("content");
    }
}
