package com.websortingalgorithm.web_sorting_algorithm.service;

import com.websortingalgorithm.web_sorting_algorithm.sorting.SortingAlgorithms;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortingService {

    public List<Integer> sort(List<Integer> data, String algorithm) {
        switch (algorithm.toLowerCase()) {
            case "heap":
                return SortingAlgorithms.heapSort(data);
            case "quick":
                return SortingAlgorithms.quickSort(data);
            case "merge":
                return SortingAlgorithms.mergeSort(data);
            case "radix":
                return SortingAlgorithms.radixSort(data);
            case "bucket":
                return SortingAlgorithms.bucketSort(data);
            default:
                throw new IllegalArgumentException("Invalid sorting algorithm: " + algorithm);
        }
    }
}
