package com.aprcomp;
import java.util.*;
import org.junit.Test;
import static com.aprcomp.Solution.*;
import static org.junit.Assert.*;
public class Test_2 {
    @Test(timeout=5000)
    public void test_2(){
        assertArrayEquals( new int[]{2}, new Solution().circularGameLosers( 2, 2));
        }
}
