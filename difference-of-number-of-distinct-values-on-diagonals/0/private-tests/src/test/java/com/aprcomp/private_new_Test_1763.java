package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_1763 {
    @Test(timeout=5000)
    public void test_1763(){
        assertEquals(new int[][]{new int[]{1,1,1,0},new int[]{1,0,0,1},new int[]{0,1,1,1}}, new Solution().differenceOfDistinctValues(new int[][]{new int[]{1,1,1,1},new int[]{1,1,1,1},new int[]{1,1,1,1}}));
        }
}
