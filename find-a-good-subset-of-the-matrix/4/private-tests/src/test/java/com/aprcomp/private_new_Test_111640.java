package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_111640 {
    @Test(timeout=5000)
    public void test_111640(){
        assertEquals(List.of(0,1), new Solution().goodSubsetofBinaryMatrix(new int[][]{new int[]{1,0,0},new int[]{0,0,0},new int[]{0,0,0}}));
        }
}
