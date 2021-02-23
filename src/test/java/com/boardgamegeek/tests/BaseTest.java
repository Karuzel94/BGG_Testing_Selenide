package com.boardgamegeek.tests;

import com.boardgamegeek.pages.fragments.SignInFragment;
import com.boardgamegeek.pages.fragments.UserMenuFragment;
import com.boardgamegeek.utilities.LoginProperties;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    //public String url = "https://boardgamegeek.com/";
    protected static WebDriver driver;
    public SignInFragment signInFragment;
    public LoginProperties loginProperties;
    public UserMenuFragment userMenuFragment;


    @BeforeTest
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        signInFragment = new SignInFragment();
        loginProperties = new LoginProperties();
        userMenuFragment = new UserMenuFragment();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
