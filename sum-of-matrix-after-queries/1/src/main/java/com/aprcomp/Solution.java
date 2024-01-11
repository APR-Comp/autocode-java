package com.aprcomp;
import java.util.*;
/**java 
 You are given an integer n and a 0-indexed 2D array queries where queries[i] = [typei, indexi, vali].
Initially, there is a 0-indexed n x n matrix filled with 0's. For each query, you must apply one of the following changes:

if typei == 0, set the values in the row with indexi to vali, overwriting any previous values.
if typei == 1, set the values in the column with indexi to vali, overwriting any previous values.

Return the sum of integers in the matrix after all queries are applied.
 
Example 1:


Input: n = 3, queries = [[0,0,1],[1,2,2],[0,2,3],[1,0,4]]
Output: 23
Explanation: The image above describes the matrix after each query. The sum of the matrix after all queries are applied is 23. 

Example 2:


Input: n = 3, queries = [[0,0,4],[0,1,2],[1,0,1],[0,2,3],[1,2,1]]
Output: 17
Explanation: The image above describes the matrix after each query. The sum of the matrix after all queries are applied is 17.

 
Constraints:

1 <= n <= 10 ** 4
1 <= queries.length <= 5 * 10 ** 4
queries[i].length == 3
0 <= typei <= 1
0 <= indexi < n
0 <= vali <= 10 ** 5

 **/
class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        long sum = 0;
        long[] row = new long[n];
        long[] col = new long[n];
        boolean[] rowSet = new boolean[n];
        boolean[] colSet = new boolean[n];

        for (int[] query : queries) {
            int type = query[0];
            int index = query[1];
            int val = query[2];
            if (type == 0) {
                if (!rowSet[index]) {
                    rowSet[index] = true;
                    row[index] = val;
                    sum += ((long) val * n);
                } else {
                    sum -= ((long) row[index] * n);
                    row[index] = val;
                    sum += ((long) row[index] * n);
                }
                for (int i = 0; i < n; i++) {
                    if (colSet[i]) {
                        sum -= row[index];
                        sum += val;
                    }
                }
            } else {
                if (!colSet[index]) {
                    colSet[index] = true;
                    col[index] = val;
                    sum += ((long) val * n);
                } else {
                    sum -= ((long) col[index] * n);
                    col[index] = val;
                    sum += ((long) col[index] * n);
                }
                for (int i = 0; i < n; i++) {
                    if (rowSet[i]) {
                        sum -= col[index];
                        sum += val;
                    }
                }
            }
        }
        return sum;
    }
}