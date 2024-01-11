package com.aprcomp;
import java.util.*;

class Solution {
    public long maximumSumOfHeights(List<Integer> v) {
        int n = v.size();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int[] he = new int[n];
            he[i] = v.get(i);
            int l = i - 1, h = i + 1;
            while (l >= 0) {
                if (v.get(l) <= he[l + 1])
                    he[l] = v.get(l);
                else
                    he[l] = he[l + 1];
                l--;
            }
            while (h < n) {
                if (v.get(h) <= he[h - 1])
                    he[h] = v.get(h);
                else
                    he[h] = he[h - 1];
                h++;
            }
            long s = 0;
            for (int value : he) {
                s += value;
            }
            ans = Math.max(ans, s);
        }
        return ans;
    }
}
