package com.affordmedical.averagecalculator.model;

import java.util.List;

public class ApiResponse {
    private double avg;
    private List<Integer> windowPrevState;
    private List<Integer> windowCurrState;
    private List<Integer> numbers;

    public ApiResponse(double avg, List<Integer> windowPrevState, List<Integer> windowCurrState, List<Integer> numbers) {
        this.avg = avg;
        this.windowPrevState = windowPrevState;
        this.windowCurrState = windowCurrState;
        this.numbers = numbers;
    }

    public double getAvg() { return avg; }
    public List<Integer> getWindowPrevState() { return windowPrevState; }
    public List<Integer> getWindowCurrState() { return windowCurrState; }
    public List<Integer> getNumbers() { return numbers; }
}
