package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] visited = new boolean[n+1];
        int current = 1;
        int step = 1;
        while (true) {
            visited[current] = true;
            int next = (current + step*k - 1) % n + 1;
            if (visited[next]) break;
            current = next;
            step++;
        }
        List<Integer> losers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) losers.add(i);
        }
        int[] res = new int[losers.size()];
        for (int i = 0; i < losers.size(); i++) {
            res[i] = losers.get(i);
        }
        return res;
    }
}