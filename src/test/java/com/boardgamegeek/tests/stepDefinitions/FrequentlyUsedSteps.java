package com.boardgamegeek.tests.stepDefinitions;

import com.boardgamegeek.tests.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java8.En;

public class FrequentlyUsedSteps extends BaseTest implements En {

    @Then("^User goes to Collection$")
    public void user_goes_to_collection() {
        userMenuFragment.goToCollection();
    }

}
