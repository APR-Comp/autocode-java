package com.aprcomp;
import java.util.*;

class Solution {
    public int matrixSum(int[][] nums) {
        int totalScore = 0;
        int maxNum;
        while(true){
            maxNum = Integer.MIN_VALUE;
            for(int i = 0; i < nums.length; i++){
                int rowMax = maxInRow(nums[i]);
                if(rowMax > maxNum){
                    maxNum = rowMax;
                }
            }
            if(maxNum == -1){
                break;
            }
            totalScore += maxNum;
        }
        return totalScore;
    }
    
    private int maxInRow(int[] nums){
        int maxNum = -1;
        int maxIndex = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > maxNum){
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        if(maxIndex != -1){
            nums[maxIndex] = -1; // once the max number is used, make it -1 to mark it as removed
        }
        return maxNum;
    }
}