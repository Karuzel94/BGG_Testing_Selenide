package com.boardgamegeek.tests.stepDefinitions;

import com.boardgamegeek.tests.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java8.En;

import static org.assertj.core.api.Assertions.*;

public class LoginStepDefs extends BaseTest implements En {

    public LoginStepDefs() {
        Given("^Log with defined credentials$", () -> {
            signInFragment.clickSignInButton();
            signInFragment.signIn(loginProperties.getUsername(), loginProperties.getPassword());
        });
        And("^User check if the correct user was logged in$", () ->
                assertThat(userMenuFragment.getUserName()).isEqualTo(loginProperties.getUsername()));
    }

    @Given("^Log in with credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void log_in_with_credentials_something_and_something(String strArg1, String strArg2) {
        signInFragment.clickSignInButton();
        signInFragment.signIn(strArg1, strArg2);
    }

    @Then("^Check if the user \"([^\"]*)\" was logged in$")
    public void check_if_the_user_something_was_logged_in(String strArg1) {
        assertThat(userMenuFragment.getUserName()).isEqualTo(strArg1);
    }


    @Given("^Log in with example (.+) and (.+)$")
    public void log_in_with_example_and(String login, String password) throws InterruptedException {
        signInFragment.clickSignInButton();
        signInFragment.signIn(login, password);
        Thread.sleep(500);
    }

    @Then("^Check if there is an error$")
    public void check_if_there_is_an_error() {
        assertThat(signInFragment.getErrorText()).isEqualTo("Invalid username or password");
        System.out.println("Invalid username or password. Please, try again.");
        signInFragment.abortLogIn();
    }

}
