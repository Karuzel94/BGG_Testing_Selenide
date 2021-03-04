package com.boardgamegeek.tests.stepDefinitions;

import com.boardgamegeek.tests.BaseTest;
import com.boardgamegeek.tests.cucumberTestContext.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java8.En;

import static org.assertj.core.api.Assertions.assertThat;

public class LogInSteps extends BaseTest implements En {

    TestContext testContext;

    public LogInSteps(TestContext context) {
        testContext = context;
        Given("^User enters credentials and log into application$", () -> {
            signInFragment.clickSignInButton();
            signInFragment.signIn(loginProperties.getUsername(), loginProperties.getPassword());
        });
        And("^User checks if he is currently logged in$", () ->
                assertThat(userMenuFragment.getUserName()).isEqualTo(loginProperties.getUsername()));
    }

    @Given("^User enters username (.*) and password (.*)$")
    public void user_enters_username_something_and_password_something(String username, String password) {
        testContext.setTempString(username);
        signInFragment.clickSignInButton();
        signInFragment.signIn(username, password);
    }

    @Then("^User checks if he, (.*), is currently logged in$")
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

}
