package com.boardgamegeek.tests.stepDefinitions;

import com.boardgamegeek.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class CucumberStepDefs extends BaseTest {

    @Given("^User is on Homepage$")
    public void user_is_on_homepage() {
        //driver.get("https://boardgamegeek.com/");
        System.out.println("Moved to homepage");
    }

    @When("^User log in with username and password$")
    public void user_log_in_with_username_and_password() {
        //signInFragment.clickSignInButton().signIn(loginProperties.getUsername(), loginProperties.getPassword());
        System.out.println("logged.");
    }

    @Then("^Homepage will reload to logged version$")
    public void homepage_will_reload_to_logged_version() throws InterruptedException {
       Thread.sleep(2000);
        System.out.println("waiting for reload");
    }

    @And("^User Button is displayed$")
    public void user_button_is_displayed() {
       // Assertions.assertThat(userMenuFragment.getUserName()).isEqualTo(loginProperties.getUsername());
        System.out.println("checked");
    }

}


