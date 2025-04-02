package com.affordmedical.averagecalculator.util;

import java.util.List;
import java.util.Arrays;

public class NumberFetcher {
    public static List<Integer> fetchNumbersFromAPI(String numberType) {
        if (numberType.equalsIgnoreCase("even")) {
            return Arrays.asList(2, 4, 6, 8, 10);
        } else if (numberType.equalsIgnoreCase("odd")) {
            return Arrays.asList(1, 3, 5, 7, 9);
        } else {
            return Arrays.asList(10, 20, 30, 40, 50);
        }
    }
}
