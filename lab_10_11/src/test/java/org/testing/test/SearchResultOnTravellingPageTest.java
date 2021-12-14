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
        SearchResultOnTravellingPage searchResultOnTravellingPage = new SearchResultOnTravellingPage(driver)
                .openPage()
                .searchPlaceTravelling(testOrder)
                .completePlaceTravelling()
                .completeView()
                .completeWhichElement()
                .inputDepartureAndArrivalCity(testOrder);
    }

    @Test
    public void testSearchAviaTicketsWithEmptyArrivalCityForTravel() {
        Order testOrder = OrderCreator.withEmptyArrivalCity();
        SearchResultOnTravellingPage searchResultOnTravellingPage = new SearchResultOnTravellingPage(driver)
                .openPage()
                .searchPlaceTravelling(testOrder)
                .completePlaceTravelling()
                .completeView()
                .completeWhichElement()
                .inputDepartureAndArrivalCity(testOrder);
    }
}
