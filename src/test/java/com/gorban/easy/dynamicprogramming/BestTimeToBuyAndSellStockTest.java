package com.gorban.easy.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStockTest {

    @Test
    void maxProfit() {
        assertEquals(5, new BestTimeToBuyAndSellStock().maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(2, new BestTimeToBuyAndSellStock().maxProfit(new int[]{2,4,1}));
        assertEquals(4, new BestTimeToBuyAndSellStock().maxProfit(new int[]{3,2,6,5,0,3}));
        assertEquals(0, new BestTimeToBuyAndSellStock().maxProfit(new int[]{1}));
    }
}