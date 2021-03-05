package com.boardgamegeek.tests.stepDefinitions;

import com.boardgamegeek.tests.BaseTest;
import com.boardgamegeek.tests.cucumberTestContext.TestContext;
import com.boardgamegeek.utilities.Log;
import io.cucumber.java.en.Then;
import io.cucumber.java8.En;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionSortingSteps extends BaseTest implements En {

    TestContext testContext;

    public CollectionSortingSteps(TestContext context) {
        testContext = context;
    }

    @Then("^User sort collection by Titles in ascending order and checks correctness of sorting$")
    public void user_sort_collection_by_titles_in_ascending_order_and_checks_correctness_of_sorting() {
        testContext.setTitlesList(collectionPage.getGamesTitlesList());
        Log.logInfo(String.valueOf(testContext.getTitlesList()));
        collectionPage.sortCollectionByTitles();
        collectionPage.sortCollectionByTitles();
        assertThat(testContext.getTitlesList()).isEqualTo(collectionPage.getGamesTitlesList());

    }
}
