package com.boardgamegeek.tests;

import com.boardgamegeek.pages.allBoardgamesPage.AllBoardgamesPage;
import com.boardgamegeek.pages.collectionPage.CollectionPage;
import com.boardgamegeek.pages.fragments.MenuFragment;
import com.boardgamegeek.pages.fragments.SignInFragment;
import com.boardgamegeek.pages.fragments.UserMenuFragment;
import com.boardgamegeek.pages.gamePage.GamePage;
import com.boardgamegeek.utilities.LoginProperties;
import com.boardgamegeek.xmlFiles.GameXmlFile;


public abstract class BaseTest {

    protected SignInFragment signInFragment = new SignInFragment();
    protected LoginProperties loginProperties = new LoginProperties();
    protected UserMenuFragment userMenuFragment = new UserMenuFragment();
    protected MenuFragment menuFragment = new MenuFragment();
    protected CollectionPage collectionPage = new CollectionPage();
    protected GamePage gamePage = new GamePage();
    protected GameXmlFile gameXmlFile = new GameXmlFile();
    protected AllBoardgamesPage allBoardgamesPage = new AllBoardgamesPage();

}