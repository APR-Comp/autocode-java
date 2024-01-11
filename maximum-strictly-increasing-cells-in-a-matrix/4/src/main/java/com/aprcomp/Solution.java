package com.aprcomp;
import java.util.*;
/**java 
 Given a 1-indexed m x n integer matrix mat, you can select any cell in the matrix as your starting cell.
From the starting cell, you can move to any other cell in the same row or column, but only if the value of the destination cell is strictly greater than the value of the current cell. You can repeat this process as many times as possible, moving from cell to cell until you can no longer make any moves.
Your task is to find the maximum number of cells that you can visit in the matrix by starting from some cell.
Return an integer denoting the maximum number of cells that can be visited.
 
Example 1:


Input: mat = [[3,1],[3,4]]
Output: 2
Explanation: The image shows how we can visit 2 cells starting from row 1, column 2. It can be shown that we cannot visit more than 2 cells no matter where we start from, so the answer is 2. 

Example 2:


Input: mat = [[1,1],[1,1]]
Output: 1
Explanation: Since the cells must be strictly increasing, we can only visit one cell in this example. 

Example 3:


Input: mat = [[3,1,6],[-9,5,7]]
Output: 4
Explanation: The image above shows how we can visit 4 cells starting from row 2, column 1. It can be shown that we cannot visit more than 4 cells no matter where we start from, so the answer is 4. 

 
Constraints:

m == mat.length 
n == mat[i].length 
1 <= m, n <= 10 ** 5
1 <= m * n <= 10 ** 5
-10 ** 5 <= mat[i][j] <= 10 ** 5

 **/
class Solution {
    private int[][] dp;
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int maxIncreasingCells(int[][] mat) {
        int m = mat.length, n = mat[0].length, res = 0;
        dp = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res = Math.max(res, dfs(mat, i, j));
            }
        }
        
        return res;
    }
    
    private int dfs(int[][] mat, int i, int j) {
        if(dp[i][j] != 0) return dp[i][j];
        
        int max = 0;
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x >= 0 && y >= 0 && x < mat.length && y < mat[0].length && mat[x][y] > mat[i][j]) {
                max = Math.max(max, dfs(mat, x, y));
            }
        }
        
        dp[i][j] = max + 1;
        return dp[i][j];
    }
}