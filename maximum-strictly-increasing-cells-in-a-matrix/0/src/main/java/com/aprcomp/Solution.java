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
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxIncreasingCells(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }
        
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> mat[b[0]][b[1]] - mat[a[0]][a[1]]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxHeap.offer(new int[]{i, j});
            }
        }
        
        int max = 1;
        while (!maxHeap.isEmpty()) {
            int[] cur = maxHeap.poll();
            int x = cur[0], y = cur[1];
            visited[x][y] = true;
            
            for (int[] d : dir) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && mat[nx][ny] < mat[x][y]) {
                    dp[nx][ny] = Math.max(dp[nx][ny], dp[x][y] + 1);
                    max = Math.max(max, dp[nx][ny]);
                }
            }
        }
        return max;
    }
}