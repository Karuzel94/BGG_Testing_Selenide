package com.boardgamegeek.tests.stepDefinitions;

import com.boardgamegeek.tests.BaseTest;
import com.boardgamegeek.tests.cucumberTestContext.TestContext;
import com.boardgamegeek.utilities.Randomizer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java8.En;

import static org.assertj.core.api.Assertions.assertThat;

public class MyRatingChangingSteps extends BaseTest implements En {

    TestContext testContext;

    public MyRatingChangingSteps(TestContext context) {
        testContext = context;
    }

    @Then("^User chooses random game from Collection$")
    public void user_chooses_random_game_from_collection() {
        collectionPage.chooseRandomGameFromList();
    }

    @Then("^User set his new rating for this game$")
    public void user_set_his_new_rating_for_this_game() {
        testContext.setTempNumber(Randomizer.Random.getRandomNumber(1, 10));
        gamePage.giveMyRating(testContext.getTempNumber());
        testContext.setTempString(gamePage.getGameTitle());
    }

    @Then("^User checks this game rating and go to the page of this game$")
    public void user_checks_this_game_rating_and_go_to_the_page_of_this_game() {
        assertThat(testContext.getTempNumber())
                .isEqualTo(collectionPage.getMyRatingFromGameInCollection(testContext.getTempString()));
        collectionPage.goToSpecificGameFromList(testContext.getTempString());
    }

    @And("^User checks rating on Game Page and the count of stars$")
    public void user_checks_rating_on_game_page_and_the_count_of_stars() {
        assertThat(testContext.getTempNumber()).isEqualTo(gamePage.getMyRating());
        assertThat(testContext.getTempNumber()).isEqualTo(gamePage.countStarsNumber());
    }
}
