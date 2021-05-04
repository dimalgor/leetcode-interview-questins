package com.gorban.easy.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {

    @Test
    void climbStairs() {
        var climbStairsSolutions = new ClimbingStairs();
        assertEquals(1, climbStairsSolutions.climbStairs(1));
        assertEquals(2, climbStairsSolutions.climbStairs(2));
        assertEquals(3, climbStairsSolutions.climbStairs(3));
        assertEquals(5, climbStairsSolutions.climbStairs(4));
        assertEquals(8, climbStairsSolutions.climbStairs(5));
    }
}