package com.boardgamegeek.pages.gamePage.fragments;

import com.boardgamegeek.pages.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GamePropertiesFragment extends BasePage {


    private SelenideElement addToCollectionButton = $("div[class='toolbar-action'] button[class='btn btn-sm btn-primary toolbar-action-full']");

    private SelenideElement inCollectionButton = $("div[class='toolbar-action'] button[id='button-collection']");

    private SelenideElement gameTitle = $("div[class='game-header-title-info'] a[ui-sref='geekitem.overview']");

    private SelenideElement editGamePropertiesButton = $(".btn.btn-sm.btn-subtle.collection-dropdown-edit");

    private SelenideElement languageDependenceInformation = $("span[ng-bind-html*='languagedependence']");

    private SelenideElement gameId = $(".game-itemid");

    private SelenideElement givenMyRating = $("span[ng-show*='rating > 0 ']");

    private SelenideElement editMyRating = $("span[ng-show*='rating'] > button");

    private ElementsCollection ratingStarsIcons = $$(".glyphicon.ng-scope.fi-star.is-active");

    private ElementsCollection ratingStarsButtons = $$("i[ng-mouseenter*='enter']");


    public String getGameTitle() {
        visibilityCheck(gameTitle);
        return gameTitle.getText();
    }

    public String getGameId() {
        return gameId.getText().replaceAll("\\D+", "");
    }

    public String getLanguageDependenceInformation() {
        return languageDependenceInformation.getText();
    }

    public boolean checkIfRatingHasBeenGiven() {
        return editMyRating.isDisplayed();
    }

    public GamePropertiesFragment clickEditMyRating() {
        click(editMyRating);
        return this;
    }

    public GamePropertiesFragment addMyRatingForGame(int rating) {
        click(ratingStarsButtons.get(rating - 1));
        return this;
    }

    public int getMyRating() {
        return Integer.parseInt(givenMyRating.getText().replaceAll("\\D+", ""));
    }

    public int countStarsNumber() {
        return ratingStarsIcons.size();
    }
}
