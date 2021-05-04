package com.gorban.easy.design;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShuffleArraySolutionTest {

    @Test
    public void testSolution() {
        int[] numbers = new int[]{1, 2, 3};
        ShuffleArraySolution obj = new ShuffleArraySolution(numbers);

        assertTrue(Arrays.equals(numbers, obj.reset()));
        assertFalse(Arrays.equals(numbers, obj.shuffle()));
        assertTrue(Arrays.equals(numbers, obj.reset()));
    }
}