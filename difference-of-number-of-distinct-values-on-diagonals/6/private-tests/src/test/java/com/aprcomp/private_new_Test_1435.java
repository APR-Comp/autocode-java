package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_1435 {
    @Test(timeout=5000)
    public void test_1435(){
        assertEquals(new int[][]{new int[]{2,1,0},new int[]{1,0,1},new int[]{0,1,1}}, new Solution().differenceOfDistinctValues(new int[][]{new int[]{3,3,3},new int[]{3,3,3},new int[]{3,1,1}}));
        }
}
