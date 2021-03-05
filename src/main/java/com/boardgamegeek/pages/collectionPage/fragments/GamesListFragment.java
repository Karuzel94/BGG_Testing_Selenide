package com.boardgamegeek.pages.collectionPage.fragments;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.utilities.Randomizer;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GamesListFragment extends BasePage {

    private final String gameLink = " a[href*='boardgame']";
    private final String myRating = " .ratingtext";

    private ElementsCollection gamesInCollectionList = $$("tr[id*='row_']");

    private SelenideElement titleSortButton = $(".collection_title > a");

    private SelenideElement loadingInformation = $("#collection_status");

    private SelenideElement filtersButton = $("span[style='float:left;'] > a:nth-child(1)");

    public SelenideElement getChildElement(int elementId, String childName) {
        return gamesInCollectionList.get(elementId).$(childName);
    }

    public int findGameIdInListByTitle(String title) {
        int gameId = 0;
        for (SelenideElement element : gamesInCollectionList) {
            if (getChildElement(gameId, gameLink).getText().equals(title)) {
                break;
            }
            gameId++;
        }
        return gameId;
    }

    public GamesListFragment goToSpecificGameFromList(String title) {
        click(getChildElement(findGameIdInListByTitle(title), gameLink));
        return this;
    }

    public int getSizeOfGamesList() {
        return gamesInCollectionList.size();
    }

    public GamesListFragment chooseRandomGameFromList() {
        click(getChildElement(Randomizer.Random.getRandomNumber(0, getSizeOfGamesList()), gameLink));
        return this;
    }

    public int getMyRatingFromGameInCollection(String title) {
        return Integer.parseInt(getChildElement(findGameIdInListByTitle(title), myRating).getText());
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
        return gamesInCollectionList.stream().map(e -> e.$(myRating).getText()).collect(Collectors.toList());
    }

    public List<String> getGamesTitlesList() {
        return gamesInCollectionList.stream().map(e -> e.$(gameLink).getText()).collect(Collectors.toList());
    }

}
