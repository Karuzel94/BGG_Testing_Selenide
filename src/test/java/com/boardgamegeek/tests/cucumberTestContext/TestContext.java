package com.boardgamegeek.tests.cucumberTestContext;

import java.util.*;
import java.util.stream.Collectors;

public class TestContext {

    private String tempString;

    private int tempNumber;

    private int secondTempNumber;

    private List<String> titlesList = new ArrayList<>();

    public String getTempString() {
        return tempString;
    }

    public void setTempString(String tempString) {
        this.tempString = tempString;
    }

    public int getTempNumber() {
        return tempNumber;
    }

    public void setTempNumber(int tempNumber) {
        this.tempNumber = tempNumber;
    }

    public List<String> getTitlesList() {
        return titlesList;
    }

    public void setTitlesList(List<String> list) {
        this.titlesList = list;
        Collections.shuffle(titlesList);
        Map<String, String> map = titlesList.stream().collect(Collectors.toMap(String::new, String::new));
        for (Map.Entry<String, String> mapa : map.entrySet()) {
            if (mapa.getValue().startsWith("The ") || mapa.getValue().startsWith("La ")
                    || mapa.getValue().startsWith("El ")) {
                mapa.setValue(mapa.getValue().substring(mapa.getValue().indexOf(" ") + 1));
            }
        }
        Map<String, String> result2 = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));
        titlesList = new ArrayList<>(result2.keySet());
    }

    public int getSecondTempNumber() {
        return secondTempNumber;
    }

    public void setSecondTempNumber(int secondTempNumber) {
        this.secondTempNumber = secondTempNumber;
    }
}




