package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_163770 {
    @Test(timeout=5000)
    public void test_163770(){
        assertEquals(List.of(0,4), new Solution().goodSubsetofBinaryMatrix(new int[][]{new int[]{1},new int[]{1},new int[]{1},new int[]{1},new int[]{0},new int[]{0},new int[]{0},new int[]{0}}));
        }
}