package org.testing.test;

import org.testing.model.Order;
import org.testing.page.OrderAviaTicketsOnTravellingPage;
import org.testing.page.OrderHotelTicketsOnTravellingPage;
import org.testing.service.OrderCreator;
import org.testng.annotations.Test;

public class OrderHotelTicketsOnTravellingPageTest extends CommonConditions {
    @Test
    public void testOrderHotelsWithTestDataHotelOnTravellingPage() {
        Order testOrder = OrderCreator.withTestDataHotel();
        OrderHotelTicketsOnTravellingPage orderAviaTicketsOnTravellingPage = new OrderHotelTicketsOnTravellingPage(driver)
                .openPage()
                .clickOnButtonBookingHotels()
                .inputInFieldHotelOrCityAndClickButtonSearch(testOrder);
    }

}
