package com.websortingalgorithm.web_sorting_algorithm.controller;

import com.websortingalgorithm.web_sorting_algorithm.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SortingViewController {

    @Autowired
    private SortingService sortingService;

    @GetMapping("/view")
    public String index() {
        return "index";
    }

    @PostMapping("/sort")
    public String sort(@RequestParam String algorithm, @RequestParam String data, Model model) {
        List<Integer> dataList = Arrays.stream(data.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> sortedData = sortingService.sort(dataList, algorithm);
        model.addAttribute("result", sortedData);
        return "index";
    }
}
