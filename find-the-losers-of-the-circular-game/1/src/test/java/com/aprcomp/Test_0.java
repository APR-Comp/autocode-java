package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class Test_0 {
    @Test(timeout=5000)
    public void test_0(){
        assertArrayEquals( new int[]{4,5}, new Solution().circularGameLosers( 5, 2));
        }
}
