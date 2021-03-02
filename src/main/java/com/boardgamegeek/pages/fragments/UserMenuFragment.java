package com.boardgamegeek.pages.fragments;

import com.boardgamegeek.pages.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class UserMenuFragment extends BasePage {

    private SelenideElement userMenuButton = $(".mygeek-dropdown-username.text-truncate");

    private SelenideElement collectionButton = $("a[href*='collection/user']");

    public String getUserName() {
        visibilityCheck(userMenuButton);
        return userMenuButton.getText();
    }

    public UserMenuFragment goToCollection() {
        click(userMenuButton);
        click(collectionButton);
        return this;
    }


}
