package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_211572 {
    @Test(timeout=5000)
    public void test_211572(){
        assertEquals(List.of(0,1), new Solution().goodSubsetofBinaryMatrix(new int[][]{new int[]{0,0,0},new int[]{0,0,1},new int[]{0,0,0}}));
        }
}
