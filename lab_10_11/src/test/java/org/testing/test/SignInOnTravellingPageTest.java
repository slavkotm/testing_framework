package org.testing.test;

import org.testing.model.User;
import org.testing.page.SignInOnTravellingPage;
import org.testing.service.UserCreator;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.*;

public class SignInOnTravellingPageTest extends CommonConditions {
    @Test
    public void testSignInAccountWithCredentialsFromPropertyOnTravellingPage() {
        User testUser = UserCreator.withCredentialsFromProperty();
        String inputEmail = new SignInOnTravellingPage(driver)
                .openPage()
                .clickOnButtonSignIn()
                .inputInFieldUserEmailAndPasswordClickSigIn(testUser)
                .getUserEmail();
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
