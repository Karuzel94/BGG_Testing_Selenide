package com.boardgamegeek.tests.cucumberOptions;

import com.boardgamegeek.tests.stepDefinitions.CucumberStepDefs;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/com/boardgamegeek/tests/features",
        glue="stepDefinitions"
)
public class TestRunner {
}
