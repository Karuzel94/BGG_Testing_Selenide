package com.boardgamegeek.pages.fragments;

import com.boardgamegeek.pages.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SignInFragment extends BasePage {

    private SelenideElement logInButton = $(".c-nav-session > a");

    private SelenideElement userNameInput = $("#inputUsername");

    private SelenideElement passwordInput = $("#inputPassword");

    private SelenideElement signInButton = $(".modal-footer > button[type=submit]");

    private SelenideElement invalidDataCommunicate = $(".help-block");

    private SelenideElement cancelSignIn = $(".btn.btn-outline-secondary");



    public SignInFragment clickSignInButton() {
        click(logInButton);
        return this;
    }

    public SignInFragment signIn(String username, String password) {
        insertValue(userNameInput, username);
        insertValue(passwordInput, password);
        click(signInButton);
        return this;
    }

    public String getErrorText() {
        visibilityCheck(invalidDataCommunicate);
        return invalidDataCommunicate.getText();
    }

    public SignInFragment abortLogIn() {
        click(cancelSignIn);
        return this;
    }


}
