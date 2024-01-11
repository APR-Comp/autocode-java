package com.aprcomp;
import java.util.*;

class Solution {
    public int distanceTraveled(int a, int b) {
        return (a + Math.min((a - 1) / 4, b)) * 10;
    }
}
