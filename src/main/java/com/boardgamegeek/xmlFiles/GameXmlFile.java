package com.boardgamegeek.xmlFiles;

import io.restassured.path.xml.XmlPath;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class GameXmlFile {

    private final String path = "boardgames.boardgame.poll.find{it.@name=='language_dependence'}.results.result.";

    public XmlPath xmlFile(String gameId) {
        return given().get("https://www.boardgamegeek.com/xmlapi/boardgame/" + gameId).xmlPath();
    }

    public int getMaxValue(String gameId) {
        List<String> stringList = xmlFile(gameId).get(path + "@numvotes");
        return Collections.max(stringList.stream().map(Integer::parseInt).collect(Collectors.toList()));
    }

    public String getLanguageDependenceFromXml(String gameId) {
        return (getMaxValue(gameId) == 0) ? "(no votes)" : xmlFile(gameId)
                .get(path + "find{it.@numvotes=='"
                        + getMaxValue(gameId) + "'}.@value");
    }

}
