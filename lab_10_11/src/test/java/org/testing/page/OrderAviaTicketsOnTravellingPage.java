package org.testing.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.model.Order;

import java.time.Duration;

public class OrderAviaTicketsOnTravellingPage extends AbstractPage {
    private static final String PAGE_URL = "https://smorodina.com";
    private static final String BOOKING_AVIA_TICKETS = "/html/body/div[1]/div/div[2]/a[3]/div[2]";
    private static final String DEPARTURE_CITY = "//input[@id=\"flights-origin-prepop-c76878bd0f1c77e8da677bb4549036e0\"]";
    private static final String ARRIVAL_CITY = "//input[@id=\"flights-destination-prepop-c76878bd0f1c77e8da677bb4549036e0\"]";
    private static final String FIND_TICKETS = "//*[@id=\"flights-form-c76878bd0f1c77e8da677bb4549036e0\"]/div[6]/button";

    @FindBy(xpath = BOOKING_AVIA_TICKETS)
    private WebElement buttonBookingAviaTickets;

    @FindBy(xpath = DEPARTURE_CITY)
    private WebElement fieldDepartureCity;

    @FindBy(xpath = ARRIVAL_CITY)
    private WebElement fieldArrivalCity;

    @FindBy(xpath = FIND_TICKETS)
    private WebElement buttonFindTickets;

    public OrderAviaTicketsOnTravellingPage(WebDriver driver) {
        super(driver);
    }

    public OrderAviaTicketsOnTravellingPage clickOnButtonBookingAviaTickets() {
        buttonBookingAviaTickets.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(DEPARTURE_CITY)));
        return this;
    }

    public OrderAviaTicketsOnTravellingPage lookPriceTickets(Order order) {
        fieldDepartureCity.sendKeys(order.getDepartureCity());
        fieldArrivalCity.sendKeys(order.getArrivalCity());
        buttonFindTickets.click();
        return this;
    }

    @Override
    public OrderAviaTicketsOnTravellingPage openPage() {
        driver.navigate().to(PAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(BOOKING_AVIA_TICKETS)));
        return this;
    }
}
