package com.gorban.easy.design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinStackSolutionTest {

    @Test
    public void testMinStackSolution() {
        var minStackSolution = new MinStackSolution();
        minStackSolution.push(-2);
        minStackSolution.push(0);
        minStackSolution.push(-3);
        assertEquals(-3, minStackSolution.getMin());
        minStackSolution.pop();
        minStackSolution.top();
        assertEquals(-2, minStackSolution.getMin());
    }

}