package com.boardgamegeek.tests.stepDefinitions;

import com.boardgamegeek.tests.BaseTest;
import com.boardgamegeek.tests.cucumberTestContext.TestContext;
import com.boardgamegeek.utilities.Log;
import com.boardgamegeek.utilities.Randomizer;
import io.cucumber.java.en.Then;
import io.cucumber.java8.En;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionFilteringSteps extends BaseTest implements En {

    TestContext testContext;

    public CollectionFilteringSteps(TestContext context) {
        testContext = context;
    }

    @Then("^User enters minimum and maximum rating to filters section and checks if the filtered games ratings are between minimum and maximum rating$")
    public void user_enters_minimum_and_maximum_rating_to_filters_section_and_checks_if_the_filtered_games_ratings_are_between_minimum_and_maximum_rating() {
        testContext.setTempNumber(Randomizer.Random.getRandomNumber(1, 9));
        testContext.setSecondTempNumber(Randomizer.Random.getRandomNumber(testContext.getTempNumber(), 10));
        collectionPage.myRatingFiltering(testContext.getTempNumber(), testContext.getSecondTempNumber())
                .acceptFilters();
        for (int i = 0; i < collectionPage.getMyRatingsList().size(); i++) {
            assertThat(Integer.parseInt(collectionPage.getMyRatingsList().get(i)))
                    .isBetween(testContext.getTempNumber(), testContext.getSecondTempNumber());
            Log.logInfo("Loop lap nr " + (i + 1) + ", number " + collectionPage.getMyRatingsList().get(i) +
                    " is between " + testContext.getTempNumber() + " and " + testContext.getSecondTempNumber());
        }
    }
}
