package com.boardgamegeek.tests;

import com.boardgamegeek.pages.fragments.SignInFragment;
import com.boardgamegeek.pages.fragments.UserMenuFragment;
import com.boardgamegeek.utilities.LoginProperties;

public abstract class BaseTest {

    public SignInFragment signInFragment = new SignInFragment();
    public LoginProperties loginProperties = new LoginProperties();
    public UserMenuFragment userMenuFragment = new UserMenuFragment();

}