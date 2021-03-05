package com.boardgamegeek.tests.stepDefinitions;

import com.boardgamegeek.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java8.En;

import static org.assertj.core.api.Assertions.assertThat;

public class LanguageDependenceSteps extends BaseTest implements En {

    @Then("^User goes to ALl Boardgames page$")
    public void user_goes_to_all_boardgames_page() {
        menuFragment.goToAllBoardgames();
    }

    @Then("^User chooses random game$")
    public void user_chooses_random_game() {
        allBoardgamesPage.goToRandomGame();
    }

    @And("^User compares language dependencies between game page and XmlApi$")
    public void user_compares_language_dependencies_between_game_page_and_xmlapi() {
        assertThat(gameXmlFile.getLanguageDependenceFromXml(gamePage.getGameId()))
                .isEqualTo(gamePage.getLanguageDependenceInformation());
    }

}
