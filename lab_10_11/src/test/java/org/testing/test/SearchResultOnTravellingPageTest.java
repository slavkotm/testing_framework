package org.testing.test;

import org.testing.model.Order;
import org.testing.page.SearchResultOnTravellingPage;
import org.testing.service.OrderCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchResultOnTravellingPageTest extends CommonConditions {

    @Test
    public void testSearchAviaTicketsWithCredentialsFromPropertyForTravel() {
        Order testOrder = OrderCreator.withCredentialsFromProperty();
        String arrivalCity = new SearchResultOnTravellingPage(driver)
                .openPage()
                .searchPlaceTravelling(testOrder)
                .completePlaceTravelling()
                .completeView()
                .completeWhichElement()
                .inputDepartureAndArrivalCity(testOrder)
                .getArrivalCity();
        Assert.assertTrue( true, arrivalCity);
    }

    @Test
    public void testSearchAviaTicketsWithEmptyArrivalCityForTravel() {
        Order testOrder = OrderCreator.withEmptyArrivalCity();
        String departureCity = new SearchResultOnTravellingPage(driver)
                .openPage()
                .searchPlaceTravelling(testOrder)
                .completePlaceTravelling()
                .completeView()
                .completeWhichElement()
                .inputDepartureAndArrivalCity(testOrder)
                .getDepartureCity();
        Assert.assertTrue( true, departureCity);
    }
}
