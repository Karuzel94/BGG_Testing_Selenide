package com.boardgamegeek.pages.gamePage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.gamePage.fragments.EditGamePropertiesFragment;
import com.boardgamegeek.pages.gamePage.fragments.GamePropertiesFragment;

public class GamePage extends BasePage {

    private GamePropertiesFragment gamePropertiesFragment = new GamePropertiesFragment();
    private EditGamePropertiesFragment editGamePropertiesFragment = new EditGamePropertiesFragment();

    public String getGameTitle() {
        return gamePropertiesFragment.getGameTitle();
    }


    public String getLanguageDependenceInformation() {
        return gamePropertiesFragment.getLanguageDependenceInformation();
    }

    public String getGameId() {
        return gamePropertiesFragment.getGameId();
    }

    public GamePage giveMyRating(int rating) {
        if (gamePropertiesFragment.checkIfRatingHasBeenGiven()) {
            gamePropertiesFragment.clickEditMyRating();
            editGamePropertiesFragment.deleteMyRating();
        }
        gamePropertiesFragment.addMyRatingForGame(rating);
        editGamePropertiesFragment.saveInCollection();
        return this;
    }

    public int getMyRating() {
        return gamePropertiesFragment.getMyRating();
    }

    public int countStarsNumber() {
        return gamePropertiesFragment.countStarsNumber();
    }

}
