package com.websortingalgorithm.web_sorting_algorithm.controller;

import com.websortingalgorithm.web_sorting_algorithm.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sort")
public class SortingController {

    @Autowired
    private SortingService sortingService;

    @PostMapping("/{algorithm}")
    public List<Integer> sort(@PathVariable String algorithm, @RequestBody List<Integer> data) {
        return sortingService.sort(data, algorithm);
    }

    @GetMapping("/algorithms")
    public List<String> getAllAlgorithms() {
        return List.of("heap", "quick", "merge", "radix", "bucket");
    }
}
