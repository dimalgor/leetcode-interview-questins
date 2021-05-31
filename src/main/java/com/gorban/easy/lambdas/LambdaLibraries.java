package com.gorban.easy.lambdas;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class LambdaLibraries {
    public static void main(String[] arr) {
        // example 4.4

        List<Integer> trackLength = Arrays.asList(90, 60, 90, 120, 60, 180);
        printTrackLengthStatistics(trackLength);

    }

    private static void printTrackLengthStatistics(List<Integer> trackLengthList) {
        IntSummaryStatistics statistics = trackLengthList.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                statistics.getMax(),
                statistics.getMin(),
                statistics.getAverage(),
                statistics.getSum());
    }
}
