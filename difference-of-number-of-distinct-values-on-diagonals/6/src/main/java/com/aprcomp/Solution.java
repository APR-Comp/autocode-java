package com.aprcomp;
import java.util.*;
/**java 
 Given a 0-indexed 2D grid of size m x n, you should find the matrix answer of size m x n.
The value of each cell (r, c) of the matrix answer is calculated in the following way:

Let topLeft[r][c] be the number of distinct values in the top-left diagonal of the cell (r, c) in the matrix grid.
Let bottomRight[r][c] be the number of distinct values in the bottom-right diagonal of the cell (r, c) in the matrix grid.

Then answer[r][c] = |topLeft[r][c] - bottomRight[r][c]|.
Return the matrix answer.
A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the matrix's end.
A cell (r1, c1) belongs to the top-left diagonal of the cell (r, c), if both belong to the same diagonal and r1 < r. Similarly is defined bottom-right diagonal.
 
Example 1:



Input: grid = [[1,2,3],[3,1,5],[3,2,1]]
Output: [[1,1,0],[1,0,1],[0,1,1]]
Explanation: The 1 ** st diagram denotes the initial grid. 
The 2 ** nd diagram denotes a grid for cell (0,0), where blue-colored cells are cells on its bottom-right diagonal.
The 3 ** rd diagram denotes a grid for cell (1,2), where red-colored cells are cells on its top-left diagonal.
The 4 ** th diagram denotes a grid for cell (1,1), where blue-colored cells are cells on its bottom-right diagonal and red-colored cells are cells on its top-left diagonal.
- The cell (0,0) contains [1,1] on its bottom-right diagonal and [] on its top-left diagonal. The answer is |1 - 0| = 1.
- The cell (1,2) contains [] on its bottom-right diagonal and [2] on its top-left diagonal. The answer is |0 - 1| = 1.
- The cell (1,1) contains [1] on its bottom-right diagonal and [1] on its top-left diagonal. The answer is |1 - 1| = 0.
The answers of other cells are similarly calculated.

Example 2:

Input: grid = [[1]]
Output: [[0]]
Explanation: - The cell (0,0) contains [] on its bottom-right diagonal and [] on its top-left diagonal. The answer is |0 - 0| = 0.

 
Constraints:

m == grid.length
n == grid[i].length
1 <= m, n, grid[i][j] <= 50

 **/
class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] answer = new int[m][n];
        
        // Calculate the top-left diagonal values
        int[][] topLeft = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    topLeft[i][j] = 1;
                } else {
                    if (grid[i][j] != grid[i-1][j-1]) {
                        topLeft[i][j] = topLeft[i-1][j-1] + 1;
                    } else {
                        topLeft[i][j] = topLeft[i-1][j-1];
                    }
                }
            }
        }
        
        // Calculate the bottom-right diagonal values
        int[][] bottomRight = new int[m][n];
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == m-1 || j == n-1) {
                    bottomRight[i][j] = 1;
                } else {
                    if (grid[i][j] != grid[i+1][j+1]) {
                        bottomRight[i][j] = bottomRight[i+1][j+1] + 1;
                    } else {
                        bottomRight[i][j] = bottomRight[i+1][j+1];
                    }
                }
            }
        }
        
        // Calculate the answer matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = Math.abs(topLeft[i][j] - bottomRight[i][j]);
            }
        }
        
        return answer;
    }
}