package com.example;

import java.util.Arrays;
import java.util.List;

class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        int rowSeenCount = 0, colSeenCount = 0;
        boolean[] rowSeen = new boolean[n];
        boolean[] colSeen = new boolean[n];
        long sum = 0;
        for (int qi = queries.length - 1; qi >= 0; qi--) {
            int type = queries[qi][0], index = queries[qi][1], val = queries[qi][2];
            if (type == 0 && !rowSeen[index]) {
                rowSeenCount++;
                rowSeen[index] = true;
                sum += (n - colSeenCount) * val;
            }
            if (type == 1 && !colSeen[index]) {
                colSeenCount++;
                colSeen[index] = true;
                sum += (n - rowSeenCount) * val;
            }
        }
        return sum;
    }
}