package com.aprcomp;
import java.util.*;

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = 0; // Since it's a binary array, we'll just assume the first value is 0
        for (int i = 0; i < n - 1; i++) {
            original[i + 1] = derived[i] ^ original[i];
        }
        // Now, check if the derived array can be generated from the original array
        int xorFirstAndLast = original[0] ^ original[n - 1];
        // The last element of the derived array should be equal to the XOR of the first and last elements of the original array
        return xorFirstAndLast == derived[n - 1];
    }
}