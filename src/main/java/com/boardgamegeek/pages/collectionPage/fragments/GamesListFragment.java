package com.boardgamegeek.pages.collectionPage.fragments;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.utilities.Randomizer;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GamesListFragment extends BasePage {

    private ElementsCollection gameTitles = $$("tr[id*='row_'] a[href*='boardgame']");

    private ElementsCollection myRatings = $$("tr[id*='row_'] div[style*='background']");

    private SelenideElement titleSortButton = $(".collection_title > a");

    private SelenideElement loadingInformation = $("#collection_status");

    private SelenideElement filtersButton = $("span[style='float:left;'] > a:nth-child(1)");

    public int findGameIdInListByTitle(String title) {
        int gameId = 0;
        for (SelenideElement element : gameTitles) {
            if (element.getText().equals(title)) {
                gameId = gameTitles.indexOf(element);
                break;
            }
        }
        return gameId;
    }

    public GamesListFragment goToSpecificGameFromList(String title) {
        click(gameTitles.get(findGameIdInListByTitle(title)));
        return this;
    }

    public GamesListFragment chooseRandomGameFromList() {
        click(gameTitles.get(Randomizer.Random.getRandomNumber(1, gameTitles.size())));
        return this;
    }

    public int getMyRatingFromGameInCollection(String title) {
        return Integer.parseInt(myRatings.get(findGameIdInListByTitle(title)).getText());
    }

    public GamesListFragment sortCollectionByTitles() {
        click(titleSortButton);
        synchronization(loadingInformation);
        return this;
    }

    public GamesListFragment openFilters() {
        click(filtersButton);
        return this;
    }

    public List<String> getMyRatingsList() {
        return myRatings.texts();
    }

    public List<String> getGamesTitlesList() {
        return gameTitles.texts();
    }

}
