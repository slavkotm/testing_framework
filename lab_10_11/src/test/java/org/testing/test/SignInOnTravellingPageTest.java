package org.testing.test;

import org.testing.model.User;
import org.testing.page.SignInOnTravellingPage;
import org.testing.service.UserCreator;
import org.testng.annotations.Test;

public class SignInOnTravellingPageTest extends CommonConditions {
    @Test
    public void testSignInAccountWithCredentialsFromPropertyOnTravellingPage() throws InterruptedException {
        User testUser = UserCreator.withCredentialsFromProperty();
        SignInOnTravellingPage signInOnTravellingPage = new SignInOnTravellingPage(driver)
                .openPage()
                .clickOnButtonSignIn()
                .inputInFieldUserEmailAndPasswordClickSigIn(testUser);
        Thread.sleep(5000);
    }

    @Test
    public void testSignInAccountWithEmptyUserEmailOnTravellingPage() {
        User testUser = UserCreator.withEmptyUserEmail();
        SignInOnTravellingPage signInOnTravellingPage = new SignInOnTravellingPage(driver)
                .openPage()
                .clickOnButtonSignIn()
                .inputInFieldUserEmailAndPasswordClickSigIn(testUser);
    }

    @Test
    public void testSignInAccountWithEmptyUserPasswordOnTravellingPage() {
        User testUser = UserCreator.withEmptyUserPassword();
        SignInOnTravellingPage signInOnTravellingPage = new SignInOnTravellingPage(driver)
                .openPage()
                .clickOnButtonSignIn()
                .inputInFieldUserEmailAndPasswordClickSigIn(testUser);
    }
}
