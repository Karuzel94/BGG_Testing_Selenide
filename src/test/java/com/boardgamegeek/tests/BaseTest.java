package com.boardgamegeek.tests;

import com.boardgamegeek.pages.allBoardgamesPage.AllBoardgamesPage;
import com.boardgamegeek.pages.collectionPage.CollectionPage;
import com.boardgamegeek.pages.fragments.MenuFragment;
import com.boardgamegeek.pages.fragments.SignInFragment;
import com.boardgamegeek.pages.fragments.UserMenuFragment;
import com.boardgamegeek.pages.gamePage.GamePage;
import com.boardgamegeek.utilities.LoginProperties;
import com.boardgamegeek.utilities.TestHelper;
import com.boardgamegeek.xmlFiles.GameXmlFile;


public abstract class BaseTest {

    public SignInFragment signInFragment = new SignInFragment();
    public LoginProperties loginProperties = new LoginProperties();
    public UserMenuFragment userMenuFragment = new UserMenuFragment();
    public MenuFragment menuFragment = new MenuFragment();
    public TestHelper testHelper = new TestHelper();
    public CollectionPage collectionPage = new CollectionPage();
    public GamePage gamePage = new GamePage();
    public GameXmlFile gameXmlFile = new GameXmlFile();
    public AllBoardgamesPage allBoardgamesPage = new AllBoardgamesPage();

}