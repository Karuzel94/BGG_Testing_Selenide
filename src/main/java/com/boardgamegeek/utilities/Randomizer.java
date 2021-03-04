package com.boardgamegeek.utilities;

public class Randomizer {

    public static class Random {
        public static int getRandomNumber(int min, int max) {
            return (int) ((Math.random() * (max - min)) + min);
        }
    }
}
