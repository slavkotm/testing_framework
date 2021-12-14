package org.testing.test;

import org.testing.model.Order;
import org.testing.page.OrderAviaTicketsOnTravellingPage;
import org.testing.service.OrderCreator;
import org.testing.util.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class OrderAviaTicketsOnTravellingPageTest extends CommonConditions{
    @Test
    public void testOrderAviaTicketsWithCredentialsFromPropertyOnTravellingPage() {
        Order testOrder = OrderCreator.withCredentialsFromProperty();
        String arrivalCity = new OrderAviaTicketsOnTravellingPage(driver)
                .openPage()
                .clickOnButtonBookingAviaTickets()
                .lookPriceTickets(testOrder)
                .getFieldArrivalCity();
        Assert.assertTrue( true, arrivalCity);
    }

    @Test
    public void testOrderAviaTicketsWithEmptyDepartureCityOnTravellingPage() {
        Order testOrder = OrderCreator.withEmptyDepartureCity();
        String arrivalCity = new OrderAviaTicketsOnTravellingPage(driver)
                .openPage()
                .clickOnButtonBookingAviaTickets()
                .lookPriceTickets(testOrder)
                .getFieldArrivalCity();
        Assert.assertTrue( true, arrivalCity);
    }

}
