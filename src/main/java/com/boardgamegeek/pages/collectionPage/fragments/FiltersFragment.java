package com.boardgamegeek.pages.collectionPage.fragments;

import com.boardgamegeek.pages.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class FiltersFragment extends BasePage {

    public SelenideElement applyButton = $("input[value*='Apply']");

    private SelenideElement minMyRating = $("input[name*='minrating']");

    private SelenideElement maxMyRating = $("input[name='rating']");

    private SelenideElement loadingInformation = $("#collection_status");

    public FiltersFragment myRatingFiltering(int min, int max) {
        insertValue(minMyRating, String.valueOf(min));
        insertValue(maxMyRating, String.valueOf(max));
        return this;
    }

    public FiltersFragment acceptFilters() {
        click(applyButton);
        synchronization(loadingInformation);
        return this;
    }

}
