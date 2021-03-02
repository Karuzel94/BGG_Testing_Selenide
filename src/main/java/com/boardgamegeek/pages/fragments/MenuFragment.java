package com.boardgamegeek.pages.fragments;

import com.boardgamegeek.pages.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MenuFragment extends BasePage {

    private SelenideElement browseButton = $("li:nth-child(1) > button");

    private SelenideElement allBoardgamesButton = $("a[href='/browse/boardgame']");

    public MenuFragment goToAllBoardgames() {
        click(browseButton);
        click(allBoardgamesButton);
        return this;
    }

}
