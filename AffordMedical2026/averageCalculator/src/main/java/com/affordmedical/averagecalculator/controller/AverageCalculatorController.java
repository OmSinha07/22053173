package com.affordmedical.averagecalculator.controller;

import com.affordmedical.averagecalculator.model.ApiResponse;
import com.affordmedical.averagecalculator.service.AverageCalculatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/numbers")
public class AverageCalculatorController {

    private final AverageCalculatorService service;

    public AverageCalculatorController(AverageCalculatorService service) {
        this.service = service;
    }

    @GetMapping("/{numberType}")
    public ApiResponse getNumbers(@PathVariable String numberType) {
        return service.fetchAndCalculateAverage(numberType);
    }
}
