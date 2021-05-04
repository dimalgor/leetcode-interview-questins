package com.gorban.easy.design;

import java.util.Stack;

public class MinStackSolution {

    Stack<Integer> stack = new Stack<>();

    public MinStackSolution() {

    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return (int) stack.peek();
    }

    public int getMin() {
        return stack.stream().min(Integer::compare).get();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
