package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_3996 {
    @Test(timeout=5000)
    public void test_3996(){
        assertEquals(new int[][]{new int[]{2,2,2,2,1,0},new int[]{2,1,1,1,0,1},new int[]{2,1,1,1,0,1},new int[]{1,0,0,0,0,2},new int[]{1,0,1,0,0,1},new int[]{0,1,2,3,2,2}}, new Solution().differenceOfDistinctValues(new int[][]{new int[]{2,2,2,2,2,2},new int[]{2,2,2,2,2,2},new int[]{2,2,2,2,29,1},new int[]{1,1,2,2,2,2},new int[]{2,28,28,28,28,28},new int[]{28,28,28,28,28,28}}));
        }
}
