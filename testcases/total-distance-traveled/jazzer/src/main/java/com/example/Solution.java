package com.example;

import java.util.Arrays;
import java.util.List;
class Solution {
    public int distanceTraveled(int a, int b) {
        return (a + Math.min((a - 1) / 4, b)) * 10;
    }
}
