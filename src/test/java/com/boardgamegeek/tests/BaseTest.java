package com.boardgamegeek.tests;

import com.boardgamegeek.pages.fragments.SignInFragment;
import com.boardgamegeek.pages.fragments.UserMenuFragment;
import com.boardgamegeek.utilities.LoginProperties;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Configuration.baseUrl;

public abstract class BaseTest {

//    protected WebDriver driver;
    public SignInFragment signInFragment = new SignInFragment();
    public LoginProperties loginProperties = new LoginProperties();
    public UserMenuFragment userMenuFragment = new UserMenuFragment();
//    private static String chromeVersion = "88.0.4324.96";

//    @BeforeTest
//    public void setupClass() {
//        Configuration.browser = "chrome";
//        Configuration.browserVersion = chromeVersion;
//        baseUrl = "https://boardgamegeek.com/";
//        System.setProperty("selenide.browser", "chrome");
//    }

//    @BeforeClass
//    public void setupTest() {
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//        WebDriverRunner.setWebDriver(createDriver(capabilities));
//        WebDriverRunner.getWebDriver().manage().window().maximize();
//        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
//        signInFragment = new SignInFragment();
//        loginProperties = new LoginProperties();
//        userMenuFragment = new UserMenuFragment();
//        Selenide.open(baseUrl);
//    }
//
//    public WebDriver createDriver(DesiredCapabilities capabilities) {
//        Map<String, Object> prefs = new HashMap<String, Object>();
//        prefs.put("credentials_enable_service", false);
//        prefs.put("profile.default_content_setting_values.notifications", 2);
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--incognito");
//        WebDriverManager.chromedriver().setup();
//        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
//        return chromeDriver;
//    }
//
//    @AfterClass
//    public void tearDown() {
//        if (WebDriverRunner.getWebDriver() != null) {
//            WebDriverRunner.getWebDriver().quit();
//        }
//    }
}