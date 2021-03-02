package com.boardgamegeek.pages.allBoardgamesPage;

import com.boardgamegeek.pages.BasePage;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class AllBoardgamesPage extends BasePage {

    private ElementsCollection gamesOnList = $$("div[id*='results_objectname'] > .primary");

    public AllBoardgamesPage goToRandomGame() {
        click(gamesOnList.get(testHelper.getRandomNumber(1, gamesOnList.size())));
        return this;
    }

}
