package com.gorban.easy.design;

import java.util.Random;

public class ShuffleArraySolution2 {
        private int[] arrayToShuffle;
        private int[] originalArray;

        Random rand = new Random();

        private int randRange(int min, int max) {
            return rand.nextInt(max - min) + min;
        }

        private void swapAt(int i, int j) {
            int temp = arrayToShuffle[i];
            arrayToShuffle[i] = arrayToShuffle[j];
            arrayToShuffle[j] = temp;
        }

        public ShuffleArraySolution2(int[] nums) {
            arrayToShuffle = nums;
            originalArray = nums.clone();
        }

        public int[] reset() {
            arrayToShuffle = originalArray;
            originalArray = originalArray.clone();
            return originalArray;
        }

        public int[] shuffle() {
            for (int i = 0; i < arrayToShuffle.length; i++) {
                swapAt(i, randRange(i, arrayToShuffle.length));
            }
            return arrayToShuffle;
        }
}
