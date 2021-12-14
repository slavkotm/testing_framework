package org.testing.test;

import org.testing.model.Order;
import org.testing.page.OrderAviaTicketsOnTravellingPage;
import org.testing.service.OrderCreator;
import org.testng.annotations.Test;

public class OrderAviaTicketsOnTravellingPageTest extends CommonConditions{
    @Test
    public void testOrderAviaTicketsWithCredentialsFromPropertyOnTravellingPage() {
        Order testOrder = OrderCreator.withCredentialsFromProperty();
        OrderAviaTicketsOnTravellingPage orderAviaTicketsOnTravellingPage = new OrderAviaTicketsOnTravellingPage(driver)
                .openPage()
                .clickOnButtonBookingAviaTickets()
                .lookPriceTickets(testOrder);

    }

    @Test
    public void testOrderAviaTicketsWithEmptyDepartureCityOnTravellingPage() {
        Order testOrder = OrderCreator.withEmptyDepartureCity();
        OrderAviaTicketsOnTravellingPage orderAviaTicketsOnTravellingPage = new OrderAviaTicketsOnTravellingPage(driver)
                .openPage()
                .clickOnButtonBookingAviaTickets()
                .lookPriceTickets(testOrder);

    }

}
