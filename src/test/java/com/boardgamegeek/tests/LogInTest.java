package com.boardgamegeek.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class LogInTest extends BaseTest{

    @Test
    public void logInTest() {
        open("https://boardgamegeek.com/");
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        System.out.println(loginProperties.getUsername());
    }

}
