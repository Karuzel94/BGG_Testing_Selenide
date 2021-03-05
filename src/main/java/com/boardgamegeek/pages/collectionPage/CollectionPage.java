package com.boardgamegeek.pages.collectionPage;

import com.boardgamegeek.pages.collectionPage.fragments.FiltersFragment;
import com.boardgamegeek.pages.collectionPage.fragments.GamesListFragment;

import java.util.List;

public class CollectionPage {

    private GamesListFragment gamesListFragment = new GamesListFragment();
    private FiltersFragment filtersFragment = new FiltersFragment();

    public CollectionPage goToSpecificGameFromList(String name) {
        gamesListFragment.goToSpecificGameFromList(name);
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

    public int getMyRatingFromGameInCollection(String title) {
        return gamesListFragment.getMyRatingFromGameInCollection(title);
    }

    public CollectionPage myRatingFiltering(int min, int max) {
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
        return gamesListFragment.getGamesTitlesList();
    }

}

