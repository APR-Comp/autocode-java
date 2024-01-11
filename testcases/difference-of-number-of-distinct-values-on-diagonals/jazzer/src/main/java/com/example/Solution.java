package com.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                res[i][j] = answer(grid, i, j);
            }
        }
        return res;
    }
    
    int answer(int[][] grid, int r, int c){
        Set st1 = new HashSet(), st2 = new HashSet();
        int r1 = r, c1 = c, r2 = r, c2 = c;
        while(r1 > 0 && c1 > 0) 
            st1.add(grid[--r1][--c1]);
        while(r2 < grid.length-1 && c2 < grid[0].length-1) 
            st2.add(grid[++r2][++c2]);
        return Math.abs(st1.size()-st2.size());
    }
}