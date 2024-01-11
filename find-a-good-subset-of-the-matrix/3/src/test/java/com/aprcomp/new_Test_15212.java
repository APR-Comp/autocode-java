package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_15212 {
    @Test(timeout=5000)
    public void test_15212(){
        assertEquals(List.of(0,2), new Solution().goodSubsetofBinaryMatrix(new int[][]{new int[]{1},new int[]{1},new int[]{0}}));
        }
}
