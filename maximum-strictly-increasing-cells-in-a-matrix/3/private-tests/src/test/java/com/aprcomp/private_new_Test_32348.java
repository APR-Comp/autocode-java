package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_32348 {
    @Test(timeout=5000)
    public void test_32348(){
        assertEquals(2, new Solution().maxIncreasingCells(new int[][]{new int[]{-6871,-10000,-10000},new int[]{-10000,-10000,-10000},new int[]{-10000,-10000,-10000}}));
        }
}
