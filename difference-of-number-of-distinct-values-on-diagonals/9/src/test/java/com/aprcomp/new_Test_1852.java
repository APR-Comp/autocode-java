package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_1852 {
    @Test(timeout=5000)
    public void test_1852(){
        assertEquals(new int[][]{new int[]{2,2,2,2,1,0},new int[]{1,0,0,0,0,1},new int[]{1,0,1,1,1,2},new int[]{1,0,1,2,2,3},new int[]{1,0,0,1,2,3},new int[]{0,1,1,1,2,3}}, new Solution().differenceOfDistinctValues(new int[][]{new int[]{6,6,6,6,6,6},new int[]{6,49,8,39,4,1},new int[]{1,1,1,1,1,1},new int[]{1,1,1,1,1,1},new int[]{1,1,1,1,1,1},new int[]{1,1,1,1,1,1}}));
        }
}
