package org.testing.service;

import org.testing.model.User;

public class UserCreator {

    public static final String TEST_DATA_EMAIL = "testdata.email.name";
    public static final String TEST_DATA_USER_PASSWORD = "testdata.user.password";

    public static User withCredentialsFromProperty() {
        return new User(
                TestDataReader.getTestData(TEST_DATA_EMAIL),
                TestDataReader.getTestData(TEST_DATA_USER_PASSWORD)
        );
    }

    public static User withEmptyUserEmail() {
        return new User("", TestDataReader.getTestData(TEST_DATA_USER_PASSWORD));
    };

    public static User withEmptyUserPassword() {
        return new User(TestDataReader.getTestData(TEST_DATA_EMAIL), "");
    };
}
