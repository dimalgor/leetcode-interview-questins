package com.gorban.easy.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTest {

    @Test
    void rob() {
        int[] nums = {1,2,3,1};
        assertEquals(4, new HouseRobber().rob(nums));

        int[] nums2 = {2,7,9,3,1};
        assertEquals(12, new HouseRobber().rob(nums2));

        int[] nums3 = {1,1};
        assertEquals(1, new HouseRobber().rob(nums3));

        int[] nums4 = {1,2};
        assertEquals(2, new HouseRobber().rob(nums4));

        int[] nums5 = {1,3,1};
        assertEquals(3, new HouseRobber().rob(nums5));
    }
}