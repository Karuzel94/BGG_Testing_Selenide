package com.boardgamegeek.tests;

import com.boardgamegeek.pages.fragments.SignInFragment;
import com.boardgamegeek.pages.fragments.UserMenuFragment;
import com.boardgamegeek.utilities.LoginProperties;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.Scanner;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserVersion;

public abstract class BaseTest {

    protected WebDriver driver;
    public SignInFragment signInFragment;
    public LoginProperties loginProperties;
    public UserMenuFragment userMenuFragment;
    private static String chromeVersion = "88.0.4324.96";

    @BeforeTest
    public void setupClass() {
        Configuration.browserVersion = chromeVersion;
        baseUrl = "https://boardgamegeek.com/";
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
        System.setProperty("selenide.browser", "chrome");
        WebDriverRunner.clearBrowserCache();
    }

    @BeforeClass
    public void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        signInFragment = new SignInFragment();
        loginProperties = new LoginProperties();
        userMenuFragment = new UserMenuFragment();
        Selenide.open(baseUrl);
    }
}
