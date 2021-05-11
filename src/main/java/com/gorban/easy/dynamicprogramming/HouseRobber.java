package com.gorban.easy.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HouseRobber {
    public int rob(int[] nums) {
        int stash = nums[0];
        if (nums.length == 2){
            if (stash >= nums[1]){
                return stash;
            } else {
                return nums[1];
            }
        }
        if (nums.length == 3){
            int maxValue = Integer.MIN_VALUE;
            for (int num: nums) {
                if (num > maxValue){
                    maxValue = num;
                }
            }
            return maxValue;
        }
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 != 0) {
                stash += nums[i];
            }
        }
        return stash;
    }
}
