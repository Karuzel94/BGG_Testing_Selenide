package com.boardgamegeek.tests.cucumberOptions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/boardgamegeek/tests/stepDefinitions",
        tags = "@myRating"
        // myRating, logIn, @sortingTest, @filteringTest, languageDependence,
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().browserVersion("87.0.4280.88").setup();
        WebDriver webDriver = new ChromeDriver(options);
        setWebDriver(webDriver);
        Selenide.open("https://boardgamegeek.com/");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.driver().getWebDriver().close();
        WebDriverRunner.driver().getWebDriver().quit();
    }

}
