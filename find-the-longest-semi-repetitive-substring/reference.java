package com.aprcomp;
import java.util.*;

public class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int i = 0, cur = 0, n = s.length();
        for (int j = 1; j < n; ++j) {
            cur += s.charAt(j) == s.charAt(j - 1) ? 1 : 0;
            if (cur > 1) {
                cur -= s.charAt(++i) == s.charAt(i - 1) ? 1 : 0;
            }
        }
        return n - i;
    }
}
