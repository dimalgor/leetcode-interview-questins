package com.gorban.easy.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubArrayTest {

    @Test
    void maxSubArray() {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        assertEquals(6, new MaximumSubArray().maxSubArray(arr));

        int[] arr2 = {5,4,-1,7,8};
        assertEquals(23, new MaximumSubArray().maxSubArray(arr2));

        int[] arr3 = {-1};
        assertEquals(-1, new MaximumSubArray().maxSubArray(arr3));

        int[] arr4 = {-2,-1};
        assertEquals(-1, new MaximumSubArray().maxSubArray(arr4));
    }
}