package com.gorban.easy.design;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ShuffleArraySolution2Test {

    @Test
    public void testSolution(){
        int[] nums = new int[]{1,2,3};
        var shuffleSolution = new ShuffleArraySolution2(nums);
        assertTrue(Arrays.equals(nums, shuffleSolution.reset()));
        assertFalse(Arrays.equals(nums, shuffleSolution.shuffle()));
        assertTrue(Arrays.equals(nums, shuffleSolution.reset()));
        assertFalse(Arrays.equals(nums, shuffleSolution.shuffle()));
    }

}