package com.aprcomp;
import java.util.*;
/**java 
 You are given a 0-indexed m x n binary matrix grid.
Let us call a non-empty subset of rows good if the sum of each column of the subset is at most half of the length of the subset.
More formally, if the length of the chosen subset of rows is k, then the sum of each column should be at most floor(k / 2).
Return an integer array that contains row indices of a good subset sorted in ascending order.
If there are multiple good subsets, you can return any of them. If there are no good subsets, return an empty array.
A subset of rows of the matrix grid is any matrix that can be obtained by deleting some (possibly none or all) rows from grid.
 
Example 1:

Input: grid = [[0,1,1,0],[0,0,0,1],[1,1,1,1]]
Output: [0,1]
Explanation: We can choose the 0 ** th and 1 ** st rows to create a good subset of rows.
The length of the chosen subset is 2.
- The sum of the 0 ** th column is 0 + 0 = 0, which is at most half of the length of the subset.
- The sum of the 1 ** st column is 1 + 0 = 1, which is at most half of the length of the subset.
- The sum of the 2 ** nd column is 1 + 0 = 1, which is at most half of the length of the subset.
- The sum of the 3 ** rd column is 0 + 1 = 1, which is at most half of the length of the subset.

Example 2:

Input: grid = [[0]]
Output: [0]
Explanation: We can choose the 0 ** th row to create a good subset of rows.
The length of the chosen subset is 1.
- The sum of the 0 ** th column is 0, which is at most half of the length of the subset.

Example 3:

Input: grid = [[1,1,1],[1,1,1]]
Output: []
Explanation: It is impossible to choose any subset of rows to create a good subset.

 
Constraints:

m == grid.length
n == grid[i].length
1 <= m <= 10 ** 4
1 <= n <= 5
grid[i][j] is either 0 or 1.

 **/
class Solution {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        
        // Calculate the sum of each column
        int[] columnSums = new int[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                columnSums[j] += grid[i][j];
            }
        }
        
        // Check if each subset of rows is a good subset
        for (int mask = 0; mask < (1 << m); mask++) {
            int[] subsetColumnSums = new int[n];
            int subsetSize = 0;
            for (int i = 0; i < m; i++) {
                if (((mask >> i) & 1) == 1) {
                    subsetSize++;
                    for (int j = 0; j < n; j++) {
                        subsetColumnSums[j] += grid[i][j];
                    }
                }
            }
            
            boolean isGoodSubset = true;
            for (int j = 0; j < n; j++) {
                if (subsetColumnSums[j] > (subsetSize / 2)) {
                    isGoodSubset = false;
                    break;
                }
            }
            
            if (isGoodSubset) {
                for (int i = 0; i < m; i++) {
                    if (((mask >> i) & 1) == 1) {
                        result.add(i);
                    }
                }
                break;
            }
        }
        
        Collections.sort(result);
        return result;
    }
}