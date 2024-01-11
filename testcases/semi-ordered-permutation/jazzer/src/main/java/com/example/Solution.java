package com.example;

import java.util.Arrays;
import java.util.List;

class Solution {
    public int semiOrderedPermutation(int[] A) {
        int n = A.length, i = 0, j = 0;
        for (int k = 0; k < n; k++) {
            if (A[k] == 1) i = k;
            if (A[k] == A.length) j = k;
        }
        return i + n - 1 - j - (i > j ? 1 : 0);
    }
}