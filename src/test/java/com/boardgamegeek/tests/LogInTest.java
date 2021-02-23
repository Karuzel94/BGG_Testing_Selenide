package com.boardgamegeek.tests;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogInTest extends BaseTest{

    @Test
    public void logInTest() {
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        assertThat(loginProperties.getUsername()).isEqualTo(userMenuFragment.getUserName());
    }

}
