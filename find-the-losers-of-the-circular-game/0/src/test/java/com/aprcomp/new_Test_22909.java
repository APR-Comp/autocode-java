package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class new_Test_22909 {
    @Test(timeout=5000)
    public void test_22909(){
        assertArrayEquals(new int[]{2,4,5,6}, new Solution().circularGameLosers(6,14) );
        }
}
