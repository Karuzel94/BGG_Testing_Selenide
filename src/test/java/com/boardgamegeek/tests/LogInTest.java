package com.boardgamegeek.tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogInTest extends BaseTest {

    @Test
    public void logInTest() {
        Selenide.open("https://boardgamegeek.com/");
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        assertThat(loginProperties.getUsername()).isEqualTo(userMenuFragment.getUserName());
        Selenide.closeWebDriver();
    }

}
