package com.gorban.easy.dynamicprogramming;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int current = 0;

        for (int i = 0; i < nums.length; i++) {
            current += nums[i];
            if (current > max) {
                max = current;
            }
            if (current < 0) {
                current = 0;
            }
        }

        return max;
    }
}
