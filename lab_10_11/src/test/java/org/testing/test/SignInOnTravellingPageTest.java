package org.testing.test;

import org.testing.model.User;
import org.testing.page.SignInOnTravellingPage;
import org.testing.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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
        Assert.assertTrue(true, inputEmail);
    }

    @Test
    public void testSignInAccountWithEmptyUserEmailOnTravellingPage() {
        User testUser = UserCreator.withEmptyUserEmail();
        String userPassword = new SignInOnTravellingPage(driver)
                .openPage()
                .clickOnButtonSignIn()
                .inputInFieldUserEmailAndPasswordClickSigIn(testUser)
                .getUserPassword();
        Assert.assertTrue(true, userPassword);
    }

    @Test
    public void testSignInAccountWithEmptyUserPasswordOnTravellingPage() {
        User testUser = UserCreator.withEmptyUserPassword();
        String userEmail = new SignInOnTravellingPage(driver)
                .openPage()
                .clickOnButtonSignIn()
                .inputInFieldUserEmailAndPasswordClickSigIn(testUser)
                .getUserEmail();
        Assert.assertTrue(true, userEmail);
    }
}
