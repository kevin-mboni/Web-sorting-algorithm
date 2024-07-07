package com.websortingalgorithm.web_sorting_algorithm.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingAlgorithms {

    public static List<Integer> heapSort(List<Integer> data) {
        // Heap Sort implementation
        buildMaxHeap(data);
        for (int i = data.size() - 1; i > 0; i--) {
            Collections.swap(data, 0, i);
            maxHeapify(data, 0, i);
        }
        return data;
    }

    private static void buildMaxHeap(List<Integer> data) {
        for (int i = data.size() / 2 - 1; i >= 0; i--) {
            maxHeapify(data, i, data.size());
        }
    }

    private static void maxHeapify(List<Integer> data, int index, int heapSize) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < heapSize && data.get(left) > data.get(largest)) {
            largest = left;
        }

        if (right < heapSize && data.get(right) > data.get(largest)) {
            largest = right;
        }

        if (largest != index) {
            Collections.swap(data, index, largest);
            maxHeapify(data, largest, heapSize);
        }
    }

    public static List<Integer> quickSort(List<Integer> data) {
        // Quick Sort implementation
        quickSortHelper(data, 0, data.size() - 1);
        return data;
    }

    private static void quickSortHelper(List<Integer> data, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(data, low, high);
            quickSortHelper(data, low, pivotIndex - 1);
            quickSortHelper(data, pivotIndex + 1, high);
        }
    }

    private static int partition(List<Integer> data, int low, int high) {
        int pivot = data.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (data.get(j) <= pivot) {
                i++;
                Collections.swap(data, i, j);
            }
        }
        Collections.swap(data, i + 1, high);
        return i + 1;
    }

    public static List<Integer> mergeSort(List<Integer> data) {
        // Merge Sort implementation
        if (data.size() <= 1) {
            return data;
        }
        int mid = data.size() / 2;
        List<Integer> left = new ArrayList<>(data.subList(0, mid));
        List<Integer> right = new ArrayList<>(data.subList(mid, data.size()));

        mergeSort(left);
        mergeSort(right);

        return merge(data, left, right);
    }

    private static List<Integer> merge(List<Integer> result, List<Integer> left, List<Integer> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                result.set(k++, left.get(i++));
            } else {
                result.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            result.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            result.set(k++, right.get(j++));
        }

        return result;
    }

    public static List<Integer> radixSort(List<Integer> data) {
        // Radix Sort implementation
        int max = Collections.max(data);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(data, exp);
        }
        return data;
    }

    private static void countingSortByDigit(List<Integer> data, int exp) {
        int n = data.size();
        List<Integer> output = new ArrayList<>(Collections.nCopies(n, 0));
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(data.get(i) / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output.set(count[(data.get(i) / exp) % 10] - 1, data.get(i));
            count[(data.get(i) / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            data.set(i, output.get(i));
        }
    }

    public static List<Integer> bucketSort(List<Integer> data) {
        // Bucket Sort implementation
        int max = Collections.max(data);
        int min = Collections.min(data);
        int bucketCount = (max - min) / data.size() + 1;

        List<List<Integer>> buckets = new ArrayList<>(Collections.nCopies(bucketCount, null));
        for (int i = 0; i < bucketCount; i++) {
            buckets.set(i, new ArrayList<>());
        }

        for (int num : data) {
            int bucketIndex = (num - min) / data.size();
            buckets.get(bucketIndex).add(num);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket) {
                data.set(index++, num);
            }
        }

        return data;
    }
}
