package com.boardgamegeek.tests.stepDefinitions;

import com.boardgamegeek.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java8.En;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions extends BaseTest implements En {

    public StepDefinitions() {
        Given("^User enters username qwerty1234zz and password qwerty1234zz$", () -> {
            signInFragment.clickSignInButton();
            signInFragment.signIn(loginProperties.getUsername(), loginProperties.getPassword());
        });
        And("^User checks if he is currently logged in$", () ->
                assertThat(userMenuFragment.getUserName()).isEqualTo(loginProperties.getUsername()));
    }

    @Given("^User enters username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_enters_username_something_and_password_something(String strArg1, String strArg2) {
        signInFragment.clickSignInButton();
        signInFragment.signIn(strArg1, strArg2);
    }

    @Then("^User checks if he, \"([^\"]*)\", is currently logged in$")
    public void user_checks_if_he_something_is_currently_logged_in(String strArg1) {
        assertThat(userMenuFragment.getUserName()).isEqualTo(strArg1);
    }


    @Given("^User enters an invalid username (.+) and password (.+)$")
    public void user_enters_an_invalid_username_and_password(String login, String password) throws InterruptedException {
        signInFragment.clickSignInButton();
        signInFragment.signIn(login, password);
        Thread.sleep(500);
    }

    @Then("^User checks if he receives an error$")
    public void user_checks_if_he_receives_an_error() {
        assertThat(signInFragment.getErrorText()).isEqualTo("Invalid username or password");
        System.out.println("Invalid username or password. Please, try again.");
        signInFragment.abortLogIn();
    }

    @Then("^User goes to Collection, enters minimum and maximum rating to filters section$")
    public void user_goes_to_collection_enters_minimum_and_maximum_rating_to_filters_section() {
        userMenuFragment.goToCollection();
        collectionPage.myRatingFiltering(4.0, 9.0)
                .acceptFilters();
    }

    @And("^User checks if the filtered games ratings are between minimum and maximum rating$")
    public void user_checks_if_the_filtered_games_ratings_are_between_minimum_and_maximum_rating() {
        for (int i = 0; i < collectionPage.getMyRatingsList().size(); i++) {
            assertThat(collectionPage.getMyRatingsList().get(i)).isBetween("4", "9");
            System.out.println("Loop lap nr " + (i + 1) + ", number " + collectionPage.getMyRatingsList().get(i) +
                    " is between 4.0 and 9.0");
        }

    }

    @Then("^User goes to Collection and sort it by Names$")
    public void user_goes_to_collection_and_sort_it_by_names() {
        userMenuFragment.goToCollection();
        testHelper.setTitlesList(collectionPage.getGamesTitlesList());
        System.out.println(testHelper.getTitlesList());
        collectionPage.sortCollectionByTitles();
        collectionPage.sortCollectionByTitles();
    }

    @And("^User checks correctness of sorting$")
    public void user_checks_correctness_of_sorting() {
        assertThat(testHelper.getTitlesList()).isEqualTo(collectionPage.getGamesTitlesList());
    }

    @Then("^User goes to ALl Boardgames page$")
    public void user_goes_to_all_boardgames_page() {
        menuFragment.goToAllBoardgames();
    }

    @Then("^User choose random game and compare dependencies from XmlApi and Game Page$")
    public void user_choose_random_game_and_compare_dependencies_from_xmlapi_and_game_page() {
        allBoardgamesPage.goToRandomGame();
        testHelper.setTempString(gamePage.getLanguageDependenceInformation());
        assertThat(gameXmlFile.getLanguageDependenceFromXml(gamePage.getGameId())).isEqualTo(testHelper.getTempString());
    }

    @Then("^User goes to collection and choose random game$")
    public void user_goes_to_collection_and_choose_random_game() {
        userMenuFragment.goToCollection();
        collectionPage.chooseRandomGameFromList();
    }

    @Then("^User give or change his rating for this game$")
    public void user_give_or_change_his_rating_for_this_game() {
        testHelper.setTempString(gamePage.getGameTitle());
        testHelper.setTempNumber(testHelper.getRandomNumber(1, 10));
        System.out.println(testHelper.getTempNumber());
        gamePage.giveMyRating(testHelper.getTempNumber());
    }

    @Then("^User goes to collection again, checks this game rating and go to the page of this game$")
    public void user_goes_to_collection_again_checks_this_game_rating_and_go_to_the_page_of_this_game() {
        userMenuFragment.goToCollection();
        assertThat(testHelper.getTempNumber())
                .isEqualTo(collectionPage.getRatingFromCollection(testHelper.getTempString()));
        collectionPage.goToSpecificGameFromList(testHelper.getTempString());
    }

    @And("^User checks rating on Game Page and the count of stars$")
    public void user_checks_rating_on_game_page_and_the_count_of_stars() {
        assertThat(testHelper.getTempNumber()).isEqualTo(gamePage.getMyRating());
        assertThat(testHelper.getTempNumber()).isEqualTo(gamePage.countStarsNumber());
    }


}
