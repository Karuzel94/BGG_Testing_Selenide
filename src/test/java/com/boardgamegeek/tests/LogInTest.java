package com.boardgamegeek.tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest{

    @Test
    public void logInTest() {
        Selenide.open("https://boardgamegeek.com/");
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        System.out.println(loginProperties.getUsername());

    }

}
