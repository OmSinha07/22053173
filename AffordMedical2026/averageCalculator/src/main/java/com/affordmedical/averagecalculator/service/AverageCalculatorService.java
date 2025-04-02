package com.affordmedical.averagecalculator.service;

import com.affordmedical.averagecalculator.model.ApiResponse;
import com.affordmedical.averagecalculator.util.NumberFetcher;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.LinkedList;

@Service
public class AverageCalculatorService {

    private static final int WINDOW_SIZE = 5;
    private LinkedList<Integer> windowPrevState = new LinkedList<>();
    private LinkedList<Integer> windowCurrState = new LinkedList<>();

    public ApiResponse fetchAndCalculateAverage(String numberType) {
        List<Integer> fetchedNumbers = NumberFetcher.fetchNumbersFromAPI(numberType);
        
        if (fetchedNumbers.isEmpty()) {
            return new ApiResponse(0.0, windowPrevState, windowCurrState, fetchedNumbers);
        }

        windowPrevState = new LinkedList<>(windowCurrState);
        windowCurrState.clear();
        
        for (int i = 0; i < Math.min(WINDOW_SIZE, fetchedNumbers.size()); i++) {
            windowCurrState.add(fetchedNumbers.get(i));
        }

        double avg = calculateAverage(windowCurrState);
        return new ApiResponse(avg, windowPrevState, windowCurrState, fetchedNumbers);
    }

    private double calculateAverage(List<Integer> numbers) {
        if (numbers.isEmpty()) return 0.0;
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }
}
