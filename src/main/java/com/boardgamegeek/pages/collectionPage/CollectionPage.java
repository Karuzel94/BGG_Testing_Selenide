package com.boardgamegeek.pages.collectionPage;

import com.boardgamegeek.pages.collectionPage.fragments.FiltersFragment;
import com.boardgamegeek.pages.collectionPage.fragments.GamesListFragment;

import java.util.List;

public class CollectionPage {

    private GamesListFragment gamesListFragment = new GamesListFragment();
    private FiltersFragment filtersFragment = new FiltersFragment();

    public CollectionPage goToSpecificGameFromList(String name) {
        gamesListFragment.clickDefinedGameFromList(name);
        return this;
    }

    public CollectionPage chooseRandomGameFromList() {
        gamesListFragment.chooseRandomGameFromList();
        return this;
    }

    public CollectionPage sortCollectionByTitles() {
        gamesListFragment.sortCollectionByTitles();
        return this;
    }

    public int getRatingFromCollection(String name) {
        return gamesListFragment.getRatingFromCollection(name);
    }

    public CollectionPage myRatingFiltering(Double min, Double max) {
        gamesListFragment.openFilters();
        filtersFragment.myRatingFiltering(min, max);
        return this;
    }

    public CollectionPage acceptFilters() {
        filtersFragment.acceptFilters();
        return this;
    }

    public List<String> getMyRatingsList() {
        return gamesListFragment.getMyRatingsList();
    }

    public List<String> getGamesTitlesList() {
        return gamesListFragment.getGamesNamesList();
    }

}

