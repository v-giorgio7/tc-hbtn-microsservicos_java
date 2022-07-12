package com.song.MegaSenaAPI.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbersUtil {

    private static final Integer MAX_NUMBER = 99;
    private static final Integer MIN_NUMBER = 1;

    private static List<Integer> randomNumbers;

    public static List<Integer> getListOfRandomNumbers() {
        randomNumbers = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            Integer randomNum = (int) Math.floor(Math.random() *
                    (MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER);
            randomNumbers.add(randomNum);
        }

        randomNumbers.sort(Collections.reverseOrder());
        return randomNumbers;
    }
}
