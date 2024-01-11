package com.example;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public String smallestString(String s) {
        int i = 0, n = s.length();
        char[] A = s.toCharArray();
        while (i < n && A[i] == 'a')
            i++;
        if (i == n)
            A[n - 1] = 'z';
        while (i < n && A[i] != 'a')
            --A[i++];
        return String.valueOf(A);
    }
}
