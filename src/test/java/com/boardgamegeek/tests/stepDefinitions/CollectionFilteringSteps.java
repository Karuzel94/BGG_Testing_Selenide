package com.boardgamegeek.tests.stepDefinitions;

import com.boardgamegeek.tests.BaseTest;
import com.boardgamegeek.tests.cucumberTestContext.TestContext;
import com.boardgamegeek.utilities.Log;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java8.En;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionFilteringSteps extends BaseTest implements En {

    TestContext testContext;

    public CollectionFilteringSteps(TestContext context) {
        testContext = context;
    }

    @Then("^User enters minimum and maximum rating to filters section$")
    public void user_enters_minimum_and_maximum_rating_to_filters_section() {
        collectionPage.myRatingFiltering(4.0, 9.0)
                .acceptFilters();
    }

    @And("^User checks if the filtered games ratings are between minimum and maximum rating$")
    public void user_checks_if_the_filtered_games_ratings_are_between_minimum_and_maximum_rating() {
        for (int i = 0; i < collectionPage.getMyRatingsList().size(); i++) {
            assertThat(collectionPage.getMyRatingsList().get(i)).isBetween("4", "9");
            Log.logInfo("Loop lap nr " + (i + 1) + ", number " + collectionPage.getMyRatingsList().get(i) +
                    " is between 4.0 and 9.0");
        }
    }
}
