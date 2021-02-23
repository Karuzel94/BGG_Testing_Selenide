package com.boardgamegeek.utilities;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class LoginProperties {

    private String username;
    private String password;

    public LoginProperties() {

        Properties properties = new Properties();
        try {
            properties.load(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("config.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        username = properties.get("username").toString();
        password = properties.get("password").toString();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
