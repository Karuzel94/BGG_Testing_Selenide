package com.boardgamegeek.utilities;

import java.util.*;
import java.util.stream.Collectors;

public class TestHelper {

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private int tempNumber = 0;

    private List<String> titlesList = new ArrayList<>();

    private String tempString = "";

    public int getTempNumber() {
        return tempNumber;
    }

    public void setTempNumber(int tempNumber) {
        this.tempNumber = tempNumber;
    }

    public String getTempString() {
        return tempString;
    }

    public void setTempString(String tempString) {
        this.tempString = tempString;
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

}
