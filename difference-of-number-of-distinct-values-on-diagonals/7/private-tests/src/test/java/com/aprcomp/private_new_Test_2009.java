package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_2009 {
    @Test(timeout=5000)
    public void test_2009(){
        assertEquals(new int[][]{new int[]{0}}, new Solution().differenceOfDistinctValues(new int[][]{new int[]{1}}));
        }
}
