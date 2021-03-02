package com.boardgamegeek.pages.collectionPage.fragments;

import com.boardgamegeek.pages.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GamesListFragment extends BasePage {

    private final String gameLink = " a[href*='boardgame']";
    private final String myRating = " .ratingtext";
    private final String deleteGameButton = " a[onclick*='CE_DeleteItem']";
    private int gameId = 0;

    private ElementsCollection gamesInCollectionList = $$("tr[id*='row_']");

    private SelenideElement titleSortButton = $(".collection_title > a");

    private SelenideElement loadingInformation = $("#collection_status");

    private SelenideElement filtersButton = $("span[style='float:left;'] > a:nth-child(1)");

    public GamesListFragment clickDefinedGameFromList(String name) {
        synchronization(loadingInformation);
        for (SelenideElement element : gamesInCollectionList) {
            if (element.$(gameLink).getText().equals(name)) {
                click(element.$(gameLink));
                break;
            }
        }
        return this;
    }

    public SelenideElement getChildElement(int elementId, String childName) {
        return gamesInCollectionList.get(elementId).$(childName);
    }

    public int getSizeOfGamesList() {
        return gamesInCollectionList.size();
    }

    public GamesListFragment chooseRandomGameFromList() {
        click(getChildElement(testHelper.getRandomNumber(0, getSizeOfGamesList()), gameLink));
        return this;
    }

    public int getRatingFromCollection(String name) {
        int i = 0;
        for (SelenideElement element : gamesInCollectionList) {
            if (element.$(gameLink).getText().equals(name)) {
                this.gameId = i;
                break;
            }
            i++;
        }
        return Integer.valueOf(getChildElement(gameId, myRating).getText());
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

    public List<String> getGamesNamesList() {
        return gamesInCollectionList.stream().map(e -> e.$(gameLink).getText()).collect(Collectors.toList());
    }

}
