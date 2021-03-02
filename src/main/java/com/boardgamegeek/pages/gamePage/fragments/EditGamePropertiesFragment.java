package com.boardgamegeek.pages.gamePage.fragments;

import com.boardgamegeek.pages.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class EditGamePropertiesFragment extends BasePage {

    private SelenideElement saveCollectionButton = $(".modal-footer > .btn.btn-primary");

    private SelenideElement clearRatingButton = $(".rating-stars-clear");

    public EditGamePropertiesFragment saveInCollection() {
        visibilityCheck(saveCollectionButton);
        click(saveCollectionButton);
        return this;
    }

    public EditGamePropertiesFragment deleteMyRating() {
        click(clearRatingButton);
        click(saveCollectionButton);
        return this;
    }
}
