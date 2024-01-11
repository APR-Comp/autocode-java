package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class private_new_Test_21619 {
    @Test(timeout=5000)
    public void test_21619(){
        assertArrayEquals(new int[]{2,3,4,6,7,9}, new Solution().circularGameLosers(10,39) );
        }
}
