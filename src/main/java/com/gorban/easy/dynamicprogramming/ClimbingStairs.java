package com.gorban.easy.dynamicprogramming;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }

        int firstTry = 1;
        int secondTry = 2;

        for (int i = 3; i <= n; i++){
            int thirdTry = firstTry + secondTry;
            firstTry = secondTry;
            secondTry = thirdTry;
        }

        return secondTry;
    }
}
