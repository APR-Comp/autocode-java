package com.example;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] nums = new int[n], result = new int[queries.length];
        int c = 0;
    
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0], color = queries[i][1];
            int pre = (index > 0) ? nums[index - 1] : 0;
            int nex = (index < n-1) ? nums[index + 1] : 0;
    
            if (nums[index] != 0 && nums[index] == pre) c--;
            if (nums[index] != 0 && nums[index] == nex) c--;
            nums[index] = color;
            if (nums[index] == pre) c++;
            if (nums[index] == nex) c++;
    
            result[i] = c;
        }
        return result;
    }
}
